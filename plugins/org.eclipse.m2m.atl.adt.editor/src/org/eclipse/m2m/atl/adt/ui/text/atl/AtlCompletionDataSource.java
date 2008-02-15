/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.swt.graphics.Image;

/**
 * The AtlCompletionDataSource, retrieves data from EMF metamodels.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlCompletionDataSource {

	private final static ResourceSet resourceSet = new ResourceSetImpl();

	/** URI tag value. */
	public final static String URI_TAG = "nsURI"; //$NON-NLS-1$
	/** PATH tag value. */
	public final static String PATH_TAG = "path"; //$NON-NLS-1$

	/** The main editor, containing the outline model. */
	private AtlEditor fEditor;

	/** The detected metamodels Map<id,List<EPackage>>. */
	private Map metamodels;

	/** Input metamodels ids list. */
	private List inputMetamodelsIds;

	/** Output metamodels ids list. */
	private List outputMetamodelsIds;

	/**
	 * Metamodel filter types : 
	 * 0 : input + output metamodels 
	 * 1 : input metamodels 
	 * 2 : output metamodels
	 */
	public final static int ALL_METAMODELS = 0;
	public final static int INPUT_METAMODELS = 1;
	public final static int OUTPUT_METAMODELS = 2;

	/**
	 * Constructor.
	 * 
	 * @param editor
	 */
	public AtlCompletionDataSource(AtlEditor editor) {
		super();
		fEditor = editor;
	}

	/**
	 * Status method.
	 * 
	 * @return <code>True</code> if the some metamodels have ever been
	 *         detected , <code>False</code> if not.
	 */
	public boolean initialized() {
		return metamodels != null;
	}

	/**
	 * Update method : parsing and metamodel detection
	 * 
	 */
	public void updateDataSource() {
		String text = fEditor.getEditorInputContent();
		try {
			parseMetamodels(text);	
		} catch (IOException e) {
			//TODO apply marker on the file
			AtlUIPlugin.log(e);
		}
	}

	/**
	 * Parsing method : detects uris and stores metamodels.
	 * 
	 * @param text the atl file.
	 * @throws IOException
	 */
	private void parseMetamodels(String text) throws IOException {
		metamodels = new HashMap();
		inputMetamodelsIds = new ArrayList();
		outputMetamodelsIds = new ArrayList();
		byte[] buffer = text.getBytes();
		int length = buffer.length;
		BufferedReader brin = new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(buffer, 0, length)));

		List uris = getTaggedInformations(brin, URI_TAG);
		for (Iterator iterator = uris.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			if (line.split("=").length == 2) { //$NON-NLS-1$
				String name = line.split("=")[0].trim(); //$NON-NLS-1$
				String uri = line.split("=")[1].trim(); //$NON-NLS-1$
				if (uri != null && uri.length() > 0) {
					uri = uri.trim();

					//EPackage registration
					EPackage regValue = EPackage.Registry.INSTANCE.getEPackage(uri);
					if (regValue != null) {
						ArrayList list = new ArrayList();
						list.add(regValue);
						metamodels.put(name, list );
					}
				}
			}
		}

		List paths = getTaggedInformations(brin, PATH_TAG);
		for (Iterator iterator = paths.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			if (line.split("=").length == 2) { //$NON-NLS-1$
				String name = line.split("=")[0].trim(); //$NON-NLS-1$
				String path = line.split("=")[1].trim(); //$NON-NLS-1$
				if (path != null && path.length() > 0) {
					path = path.trim();
					Resource resource = (Resource) load(URI.createPlatformResourceURI(path, true), resourceSet);
					if (resource != null) {
						ArrayList list = new ArrayList();
						for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
							Object object = (Object) it.next();
							if (object instanceof EPackage)
								list.add(object);				
						}
						metamodels.put(name, list);
					}
				}
			}
		}

		if (fEditor.getOutlinePage() == null) {
			inputMetamodelsIds = null;
			outputMetamodelsIds = null;
			return;
		}
		//outline editor, updated on each save
		EObject model = fEditor.getOutlinePage().getModel();

		if (model.eClass().getName().equals("Module")) {
			//input models computation
			EList inModels = (EList) eGet(model, "inModels"); //$NON-NLS-1$
			if (inModels != null) {
				for (Iterator iterator = inModels.iterator(); iterator.hasNext();) {
					EObject me = (EObject) iterator.next();
					EObject mm = (EObject) eGet(me,"metamodel"); //$NON-NLS-1$
					inputMetamodelsIds.add(eGet(mm,"name").toString()); //$NON-NLS-1$
				}			
			}

			//output models computation
			EList outModels = (EList) eGet(model,"outModels"); //$NON-NLS-1$
			if (outModels != null) {
				for (Iterator iterator = outModels.iterator(); iterator.hasNext();) {
					EObject me = (EObject) iterator.next();
					EObject mm = (EObject) eGet(me,"metamodel"); //$NON-NLS-1$
					outputMetamodelsIds.add(eGet(mm,"name").toString()); //$NON-NLS-1$
				}			
			}
		}
	}

	/**
	 * Computes proposals for EMF uris.
	 * @param prefix
	 * @param offset
	 * @return the proposals
	 */
	public List getURIProposals(String prefix, int offset) {
		List res = new ArrayList();
		Set uris = EPackage.Registry.INSTANCE.keySet();
		for (Iterator iterator = uris.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			String replacementString = object.toString();
			if (startsWithIgnoreCase(prefix, replacementString)) {
				ICompletionProposal proposal = new AtlCompletionProposal(
						replacementString, offset - prefix.length(),
						replacementString.length(), null, replacementString, 0);
				res.add(proposal);
			}
		}
		Collections.sort(res);
		return res;
	}

	/**
	 * Metamodels access method.
	 * 
	 * @param filter
	 * @return the map of searched metamodels
	 */
	private Map getMetamodelPackages(int filter) {
		if (inputMetamodelsIds == null && outputMetamodelsIds == null) {
			return metamodels;
		}
		switch (filter) {
		case INPUT_METAMODELS:
			Map inputres = new HashMap();
			for (Iterator iterator = inputMetamodelsIds.iterator(); iterator
			.hasNext();) {
				String id = (String) iterator.next();
				inputres.put(id, metamodels.get(id));
			}
			return inputres;
		case OUTPUT_METAMODELS:
			Map outputres = new HashMap();
			for (Iterator iterator = outputMetamodelsIds.iterator(); iterator
			.hasNext();) {
				String id = (String) iterator.next();
				outputres.put(id, metamodels.get(id));
			}
			return outputres;
		}
		//default case
		return metamodels;
	}

	/**
	 * Access on a specific metamodel.
	 * 
	 * @param metamodelId
	 * @return
	 */
	private List getMetamodelPackages(String metamodelId) {
		return (List) metamodels.get(metamodelId);
	}

	/**
	 * Metamodel elements proposals for a given filter.
	 * 
	 * @param prefix completion prefix
	 * @param offset completion offset
	 * @param filter the given filter
	 * @return the filtered proposals
	 */
	public List getMetaElementsProposals(String prefix, int offset, int filter) {
		List res = new ArrayList();
		Set entries = getMetamodelPackages(filter).entrySet();
		//input or output metamodels
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String metamodelName = entry.getKey().toString();
			List packages = (List) entry.getValue();
			if (packages != null) {
				//packages of the current metamodel
				for (Iterator it = packages.iterator(); it.hasNext();) {
					EPackage metamodel = (EPackage) it.next();
					res.addAll(getMetaElementsProposals(metamodelName, metamodel,
							prefix, offset));
				}				
			}
		}
		return res;
	}

	/**
	 * Metamodel elements proposals for a given metamodel.
	 * 
	 * @param metamodelName
	 * @param metamodel
	 * @param prefix completion prefix
	 * @param offset completion offset
	 * @return the proposals
	 */
	private List getMetaElementsProposals(String metamodelName,
			EPackage metamodel, String prefix, int offset) {
		List res = new ArrayList();

		//classifiers computation
		Collection classifiers = new TreeSet(new Comparator() {
			public int compare(Object arg0, Object arg1) {
				EClassifier c0 = ((EClassifier) arg0);
				EClassifier c1 = ((EClassifier) arg1);
				return getEClassifierShortPath(c0, false).compareTo(
						getEClassifierShortPath(c1, false));
			}
		});
		classifiers.addAll(computeAllClassifiersList(metamodel));

		// adds classifiers with a "normal" formalism : MM!ME
		for (Iterator iterator = classifiers.iterator(); iterator.hasNext();) {
			EClassifier classifier = (EClassifier) iterator.next();
			String replacementString = metamodelName + "!" //$NON-NLS-1$
			+ getEClassifierShortPath(classifier, false);
			if (startsWithIgnoreCase(prefix, replacementString)
					&& !prefix.equals(replacementString)) {
				Image image = getImage("model_class.gif"); //$NON-NLS-1$
				ICompletionProposal proposal = new AtlCompletionProposal(
						replacementString, offset - prefix.length(),
						replacementString.length(), image, replacementString, 0);
				res.add(proposal);
			}
		}

		/*
		// adds classifiers with a different formalism : MM!"pck::ME"
		for (Iterator iterator = classifiers.iterator(); iterator.hasNext();) {
			EClassifier classifier = (EClassifier) iterator.next();
			String replacementString = metamodelName + "!" //$NON-NLS-1$
			+ getEClassifierShortPath(classifier, true);
			if (startsWithIgnoreCase(prefix, replacementString)
					&& !prefix.equals(replacementString)) {
				Image image = getImage("model_class.gif"); //$NON-NLS-1$
				ICompletionProposal proposal = new AtlCompletionProposal(
						replacementString, offset - prefix.length(),
						replacementString.length(), image, replacementString, 0);
				res.add(proposal);
			}
		}
		*/

		Collections.sort(res);
		return res;
	}

	private static List computeAllClassifiersList(EPackage ePackage) {
		List classifiers = new BasicEList();
		if (ePackage != null)
			computeAllClassifiersList(ePackage, classifiers);
		return classifiers;
	}

	private static void computeAllClassifiersList(EPackage ePackage, List all) {
		Iterator classifiers = ePackage.getEClassifiers().iterator();
		while (classifiers.hasNext()) {
			EClassifier classifier = (EClassifier) classifiers.next();
			if (classifier instanceof EClass
					&& !((EClass) classifier).isAbstract()
					&& !((EClass) classifier).isInterface()) {
				all.add(classifier);
			}
		}
		Iterator packages = ePackage.getESubpackages().iterator();
		while (packages.hasNext()) {
			computeAllClassifiersList((EPackage) packages.next(), all);
		}
	}

	/**
	 * Features proposals for a given MetaElement.
	 * 
	 * @param existing the list of features that have ever been typed
	 * @param atlType the type under its "OclModelElement" form
	 * @param prefix completion prefix
	 * @param offset completion offset
	 * @return the proposals
	 */
	public List getMetaFeaturesProposals(List existing, EObject atlType,
			String prefix, int offset) {
		EObject model = (EObject) eGet(atlType,"model"); //$NON-NLS-1$
		String metamodelId = eGet(model,"name").toString(); //$NON-NLS-1$
		List packages = getMetamodelPackages(metamodelId);
		if (packages != null) {
			for (Iterator iterator = packages.iterator(); iterator.hasNext();) {
				EPackage pack = (EPackage) iterator.next();
				EClassifier res = pack.getEClassifier(eGet(atlType,"name").toString()); //$NON-NLS-1$
				if (res instanceof EClass) {
					return getMetaFeaturesProposals(existing, (EClass) res, prefix,
							offset);
				}
			}
		}
		return new ArrayList();
	}

	/**
	 * Features proposals for a given MetaElement.
	 * 
	 * @param existing the list of features that have ever been typed
	 * @param modelElement the EMF type
	 * @param prefix completion prefix
	 * @param offset completion offset
	 * @return the proposals
	 */
	private List getMetaFeaturesProposals(List existing, EClass modelElement,
			String prefix, int offset) {
		List res = new ArrayList();
		if (modelElement instanceof EClass) {
			EClass type = (EClass) modelElement;
			Collection features = new TreeSet(new Comparator() {
				public int compare(Object arg0, Object arg1) {
					EStructuralFeature f0 = ((EStructuralFeature) arg0);
					EStructuralFeature f1 = ((EStructuralFeature) arg1);
					return f0.getName().compareTo(f1.getName());
				}
			});
			features.addAll(((EClass) type).getEAllStructuralFeatures());
			for (Iterator iterator = features.iterator(); iterator.hasNext();) {
				EStructuralFeature feature = (EStructuralFeature) iterator
				.next();
				String replacementString = feature.getName();
				if (!existing.contains(replacementString)) {
					if (startsWithIgnoreCase(prefix, replacementString)
							&& !prefix.equals(replacementString)) {
						Image image = null;
						if (feature.isChangeable()) {
							if (feature instanceof EAttribute)
								image = getImage("model_attribute.gif"); //$NON-NLS-1$
							else if (feature instanceof EReference)
								image = getImage("model_reference.gif"); //$NON-NLS-1$
							ICompletionProposal proposal = new AtlCompletionProposal(
									replacementString, offset - prefix.length(),
									replacementString.length(), image,
									replacementString, 0);
							res.add(proposal);
						}
					}
				}
			}
		}
		Collections.sort(res);
		return res;
	}

	/**
	 * Computes types completion for helper, i.e. primitive types and all metamodels types
	 * 
	 * @param prefix completion prefix
	 * @param offset completion offset
	 * @return the proposals
	 */
	public List getHelperTypesProposals(String prefix, int offset) {
		List res = new ArrayList();
		res.addAll(getMetaElementsProposals(prefix, offset,
				AtlCompletionDataSource.ALL_METAMODELS));
		String[] types = { "Boolean", "String", "Integer", "Sequence", "Set", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				"Bag", "OrderedSet", "Map" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		for (int i = 0; i < types.length; i++) {
			String replacementString = types[i];
			if (startsWithIgnoreCase(prefix, replacementString)) {
				ICompletionProposal proposal = new AtlCompletionProposal(
						replacementString, offset - prefix.length(),
						replacementString.length(), null, replacementString, 0);
				res.add(proposal);
			}
		}
		return res;
	}

	/**
	 * Computes the type of a given variable in a given rule. Uses the outline model for that.
	 * 
	 * @param ruleName
	 * @param variableName
	 * @return the type of the variable
	 */
	public EObject getVariableType(String ruleName, String variableName) {
		EObject model = fEditor.getOutlinePage().getModel();
		EList contents = model.eContents();
		for (Iterator iterator = contents.iterator(); iterator.hasNext();) {
			EObject object = (EObject) iterator.next();
			if (object.eClass().getName().equals("MatchedRule")) { //$NON-NLS-1$
				if (ruleName.equals(eGet(object,"name"))) { //$NON-NLS-1$
					TreeIterator ruleContentsIterator = object.eAllContents();
					while (ruleContentsIterator.hasNext()) {
						EObject content = (EObject) ruleContentsIterator.next();
						if (content.eClass().getName().equals(
						"SimpleInPatternElement")) { //$NON-NLS-1$
							if (variableName.equals(eGet(content,"varName"))) { //$NON-NLS-1$
								return (EObject) eGet(content,"type"); //$NON-NLS-1$
							}
						}
					}

				}
			}
		}

		return null;
	}

	/**
	 * startsWithIgnoreCase method, i.e. equalsIgnoreCase and startsWith mix.
	 * @param prefix
	 * @param replacementString
	 * @return <code>True</code> if the replacementString starts with the prefix, without checking the case, <code>False</code> else.
	 */
	private static boolean startsWithIgnoreCase(String prefix,
			String replacementString) {
		if (replacementString.length() >= prefix.length()) {
			String tmp = replacementString.substring(0, prefix.length());
			return tmp.equalsIgnoreCase(prefix);
		}
		return false;
	}

	/**
	 * Generates a non-ambiguous name for a classifier.
	 * 
	 * @param eClassifier
	 * @param mode <code>True</code> if the classifier needs to have the form "pck::name", <code>False</code> else.
	 * @return the short path.
	 */
	private static String getEClassifierShortPath(EClassifier eClassifier,
			boolean mode) {
		String name = eClassifier.getName();
		if (eClassifier.getEPackage() != null && mode)
			name = "\"" + eClassifier.getEPackage().getName() + "::" + name //$NON-NLS-1$ //$NON-NLS-2$
			+ "\""; //$NON-NLS-1$
		return name;
	}

	/**
	 * Gets the image at the given plug-in relative path.
	 */
	private static Map path2image = new HashMap();

	/**
	 * Looks for an image in the icons folder.
	 * 
	 * @param path
	 * @return the searched Image
	 */
	public static Image getImage(String path) {
		Image result = (Image) path2image.get(path);
		if (result == null && !path2image.containsKey(path)) {
			ImageDescriptor descriptor = AtlUIPlugin.getImageDescriptor(path);
			if (descriptor != null) {
				result = descriptor.createImage();
			} else {
				result = null;
			}
			path2image.put(path, result);
		}
		if (result.isDisposed()) {
			result = null;
		}
		return result;
	}

	public static List getTaggedInformations(BufferedReader reader, String tag) throws IOException {
		reader.mark(1000);
		List res = new ArrayList();
		while (reader.ready()) {
			String line = reader.readLine();
			//code begins, uris checking stops.
			if (line == null || line.startsWith("library") //$NON-NLS-1$
					|| line.startsWith("module") || line.startsWith("query")) { //$NON-NLS-1$ //$NON-NLS-2$
				break;
			} else {
				if (line.trim().startsWith("-- @" + tag)) { //$NON-NLS-1$
					line = line.replaceFirst("^\\p{Space}*--\\p{Space}*@" //$NON-NLS-1$
							+ tag
							+ "\\p{Space}+([^\\p{Space}]*)\\p{Space}*$", "$1"); //$NON-NLS-1$ //$NON-NLS-2$
					res.add(line);
				}
			}
		}
		reader.reset();
		return res;
	}

	/**
	 * Loads a model from an {@link org.eclipse.emf.common.util.URI URI} in a given {@link ResourceSet}.
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The packages of the model loaded from the URI.
	 * @throws IOException
	 *             If the given file does not exist.
	 */
	public static Resource load(URI modelURI, ResourceSet resourceSet) throws IOException {
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

		final Resource modelResource = resourceSet.createResource(modelURI);
		final Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty("file.encoding")); //$NON-NLS-1$
		modelResource.load(options);
		return modelResource;
	}

	public static Object eGet(EObject self, String featureName) {
		EStructuralFeature feature = self.eClass().getEStructuralFeature(featureName);
		if (feature != null) {
			return self.eGet(feature);
		}
		return null;
	}
}
