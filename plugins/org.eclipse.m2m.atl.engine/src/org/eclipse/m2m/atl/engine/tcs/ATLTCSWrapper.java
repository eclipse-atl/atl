/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.tcs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.dsls.core.EMFTCSExtractor;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;

/**
 * TCS utilities Wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class ATLTCSWrapper implements IInjector, IExtractor {

	private static ModelFactory modelFactory;

	private static IInjector injector;

	private static IModel atlTcsModel;

	private static IReferenceModel problemMetamodel;

	private static IReferenceModel atlMetamodel;

	static {
		modelFactory = new EMFModelFactory();
		try {
			URL tcsMetamodelURL = ATLTCSWrapper.class.getResource("resources/TCS.ecore"); //$NON-NLS-1$
			URL atlTcsModelURL = ATLTCSWrapper.class.getResource("resources/ATL-TCS.xmi"); //$NON-NLS-1$
			injector = new EMFInjector();
			atlMetamodel = modelFactory.getBuiltInResource("ATL.ecore"); //$NON-NLS-1$
			problemMetamodel = modelFactory.getBuiltInResource("Problem.ecore"); //$NON-NLS-1$		
			IReferenceModel tcsMetamodel = modelFactory.newReferenceModel();
			injector.inject(tcsMetamodel, tcsMetamodelURL.openStream(), null);
			atlTcsModel = modelFactory.newModel(tcsMetamodel);
			injector.inject(atlTcsModel, atlTcsModelURL.openStream(), null);
		} catch (ATLCoreException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create a new Model then injects data using the given options.
	 * 
	 * @param source
	 *            the {@link InputStream} containing the model
	 * @param options
	 *            the injection parameters
	 * @return the new ATL Model
	 * @throws ATLCoreException
	 */
	public IModel[] inject(InputStream source, Map options) throws ATLCoreException {
		IModel targetModel = modelFactory.newModel(atlMetamodel);
		final Map params = new HashMap();
		params.put("name", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
		params.put("problems", modelFactory.newModel(problemMetamodel)); //$NON-NLS-1$
		if (options != null) {
			params.putAll(options);
		}
		inject(targetModel, source, params);
		return new IModel[] {targetModel, (IModel)params.get("problem")}; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.io.InputStream,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, InputStream source, Map options) throws ATLCoreException {
		final EMFTCSInjector ebnfi = new EMFTCSInjector();
		final Map params = new HashMap();
		params.put("name", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
		params.put("problems", modelFactory.newModel(problemMetamodel)); //$NON-NLS-1$
		if (options != null) {
			params.putAll(options);
		}
		try {
			ebnfi.inject((EMFModel)targetModel, source, params);
		} catch (IOException e) {
			throw new ATLCoreException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, String source, Map options) throws ATLCoreException {
		try {
			FileInputStream fis = new FileInputStream(formatFileName(source));
			inject(targetModel, fis, options);
			fis.close();
		} catch (IOException e) {
			throw new ATLCoreException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void inject(IModel targetModel, String source) throws ATLCoreException {
		inject(targetModel, source, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.io.OutputStream,
	 *      java.util.Map)
	 */
	public void extract(IModel sourceModel, OutputStream target, Map options) throws ATLCoreException {
		final EMFTCSExtractor ebnfe = new EMFTCSExtractor();
		final Map params = new HashMap();
		params.put("format", atlTcsModel); //$NON-NLS-1$
		params.put("indentString", " "); //$NON-NLS-1$ //$NON-NLS-2$
		params.put("identEsc", "'"); //$NON-NLS-1$ //$NON-NLS-2$
		params.put("stringDelim", "'"); //$NON-NLS-1$//$NON-NLS-2$
		params.put("serializeComments", "true"); //$NON-NLS-1$//$NON-NLS-2$
		if (options != null) {
			params.putAll(options);
		}
		ebnfe.extract((EMFModel)sourceModel, target, params);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void extract(IModel sourceModel, String target, Map options) throws ATLCoreException {
		try {
			FileOutputStream fos = new FileOutputStream(formatFileName(target));
			extract(sourceModel, fos, options);
			fos.close();
		} catch (IOException e) {
			throw new ATLCoreException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void extract(IModel sourceModel, String target) throws ATLCoreException {
		extract(sourceModel, target, null);
	}

	private static String formatFileName(String fileName) {
		if (fileName.startsWith("file:")) { //$NON-NLS-1$
			return fileName.substring(5);
		}
		return fileName;
	}

}
