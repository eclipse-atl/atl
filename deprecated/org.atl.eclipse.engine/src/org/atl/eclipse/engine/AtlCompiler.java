/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.engine.repositories.emf4atl.ASMEMFModelElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.mda.asm.nativeimpl.ASMModel;

/**
 * @author JOUAULT
 *
 */
public class AtlCompiler {
	
	private static AtlCompiler defaultCompiler = null;
	
	public static AtlCompiler getDefault() {
		if(defaultCompiler == null) {
			defaultCompiler = new AtlCompiler();
		}
		return defaultCompiler;
	}
	
	private AtlCompiler() {
		
	}
	
	/**
	 * 
	 * @param in The InputStream to get atl source from.
	 * @param out The IFile to which the ATL compiled program will be saved.
	 * @return A List of EObject instance of Problem. 
	 */
	public EObject[] compile(InputStream in, IFile out) {
		EObject ret[] = null;
		// Parsing + Semantic Analysis
		ASMModel parsed[] = AtlParser.getDefault().parseToModelWithProblems(in);
		ASMModel atlmodel = parsed[0];
		ASMModel problems = parsed[1];
		
		// Generating code
		URL atlsaurl = AtlCompiler.class.getResource("resources/ATLToASMCompiler.asm");

		AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		Map models = new HashMap();
		models.put("MOF", amh.getMof());
		models.put("ATL", amh.getAtl());
		models.put("IN", atlmodel);

		Map params = new HashMap();
		params.put("debug", "false");
		params.put("WriteTo", out.getLocation().toString());
		
		Map libs = new HashMap();
		libs.put("typeencoding", AtlParser.class.getResource("resources/typeencoding.asm"));
		libs.put("strings", AtlParser.class.getResource("resources/strings.asm"));

		AtlLauncher.getDefault().launch(atlsaurl, libs, models, params);
		
		try {
			out.refreshLocal(0, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		Collection pbs = (Collection)problems.getElementsByType("Problem");
	
		if(pbs != null) {
			ret = new EObject[pbs.size()];
			int k = 0;
			for(Iterator i = pbs.iterator() ; i.hasNext() ; ) {
				ret[k++] = ((ASMEMFModelElement)i.next()).getObject();
			}
		}
		
		return ret;
	}
}
