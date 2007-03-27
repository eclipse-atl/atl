/*
 * Created on 10 juin 2004
 */
package org.eclipse.m2m.atl.adt.launching;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * @author allilaire
 */
public class RemoteAtlTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs;
		tabs = new ILaunchConfigurationTab[] {
				new RemoteAtlTab(),
				new CommonTab()
		};
		setTabs(tabs);
	}
}
