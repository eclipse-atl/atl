package org.eclipse.m2m.atl.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import org.atl.engine.injectors.ebnf.ATLLexer;
import org.atl.engine.injectors.ebnf.ATLParser;
import org.atl.engine.injectors.ebnf.EBNFInjector2;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

public class AtlParser {
	
	private static AtlParser defaultParser = null;
	
	private AtlModelHandler amh;
	private ASMModel pbmm;
	
	private AtlParser() {
		amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		pbmm = amh.getBuiltInMetaModel("Problem");
	}
	
	public static AtlParser getDefault() {
		if(defaultParser == null) {
			defaultParser = new AtlParser();
		}
		return defaultParser;
	}
	
	public ASMModel parseToModel(InputStream in) {
		return parseToModelWithProblems(in)[0];
	}

	public ASMModel[] parseToModelWithProblems(InputStream in) {
		ASMModel ret[] = new ASMModel[2];
		ASMModel atlmm = amh.getAtl();
//		ASMModel mofmm = amh.getMof();

		try {
			ret[0] = ASMEMFModel.newASMEMFModel("temp", (ASMEMFModel)atlmm, null);
			ret[1] = amh.newModel("pb", pbmm);
			
			EBNFInjector2 ebnfi = new EBNFInjector2();
			ebnfi.performImportation(atlmm, ret[0], in, "ATL", ATLLexer.class, ATLParser.class, ret[1]);

			// Semantic Analysis
/*
			URL atlsaurl = AtlParser.class.getResource("resources/ATLSemanticAnalyzer.asm");

			Map models = new HashMap();
			models.put("MOF", amh.getMof());
			models.put("ATL", amh.getAtl());
			models.put("IN", ret[0]);

			Map params = new HashMap();
			params.put("debug", "false");

			AtlLauncher.getDefault().launch(atlsaurl, models, params);
*/
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	public EObject parse(InputStream in) {
		return parseWithProblems(in)[0];
	}
	
	/**
	 * 
	 * @param in InputStream to parse ATL code from.
	 * @return An array of EObject, the first one being an ATL!Unit and
	 * 			the following ones Problem!Problem.
	 */
	public EObject[] parseWithProblems(InputStream in) {
		EObject ret[] = null;
		EObject retUnit = null;
		Collection pbs = null;
		
		ASMModel parsed[] = parseToModelWithProblems(in);
		ASMModel atlmodel = parsed[0];
		ASMModel problems = parsed[1];
		if(atlmodel instanceof ASMEMFModel) {
			Collection modules = atlmodel.getElementsByType("Unit");
			if(modules.size() > 0) {
				retUnit = ((ASMEMFModelElement)modules.iterator().next()).getObject();
			}
			pbs = problems.getElementsByType("Problem");
		} else {
			Object o = atlmodel.getElementsByType("Unit");
			System.out.println(o);
		}
		
		if(pbs != null) {
			ret = new EObject[1 + pbs.size()];
			int k = 1;
			for(Iterator i = pbs.iterator() ; i.hasNext() ; ) {
				ret[k++] = ((ASMEMFModelElement)i.next()).getObject();
			}
		} else {
			ret = new EObject[1];
		}
		ret[0] = retUnit;
		
		return ret;
	}
}
