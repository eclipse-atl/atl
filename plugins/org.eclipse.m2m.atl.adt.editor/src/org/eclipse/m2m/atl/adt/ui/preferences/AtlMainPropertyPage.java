/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * The ATL Main property page.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlMainPropertyPage extends AbstractPropertyAndPreferencePage {

	public AtlMainPropertyPage() {
		super(AtlPreferencesMessages.getString("AtlPropertyPage.description")); //$NON-NLS-1$
	}

	@Override
	protected Control createContents(Composite parent) {
		return null;
	}

}
