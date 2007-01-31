package org.atl.eclipse.km3.actions;

import java.io.IOException;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.km3.KM3Projector;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class KM3MDRInjector implements IObjectActionDelegate {

	private AtlModelHandler amh = AtlModelHandler.getDefault("MDR");

	private ISelection selection;

	private KM3Projector kp = KM3Projector.getKM3Projector();

	/**
	 * Constructor for Action1.
	 */
	public KM3MDRInjector() {
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
			
			ASMModel emf = kp.getMDRKM3FromFile(file);
			
			if(emf != null) {
				String name = file.getFullPath().removeFirstSegments(1).toString();
				name = name.substring(0, name.length() - 4) + "-KM3.xmi";
				amh.saveModel(emf, name, file.getProject());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
