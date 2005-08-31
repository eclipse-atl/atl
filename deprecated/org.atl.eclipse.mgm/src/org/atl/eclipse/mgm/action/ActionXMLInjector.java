/*
 * Created on 24 nov. 2004
 */
package org.atl.eclipse.mgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.engine.injectors.xml.XMLInjector;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

/**
 * Action XML Injector
 * 		on an file with extension "xml"
 * @author allilaire
 */
public class ActionXMLInjector extends Action {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
	private IFile inFile;
	private String mmUri;
	private String mmName;

	/**
	 * Constructor call on External file "xml" use case
	 */
	public ActionXMLInjector(String text, IFile file, EObject metamodel) {
		super(text);
		this.inFile = file;
		mmUri = (String)MgmPlugin.getDefault().getHandler().get(metamodel, "uri");
		mmName = (String)MgmPlugin.getDefault().getHandler().get(metamodel, "name");
	}

	/**
	 * Main method for action
	 */
	public void run() {
		try {
			InputStream in = inFile.getContents();
			File languageMetamodel = new File(MgmPlugin.getPluginRep() + mmUri);
			ASMModel mm = amh.loadModel(mmName, amh.getMof(), new FileInputStream(languageMetamodel));
			ASMModel model = amh.newModel(inFile.getName(), mm);

			XMLInjector xmli = new XMLInjector();

			Map parameters = Collections.EMPTY_MAP;
			xmli.inject(model, in, parameters);
			
			if(model != null) {
				String name = inFile.getFullPath().removeFirstSegments(1).toString();
				name = name.substring(0, name.length() - 4) + "-" + mmName + ".ecore";
				amh.saveModel(model, name, inFile.getProject());
			}			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
}
