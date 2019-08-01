/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IInjector}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMInjector implements IInjector {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, String source, Map<String, Object> options)
			throws ATLCoreException {
		inject(targetModel, source, ((ASMModelWrapper)targetModel).getName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void inject(IModel targetModel, String source) throws ATLCoreException {
		inject(targetModel, source, ((ASMModelWrapper)targetModel).getName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.io.InputStream,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, InputStream source, Map<String, Object> options)
			throws ATLCoreException {
		final ASMModelWrapper modelWrapper = (ASMModelWrapper)targetModel;
		try {
			final ModelLoader ml = modelWrapper.getModelLoader();
			ASMModel asmModel = ml.loadModel(modelWrapper.getName(), ((ASMModelWrapper)modelWrapper
					.getReferenceModel()).getAsmModel(), source);
			modelWrapper.setAsmModel(asmModel);
		} catch (IOException e) {
			throw new ATLCoreException(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.io.Reader,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, Reader source, Map<String, Object> options)
			throws ATLCoreException {
		throw new UnsupportedOperationException();
	}

	private void inject(IModel targetModel, String source, String modelName) throws ATLCoreException {
		final ASMModelWrapper modelWrapper = (ASMModelWrapper)targetModel;
		try {
			final ModelLoader ml = modelWrapper.getModelLoader();
			ASMModel asmModel = null;

			if (source.startsWith("#")) { //$NON-NLS-1$
				// nothing to do, already loaded in newModel
				return;
			} else if (ml instanceof EMFModelLoader) {
				if (source.startsWith("pathmap:")) { //$NON-NLS-1$
					asmModel = ((EMFModelLoader)ml).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createURI(source).trimFragment());
				} else {
					asmModel = ((EMFModelLoader)ml).loadModel(modelName, ((ASMModelWrapper)modelWrapper.getReferenceModel())
							.getAsmModel(), URI.createURI(source));
				}
			} else {
				asmModel = ml.loadModel(modelName, ((ASMModelWrapper)modelWrapper.getReferenceModel())
						.getAsmModel(), fileNameToInputStream(source));
			}
			modelWrapper.setAsmModel(asmModel);

		} catch (CoreException e) {
			throw new ATLCoreException(e.getLocalizedMessage(), e);
		} catch (IOException e) {
			throw new ATLCoreException(e.getLocalizedMessage(), e);
		}
	}

	private static InputStream fileNameToInputStream(String filePath) throws FileNotFoundException,
			CoreException {
		String usedFilePath = filePath;
		if (usedFilePath.startsWith("file:/")) { //$NON-NLS-1$
			File f = new File(usedFilePath.substring(6));
			return new FileInputStream(f);
		} else {
			if (usedFilePath.startsWith("platform:/resource/")) { //$NON-NLS-1$
				usedFilePath = usedFilePath.substring(19);
			}
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			usedFilePath = usedFilePath.replace('#', '/');
			return iwr.getFile(new Path(usedFilePath)).getContents();
		}
	}
}
