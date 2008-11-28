package org.eclipse.m2m.atl.drivers.uml24atl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Loads UML models into a {@link ResourceSet}. Make sure to use the same
 * model loader for all EMF models used in a model transformation!
 * Use different model loaders for different threads.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class UMLModelLoader extends EMFModelLoader {

	/**
	 * UMLModelLoader constructor.
	 */
	public UMLModelLoader() {
		super();
		useIDs = true;
		saveOptions.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
	}

	protected ASMEMFModel createASMEMFModel(String name, Resource extent, ASMModel metamodel, boolean isTarget) {
		return new ASMUMLModel(name, extent, (ASMUMLModel)metamodel, isTarget, this);
	}

	/**
	 * Finalizes r by calling {@link Resource#unload()}. This works around a
	 * memory leak that is currently only experienced with UML models.
	 * @param r
	 */
	protected void finalizeResource(Resource r) {
		r.unload();
		logger.fine(r + " is unloaded");
	}
	
}
