/*******************************************************************************
 * Copyright (c) 2004 INRIA and Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Mikael Barbero (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *    William Piers (Obeo)
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.m2m.atl.core.ui.launch.MainAtlTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Main UI tab for launching EMFTVM transformations.
 * Derived from {@link MainAtlTab}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class EMFTVMParameterTab extends AbstractLaunchConfigurationTab {

	private ScrolledComposite scrollContainer;
	private Composite rootContainer;
	private Group parameterGroup;
	private Button displayTimingData;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		scrollContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrollContainer.setExpandHorizontal(true);
		scrollContainer.setExpandVertical(true);

		rootContainer = new Composite(scrollContainer, SWT.NULL);
		rootContainer.setLayout(new GridLayout());
		scrollContainer.setContent(rootContainer);

		parameterGroup = new Group(rootContainer, SWT.NULL);
		parameterGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		parameterGroup.setLayout(new GridLayout(3, false));
		parameterGroup.setText("EMFTVM parameters");
		
		displayTimingData = new Button(parameterGroup, SWT.CHECK);
		displayTimingData.setText("Display Timing Data");
		displayTimingData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		setControl(scrollContainer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EMFTVMLaunchConstants.DISPLAY_TIMING, true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			displayTimingData.setSelection(
					configuration.getAttribute(
							EMFTVMLaunchConstants.DISPLAY_TIMING, true));
		} catch (CoreException e) {
			EmftvmLauncherPlugin.log(e.getStatus());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				EMFTVMLaunchConstants.DISPLAY_TIMING, displayTimingData.getSelection());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		return super.isValid(launchConfig);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Parameters";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return EmftvmLauncherImages.get(EmftvmLauncherImages.OBJ_PARAMETER_TAB);
	}

}
