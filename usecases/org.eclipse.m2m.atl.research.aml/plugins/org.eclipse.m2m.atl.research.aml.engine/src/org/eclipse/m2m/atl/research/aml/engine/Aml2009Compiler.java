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

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.projectors.xml.XMLExtractor;
import org.eclipse.m2m.atl.research.aml.split.EMFSplitter;
import org.eclipse.m2m.atl.research.aml.split.Splitter;
import org.eclipse.m2m.atl.research.aml.tcs.injector.properties.Properties_ANTLR3Lexer;
import org.eclipse.m2m.atl.research.aml.tcs.injector.properties.Properties_ANTLR3Parser;
import org.eclipse.m2m.atl.research.aml.utils.ModelUtils;
import org.eclipse.m2m.research.aml.tcs.injector.ModifiedEMFTCSInjector;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a> 
 * 
 */
public class Aml2009Compiler extends AmlDefaultCompiler {

	private IReferenceModel propertiesMetamodel;
	private IReferenceModel XMLMetamodel;
	private EMFModelFactory emfModelFactory;
	XMLExtractor xmlExtractor;

	private Map<String, InputStream> matchingLibraryMap;

	public Aml2009Compiler() {
		emfModelFactory = (EMFModelFactory) modelFactory;

		matchingCodeMetamodel = AtlParser.getDefault().getAtlMetamodel();
		propertiesMetamodel = new EMFReferenceModel(emfModelFactory
				.getMetametamodel(), emfModelFactory);
		chainCodeMetamodel = new EMFReferenceModel(emfModelFactory
				.getMetametamodel(), emfModelFactory);
		XMLMetamodel = AmlResourceManager.getDefault().getXmlMetamodel();

		xmlExtractor = new XMLExtractor();
		matchingLibraryMap = new HashMap<String, InputStream>();

		try {
			injec.inject(propertiesMetamodel, AmlResourceManager.getDefault()
					.getMetamodel("Properties.ecore").openStream(), null);
			injec.inject(chainCodeMetamodel, AmlResourceManager.getDefault()
					.getMetamodel("AntScripts.ecore").openStream(), null);

		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

	}

	@Override
	protected URL getSemanticAnalyzerURL() {
		// TODO Auto-generated method stub
		return AmlResourceManager.getDefault().getTransformation("AMLWFR.asm");
	}

	@Override
	protected URL getMatchingCodeGeneratorURL() {
		// TODO Auto-generated method stub
		return AmlResourceManager.getDefault().getTransformation("AML2ATL.asm");
	}

	@Override
	protected URL getTransfChainCodeGeneratorURL() {
		// TODO Auto-generated method stub
		return AmlResourceManager.getDefault().getTransformation(
				"AML2AntScripts.asm");
	}

	@Override
	public Map<String, InputStream> getMatchingLibraries() {
		
		matchingLibraryMap.clear();
		
		try {
			InputStream matchingLib = AmlResourceManager.getDefault().getTransformation("AMLLibrary.asm").openStream();
			matchingLibraryMap.put("AMLLibrary", matchingLib);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matchingLibraryMap;
	}

	@Override
	protected String getMatchingCodeMetamodelURL() {
		// TODO Auto-generated method stub

		return "http://www.eclipse.org/gmt/2005/ATL";

	}

	@Override
	protected URL getTransfChainCodeMetamodelURL() {
		// TODO Auto-generated method stub
		return AmlResourceManager.getDefault().getMetamodel(
				getTransfChainCodeMetamodelName() + ".ecore");
	}

	protected String getMatchingCodeMetamodelName() {
		return "ATL";
	}

	protected String getTransfChainCodeMetamodelName() {
		return "AntScripts";
	}

	/**
	 * Extracts executable matching code from matching code model
	 */

	public Map<String, ByteArrayOutputStream> extractMatchingCode(
			IModel matchingCodeModel) {

		Map<String, ByteArrayOutputStream> atlTransfos = new HashMap<String, ByteArrayOutputStream>();

		Splitter splitter = new EMFSplitter();
		Collection<IModel> newModels = splitter.split(matchingCodeModel,
				"Module");

		Map<String, IModel> models = new HashMap<String, IModel>();
		models.put(getMatchingCodeMetamodelName(), matchingCodeMetamodel);
		String atlTransfoName = null;

		for (IModel newModel : newModels) {

			models.put("IN", newModel);

			try {

				ByteArrayOutputStream outNewModel = new ByteArrayOutputStream();
				AtlParser.getDefault().extract(newModel, outNewModel,
						Collections.EMPTY_MAP);

				atlTransfoName = getRootName(newModel);

				atlTransfos.put(atlTransfoName + ".atl", outNewModel);

			} catch (Exception e) {
				// TODO Exception handling
				e.printStackTrace();
			}

		}
		return atlTransfos;

	}

	/**
	 * returns the name of the model root element
	 * 
	 * @param model
	 * @return
	 */
	private String getRootName(IModel model) {

		TreeIterator<EObject> tree = ((EMFModel) model).getResource()
				.getAllContents();
		String name = null;
		if (tree.hasNext()) {
			EObject root = tree.next();
			name = (String) ModelUtils.get(root, "name");
		}

		return name;

	}

	public Map<String, ByteArrayOutputStream> extractTransfChainCode(
			IModel chainCodeModel) {

		Map<String, ByteArrayOutputStream> antFiles = new HashMap<String, ByteArrayOutputStream>();

		String chainName = getRootName(chainCodeModel);

		if (chainName != null) {

			launcher.initialize(Collections.EMPTY_MAP);

			IModel outModel = emfModelFactory.newModel(XMLMetamodel);
			launcher.addInModel(chainCodeModel, "IN", "AntScripts");
			launcher.addOutModel(outModel, "OUT", "XML");

			URL Ant2XMLTransfo = AmlResourceManager.getDefault()
					.getTransformation("AntScript2XML.asm");

			try {
				launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP,
						Ant2XMLTransfo.openStream());
				ByteArrayOutputStream outNewModel = new ByteArrayOutputStream();
				
				xmlExtractor.extract(outModel, outNewModel, Collections.EMPTY_MAP);

				antFiles.put(chainName + ".xml", outNewModel);

			} catch (IOException e) {
				// TODO Exception handling
				e.printStackTrace();
			} catch (ATLCoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return antFiles;

	}

	private URL getPropertiesGeneratorURL() {
		return AmlResourceManager.getDefault().getTransformation(
				"AML2PropertiesFile.asm");
	}

	public IModel compilePropertiesCode(IModel amlModel, IModel propertiesModel) {

		launcher.initialize(Collections.EMPTY_MAP);

		IModel outModel = emfModelFactory.newModel(propertiesMetamodel);

		launcher.addInModel(propertiesModel, "IN", "Properties");

		launcher.addInModel(amlModel, "IN1", "AML");
		launcher.addOutModel(outModel, "OUT", "Properties");

		setLauncherLibraries(getMatchingLibraries());

		try {
			launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP,
					getPropertiesGeneratorURL().openStream());
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		return outModel;
	}

	/**
	 * generates a property file that contains properties required by a matching
	 * transfo chain
	 * 
	 * @param amlModel
	 * @return
	 */

	public ByteArrayOutputStream extractParameterCode(IModel parameterModel) {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		Properties properties = new Properties();

		EMFModel emfModel = (EMFModel) parameterModel;
		Object eClass = emfModel.getReferenceModel().getMetaElementByName(
				"PropertiesFile");
		Set<EObject> propSet = emfModel.getElementsByType(eClass);
		String name;
		String value;

		for (Iterator ite = propSet.iterator(); ite.hasNext();) {
			EObject oPropFile = (EObject) ite.next();
			EList<EObject> lProperties = (EList<EObject>) ModelUtils.get(
					oPropFile, "properties");
			for (Iterator ite2 = lProperties.iterator(); ite2.hasNext();) {
				EObject oProperty = (EObject) ite2.next();
				name = (String) ModelUtils.get(oProperty, "name");
				value = (String) ModelUtils.get(oProperty, "value") == null ? ""
						: (String) ModelUtils.get(oProperty, "value");
				properties.put(name, value);
			}
		}

		try {
			properties.store(out, "Properties");
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		
		return out;

	}

	public IModel injectParameterTextFile(final InputStream in) {

		EMFTCSInjector inj = new ModifiedEMFTCSInjector();
		Map<Object, Object> params = new HashMap<Object, Object>();
		params.put("name", "Properties");
		params.put("lexerClass", Properties_ANTLR3Lexer.class);
		params.put("parserClass", Properties_ANTLR3Parser.class);
		IModel targetmf;
		try {
			targetmf = modelFactory.newModel(propertiesMetamodel);
			inj.inject((EMFModel) targetmf, in, params);
			return targetmf;
		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		return null;

	}

}
