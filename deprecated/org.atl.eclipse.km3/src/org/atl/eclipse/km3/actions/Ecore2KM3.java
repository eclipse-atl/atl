package org.atl.eclipse.km3.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.mda.asm.nativeimpl.ASMModel;
import org.mda.asm.nativeimpl.ASMString;

public class Ecore2KM3 implements IObjectActionDelegate {

	private ISelection selection;
	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
	private ASMModel mm;
	private String mmName = "KM3";

	/**
	 * Constructor for Action1.
	 */
	public Ecore2KM3() {
		super();

		URL mmurl = Ecore2KM3.class.getResource("resources/" + mmName + ".ecore");
		try {
			mm = amh.loadModel(mmName, amh.getMof(), mmurl.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			File file = ((File)((IStructuredSelection)selection).getFirstElement());
			InputStream in = file.getContents();
			
			ASMModel model = amh.loadModel(file.getName(), amh.getMof(), in);
			// Transformation
			final URL KM32EMFurl = Ecore2KM3.class.getResource("resources/EMF2KM3.asm");
			final URL KM3_serializerurl = Ecore2KM3.class.getResource("resources/KM3-serializer.asm");
			
			final Map models = new HashMap();
			models.put("MOF", amh.getMof());
			models.put("IN", model);
			models.put("KM3", mm);
			ASMModel km3 = amh.newModel("OUT", mm);
			models.put("OUT", km3);
			
			
//			new Thread() {
//				public void run() {

					Map params = Collections.EMPTY_MAP;
					
					Map libs = Collections.EMPTY_MAP;

					AtlLauncher.getDefault().launch(KM32EMFurl, libs, models, params
//
//							, new NetworkDebugger(1234, true)
//
					);
					ASMString s = (ASMString)AtlLauncher.getDefault().launch(KM3_serializerurl, libs, models, params
//
//							 , new NetworkDebugger(1234, true)
//
					);
//	
// 				}
//			}.start();
//
					
			String name = file.getName();
			name = name.substring(0, name.length() - file.getFileExtension().length()) + "km3";
			if(s != null) {
				IWorkspace wks = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot wksroot = wks.getRoot();
				IFile fileCreated = wksroot.getFile(file.getFullPath().removeLastSegments(1).append(name));
				InputStream stream = openContentStream(s.getSymbol());
				if (fileCreated.exists()) {
					fileCreated.setContents(stream, true, true, null);
				} else {
					fileCreated.create(stream, true, null);
				}
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method transforms string into inputstream
	 * @param contents content of the file to cast in InputStream
	 * @return the InputStream content
	 */
	private InputStream openContentStream(String contents) {
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
