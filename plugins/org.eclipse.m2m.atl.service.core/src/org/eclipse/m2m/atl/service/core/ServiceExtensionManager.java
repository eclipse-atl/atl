/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.service.core.configuration.ComposedTransformationConfiguration;
import org.eclipse.m2m.atl.service.core.configuration.SingleTransformationConfiguration;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * ServiceExtensionManager creates transformation configurations available from declared extension points This
 * class implements Singleton Design Pattern.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public final class ServiceExtensionManager {

	private List transformationConfigurations;

	/**
	 * ServiceExtensionManager creates transformation configurations available from declared extension points.
	 */
	private ServiceExtensionManager() {
		final AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		transformationConfigurations = new ArrayList();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry == null) {
			throw new RuntimeException(ServiceMessages.getString("ServiceExtensionManager.0")); //$NON-NLS-1$
		}

		IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.transformation"); //$NON-NLS-1$

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				SingleTransformationConfiguration tc = new SingleTransformationConfiguration(
						elements[j].getAttribute("path"), elements[j].getAttribute("name"), extensions[i].getNamespaceIdentifier()); //$NON-NLS-1$//$NON-NLS-2$
    			ModelLoader ml = amh.createModelLoader();

				IConfigurationElement[] elementsFileExtension = elements[j].getChildren("fileExtension"); //$NON-NLS-1$
				for (int k = 0; k < elementsFileExtension.length; k++) {
					tc.addFileExtension(elementsFileExtension[k].getAttribute("value")); //$NON-NLS-1$
				}

				IConfigurationElement[] elementsMetamodel = elements[j].getChildren("metamodel"); //$NON-NLS-1$
				for (int k = 0; k < elementsMetamodel.length; k++) {
					String isM3Value = elementsMetamodel[k].getAttribute("isMetametamodel"); //$NON-NLS-1$
					boolean isM3 = false;
					if (isM3Value != null) {
						isM3 = new Boolean(isM3Value).booleanValue();
					}
					tc.addMetamodel(elementsMetamodel[k].getAttribute("name"), //$NON-NLS-1$
							elementsMetamodel[k].getAttribute("path"), //$NON-NLS-1$
							elementsMetamodel[k].getAttribute("nsUri"), //$NON-NLS-1$
							isM3, ml
					);
				}

				IConfigurationElement[] elementsInModel = elements[j].getChildren("inModel"); //$NON-NLS-1$
				for (int k = 0; k < elementsInModel.length; k++) {
					tc.addInModel(elementsInModel[k].getAttribute("name"), //$NON-NLS-1$
							elementsInModel[k].getAttribute("path"), //$NON-NLS-1$
							elementsInModel[k].getAttribute("metamodel"), //$NON-NLS-1$
							ml,
							new Boolean(elementsInModel[k].getAttribute("inWorkspace")).booleanValue() //$NON-NLS-1$
							);
				}

				IConfigurationElement[] elementsOutModel = elements[j].getChildren("outModel"); //$NON-NLS-1$
				for (int k = 0; k < elementsOutModel.length; k++) {
					tc.addOutModel(elementsOutModel[k].getAttribute("name"), //$NON-NLS-1$
							elementsOutModel[k].getAttribute("fileName"), //$NON-NLS-1$
							elementsOutModel[k].getAttribute("metamodel"), //$NON-NLS-1$
							ml);
				}

				transformationConfigurations.add(tc);
			}
		}

		point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.composedTransformations"); //$NON-NLS-1$

		extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				ComposedTransformationConfiguration tc = new ComposedTransformationConfiguration(elements[j]
						.getAttribute("name"), extensions[i].getNamespaceIdentifier()); //$NON-NLS-1$
    			ModelLoader ml = amh.createModelLoader();

				IConfigurationElement[] elementsFileExtension = elements[j].getChildren("fileExtension"); //$NON-NLS-1$
				for (int k = 0; k < elementsFileExtension.length; k++) {
					tc.addFileExtension(elementsFileExtension[k].getAttribute("value")); //$NON-NLS-1$
				}

				IConfigurationElement[] elementsMetamodel = elements[j].getChildren("load.metamodel"); //$NON-NLS-1$
				for (int k = 0; k < elementsMetamodel.length; k++) {
					String isM3Value = elementsMetamodel[k].getAttribute("isMetametamodel"); //$NON-NLS-1$
					boolean isM3 = false;
					if (isM3Value != null) {
						isM3 = new Boolean(isM3Value).booleanValue();
					}
					tc.addMetamodel(elementsMetamodel[k].getAttribute("name"), //$NON-NLS-1$
							elementsMetamodel[k].getAttribute("path"), //$NON-NLS-1$
							elementsMetamodel[k].getAttribute("nsUri"), //$NON-NLS-1$
							isM3, ml
					);
				}

				List notPreLoadedModels = new ArrayList();

				IConfigurationElement[] elementsInModel = elements[j].getChildren("load.model"); //$NON-NLS-1$
				for (int k = 0; k < elementsInModel.length; k++) {
					boolean isInWorkspace = new Boolean(elementsInModel[k].getAttribute("inWorkspace")).booleanValue(); //$NON-NLS-1$
					tc.addInModel(elementsInModel[k].getAttribute("name"), //$NON-NLS-1$
							elementsInModel[k].getAttribute("path"), //$NON-NLS-1$
							elementsInModel[k].getAttribute("metamodel"), //$NON-NLS-1$
							ml, isInWorkspace);
					if (isInWorkspace) {
						notPreLoadedModels.add(elementsInModel[k].getAttribute("name")); //$NON-NLS-1$
					}
				}

				IConfigurationElement[] elementsTransformation = elements[j].getChildren("transformation"); //$NON-NLS-1$
				for (int k = 0; k < elementsTransformation.length; k++) {
					Transformation t = new Transformation(elementsTransformation[k].getAttribute("path")); //$NON-NLS-1$

					IConfigurationElement[] subElementsTransformation = elementsTransformation[k]
							.getChildren("inModel"); //$NON-NLS-1$
					for (int l = 0; l < subElementsTransformation.length; l++) {
						t.addInModel(subElementsTransformation[l].getAttribute("name"), //$NON-NLS-1$
								subElementsTransformation[l].getAttribute("model") //$NON-NLS-1$
								);
						if (notPreLoadedModels.contains(subElementsTransformation[l].getAttribute("model"))) { //$NON-NLS-1$
							t.addInNotPreloadedList(subElementsTransformation[l].getAttribute("model")); //$NON-NLS-1$
						}
					}

					subElementsTransformation = elementsTransformation[k].getChildren("outModel"); //$NON-NLS-1$
					for (int l = 0; l < subElementsTransformation.length; l++) {
						t.addOutModel(subElementsTransformation[l].getAttribute("name"), //$NON-NLS-1$
								subElementsTransformation[l].getAttribute("model"), //$NON-NLS-1$
								subElementsTransformation[l].getAttribute("metamodel") //$NON-NLS-1$
								);
					}

					tc.addTransformation(t);
				}

				IConfigurationElement[] elementsApplyMarker = elements[j].getChildren("applyMarker"); //$NON-NLS-1$
				for (int k = 0; k < elementsApplyMarker.length; k++) {
					String globalModelName = elementsApplyMarker[k].getAttribute("model"); //$NON-NLS-1$
					tc.addApplyMarker(globalModelName);
				}

				IConfigurationElement[] elementsOutModel = elements[j].getChildren("save.model"); //$NON-NLS-1$
				for (int k = 0; k < elementsOutModel.length; k++) {
					String globalModelName = elementsOutModel[k].getAttribute("model"); //$NON-NLS-1$
					String fileName = elementsOutModel[k].getAttribute("path"); //$NON-NLS-1$

					IConfigurationElement[] elementsExtractor = elementsOutModel[k].getChildren("extractor"); //$NON-NLS-1$
					if (elementsExtractor.length == 0) {
						tc.addModelToSave(globalModelName, fileName);
					}
					else if (elementsExtractor.length == 1) {
						// TODO
						Map extractorParams = new HashMap();
						IConfigurationElement[] elementsParams = elementsExtractor[0].getChildren("param"); //$NON-NLS-1$
						for (int l = 0; l < elementsParams.length; l++) {
							extractorParams
									.put(
											elementsParams[l].getAttribute("key"), elementsParams[l].getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
						tc.addModelToSave(globalModelName, fileName, elementsExtractor[0]
								.getAttribute("type"), extractorParams); //$NON-NLS-1$
					} else {
						throw new RuntimeException(ServiceMessages.getString("ServiceExtensionManager.1")); //$NON-NLS-1$
					}

				}

				transformationConfigurations.add(tc);
			}
		}

		point = registry.getExtensionPoint("org.eclipse.m2m.atl.service.core.asl"); //$NON-NLS-1$

		extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				transformationConfigurations
						.add(createComposedTransformationConfigurationFromASLExtensionPoint(
								elements[j].getAttribute("name"), elements[j].getAttribute("path"), extensions[i].getNamespaceIdentifier())); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

	}

	private ComposedTransformationConfiguration createComposedTransformationConfigurationFromASLExtensionPoint(
			String configName, String aslPath, String pluginId) {

    	final AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
    	final ModelLoader ml = amh.createModelLoader();
    	try {
			ASMModel aslMM = ServiceTransformationUtil
					.loadModel(
							"ASL", ml.getMOF(), ml, "resources/ASL/ASL.ecore", "", false, false, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							"org.eclipse.m2m.atl.service.core"); //$NON-NLS-4$
			ASMModel sample = ServiceTransformationUtil
					.ebnfInjection(
							"sample-ASL", aslPath, aslMM, new HashMap(), //$NON-NLS-1$
							"resources/ASL/ASL-importer.jar", "ASL", //$NON-NLS-2$ //$NON-NLS-3$
							"org.eclipse.m2m.atl.service.core"); //$NON-NLS-4$
			Set modelElements = sample.getElementsByType("ASL"); //$NON-NLS-1$
			for (Iterator it = modelElements.iterator(); it.hasNext();) {
				ASMModelElement me = (ASMModelElement)it.next();
				ASMSequence seq = (ASMSequence)me.get(null, "operations"); //$NON-NLS-1$

				for (Iterator it2 = seq.iterator(); it2.hasNext();) {
					ASMModelElement me2 = (ASMModelElement)it2.next();
					String metaObjectName = me2.getMetaobject().getName();

					if (metaObjectName.equals("loadMetamodel")) { //$NON-NLS-1$

					} else if (metaObjectName.equals("loadModel")) { //$NON-NLS-1$

					} else if (metaObjectName.equals("atl")) { //$NON-NLS-1$

					} else if (metaObjectName.equals("applyMarker")) { //$NON-NLS-1$

					} else if (metaObjectName.equals("saveModel")) { //$NON-NLS-1$

					}

				}

			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Service extension manager.
	 */
	private static final class ServiceExtensionManagerHolder {
		private static ServiceExtensionManager instance = new ServiceExtensionManager();

		private ServiceExtensionManagerHolder() {
			super();
		}
		
	}

	public static ServiceExtensionManager getInstance() {
		return ServiceExtensionManagerHolder.instance;
	}

	public List getTransformationConfigurations() {
		return transformationConfigurations;
	}

}
