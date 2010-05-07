/*******************************************************************************
 * Copyright (c) 2004 INRIA and Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.emf4atl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;

/**
 * The ASMModel specialization for EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMEMFModel extends ASMModel {

	/** These meta model definition shall be redefined in all sub-classes of ASMEMFModel. */
	protected static ASMEMFModel mofmm;

	// instance counter for memory leak testing
	private static int instanceCount;

	/** These meta model definition shall be redefined in all sub-classes of ASMEMFModel. */
	protected Resource extent;

	/** These meta model definition shall be redefined in all sub-classes of ASMEMFModel. */
	protected Set referencedExtents = new HashSet();

	/** If not null, model could not yet be loaded from URI and needs to be loaded later from this URI. */
	protected String resolveURI;

	/** Lookup table of {@link ASMModelElement} by {@link EObject}. */
	protected Map modelElements = new HashMap();

	private Map classifiers;

	/**
	 * Creates a new {@link ASMEMFModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param extent
	 *            the resource extent
	 * @param metamodel
	 *            the metamodel
	 * @param isTarget
	 *            true if the model is a target model
	 * @param ml
	 *            the model loader
	 */
	protected ASMEMFModel(String name, Resource extent, ASMEMFModel metamodel, boolean isTarget,
			ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.extent = extent;
		if (extent != null) {
			addAllReferencedExtents(extent);
		}
		instanceCount++;
		ATLLogger.fine(this + " created (" + instanceCount + ")");
	}

	/**
	 * Returns the meta-meta-model.
	 * 
	 * @return the meta-meta-model.
	 */
	public static ASMModel getMOF() {
		if (mofmm == null) {
			mofmm = new ASMEMFModel("MOF", EcorePackage.eINSTANCE.eResource(), null, false, null);
		}
		return mofmm;
	}

	/**
	 * Returns the ASMModelElement corresponding to the given {@link EObject}.
	 * 
	 * @param object
	 *            the given {@link EObject}
	 * @return the {@link ASMModelElement}
	 */
	public synchronized ASMModelElement getASMModelElement(EObject object) {
		// TODO reinstate double checked locking with final field when switching to Java 5
		ASMModelElement ret = (ASMModelElement)modelElements.get(object);
		if (ret == null) {
			ret = new ASMEMFModelElement(modelElements, this, object);
		}
		return ret;
	}

	/**
	 * Returns the classifier with the given name.
	 * 
	 * @param name
	 *            the classifier name
	 * @return the classifier with the given name
	 */
	private synchronized ASMModelElement getClassifier(String name) {
		// TODO reinstate double checked locking with final field when switching to Java 5
		if (classifiers == null) {
			classifiers = initClassifiersInAllExtents();
		}
		EObject eo = (EObject)classifiers.get(name);

		ASMModelElement ret = null;
		if (eo != null) {
			ret = getASMModelElement(eo);
		}
		return ret;
	}

	/**
	 * Indexes all classifiers in main extent and referenced extents.
	 * 
	 * @return The classifier map to build.
	 * @see #register(Map, String, EObject)
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private Map initClassifiersInAllExtents() {
		Map allClassifiers = new HashMap();
		initClassifiers(getExtent().getContents().iterator(), allClassifiers, null);
		Iterator refExtents = referencedExtents.iterator();
		while (refExtents.hasNext()) {
			initClassifiers(((Resource)refExtents.next()).getContents().iterator(), allClassifiers, null);
		}
		return allClassifiers;
	}

	private void initClassifiers(Iterator i, Map allClassifiers, String base) {
		for ( ; i.hasNext();) {
			EObject eo = (EObject)i.next();
			if (eo instanceof EPackage) {
				String name = ((EPackage)eo).getName();
				if (base != null) {
					name = base + "::" + name;
				}
				initClassifiers(((EPackage)eo).eContents().iterator(), allClassifiers, name);
			} else if (eo instanceof EClassifier) {
				String name = ((EClassifier)eo).getName();
				// register the classifier under its simple name
				register(allClassifiers, name, eo);
				if (base != null) {
					name = base + "::" + name;
					// register the classifier under its full name
					register(allClassifiers, name, eo);
				}
			} else {
				// No meta-package or meta-class => just keep digging.
				// N.B. This situation occurs in UML2 profiles, where
				// EPackages containing EClasses are buried somewhere
				// underneath other elements.
				initClassifiers(eo.eContents().iterator(), allClassifiers, base);
			}
		}
	}

	private void register(Map allClassifiers, String name, EObject classifier) {
		if (allClassifiers.containsKey(name)) {
			ATLLogger.warning("metamodel contains several classifiers with same name: " + name);
		}
		allClassifiers.put(name, classifier);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel#findModelElement(java.lang.String)
	 */
	public ASMModelElement findModelElement(String name) {
		ASMModelElement ret = null;

		ret = getClassifier(name);

		return ret;
	}

	/**
	 * Returns The set of ASMModelElements that are instances of type and are contained in this model.
	 * 
	 * @param type
	 *            The type of element to search for.
	 * @return The set of ASMModelElements that are instances of type.
	 * @see ASMModelElement
	 */
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new LinkedHashSet();
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		addElementsOfType(ret, t, getExtent());
		return ret;
	}

	/**
	 * Returns The set of ASMModelElements that are instances of type and are contained in this model or any
	 * referenced meta-model.
	 * 
	 * @param typeName
	 *            The type of element to search for.
	 * @return The set of ASMModelElements that are instances of type.
	 * @see ASMModelElement
	 */
	public Set getAllElementsByType(String typeName) {
		return getAllElementsByType(getMetamodel().findModelElement(typeName));
	}

	/**
	 * Returns The set of ASMModelElements that are instances of type and are contained in this model or any
	 * referenced meta-model.
	 * 
	 * @param type
	 *            The type of element to search for.
	 * @return The set of ASMModelElements that are instances of type.
	 * @see ASMModelElement
	 */
	public Set getAllElementsByType(ASMModelElement type) {
		Set ret = new LinkedHashSet();
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		addElementsOfType(ret, t, getExtent());
		for (Iterator i = getReferencedExtents().iterator(); i.hasNext();) {
			Resource res = (Resource)i.next();
			addElementsOfType(ret, t, res);
		}
		return ret;
	}

	/**
	 * Adds all elements of the given type to the set.
	 * 
	 * @param elements
	 *            The set to add to.
	 * @param type
	 *            The type to test for.
	 * @param res
	 *            The resource containing the elements.
	 */
	private void addElementsOfType(Set elements, EClassifier type, Resource res) {
		for (Iterator i = res.getAllContents(); i.hasNext();) {
			EObject eo = (EObject)i.next();
			if (type.isInstance(eo)) {
				elements.add(getASMModelElement(eo));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel#newModelElement(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement)
	 */
	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;

		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = getASMModelElement(eo);
		getExtent().getContents().add(eo);

		return ret;
	}

	/**
	 * Returns the EMF resource containing the model.
	 * 
	 * @return The EMF resource containing the model
	 */
	public Resource getExtent() {
		if ((extent == null) && (resolveURI != null)) {
			final EMFModelLoader ml = (EMFModelLoader)getModelLoader();
			final ResourceSet resourceSet = ml.getResourceSet();
			boolean adapt = false;
			synchronized (resourceSet) {
				if (extent == null) {
					// check again, since another locking thread may have loaded the extent
					final EPackage pack = resourceSet.getPackageRegistry().getEPackage(resolveURI);
					final Resource r = pack.eResource();
					addAllReferencedExtents(r);
					adapt = true;
					extent = r;
				}
			}
			if (adapt) {
				try {
					ml.adaptMetamodel(this, (ASMEMFModel)getMetamodel());
				} catch (IOException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		}
		return extent;
	}

	static {
		init();
	}

	private static void init() {
		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// public boolean equals(Object o) {
	// return (o instanceof ASMEMFModel) && (((ASMEMFModel)o).extent == extent);
	// }

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return extent.hashCode();
	}

	/**
	 * Searches for and adds all Resource extents that are referenced from the main extent to
	 * referencedExtents.
	 * 
	 * @param resourceExtent
	 *            The main extent
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private void addAllReferencedExtents(Resource resourceExtent) {
		Iterator contents = resourceExtent.getAllContents();
		while (contents.hasNext()) {
			Object o = contents.next();
			if (o instanceof EClass) {
				addReferencedExtentsFor((EClass)o, new HashSet());
			}
		}
		referencedExtents.remove(resourceExtent);
	}

	/**
	 * Searches for and adds all Resource extents that are referenced from eClass to referencedExtents.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @param eClass
	 * @param ignore
	 *            Set of classes to ignore for searching.
	 */
	private void addReferencedExtentsFor(EClass eClass, Set ignore) {
		if (ignore.contains(eClass)) {
			return;
		}
		ignore.add(eClass);
		Iterator eRefs = eClass.getEReferences().iterator();
		while (eRefs.hasNext()) {
			EReference eRef = (EReference)eRefs.next();
			if (eRef.isContainment()) {
				EClassifier eType = eRef.getEType();
				if (eType.eResource() != null) {
					referencedExtents.add(eType.eResource());
				} else {
					ATLLogger.warning("Resource for " + eType.toString() + " is null; cannot be referenced");
				}
				if (eType instanceof EClass) {
					addReferencedExtentsFor((EClass)eType, ignore);
				}
			}
		}
		Iterator eAtts = eClass.getEAttributes().iterator();
		while (eAtts.hasNext()) {
			EAttribute eAtt = (EAttribute)eAtts.next();
			EClassifier eType = eAtt.getEType();
			if (eType != null) {
				if (eType.eResource() != null) {
					referencedExtents.add(eType.eResource());
				} else {
					ATLLogger.warning("Resource for " + eType.toString() + " is null; cannot be referenced");
				}
			}
		}
		Iterator eSupers = eClass.getESuperTypes().iterator();
		while (eSupers.hasNext()) {
			EClass eSuper = (EClass)eSupers.next();
			if (eSuper.eResource() != null) {
				referencedExtents.add(eSuper.eResource());
				addReferencedExtentsFor(eSuper, ignore);
			} else {
				ATLLogger.warning("Resource for " + eSuper.toString() + " is null; cannot be referenced");
			}
		}
	}

	/**
	 * Returns The set of referenced Resources.
	 * 
	 * @return The set of referenced Resources
	 */
	public Set getReferencedExtents() {
		return referencedExtents;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#finalize()
	 */
	protected void finalize() throws Throwable {
		instanceCount--;
		ATLLogger.fine(this + " is being collected (" + instanceCount + ")");
		final ModelLoader ml = getModelLoader();
		if (ml != null) {
			ml.unload(this);
		}
		super.finalize();
	}
}
