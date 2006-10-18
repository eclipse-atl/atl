package org.atl.engine.repositories.emf4atl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.atl.engine.vm.ModelLoader;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * @author Frédéric Jouault
 */
public class EMFModelLoader extends ModelLoader {

	private ASMModel mofmm;
	
	public EMFModelLoader() {
		mofmm = ASMEMFModel.createMOF();
	}
		
	public ASMModel getMOF() {
		return mofmm;
	}

	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	protected ASMModel realLoadModel(String name, ASMModel metamodel, String href) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, href);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.newASMEMFModel(name, (ASMEMFModel)metamodel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	protected void setParameter(String name, Object value) {
		if("useIDs".equals(name)) {
			if("true".equals(value)) {
				useIDs = true;
			} else if("true".equals(value)) {
				useIDs = false;				
			}
		} else if("removeIDs".equals(name)) {
			if("true".equals(value)) {
				removeIDs = true;
			} else if("true".equals(value)) {
				removeIDs = false;				
			}
		} else if("encoding".equals(name)) {
			encoding = (String)value;
		}
	}
	
	private boolean useIDs = false;
	private boolean removeIDs = false;
	private String encoding = "ISO-8859-1";

	protected void realSave(ASMModel model, String href) {
		Resource r = ((ASMEMFModel)model).getExtent();
		r.setURI(URI.createURI(href));
		
		if(useIDs || removeIDs) {
			XMIResource xr = ((XMIResource)r);
			int id = 1;
			Set alreadySet = new HashSet();
			for(Iterator i = r.getAllContents() ; i.hasNext() ; ) {
				EObject eo = (EObject)i.next();
				if(alreadySet.contains(eo)) continue;	// because sometimes a single element gets processed twice
				xr.setID(eo, removeIDs ? null : ("a" + (id++)));
				alreadySet.add(eo);
			}
		}
		try {
			Map options = new HashMap();
			options.put(XMIResource.OPTION_ENCODING, encoding);
			r.save(options);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
