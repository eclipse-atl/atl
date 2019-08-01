/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This will allow the user to unzip the public2private example.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Public2PrivateExampleWizard extends AbstractExampleWizard {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.examples.AbstractExampleWizard#getProjectDescriptors()
	 */
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		final List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(2);
		projects
				.add(new ProjectDescriptor(
						"org.eclipse.m2m.atl.examples", "examples/org.eclipse.m2m.atl.examples.public2private.zip", "org.eclipse.m2m.atl.examples.public2private")); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		projects
				.add(new ProjectDescriptor(
						"org.eclipse.m2m.atl.examples", "examples/org.eclipse.m2m.atl.examples.public2private.ui.zip", "org.eclipse.m2m.atl.examples.public2private.ui")); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		return projects;
	}

}
