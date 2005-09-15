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

public class KM32MOF14 implements IObjectActionDelegate {

	private AtlModelHandler amh = null;

	private ISelection selection;

	private KM3Projector kp = KM3Projector.getKM3Projector();

	/**
	 * Constructor for Action1.
	 */
	public KM32MOF14() {
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
		if(amh == null) {
			amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_MDR);
		}
		try {
			IFile file = ((IFile)((IStructuredSelection)selection).getFirstElement());
			
			ASMModel mof = kp.getMOF14FromKM3File(file);

			if(mof != null) {
				String name = file.getFullPath().removeFirstSegments(1).toString();
				name = name.substring(0, name.length() - file.getFileExtension().length()) + "xmi";
				amh.saveModel(mof, name, file.getProject());
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
