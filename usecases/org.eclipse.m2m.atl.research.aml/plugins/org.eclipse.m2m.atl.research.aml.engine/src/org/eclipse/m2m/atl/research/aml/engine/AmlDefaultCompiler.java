/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.engine;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.research.aml.tcs.injector.aml.AML_ANTLR3Lexer;
import org.eclipse.m2m.atl.research.aml.tcs.injector.aml.AML_ANTLR3Parser;
import org.eclipse.m2m.atl.research.aml.utils.ResourceUtils;
import org.eclipse.m2m.research.aml.tcs.injector.ModifiedEMFTCSInjector;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 * 
 */
abstract public class AmlDefaultCompiler implements AmlStandaloneCompiler {

	protected IReferenceModel matchingCodeMetamodel;
	protected IReferenceModel chainCodeMetamodel;
	protected ModelFactory modelFactory;
	protected IReferenceModel AMLMetamodel;
	protected IInjector injec;
	protected IExtractor extractor;
	protected ILauncher launcher;
	protected IReferenceModel problemMetamodel;

	public AmlDefaultCompiler() {
		launcher = new EMFVMLauncher();
		modelFactory = AmlResourceManager.getDefault().getModelFactory();
		injec = new EMFInjector();

		problemMetamodel = AtlParser.getDefault().getProblemMetamodel();
		AMLMetamodel = new EMFReferenceModel((EMFReferenceModel) modelFactory
				.getMetametamodel(), (EMFModelFactory) modelFactory);

		try {
			injec.inject(AMLMetamodel, AmlResourceManager.getDefault()
					.getMetamodel("AML.ecore").openStream(), null);
		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

	}

	public IReferenceModel getAmlMetamodel() {
		return AMLMetamodel;
	}

	@Override
	public IModel compileMatchingCode(IModel in) {

		launcher.initialize(Collections.EMPTY_MAP);

		IModel out = null;
		try {
			out = modelFactory.newModel(matchingCodeMetamodel);

			launcher.addInModel(in, "IN", "AML");

			launcher.addOutModel(out, "OUT", getMatchingCodeMetamodelName());

			setLauncherLibraries(getMatchingLibraries());
			launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP,
					getMatchingCodeGeneratorURL().openStream());
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		return out;

	}

	protected void setLauncherLibraries(Map<String, InputStream> libraries) {

		for (Iterator<Entry<String, InputStream>> iterator = libraries
				.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, InputStream> library = iterator.next();
			launcher.addLibrary(library.getKey(), library.getValue());
		}

	}

	@Override
	public IModel compileTransfChainCode(IModel in) {
		launcher.initialize(Collections.EMPTY_MAP);

		try {

			IModel out = modelFactory.newModel(chainCodeMetamodel);
			launcher.addInModel(AMLMetamodel, "AML", "#EMF");
			launcher.addInModel(in, "IN", "AML");
			launcher.addOutModel(chainCodeMetamodel,
					getTransfChainCodeMetamodelName(), "#EMF");
			launcher.addOutModel(out, "OUT", getTransfChainCodeMetamodelName());

			Map<String, Object> options = new HashMap<String, Object>();
			options.put("extensions", "match.AML2AntScriptsUtils");
			options.put("extraClasspath", "bin");

			Bundle amlEngineBundle = Platform
					.getBundle(AmlEnginePlugin.PLUGIN_ID);
			URL amlEnginePluginUrl = FileLocator.resolve(amlEngineBundle
					.getEntry(ResourceUtils.fileSeparator));

			options.put("user.dir", amlEnginePluginUrl.getPath());			
			options.put("wsPath", ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());

			setLauncherLibraries(getMatchingLibraries());

			launcher.launch(launcher.RUN_MODE, null, options,
					getTransfChainCodeGeneratorURL().openStream());

			return out;
		} catch (ATLCoreException e) {
			// TODO Exception handling
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public IModel[] injectAMLTextFile(final InputStream in)
			throws ATLCoreException {

		EMFTCSInjector inj = new ModifiedEMFTCSInjector();
		Map<Object, Object> params = new HashMap<Object, Object>();
		params.put("name", "AML");
		params.put("lexerClass", AML_ANTLR3Lexer.class);
		params.put("parserClass", AML_ANTLR3Parser.class);
		
		IModel pbs = modelFactory.newModel(problemMetamodel);
		params.put("problems", pbs);

		IModel targetmf = null;
		try {
			targetmf = modelFactory.newModel(AMLMetamodel);
			inj.inject((EMFModel) targetmf, in, params);
			
			EObject[] oPbs = AmlModelUtils.getDefault().getProblems(pbs);
			if(oPbs.length == 0) { // let's make semantic analysis
				
				pbs = getSemanticProblems(targetmf);
				
			}

		} catch (IOException e) {
			// fail silently
		}
		// TODO change the way to store injected aml model and problem model
		return new IModel[] { targetmf, pbs };

	}
	
	private IModel getSemanticProblems (IModel amlModel) throws ATLCoreException, IOException{
		
		launcher.initialize(Collections.EMPTY_MAP);
		
		IModel out = modelFactory.newModel(problemMetamodel);
		launcher.addInModel(amlModel, "IN", "AML");
		launcher.addOutModel(out, "OUT", "Problem");
		
		launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP,
				getSemanticAnalyzerURL().openStream());
		
		return out;
		
	}

	/**
	 * Returns the AML WFR URL (whatever that may be); to be implemented by
	 * concrete subclass.
	 * 
	 * @return the URL
	 */
	protected abstract URL getSemanticAnalyzerURL();

	/**
	 * Returns the URL of the ATL transformation that compiles AML code into
	 * matching model transformations; to be implemented by concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	protected abstract URL getMatchingCodeGeneratorURL();

	/**
	 * Returns the URL of the ATL transformation that compiles AML code into
	 * transformation chain code; to be implemented by concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	protected abstract URL getTransfChainCodeGeneratorURL();

	/**
	 * Returns the URL of the metamodel representing executable matching logic;
	 * to be implemented by concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	protected abstract String getMatchingCodeMetamodelURL();

	/**
	 * Returns the URL of the metamodel representing executable transformation
	 * chain; to be implemented by concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	protected abstract URL getTransfChainCodeMetamodelURL();

	protected abstract String getMatchingCodeMetamodelName();

	protected abstract String getTransfChainCodeMetamodelName();

	/**
	 * Returns a map with the libraries required by matching compilation
	 * concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	public abstract Map<String, InputStream> getMatchingLibraries();

}
