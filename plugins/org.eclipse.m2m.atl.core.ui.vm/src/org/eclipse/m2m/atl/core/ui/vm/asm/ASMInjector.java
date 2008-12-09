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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IInjector}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMInjector implements IInjector {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object,
	 *      java.util.Map)
	 */
	public void inject(IModel sourceModel, Object source, Map options) {
		boolean checkSameModel = "true".equals(options.get("checkSameModel")); //$NON-NLS-1$ //$NON-NLS-2$
		inject(sourceModel, source, ((ASMModelWrapper)sourceModel).getName(), checkSameModel);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object)
	 */
	public void inject(IModel sourceModel, Object source) {
		inject(sourceModel, source, ((ASMModelWrapper)sourceModel).getName(), false);
	}

	private void inject(IModel sourceModel, Object source, String modelName, boolean checkSameModel) {
		ASMModelWrapper modelWrapper = (ASMModelWrapper)sourceModel;
		try {
			AtlModelHandler amh = modelWrapper.getModelHandler();
			String path = (String)source;
			ASMModel asmModel = null;

			if (((String)source).startsWith("#")) { //$NON-NLS-1$
				// nothing to do, ever loaded in newModel
				return;
			} else if (amh instanceof AtlEMFModelHandler) {
				if (path.startsWith("uri:")) { //$NON-NLS-1$
					asmModel = ((AtlEMFModelHandler)amh).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), path);
				} else if (path.startsWith("ext:")) { //$NON-NLS-1$
					path = path.substring(4);
					asmModel = ((AtlEMFModelHandler)amh).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createFileURI(path));
				} else {
					asmModel = ((AtlEMFModelHandler)amh).loadModel(modelName, ((ASMModelWrapper)modelWrapper
							.getReferenceModel()).getAsmModel(), URI.createPlatformResourceURI(path, false));
				}
			} else {
				asmModel = amh.loadModel(modelName, ((ASMModelWrapper)modelWrapper.getReferenceModel())
						.getAsmModel(), fileNameToInputStream((String)source));
			}

			if (asmModel instanceof ASMEMFModel) {
				((ASMEMFModel)asmModel).setCheckSameModel(checkSameModel);
			}
			modelWrapper.setAsmModel(asmModel);

		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (FileNotFoundException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private static InputStream fileNameToInputStream(String filePath) throws FileNotFoundException,
			CoreException {
		String usedFilePath = filePath;
		if (usedFilePath.startsWith("ext:")) { //$NON-NLS-1$
			File f = new File(usedFilePath.substring(4));
			return new FileInputStream(f);
		} else {
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			usedFilePath = usedFilePath.replace('#', '/');
			return iwr.getFile(new Path(usedFilePath)).getContents();
		}
	}
}
