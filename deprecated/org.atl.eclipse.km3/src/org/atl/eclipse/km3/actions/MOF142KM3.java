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

public class MOF142KM3 implements IObjectActionDelegate {
	
	private final static String pluginid = "org.atl.eclipse.km3";
	private final static String errorMsg = "An error was encountered while trying to get a KM3 file from a MOF-1.4 metamodel.";

	private AtlModelHandler amh = null;

	private ISelection selection;
	
	private KM3Projector kp = KM3Projector.getKM3Projector();

	/**
	 * Constructor for Action1.
	 */
	public MOF142KM3() {
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
		Job job = new Job("MOF-1.4 to KM3") {
			protected IStatus run(IProgressMonitor mon) {
				IStatus ret = null;
				mon.beginTask("MOF-1.4 to KM3", IProgressMonitor.UNKNOWN);

				if(amh == null) {
					mon.subTask("Initializing MDR");
					amh =  AtlModelHandler.getDefault("MDR");	// TODO: MDR string
				}
				try {
					mon.subTask("Loading MOF-1.4 metamodel");

					IFile file = ((IFile)((IStructuredSelection)selection).getFirstElement());
					InputStream in = file.getContents();
					
					ASMModel model = amh.loadModel(file.getName(), amh.getMof(), in);
		
					mon.subTask("Transforming MOF-1.4 metamodel into KM3 model");
					ASMModel km3model = kp.getKM3FromMOF14(model);

					mon.subTask("Serializing KM3 model");
					String km3 = kp.getStringFromKM3(km3model);
					
					String name = file.getName();
					name = name.substring(0, name.length() - file.getFileExtension().length()) + "km3";
					if(km3 != null) {
						mon.subTask("Writing KM3 file");
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
							ret = new Status(Status.OK, pluginid, Status.OK, file + " transformed into " + name, null);
						} catch (IOException e1) {
							ret = new Status(Status.ERROR, pluginid, Status.OK, errorMsg, e1);
						}
					} else {
						ret = new Status(Status.ERROR, pluginid, Status.OK, "Encountered an error while serializing KM3 model.", null);							
					}
				} catch (CoreException e) {
					ret = new Status(Status.ERROR, pluginid, Status.OK, errorMsg, e);
				}
				
				return ret;
			}
		};
		job.setPriority(Job.BUILD);
		job.schedule();
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
