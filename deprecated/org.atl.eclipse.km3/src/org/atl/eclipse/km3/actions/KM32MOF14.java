package org.atl.eclipse.km3.actions;

import java.io.IOException;

import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.km3.KM3Projector;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class KM32MOF14 implements IObjectActionDelegate {

	private final static String pluginid = "org.atl.eclipse.km3";
	private final static String errorMsg = "An error was encountered while trying to get a MOF-1.4 metamodel from a KM3 file.";

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
		Job job = new Job("KM3 to MOF-1.4") {
			protected IStatus run(IProgressMonitor mon) {
				IStatus ret = null;
				mon.beginTask("KM3 to MOF-1.4", IProgressMonitor.UNKNOWN);
				
				if(amh == null) {
					mon.subTask("Initializing MDR");
					amh = AtlModelHandler.getDefault("MDR");	// TODO: MDR string
				}
				try {
					IFile file = ((IFile)((IStructuredSelection)selection).getFirstElement());
					
					mon.subTask("Parsing and checking KM3 file");
					ASMModel km3model = kp.getEMFKM3FromFile(file);

					ASMModel mof = null;
					if(km3model != null) {
						mon.subTask("Transforming KM3 model into MOF-1.4 metamodel");
						mof = kp.getMOF14FromKM3File(file);
					}
		
					if(mof != null) {
						mon.subTask("Serializing MOF-1.4 metamodel");
						String name = file.getFullPath().removeFirstSegments(1).toString();
						name = name.substring(0, name.length() - file.getFileExtension().length()) + "xmi";
						amh.saveModel(mof, name, file.getProject());
						ret = new Status(Status.OK, pluginid, Status.OK, file + " transformed into " + name, null);
					} else {
						ret = new Status(Status.ERROR, pluginid, Status.OK, errorMsg, null);													
					}
				} catch (CoreException e) {
					ret = new Status(Status.ERROR, pluginid, Status.OK, errorMsg, e);
				} catch(IOException ioe) {
					ret = new Status(Status.ERROR, pluginid, Status.OK, errorMsg, ioe);
				}
				
				return ret;
			}
		};
		job.setPriority(Job.BUILD);
		job.schedule();		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
