/*
 * Created on 26 avr. 2004
 */
package org.atl.eclipse.adt.launching;
import org.eclipse.debug.core.ILaunchManager;
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
		ILaunchConfigurationTab[] tabs;
		// run tab group
		if (mode.equals(ILaunchManager.RUN_MODE)) {
			tabs = new ILaunchConfigurationTab[] {
					new MainAtlTab(),
					new ModelChoiceTab(),
					new CommonTab()
			};
		}
		// debug tab group
		else {
			tabs = new ILaunchConfigurationTab[] {
					new MainAtlTab(),
					new ModelChoiceTab(),
					new CommonTab()
			};
		}
		setTabs(tabs);
	}
}