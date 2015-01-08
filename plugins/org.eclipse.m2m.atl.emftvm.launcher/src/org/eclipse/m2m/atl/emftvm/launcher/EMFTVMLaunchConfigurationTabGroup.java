/*******************************************************************************
 * Copyright (c) 2011-2014 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * UI for launching EMFTVM transformations.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFTVMLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	/**
	 * Creates a new {@link EMFTVMLaunchConfigurationTabGroup}. 
	 */
	public EMFTVMLaunchConfigurationTabGroup() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		final ILaunchConfigurationTab mainTab = new MainEMFTVMTab();
		final ILaunchConfigurationTab parameterTab = new EMFTVMParameterTab(mode);
		final ILaunchConfigurationTab commonTab = new CommonTab();
		setTabs(new ILaunchConfigurationTab[]{mainTab, parameterTab, commonTab});
	}

}
