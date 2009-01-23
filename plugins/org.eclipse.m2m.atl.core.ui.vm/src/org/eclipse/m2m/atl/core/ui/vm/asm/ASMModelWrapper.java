/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.asm;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IModel}, {@link IReferenceModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMModelWrapper implements IModel, IReferenceModel {

	private ASMModel asmModel;

	private ASMModelWrapper referenceModel;

	private ASMFactory modelFactory;

	private ModelLoader modelLoader;

	/**
	 * Creates a new {@link ASMModelWrapper}.
	 * 
	 * @param referenceModel
	 *            the {@link ASMModelWrapper} metamodel
	 * @param modelFactory
	 *            the model loader creating this model.
	 * @param modelLoader
	 *            the model loader creating the wrapped model.
	 * @param modelName
	 *            the model name
	 * @param path
	 *            the model path (injection path for an existing one, extraction path for a new one)
	 * @param newModel
	 *            true if the model is a new one (output model)
	 */
	public ASMModelWrapper(ASMModelWrapper referenceModel, ASMFactory modelFactory, ModelLoader modelLoader, String modelName,
			String path, boolean newModel) {
		this.referenceModel = referenceModel;
		this.modelFactory = modelFactory;
		this.modelLoader = modelLoader;
		if (newModel) {
			String newPath;
			if (path == null) {
				newPath = "temp"; //$NON-NLS-1$
			} else {
				if (path.startsWith("ext:")) { //$NON-NLS-1$
					File f = new File(path.substring(4));
					newPath = URI.createFileURI(f.getPath()).toString();
				} else {
					newPath = URI.createPlatformResourceURI(path, true).toString();
				}
			}
			asmModel = modelLoader.newModel(modelName, newPath, referenceModel.getAsmModel());
		}
	}

	/**
	 * Creates a new {@link ASMModelWrapper}, with the given {@link ASMModel}. This constructor is used to
	 * create metametamodels.
	 * 
	 * @param asmModel
	 *            the {@link ASMModel}
	 * @param modelLoader
	 *            the {@link ModelLoader}
	 */
	public ASMModelWrapper(ASMModel asmModel, ModelLoader modelLoader) {
		this.referenceModel = this;
		this.asmModel = asmModel;
		this.modelLoader = modelLoader;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getReferenceModel()
	 */
	public IReferenceModel getReferenceModel() {
		return referenceModel;
	}

	/**
	 * Sets the metamodel.
	 * 
	 * @param referenceModel
	 *            The metamodel to set.
	 */
	public void setReferenceModel(ASMModelWrapper referenceModel) {
		this.referenceModel = referenceModel;
	}

	/**
	 * Returns the model loader that created the inner {@link ASMModel}.
	 * 
	 * @return The model loader.
	 */
	public ModelLoader getModelLoader() {
		return modelLoader;
	}

	/**
	 * Returns the inner {@link ASMModel}.
	 * 
	 * @return the inner {@link ASMModel}.
	 */
	public ASMModel getAsmModel() {
		return asmModel;
	}

	/**
	 * Sets the inner {@link ASMModel}.
	 * 
	 * @param asmModel
	 *            The inner {@link ASMModel} to set.
	 */
	public void setAsmModel(ASMModel asmModel) {
		this.asmModel = asmModel;
	}

	/**
	 * Returns the inner model name or {@literal &lt;unnamed&gt;}.
	 * 
	 * @return the inner model name or {@literal &lt;unnamed&gt;}.
	 */
	public String getName() {
		final ASMModel am = getAsmModel();
		if (am != null) {
			return am.getName();
		}
		return "<unnamed>"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#isTarget()
	 */
	public boolean isTarget() {
		return asmModel.isTarget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#setIsTarget(boolean)
	 */
	public void setIsTarget(boolean value) {
		asmModel.setIsTarget(value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getElementsByType(java.lang.Object)
	 * @deprecated unused in this implementation
	 */
	public Set<? extends Object> getElementsByType(Object metaElement) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#newElement(java.lang.Object)
	 * @deprecated unused in this implementation
	 */
	public Object newElement(Object metaElement) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IReferenceModel#getMetaElementByName(java.lang.String)
	 * @deprecated unused in this implementation
	 */
	public Object getMetaElementByName(String name) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IReferenceModel#isModelOf(java.lang.Object)
	 * @deprecated unused in this implementation
	 */
	public boolean isModelOf(Object object) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.core.IModel#getModelFactory()
	 */
	public ASMFactory getModelFactory() {
		return modelFactory;
	}

}
