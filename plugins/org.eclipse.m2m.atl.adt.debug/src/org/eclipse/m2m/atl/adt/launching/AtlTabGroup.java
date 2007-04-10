/*
 * Created on 26 avr. 2004
 */
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
 * @author allilaire
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