/*******************************************************************************
 * Copyright (c) 2004-2014 INRIA and Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
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
 * Parameter tab for launching EMFTVM transformations.
 * Derived from {@link org.eclipse.m2m.atl.core.ui.launch.MainAtlTab}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class EMFTVMParameterTab extends AbstractLaunchConfigurationTab {

	private final String mode;
	
	private ScrolledComposite scrollContainer;
	private Composite rootContainer;
	private Group parameterGroup;
	private Button displayTimingData;
	private Button disableJIT;
	private Button profile;
	
	/**
	 * Creates a new {@link EMFTVMParameterTab}.
	 * @param mode the mode the launch configuration dialog was opened in
	 */
	public EMFTVMParameterTab (String mode) {
		this.mode = mode;
	}

	/**
	 * {@inheritDoc}
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
		displayTimingData.setText(EMFTVMLaunchConstants.DISPLAY_TIMING);
		displayTimingData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		disableJIT = new Button(parameterGroup, SWT.CHECK);
		disableJIT.setText(EMFTVMLaunchConstants.DISABLE_JIT);
		disableJIT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		profile = new Button(parameterGroup, SWT.CHECK);
		profile.setText(EMFTVMLaunchConstants.PROFILE);
		profile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		setControl(scrollContainer);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EMFTVMLaunchConstants.DISPLAY_TIMING, true);
		configuration.setAttribute(EMFTVMLaunchConstants.DISABLE_JIT, false);
		configuration.setAttribute(EMFTVMLaunchConstants.PROFILE, false);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			displayTimingData.setSelection(
					configuration.getAttribute(
							EMFTVMLaunchConstants.DISPLAY_TIMING, true));
			disableJIT.setSelection(
					configuration.getAttribute(
							EMFTVMLaunchConstants.DISABLE_JIT, false));
			profile.setSelection(
					configuration.getAttribute(
							EMFTVMLaunchConstants.PROFILE, false));
			// Profiling does not make sense while debugging
			if (ILaunchManager.DEBUG_MODE.equals(mode)) {
				profile.setEnabled(false);
			}
		} catch (CoreException e) {
			EmftvmLauncherPlugin.log(e.getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				EMFTVMLaunchConstants.DISPLAY_TIMING, displayTimingData.getSelection());
		configuration.setAttribute(
				EMFTVMLaunchConstants.DISABLE_JIT, disableJIT.getSelection());
		configuration.setAttribute(
				EMFTVMLaunchConstants.PROFILE, profile.getSelection());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		return super.isValid(launchConfig);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return "Parameters";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return EmftvmLauncherImages.get(EmftvmLauncherImages.OBJ_PARAMETER_TAB);
	}

}
