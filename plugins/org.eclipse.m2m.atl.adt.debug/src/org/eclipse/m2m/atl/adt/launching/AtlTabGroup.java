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

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTabGroup;

/**
 * This class create tabGroup in order to create configuration in
 * Run or Debug mode
 *  
 * @author Freddy Allilaire
 */
public class AtlTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	/**
	 * Constructs a new Java applet tab group.
	 */
	public AtlTabGroup() {
	}
	
	/**
	 * Main method, there is two differents tab group, one in Run mode and
	 * one in Debug mode.
	 * 
	 * @see ILaunchConfigurationTabGroup#createTabs(ILaunchConfigurationDialog, String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab mainAtlTab = new MainAtlTab();
        //ILaunchConfigurationTab modelChoiceTab = new ModelChoiceTab();
        ILaunchConfigurationTab advancedTab = new AdvancedTab();
        ILaunchConfigurationTab commonTab = new CommonTab();
		setTabs(new ILaunchConfigurationTab[] {
                mainAtlTab,
                //modelChoiceTab,
                advancedTab,
                commonTab
		    });
	}
}