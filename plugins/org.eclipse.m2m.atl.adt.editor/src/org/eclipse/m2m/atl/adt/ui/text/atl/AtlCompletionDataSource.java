/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *     INRIA - additionalProposalInfo implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.swt.graphics.Image;

/**
 * The AtlCompletionDataSource, retrieves data from EMF metamodels.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class AtlCompletionDataSource {

	/**
	 * Gets the image at the given plug-in relative path.
	 */
	private static Map path2image = new HashMap();

	/** The main editor, containing the outline model. */
	private AtlEditor fEditor;

	/**
	 * Creates an ATL completion data source.
	 * 
	 * @param editor
	 *            the current ATL editor.
	 */
	public AtlCompletionDataSource(AtlEditor editor) {
		super();
		fEditor = editor;
	}

	/**
	 * Computes proposals for EMF uris.
	 * 
	 * @param prefix
	 *            the current prefix
	 * @param offset
	 *            the current offset
	 * @return the proposals
	 */
	public List getURIProposals(String prefix, int offset) {
		return getProposalsFromList(offset, prefix, EPackage.Registry.INSTANCE.keySet().toArray());
	}

	/**
	 * Computes proposals for EMF paths.
	 * 
	 * @param prefix
	 *            the current prefix
	 * @param offset
	 *            the current offset
	 * @return the proposals
	 */
	public List getPathProposals(String prefix, int offset) {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		final IProject[] projects = root.getProjects();
		final List allFiles = new ArrayList();
		try {
			getWorkspaceEcoreFileNames(projects, allFiles);
		} catch (final CoreException e1) {
			// do nothing -- fail silentlty
		}
		return getProposalsFromList(offset, prefix, allFiles.toArray());
	}

	/**
	 * Get all files contained in a set of resources.
	 * 
	 * @param resources
	 *            the resources to scan
	 * @param fileNames
	 *            the result files
	 * @throws CoreException
	 *             if {@link org.eclipse.core.resources.IContainer#members()} on a resource fails. Reasons
	 *             include:
	 *             <ul>
	 *             <li>This resource does not exist.</li>
	 *             <li>This resource is a project that is not open.</li>
	 *             </ul>
	 */
	private static void getWorkspaceEcoreFileNames(final IResource[] resources, final List fileNames)
			throws CoreException {
		for (int i = 0; i < resources.length; i++) {
			final IResource resource = resources[i];
			if (resource.isAccessible()) {
				if (resource instanceof IFile) {
					if (resource.getFileExtension().equals("ecore")) { //$NON-NLS-1$
						fileNames.add(resource.getFullPath());
					}
				} else if (resource instanceof IProject) {
					getWorkspaceEcoreFileNames(((IProject)resource).members(), fileNames);
				} else if (resource instanceof IFolder) {
					getWorkspaceEcoreFileNames(((IFolder)resource).members(), fileNames);
				}
			}
		}
	}

	/**
	 * Metamodel elements proposals for a given filter.
	 * 
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @param filter
	 *            the given filter
	 * @return the filtered proposals
	 */
	public List getMetaElementsProposals(String prefix, int offset, int filter) {
		List res = new ArrayList();
		Set entries = fEditor.getSourceManager().getMetamodelPackages(filter).entrySet();
		// input or output metamodels
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Entry entry = (Entry)iterator.next();
			String metamodelName = entry.getKey().toString();
			List packages = (List)entry.getValue();
			if (packages != null) {
				// packages of the current metamodel
				for (Iterator it = packages.iterator(); it.hasNext();) {
					EPackage metamodel = (EPackage)it.next();
					res.addAll(getMetaElementsProposals(metamodelName, metamodel, prefix, offset));
				}
			}
		}
		return res;
	}

	/**
	 * Metamodels names proposals.
	 * 
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @return the filtered proposals
	 */
	public Collection getMetamodelsProposals(String prefix, int offset) {
		Set res = new HashSet();
		res.addAll(fEditor.getSourceManager().getInputModels().values());
		res.addAll(fEditor.getSourceManager().getOutputModels().values());
		return getProposalsFromList(offset, prefix, res.toArray());
	}

	/**
	 * Metamodel elements proposals for a given metamodel.
	 * 
	 * @param metamodelName
	 * @param metamodel
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @return the proposals
	 */
	private List getMetaElementsProposals(String metamodelName, EPackage metamodel, String prefix, int offset) {
		List res = new ArrayList();

		// classifiers computation
		Collection classifiers = new TreeSet(new Comparator() {
			public int compare(Object arg0, Object arg1) {
				EClassifier c0 = (EClassifier)arg0;
				EClassifier c1 = (EClassifier)arg1;
				return getEClassifierShortPath(c0, false).compareTo(getEClassifierShortPath(c1, false));
			}
		});
		classifiers.addAll(computeAllClassifiersList(metamodel));

		// adds classifiers with a "normal" formalism : MM!ME
		for (Iterator iterator = classifiers.iterator(); iterator.hasNext();) {
			EClassifier classifier = (EClassifier)iterator.next();
			String replacementString = metamodelName + "!" //$NON-NLS-1$
					+ getEClassifierShortPath(classifier, false);
			if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
				Image image = getImage("model_class.gif"); //$NON-NLS-1$

				StringBuffer additionalProposalInfo = new StringBuffer();
				if (classifier instanceof EClass) {
					EClass cl = (EClass)classifier;
					if (cl.isAbstract()) {
						additionalProposalInfo.append("abstract "); //$NON-NLS-1$
					}
					additionalProposalInfo.append("class "); //$NON-NLS-1$
					additionalProposalInfo.append(cl.getName());
					boolean first = true;
					for (Iterator i = cl.getESuperTypes().iterator(); i.hasNext();) {
						EClass st = (EClass)i.next();
						if (first) {
							additionalProposalInfo.append(" extends\n\t"); //$NON-NLS-1$
							first = false;
						} else {
							additionalProposalInfo.append(",\n\t"); //$NON-NLS-1$
						}
						additionalProposalInfo.append(st.getName());
					}
				}

				ICompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
						- prefix.length(), replacementString.length(), image, replacementString, 0,
						additionalProposalInfo.toString());
				res.add(proposal);
			}
		}

		/*
		 * // adds classifiers with a different formalism : MM!"pck::ME" for (Iterator iterator =
		 * classifiers.iterator(); iterator.hasNext();) { EClassifier classifier = (EClassifier)
		 * iterator.next(); String replacementString = metamodelName + "!" //$NON-NLS-1$ +
		 * getEClassifierShortPath(classifier, true); if (startsWithIgnoreCase(prefix, replacementString) &&
		 * !prefix.equals(replacementString)) { Image image = getImage("model_class.gif"); //$NON-NLS-1$
		 * ICompletionProposal proposal = new AtlCompletionProposal( replacementString, offset -
		 * prefix.length(), replacementString.length(), image, replacementString, 0); res.add(proposal); } }
		 */

		Collections.sort(res);
		return res;
	}

	private static List computeAllClassifiersList(EPackage ePackage) {
		List classifiers = new BasicEList();
		if (ePackage != null) {
			computeAllClassifiersList(ePackage, classifiers);
		}
		return classifiers;
	}

	private static void computeAllClassifiersList(EPackage ePackage, List all) {
		Iterator classifiers = ePackage.getEClassifiers().iterator();
		while (classifiers.hasNext()) {
			EClassifier classifier = (EClassifier)classifiers.next();
			if (classifier instanceof EClass && !((EClass)classifier).isInterface()) {
				all.add(classifier);
			}
		}
		Iterator packages = ePackage.getESubpackages().iterator();
		while (packages.hasNext()) {
			computeAllClassifiersList((EPackage)packages.next(), all);
		}
	}

	/**
	 * Features proposals for a given MetaElement.
	 * 
	 * @param existing
	 *            the list of features that have ever been typed
	 * @param atlType
	 *            the type under its "OclModelElement" form
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @return the proposals
	 */
	public List getMetaFeaturesProposals(List existing, EObject atlType, String prefix, int offset) {
		if (atlType != null) {
			EClassifier res = getEClassifierFromAtlType(atlType);
			if (res instanceof EClass) {
				return getMetaFeaturesProposals(existing, (EClass)res, prefix, offset);
			}
		}
		return new ArrayList();
	}

	/**
	 * Features proposals for a given MetaElement.
	 * 
	 * @param existing
	 *            the list of features that have ever been typed
	 * @param modelElement
	 *            the EMF type
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @return the proposals
	 */
	private List getMetaFeaturesProposals(List existing, EClass type, String prefix, int offset) {
		List res = new ArrayList();
		Collection features = new TreeSet(new Comparator() {
			public int compare(Object arg0, Object arg1) {
				EStructuralFeature f0 = (EStructuralFeature)arg0;
				EStructuralFeature f1 = (EStructuralFeature)arg1;
				return f0.getName().compareTo(f1.getName());
			}
		});
		features.addAll(type.getEAllStructuralFeatures());
		for (Iterator iterator = features.iterator(); iterator.hasNext();) {
			EStructuralFeature feature = (EStructuralFeature)iterator.next();
			String replacementString = feature.getName();
			if (!existing.contains(replacementString)) {
				if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
					Image image = null;
					if (feature.isChangeable()) {
						if (feature instanceof EAttribute) {
							image = getImage("model_attribute.gif"); //$NON-NLS-1$
						} else if (feature instanceof EReference) {
							image = getImage("model_reference.gif"); //$NON-NLS-1$
						}
						StringBuffer additionalProposalInfo = new StringBuffer();
						if (feature instanceof EAttribute) {
							additionalProposalInfo.append("attribute "); //$NON-NLS-1$
						} else if (feature instanceof EReference) {
							additionalProposalInfo.append("reference "); //$NON-NLS-1$
						}
						additionalProposalInfo.append(feature.getName());
						if ((feature.getLowerBound() == 1) && (feature.getUpperBound() == 1)) {
							// display nothing
						} else {
							additionalProposalInfo.append('[');
							if ((feature.getLowerBound() == 0) && (feature.getUpperBound() == -1)) {
								additionalProposalInfo.append('*');
							} else {
								additionalProposalInfo.append(feature.getLowerBound());
								additionalProposalInfo.append('-');
								additionalProposalInfo.append(feature.getUpperBound());
							}
							additionalProposalInfo.append(']');
						}
						if (feature.isOrdered()) {
							additionalProposalInfo.append(" ordered"); //$NON-NLS-1$
						}
						if ((feature instanceof EReference) && ((EReference)feature).isContainment()) {
							additionalProposalInfo.append(" container"); //$NON-NLS-1$
						}
						additionalProposalInfo.append(" :\n\t"); //$NON-NLS-1$
						additionalProposalInfo.append(feature.getEType().getName());
						if (feature instanceof EReference) {
							EReference opposite = ((EReference)feature).getEOpposite();
							if (opposite != null) {
								additionalProposalInfo.append(" oppositeOf "); //$NON-NLS-1$
								additionalProposalInfo.append(opposite.getName());
							}
						}

						ICompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
								- prefix.length(), replacementString.length(), image, replacementString, 0,
								additionalProposalInfo.toString());
						res.add(proposal);
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
	 * @param prefix
	 *            completion prefix
	 * @param offset
	 *            completion offset
	 * @return the proposals
	 */
	public List getHelperTypesProposals(String prefix, int offset) {
		List res = new ArrayList();
		res.addAll(getMetaElementsProposals(prefix, offset, AtlSourceManager.FILTER_ALL_METAMODELS));
		String[] types = {"Boolean", "String", "Integer", "Sequence", "Set", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				"Bag", "OrderedSet", "Map",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		res.addAll(getProposalsFromList(offset, prefix, types));
		return res;
	}

	/**
	 * startsWithIgnoreCase method, i.e. equalsIgnoreCase and startsWith mix.
	 * 
	 * @param prefix
	 * @param replacementString
	 * @return <code>True</code> if the replacementString starts with the prefix, without checking the case,
	 *         <code>False</code> else.
	 */
	private static boolean startsWithIgnoreCase(String prefix, String replacementString) {
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
	 * @param mode
	 *            <code>True</code> if the classifier needs to have the form "pck::name", <code>False</code>
	 *            else.
	 * @return the short path.
	 */
	private static String getEClassifierShortPath(EClassifier eClassifier, boolean mode) {
		String name = eClassifier.getName();
		if (eClassifier.getEPackage() != null && mode) {
			name = "\"" + eClassifier.getEPackage().getName() + "::" + name //$NON-NLS-1$ //$NON-NLS-2$
					+ "\""; //$NON-NLS-1$
		}
		return name;
	}

	/**
	 * Looks for an image in the icons folder.
	 * 
	 * @param path
	 *            the image path
	 * @return the searched Image
	 */
	public static Image getImage(String path) {
		Image result = (Image)path2image.get(path);
		if (result == null && !path2image.containsKey(path)) {
			ImageDescriptor descriptor = AtlUIPlugin.getImageDescriptor(path);
			if (descriptor != null) {
				result = descriptor.createImage();
				path2image.put(path, result);
			}
		}
		if (result != null) {
			if (result.isDisposed()) {
				result = null;
			}
		}
		return result;
	}

	/**
	 * Returns the value of a feature on an EObject.
	 * 
	 * @param self
	 *            the EObject
	 * @param featureName
	 *            the feature name
	 * @return the feature value
	 */
	public static Object eGet(EObject self, String featureName) {
		EStructuralFeature feature = self.eClass().getEStructuralFeature(featureName);
		if (feature != null) {
			return self.eGet(feature);
		}
		return null;
	}

	/**
	 * Returns the EMF classifier matching with an ATL type.
	 * 
	 * @param atlType
	 *            the ATL type
	 * @return the EMF classifier matching with an ATL type
	 */
	public EClassifier getEClassifierFromAtlType(EObject atlType) {
		if (atlType != null) {
			EObject model = (EObject)eGet(atlType, "model"); //$NON-NLS-1$
			if (model != null) {
				String metamodelId = eGet(model, "name").toString(); //$NON-NLS-1$
				List packages = fEditor.getSourceManager().getMetamodelPackages(metamodelId);
				if (packages != null) {
					for (Iterator iterator = packages.iterator(); iterator.hasNext();) {
						EPackage pack = (EPackage)iterator.next();
						EClassifier res = pack.getEClassifier(eGet(atlType, "name").toString()); //$NON-NLS-1$
						return res;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of variables.
	 * 
	 * @param rule
	 *            the current rule
	 * @return the list of variables
	 */
	public static Map getVariables(EObject rule) {
		Map res = new HashMap();
		res.put("thisModule", null); //$NON-NLS-1$
		TreeIterator ruleContentsIterator = rule.eAllContents();
		while (ruleContentsIterator.hasNext()) {
			EObject content = (EObject)ruleContentsIterator.next();
			if (content.eClass().getName().equals("SimpleInPatternElement")) { //$NON-NLS-1$
				res.put(eGet(content, "varName"), eGet(content, "type")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return res;
	}

	/**
	 * Returns a list of variables proposals.
	 * 
	 * @param rule
	 *            the current rule
	 * @param prefix
	 *            current prefix
	 * @param offset
	 *            current offset
	 * @return a list of variables proposals
	 */
	public List getVariablesProposals(EObject rule, String prefix, int offset) {
		List res = new ArrayList();
		Map variables = getVariables(rule);
		for (Iterator iterator = variables.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry)iterator.next();
			String replacementString = entry.getKey().toString();
			StringBuffer additionalProposalInfo = new StringBuffer();
			EClassifier classifier = getEClassifierFromAtlType((EObject)entry.getValue());
			if (classifier != null) {
				additionalProposalInfo.append(getEClassifierShortPath(classifier, false));
			}
			if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
				ICompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
						- prefix.length(), replacementString.length(), null, replacementString, 0,
						additionalProposalInfo.toString());
				res.add(proposal);
			}
		}
		return res;
	}

	public static List getProposalsFromList(int offset, String prefix, Object[] proposals) {
		List res = new ArrayList();
		for (int i = 0; i < proposals.length; i++) {
			String replacementString = proposals[i].toString();
			if (startsWithIgnoreCase(prefix, replacementString)) {
				res.add(new AtlCompletionProposal(replacementString, offset - prefix.length(),
						replacementString.length(), null, replacementString, 0, null));
			}
		}
		Collections.sort(res);
		return res;
	}
}
