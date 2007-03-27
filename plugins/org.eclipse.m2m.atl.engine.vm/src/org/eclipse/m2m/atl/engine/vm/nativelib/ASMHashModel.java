package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.atl.engine.injectors.Injector;
import org.eclipse.m2m.atl.engine.injectors.xml.XMLInjector;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;

/**
 * Prototype ASMModel using HashMaps to store contents.
 * Only stores models, metamodels must be loaded into another repository
 * (e.g. EMF or MDR).
 * This class has not been modified to use the ModelLoader scheme.
 * It has not been updated for a long time and may not work without
 * some improvements.
 * @author Frédéric Jouault
 */
public class ASMHashModel extends ASMModel {

	private Map contents = new HashMap();
	private Set getContentsSetForType(ASMModelElement type) {
		Set ret = (Set)contents.get(type);

		if(ret == null) {
			ret = new HashSet();
			contents.put(type, ret);
		}

		return ret;
	}

	private ASMHashModel(String name, ASMModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
	}

	public ASMModelElement findModelElement(String name) {
		System.out.println("ERROR: can't use ASMHashModel as a meta-model so far.");
		return null;
	}

	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = new ASMHashModelElement(this, type);

		getContentsSetForType(type).add(ret);

		return ret;
	}

	public static ASMHashModel newASMHashModel(String name, ASMModel metamodel, ModelLoader ml) throws Exception {
		return new ASMHashModel(name, metamodel, true, ml);
	}

	public Set getElementsByType(ASMModelElement ame) {
		Set ret = new HashSet();

		realGetElementsByType(ame, ret);

		return ret;
	}

	private void realGetElementsByType(ASMModelElement ame, Set ret) {
		for(Iterator i = getContentsSetForType(ame).iterator() ; i.hasNext() ; ) {
			ret.add(i.next());
		}
//		for(Iterator i = ame.getSubtypes().iterator() ; i.hasNext() ; ) {
//			Object o = i.next();
//			if(o instanceof ASMModelElement) {
//				realGetElementsByType((ASMModelElement)o, ret);
//			}
//		}
	}

	// TODO: move injection elsewhere
	private static Map injectors = new HashMap();
	static {
//		importers.put("ebnf", EBNFImporter.class);
		injectors.put("xml", XMLInjector.class);
	}
	public static ASMHashModel loadASMHashModel(String name, ASMModel metamodel, String url, ModelLoader ml) throws Exception {
		ASMHashModel ret = newASMHashModel(name, metamodel, ml);

		String ss[] = url.split(":");
		if(ss.length == 1) {
			ss = new String[] {"xmi", ss[0]};
		}

		String other = null;
		if(ss.length == 3) other = ss[1];
		Class injectorClass = (Class)injectors.get(ss[0]);
		InputStream in = new FileInputStream(ss[ss.length - 1]);
		Injector im = (Injector)injectorClass.newInstance();
		im.performImportation(metamodel, ret, in, other);

		ret.setIsTarget(false);
		//ret.getAllAcquaintances();

		return ret;
	}
}

