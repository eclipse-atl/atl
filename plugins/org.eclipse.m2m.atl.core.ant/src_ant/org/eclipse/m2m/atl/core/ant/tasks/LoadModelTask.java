/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Ant tooling
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ant.tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.ant.AtlBuildListener;
import org.eclipse.m2m.atl.core.ant.Messages;
import org.eclipse.m2m.atl.core.ant.tasks.nested.Injector;
import org.eclipse.m2m.atl.core.service.CoreService;

/**
 * Model loading task.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class LoadModelTask extends AbstractAtlTask {

	protected String name;

	protected String metamodel;

	/** Only used for RegularVM launch. */
	protected String modelHandler;

	/** Only used for EMFVM launch. */
	protected String factory;

	protected File path;

	protected String nsUri;

	private List<Injector> injectors = new ArrayList<Injector>();

	public void setName(String name) {
		this.name = name;
	}

	public void setMetamodel(String metamodel) {
		this.metamodel = metamodel;
	}

	public void setModelHandler(String modelHandler) {
		this.modelHandler = modelHandler;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public void setNsUri(String nsUri) {
		this.nsUri = nsUri;
	}

	/**
	 * Adds an injector.
	 * 
	 * @param injector
	 *            the given injector
	 */
	public void addConfiguredInjector(Injector injector) {
		injectors.add(injector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ant.tasks.AbstractAtlTask#execute()
	 */
	@Override
	public void execute() throws BuildException {
		String source = convertSource();
		log(Messages.getString("LoadModelTask.MSG", name, source)); //$NON-NLS-1$

		ModelFactory factoryInstance = null;
		IInjector injectorInstance = null;
		Map<String, Object> injectorParams = Collections.<String, Object> emptyMap();

		try {
			if (factory != null) {
				factoryInstance = AtlBuildListener.getModelFactory(factory);
			} else {
				factoryInstance = getDefaultModelFactory();
			}
		} catch (CoreException e) {
			error(Messages.getString("LoadModelTask.UNABLE_TO_LOAD_FACTORY"), e); //$NON-NLS-1$
		}
		try {
			if (!injectors.isEmpty()) {
				injectorParams = injectors.get(0).getParams();
				injectorInstance = CoreService.getInjector(injectors.get(0).getName());
			} else {
				String injector = factoryInstance.getDefaultInjectorName();
				injectorInstance = CoreService.getInjector(injector);
			}
		} catch (CoreException e) {
			error(Messages.getString("LoadModelTask.UNABLE_TO_LOAD_INJECTOR"), e); //$NON-NLS-1$
		}

		IModel sourceModel = (IModel)getProject().getReference(name);
		if (sourceModel == null) {
			if (source != null) {
				if (source.startsWith("#")) { //$NON-NLS-1$
					try {
						sourceModel = factoryInstance.getBuiltInResource(source.replaceFirst("#", "")); //$NON-NLS-1$ //$NON-NLS-2$	
					} catch (ATLCoreException e) {
						error(e.getMessage(), e);
					}
					getProject().addReference(name, sourceModel);
				} else {
					if (modelHandler == null) {
						modelHandler = DEFAULT_MODEL_HANDLER;
					}
					if (metamodel.equals("MOF") || metamodel.startsWith("#")) { //$NON-NLS-1$ //$NON-NLS-2$
						Map<String, Object> referenceModelOptions = new HashMap<String, Object>();
						referenceModelOptions.put(OPTION_MODEL_HANDLER, modelHandler);
						referenceModelOptions.put(OPTION_MODEL_NAME, name);
						referenceModelOptions.put(OPTION_MODEL_PATH, path);
						sourceModel = newReferenceModel(factoryInstance, name, referenceModelOptions);
					} else {
						Map<String, Object> modelOptions = new HashMap<String, Object>();
						modelOptions.put(OPTION_MODEL_NAME, name);
						modelOptions.put(OPTION_MODEL_PATH, path);
						modelOptions.put(OPTION_NEW_MODEL, false);
						sourceModel = newModel(factoryInstance, name, metamodel, modelOptions);
					}
					try {
						injectorInstance.inject(sourceModel, source, injectorParams);
					} catch (ATLCoreException e) {
						error(e.getMessage(), e);
					}
				}
			}
		}
		super.execute();
	}

	private String convertSource() {
		if (path != null) {
			if (!path.toString().startsWith("#")) { //$NON-NLS-1$
				return "ext:" + path.toString(); //$NON-NLS-1$
			}
			return path.toString();
		} else if (nsUri != null) {
			if (!nsUri.startsWith("pathmap:")) { //$NON-NLS-1$	
				return "uri:" + nsUri; //$NON-NLS-1$	
			}
			return nsUri;
		} else {
			error(Messages.getString("LoadModelTask.UNSPECIFIED_SOURCE")); //$NON-NLS-1$
		}
		return null;
	}
}
