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
package org.eclipse.m2m.atl.service.core.nestedElements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;

/**
 * The model class.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class Model {

	/**
	 * The injector definition.
	 */
	private final class Injector {
		private String type;

		private Map params;

		private Injector(String type) {
			this.type = type;
			params = new HashMap();
		}
	}

	private Injector injector;

	/**
	 * ASMModel.
	 */
	private ASMModel asmModel;

	/**
	 * Global model name.
	 */
	private String name;

	private String atlModelHandlerId;

	private String metamodelName;

	private String fileName;

	// TODO add subclasses: PreloadedModel, ModelLoadedFromWorkspace, ModelCreatedByTransformation
	/**
	 * Creates a new model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param path
	 *            the model path
	 * @param nsUri
	 *            the model uri
	 * @param isM3
	 *            true if the metamodel is a metametamodel
	 * @param atlModelHandlerId
	 *            the model handler id
	 * @param pluginId
	 *            the plugin id
	 * @throws ServiceException
	 * @throws IOException 
	 */
	public Model(String name, ASMModel metamodel, ModelLoader ml, String path,
			String nsUri, boolean isM3, String pluginId)
			throws ServiceException, IOException {
		this.asmModel = ServiceTransformationUtil.loadModel(name, metamodel,
				ml, path, nsUri, isM3, false, pluginId);
		this.name = name;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param fileName
	 *            the model filename
	 * @param atlModelHandlerId
	 *            the modelhandler id
	 */
	public Model(String name, ASMModel metamodel, ModelLoader ml, String fileName) {
		this.asmModel = ml.newModel(name, fileName, metamodel);
		this.fileName = fileName;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel name
	 * @param modelHandler
	 *            the modelhandler name
	 */
	public Model(String name, String metamodel, String modelHandler) {
		this.name = name;
		this.metamodelName = metamodel;
		this.atlModelHandlerId = modelHandler;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param path
	 *            the model path
	 * @param nsUri
	 *            the model uri
	 * @param isM3
	 *            true if the metamodel is a metametamodel
	 * @param atlModelHandlerId
	 *            the model handler id
	 * @param pluginId
	 *            the plugin id
	 * @param injectorType
	 *            the injector type
	 * @param paramsInjector
	 *            the injector parameters
	 */
	public Model(String name, ASMModel metamodel, String path, String nsUri,
			boolean isM3, String pluginId, String injectorType,
			Map paramsInjector) {
		if (injectorType.equals("ebnf")) { //$NON-NLS-1$
			this.asmModel = ServiceTransformationUtil.ebnfInjection(name, path,
					metamodel, paramsInjector, (String) paramsInjector
							.get("parserPath"), metamodel.getName(), pluginId);//$NON-NLS-1$
		}
		this.name = name;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param modelHandler
	 *            the model handler
	 * @param injectorType
	 *            the injector type
	 * @param paramsInjector
	 *            the injector parameters
	 */
	public Model(String name, String metamodel, String modelHandler,
			String injectorType, Map paramsInjector) {
		this.name = name;
		this.metamodelName = metamodel;
		this.atlModelHandlerId = modelHandler;
		Injector i = new Injector(injectorType);
		i.params = paramsInjector;
		this.injector = i;
	}

	/**
	 * Loads a model.
	 * 
	 * @param path
	 *            the model path
	 * @param asmMetamodel
	 *            the metamodel
	 * @param pluginId
	 *            the plugin id
	 * @throws ServiceException
	 * @throws IOException 
	 */
	public void loadModel(String path, ASMModel asmMetamodel, ModelLoader ml,
			String pluginId) throws ServiceException, IOException {
		if (this.injector == null) {
			asmModel = ServiceTransformationUtil.loadModel(name, asmMetamodel,
					ml, path, null, false, true, pluginId);
		} else if (this.injector.type.equals("ebnf")) { //$NON-NLS-1$
			this.asmModel = ServiceTransformationUtil
					.ebnfInjection(
							name,
							path,
							asmMetamodel,
							this.injector.params,
							(String) this.injector.params.get("parserPath"), asmMetamodel.getName(), pluginId);//$NON-NLS-1$
		}
	}

	public ASMModel getAsmModel() {
		return asmModel;
	}

	public String getName() {
		return name;
	}

	public String getMetamodelName() {
		return metamodelName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getAtlModelHandlerId() {
		return atlModelHandlerId;
	}

}
