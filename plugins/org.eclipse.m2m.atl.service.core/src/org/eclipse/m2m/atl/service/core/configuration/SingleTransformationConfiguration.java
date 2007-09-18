package org.eclipse.m2m.atl.service.core.configuration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.m2m.atl.engine.AtlLauncher;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Model;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * SingleTransformationConfiguration (i.e. only one transformation to execute)
 * It contains models used by the transformations, and metadata transformation
 * TransformationConfiguration are built and stocked by the ServiceExtensionManager
 * UI parts can execute a transformationConfiguration with method execute()
 * 
 * @author Freddy Allilaire
 *
 */
public class SingleTransformationConfiguration extends TransformationConfiguration {

	private Transformation transformation;
	
	public SingleTransformationConfiguration(String path, String name, String pluginId) {
		super(name, pluginId);
		transformation = new Transformation(path);
	}
	
	public void addInModel(String name, String path, String metamodel, boolean inWorkspace) {
		// TODO
		try {
			if (inWorkspace) {
				models.put(name, new Model(name, metamodel, "EMF"));
				transformation.addInNotPreloadedList(name);
			}
			else
				models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), path, null, false, "EMF", pluginId));
			transformation.addInModel( name, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addOutModel(String name, String fileName, String metamodel) {
		// TODO
		models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), fileName, "EMF"));
		transformation.addOutModel(name, name, metamodel);
	}

	public void addMetamodel(String name, String path, String nsUri, boolean isM3, String modelHandler) {
		// TODO
		try {
			models.put(name, new Model(name, AtlModelHandler.getDefault(modelHandler).getMof(), path, nsUri, isM3, modelHandler, pluginId));
			transformation.addInModel(name, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method launchs by UI
	 */
	public void execute(String pathFolder, String pathInModel) throws ServiceException {
		Map params = Collections.EMPTY_MAP;
		Map libs = new HashMap();
        List superimps = new ArrayList();
        
		URL asmUrl = ServiceTransformationUtil.getURLFromASMFile(transformation.getTransformationPath(), pluginId);

		// TODO
		if (transformation.getModelsNotPreloaded().size() == 1)
			((Model)models.get(transformation.getModelsNotPreloaded().get(0))).loadModel(pathInModel, ((Model)models.get(((Model)models.get(transformation.getModelsNotPreloaded().get(0))).getMetamodelName())).getAsmModel(), pluginId);
		else
			throw new ServiceException(IStatus.CANCEL, "Only one model could be loaded from UI");
		
		// TODO nouvelle API
		AtlLauncher.getDefault().launch(asmUrl, libs, getModelsForTransformation(transformation), params, superimps, Collections.EMPTY_MAP);
		
		for (Iterator it = transformation.getOutModels().keySet().iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			Model currentOutModel = (Model)models.get(modelName);
			AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF).saveModel(currentOutModel.getAsmModel(), pathFolder + "/" + currentOutModel.getFileName());
		}
	}

}
