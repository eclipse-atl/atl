/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;


/**
 * General superclass for EMFTVM Ant tasks.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class EMFTVMTask extends Task {

	public static final String RESOURCE_SET = "EMFTVM.ResourceSet";

	/**
	 * @return the {@link ResourceSet} object for this project.
	 */
	public ResourceSet getResourceSet() {
		ResourceSet resourceSet = (ResourceSet) getProject().getReference(RESOURCE_SET);
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			getProject().addReference(RESOURCE_SET, resourceSet);
		}
		return resourceSet;
	}

	/**
	 * @param name
	 * @return the loaded model with the given name
	 */
	public Model getModel(final String name) {
		return (Model) getProject().getReference(name);
	}

	/**
	 * @param name
	 * @return the loaded metamodel with the given name
	 */
	public Metamodel getMetamodel(final String name) {
		return (Metamodel) getProject().getReference(name);
	}

	/**
	 * Sets a reference to the model by name.
	 * @param name
	 * @param model
	 */
	public void setModel(final String name, final Model model) {
		if (getProject().getReference(name) != null) {
			throw new IllegalArgumentException(String.format("Model reference %s already exists", name));
		}
		getProject().addReference(name, model);
	}

	/* (non-Javadoc)
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public final void execute() throws BuildException {
		try {
			super.execute();
			EMFTVMBuildListener.attachBuildListener(getProject());
			innerExecute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException(e);
		}
	}

	/**
	 * Performs the actual execution.
	 * @throws Exception
	 */
	protected abstract void innerExecute() throws Exception;

}