package org.atl.engine.repositories.emf4atl;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.atl.engine.vm.ModelLoader;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModelElement;
import org.atl.engine.vm.nativelib.ASMString;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * @author Frédéric Jouault
 */
public class ASMEMFModel extends ASMModel {

	public static ASMModel getMOF() {
		return mofmm;
	}
	
	public ASMModelElement findModelElement(String name) {
		ASMModelElement ret = null;
		
		EObject eo = null;
		
		eo = findModelElementIn(name, extent.getContents().iterator());
		
		if(eo != null)
			ret = ASMEMFModelElement.getASMModelElement(this, eo);
		
		return ret;
	}

	private EObject findModelElementIn(String name, Iterator i) {
		EObject ret = null;

		for( ; i.hasNext() && (ret == null); ) {
			EObject t = (EObject)i.next();
			if(t instanceof EPackage) {
				ret = ((EPackage)t).getEClassifier(name);
				if(ret == null) {
					ret = findModelElementIn(name, ((EPackage)t).getESubpackages().iterator());
				}
			}
		}
		
		return ret;
	}
	
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new HashSet();
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		for(Iterator i = extent.getAllContents() ; i.hasNext() ; ) {
			EObject eo = (EObject)i.next();
			if(t.isInstance(eo)) {
				ret.add(ASMEMFModelElement.getASMModelElement(this, eo));
			}
		}
		
		return ret;
	}

	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;
		
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = (ASMEMFModelElement)ASMEMFModelElement.getASMModelElement(this, eo);
		extent.getContents().add(eo);
		
		return ret;
	}
	/**
	 * @param name
	 * @param metamodel
	 * @param isTarget
	 */
	private ASMEMFModel(String name, Resource extent, ASMEMFModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.extent = extent;
	}
	
	public static ASMEMFModel newASMEMFModel(String name, ASMEMFModel metamodel, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		Resource extent = resourceSet.createResource(URI.createURI(name));

		ret = new ASMEMFModel(name, extent, metamodel, true, ml);

		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, String url, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		if(url.startsWith("uri:")) {
			String uri = url.substring(4);
			EPackage pack = (EPackage)EPackage.Registry.INSTANCE.getEPackage(uri);
			Resource extent = pack.eResource();
			ret = new ASMEMFModel(name, extent, metamodel, false, ml);
		} else {
			ret = loadASMEMFModel(name, metamodel, URI.createURI(url), ml);
		}
		
		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, URL url, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;

		ret = loadASMEMFModel(name, metamodel, url.openStream(), ml);
		
		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, URI uri, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;

		try {
			Resource extent = resourceSet.createResource(uri);
			extent.load(Collections.EMPTY_MAP);
			ret = new ASMEMFModel(name, extent, metamodel, true, ml);
			ret.setIsTarget(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		adaptMetamodel(ret, metamodel);

		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, InputStream in, ModelLoader ml) throws Exception {
		ASMEMFModel ret = newASMEMFModel(name, metamodel, ml);

		try {
			ret.extent.load(in, Collections.EMPTY_MAP);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		adaptMetamodel(ret, metamodel);
		ret.setIsTarget(false);

		return ret;
	}
	
	private static void adaptMetamodel(ASMEMFModel model, ASMEMFModel metamodel) {
		if(metamodel == mofmm) {
			for(Iterator i = model.getElementsByType("EPackage").iterator() ; i.hasNext() ; ) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				EPackage p = (EPackage)ame.getObject();
				String nsURI = p.getNsURI();
				if(nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				}
				EPackage.Registry.INSTANCE.put(nsURI, p);
			}
			for(Iterator i = model.getElementsByType("EDataType").iterator() ; i.hasNext() ; ) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				String tname = ((ASMString)ame.get(null, "name")).getSymbol();
				String icn = null;
				if(tname.equals("Boolean")) {
					icn = "java.lang.Boolean";
				} else if(tname.equals("Double")) {
					icn = "java.lang.Double";
				} else if(tname.equals("Float")) {
					icn = "java.lang.Float";
				} else if(tname.equals("Integer")) {
					icn = "java.lang.Integer";
				} else if(tname.equals("String")) {
					icn = "java.lang.String";
				}
				if(icn != null)
					ame.set(null, "instanceClassName", new ASMString(icn));
			}
		}

/*		
		reader.read(url.openStream(), url.toString(), ret.pack);
		ret.getAllAcquaintances();
*/	
	}
	
	public static ASMEMFModel createMOF(ModelLoader ml) {
		ASMEMFModel ret = null;
		
		Resource extent = resourceSet.createResource(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"));
//		System.out.println("Actual resource class: " + extent.getClass());
		extent.getContents().add(EcorePackage.eINSTANCE);
		ret = new ASMEMFModel("MOF", extent, null, false, ml);
		mofmm = ret;
		
		return ret;
	}
	
	public Resource getExtent() {
		return extent; 
	}
	
	static {
		init();
	}
	
	private static void init() {
		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
//		System.out.println(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
//		System.out.println(Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap());
		resourceSet = new ResourceSetImpl();
		
	}
	
	public boolean equals(Object o) {
		return (o instanceof ASMEMFModel) && (((ASMEMFModel)o).extent == extent);
	}
	
	private static ResourceSet resourceSet;

	private static ASMEMFModel mofmm;
	private Resource extent;
}
