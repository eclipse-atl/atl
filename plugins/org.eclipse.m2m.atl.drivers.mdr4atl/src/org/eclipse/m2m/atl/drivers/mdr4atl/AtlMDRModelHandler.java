/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

public class AtlMDRModelHandler extends AtlModelHandler {

	private ASMMDRModel atlmm;

	private ASMMDRModel mofmm;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, org.eclipse.core.resources.IProject)
	 */
	public void saveModel(final ASMModel model, IProject project) {
		saveModel(model, model.getName() + ".xmi", project);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String, org.eclipse.core.resources.IProject)
	 */
	public void saveModel(final ASMModel model, String fileName, IProject project) {
		IFile file = project.getFile(fileName);
		saveModel(model, file);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	public void saveModel(final ASMModel model, String uri) {
		try {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri));
			saveModel(model, file);
		} catch (Throwable e) {
			try {
				((ASMMDRModel)model).save(uri);
			} catch (IOException ioe) {
				ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
			}
		}
	}

	private void saveModel(final ASMModel model, IFile file) {
		try {
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			Thread th = new Thread() {
				public void run() {
					saveModel(model, out);
				}
			};
			th.start();
			if (file.exists()) {
				file.setContents(in, IFile.FORCE, null);
			}
			else {
				file.create(in, IFile.FORCE, null);
			}
			file.setDerived(true);
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.OutputStream)
	 */
	public void saveModel(final ASMModel model, OutputStream out) {
		try {
			((ASMMDRModel)model).save(out);
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public ASMModel getAtl() {
		return atlmm;
	}

	public ASMModel getMof() {
		return mofmm;
	}

	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.loadASMMDRModel(name, (ASMMDRModel)metamodel, in, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		}

		return ret;
	}

	/**
	 * @see ASMMDRModel#newASMMDRModel(String, ASMMDRModel, ModelLoader)
	 */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.newASMMDRModel(name, (ASMMDRModel)metamodel, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		}

		return ret;
	}

	/**
	 * @see ASMMDRModel#newASMMDRModel(String, String, ASMMDRModel, ModelLoader)
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.newASMMDRModel(name, uri, (ASMMDRModel)metamodel, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		}

		return ret;
	}

	public AtlMDRModelHandler() {
		URL atlurl = AtlMDRModelHandler.class.getResource("resources/ATL-0.2.xmi");
		mofmm = ASMMDRModel.createMOF(null);

		try {
			atlmm = ASMMDRModel.loadASMMDRModel("ATL", mofmm, atlurl, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = null;

		return ret;
	}

	public boolean isHandling(ASMModel model) {
		return model instanceof ASMMDRModel;
	}

	public void disposeOfModel(ASMModel model) {
		((ASMMDRModel)model).dispose();
	}
}
