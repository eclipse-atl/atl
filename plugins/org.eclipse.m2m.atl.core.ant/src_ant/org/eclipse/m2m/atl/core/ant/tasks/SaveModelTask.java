/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.ant.AtlBuildListener;
import org.eclipse.m2m.atl.core.ant.Messages;
import org.eclipse.m2m.atl.core.ant.tasks.nested.Extractor;
import org.eclipse.m2m.atl.core.service.CoreService;

/**
 * Model saving task.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class SaveModelTask extends AbstractAtlTask {

	protected boolean setSavedFilesToDerived = true;

	protected String model;

	protected File path;

	protected String uri;

	protected String factory;

	private List<Extractor> extractors = new ArrayList<Extractor>();

	public boolean isDerived() {
		return setSavedFilesToDerived;
	}

	public void setDerived(boolean isDerived) {
		this.setSavedFilesToDerived = isDerived;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFactory() {
		return factory;
	}

	/**
	 * Adds an extractor.
	 * 
	 * @param extractor
	 *            the given extractor
	 */
	public void addConfiguredExtractor(Extractor extractor) {
		extractors.add(extractor);
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ant.tasks.AbstractAtlTask#execute()
	 */
	@Override
	public void execute() throws BuildException {
		log(Messages.getString("SaveModelTask.MSG", model, path)); //$NON-NLS-1$

		IExtractor extractorInstance = null;
		Map<String, Object> extractorParams = Collections.<String, Object> emptyMap();

		try {
			if (!extractors.isEmpty()) {
				extractorParams = extractors.get(0).getParams();
				extractorInstance = CoreService.getExtractor(extractors.get(0).getName());
			} else {
				ModelFactory factoryInstance = null;
				if (factory != null) {
					factoryInstance = AtlBuildListener.getModelFactory(factory);
				} else {
					factoryInstance = getDefaultModelFactory();
				}
				String extractor = factoryInstance.getDefaultExtractorName();
				extractorInstance = CoreService.getExtractor(extractor);
			}
		} catch (ATLCoreException e) {
			error(Messages.getString("SaveModelTask.UNABLE_TO_LOAD_EXTRACTOR"), e); //$NON-NLS-1$
		}

		IModel targetModel = (IModel)getProject().getReference(model);
		if (targetModel == null) {
			error(Messages.getString("SaveModelTask.MODEL_NOT_FOUND", model)); //$NON-NLS-1$
		}

		try {
			String convertedPath = convertTarget();
			extractorInstance.extract(targetModel, convertedPath, extractorParams);
			if (Platform.isRunning()) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
						new Path(path.getPath()));
				file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
				if (setSavedFilesToDerived) {
					if (file.exists()) {
						file.setDerived(true);
					}
				}
			}
		} catch (ATLCoreException e) {
			error(e.getMessage(), e);
		} catch (CoreException e) {
			error(e.getMessage(), e);
		}
		super.execute();
	}

	private String convertTarget() {
		if (path != null) {
			if (path.toString().startsWith("platform:")) { //$NON-NLS-1$
				return path.toString();
			} else if (uri != null) {
				return uri;
			}
			return "file:/" + path.toString(); //$NON-NLS-1$
		} else {
			error(Messages.getString("SaveModelTask.UNSPECIFIED_TARGET")); //$NON-NLS-1$
		}
		return null;
	}

}
