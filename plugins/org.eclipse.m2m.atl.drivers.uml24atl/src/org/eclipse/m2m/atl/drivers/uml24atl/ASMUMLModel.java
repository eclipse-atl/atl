/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.ATLPlugin;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * The UML implementation of ASMModel.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 */
public final class ASMUMLModel extends ASMEMFModel {

	private static ResourceSet resourceSet;

	private static ASMUMLModel mofmm;

	// mof metamodel shall be unique for each model handler of a given type,
	// but shall be redefined for a model handler that redefined a another model
	// handler.
	// use of static attributes is not advisable !

	private Resource extent;

	private Set referencedExtents = new HashSet();

	private List delayedInvocations = new ArrayList();

	/**
	 * Creates a new {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param isTarget
	 *            true if the model is an output model
	 */
	private ASMUMLModel(String name, Resource extent, ASMUMLModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, extent, metamodel, isTarget, ml);
		this.extent = extent; // MOF UML2 PRO IN OUT
	}

	public static ASMModel getMOF() {
		return ASMUMLModel.mofmm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#getASMModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public ASMModelElement getASMModelElement(EObject object) {
		ASMModelElement ret = null;

		synchronized (modelElements) {
			ret = (ASMModelElement)modelElements.get(object);
			if (ret == null) {
				ret = new ASMUMLModelElement(modelElements, this, object);
			}
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#getElementsByType(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement)
	 */
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new HashSet();
		EClass t = (EClass)((ASMUMLModelElement)type).getObject();
		addElementsOfType(ret, t, getExtent());
		for (Iterator i = referencedExtents.iterator(); i.hasNext();) {
			Resource res = (Resource)i.next();
			addElementsOfType(ret, t, res);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#newModelElement(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement)
	 */
	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;

		EClass t = (EClass)((ASMUMLModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = (ASMUMLModelElement)getASMModelElement(eo);
		getExtent().getContents().add(eo);

		return ret;
	}

	/**
	 * Simple Resource wrapping factory.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param extent
	 *            the resource extent
	 * @param ml
	 *            ModelLoader used to load the model if available, null otherwise.
	 * @return the loaded model
	 * @throws Exception
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, Resource extent,
			ModelLoader ml) throws Exception {
		ASMUMLModel ret = null;

		ret = new ASMUMLModel(name, extent, metamodel, false, ml);

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#dispose()
	 */
	public void dispose() {
		if (extent != null) {
			referencedExtents.clear();
			referencedExtents = null;
			for (Iterator unrs = unregister.iterator(); unrs.hasNext();) {
				String nsURI = (String)unrs.next();
				resourceSet.getPackageRegistry().remove(nsURI);

			}
			resourceSet.getResources().remove(extent);
			if (unload) {
				extent.unload();
			}
			extent = null;

			modelElements.clear();
			unregister.clear();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() {
		dispose();
		try {
			super.finalize();
		} catch (Throwable e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Creates a new ASMEMFModel. Do not use this method for models that require a special registered factory
	 * (e.g. uml2).
	 * 
	 * @param name
	 *            The model name. Also used as EMF model URI.
	 * @param metamodel
	 *            the metamodel
	 * @param ml
	 *            the model loader
	 * @return the new ASMUMLModel
	 * @throws Exception
	 */
	public static ASMUMLModel newASMUMLModel(String name, ASMUMLModel metamodel, ModelLoader ml)
			throws Exception {
		return newASMUMLModel(name, name, metamodel, ml); // OUT
	}

	/**
	 * Creates a new ASMEMFModel.
	 * 
	 * @param name
	 *            The model name. Not used by EMF.
	 * @param uri
	 *            The model URI. EMF uses this to determine the correct factory.
	 * @param metamodel
	 *            the metamodel
	 * @param ml
	 *            the model loader
	 * @return the new ASMUMLModel
	 * @throws Exception
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static ASMUMLModel newASMUMLModel(String name, String uri, ASMUMLModel metamodel, ModelLoader ml)
			throws Exception {
		ASMUMLModel ret = null;

		Resource extent = resourceSet.createResource(URI.createURI(uri));

		ret = new ASMUMLModel(name, extent, metamodel, true, ml);
		ret.unload = true;

		return ret;
	}

	/**
	 * Loads an {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param url
	 *            the model url (as String)
	 * @param ml
	 *            the model loader
	 * @return the loaded model
	 * @throws Exception
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, String url, ModelLoader ml)
			throws Exception {
		ASMUMLModel ret = null;

		if (url.startsWith("uri:")) {
			String uri = url.substring(4);
			EPackage pack = resourceSet.getPackageRegistry().getEPackage(uri);
			if (pack == null) {
				ret = new ASMUMLModel(name, null, metamodel, false, ml);
				ret.resolveURI = uri;
			} else {
				Resource extent = pack.eResource();
				ret = new ASMUMLModel(name, extent, metamodel, false, ml);
				ret.addAllReferencedExtents(extent);
			}
		} else {
			ret = loadASMUMLModel(name, metamodel, URI.createURI(url), ml);
		}

		return ret;
	}

	/**
	 * Loads an {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param url
	 *            the model url
	 * @param ml
	 *            the model loader
	 * @return the loaded model
	 * @throws Exception
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, URL url, ModelLoader ml)
			throws Exception {
		ASMUMLModel ret = null;

		ret = loadASMUMLModel(name, metamodel, url.openStream(), ml);

		return ret;
	}

	/**
	 * Loads an {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param uri
	 *            the model uri
	 * @param ml
	 *            the model loader
	 * @return the loaded model
	 * @throws Exception
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, URI uri, ModelLoader ml)
			throws Exception {
		ASMUMLModel ret = null;
		// PRO IN
		try {
			Resource extent = resourceSet.createResource(uri);
			extent.load(Collections.EMPTY_MAP);
			ret = new ASMUMLModel(name, extent, metamodel, true, ml);
			ret.addAllReferencedExtents(extent);
			ret.setIsTarget(false);
			ret.unload = true;
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		adaptMetamodel(ret, metamodel);

		return ret;
	}

	/**
	 * Loads an {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param in
	 *            the model {@link InputStream}
	 * @param ml
	 *            the model loader
	 * @return the loaded model
	 * @throws Exception
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, InputStream in,
			ModelLoader ml) throws Exception {
		ASMUMLModel ret = newASMUMLModel(name, metamodel, ml);

		try {
			ret.getExtent().load(in, Collections.EMPTY_MAP);
			ret.addAllReferencedExtents(ret.getExtent());
			ret.unload = true;
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		adaptMetamodel(ret, metamodel);
		ret.setIsTarget(false);

		return ret;
	}

	/**
	 * Adapts the model to its metamodel.
	 * 
	 * @param model
	 *            the model
	 * @param metamodel
	 *            the metamodel
	 */
	private static void adaptMetamodel(ASMUMLModel model, ASMUMLModel metamodel) {
		if (metamodel == mofmm) {
			for (Iterator i = model.getElementsByType("EPackage").iterator(); i.hasNext();) {
				ASMUMLModelElement ame = (ASMUMLModelElement)i.next();
				EPackage p = (EPackage)ame.getObject();
				String nsURI = p.getNsURI();
				if (nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				}
				if (!resourceSet.getPackageRegistry().containsKey(nsURI)) {
					model.unregister.add(nsURI);
				}
				resourceSet.getPackageRegistry().put(nsURI, p);
			}
			for (Iterator i = model.getElementsByType("EDataType").iterator(); i.hasNext();) {
				ASMUMLModelElement ame = (ASMUMLModelElement)i.next();
				String tname = ((ASMString)ame.get(null, "name")).getSymbol();
				String icn = null;
				if (tname.equals("Boolean")) {
					icn = "boolean"; // "java.lang.Boolean";
				} else if (tname.equals("Double")) {
					icn = "java.lang.Double";
				} else if (tname.equals("Float")) {
					icn = "java.lang.Float";
				} else if (tname.equals("Integer")) {
					icn = "java.lang.Integer";
				} else if (tname.equals("String")) {
					icn = "java.lang.String";
				}
				if (icn != null) {
					ame.set(null, "instanceClassName", new ASMString(icn));
				}
			}
		}

		/*
		 * reader.read(url.openStream(), url.toString(), ret.pack); ret.getAllAcquaintances();
		 */
	}

	/*
	 * To be able to adapt return type (ASMUMLModel), we have to use jdk5 features (covariance)
	 */
	/**
	 * Creates the MOF metametamodel.
	 * 
	 * @param ml
	 *            the model loader
	 * @return the mof
	 */
	public static ASMEMFModel createMOF(ModelLoader ml) {
		if (ASMUMLModel.mofmm == null) {
			ASMUMLModel.mofmm = new ASMUMLModel("MOF", EcorePackage.eINSTANCE.eResource(), null, false, ml);
		}

		return ASMUMLModel.mofmm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#getExtent()
	 */
	public Resource getExtent() {
		if ((extent == null) && (resolveURI != null)) {
			EPackage pack = resourceSet.getPackageRegistry().getEPackage(resolveURI);
			extent = pack.eResource();
			addAllReferencedExtents();
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
		resourceSet = new ResourceSetImpl();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return (o instanceof ASMUMLModel) && (((ASMUMLModel)o).extent == extent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#hashCode()
	 */
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#isCheckSameModel()
	 */
	public boolean isCheckSameModel() {
		return checkSameModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#setCheckSameModel(boolean)
	 */
	public void setCheckSameModel(boolean checkSameModel) {
		this.checkSameModel = checkSameModel;
	}

	/**
	 * Searches for and adds all Resource extents that are referenced from the main extent to
	 * referencedExtents.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private void addAllReferencedExtents() {
		Iterator contents = getExtent().getAllContents();
		while (contents.hasNext()) {
			Object o = contents.next();
			if (o instanceof EClass) {
				addReferencedExtentsFor((EClass)o, new HashSet());
			}
		}
		referencedExtents.remove(getExtent());
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
					ATLPlugin.log(Level.SEVERE, "WARNING: Resource for " + eType.toString()
							+ " is null; cannot be referenced");
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
			if (eType.eResource() != null) {
				referencedExtents.add(eType.eResource());
			} else {
				ATLPlugin.log(Level.SEVERE, "WARNING: Resource for " + eType.toString()
						+ " is null; cannot be referenced");
			}
		}
		Iterator eSupers = eClass.getESuperTypes().iterator();
		while (eSupers.hasNext()) {
			EClass eSuper = (EClass)eSupers.next();
			if (eSuper.eResource() != null) {
				referencedExtents.add(eSuper.eResource());
				addReferencedExtentsFor(eSuper, ignore);
			} else {
				ATLPlugin.log(Level.SEVERE, "WARNING: Resource for " + eSuper.toString()
						+ " is null; cannot be referenced");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#getReferencedExtents()
	 */
	public Set getReferencedExtents() {
		return referencedExtents;
	}

	/*
	 * // Unsupported Methods needed //
	 */
	/**
	 * Gets the last stereotype method in the delayed invocations list.
	 * 
	 * @param opName
	 *            the operation name
	 * @return the last stereotype method index
	 */
	public int getLastStereotypeMethod(String opName) {
		int rang = 0;
		for (int i = 0; i < delayedInvocations.size(); i++) {
			Invocation invoc = (Invocation)(delayedInvocations.get(rang));
			if (invoc.getOpName().equals(opName)) {
				rang = i;
			}
		}
		return rang;
	}

	/**
	 * Delays an invocation.
	 * 
	 * @param invocation
	 *            the operation invocation to delay
	 */
	public void addDelayedInvocation(Invocation invocation) {
		// Guarantee the applied profiles operations are the first applied
		if (invocation.getOpName().equals("applyProfile")) {
			delayedInvocations.add(0, invocation);
		} else {
			if (invocation.getOpName().equals("applyStereotype")
					|| invocation.getOpName().equals("applyAllStereotypes")
					|| invocation.getOpName().equals("applyAllRequiredStereotypes")) {
				// Guarantee the applied stereotypes operations are applied
				// before setValue and after applyProfile
				int lastApplyProfile = getLastStereotypeMethod("applyProfile");
				if (lastApplyProfile < delayedInvocations.size() - 1) {
					delayedInvocations.add(lastApplyProfile + 1, invocation);
				} else {
					delayedInvocations.add(invocation);
				}
			} else {
				// SetValue operation follow this way
				delayedInvocations.add(invocation);
			}
		}
	}

	/**
	 * Applies all delayed operation invocations.
	 */
	public void applyDelayedInvocations() {

		for (Iterator i = delayedInvocations.iterator(); i.hasNext();) {
			Invocation invocation = (Invocation)i.next();
			invocation.getSelf().realInvoke(invocation.getFrame(), invocation.getOpName(),
					invocation.getArguments());
		}

	}

}
