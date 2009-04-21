package org.eclipse.m2m.atl.engine.emfvm.launch;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.adapter.EMFModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.adapter.UML2ModelAdapter;

/**
 * The EMFVM implementation of the {@link ILauncher} interface.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFVMLauncher implements ILauncher {

	private static final String LAUNCHER_NAME = "EMF-specific VM"; //$NON-NLS-1$

	private static final String MODEL_FACTORY_NAME = "EMF"; //$NON-NLS-1$

	private Map<String, IModel> models;

	private Map<String, ASM> libraries;

	public String getName() {
		return LAUNCHER_NAME;
	}

	/**
	 * Adds any model to the local map.
	 * 
	 * @param model
	 *            the {@link IModel}
	 * @param name
	 *            the model name
	 * @param referenceModelName
	 *            the model reference model name
	 */
	protected void addModel(IModel model, String name, String referenceModelName) {
		if (models.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFVMLauncher.MODEL_EVER_REGISTERED", name)); //$NON-NLS-1$
		} else {
			models.put(name, model);
		}
		if (!models.containsKey(referenceModelName)) {
			models.put(referenceModelName, model.getReferenceModel());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInModel(IModel model, String name, String referenceModelName) {
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addLibrary(java.lang.String, java.lang.Object)
	 */
	public void addLibrary(String name, Object library) {
		if (libraries.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFVMLauncher.LIBRARY_EVER_REGISTERED", name)); //$NON-NLS-1$
		} else {
			libraries.put(name, getASMFromObject(library));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#initialize(java.util.Map)
	 */
	public void initialize(Map<String, Object> parameters) {
		models = new HashMap<String, IModel>();
		libraries = new HashMap<String, ASM>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map, java.lang.Object[])
	 */
	public Object launch(final String mode, final IProgressMonitor monitor,
			final Map<String, Object> options, final Object... modules) {
		if (!mode.equals(ILauncher.RUN_MODE)) {
			ATLLogger.warning("mode " + mode + " unsupported for EMFVM, running launch instead"); //$NON-NLS-1$//$NON-NLS-2$
		}
		List<ASM> superimpose = new ArrayList<ASM>();
		ASM mainModule = getASMFromObject(modules[0]);
		for (int i = 1; i < modules.length; i++) {
			superimpose.add(getASMFromObject(modules[i]));
		}
		return launch(mode, monitor, options, mainModule, superimpose);
	}

	/**
	 * Launches the transformation with preloaded modules.
	 * 
	 * @param mode
	 *            the launching mode
	 * @param monitor
	 *            the progress monitor
	 * @param options
	 *            vm options
	 * @param mainModule
	 *            the main module
	 * @param superimpose
	 *            the superimposed modules
	 * @return the transformation return result
	 */
	protected Object launch(final String mode, final IProgressMonitor monitor,
			final Map<String, Object> options, ASM mainModule, List<ASM> superimpose) {
		IModelAdapter modelAdapter;
		if ("true".equals(options.get("supportUML2Stereotypes"))) { //$NON-NLS-1$ //$NON-NLS-2$
			modelAdapter = new UML2ModelAdapter();
		} else {
			modelAdapter = new EMFModelAdapter();
		}
		modelAdapter.setAllowInterModelReferences("true".equals(options.get("allowInterModelReferences"))); //$NON-NLS-1$ //$NON-NLS-2$
		return mainModule.run(models, libraries, superimpose, options, monitor, modelAdapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#loadModule(java.io.InputStream)
	 */
	public Object loadModule(InputStream inputStream) {
		return new ASMXMLReader().read(inputStream);
	}

	/**
	 * Load a module if necessary.
	 * 
	 * @param module
	 *            the given {@link ASM} or {@link InputStream}.
	 * @return the {@link ASM}
	 */
	protected ASM getASMFromObject(Object module) {
		if (module instanceof InputStream) {
			return (ASM)loadModule((InputStream)module);
		} else if (module instanceof ASM) {
			return (ASM)module;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModel(java.lang.String)
	 */
	public IModel getModel(String modelName) {
		return models.get(modelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getLibrary(java.lang.String)
	 */
	public Object getLibrary(String libraryName) {
		return libraries.get(libraryName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getDefaultModelFactoryName()
	 */
	public String getDefaultModelFactoryName() {
		return MODEL_FACTORY_NAME;
	}

}
