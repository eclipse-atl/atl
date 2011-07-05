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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.DuplicateEntryException;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.FieldContainer;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.Matcher;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.OCLOperations;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.TypeHashMap;
import org.eclipse.m2m.atl.emftvm.util.TypeMap;
import org.eclipse.m2m.atl.emftvm.util.VMException;


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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl#getDeletionQueue <em>Deletion Queue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecEnvImpl extends EObjectImpl implements ExecEnv {

	/**
	 * The 'EMFTVM!ExecEnv' type.
	 */
	public static final String[] EXEC_ENV_TYPE 		= new String[]{"EMFTVM", "ExecEnv"};

	/**
	 * The 'TRACE!TraceLinkSet' type.
	 */
	public static final String[] TRACE_LINK_SET_TYPE = new String[]{"TRACE", "TraceLinkSet"};

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
	 * The cached value of the '{@link #getDeletionQueue() <em>Deletion Queue</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletionQueue()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> deletionQueue;

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
	protected Map<String, Rule> rules = new LinkedHashMap<String, Rule>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected Map<Resource, Model> modelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected Map<Resource, Model> inputModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected Map<Resource, Model> inoutModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (resource -> model).
	 */
	protected Map<Resource, Model> outputModelOf = new HashMap<Resource, Model>();

	/**
	 * Lookup table of (model -> ID).
	 */
	protected Map<Model, String> modelId = new HashMap<Model, String>();

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link ExecEnvImpl}.
	 * <!-- end-user-doc -->
	 */
	protected ExecEnvImpl() {
		super();
		final Map<String, Metamodel> mms = getMetaModels();
		mms.put(EcorePackage.eNAME.toUpperCase(), EMFTVMUtil.getEcoreMetamodel());
		mms.put(EmftvmPackage.eNAME.toUpperCase(), EMFTVMUtil.getEmfTvmMetamodel());
		mms.put(TracePackage.eNAME.toUpperCase(), EMFTVMUtil.getTraceMetamodel());
		createField("matches", true, EXEC_ENV_TYPE, TRACE_LINK_SET_TYPE, new CodeBlockImpl() {
			@Override
			public Object execute(StackFrame frame) {
				final Map<String, Model> oms = frame.getEnv().getOutputModels();
				if (oms.containsKey("match")) {
					return oms.get("match").newElement(TracePackage.eINSTANCE.getTraceLinkSet());
				} else {
					return TraceFactory.eINSTANCE.createTraceLinkSet();
				}
			}
		});
		createField("traces", true, EXEC_ENV_TYPE, TRACE_LINK_SET_TYPE, new CodeBlockImpl() {
			@Override
			public Object execute(StackFrame frame) {
				final Map<String, Model> oms = frame.getEnv().getOutputModels();
				if (oms.containsKey("trace")) {
					return oms.get("trace").newElement(TracePackage.eINSTANCE.getTraceLinkSet());
				} else {
					return TraceFactory.eINSTANCE.createTraceLinkSet();
				}
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
		final Field f = EmftvmFactory.eINSTANCE.createField();
		f.setName(name);
		f.setContextModel(context[0]);
		f.setContext(context[1]);
		f.setTypeModel(type[0]);
		f.setType(type[1]);
		f.setInitialiser(initialiser);
		f.setStatic(isStatic);
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
	 */
	public Map<String, Module> getModules() {
		if (modules == null) {
			modules = new HashMap<String, Module>();
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getDeletionQueue() {
		if (deletionQueue == null) {
			deletionQueue = new EObjectResolvingEList<EObject>(EObject.class, this, EmftvmPackage.EXEC_ENV__DELETION_QUEUE);
		}
		return deletionQueue;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Map<String, Metamodel> getMetaModels() {
		if (metaModels == null) {
			metaModels = new HashMap<String, Metamodel>();
		}
		return metaModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Map<String, Model> getInputModels() {
		if (inputModels == null) {
			inputModels = new HashMap<String, Model>();
		}
		return inputModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Map<String, Model> getInoutModels() {
		if (inoutModels == null) {
			inoutModels = new HashMap<String, Model>();
		}
		return inoutModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Map<String, Model> getOutputModels() {
		if (outputModels == null) {
			outputModels = new HashMap<String, Model>();
		}
		return outputModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Recursively loads module into the list of modules, and registers its contents for execution.
	 * @param resolver the module resolver
	 * @param name the module name
	 * @return the loaded module
	 * <!-- end-user-doc -->
	 */
	public Module loadModule(final ModuleResolver resolver, final String name) {
		try {
			final Map<String, Module> modules = getModules();
			if (modules.containsKey(name)) {
				return modules.get(name);
			}
			final Module module = resolver.resolveModule(name);
			modules.put(name, module);
			resolveImports(module, resolver);
			for (Feature f : module.getFeatures()) {
				registerFeature(f);
			}
			for (Rule r : module.getRules()) {
				registerRule(r);
			}
			for (Rule r : module.getRules()) {
				resolveSuperRules(r);
			}
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
			Module impModule = getModules().get(imp);
			if (impModule == null) {
				impModule = loadModule(resolver, imp);
			}
			eImports.add(impModule);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Registers feature in the corresponding lookup table.
	 * @param feature
	 * <!-- end-user-doc -->
	 */
	public void registerFeature(final Feature feature) {
		feature.setEContext(findType(feature.getContextModel(), feature.getContext()));
		feature.setEType(findType(feature.getTypeModel(), feature.getType()));
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
			registerOperationIn(op, staticOperations);
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
			par.setEType(findType(par.getTypeModel(), par.getType()));
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
			final Class<?> fCls = f.getInstanceClass();
			final Class<?> sCls = s.getInstanceClass();
			if (fCls == null || sCls == null) {
				return false; // not comparable
			}
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
			final Class<?> fCls = f.getInstanceClass();
			final Class<?> sCls = s.getInstanceClass();
			if (fCls == null || sCls == null) {
				return false; // not comparable
			}
			if (fCls == sCls) {
				return isMoreSpecific(first.getParameters(), second.getParameters(), 0);
			}
			return sCls.isAssignableFrom(fCls);
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * Registers r in the corresponding lookup table.
	 * @param r
	 * <!-- end-user-doc -->
	 */
	public void registerRule(final Rule r) {
		//TODO check rule redefinition consistency? (types, mapsTo, ...)
		rules.put(r.getName(), r);
		for (RuleElement re : r.getInputElements()) {
			resolveRuleElement(re, getInputModels());
		}
		for (OutputRuleElement re : r.getOutputElements()) {
			resolveRuleElement(re, getOutputModels());
		}
		for (Field field : r.getFields()) {
			field.setEContext(findType(field.getContextModel(), field.getContext()));
			field.setEType(findType(field.getTypeModel(), field.getType()));
			r.registerField(field);
		}
	}

	/**
	 * Resolves model and type references in <pre>re</pre>.
	 * @param re the rule element to resolve references for
	 * @param models the map of models resolve from
	 * @throws IllegalArgumentException when a reference cannot be resolved
	 */
	private void resolveRuleElement(final RuleElement re, final Map<String, Model> models) {
		re.setEType(findType(re.getTypeModel(), re.getType()));
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
	 * Resolves the super rule references in rule.
	 * @param rule the rule to resolve references for
	 */
	private void resolveSuperRules(final Rule rule) {
		final EList<Rule> eSuperRules = rule.getESuperRules();
		eSuperRules.clear();
		for (String superRuleName : rule.getSuperRules()) {
			Rule superRule = findRule(superRuleName);
			if (!moduleIsImported(superRule.getModule(), rule.getModule())) {
				throw new IllegalArgumentException(String.format(
						"Super-rule %s of %s is not contained in any module imported by %s",
						superRuleName, rule.getName(), rule.getModule()));
			}
			//TODO check consistency of rule element declarations
			eSuperRules.add(superRule);
		}
	}

	/**
	 * Checks whether <pre>imported</pre> is imported by <pre>module</pre>. 
	 * @param imported the module to check
	 * @param module the importing module
	 * @return <code>true</code> iff <pre>imported</pre> is imported by <pre>module</pre>
	 */
	private boolean moduleIsImported(final Module imported, final Module module) {
		if (module == imported) {
			return true;
		}
		for (Module eImport : module.getEImports()) {
			if (moduleIsImported(imported, eImport)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public Operation findOperation(final Object context, final String name, final EList<Object> parameterTypes) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = operations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final int argCount = parameterTypes.size();
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(argCount);
			
			if (ctxMap != null) {
				// There are operations with argCount arguments
				if (argCount == 0) {

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

				} else { //argCount > 0
					
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
							registerOperationByArgTypes(op, argMap, parameterTypes.toArray(), 0);
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
	 */
	@SuppressWarnings("unchecked")
	public Operation findStaticOperation(Object context, final String name, final EList<Object> parameterTypes) {
		Operation op = null;
		final Map<Integer, TypeMap<Object, Object>> argcountOpsMap = staticOperations.get(name);

		if (argcountOpsMap != null) {
			// There are operations with the given name
			final int argCount = parameterTypes.size();
			final TypeMap<Object, Object> ctxMap = argcountOpsMap.get(argCount);
			
			if (ctxMap != null) {
				// There are operations with argCount arguments
				if (argCount == 0) {

					// Static operations must be defined in exact context type
					op = (Operation)ctxMap.get(context);

				} else { //argCount > 0
					
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
								registerOperationByArgTypes(op, argMap, parameterTypes.toArray(), 0);
							}
						}
					}

				}
			}
		}
		
		return op;
	}

	/**
	 * Attempts to find an operation using direct type dispatch, ignoring any supertypes.
	 * @param typeMap
	 * @param parameterTypes
	 * @param argIndex
	 * @return the operation, or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	private static Operation findOperationDirect(final TypeMap<Object, Object> typeMap, final EList<Object> parameterTypes, 
			final int argIndex) {
		final int argCount = parameterTypes.size();
		assert argIndex >= 0 && argIndex < argCount;
		final Object argType = parameterTypes.get(argIndex);
		
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
	private static void findOperations(final TypeMap<Object, Object> typeMap, final EList<Object> parameterTypes, 
			final Set<Operation> ops, final int argIndex) {
		final int argCount = parameterTypes.size();
		assert argIndex >= 0 && argIndex < argCount;
		final Object argType = parameterTypes.get(argIndex);
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
	 */
	public Field findField(final Object context, final String name) {
		return fieldContainer.findField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Field findStaticField(Object context, String name) {
		return fieldContainer.findStaticField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Rule findRule(String name) {
		return rules.get(name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Object run(final TimingData timingData) {
		assert getDeletionQueue().isEmpty();
		cacheModels();
		final Operation main = findStaticOperation(eClass(), EMFTVMUtil.MAIN_OP_NAME, new BasicEList<Object>());
		if (main == null) {
			throw new UnsupportedOperationException(String.format("Operation %s not found", EMFTVMUtil.MAIN_OP_NAME));
		}
		final CodeBlock cb = main.getBody();
		final StackFrame frame = new StackFrame(this, cb);
		Matcher.matchAll(frame, timingData); // run all automatic rules before main
		final Object result = cb.execute(frame);
		deleteQueue(); // process any leftover elements
		return result;
	}

	/**
	 * Caches run-time models in various lookup tables.
	 */
	private void cacheModels() {
		modelOf.clear();
		inputModelOf.clear();
		inoutModelOf.clear();
		outputModelOf.clear();
		modelId.clear();
		cacheModels(getInputModels(), inputModelOf);
		cacheModels(getOutputModels(), outputModelOf);
		cacheModels(getInoutModels(), inoutModelOf);
		cacheModels(getMetaModels(), null);
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public LazyList<Rule> getRules() {
		return new LazyList<Rule>(rules.values());
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Model getModelOf(EObject object) {
		final Resource r = object.eResource();
		return (r == null) ? null : modelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public String getModelID(Model model) {
		return (model == null) ? null : modelId.get(model);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public void deleteQueue() {
		final EList<EObject> queue = getDeletionQueue();
		for (EObject element : queue) {
			assert getInputModelOf(element) == null;
			Model m = getModelOf(element);
			m.deleteElement(element);
		}
		queue.clear();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Model getInputModelOf(EObject object) {
		final Resource r = object.eResource();
		return (r == null) ? null : inputModelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Model getInoutModelOf(EObject object) {
		final Resource r = object.eResource();
		return (r == null) ? null : inoutModelOf.get(r);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Model getOutputModelOf(EObject object) {
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
			case EmftvmPackage.EXEC_ENV__DELETION_QUEUE:
				return getDeletionQueue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__DELETION_QUEUE:
				getDeletionQueue().clear();
				getDeletionQueue().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.EXEC_ENV__DELETION_QUEUE:
				getDeletionQueue().clear();
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
			case EmftvmPackage.EXEC_ENV__DELETION_QUEUE:
				return deletionQueue != null && !deletionQueue.isEmpty();
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
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public EClassifier findType(String modelName, String typeName) {
		try {
			final Object type = EMFTVMUtil.findType(this, modelName, typeName);
			if (type instanceof Class<?>) {
				// Wrap Java class
				final EDataType dt = EcoreFactory.eINSTANCE.createEDataType();
				dt.setName(typeName);
				dt.setInstanceClass((Class<?>)type);
				return dt;
			} else if (type instanceof EClassifier) {
				return (EClassifier)type;
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

} //ExecEnvImpl
