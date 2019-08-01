/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import javax.jmi.reflect.InvalidCallException;
import javax.jmi.reflect.RefAssociation;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
import org.netbeans.api.mdr.MDRManager;
import org.netbeans.api.mdr.MDRepository;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMMDRModel extends ASMModel {

	private static int verboseLevel = 1;

	private static boolean persist = false;

	protected static MDRepository rep = null;

	static {
		ATLLogger.info("Initializing MDR...");
		initMDR();
	}

	protected ASMMDRModel(String name, RefPackage pack, ASMModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.pack = pack;
	}

	private Map modelElements = new HashMap();

	public ASMModelElement getASMModelElement(RefObject object) {
		ASMModelElement ret = (ASMModelElement)modelElements.get(object);

		if (ret == null) { // don't do expensive synchronize if ret is already defined
			synchronized(modelElements) {
				// check again, since another locking thread may have created a new element
				ret = (ASMModelElement)modelElements.get(object);
				if (ret == null) {
					ret = new ASMMDRModelElement(modelElements, this, object);
				}
			}
		}

		return ret;
	}

	private Map classifiers = null;

	private ASMModelElement getClassifier(String name) {
		if (classifiers == null) {
			classifiers = new HashMap();
			RefClass cl = pack.refClass("Classifier");
			initClassifiers(cl.refAllOfType().iterator(), classifiers);
		}
		ASMModelElement ret = null;

		RefObject ro = (RefObject)classifiers.get(name);
		if (ro != null) {
			ret = getASMModelElement(ro);
		}

		return ret;
	}

	private static String baseName(RefObject o) {
		RefObject parent = (RefObject)o.refGetValue("container");
		if (parent != null) {
			String name = (String)parent.refGetValue("name");
			return baseName(parent) + name + "::";
		}
		return "";
	}

	private static void initClassifiers(Iterator i, Map classifiers) {
		while (i.hasNext()) {
			RefObject ro = (RefObject)i.next();
			String name = (String)ro.refGetValue("name");
			register(classifiers, name, ro);
			String base = baseName(ro);
			if (base.length() > 0) {
				register(classifiers, base + name, ro);
			}
		}
	}

	private static void register(Map classifiers, String name, RefObject classifier) {
		if (classifiers.containsKey(name)) {
			ATLLogger.warning("metamodel contains several classifiers with same name: " + name);
		}
		classifiers.put(name, classifier);
	}

	public ASMModelElement findModelElement(String name) {
		ASMModelElement ret = null;

		ret = getClassifier(name);

		return ret;
	}

	public Set getElementsByType(ASMModelElement ame) {
		Set ret = new HashSet();
		RefObject o = ((ASMMDRModelElement)ame).getObject();

		for (Iterator i = findRefClass(pack, o).refAllOfType().iterator(); i.hasNext();) {
			ret.add(getASMModelElement((RefObject)i.next()));
		}

		return ret;
	}

	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;

		ret = getASMModelElement(findRefClass(pack, ((ASMMDRModelElement)type).getObject())
				.refCreateInstance(null));

		return ret;
	}

	private RefClass findRefClass(RefPackage pack, RefObject object) {
		RefClass ret = null;

		try {
			ret = pack.refClass(object);
		} catch (InvalidCallException ice) {

		}

		if (ret == null) {
			for (Iterator i = pack.refAllPackages().iterator(); i.hasNext() && (ret == null);) {
				ret = findRefClass((RefPackage)i.next(), object);
			}
		}

		return ret;
	}

	protected RefAssociation findRefAssociation(RefObject object) {
		return findRefAssociation(pack, object);
	}

	private RefAssociation findRefAssociation(RefPackage pack, RefObject object) {
		RefAssociation ret = null;

		try {
			ret = pack.refAssociation(object);
		} catch (InvalidCallException ice) {

		}

		if (ret == null) {
			for (Iterator i = pack.refAllPackages().iterator(); i.hasNext() && (ret == null);) {
				ret = findRefAssociation((RefPackage)i.next(), object);
			}
		}

		return ret;
	}

	protected void getAllAcquaintances() {

		final boolean debug = false;

		if (getMetamodel().equals(getMOF())) {
			ASMMDRModelElement assoType = (ASMMDRModelElement)getMOF().findModelElement("Association");
			for (Iterator i = getElementsByType(assoType).iterator(); i.hasNext();) {
				ASMMDRModelElement asso = (ASMMDRModelElement)i.next();

				if (debug) {
					ATLLogger.info(asso.toString());
				}

				ASMMDRModelElement type1 = null;
				String name1 = null;
				ASMModelElement ae1 = null;

				ASMMDRModelElement type2 = null;
				String name2 = null;
				ASMModelElement ae2 = null;
				for (Iterator j = ((ASMCollection)asso.get(null, "contents")).iterator(); j.hasNext();) {
					ASMModelElement ae = (ASMModelElement)j.next();
					if (ae.getMetaobject().get(null, "name").equals(new ASMString("AssociationEnd"))) {
						ASMMDRModelElement type = (ASMMDRModelElement)ae.get(null, "type");
						if (type1 == null) {
							type1 = type;
							name1 = ((ASMString)ae.get(null, "name")).getSymbol();
							ae1 = ae;
						} else {
							type2 = type;
							name2 = ((ASMString)ae.get(null, "name")).getSymbol();
							ae2 = ae;
						}
					}
				}

				if (debug)
					ATLLogger.info("\tAdding acquaintance \"" + name1 + "\" to " + type2);

				type2.addAcquaintance(name1, asso, ae1, true);

				if (debug)
					ATLLogger.info("\tAdding acquaintance \"" + name2 + "\" to " + type1);

				type1.addAcquaintance(name2, asso, ae2, false);
			}
		}
	}

	private static ASMMDRModel createMOF() {
		ASMMDRModel ret = null;

		try {
			ret = new ASMMDRModel("MOF", rep.getExtent("MOF"), null, false, null);
		} catch (org.netbeans.mdr.util.DebugException de) {
			ATLLogger.log(Level.SEVERE, de.getLocalizedMessage(), de);
		}

		return ret;
	}

	private static void initMDR() {
		if (rep != null)
			return;

		if (verboseLevel < 1) {
			System.setProperty("org.netbeans.lib.jmi.Logger.fileName", "");
		}
		if (!persist) {
			System.setProperty("org.netbeans.mdr.storagemodel.StorageFactoryClassName",
					"org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl");
		}
		System.setProperty("org.openide.util.Lookup", "org.openide.util.lookup.ATLLookup");
		//
		// otherwise MDR does not find ATLLookup
		Thread.currentThread()
				.setContextClassLoader(org.openide.util.lookup.ATLLookup.class.getClassLoader());

		rep = MDRManager.getDefault().getDefaultRepository();
//		rep.getExtent("MOF");
	}

	public RefPackage getPackage() {
		return pack;
	}

	public String xmiIdByElement(RefObject object) {
		return (String)xmiIdByElement.get(object);
	}

	public RefObject elementByXmiId(String xmiId) {
		return (RefObject)elementByXmiId.get(xmiId);
	}

	public static ASMModel getMOF() {
		if (mofmm == null) {
			mofmm = createMOF();
		}
		return mofmm;
	}

	private RefPackage pack;

	protected Map elementByXmiId;

	protected Map xmiIdByElement;

	private static ASMMDRModel mofmm;

	public void finalize() {
		getModelLoader().unload(this);
	}
}
