/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.engine;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.research.aml.utils.ResourceUtils;
import org.osgi.framework.Bundle;

/**
 * this class manages internal AML resources, e.g., metamodels, templates, and transformations
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a> 
 */

public class AmlResourceManager {

	public static AmlResourceManager manager;
	public static String metamodelsFolderName = "Metamodels";
	public static String HOTFolderName = "HOTLibrary";
	public static String parsersFolderName = "Parsers";
	public static String libraryFolderName = "Library";
	public static String strategyFolderName = "Strategy";
	public static String transfoFolderName = "Transformations";
	public static String templatesFolderName = "Templates";
	public static String javaSrcFolderName = "match";
	public static String equalMMName = "EqualMM.ecore";
	public static String atlMMName = "ATL.ecore";
	public static String amlMMName = "Aml.ecore";

	public static String xmlMMName = "XML.ecore";
	public static String mainHOTName = "HOT_match.asm";
	private EMFReferenceModel equalMetamodel;
	private EMFReferenceModel km3Metamodel;

	private EMFReferenceModel xmlMetamodel;

	private EMFModelFactory emf;
	private EMFInjector injector;
	private EMFExtractor extractor;

	public EMFExtractor getExtractor() {
		return extractor;
	}

	public EMFInjector getInjec() {
		return injector;
	}

	public static String KM3MMName = "KM3.ecore";

	AmlResourceManager() {
		emf = new EMFModelFactory();
		injector = new EMFInjector();
		extractor = new EMFExtractor();

		equalMetamodel = new EMFReferenceModel((EMFReferenceModel) emf
				.getMetametamodel(), emf);
		//TODO uncomment when ActionExecuteHOT available to user
		//km3Metamodel = new EMFReferenceModel((EMFReferenceModel) emf
		//		.getMetametamodel(), emf);
		xmlMetamodel = new EMFReferenceModel((EMFReferenceModel) emf
				.getMetametamodel(), emf);
		try {
			injector.inject(equalMetamodel, getMetamodel(equalMMName)
					.openStream(), null);
			//injector.inject(km3Metamodel, getMetamodel(KM3MMName).openStream(),
			//		null);

			injector.inject(xmlMetamodel, getMetamodel(xmlMMName).openStream(),
					null);
		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

	}

	public static AmlResourceManager getDefault() {
		if (manager == null) {

			manager = new AmlResourceManager();
		}

		return manager;
	}

	public ByteArrayInputStream getTemplate(String path, Map substitutions)
			throws IOException {

		String ret = getStringFromInputStream(getInputStream(path));
		for (Iterator i = substitutions.keySet().iterator(); i.hasNext();) {
			String key = (String) i.next();
			String value = (String) substitutions.get(key);
			ret = ret.replaceAll("\\$\\{" + key + "}", value);
		}
		return new ByteArrayInputStream(ret.getBytes());
	}

	public BufferedInputStream getInputStream(String path) throws IOException {

		URL templateURL = getResource(path);
		BufferedInputStream in = new BufferedInputStream(templateURL
				.openStream());
		return in;
		
	}

	public String getStringFromInputStream(BufferedInputStream in)
			throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int size;
		byte buffer[] = new byte[1000];
		while ((size = in.read(buffer)) > 0) {
			out.write(buffer, 0, size);
		}
		String ret = out.toString();
		return ret;
	}

	public String[] getFolderContent(String path) throws URISyntaxException,
			IOException {

		URL dirURL = getResource(path);
		URL fileURL = FileLocator.toFileURL(dirURL);
		if (fileURL != null && fileURL.getProtocol().equals("file")) {
			/* A file path: easy enough */
			return new File(fileURL.toURI()).list();
		}

		return null;

	}

	public URL getMetamodel(String metamodelName) {
		return getResource(ResourceUtils.getPathWithSeparator(
				metamodelsFolderName, metamodelName));
	}

	public URL getTransformation(String metamodelName) {
		return getResource(ResourceUtils.getPathWithSeparator(
				transfoFolderName, metamodelName));
	}

	public URL getParser(String parserName) {
		return getResource(ResourceUtils.getPathWithSeparator(
				parsersFolderName, parserName));
	}

	public URL getHOT(String HOTName) {
		return getResource(ResourceUtils.getPathWithSeparator(HOTFolderName,
				HOTName));
	}

	public URL getATLLibrary(String AtlModuleName) {
		return getResource(ResourceUtils.getPathWithSeparator(
				libraryFolderName, AtlModuleName));
	}

	public URL getTemplate(String templateName) {
		return getResource(ResourceUtils.getPathWithSeparator(
				templatesFolderName, templateName));
	}

	public URL getPropertiesFile(String propertiesFileName) {
		return getResource(propertiesFileName);
	}

	private URL getResource(String path) {
		Bundle bundle = AmlEnginePlugin.getDefault().getBundle();
		return bundle.getResource(path);
	}

	/**
	 * loads model conforming to the internal metamodels
	 * 
	 * @param modelLoc
	 * @param refModel
	 * @return
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	public EMFModel loadModel(String modelLoc, EMFReferenceModel refModel)
			throws ATLCoreException, IOException {

		FileInputStream modelFile = new FileInputStream(modelLoc);

		EMFModel model = (EMFModel) emf.newModel(refModel);
		injector.inject(model, modelFile, null);

		return model;

	}

	public EMFReferenceModel getEqualMetamodel() {

		return equalMetamodel;
	}

	public EMFReferenceModel getKM3Metamodel() {

		return km3Metamodel;
	}

	public EMFReferenceModel getXmlMetamodel() {
		return xmlMetamodel;

	}

	public EMFModelFactory getModelFactory() {
		return emf;
	}

}
