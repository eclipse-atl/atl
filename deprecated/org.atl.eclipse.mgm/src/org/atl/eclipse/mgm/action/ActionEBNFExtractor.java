/*
 * Created on 12 juil. 2005
 */
package org.atl.eclipse.mgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.engine.extractors.ebnf.EBNFExtractor;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

/**
 * This action executes EBNF extractor
 * @author allilaire
 */
public class ActionEBNFExtractor extends Action {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);

	private String mmUri;
	private String mmName;
	private String extension;
	private IFile inFile;
	private EObject tcs;
	
	/**
	 * Constructor
	 */
	public ActionEBNFExtractor(String text, IFile file, EObject metamodel, EObject extractor, EObject tcs) {
		super(text);
		this.inFile = file;
		mmUri = (String)MgmPlugin.getDefault().getHandler().get(metamodel, "uri");
		mmName = (String)MgmPlugin.getDefault().getHandler().get(metamodel, "name");
		extension = (String)MgmPlugin.getDefault().getHandler().get(extractor, "extension");
		this.tcs = tcs;
	}
	
	public void run() {
		try {
			File languageMetamodel = new File(MgmPlugin.getPluginRep() + mmUri);
			ASMModel mm = amh.loadModel(mmName, amh.getMof(), new FileInputStream(languageMetamodel));
			final ASMModel model = amh.loadModel(inFile.getName(), mm, inFile.getContents());
						
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			
			Map tempParam = new HashMap();
			
			Set metamodels = MgmPlugin.getDefault().getHandler().getElementsByType("Metamodel");
			for (Iterator it = metamodels.iterator(); it.hasNext();) {
				EObject currentMetamodel = (EObject) it.next();
				if (MgmPlugin.getDefault().getHandler().get(currentMetamodel, "name").equals("TCS")) {
					File fileMMTCS = new File(MgmPlugin.getPluginRep() + MgmPlugin.getDefault().getHandler().get(currentMetamodel, "uri"));
					File fileTCS = new File(MgmPlugin.getPluginRep() + MgmPlugin.getDefault().getHandler().get(tcs, "uri"));
					ASMModel mmTCS = amh.loadModel("TCS", amh.getMof(), new FileInputStream(fileMMTCS));
					ASMModel modelTCS = amh.loadModel((String)MgmPlugin.getDefault().getHandler().get(tcs, "name"), mmTCS, new FileInputStream(fileTCS));
					tempParam.put("format", modelTCS);
				}
			}
			final Map parameters = tempParam;
			
			final EBNFExtractor ebnfe = new EBNFExtractor();
			
			String name = inFile.getName();
			name = name.substring(0, name.length() - inFile.getFileExtension().length()) + extension;

			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();
			IFile file = wksroot.getFile(inFile.getFullPath().removeLastSegments(1).append(name));
			
			new Thread() {
				public void run() {
					try {
						ebnfe.extract(model, out, parameters);
					} catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch(IOException ioe) {
							
						}
					}
				}
			}.start();
			if(file.exists())
				file.setContents(in, IFile.FORCE, null);
			else
				file.create(in, IFile.FORCE, null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
}
