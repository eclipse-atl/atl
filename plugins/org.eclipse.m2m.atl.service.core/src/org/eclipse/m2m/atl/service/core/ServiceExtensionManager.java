package org.eclipse.m2m.atl.service.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.service.core.configuration.ComposedTransformationConfiguration;
import org.eclipse.m2m.atl.service.core.configuration.SingleTransformationConfiguration;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * ServiceExtensionManager creates transformation configurations available from declared extension points
 * This class implements Singleton Design Pattern 
 * @author Freddy Allilaire
 *
 */
public class ServiceExtensionManager {

	private List transformationConfigurations;
	
	/**
	 * ServiceExtensionManager creates transformation configurations available from declared extension points
	 *
	 */
    private ServiceExtensionManager () {
    	transformationConfigurations = new ArrayList();
    	
    	IExtensionRegistry registry = Platform.getExtensionRegistry();
    	if (registry == null) {
    		throw new RuntimeException("Eclipse platform extension registry not found. Dynamic repository lookup does not work outside Eclipse.");
    	}

    	IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.transformation");

    	IExtension[] extensions = point.getExtensions();	
    	for(int i = 0 ; i < extensions.length ; i++) {
    		IConfigurationElement[] elements = extensions[i].getConfigurationElements();
    		for(int j = 0 ; j < elements.length ; j++){
    			SingleTransformationConfiguration tc = new SingleTransformationConfiguration(elements[j].getAttribute("path"), elements[j].getAttribute("name"), extensions[i].getNamespaceIdentifier());
   				
    			IConfigurationElement[] elementsFileExtension = elements[j].getChildren("fileExtension");
   				for (int k = 0; k < elementsFileExtension.length; k++) {
   	    			tc.addFileExtension(elementsFileExtension[k].getAttribute("value"));
   				}
   				
   				IConfigurationElement[] elementsMetamodel = elements[j].getChildren("metamodel");
   				for (int k = 0; k < elementsMetamodel.length; k++) {
   					String isM3Value = elementsMetamodel[k].getAttribute("isMetametamodel");
   					boolean isM3 = false;
   					if (isM3Value != null)
   						isM3 = new Boolean(isM3Value).booleanValue();
   					tc.addMetamodel(
   							elementsMetamodel[k].getAttribute("name"), 
   							elementsMetamodel[k].getAttribute("path"), 
   							elementsMetamodel[k].getAttribute("nsUri"),
   							isM3,
   							"EMF"
   					);
   				}
   				
   				IConfigurationElement[] elementsInModel = elements[j].getChildren("inModel");
   				for (int k = 0; k < elementsInModel.length; k++) {
   					tc.addInModel(
   							elementsInModel[k].getAttribute("name"), 
   							elementsInModel[k].getAttribute("path"), 
   							elementsInModel[k].getAttribute("metamodel"),
   							new Boolean(elementsInModel[k].getAttribute("inWorkspace")).booleanValue()
   					);
   				}
   				
   				IConfigurationElement[] elementsOutModel = elements[j].getChildren("outModel");
   				for (int k = 0; k < elementsOutModel.length; k++) {
   					tc.addOutModel(
   							elementsOutModel[k].getAttribute("name"), 
   							elementsOutModel[k].getAttribute("fileName"), 
   							elementsOutModel[k].getAttribute("metamodel") 
   					);
   				}
   				
   				transformationConfigurations.add(tc);
    		}
    	}
    	
    	point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.composedTransformations");

    	extensions = point.getExtensions();	
    	for(int i = 0 ; i < extensions.length ; i++) {
    		IConfigurationElement[] elements = extensions[i].getConfigurationElements();
    		for(int j = 0 ; j < elements.length ; j++){
    			ComposedTransformationConfiguration tc = new ComposedTransformationConfiguration(elements[j].getAttribute("name"), extensions[i].getNamespaceIdentifier());
   				
    			IConfigurationElement[] elementsFileExtension = elements[j].getChildren("fileExtension");
   				for (int k = 0; k < elementsFileExtension.length; k++) {
   	    			tc.addFileExtension(elementsFileExtension[k].getAttribute("value"));
   				}
   				
   				IConfigurationElement[] elementsMetamodel = elements[j].getChildren("load.metamodel");
   				for (int k = 0; k < elementsMetamodel.length; k++) {
   					String isM3Value = elementsMetamodel[k].getAttribute("isMetametamodel");
   					boolean isM3 = false;
   					if (isM3Value != null)
   						isM3 = new Boolean(isM3Value).booleanValue();
   					tc.addMetamodel(
   							elementsMetamodel[k].getAttribute("name"), 
   							elementsMetamodel[k].getAttribute("path"), 
   							elementsMetamodel[k].getAttribute("nsUri"),
   							isM3,
   							"EMF"
   					);
   				}
   				
   				List notPreLoadedModels = new ArrayList();
   				
   				IConfigurationElement[] elementsInModel = elements[j].getChildren("load.model");
   				for (int k = 0; k < elementsInModel.length; k++) {
   					boolean isInWorkspace = new Boolean(elementsInModel[k].getAttribute("inWorkspace")).booleanValue();
   					tc.addInModel(
   							elementsInModel[k].getAttribute("name"), 
   							elementsInModel[k].getAttribute("path"), 
   							elementsInModel[k].getAttribute("metamodel"),
   							isInWorkspace
   					);
   					if (isInWorkspace)
   						notPreLoadedModels.add(elementsInModel[k].getAttribute("name"));
   				}
   				
   				IConfigurationElement[] elementsTransformation = elements[j].getChildren("transformation");
   				for (int k = 0; k < elementsTransformation.length; k++) {
   					Transformation t = new Transformation(elementsTransformation[k].getAttribute("path"));
   					
   					IConfigurationElement[] subElementsTransformation = elementsTransformation[k].getChildren("inModel");
   	   				for (int l = 0; l < subElementsTransformation.length; l++) {
   	   					t.addInModel(
   	   						subElementsTransformation[l].getAttribute("name"), 
   	   						subElementsTransformation[l].getAttribute("model") 
   	   					);
   	   					if (notPreLoadedModels.contains(subElementsTransformation[l].getAttribute("model")))
   	   						t.addInNotPreloadedList(subElementsTransformation[l].getAttribute("model"));
   	   				}
   	   				
   	   				subElementsTransformation = elementsTransformation[k].getChildren("outModel");
	   				for (int l = 0; l < subElementsTransformation.length; l++) {
	   					t.addOutModel(
	   						subElementsTransformation[l].getAttribute("name"), 
	   						subElementsTransformation[l].getAttribute("model"), 
	   						subElementsTransformation[l].getAttribute("metamodel")
	   					);
	   				}
	   				
   					tc.addTransformation(t);
   				}
   				
   				IConfigurationElement[] elementsApplyMarker = elements[j].getChildren("applyMarker");
   				for (int k = 0; k < elementsApplyMarker.length; k++) {
   					String globalModelName = elementsApplyMarker[k].getAttribute("model");
   					tc.addApplyMarker(globalModelName);
   				}
   				
   				IConfigurationElement[] elementsOutModel = elements[j].getChildren("save.model");
   				for (int k = 0; k < elementsOutModel.length; k++) {
   					String globalModelName = elementsOutModel[k].getAttribute("model");
   					String fileName = elementsOutModel[k].getAttribute("path");
   					
   					IConfigurationElement[] elementsExtractor = elementsOutModel[k].getChildren("extractor");
   					if (elementsExtractor.length == 0)
   						tc.addModelToSave( globalModelName, fileName);
   					else if (elementsExtractor.length == 1) {
   						// TODO
   						Map extractorParams = new HashMap();
   						IConfigurationElement[] elementsParams = elementsExtractor[0].getChildren("param");
   						for (int l = 0; l < elementsParams.length; l++)
   							extractorParams.put(elementsParams[l].getAttribute("key"), elementsParams[l].getAttribute("value"));
   						tc.addModelToSave(globalModelName, fileName, elementsExtractor[0].getAttribute("type"), extractorParams);
   					}
   					else
   						throw new RuntimeException("Only one extractor is possible for the same model.");
   					
   				}
   				
   				transformationConfigurations.add(tc);
    		}
    	}
    	
    	point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.asl");

    	extensions = point.getExtensions();	
    	for(int i = 0 ; i < extensions.length ; i++) {
    		IConfigurationElement[] elements = extensions[i].getConfigurationElements();
    		for(int j = 0 ; j < elements.length ; j++){
    			transformationConfigurations.add(createComposedTransformationConfigurationFromASLExtensionPoint(elements[j].getAttribute("name"), elements[j].getAttribute("path"), extensions[i].getNamespaceIdentifier()));
    		}
    	}
    	
    }

