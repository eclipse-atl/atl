/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.api.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.eclipse.m2m.atl.tests.AtlTestsMessages;
import org.eclipse.m2m.atl.tests.TestException;

/**
 * Utility class for models.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class ModelUtils {
	/** Constant for the file encoding system property. */
	private static final String ENCODING_PROPERTY = "file.encoding"; //$NON-NLS-1$

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private ModelUtils() {
		// prevents instantiation
	}

	/**
	 * Loads a model from a {@link java.io.File File} in a given {@link ResourceSet}.
	 * 
	 * @param file
	 *            where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The model loaded from the URI.
	 * @throws IOException
	 *             If the given file does not exist.
	 */
	public static Resource load(File file, ResourceSet resourceSet) throws IOException {
		URI modelURI = URI.createFileURI(file.getPath());

		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Object resourceFactory = reg.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
					resourceFactory);
		} else {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
					new XMIResourceFactoryImpl());
		}

		final Resource result = resourceSet.createResource(modelURI);
		final Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty(ENCODING_PROPERTY));
		result.load(options);
		return result;
	}

	private static Set getElementsByType(Resource extent, String type) {
		Set ret = new HashSet();
		for (Iterator i = extent.getAllContents(); i.hasNext();) {
			EObject eo = (EObject)i.next();
			if (eo.eClass().getName().equals(type)) {
				ret.add(eo);
			}
		}
		return ret;
	}

	/**
	 * Metamodel register : allows to open/compare specific models.
	 * 
	 * @param metamodelURI the metamodel uri
	 * @param resourceSet the resource set
	 * @throws IOException
	 */
	public static void registerMetamodel(URI metamodelURI, ResourceSet resourceSet) throws IOException {
		if (EPackage.Registry.INSTANCE.getEPackage(metamodelURI.toString()) != null) {
			return;
		}
		Resource.Factory myEcoreFactory = new EcoreResourceFactoryImpl();
		Resource mmExtent = myEcoreFactory.createResource(metamodelURI);
		try {
			mmExtent.load(new FileInputStream(metamodelURI.toFileString()), Collections.EMPTY_MAP);
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		for (Iterator it = getElementsByType(mmExtent, "EPackage").iterator(); it.hasNext();) { //$NON-NLS-1$
			EPackage p = (EPackage)it.next();
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			EPackage.Registry.INSTANCE.put(nsURI, p);
		}

		for (Iterator it = getElementsByType(mmExtent, "EDataType").iterator(); it.hasNext();) { //$NON-NLS-1$
			EObject eo = (EObject)it.next();
			EStructuralFeature sf;
			sf = eo.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
			String tname = (String)eo.eGet(sf);
			String icn = null;
			if (tname.equals("Boolean")) { //$NON-NLS-1$
				icn = "java.lang.Boolean"; //$NON-NLS-1$
			} else if (tname.equals("Double")) { //$NON-NLS-1$
				icn = "java.lang.Double"; //$NON-NLS-1$
			} else if (tname.equals("Float")) { //$NON-NLS-1$
				icn = "java.lang.Float"; //$NON-NLS-1$
			} else if (tname.equals("Integer")) { //$NON-NLS-1$
				icn = "java.lang.Integer"; //$NON-NLS-1$
			} else if (tname.equals("String")) { //$NON-NLS-1$
				icn = "java.lang.String"; //$NON-NLS-1$
			}

			if (icn != null) {
				sf = eo.eClass().getEStructuralFeature("instanceClassName"); //$NON-NLS-1$
				eo.eSet(sf, icn);
			}
		}
	}

	/**
	 * Saves a model as a file to the given path.
	 * 
	 * @param root
	 *            Root of the objects to be serialized in a file.
	 * @param path
	 *            File where the objects have to be saved.
	 * @throws IOException
	 *             Thrown if an I/O operation has failed or been interrupted during the saving process.
	 */
	public static void save(EObject root, String path) throws IOException {
		final URI modelURI = URI.createURI(path);
		// final ResourceSet resourceSet = AtlTestPlugin.getResourceSet();
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		final Resource newModelResource = resourceSet.createResource(modelURI);
		newModelResource.getContents().add(root);
		final Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty(ENCODING_PROPERTY));
		newModelResource.save(options);
	}

	/**
	 * Serializes the given EObjet as a String.
	 * 
	 * @param root
	 *            Root of the objects to be serialized.
	 * @return The given EObjet serialized as a String.
	 * @throws IOException
	 *             Thrown if an I/O operation has failed or been interrupted during the saving process.
	 */
	public static String serialize(EObject root) throws IOException {
		if (root == null) {
			throw new NullPointerException("ModelUtils.NullSaveRoot"); //$NON-NLS-1$
		}

		final XMIResourceImpl newResource = new XMIResourceImpl();
		final StringWriter writer = new StringWriter();
		newResource.getContents().add(root);
		newResource.save(writer, Collections.EMPTY_MAP);
		return writer.toString();
	}

	/**
	 * Compare two ecore files as models.
	 * 
	 * @param leftUri the left file uri
	 * @param rightUri the right file uri
	 * @param ignoreIds if <code>true</code>, ignore xmi ids
	 * @param delete if <code>true</code>, delete the right file after comparison
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void compareModels(File leftUri, File rightUri, boolean ignoreIds, boolean delete)
			throws IOException, InterruptedException, TestException {
		Resource leftModel = load(leftUri, AtlTestPlugin.getDefault().getResourceSet());
		Resource rightModel = load(rightUri, AtlTestPlugin.getDefault().getResourceSet());

		Map options = new HashMap();
		if (ignoreIds) {
			options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		}
		final MatchModel inputMatch = MatchService.doResourceMatch(leftModel, rightModel, options);
		final DiffModel inputDiff = DiffService.doDiff(inputMatch);

		if (((DiffGroup)inputDiff.getOwnedElements().get(0)).getSubchanges() != 0) {
			ModelInputSnapshot snapshot = DiffFactory.eINSTANCE.createModelInputSnapshot();
			snapshot.setDiff(inputDiff);
			snapshot.setMatch(inputMatch);
			ModelUtils.save(snapshot, "file:/" + leftUri.toString() + ".emfdiff"); //$NON-NLS-1$ //$NON-NLS-2$
			throw new TestException(AtlTestsMessages.getString("AtlTestPlugin.DIFFFAIL")); //$NON-NLS-1$
		}
		if (delete) {
			leftUri.delete();
		}
	}

}
