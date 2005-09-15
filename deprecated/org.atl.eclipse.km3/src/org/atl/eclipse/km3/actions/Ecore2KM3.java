package org.atl.eclipse.km3.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.km3.KM3Projector;
import org.atl.engine.vm.nativelib.ASMModel;
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

public class Ecore2KM3 implements IObjectActionDelegate {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);

	private ISelection selection;
	
	private KM3Projector kp = KM3Projector.getKM3Projector();

	/**
	 * Constructor for Action1.
	 */
	public Ecore2KM3() {
		super();
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
			IFile file = ((IFile)((IStructuredSelection)selection).getFirstElement());
			InputStream in = file.getContents();
			
			ASMModel model = amh.loadModel(file.getName(), amh.getMof(), in);

			String km3 = kp.getStringFromKM3(kp.getKM3FromEcore(model));
			
			String name = file.getName();
			name = name.substring(0, name.length() - file.getFileExtension().length()) + "km3";
			if(km3 != null) {
				IWorkspace wks = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot wksroot = wks.getRoot();
				IFile fileCreated = wksroot.getFile(file.getFullPath().removeLastSegments(1).append(name));
				InputStream stream = openContentStream(km3);
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
