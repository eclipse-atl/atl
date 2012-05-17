/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleElement;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.DuplicateEntryException;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.FieldContainer;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.NativeTypes;
import org.eclipse.m2m.atl.emftvm.util.OCLOperations;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.TypeHashMap;
import org.eclipse.m2m.atl.emftvm.util.TypeMap;
import org.eclipse.m2m.atl.emftvm.util.Types;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Env</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getMetaModels <em>Meta Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getInoutModels <em>Inout Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getOutputModels <em>Output Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getMatches <em>Matches</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getUniqueResults <em>Unique Results</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#isJitDisabled <em>Jit Disabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecEnvImpl extends EObjectImpl implements ExecEnv {

	/**
	 * Hold data for element deletion.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	final class DeletionEntry {

		/**
		 * The element to delete.
		 */
		protected EObject element;

		/**
		 * The stack frame context in which to perform the deletion.
		 */
		protected StackFrame frame;

		/**
		 * Creates a new {@link DeletionEntry}.
		 * @param element the element to delete
		 * @param frame the stack frame context in which to perform the deletion
		 */
		public DeletionEntry(final EObject element, final StackFrame frame) {
			super();
			this.element = element;
			this.frame = frame;
		}

		/**
		 * Performs the element deletion.
		 */
		public void delete() {
			assert getInputModelOf(element) == null;
			final Model m = getModelOf(element);
			try {
				m.deleteElement(element);
			} catch (Exception e) {
				throw new VMException(frame, 
						String.format(
								"Error while deleting element %s from %s: %s", 
								EMFTVMUtil.toPrettyString(element, ExecEnvImpl.this), 
								getModelID(m),
								e.getLocalizedMessage()),
						e);
			}
		}

	}

	/**
	 * The cached value of the '{@link #getMetaModels() <em>Meta Models</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModels()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Metamodel> metaModels;

	/**
	 * The cached value of the '{@link #getInputModels() <em>Input Models</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModels()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Model> inputModels;

	/**
	 * The cached value of the '{@link #getInoutModels() <em>Inout Models</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutModels()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Model> inoutModels;

	/**
	 * The cached value of the '{@link #getOutputModels() <em>Output Models</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModels()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Model> outputModels;

	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Module> modules;

	/**
	 * The cached value of the '{@link #getMatches() <em>Matches</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatches()
	 * @generated
	 * @ordered
	 */
	protected TraceLinkSet matches;

	/**
	 * The cached value of the '{@link #getTraces() <em>Traces</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraces()
	 * @generated
	 * @ordered
	 */
	protected TraceLinkSet traces;

	/**
	 * The cached value of the '{@link #getUniqueResults() <em>Unique Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueResults()
	 * @generated
	 * @ordered
	 */
	protected Map<TraceLink, Object> uniqueResults;

	/**
	 * The default value of the '{@link #isJitDisabled() <em>Jit Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJitDisabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean JIT_DISABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isJitDisabled() <em>Jit Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJitDisabled()
	 * @generated
	 * @ordered
	 */
	protected boolean jitDisabled = JIT_DISABLED_EDEFAULT;

	/**
	 * The internal value of the '{@link #getMetaModels() <em>Meta Models</em>}' attribute.
	 */
	protected final Map<String, Metamodel> internalMetaModels = 
			Collections.synchronizedMap(new HashMap<String, Metamodel>());

	/**
	 * The internal value of the '{@link #getInputModels() <em>Input Models</em>}' attribute.
	 */
	protected final Map<String, Model> internalInputModels =
			Collections.synchronizedMap(new HashMap<String, Model>());

	/**
	 * The internal value of the '{@link #getInoutModels() <em>Inout Models</em>}' attribute.
	 */
	protected final Map<String, Model> internalInoutModels =
			Collections.synchronizedMap(new HashMap<String, Model>());

	/**
	 * The internal value of the '{@link #getOutputModels() <em>Output Models</em>}' attribute.
	 */
	protected final Map<String, Model> internalOutputModels =
			Collections.synchronizedMap(new HashMap<String, Model>());

	/**
	 * The internal value of the '{@link #getModules() <em>Modules</em>}' attribute.
	 */
	protected final Map<String, Module> internalModules =
			Collections.synchronizedMap(new LinkedHashMap<String, Module>());

	/**
	 * Set of modules that have effectively been loaded.
	 * Intended for keeping track of cyclic imports.
	 */
	protected final Set<String> loadedModules = new HashSet<String>();
	
	/**
	 * The chain of '<code>main()</code>' operations to be executed after the automatic rules.
	 */
	protected final EList<Operation> mainChain = new BasicEList<Operation>();

	/**
	 * Field storage and lookup. 
	 */
	protected final FieldContainer fieldContainer = new FieldContainer();

	/**
	 * Lookup table for operations: (name -> (argcount -> (context -> ?)))
	 * Depending on the number of arguments (argcount), several nested {@link TypeMap}s are contained,
	 * eventually pointing to an {@link Operation}.
	 * Example: for argcount = 2: (name -> (2 -> (context -> (arg1 -> (arg2 -> op)))))
	 */
	protected final Map<String, Map<Integer, TypeMap<Object, Object>>> operations = 
		new HashMap<String, Map<Integer,TypeMap<Object,Object>>>();

	/**
	 * Lookup table for static operations: (name -> (argcount -> (context -> ?)))
	 * Depending on the number of arguments (argcount), several nested {@link TypeMap}s are contained,
	 * eventually pointing to an {@link Operation}.
	 * Example: for argcount = 2: (name -> (2 -> (context -> (arg1 -> (arg2 -> op)))))
	 */
	protected final Map<String, Map<Integer, TypeMap<Object, Object>>> staticOperations = 
		new HashMap<String, Map<Integer,TypeMap<Object,Object>>>();

	/**
	 * Lookup table for rules: (name -> rule).
	 */
	protected final Map<String, Rule> rules = new LinkedHashMap<String, Rule>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected final Map<Resource, Model> modelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected final Map<Resource, Model> inputModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected final Map<Resource, Model> inoutModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected final Map<Resource, Model> outputModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> metamodel).
	 */
	protected final Map<Resource, Metamodel> metaModelOf = new HashMap<Resource, Metamodel>();

	/**
	 * Lookup table of (model -> ID).
	 */
	protected final Map<Model, String> modelId = new HashMap<Model, String>();

	/**
	 * Lookup table of (metamodel -> ID).
	 */
	protected final Map<Metamodel, String> metaModelId = new HashMap<Metamodel, String>();

	/**
	 * Model cache initialised?
	 */
	protected boolean modelCacheInit;

	/**
	 * The {@link VMMonitor} for the currently running VM instance.
	 */
	protected VMMonitor monitor;

	/**
	 * {@link Queue} of elements to be deleted, along with the {@link StackFrame}
	 * context in which the deletion takes place.
	 */
	protected final Queue<DeletionEntry> deletionQueue = new LinkedList<DeletionEntry>();

	private CodeBlockJIT cbJit;
	private boolean ruleStateCompiled;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link ExecEnvImpl}.
	 * <!-- end-user-doc -->
	 */
	protected ExecEnvImpl() {
		super();
		registerMetaModel(EcorePackage.eNAME.toUpperCase(), EMFTVMUtil.getEcoreMetamodel());
		registerMetaModel(EmftvmPackage.eNAME.toUpperCase(), EMFTVMUtil.getEmfTvmMetamodel());
		registerMetaModel(TracePackage.eNAME.toUpperCase(), EMFTVMUtil.getTraceMetamodel());
		createField("matches", true, Types.EXEC_ENV_TYPE, Types.TRACE_LINK_SET_TYPE, new NativeCodeBlock() {
			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(getMatches());
				return frame;
			}
		});
		createField("traces", true, Types.EXEC_ENV_TYPE, Types.TRACE_LINK_SET_TYPE, new NativeCodeBlock() {
			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(getTraces());
				return frame;
			}
		});
		final Module oclModule = OCLOperations.getInstance().getOclModule();
		loadModule(new ModuleResolver() {
			public Module resolveModule(final String name) throws ModuleNotFoundException {
				return oclModule;
			}
		}, oclModule.getName());
	}

	/**
	 * Creates and registers a new {@link Field}.
	 * @param name field name
	 * @param isStatic whether the field is static
	 * @param context field context type model and name
	 * @param type field type model and name
	 * @param initialiser field initialiser codeblock
	 */
	private void createField(final String name, final boolean isStatic, 
			final String[] context, final String[] type, final CodeBlock initialiser) {
		final Field f = EMFTVMUtil.createField(name, isStatic, context, type, initialiser);
		registerFeature(f);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.EXEC_ENV;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Module> getModules() {
		if (modules == null) {
			modules = Collections.unmodifiableMap(internalModules);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TraceLinkSet getMatches() {
		if (matches == null) {
			basicGetMatches();
		}
		if (matches != null && matches.eIsProxy()) {
			InternalEObject oldMatches = (InternalEObject)matches;
			matches = (TraceLinkSet)eResolveProxy(oldMatches);
			if (matches != oldMatches) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.EXEC_ENV__MATCHES, oldMatches, matches));
			}
		}
		return matches;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * Returns the value of the 'Matches' reference.
	 * @return the value of the 'Matches' reference.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TraceLinkSet basicGetMatches() {
		if (matches == null) {
			final Map<String, Model> oms = getOutputModels();
			if (oms.containsKey("match")) {
				matches = (TraceLinkSet)oms.get("match").newElement(TracePackage.eINSTANCE.getTraceLinkSet());
			} else {
				matches = TraceFactory.eINSTANCE.createTraceLinkSet();
			}
			assert matches != null;
		}
		return matches;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TraceLinkSet getTraces() {
		if (traces == null) {
			basicGetTraces();
		}
		if (traces != null && traces.eIsProxy()) {
			InternalEObject oldTraces = (InternalEObject)traces;
			traces = (TraceLinkSet)eResolveProxy(oldTraces);
			if (traces != oldTraces) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.EXEC_ENV__TRACES, oldTraces, traces));
			}
		}
		return traces;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * Returns the value of the 'Traces' reference.
	 * @return the value of the 'Traces' reference.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TraceLinkSet basicGetTraces() {
		if (traces == null) {
			final Map<String, Model> oms = getOutputModels();
			if (oms.containsKey("trace")) {
				traces = (TraceLinkSet)oms.get("trace").newElement(TracePackage.eINSTANCE.getTraceLinkSet());
			} else {
				traces = TraceFactory.eINSTANCE.createTraceLinkSet();
			}
			assert traces != null;
		}
		return traces;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<TraceLink, Object> getUniqueResults() {
		if (uniqueResults == null) {
			uniqueResults = new HashMap<TraceLink, Object>();
		}
		return uniqueResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isJitDisabled() {
		return jitDisabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJitDisabled(boolean newJitDisabled) {
		boolean oldJitDisabled = jitDisabled;
		jitDisabled = newJitDisabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.EXEC_ENV__JIT_DISABLED, oldJitDisabled, jitDisabled));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VMMonitor getMonitor() {
		return monitor;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void setMonitor(final VMMonitor monitor) {
		// Reset JIT compiler if monitor changes from or to null
		if (this.monitor == null) {
			if (monitor != null) {
				resetJITCompiler();
			}
		} else {
			if (monitor == null) {
				resetJITCompiler();
			}
		}
		this.monitor = monitor;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void registerMetaModel(final String name, final Metamodel metamodel) {
		internalMetaModels.put(name, metamodel);
		clearModelCaches();
		resetJITCompiler();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void registerInputModel(final String name, final Model model) {
		internalInputModels.put(name, model);
		clearModelCaches();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void registerInOutModel(final String name, final Model model) {
		internalInoutModels.put(name, model);
		clearModelCaches();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void registerOutputModel(final String name, final Model model) {
		internalOutputModels.put(name, model);
		clearModelCaches();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Metamodel getMetaModel(final Resource resource) {
		if (!modelCacheInit) {
			cacheModels();
		}
		return (resource == null) ? null : metaModelOf.get(resource);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Metamodel> getMetaModels() {
		if (metaModels == null) {
			metaModels = Collections.unmodifiableMap(internalMetaModels);
		}
		return metaModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Model> getInputModels() {
		if (inputModels == null) {
			inputModels = Collections.unmodifiableMap(internalInputModels);
		}
		return inputModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Model> getInoutModels() {
		if (inoutModels == null) {
			inoutModels = Collections.unmodifiableMap(internalInoutModels);
		}
		return inoutModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Model> getOutputModels() {
		if (outputModels == null) {
			outputModels = Collections.unmodifiableMap(internalOutputModels);
		}
		return outputModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Module loadModule(final ModuleResolver resolver, final String name) {
		resetJITCompiler();
		if (isRuleStateCompiled()) {
			for (Rule r : getRules()) {
				r.resetState();
			}
		}
		setRuleStateCompiled(false);
		try {
			//detect cyclic imports w.r.t. redefinition
			if (internalModules.containsKey(name)) {
				if (!loadedModules.contains(name)) {
					ATLLogger.warning(String.format(
							"Cyclic import of module %s detected; element redefinition will not work",
							name));
				}
				return internalModules.get(name);
			}
			final Module module = resolver.resolveModule(name);
			if (module.eResource() != null) { // skip built-in native modules
				final Model mmodel = EmftvmFactory.eINSTANCE.createModel();
				mmodel.setResource(module.eResource());
				final IValidator<EObject> validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
				final IStatus results = validator.validate(mmodel.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock()));
				if (!results.isOK()) {
					throw new CoreException(results);
				}
			}
			internalModules.put(name, module);
			resolveImports(module, resolver);
			for (Feature f : module.getFeatures()) {
				registerFeature(f);
			}
			for (Rule r : module.getRules()) {
				registerRule(r);
			}
			// Re-resolve all super-rules, because they may have been redefined
			for (Rule r : getRules()) {
				resolveSuperRules(r);
			}
			loadedModules.add(name);
			return module;
		} catch (Exception e) {
			throw new VMException(null, String.format(
					"Error during module loading: %s", 
					e.getMessage()), e);
		}
	}

	/**
	 * Resolves the imports list of module.
	 * @param module
	 * @param resolver
	 */
	private void resolveImports(final Module module, final ModuleResolver resolver) {
		final EList<Module> eImports = module.getEImports();
		for (String imp : module.getImports()) {
			Module impModule = loadModule(resolver, imp);
			eImports.add(impModule);
		}
	}

	/**
	 * Registers a {@link Feature} into this {@link ExecEnv}.
	 * @param feature the {@link Feature} to register
	 */
	protected void registerFeature(final Feature feature) {
		feature.setEContext(findEClassifier(feature.getContextModel(), feature.getContext()));
		feature.setEType(findEClassifier(feature.getTypeModel(), feature.getType()));
		switch (feature.eClass().getClassifierID()) {
		case EmftvmPackage.FIELD:
			fieldContainer.registerField((Field)feature);
			break;
		case EmftvmPackage.OPERATION:
			registerOperation((Operation)feature);
			break;
		default:
			throw new IllegalArgumentException(String.format("Feature of class %s not supported", feature.eClass()));
		}
	}

	/**
	 * Registers op in the corresponding lookup table.
	 * @param op
	 */
	private void registerOperation(final Operation op) {
		if (op.isStatic()) {
			if (EMFTVMUtil.MAIN_OP_NAME.equals(op.getName()) && op.getParameters().isEmpty()) {
				// main() is special, and cannot be invoked programmatically
				mainChain.add(op);
			} else {
				registerOperationIn(op, staticOperations);
			}
		} else {
			registerOperationIn(op, operations);
		}
	}

	/**
	 * Registers op in the corresponding lookup table.
	 * @param op
	 * @param reg
	 */
	@SuppressWarnings("unchecked")
	private void registerOperationIn(final Operation op, final Map<String, Map<Integer, TypeMap<Object, Object>>> reg) {
		final EList<Parameter> args = op.getParameters();
		final Integer argCount = args.size();
		final String opname = op.getName();

		// register operation in lookup table
		Map<Integer, TypeMap<Object, Object>> argcountOpsMap = reg.get(opname);
		if (argcountOpsMap == null) {
			argcountOpsMap = new HashMap<Integer, TypeMap<Object,Object>>();
			reg.put(opname, argcountOpsMap);
		}
		final EClassifier ectx = op.getEContext();
		assert ectx != null;
		final Object ctx = EMFTVMUtil.getRegistryType(ectx);
		TypeMap<Object, Object> ctxMap = argcountOpsMap.get(argCount);
		if (ctxMap == null) {
			ctxMap = new TypeHashMap<Object, Object>();
			argcountOpsMap.put(argCount, ctxMap);
		}
		if (argCount == 0) {
			ctxMap.put(ctx, op);
		} else {
			TypeMap<Object, Object> opsMap = (TypeMap<Object, Object>)ctxMap.get(ctx);
			if (opsMap == null) {
				opsMap = new TypeHashMap<Object, Object>();
				ctxMap.put(ctx, opsMap);
			}
			registerOperationByArgTypes(op, opsMap, getTypesOfParameters(op.getParameters()), 0);
		}

	}

	/**
	 * Retrieves the registry types of the elements of <pre>eList</pre>.
	 * @param eList
	 * @return the registry types of elements
	 */
	private Object[] getTypesOfParameters(EList<Parameter> eList) {
		final Object[] types = new Object[eList.size()];
		for (int i = 0; i < types.length; i++) {
			Parameter par = eList.get(i);
			par.setEType(findEClassifier(par.getTypeModel(), par.getType()));
			types[i] = EMFTVMUtil.getRegistryType(par.getEType());
		}
		return types;
	}

	/**
	 * Registers op in reg.
	 * @param op
	 * @param reg the current depth registry
	 * @param argTypes the argument types to use for registering
	 * @param argIndex the current argument index for the current depth registry
	 */
	@SuppressWarnings("unchecked")
	private static void registerOperationByArgTypes(final Operation op, final TypeMap<Object, Object> reg, final Object[] argTypes, final int argIndex) {
		final int argCount = argTypes.length;
		assert argIndex >= 0 && argIndex < argCount;
		final Object regType = argTypes[argIndex];
		if (argIndex < argCount - 1) {
			TypeMap<Object, Object> nestedReg = (TypeMap<Object, Object>)reg.get(regType);
			if (nestedReg == null) {
				nestedReg = new TypeHashMap<Object, Object>();
				reg.put(regType, nestedReg);
			}
			registerOperationByArgTypes(op, nestedReg, argTypes, argIndex + 1);
		} else {
			reg.put(regType, op);
		}
	}

	/**
	 * Checks whether the types of <pre>first</pre> are more specific than the types of <pre>second</pre>.
	 * @param first the first list of parameters to compare
	 * @param second the second list of parameters to compare
	 * @param index the comparison index (start at 0)
	 * @return <code>true</code> iff the types of <pre>first</pre> are more specific than the types of <pre>second</pre>
	 */
	private static boolean isMoreSpecific(
			final EList<Parameter> first, 
			final EList<Parameter> second, 
			final int index) {
		assert first.size() == second.size();
		final EClassifier f = first.get(index).getEType();
		final EClassifier s = second.get(index).getEType();
		assert f != null;
		assert s != null;
		if (f == s && index < first.size() - 1) {
			return isMoreSpecific(first, second, index + 1);
		}
		if (f instanceof EClass && s instanceof EClass) {
			return ((EClass)s).isSuperTypeOf((EClass)f);
		} else {
			assert f instanceof EClass || f.getInstanceClass() != null;
			assert s instanceof EClass || s.getInstanceClass() != null;
			final Class<?> fCls = f.getInstanceClass() == null ? EObject.class : f.getInstanceClass();
			final Class<?> sCls = s.getInstanceClass() == null ? EObject.class : s.getInstanceClass();
			assert fCls != null;
			assert sCls != null;
			if (fCls == sCls && index < first.size() - 1) {
				return isMoreSpecific(first, second, index + 1);
			}
			return sCls.isAssignableFrom(fCls);
		}
	}

	/**
	 * Checks whether the types of <pre>first</pre> are more specific than the types of <pre>second</pre>.
	 * @param first the first operation to compare
	 * @param second the second operation to compare
	 * @return <code>true</code> iff the types of <pre>first</pre> are more specific than the types of <pre>second</pre>
	 */
	private static boolean isMoreSpecific(
			final Operation first, 
			final Operation second) {
		final EClassifier f = first.getEContext();
		final EClassifier s = second.getEContext();
		assert f != null;
		assert s != null;
		if (f == s) {
			return isMoreSpecific(first.getParameters(), second.getParameters(), 0);
		}
		if (f instanceof EClass && s instanceof EClass) {
			return ((EClass) s).isSuperTypeOf((EClass)f);
		} else {
			assert f instanceof EClass || f.getInstanceClass() != null;
			assert s instanceof EClass || s.getInstanceClass() != null;
			final Class<?> fCls = f.getInstanceClass() == null ? EObject.class : f.getInstanceClass();
			final Class<?> sCls = s.getInstanceClass() == null ? EObject.class : s.getInstanceClass();
			assert fCls != null;
			assert sCls != null;
			if (fCls == sCls) {
				return isMoreSpecific(first.getParameters(), second.getParameters(), 0);
			}
			return sCls.isAssignableFrom(fCls);
		}
	}

	/**
	 * Registers a {@link Rule} into this {@link ExecEnv}.
	 * @param rule the {@link Rule} to register
	 */
	protected void registerRule(final Rule r) {
		//TODO check rule redefinition consistency? (types, mapsTo, ...)
		final String rName = r.getName();
		if (rules.containsKey(rName)) {
			final Rule oldRule = rules.get(rName);
			if (r.getMode() != oldRule.getMode()) {
				throw new IllegalArgumentException(String.format(
						"Rule %s with mode %s cannot redefine existing rule with mode %s", 
						rName, r.getMode(), oldRule.getMode()));
			}
		}
		rules.put(rName, r);

		for (RuleElement re : r.getInputElements()) {
			resolveRuleElement(re);
		}

		for (OutputRuleElement re : r.getOutputElements()) {
			resolveRuleElement(re);
		}

		for (Field field : r.getFields()) {
			field.setEContext(findEClassifier(field.getContextModel(), field.getContext()));
			field.setEType(findEClassifier(field.getTypeModel(), field.getType()));
			r.registerField(field);
		}
	}

	/**
	 * Resolves type references in <pre>re</pre>.
	 * @param re the rule element to resolve references for
	 * @throws IllegalArgumentException when a reference cannot be resolved
	 */
	private void resolveRuleElement(final RuleElement re) {
		re.setEType(findEClassifier(re.getTypeModel(), re.getType()));
	}

	/**
	 * Resolves the super rule references in rule.
	 * @param rule the rule to resolve references for
	 */
	private void resolveSuperRules(final Rule rule) {
		final EList<Rule> eSuperRules = rule.getESuperRules();
		eSuperRules.clear();
		for (String superRuleName : rule.getSuperRules()) {
			Rule superRule = findRule(superRuleName);
			if (superRule == null) {
				throw new IllegalArgumentException(String.format(
						"Super-rule %s of %s is not found in any module loaded before %s",
						superRuleName, rule.getName(), rule.getModule()));
			}
			//check rule type consistency
			if (superRule.getMode() != rule.getMode()) {
				throw new IllegalArgumentException(String.format(
						"Rule %s with mode %s cannot inherit from super-rule %s with mode %s", 
						rule.getName(), rule.getMode(), superRule.getName(), superRule.getMode()));
			}
			//check type consistency of rule element declarations
			for (OutputRuleElement sre : superRule.getOutputElements()) {
				for (OutputRuleElement re : rule.getOutputElements()) {
					if (sre.getName().equals(re.getName())) {
						if (!((EClass)sre.getEType()).isSuperTypeOf((EClass)re.getEType())) {
							throw new IllegalArgumentException(String.format(
									"Output element %s of type %s in rule %s is not compatible with element %s of type %s in super-rule %s",
									re.getName(),
									EMFTVMUtil.toPrettyString(re.getEType(), this), 
									rule.getName(),
									sre.getName(),
									EMFTVMUtil.toPrettyString(sre.getEType(), this), 
									superRule.getName()));
						}
					}
				}
			}
			eSuperRules.add(superRule);
		}
	}

	/**
	 * Resolves model references for a {@link Rule}.
	 * @param rule the {@link Rule} to resolve
	 */
	protected void resolveRuleModels(final Rule r) {
		final Map<String, Model> inModels = new LinkedHashMap<String, Model>(getInputModels());
		inModels.putAll(getInoutModels());
		for (RuleElement re : r.getInputElements()) {
			resolveRuleElementModels(re, inModels);
		}

		final Map<String, Model> outModels = new LinkedHashMap<String, Model>(getOutputModels());
		outModels.putAll(getInoutModels());
		for (OutputRuleElement re : r.getOutputElements()) {
			resolveRuleElementModels(re, outModels);
		}
	}

	/**
	 * Resolves model references in <pre>re</pre>.
	 * @param re the rule element to resolve references for
	 * @param models the map of models resolve from
	 * @throws IllegalArgumentException when a reference cannot be resolved
	 */
	private void resolveRuleElementModels(final RuleElement re, final Map<String, Model> models) {
		re.setEType(findEClassifier(re.getTypeModel(), re.getType()));
		final EList<Model> eModels = re.getEModels();
		eModels.clear();
		for (String modelName : re.getModels()) {
			final Model model = models.get(modelName);
			if (model == null) {
				throw new IllegalArgumentException(String.format("Model %s not found", modelName));
			}
			eModels.add(model);
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Operation findOperation(final Object context, final String name, final Object[] parameterTypes) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = operations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final int argCount = parameterTypes.length;
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(argCount);
			
			if (ctxMap != null) {
				// There are operations with argCount arguments
				// First try to find with direct types
				TypeMap<Object, Object> argMap = (TypeMap<Object, Object>)ctxMap.get(context);
				if (argMap != null) {
					op = findOperationDirect(argMap, parameterTypes, 0);
				}
				// Fall back to full resolving algorithm
				if (op == null) {
					final Set<Object> ctxKeys = new HashSet<Object>();
					ctxMap.findAllKeys(context, ctxKeys);
					final Set<Operation> ops = new LinkedHashSet<Operation>();
					for (Object ctxKey : ctxKeys) {
						// There are operations defined on the given context type
						argMap = (TypeMap<Object, Object>)ctxMap.get(ctxKey);
						findOperations(argMap, parameterTypes, ops, 0);
					}
					op = findMostSpecificOperation(ops);
					if (op != null) {
						// Now register directly under context type
						argMap = (TypeMap<Object, Object>)ctxMap.get(context);
						if (argMap == null) {
							argMap = new TypeHashMap<Object, Object>();
							ctxMap.put(context, argMap);
						}
						registerOperationByArgTypes(op, argMap, parameterTypes, 0);
					}
				}
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Operation findOperation(Object context, String name) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = operations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(0);
			
			if (ctxMap != null) {
				// There are operations with 0 arguments
				// First try to find with direct type
				op = (Operation)ctxMap.get(context);
				// Fall back to full resolving algorithm
				if (op == null) {
					final Object ctxKey = ctxMap.findKey(context);
					if (ctxKey != null) {
						// There is an operation with the given context type
						op = (Operation)ctxMap.get(ctxKey);
						assert op != null;
						// Now register directly under context type
						ctxMap.put(context, op);
					}
				}
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Operation findOperation(Object context, String name, Object parameterType) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = operations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(1);
			
			if (ctxMap != null) {
				// There are operations with 1 argument
				// First try to find with direct types
				TypeMap<Object, Object> argMap = (TypeMap<Object, Object>)ctxMap.get(context);
				if (argMap != null) {
					op = (Operation)argMap.get(parameterType);
				}
				// Fall back to full resolving algorithm
				if (op == null) {
					final Set<Object> ctxKeys = new HashSet<Object>();
					ctxMap.findAllKeys(context, ctxKeys);
					final Set<Operation> ops = new LinkedHashSet<Operation>();
					for (Object ctxKey : ctxKeys) {
						// There are operations defined on the given context type
						argMap = (TypeMap<Object, Object>)ctxMap.get(ctxKey);
						final Set<Object> argTypeKeys = new HashSet<Object>();
						argMap.findAllKeys(parameterType, argTypeKeys);
						for (Object argTypeKey : argTypeKeys) {
							// There are operations defined on all given parameter types
							ops.add((Operation)argMap.get(argTypeKey));
						}
					}
					op = findMostSpecificOperation(ops);
					if (op != null) {
						// Now register directly under context type
						argMap = (TypeMap<Object, Object>)ctxMap.get(context);
						if (argMap == null) {
							argMap = new TypeHashMap<Object, Object>();
							ctxMap.put(context, argMap);
						}
						argMap.put(parameterType, op);
					}
				}
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasOperation(String name, int argcount) {
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = operations.get(name);
		if (argcountOpsMap != null) { // There are operations with the given name
			return argcountOpsMap.get(argcount) != null;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Operation findStaticOperation(Object context, final String name, final Object[] parameterTypes) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = staticOperations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final int argCount = parameterTypes.length;
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(argCount);
			
			if (ctxMap != null) {
				// There are operations with argCount arguments
				// Static operations must be defined in exact context type
				TypeMap<Object, Object> argMap = (TypeMap<Object, Object>)ctxMap.get(context);
				if (argMap != null) {
					// First try to find with direct types
					op = findOperationDirect(argMap, parameterTypes, 0);
					// Fall back to full resolving algorithm
					if (op == null) {
						final Set<Operation> ops = new LinkedHashSet<Operation>();
						findOperations(argMap, parameterTypes, ops, 0);
						op = findMostSpecificOperation(ops);
						if (op != null) {
							// Now register directly under context type
							registerOperationByArgTypes(op, argMap, parameterTypes, 0);
						}
					}
				}
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Operation findStaticOperation(Object context, String name) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = staticOperations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(0);
			
			if (ctxMap != null) {
				// There are operations with 0 arguments
				// Static operations must be defined in exact context type
				op = (Operation)ctxMap.get(context);
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Operation findStaticOperation(Object context, String name, Object parameterType) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = staticOperations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(1);
			
			if (ctxMap != null) {
				// There are operations with 1 argument
				// Static operations must be defined in exact context type
				TypeMap<Object, Object> argMap = (TypeMap<Object, Object>)ctxMap.get(context);
				if (argMap != null) {
					// First try to find with direct types
					op = (Operation)argMap.get(parameterType);
					// Fall back to full resolving algorithm
					if (op == null) {
						final Set<Operation> ops = new LinkedHashSet<Operation>();
						final Set<Object> argTypeKeys = new HashSet<Object>();
						argMap.findAllKeys(parameterType, argTypeKeys);
						for (Object argTypeKey : argTypeKeys) {
							// There are operations defined on all given parameter types
							ops.add((Operation)argMap.get(argTypeKey));
						}
						op = findMostSpecificOperation(ops);
						if (op != null) {
							// Now register directly under context type
							argMap = (TypeMap<Object, Object>)ctxMap.get(context);
							if (argMap == null) {
								argMap = new TypeHashMap<Object, Object>();
								ctxMap.put(context, argMap);
							}
							argMap.put(parameterType, op);
						}
					}
				}
			}
		}
		
		return op;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasStaticOperation(String name, int argcount) {
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = staticOperations.get(name);
		if (argcountOpsMap != null) { // There are operations with the given name
			return argcountOpsMap.get(argcount) != null;
		}
		return false;
	}

	/**
	 * Attempts to find an operation using direct type dispatch, ignoring any supertypes.
	 * @param typeMap
	 * @param parameterTypes
	 * @param argIndex
	 * @return the operation, or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	private static Operation findOperationDirect(final TypeMap<Object, Object> typeMap, Object[] parameterTypes, 
			final int argIndex) {
		final int argCount = parameterTypes.length;
		assert argIndex >= 0 && argIndex < argCount;
		final Object argType = parameterTypes[argIndex];
		
		if (argIndex < argCount - 1) {
			final TypeMap<Object, Object> nestedTypeMap = (TypeMap<Object, Object>)typeMap.get(argType);
			if (nestedTypeMap != null) {
				return findOperationDirect(nestedTypeMap, parameterTypes, argIndex + 1);
			}
			return null;
		} else {
			return (Operation)typeMap.get(argType);
		}
	}

	/**
	 * Finds all operations that correspond to the given types, and adds them to <pre>ops</pre>.
	 * @param typeMap
	 * @param parameterTypes
	 * @param ops
	 * @param argIndex
	 */
	@SuppressWarnings("unchecked")
	private static void findOperations(final TypeMap<Object, Object> typeMap, final Object[] parameterTypes, 
			final Set<Operation> ops, final int argIndex) {
		final int argCount = parameterTypes.length;
		assert argIndex >= 0 && argIndex < argCount;
		final Object argType = parameterTypes[argIndex];
		final Set<Object> argTypeKeys = new HashSet<Object>();
		typeMap.findAllKeys(argType, argTypeKeys);
		
		if (argIndex < argCount - 1) {
			for (Object argTypeKey : argTypeKeys) {
				// There are operations defined on the given parameter type so far...
				TypeMap<Object, Object> nestedTypeMap = (TypeMap<Object, Object>)typeMap.get(argTypeKey);
				findOperations(nestedTypeMap, parameterTypes, ops, argIndex + 1);
			}
		} else {
			for (Object argTypeKey : argTypeKeys) {
				// There are operations defined on all given parameter types
				ops.add((Operation)typeMap.get(argTypeKey));
			}
		}
	}

	/**
	 * Finds the most-specific operation from <pre>ops</pre>, based on context/argument types
	 * @param ops
	 * @return Most-specific operation from <pre>ops</pre>, based on context/argument types
	 * @throws DuplicateEntryException when more than one operation was found to be most-specific
	 */
	private static Operation findMostSpecificOperation(final Collection<Operation> ops) {
		Operation msOp = null;
		final Set<Operation> conflicts = new HashSet<Operation>();

		// First iteration to find most-specific op
		for (Operation op : ops) {
			if (msOp == null || isMoreSpecific(op, msOp)) {
				msOp = op;
			} else if (!isMoreSpecific(msOp, op)) {
				conflicts.add(op); //temporary conflict situation -- may not have found most-specific yet
			}
		}
		assert msOp != null || (ops.isEmpty() && conflicts.isEmpty());

		// Second iteration to resolve conflicts
		for (Operation op : conflicts) {
			if (!isMoreSpecific(msOp, op)) {
				throw new DuplicateEntryException(String.format(
						"More than one operation found for given context/arguments: %s and %s",
						msOp, op));
			}
		}

		return msOp;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Field findField(final Object context, final String name) {
		return fieldContainer.findField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasField(final String name) {
		return fieldContainer.hasField(name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Field findStaticField(Object context, String name) {
		return fieldContainer.findStaticField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasStaticField(final String name) {
		return fieldContainer.hasStaticField(name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Rule findRule(String name) {
		return rules.get(name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object findType(String modelName, String typeName) throws ClassNotFoundException {
		if (EMFTVMUtil.NATIVE.equals(modelName)) {
			return NativeTypes.findType(typeName);
		} else {
			final Metamodel mm = getMetaModels().get(modelName);
			if (mm == null) {
				throw new IllegalArgumentException(String.format("Metamodel %s not found", modelName));
			}
			return mm.findType(typeName);
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Object run(final TimingData timingData) {
		Object result = null;
		try {
			assert deletionQueue.isEmpty();
			for (Rule r : getRules()) {
				resolveRuleModels(r);
			}
			if (!isRuleStateCompiled()) {
				for (Rule r : getRules()) {
					r.compileState(this); // compile internal state for all registered rules
				}
			}
			final Iterator<Operation> mains = mainChain.iterator();
			if (!mains.hasNext()) {
				throw new UnsupportedOperationException(String.format("Operation %s not found", EMFTVMUtil.MAIN_OP_NAME));
			}
			final StackFrame rootFrame = new StackFrame(this, mainChain.get(mainChain.size() - 1).getBody());
			// run all automatic rules before main
			matchAllSingle(rootFrame, timingData); 
			matchAllRecursive(rootFrame, timingData); 
			while (mains.hasNext()) {
				CodeBlock cb = mains.next().getBody();
				StackFrame rFrame = cb.execute(new StackFrame(this, cb));
				if (!rFrame.stackEmpty()) {
					result = rFrame.pop();
				}
			}
			deleteQueue(); // process any leftover elements
			if (monitor != null) {
				monitor.terminated();
			}
		} catch (VMException e) {
			if (monitor != null) {
				monitor.error(e.getFrame(), e.getLocalizedMessage(), e);
				monitor.terminated();
			}
			throw e;
		} finally {
			this.matches = null;
			this.traces = null;
			this.uniqueResults = null;
			findStaticField(eClass(), "matches").clear();
			findStaticField(eClass(), "traces").clear();
			assert findStaticField(eClass(), "matches").getStaticValue() == null;
			assert findStaticField(eClass(), "traces").getStaticValue() == null;
		}
		return result;
	}

	/**
	 * Finds the {@link EClassifier} for the given (meta-)<pre>modelName</pre> and <pre>typeName</pre>.
	 * @param modelName the name under which the metamodel that contains the type is registered
	 * @param typeName the type/metaclass name (may be fully qualified using '<pre>::</pre>')
	 * @return the type/metaclass, or <code>null</code> if not found
	 */
	private EClassifier findEClassifier(String modelName, String typeName) {
		try {
			final Object type = findType(modelName, typeName);
			if (type instanceof Class<?>) {
				// Wrap Java class
				final EDataType dt = EcoreFactory.eINSTANCE.createEDataType();
				dt.setName(typeName);
				dt.setInstanceClass((Class<?>)type);
				return dt;
			} else {
				return (EClassifier)type;
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Caches run-time models in various lookup tables.
	 */
	protected synchronized void cacheModels() {
		cacheMetaModels(getMetaModels(), metaModelOf);
		cacheModels(getInputModels(), inputModelOf);
		cacheModels(getOutputModels(), outputModelOf);
		cacheModels(getInoutModels(), inoutModelOf);
		cacheModels(getMetaModels(), null);
		modelCacheInit = true;
	}

	/**
	 * Clears the model caches.
	 */
	protected synchronized void clearModelCaches() {
		metaModelOf.clear();
		modelOf.clear();
		inputModelOf.clear();
		inoutModelOf.clear();
		outputModelOf.clear();
		metaModelId.clear();
		modelId.clear();
		modelCacheInit = false;
	}

	/**
	 * Caches <code>models</code> in various lookup tables.
	 * @param models
	 * @param thisModelOf local resource to model map
	 */
	private void cacheModels(final Map<String, ? extends Model> models, final Map<Resource, Model> thisModelOf) {
		for (Entry<String, ? extends Model> entry : models.entrySet()) {
			String id = entry.getKey();
			Model model = entry.getValue();
			modelOf.put(model.getResource(), model);
			if (thisModelOf != null) {
				thisModelOf.put(model.getResource(), model);
			}
			modelId.put(model, id);
		}
	}

	/**
	 * Caches <code>models</code> in various lookup tables.
	 * @param models
	 * @param thisModelOf local resource to model map
	 */
	private void cacheMetaModels(final Map<String, ? extends Metamodel> models, final Map<Resource, Metamodel> thisModelOf) {
		for (Entry<String, ? extends Metamodel> entry : models.entrySet()) {
			String id = entry.getKey();
			Metamodel model = entry.getValue();
			if (thisModelOf != null) {
				thisModelOf.put(model.getResource(), model);
			}
			metaModelId.put(model, id);
		}
	}

	/**
	 * Matches all {@link RuleMode#AUTOMATIC_SINGLE} rules.
	 * @param frame the stack frame context
	 * @param timingData the timing data object to update
	 */
	private void matchAllSingle(final StackFrame frame, final TimingData timingData) {
		final List<Rule> rules = getRules();
		// Match automatic single rules
		final Set<Rule> matchedRules = new LinkedHashSet<Rule>();
		boolean match;
		do {
			match = false;
			for (Rule rule : rules) {
				// Only match rules for which all super-rules have already been matched
				if (!matchedRules.contains(rule) && matchedRules.containsAll(rule.getESuperRules())) {
					if (rule.matchSingle(frame)) {
						match = true;
						matchedRules.add(rule); // only add rules that match
					}
				}
			}
		} while (match);
		// Create traces for automatic single rules
		for (Rule rule : matchedRules) {
			rule.createTraces(frame);
		}
		if (timingData != null) timingData.finishMatch();
		// Apply rules
		for (Rule rule : matchedRules) {
			rule.apply(frame);
		}
		if (timingData != null) timingData.finishApply();
		// Run post-apply
		for (Rule rule : matchedRules) {
			rule.postApply(frame);
		}
		deleteQueue();
		if (timingData != null) timingData.finishPostApply();
	}

	/**
	 * Matches all {@link RuleMode#AUTOMATIC_RECURSIVE} rules.
	 * @param frame the stack frame context
	 * @param timingData the timing data object to update
	 */
	private void matchAllRecursive(final StackFrame frame, final TimingData timingData) {
		final List<Rule> rules = getRules();
		final Set<Rule> matchedRules = new LinkedHashSet<Rule>();
		
		boolean outerMatch;
		do {
			outerMatch = false;
			
			// Match automatic recursive rules
			matchedRules.clear();
			boolean match;
			MATCHER:
			do {
				match = false;
				for (Rule rule : rules) {
					// Only match rules for which all super-rules have already been matched
					if (!matchedRules.contains(rule) && matchedRules.containsAll(rule.getESuperRules())) {
						boolean[] matchResult = rule.matchRecursive(frame);
						if (matchResult[1]) { // Guaranteed final match
							outerMatch = true;
							matchedRules.add(rule);
							break MATCHER;
						} else if (matchResult[0]) {
							match = true;
							matchedRules.add(rule);
							outerMatch |= !rule.isAbstract();
						}
					}
				}
			} while (match);

			for (Rule rule : matchedRules) {
				if (rule.applyFirst(frame)) {
					break;
				}
			}
			
		} while (outerMatch);		

		if (timingData != null) {
			timingData.finishRecursive();
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LazyList<Rule> getRules() {
		return new LazyList<Rule>(rules.values());
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Model getModelOf(EObject object) {
		if (!modelCacheInit) {
			cacheModels();
		}
		final Resource r = object.eResource();
		return (r == null) ? null : modelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getModelID(Model model) {
		if (!modelCacheInit) {
			cacheModels();
		}
		return (model == null) ? null : modelId.get(model);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMetaModelID(final Metamodel metamodel) {
		if (!modelCacheInit) {
			cacheModels();
		}
		return (metamodel == null) ? null : metaModelId.get(metamodel);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void queueForDelete(final EObject element, final StackFrame frame) {
		deletionQueue.offer(new DeletionEntry(element, frame));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteQueue() {
		while (!deletionQueue.isEmpty()) {
			deletionQueue.poll().delete();
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Model getInputModelOf(EObject object) {
		if (!modelCacheInit) {
			cacheModels();
		}
		final Resource r = object.eResource();
		return (r == null) ? null : inputModelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Model getInoutModelOf(EObject object) {
		if (!modelCacheInit) {
			cacheModels();
		}
		final Resource r = object.eResource();
		return (r == null) ? null : inoutModelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Model getOutputModelOf(EObject object) {
		if (!modelCacheInit) {
			cacheModels();
		}
		final Resource r = object.eResource();
		return (r == null) ? null : outputModelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__META_MODELS:
				return getMetaModels();
			case EmftvmPackage.EXEC_ENV__INPUT_MODELS:
				return getInputModels();
			case EmftvmPackage.EXEC_ENV__INOUT_MODELS:
				return getInoutModels();
			case EmftvmPackage.EXEC_ENV__OUTPUT_MODELS:
				return getOutputModels();
			case EmftvmPackage.EXEC_ENV__MODULES:
				return getModules();
			case EmftvmPackage.EXEC_ENV__MATCHES:
				if (resolve) return getMatches();
				return basicGetMatches();
			case EmftvmPackage.EXEC_ENV__TRACES:
				if (resolve) return getTraces();
				return basicGetTraces();
			case EmftvmPackage.EXEC_ENV__UNIQUE_RESULTS:
				return getUniqueResults();
			case EmftvmPackage.EXEC_ENV__JIT_DISABLED:
				return isJitDisabled();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__JIT_DISABLED:
				setJitDisabled((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__JIT_DISABLED:
				setJitDisabled(JIT_DISABLED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__META_MODELS:
				return metaModels != null;
			case EmftvmPackage.EXEC_ENV__INPUT_MODELS:
				return inputModels != null;
			case EmftvmPackage.EXEC_ENV__INOUT_MODELS:
				return inoutModels != null;
			case EmftvmPackage.EXEC_ENV__OUTPUT_MODELS:
				return outputModels != null;
			case EmftvmPackage.EXEC_ENV__MODULES:
				return modules != null;
			case EmftvmPackage.EXEC_ENV__MATCHES:
				return matches != null;
			case EmftvmPackage.EXEC_ENV__TRACES:
				return traces != null;
			case EmftvmPackage.EXEC_ENV__UNIQUE_RESULTS:
				return uniqueResults != null;
			case EmftvmPackage.EXEC_ENV__JIT_DISABLED:
				return jitDisabled != JIT_DISABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (metaModels: ");
		result.append(metaModels);
		result.append(", inputModels: ");
		result.append(inputModels);
		result.append(", inoutModels: ");
		result.append(inoutModels);
		result.append(", outputModels: ");
		result.append(outputModels);
		result.append(", modules: ");
		result.append(modules);
		result.append(", uniqueResults: ");
		result.append(uniqueResults);
		result.append(", jitDisabled: ");
		result.append(jitDisabled);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized CodeBlockJIT getJITCompiler() {
		if (cbJit == null && !isJitDisabled()) {
			cbJit = new CodeBlockJIT(this);
		}
		return cbJit;
	}

	/**
	 * Sets the JIT compiler instance for this execution environment to <code>null</code>.
	 */
	protected synchronized void resetJITCompiler() {
		if (cbJit != null) {
			cbJit.cleanup(); // Clean up all generated JVM bytecode
		}
		cbJit = null;
	}

	/**
	 * Returns whether the internal state of the rules has been compiled.
	 * @return the ruleStateCompiled
	 */
	protected boolean isRuleStateCompiled() {
		return ruleStateCompiled;
	}

	/**
	 * Sets whether the internal state of the rules has been compiled.
	 * @param ruleStateCompiled the ruleStateCompiled to set
	 */
	protected void setRuleStateCompiled(boolean ruleStateCompiled) {
		this.ruleStateCompiled = ruleStateCompiled;
	}

} //ExecEnvImpl
