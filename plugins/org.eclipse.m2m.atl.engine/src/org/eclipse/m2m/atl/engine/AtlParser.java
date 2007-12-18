/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.tcs.injector.TCSInjector;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

public class AtlParser {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
	private static AtlParser defaultParser = null;
	
	private AtlModelHandler amh;
	private ASMModel pbmm;
	
	private AtlParser() {
		amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		pbmm = amh.getBuiltInMetaModel("Problem"); //$NON-NLS-1$
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
			ret[0] = ASMEMFModel.newASMEMFModel("temp", "temp", (ASMEMFModel)atlmm, null); //$NON-NLS-1$ //$NON-NLS-2$
			ret[1] = amh.newModel("pb", "pb", pbmm); //$NON-NLS-1$ //$NON-NLS-2$
			
			TCSInjector ebnfi = new TCSInjector();
			Map params = new HashMap();
			params.put("name", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
			params.put("problems", ret[1]); //$NON-NLS-1$
			ebnfi.inject(ret[0], in, params);
			//ebnfi.performImportation(atlmm, ret[0], in, "ATL", ATLLexer.class, ATLParser.class, ret[1]);

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
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
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
			Collection modules = atlmodel.getElementsByType("Unit"); //$NON-NLS-1$
			if(modules.size() > 0) {
				retUnit = ((ASMEMFModelElement)modules.iterator().next()).getObject();
			}
			pbs = problems.getElementsByType("Problem"); //$NON-NLS-1$
		} else {
			Object o = atlmodel.getElementsByType("Unit"); //$NON-NLS-1$
			logger.info(o.toString());
//			System.out.println(o);
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
