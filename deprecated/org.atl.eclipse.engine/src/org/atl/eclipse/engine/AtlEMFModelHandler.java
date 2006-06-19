/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.atl.engine.repositories.emf4atl.ASMEMFModel;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * @author JOUAULT
 *
 */
public class AtlEMFModelHandler extends AtlModelHandler {
	private ASMEMFModel mofmm;
	private ASMEMFModel atlmm;
		
	public void saveModel(final ASMModel model, IProject project) {
		saveModel(model, model.getName() + ".ecore", project);
	}
	
	public void saveModel(final ASMModel model, String fileName, IProject project) {
		String uri = project.getFullPath().toString() + "/" + fileName;
		saveModel(model, uri);
	}

	public void saveModel(final ASMModel model, String uri) {
		saveModel(model, URI.createURI(uri));
	}
	
	private boolean useIDs = false;
	private boolean removeIDs = false;
	private String encoding = "ISO-8859-1";

	private void saveModel(final ASMModel model, URI uri) {
		Resource r = ((ASMEMFModel)model).getExtent();
		r.setURI(uri);
		Map options = new HashMap();
		options.put(XMIResource.OPTION_ENCODING, encoding);
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		
		if((useIDs || removeIDs) && (r instanceof XMIResource)) {
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
			r.save(options);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	protected AtlEMFModelHandler() {
		URL atlurl = AtlEMFModelHandler.class.getResource("resources/ATL-0.2.ecore");
		
		mofmm = org.atl.engine.repositories.emf4atl.ASMEMFModel.createMOF(null);
			
		try {
			atlmm = ASMEMFModel.loadASMEMFModel("ATL", mofmm, atlurl, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ASMModel getMof() {
		return mofmm;
	}

	public ASMModel getAtl() {
		return atlmm;
	}
	
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, in, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	public ASMModel loadModel(String name, ASMModel metamodel, URI uri) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, uri, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	public ASMModel loadModel(String name, ASMModel metamodel, String uri) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, uri, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

    /**
     * @see ASMEMFModel#newASMEMFModel(String, ASMEMFModel, ModelLoader)
     */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;
		
		try {
			ret = ASMEMFModel.newASMEMFModel(name, (ASMEMFModel)metamodel, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
    /**
     * @see ASMEMFModel#newASMEMFModel(String, String, ASMEMFModel, ModelLoader)
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public ASMModel newModel(String name, String uri, ASMModel metamodel) {
        ASMModel ret = null;
        
        try {
            ret = ASMEMFModel.newASMEMFModel(name, uri, (ASMEMFModel)metamodel, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ret;
    }
    
	private Map bimm = new HashMap();
	
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = (ASMModel)bimm.get(name);

		if(ret == null) {
			URL mmurl = AtlParser.class.getResource("resources/" + name + ".ecore");
			
			try {
				ret = loadModel(name, mofmm, mmurl.openStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			bimm.put(name, ret);
		}

		return ret;
	}

	public boolean isHandling(ASMModel model) {
		return model instanceof ASMEMFModel;
	}

	public void disposeOfModel(ASMModel model) {
		((ASMEMFModel)model).dispose();
	}

}
