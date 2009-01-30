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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object,
	 *      java.util.Map)
	 */
	public void inject(IModel sourceModel, Object source, Map<String, Object> options)
			throws ATLCoreException {
		inject(sourceModel, source, ((ASMModelWrapper)sourceModel).getName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object)
	 */
	public void inject(IModel sourceModel, Object source) throws ATLCoreException {
		inject(sourceModel, source, ((ASMModelWrapper)sourceModel).getName());
	}

	private void inject(IModel sourceModel, Object source, String modelName)
			throws ATLCoreException {
		final ASMModelWrapper modelWrapper = (ASMModelWrapper)sourceModel;
		try {
			final ModelLoader ml = modelWrapper.getModelLoader();
			String path = (String)source;
			ASMModel asmModel = null;

			if (path.startsWith("#")) { //$NON-NLS-1$
				// nothing to do, ever loaded in newModel
				return;
			} else if (ml instanceof EMFModelLoader) {
				if (path.startsWith("platform:/resource")) { //$NON-NLS-1$
					path = path.substring(18);
					asmModel = ((EMFModelLoader)ml).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createPlatformResourceURI(path, false));
				} else if (path.startsWith("file:/")) { //$NON-NLS-1$
					path = path.substring(6);
					asmModel = ((EMFModelLoader)ml).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createFileURI(path));
				} else if (path.startsWith("pathmap:")) { //$NON-NLS-1$
					asmModel = ((EMFModelLoader)ml).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createURI(path, true));
				} else {
					asmModel = ml.loadModel(modelName, ((ASMModelWrapper)modelWrapper.getReferenceModel())
							.getAsmModel(), "uri:" + path); //$NON-NLS-1$
				}
			} else {
				asmModel = ml.loadModel(modelName, ((ASMModelWrapper)modelWrapper.getReferenceModel())
						.getAsmModel(), fileNameToInputStream((String)source));
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
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			usedFilePath = usedFilePath.replace('#', '/');
			return iwr.getFile(new Path(usedFilePath)).getContents();
		}
	}
}
