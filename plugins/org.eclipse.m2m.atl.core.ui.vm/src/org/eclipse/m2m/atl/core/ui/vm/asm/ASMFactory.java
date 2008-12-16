/*******************************************************************************
 * Copyright (c) 2008 Obeo.
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.ui.vm.Messages;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;

/**
 * The RegularVM adaptation of the {@link ModelFactory}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMFactory extends ModelFactory {

	/** The model factory name which is also the extractor/injector name. */
	public static final String MODEL_FACTORY_NAME = "ASM"; //$NON-NLS-1$

	/** The model handler name. */
	public static final String OPTION_MODEL_HANDLER = "modelHandlerName"; //$NON-NLS-1$

	/** The model name. */
	public static final String OPTION_MODEL_NAME = "modelName"; //$NON-NLS-1$

	/** The model path. */
	public static final String OPTION_MODEL_PATH = "path"; //$NON-NLS-1$

	/** The newModel boolean. */
	public static final String OPTION_NEW_MODEL = "newModel"; //$NON-NLS-1$

	private static Map<String, ASMModelWrapper> metametamodels = new HashMap<String, ASMModelWrapper>();

	private static Map<String, ASMModelWrapper> builtin = new HashMap<String, ASMModelWrapper>();

	private static final AtlModelHandler DEFAULT_MODEL_HANDLER = AtlModelHandler.getDefault("EMF"); //$NON-NLS-1$
	
	private Map<AtlModelHandler, ModelLoader> modelLoaders = new HashMap<AtlModelHandler, ModelLoader>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultExtractorName()
	 */
	@Override
	public String getDefaultExtractorName() {
		return MODEL_FACTORY_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultInjectorName()
	 */
	@Override
	public String getDefaultInjectorName() {
		return MODEL_FACTORY_NAME;
	}

	/**
	 * {@inheritDoc} This method needs additional parameters to be launched, passed as options:
	 * <ul>
	 * <li>modelHandlerName: the name of the model handler.</li>
	 * <li>modelName: the name of the model.</li>
	 * <li>path: the path of the model.</li>
	 * <li>newModel: a boolean, true if the model is a new one.</li>
	 * </ul>
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newModel(org.eclipse.m2m.atl.core.IReferenceModel,
	 *      java.util.Map)
	 */
	@Override
	public IModel newModel(IReferenceModel referenceModel, Map<String, Object> options) {
		String modelName = (String)options.get(OPTION_MODEL_NAME);
		String path = (String)options.get(OPTION_MODEL_PATH);
		boolean newModel = "true".equals(options.get(OPTION_NEW_MODEL).toString()); //$NON-NLS-1$
		return new ASMModelWrapper((ASMModelWrapper)referenceModel, this, ((ASMModelWrapper)referenceModel)
				.getModelLoader(), modelName, path, newModel);
	}

	/**
	 * {@inheritDoc} This method needs additional parameters to be launched, passed as options:
	 * <ul>
	 * <li>modelHandlerName: the name of the model handler.</li>
	 * <li>modelName: the name of the model.</li>
	 * <li>path: the path of the model.</li>
	 * </ul>
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newReferenceModel(java.util.Map)
	 */
	@Override
	public IReferenceModel newReferenceModel(Map<String, Object> options) {
		String modelHandlerName = (String)options.get(OPTION_MODEL_HANDLER);
		String modelName = (String)options.get(OPTION_MODEL_NAME);
		String path = (String)options.get(OPTION_MODEL_PATH);
		if (path != null) {
			if (path.startsWith("#")) { //$NON-NLS-1$
				return getMetametamodel(modelHandlerName);
			}
		}
		return new ASMModelWrapper(
				getMetametamodel(modelHandlerName), this,
				getModelLoader(getModelHandler(modelHandlerName)),
				modelName, path, false);
	}

	private AtlModelHandler getModelHandler(String modelHandlerName) {
		AtlModelHandler modelHandler = null;
		if (modelHandlerName != null) {
			modelHandler = AtlModelHandler.getDefault(modelHandlerName);
		} else {
			modelHandler = DEFAULT_MODEL_HANDLER;
		}
		return modelHandler;
	}
	
	private ModelLoader getModelLoader(AtlModelHandler handler) {
		ModelLoader ml = modelLoaders.get(handler);
		if (ml == null) {
			ml = handler.createModelLoader();
			modelLoaders.put(handler, ml);
		}
		return ml;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newModel(org.eclipse.m2m.atl.core.IReferenceModel)
	 */
	@Override
	public IModel newModel(IReferenceModel referenceModel) {
		ATLLogger.severe(Messages.getString("ASMFactory.MISSING_PARAMS")); //$NON-NLS-1$
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newReferenceModel()
	 */
	@Override
	public IReferenceModel newReferenceModel() {
		ATLLogger.severe(Messages.getString("ASMFactory.MISSING_PARAMS")); //$NON-NLS-1$
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getBuiltInResource(java.lang.String)
	 */
	@Override
	public IReferenceModel getBuiltInResource(String name) {
		if (builtin.get(name) == null) {
			final ModelLoader ml = getModelLoader(DEFAULT_MODEL_HANDLER);
			final ASMModelWrapper metamodel = new ASMModelWrapper(ml.getBuiltInMetaModel(name), ml);
			builtin.put(name, metamodel);
		}
		return builtin.get(name);
	}

	/**
	 * Find the metametamodel for a given model handler name.
	 * 
	 * @param modelHandlerName
	 *            the model handler name
	 * @return the metametamodel, embedded into an ASMModelWrapper
	 */
	public static ASMModelWrapper getMetametamodel(String modelHandlerName) {
		if (metametamodels.get(modelHandlerName) == null) {
			final AtlModelHandler amh = AtlModelHandler.getDefault(modelHandlerName);
			final ModelLoader ml = amh.createModelLoader();
			final ASMModelWrapper metametamodel = new ASMModelWrapper(ml.getMOF(), ml);
			metametamodels.put(modelHandlerName, metametamodel);
		}
		return metametamodels.get(modelHandlerName);
	}
}
