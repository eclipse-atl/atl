/*
 * Created on 25 nov. 2004
 */
package org.atl.eclipse.mgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;
import java.util.Map;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.engine.extractors.xml.XMLExtractor;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;

/**
 * Launch XML Extractor
 * @author allilaire
 */
public class ActionXMLExtractor extends Action {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);

	private String mmUri;
	private String mmName;
	private IFile inFile;
	
	public ActionXMLExtractor(String text, IFile file, EObject element) {
		super(text);
		this.inFile = file;
		mmUri = (String)MgmPlugin.getDefault().getHandler().get(element, "uri");
		mmName = (String)MgmPlugin.getDefault().getHandler().get(element, "name");
	}
	
	public void run() {
		try {
			File languageMetamodel = new File(MgmPlugin.getPluginRep() + mmUri);
			ASMModel mm = amh.loadModel(mmName, amh.getMof(), new FileInputStream(languageMetamodel));
			final ASMModel model = amh.loadModel(inFile.getName(), mm, inFile.getContents());

			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			
			final Map parameters = Collections.EMPTY_MAP;

			final XMLExtractor xmle = new XMLExtractor();
			
			String name = inFile.getName();
			name = name.substring(0, name.length() - inFile.getFileExtension().length()) + "xml";

			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();
			IFile file = wksroot.getFile(inFile.getFullPath().removeLastSegments(1).append(name));

			new Thread() {
				public void run() {
					try {
						xmle.extract(model, out, parameters);
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