    private ComposedTransformationConfiguration createComposedTransformationConfigurationFromASLExtensionPoint(String configName, String aslPath, String pluginId) {
    	
    	AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
    	try {
			ASMModel aslMM = ServiceTransformationUtil.loadModel(amh, "ASL", amh.getMof(), "resources/ASL/ASL.ecore", "", false, false, "org.eclipse.m2m.atl.service.core");
			ASMModel sample = ServiceTransformationUtil.ebnfInjection("sample-ASL", aslPath, amh, aslMM, new HashMap(), "resources/ASL/ASL-importer.jar", "ASL", "org.eclipse.m2m.atl.service.core");
			Set modelElements = sample.getElementsByType("ASL");
			for (Iterator it = modelElements.iterator(); it.hasNext();) {
				ASMModelElement me = (ASMModelElement)it.next();
				ASMSequence seq = (ASMSequence)me.get(null, "operations");
				
				ComposedTransformationConfiguration ctc = new ComposedTransformationConfiguration("configName", "pluginId");
				
				for (Iterator it2 = seq.iterator(); it2.hasNext();) {
					ASMModelElement me2 = (ASMModelElement)it2.next();
					String metaObjectName = me2.getMetaobject().getName();
					
					if (metaObjectName.equals("loadMetamodel")) {
						
					}
					else if (metaObjectName.equals("loadModel")) {
						
					}
					else if (metaObjectName.equals("atl")) {
						
					}
					else if (metaObjectName.equals("applyMarker")) {
						
					}
					else if (metaObjectName.equals("saveModel")) {
						
					}
					
				}
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
    
//    private void loadSample() {
//    	AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
//    	try {
//			ASMModel aslMM = ServiceTransformationUtil.loadModel(amh, "ASL", amh.getMof(), "resources/ASL/ASL.ecore", "", false, false, "org.eclipse.m2m.atl.service.core");
//			ASMModel sample = ServiceTransformationUtil.ebnfInjection("sample-ASL", "resources/ASL/sample.asl", amh, aslMM, new HashMap(), "resources/ASL/ASL-importer.jar", "ASL", "org.eclipse.m2m.atl.service.core");
//			Set modelElements = sample.getElementsByType("ASL");
//			for (Iterator it = modelElements.iterator(); it.hasNext();) {
//				ASMModelElement me = (ASMModelElement)it.next();
//				ASMSequence seq = (ASMSequence)me.get(null, "operations");
//				
//				ComposedTransformationConfiguration ctc = new ComposedTransformationConfiguration("configName", "pluginId");
//				
//				for (Iterator it2 = seq.iterator(); it2.hasNext();) {
//					ASMModelElement me2 = (ASMModelElement)it2.next();
//					me2.getMetaobject().getName();
//				}
//				
//			}
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    private static class ServiceExtensionManagerHolder {
    	private static ServiceExtensionManager instance = new ServiceExtensionManager();
    }
    
    public static ServiceExtensionManager getInstance() {
    	return ServiceExtensionManagerHolder.instance;
    }

	public List getTransformationConfigurations() {
		return transformationConfigurations;
	}

}
