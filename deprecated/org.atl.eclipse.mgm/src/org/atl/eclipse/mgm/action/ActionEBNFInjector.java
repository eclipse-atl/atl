/*
 * Created on 23 nov. 2004
 */
package org.atl.eclipse.mgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.engine.injectors.ebnf.EBNFInjector2;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

/**
 * This action executes EBNF injector
 * @author allilaire
 */
public class ActionEBNFInjector extends Action {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
	private IFile file;
	private EObject injector;
	private EObject metamodel;
	
	/**
	 * Constructor
	 */
	public ActionEBNFInjector(String text, IFile file, EObject injector, EObject metamodel) {
		super(text);
		this.file = file;
		this.injector = injector;
		this.metamodel = metamodel;
	}
	
	public void run() {
		
		ASMModel pbmm = amh.getBuiltInMetaModel("Problem");
		ASMModel pbs = amh.newModel("pbs", pbmm);
		
		try {
			InputStream in = file.getContents();
			File languageMetamodel = new File(MgmPlugin.getPluginRep() + MgmPlugin.getDefault().getHandler().get(metamodel, "uri"));
			ASMModel mm = amh.loadModel((String)MgmPlugin.getDefault().getHandler().get(metamodel, "name"), amh.getMof(), new FileInputStream(languageMetamodel));
			ASMModel model = amh.newModel(file.getName(), mm);
			Class lexer = MgmPlugin.getDefault().getLoader().loadClass2("org.atl.engine.injectors.ebnf." + MgmPlugin.getDefault().getHandler().get(injector, "classNamePrefix") + "Lexer", true);
			Class parser = MgmPlugin.getDefault().getLoader().loadClass2("org.atl.engine.injectors.ebnf." + MgmPlugin.getDefault().getHandler().get(injector, "classNamePrefix") + "Parser", true);
			EBNFInjector2 ebnfi = new EBNFInjector2();
			ebnfi.performImportation(mm, model, in, (String)MgmPlugin.getDefault().getHandler().get(injector, "classNamePrefix"), lexer, parser, pbs);
			
			if(model != null) {
				String name = file.getFullPath().removeFirstSegments(1).toString();
				name = name.substring(0, name.length() - 4) + "-" + MgmPlugin.getDefault().getHandler().get(metamodel, "name") + ".ecore";
				amh.saveModel(model, name, file.getProject());
			}
		}
		catch (CoreException e1) {
			System.err.println(e1);
		}
		catch (IOException e1) {
			System.err.println(e1);
		}
		catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

}