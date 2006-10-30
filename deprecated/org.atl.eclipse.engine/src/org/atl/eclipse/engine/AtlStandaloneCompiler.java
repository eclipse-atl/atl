package org.atl.eclipse.engine;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.engine.repositories.emf4atl.ASMEMFModelElement;
import org.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.emf.ecore.EObject;

/**
 * The ATL compiler, refactored as a stand-alone class which does not depend on
 * the Eclipse core API.
 * 
 * @author JOUAULT (original version)
 * @author Matthias Bohlen (refactored to make it usable in Eclipse-less
 *         environments)
 * 
 */
public class AtlStandaloneCompiler {
	private static AtlStandaloneCompiler defaultCompiler = null;

	public static AtlStandaloneCompiler getDefault() {
		if (defaultCompiler == null) {
			defaultCompiler = new AtlStandaloneCompiler();
		}
		return defaultCompiler;
	}

	private URL ATLWFRurl = AtlCompiler.class
			.getResource("resources/ATL-WFR.asm");

	private AtlModelHandler amh;

	private ASMModel pbmm;

	private AtlStandaloneCompiler() {
		amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		pbmm = amh.getBuiltInMetaModel("Problem");
	}

	private Object[] getProblems(ASMModel problems, EObject prev[]) {
		Object ret[] = new Object[2];
		EObject pbsa[] = null;
		Collection pbs = problems.getElementsByType("Problem");

		int nbErrors = 0;
		if (pbs != null) {
			pbsa = new EObject[pbs.size() + prev.length];
			System.arraycopy(prev, 0, pbsa, 0, prev.length);
			int k = prev.length;
			for (Iterator i = pbs.iterator(); i.hasNext();) {
				ASMEMFModelElement ame = ((ASMEMFModelElement) i.next());
				pbsa[k++] = ame.getObject();
				if ("error".equals(((ASMEnumLiteral) ame.get(null, "severity"))
						.getName())) {
					nbErrors++;
				}
			}
		}

		ret[0] = new Integer(nbErrors);
		ret[1] = pbsa;

		return ret;
	}

	/**
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be
	 *            saved.
	 * @return A List of EObject instance of Problem.
	 */
	public EObject[] compile(InputStream in, String outputFileName) {
		EObject ret[] = null;
		// Parsing + Semantic Analysis
		ASMModel parsed[] = AtlParser.getDefault().parseToModelWithProblems(in);
		ASMModel atlmodel = parsed[0];
		ASMModel problems = parsed[1];

		Object a[] = getProblems(problems, new EObject[0]);
		int nbErrors = ((Integer) a[0]).intValue();
		ret = (EObject[]) a[1];

		if (nbErrors == 0) {
			Map models = new HashMap();
			models.put("MOF", amh.getMof());
			models.put("ATL", atlmodel.getMetamodel());
			models.put("IN", atlmodel);
			models.put("Problem", pbmm);
			models.put("OUT", problems);

			Map params = Collections.EMPTY_MAP;

			Map libs = Collections.EMPTY_MAP;

			AtlLauncher.getDefault().launch(ATLWFRurl, libs, models, params);

			a = getProblems(problems, ret);
			nbErrors = ((Integer) a[0]).intValue();
			ret = (EObject[]) a[1];
		}

		if (nbErrors == 0) {
			// Generating code
			URL atlsaurl = AtlCompiler.class
					.getResource("resources/ATLToASMCompiler.asm");

			Map models = new HashMap();
			models.put("MOF", amh.getMof());
			models.put("ATL", amh.getAtl());
			models.put("IN", atlmodel);

			Map params = new HashMap();
			params.put("debug", "false");
			params.put("WriteTo", outputFileName);

			Map libs = new HashMap();
			libs.put("typeencoding", AtlParser.class
					.getResource("resources/typeencoding.asm"));
			libs.put("strings", AtlParser.class
					.getResource("resources/strings.asm"));

			AtlLauncher.getDefault().launch(atlsaurl, libs, models, params);
		}

		return ret;
	}

}
