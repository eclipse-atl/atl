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
package org.eclipse.m2m.atl.adt.ui.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * The model selection dialog.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlModelSelection extends AbstractAtlSelection {

	private static final String DEFAULT_METAMODEL_NAME = "MM"; //$NON-NLS-1$

	private Text modelNameText;

	private Text metamodelNameText;

	private AtlResourceSelectionBox loadResourceBox;

	private String defaultModelName;

	private Map<String, String> inputFromParent;

	private Map<String, String> outputFromParent;

	private Map<String, String> pathsFromParent;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param title
	 *            the title
	 * @param defaultModelName
	 *            the default model name
	 * @param input
	 *            input from parent
	 * @param output
	 *            output from parent
	 * @param paths
	 *            paths from parent
	 */
	public AtlModelSelection(Shell parent, String title, String defaultModelName, Map<String, String> input,
			Map<String, String> output, Map<String, String> paths) {
		super(parent, title);
		this.defaultModelName = defaultModelName;
		this.inputFromParent = input;
		this.outputFromParent = output;
		this.pathsFromParent = paths;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.common.AbstractAtlSelection#create()
	 */
	@Override
	public void create() {
		super.create();
		modelNameText.setText(getDefaultName(defaultModelName, getExistingModels()));
		metamodelNameText.setText(getDefaultName(DEFAULT_METAMODEL_NAME, getExistingMetamodels()));
		// usually metamodel name matters more than model name
		metamodelNameText.setFocus();
		metamodelNameText.selectAll();
	}

	private Set<String> getExistingModels() {
		Set<String> res = new HashSet<String>();
		res.addAll(inputFromParent.keySet());
		res.addAll(outputFromParent.keySet());
		return res;
	}

	private Set<String> getExistingMetamodels() {
		Set<String> res = new HashSet<String>();
		res.addAll(inputFromParent.values());
		res.addAll(outputFromParent.values());
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite)super.createDialogArea(parent);
		GridData data = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(data);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);

		Group modelSection = new Group(container, SWT.NULL);
		modelSection.setText(Messages.getString("AtlModelSelection.NAMING")); //$NON-NLS-1$
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 10;
		modelSection.setLayout(layout);
		data = new GridData(GridData.FILL_HORIZONTAL);
		modelSection.setLayoutData(data);

		Label modelLabel = new Label(modelSection, SWT.NULL);
		modelLabel.setText(Messages.getString("AtlModelSelection.MODEL_NAME")); //$NON-NLS-1$
		modelLabel.setLayoutData(new GridData());
		modelNameText = new Text(modelSection, SWT.BORDER);
		modelNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		modelNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textChanged();
			}
		});

		Label metamodelLabel = new Label(modelSection, SWT.NULL);
		metamodelLabel.setText(Messages.getString("AtlModelSelection.METAMODEL_NAME")); //$NON-NLS-1$
		metamodelLabel.setLayoutData(new GridData());
		metamodelNameText = new Text(modelSection, SWT.BORDER);
		metamodelNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		metamodelNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textChanged();
			}
		});

		Group uriSection = new Group(container, SWT.NULL);
		uriSection.setText(Messages.getString("AtlModelSelection.METAMODEL_LOCATION")); //$NON-NLS-1$
		uriSection.setLayout(new GridLayout());
		data = new GridData(GridData.FILL_HORIZONTAL);
		uriSection.setLayoutData(data);

		loadResourceBox = new AtlResourceSelectionBox(getShell());
		final Composite composite = (Composite)loadResourceBox.createDialogArea(uriSection);
		composite.getChildren()[composite.getChildren().length - 1].dispose();

		composite.setLayoutData(data);
		return container;
	}

	private void textChanged() {
		String modelMessage = checkText(
				Messages.getString("AtlModelSelection.MODEL"), modelNameText.getText()); //$NON-NLS-1$
		String metamodelMessage = checkText(
				Messages.getString("AtlModelSelection.METAMODEL"), metamodelNameText.getText()); //$NON-NLS-1$
		if (modelMessage != null) {
			nok(modelMessage);
		} else if (metamodelMessage != null) {
			nok(metamodelMessage);
		} else if (getExistingModels().contains(modelNameText.getText())) {
			nok(Messages.getString("AtlModelSelection.MODEL_EXISTS")); //$NON-NLS-1$
		} else if (getExistingMetamodels().contains(metamodelNameText.getText())) {
			loadResourceBox.setText(pathsFromParent.get(metamodelNameText.getText()));
			warn(Messages.getString("AtlModelSelection.METAMODEL_EXISTS")); //$NON-NLS-1$
		} else {
			ok();
		}
	}

	private String checkText(String type, String text) {
		if (text == null || "".equals(text)) { //$NON-NLS-1$
			return Messages.getString("AtlModelSelection.SET_NAME", type); //$NON-NLS-1$
		} else if (!text.matches(NAMING_REGEX)) {
			return Messages.getString("AtlModelSelection.INVALID_NAME", type); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#computeResult()
	 */
	@Override
	protected void computeResult() {
		Object[] result;
		String resource = loadResourceBox.getURIText();
		if (resource != null && !"".equals(resource)) { //$NON-NLS-1$
			result = new Object[] {modelNameText.getText(), metamodelNameText.getText(), resource};
		} else {
			result = new Object[] {modelNameText.getText(), metamodelNameText.getText()};
		}
		setResult(Arrays.asList(result));
	}

}
