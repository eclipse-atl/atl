/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
public class Public2PrivateCLExampleWizard extends AbstractExampleWizard {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.examples.AbstractExampleWizard#getProjectDescriptors()
	 */
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		final List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects
				.add(new ProjectDescriptor(
						"org.eclipse.m2m.atl.examples", "examples/org.eclipse.m2m.atl.examples.public2private.cmd.zip", "org.eclipse.m2m.atl.examples.public2private.cmd")); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		return projects;
	}

}
