/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author JOUAULT
 *
 */
public abstract class AtlModelHandler {
	
//	public final static String AMH_MDR = "MDR";
	public final static String AMH_EMF = "EMF";

	private static String modelHandlers[] = null;	//new String[] {/*AMH_MDR, */AMH_EMF};
	
	private static Map defaultModelHandlers = new HashMap();
		
	public static AtlModelHandler getDefault(String repository) {
		AtlModelHandler ret = (AtlModelHandler)defaultModelHandlers.get(repository);
		if(ret == null) {
			if(AMH_EMF.equals(repository)) {
				ret = new AtlEMFModelHandler();
				defaultModelHandlers.put(repository, ret);				
			} else {
				IExtensionRegistry registry = Platform.getExtensionRegistry();		
				IExtensionPoint point = registry.getExtensionPoint("org.atl.eclipse.engine.modelhandler");

				IExtension[] extensions = point.getExtensions();		
				extensions: for(int i = 0 ; i < extensions.length ; i++){		
					IConfigurationElement[] elements = extensions[i].getConfigurationElements();
					for(int j = 0 ; j < elements.length ; j++){
						try {					
							if(elements[j].getAttribute("name").equals(repository)) {
								ret = (AtlModelHandler)elements[j].createExecutableExtension("class");
								defaultModelHandlers.put(repository, ret);
								break extensions;
							}
						} catch (CoreException e){
							e.printStackTrace();
						}				
					}
				 }
			}

			if(ret == null) {
				throw new RuntimeException("Model handler for " + repository + " not found. You may need to install a model handler plugin.");
			}
		}
		
		return ret;
	}
	
	public static String[] getModelHandlers() {
		if(modelHandlers == null) {
			List mhs = new ArrayList();
			mhs.add(AMH_EMF);
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();		
			IExtensionPoint point = registry.getExtensionPoint("org.atl.eclipse.engine.modelhandler");
	
			IExtension[] extensions = point.getExtensions();		
			for(int i = 0 ; i < extensions.length ; i++){		
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j = 0 ; j < elements.length ; j++){
					mhs.add(elements[j].getAttribute("name"));
				}
			}
			modelHandlers = (String[])mhs.toArray(new String [] {});
		}
		return modelHandlers;
	}
	
	public static String getHandlerName(ASMModel model) {
		String ret = null;
		
		for(Iterator i = defaultModelHandlers.keySet().iterator() ; i.hasNext() && (ret == null) ; ) {
			String amhName = (String)i.next();
			AtlModelHandler amh = getDefault(amhName);
			if(amh.isHandling(model)) {
				ret = amhName;
			}
		}
		return ret;
	}
	
	public static AtlModelHandler getHandler(ASMModel model) {
		return (AtlModelHandler)defaultModelHandlers.get(getHandlerName(model));
	}
	
	public abstract void saveModel(final ASMModel model, IProject project);

	public abstract void saveModel(final ASMModel model, String fileName, IProject project);
	
	public abstract void saveModel(final ASMModel model, String uri);

	public abstract ASMModel getAtl();

	public abstract ASMModel getMof();
	
	public abstract ASMModel loadModel(String name, ASMModel metamodel, InputStream in);
	
	public abstract ASMModel newModel(String name, ASMModel metamodel);

	/** 
	 * Performs necessary clean-up such as freeing memory.
	 * It should be redefined by any AtlModelHandler requiring specific clean-upon actions to be performed.
	 * This method should be called once the ASMModel is not needed any more.
	 */ 
	public void disposeOfModel(ASMModel model) {
		
	}
	
	public abstract ASMModel getBuiltInMetaModel(String name);
	
	public abstract boolean isHandling(ASMModel model);
}
