/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.asm;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IModel}, {@link IReferenceModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMModelWrapper implements IModel, IReferenceModel {

	private ASMModel asmModel;

	private ASMModelWrapper referenceModel;

	private AtlModelHandler modelHandler;

	private String modelName;

	/**
	 * Creates a new {@link ASMModelWrapper}.
	 * 
	 * @param referenceModel
	 *            the {@link ASMModelWrapper} metamodel
	 * @param modelHandler
	 *            the modelHandler
	 * @param modelName
	 *            the model name
	 * @param path
	 *            the model path (injection path for an existing one, extraction path for a new one)
	 * @param newModel
	 *            true if the model is a new one (output model)
	 */
	public ASMModelWrapper(ASMModelWrapper referenceModel, AtlModelHandler modelHandler, String modelName,
			String path, boolean newModel) {
		this.referenceModel = referenceModel;
		this.modelHandler = modelHandler;
		this.modelName = modelName;
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
			asmModel = modelHandler.newModel(modelName, newPath, referenceModel.getAsmModel());
		}
	}

	/**
	 * Creates a new {@link ASMModelWrapper}, with the given {@link ASMModel}. This constructor is used to
	 * create metametamodels.
	 * 
	 * @param asmModel
	 *            the {@link ASMModel}
	 * @param modelHandler
	 *            the {@link AtlModelHandler}
	 */
	public ASMModelWrapper(ASMModel asmModel, AtlModelHandler modelHandler) {
		this.referenceModel = this;
		this.asmModel = asmModel;
		this.modelHandler = modelHandler;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getReferenceModel()
	 */
	public IReferenceModel getReferenceModel() {
		return referenceModel;
	}

	public void setReferenceModel(ASMModelWrapper referenceModel) {
		this.referenceModel = referenceModel;
	}

	public AtlModelHandler getModelHandler() {
		return modelHandler;
	}

	public void setModelHandler(AtlModelHandler modelHandler) {
		this.modelHandler = modelHandler;
	}

	public ASMModel getAsmModel() {
		return asmModel;
	}

	public void setAsmModel(ASMModel asmModel) {
		this.asmModel = asmModel;
	}

	public String getName() {
		return modelName;
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
	 * @see org.eclipse.m2m.atl.core.IModel#dispose()
	 */
	public void dispose() {
		if (!this.referenceModel.equals(this)) {
			modelHandler.disposeOfModel(asmModel);
		}
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

}
