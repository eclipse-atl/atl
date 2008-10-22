/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.debug.AtlDebugMessages;
import org.eclipse.m2m.atl.adt.debug.AtlDebugPlugin;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * ATL launching configuration utility.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public final class AtlLauncherTools {

	/** ATL VM name. */
	public static final String ATLVM = "ATL VM"; //$NON-NLS-1$

	/** ATL File Name. */
	public static final String ATLFILENAME = "ATL File Name"; //$NON-NLS-1$

	/** Allow intermodel references parameter (boolean). */
	public static final String ALLOWINTERMODELREFERENCES = "AllowInterModelReferences"; //$NON-NLS-1$

	/** Project name. */
	public static final String PROJECTNAME = "Project Name"; //$NON-NLS-1$

	/** Output models. */
	public static final String OUTPUT = "Output"; //$NON-NLS-1$

	/** Input models. */
	public static final String INPUT = "Input"; //$NON-NLS-1$

	/** Null parameter. */
	public static final String NULLPARAMETER = "<null>"; //$NON-NLS-1$

	/** Path map. */
	public static final String PATH = "Path"; //$NON-NLS-1$

	/** Debug host. */
	public static final String HOST = "Host"; //$NON-NLS-1$

	/** Debug port. */
	public static final String PORT = "Port"; //$NON-NLS-1$

	/** Libraries map. */
	public static final String LIBS = "Libs"; //$NON-NLS-1$

	/** Output model. */
	public static final String MODEL_OUTPUT = "MODELOUTPUT"; //$NON-NLS-1$

	/** Input model. */
	public static final String MODEL_INPUT = "MODELINPUT"; //$NON-NLS-1$

	/** Output metamodel. */
	public static final String METAMODEL_OUTPUT = "METAMODELOUTPUT"; //$NON-NLS-1$

	/** Input metamodel. */
	public static final String METAMODEL_INPUT = "METAMODELINPUT"; //$NON-NLS-1$

	/** Superimposed modules. */
	public static final String SUPERIMPOSE = "Superimpose"; //$NON-NLS-1$

	/** Model type. */
	public static final String MODELTYPE = "ModelType"; //$NON-NLS-1$

	/** Injector. */
	public static final String INJECTOR = "Injector"; //$NON-NLS-1$

	/** Extractor. */
	public static final String EXTRACTOR = "Extractor"; //$NON-NLS-1$

	/** Model handler. */
	public static final String MODELHANDLER = "Model Handler"; //$NON-NLS-1$

	/** Debug mode. */
	public static final String MODEDEBUG = "Mode Debug"; //$NON-NLS-1$

	/** Model choice tab. */
	public static final String MODELCHOICETABNAME = AtlDebugMessages
			.getString("AtlLauncherTools.MODELCHOICE"); //$NON-NLS-1$

	/** Advanced tab. */
	public static final String ADVANCEDTABNAME = AtlDebugMessages.getString("AtlLauncherTools.ADVANCED"); //$NON-NLS-1$

	/** Remote tab. */
	public static final String REMOTEATLNAME = AtlDebugMessages
			.getString("AtlLauncherTools.ATLCONFIGURATION"); //$NON-NLS-1$

	/** ATL icon path. */
	public static final String PATHICONATL = "icons/atllogo_icon.gif"; //$NON-NLS-1$

	/** Continue execution after error. */
	public static final String OPTION_CONTINUE_AFTER_ERROR = "continueAfterError"; //$NON-NLS-1$

	/** Disable/enable attribute cache. */
	public static final String OPTION_DISABLE_ATTRIBUTE_HELPER_CACHE = "disableAttributeHelperCache"; //$NON-NLS-1$

	/** Allow target navigation. */
	public static final String OPTION_ALLOW_TARGET_NAVIGATION = "allowTargetNavigation"; //$NON-NLS-1$

	/** Allow source modification. */
	public static final String OPTION_ALLOW_SOURCE_MODIFICATION = "allowSourceModification"; //$NON-NLS-1$

	/** Allow container reassignement. */
	public static final String OPTION_ALLOW_CONTAINER_REASSIGNMENT = "allowContainerReassignment"; //$NON-NLS-1$

	/** Display execution time. */
	public static final String OPTION_PRINT_EXECUTION_TIME = "printExecutionTime"; //$NON-NLS-1$

	/** Step. */
	public static final String OPTION_STEP = "step"; //$NON-NLS-1$

	/** Show summary. */
	public static final String OPTION_SHOW_SUMMARY = "showSummary"; //$NON-NLS-1$

	/** Performances measures. */
	public static final String OPTION_PROFILE = "profile"; //$NON-NLS-1$

	/** Parameters ids. */
	public static final String[] ADDITIONAL_PARAM_IDS = new String[] {
			OPTION_CONTINUE_AFTER_ERROR, OPTION_DISABLE_ATTRIBUTE_HELPER_CACHE, OPTION_PRINT_EXECUTION_TIME,
			OPTION_STEP, OPTION_SHOW_SUMMARY, OPTION_PROFILE,};

	/** Parameters labels.*/
	public static final String[] ADDITIONAL_PARAM_LABELS = new String[] {
	// "Allow navigation in target models",
			// "Allow modification of source models",
			// "Allow container reassignment",
			AtlDebugMessages.getString("AtlLauncherTools.0"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.1"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.2"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.3"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.4"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.5"), //$NON-NLS-1$
			AtlDebugMessages.getString("AtlLauncherTools.6"), //$NON-NLS-1$
	};

	private static String[] modelHandlersNames;

	private static int emfKey = -1;

	/** ATL extensions. */
	private static List extensions = new ArrayList();
	static {
		extensions.add("atl"); //$NON-NLS-1$
		extensions.add("acg"); //$NON-NLS-1$
	}

	private AtlLauncherTools() {
	}

	public static List getExtensions() {
		return extensions;
	}

	/**
	 * Returns the model handlers names.
	 * 
	 * @return the model handlers names
	 */
	public static String[] getModelHandlers() {
		if (modelHandlersNames == null) {
			modelHandlersNames = AtlModelHandler.getModelHandlers();
			for (int i = 0; i < modelHandlersNames.length; i++) {
				if (modelHandlersNames[i].equals(AtlEMFModelHandler.ID)) {
					emfKey = i;
				}
			}
		}
		return modelHandlersNames;
	}

	/**
	 * Returns the EMF key.
	 * 
	 * @return the EMF key
	 */
	public static int getEMFKey() {
		if (emfKey == -1) {
			getModelHandlers();
		}
		return emfKey;
	}

	/**
	 * Creates the form data.
	 * 
	 * @param left
	 *            the left parameter
	 * @param right
	 *            the right parameter
	 * @param top
	 *            the top parameter
	 * @param bottom
	 *            the bottom parameter
	 * @return A form data corresponding to the parameters
	 */
	public static FormData createFormData(int left, int right, int top, int bottom) {
		FormData formData = new FormData();
		formData.left = new FormAttachment(left, 100, 0);
		formData.right = new FormAttachment(right, 100, 0);
		formData.top = new FormAttachment(top, 100, 0);
		formData.bottom = new FormAttachment(bottom, 100, 0);

		return formData;
	}

	/**
	 * Display a message box with the text in parameter.
	 * 
	 * @param textToDisplay
	 *            the message
	 */
	public static void messageBox(String textToDisplay) {
		MessageBox msgBox = new MessageBox(new Shell(), SWT.APPLICATION_MODAL | SWT.OK);
		msgBox.setText(AtlDebugMessages.getString("AtlLauncherTools.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(textToDisplay);
		msgBox.open();
	}

	/**
	 * This method returns an image from the path.
	 * 
	 * @param path
	 *            the image path
	 * @return the created image
	 */
	public static Image createImage(String path) {
		try {
			URL baseUrl = AtlDebugPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
			URL url = new URL(baseUrl, path);
			return ImageDescriptor.createFromURL(url).createImage();
		} catch (MalformedURLException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return null;
	}

	/**
	 * Returns An array of string corresponding to the name of open projects.
	 * 
	 * @return An array of string corresponding to the name of open projects
	 */
	public static String[] projectNames() {
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		IProject[] myTab = wksroot.getProjects();

		if (myTab != null && myTab.length > 0) {
			List projectNames = new ArrayList();
			for (int i = 0; i < myTab.length; i++) {
				if (myTab[i].isOpen()) {
					projectNames.add(myTab[i].getName());
				}
			}
			return (String[])projectNames.toArray(new String[] {});
		}
		return new String[] {};
	}

	/**
	 * This function returns all the files in open projects with a good extension See function
	 * isGoodExtension.
	 * 
	 * @param projectName
	 *            the project name
	 * @return An array of string to display corresponding to the file
	 */
	public static String[] fileNames(String projectName) {
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();
		final Vector fileList = new Vector();

		IProject currentProject;
		if (projectName != null && !(projectName.equals(""))) { //$NON-NLS-1$
			currentProject = wksroot.getProject(projectName);
		} else {
			return new String[] {};
		}

		if (currentProject == null) {
			return new String[] {};
		}

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
			ATLLogger.warning(e.getMessage());
		}

		String[] fileNames = new String[fileList.size()];
		for (int k = 0; k < fileNames.length; k++) {
			fileNames[k] = (String)fileList.get(k);
		}
		return fileNames;
	}

	/**
	 * Returns true if the extension is good.
	 * 
	 * @param extension
	 *            the file extension
	 * @return true if the extension is good
	 */
	public static boolean isGoodExtension(String extension) {
		if (extensions.contains(extension.toLowerCase())) {
			return true;
		}
		return false;
	}
}
