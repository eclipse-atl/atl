/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
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
		String convertedPath = convertTarget();
		log(Messages.getString("SaveModelTask.MSG", model, convertedPath)); //$NON-NLS-1$

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
			error(
					Messages.getString("SaveModelTask.UNABLE_TO_LOAD_EXTRACTOR", extractors.get(0).getName()), e); //$NON-NLS-1$
		}

		IModel targetModel = (IModel)getProject().getReference(model);
		if (targetModel == null) {
			error(Messages.getString("SaveModelTask.MODEL_NOT_FOUND", model)); //$NON-NLS-1$
		}

		try {
			extractorInstance.extract(targetModel, convertedPath, extractorParams);
			if (setSavedFilesToDerived && path != null && CoreService.isEclipseRunning()) {
				try {
					Class<?> rp = Class.forName("org.eclipse.core.resources.ResourcesPlugin"); //$NON-NLS-1$
					Object ws = rp.getMethod("getWorkspace").invoke(null); //$NON-NLS-1$
					Object root = ws.getClass().getMethod("getRoot").invoke(ws); //$NON-NLS-1$
					Object wsfile = root
							.getClass()
							.getMethod("getFileForLocation", IPath.class).invoke(root, new Path(path.toString())); //$NON-NLS-1$
					Object parent = wsfile.getClass().getMethod("getParent").invoke(wsfile); //$NON-NLS-1$
					parent
							.getClass()
							.getMethod("refreshLocal", int.class, IProgressMonitor.class).invoke(parent, 1, null); //$NON-NLS-1$
					boolean fileExists = new Boolean(wsfile.getClass()
							.getMethod("exists").invoke(wsfile).toString()).booleanValue(); //$NON-NLS-1$
					if (fileExists) {
						wsfile.getClass().getMethod("setDerived", boolean.class).invoke(wsfile, true); //$NON-NLS-1$	
					}
				} catch (Throwable e) {
					error(e.getMessage(), e);
				}
			}
		} catch (ATLCoreException e) {
			error(e.getMessage(), e);
		}
		super.execute();
	}

	private String convertTarget() {
		if (path != null) {
			return "file:/" + path.toString(); //$NON-NLS-1$
		} else if (uri != null) {
			return uri;
		} else {
			error(Messages.getString("SaveModelTask.UNSPECIFIED_TARGET")); //$NON-NLS-1$
		}
		return null;
	}

}
