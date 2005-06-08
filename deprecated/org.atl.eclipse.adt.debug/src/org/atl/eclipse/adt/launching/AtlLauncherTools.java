/*
 * Created on 16 juin 2004
 */
package org.atl.eclipse.adt.launching;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.atl.eclipse.adt.debug.AtlDebugPlugin;
import org.atl.eclipse.adt.debug.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * @author allilaire
 */
public class AtlLauncherTools {

	public static String ATLFILENAME = "ATL File Name";
	public static String PROJECTNAME = "Project Name";
	public static String OUTPUT = "Output";
	public static String INPUT = "Input";
	public static String NULLPARAMETER = "<null>";
	public static String PATH = "Path";
	public static String HOST = "Host";
	public static String PORT = "Port";
	public static String LIBS = "Libs";
	public static String MODELTYPE = "ModelType";
	public static String INJECTOR = "Injector";
	public static String EXTRACTOR = "Extractor";
	public static String MODELHANDLER = "Model Handler";
	public static String MODEDEBUG = "Mode Debug";
	public static String EXTENSION = "atl";
	public static String MODELCHOICETABNAME = Messages.getString("AtlLauncherTools.MODELCHOICE"); //$NON-NLS-1$
	public static String REMOTEATLNAME = Messages.getString("AtlLauncherTools.ATLCONFIGURATION"); //$NON-NLS-1$
	public static String PATHICONATL = "icons/atllogo_icon.gif";
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 * @return A form data corresponding to the parameters
	 */
	public static FormData createFormData(int left, int right, int top, int bottom) {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(left, 100, 0);
		formData.right =  new FormAttachment(right, 100, 0);
		formData.top =  new FormAttachment(top, 100, 0);
		formData.bottom =  new FormAttachment(bottom, 100, 0);
		
		return formData;
	}
	
	/**
	 * Display a message box with the text in parameter
	 * @param textToDisplay
	 */
	public static void messageBox(String textToDisplay) {
		MessageBox msgBox = new MessageBox(new Shell(),	SWT.APPLICATION_MODAL | SWT.OK);
		msgBox.setText(Messages.getString("AtlLauncherTools.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(textToDisplay);
		msgBox.open();
	}
	
	/**
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	public static Image createImage(String path) {
		try {
			URL BASE_URL = AtlDebugPlugin.getDefault().getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
	
	/**
	 * 
	 * @return An array of string corresponding to the name of open projects
	 */
	public static String[] projectNames() {
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		IProject myTab[] = wksroot.getProjects();
		
		if (myTab != null && myTab.length > 0) {
			List projectNames = new ArrayList();
			for (int i=0; i < myTab.length; i++)
				if (myTab[i].isOpen())
					projectNames.add(myTab[i].getName());

			return (String[])projectNames.toArray(new String[] {});
		}
		return new String[]{};
	}
	
	/**
	 * This function returns all the files in open projects with a good extension
	 * See function isGoodExtension
	 * @return An array of string to display corresponding to the file
	 */
	public static String[] fileNames(String projectName) {
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();
		final Vector fileList = new Vector();

		IProject currentProject;
		if (projectName != null && !(projectName.equals("")))
			currentProject = wksroot.getProject(projectName);
		else
			return new String[]{};
		
		if (currentProject == null)
			return new String[]{};
		
		try {
			currentProject.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						String extension = ((IFile)resource).getFileExtension();
						if (extension != null && isGoodExtension(extension)) {
							fileList.add(((IFile)resource).getFullPath().toString());
						}
					}
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		String fileNames[] = new String[fileList.size()];
		for (int k=0; k < fileNames.length; k++)
			fileNames[k] = (String)fileList.get(k);
		return fileNames;
	}
	
	/**
	 * 
	 * @param extension
	 * @return true if the extension is good
	 */
	public static boolean isGoodExtension(String extension) {
		if (extension.toLowerCase().equals(EXTENSION.toLowerCase()))
			return true;
		return false;
	}
}
