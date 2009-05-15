/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.launch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ui.ATLCoreUIPlugin;
import org.eclipse.m2m.atl.core.ui.Messages;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * ATL Launch Shortcut.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLLaunchShortcut implements ILaunchShortcut {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.jface.viewers.ISelection,
	 *      java.lang.String)
	 */
	public void launch(ISelection selection, String mode) {
		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		IFile file = (IFile)structuredSelection.getFirstElement();
		launch(file, mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.ui.IEditorPart, java.lang.String)
	 */
	public void launch(IEditorPart editor, String mode) {
		IFile file = ((IFileEditorInput)editor.getEditorInput()).getFile();
		launch(file, mode);
	}

	/**
	 * Launches a configuration from ATL file.
	 * 
	 * @param file
	 *            the file
	 * @param mode
	 *            the launch mode
	 */
	protected void launch(IFile file, String mode) {
		List<ILaunchConfiguration> availableConfigurations = new ArrayList<ILaunchConfiguration>();
		try {
			ILaunchConfiguration[] configurations = getLaunchManager().getLaunchConfigurations(
					getConfigurationType());
			for (ILaunchConfiguration launchConfiguration : configurations) {
				String moduleName = launchConfiguration.getAttribute(ATLLaunchConstants.ATL_FILE_NAME, ""); //$NON-NLS-1$
				if (moduleName.endsWith(".atl")) { //$NON-NLS-1$
					if (file.getFullPath().toString().equals(moduleName)) {
						availableConfigurations.add(launchConfiguration);
					}					
				} else if (moduleName.endsWith(".asm")) { //$NON-NLS-1$
					moduleName = moduleName.substring(0, moduleName.length() - 4) + ".atl"; //$NON-NLS-1$
					if (file.getFullPath().toString().equals(moduleName)) {
						availableConfigurations.add(launchConfiguration);
					}
				}
			}
			if (availableConfigurations.size() == 1) {
				DebugUITools.launch(availableConfigurations.get(0), mode);
				return;
			} else if (!availableConfigurations.isEmpty()) {
				ILaunchConfiguration configuration = chooseConfiguration(availableConfigurations);
				if (configuration != null) {
					DebugUITools.launch(configuration, mode);
				}
				return;
			} else if (isLaunchable(file)) {
				ILaunchConfigurationWorkingCopy configuration = createConfiguration(file);
				ILaunchGroup group = DebugUITools.getLaunchGroup(configuration, mode);
				if (DebugUITools.openLaunchConfigurationDialog(ATLCoreUIPlugin.getDefault().getShell(),
						configuration, group.getIdentifier(), Status.OK_STATUS) != Window.CANCEL) {
					configuration.doSave();
				}
			}
		} catch (CoreException e) {
			MessageDialog.openError(ATLCoreUIPlugin.getDefault().getShell(), Messages
					.getString("ATLLaunchShortcut.LAUNCH_ERROR"), e.getMessage()); //$NON-NLS-1$
		}
	}

	private boolean isLaunchable(IFile file) throws CoreException {
		try {
			AtlSourceManager sourceManager = new AtlSourceManager();
			sourceManager.updateDataSource(file.getContents());
			int atlFileType = sourceManager.getATLFileType();
			return atlFileType == AtlSourceManager.ATL_FILE_TYPE_MODULE
					|| atlFileType == AtlSourceManager.ATL_FILE_TYPE_QUERY;
		} catch (IOException e) {
			// do nothing
		}
		return false;
	}

	/**
	 * Returns a configuration from the given collection of configurations that should be launched, or
	 * <code>null</code> to cancel. Default implementation opens a selection dialog that allows the user to
	 * choose one of the specified launch configurations. Returns the chosen configuration, or
	 * <code>null</code> if the user cancels.
	 * 
	 * @param configList
	 *            list of configurations to choose from
	 * @return configuration to launch or <code>null</code> to cancel
	 */
	protected ILaunchConfiguration chooseConfiguration(List<ILaunchConfiguration> configList) {
		IDebugModelPresentation labelProvider = DebugUITools.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(ATLCoreUIPlugin.getDefault()
				.getShell(), labelProvider);
		dialog.setElements(configList.toArray());
		dialog.setTitle(Messages.getString("ATLLaunchShortcut.SELECT_TRANSFO")); //$NON-NLS-1$
		dialog.setMessage(Messages.getString("ATLLaunchShortcut.SELECT_EXISTING")); //$NON-NLS-1$
		dialog.setMultipleSelection(false);
		int result = dialog.open();
		labelProvider.dispose();
		if (result == Window.OK) {
			return (ILaunchConfiguration)dialog.getFirstResult();
		}
		return null;
	}

	private ILaunchConfigurationWorkingCopy createConfiguration(IFile file) throws CoreException {
		String name = getLaunchManager().generateUniqueLaunchConfigurationNameFrom(
				getModuleNameFromFile(file));
		ILaunchConfigurationWorkingCopy wc = getConfigurationType().newInstance(null, name);
		wc.setAttribute(ATLLaunchConstants.ATL_FILE_NAME, file.getFullPath().toString());
		return wc;
	}

	/**
	 * Returns the default module name.
	 * 
	 * @param file
	 *            the file name
	 * @return the default module name
	 */
	public String getModuleNameFromFile(IFile file) {
		String fileName = file.getName();
		if (fileName.endsWith(".atl")) { //$NON-NLS-1$
			fileName = fileName.substring(0, fileName.length() - 4);
		}
		return fileName;
	}

	protected ILaunchConfigurationType getConfigurationType() {
		return getLaunchManager().getLaunchConfigurationType(ATLLaunchConstants.LAUNCH_CONFIGURATION_TYPE);
	}

	/**
	 * Returns the singleton launch manager.
	 * 
	 * @return launch manager
	 */
	private ILaunchManager getLaunchManager() {
		return DebugPlugin.getDefault().getLaunchManager();
	}

}
