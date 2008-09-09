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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;

/**
 * 
 * @author Freddy Allilaire
 *
 */
public class Model {

	private class Injector {
		private String type;
		private Map params;

		public Injector(String type) {
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
	public Model(String name, ASMModel metamodel, String path, String nsUri, boolean isM3, String atlModelHandlerId, String pluginId) throws ServiceException {
		this.asmModel = ServiceTransformationUtil.loadModel(AtlModelHandler.getDefault(atlModelHandlerId), name, metamodel, path, nsUri, isM3, false, pluginId);
		this.name = name;
	}

	public Model(String name, ASMModel metamodel, String fileName, String atlModelHandlerId) {
		this.asmModel = AtlModelHandler.getDefault(atlModelHandlerId).newModel(name, fileName, metamodel);
		this.fileName = fileName;
	}

	public Model(String name, String metamodel, String modelHandler) {
		this.name = name;
		this.metamodelName = metamodel;
		this.atlModelHandlerId = modelHandler;
	}

	public Model(String name, ASMModel metamodel, String path, String nsUri, boolean isM3, String atlModelHandlerId, String pluginId, String injectorType, Map paramsInjector) {
		if (injectorType.equals("ebnf"))//$NON-NLS-1$
			this.asmModel = ServiceTransformationUtil.ebnfInjection(name, path, AtlModelHandler.getDefault(atlModelHandlerId), metamodel, paramsInjector, (String)paramsInjector.get("parserPath"), metamodel.getName(), pluginId); //$NON-NLS-1$
		
		this.name = name;
	}
	
	public Model(String name, String metamodel, String modelHandler, String injectorType, Map paramsInjector) {
		this.name = name;
		this.metamodelName = metamodel;
		this.atlModelHandlerId = modelHandler;
		Injector i = new Injector(injectorType);
		i.params = paramsInjector;
		this.injector = i;
	}
	
	public void loadModel(String path, ASMModel asmMetamodel, String pluginId) throws ServiceException {
		if (this.injector == null)
			asmModel = ServiceTransformationUtil.loadModel(AtlModelHandler.getDefault(atlModelHandlerId), name, asmMetamodel, path, null, false, true, pluginId);
		else if (this.injector.type.equals("ebnf"))//$NON-NLS-1$
			this.asmModel = ServiceTransformationUtil.ebnfInjection(name, path, AtlModelHandler.getDefault(atlModelHandlerId), asmMetamodel, this.injector.params, (String)this.injector.params.get("parserPath"), asmMetamodel.getName(), pluginId); //$NON-NLS-1$
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

}
