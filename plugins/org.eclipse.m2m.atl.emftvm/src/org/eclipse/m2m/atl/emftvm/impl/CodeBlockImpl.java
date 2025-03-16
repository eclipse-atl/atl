/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.Get;
import org.eclipse.m2m.atl.emftvm.GetStatic;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.GetTrans;
import org.eclipse.m2m.atl.emftvm.Getcb;
import org.eclipse.m2m.atl.emftvm.Goto;
import org.eclipse.m2m.atl.emftvm.If;
import org.eclipse.m2m.atl.emftvm.Ifn;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Implies;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Insert;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Invoke;
import org.eclipse.m2m.atl.emftvm.InvokeAllCbs;
import org.eclipse.m2m.atl.emftvm.InvokeCb;
import org.eclipse.m2m.atl.emftvm.InvokeCbS;
import org.eclipse.m2m.atl.emftvm.InvokeStatic;
import org.eclipse.m2m.atl.emftvm.InvokeSuper;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.Load;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.MatchS;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Or;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Remove;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT;
import org.eclipse.m2m.atl.emftvm.jit.JITCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.DuplicateEntryException;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.LazyBagOnCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyListOnList;
import org.eclipse.m2m.atl.emftvm.util.LazySetOnSet;
import org.eclipse.m2m.atl.emftvm.util.NativeTypes;
import org.eclipse.m2m.atl.emftvm.util.Stack;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.Tuple;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Block</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getMaxLocals <em>Max Locals</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getMaxStack <em>Max Stack</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getLineNumbers <em>Line Numbers</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getLocalVariables <em>Local Variables</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getMatcherFor <em>Matcher For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getApplierFor <em>Applier For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getPostApplyFor <em>Post Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getBodyFor <em>Body For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getInitialiserFor <em>Initialiser For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getNested <em>Nested</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getNestedFor <em>Nested For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getParentFrame <em>Parent Frame</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl#getBindingFor <em>Binding For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeBlockImpl extends EObjectImpl implements CodeBlock {

	/**
	 * The default value of the '{@link #getMaxLocals() <em>Max Locals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLocals()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_LOCALS_EDEFAULT = -1;

	/**
	 * The default value of the '{@link #getMaxStack() <em>Max Stack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxStack()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_STACK_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMaxLocals() <em>Max Locals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLocals()
	 * @generated NOT
	 * @ordered
	 */
	protected int maxLocals = MAX_LOCALS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaxStack() <em>Max Stack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxStack()
	 * @generated NOT
	 * @ordered
	 */
	protected int maxStack = MAX_STACK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> code;

	/**
	 * The cached value of the '{@link #getLineNumbers() <em>Line Numbers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumbers()
	 * @generated
	 * @ordered
	 */
	protected EList<LineNumber> lineNumbers;

	/**
	 * The cached value of the '{@link #getLocalVariables() <em>Local Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<LocalVariable> localVariables;

	/**
	 * The cached value of the '{@link #getNested() <em>Nested</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNested()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeBlock> nested;

	/**
	 * The default value of the '{@link #getParentFrame() <em>Parent Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentFrame()
	 * @generated
	 * @ordered
	 */
	protected static final StackFrame PARENT_FRAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentFrame() <em>Parent Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentFrame()
	 * @generated NOT
	 * @ordered
	 */
	protected ThreadLocal<StackFrame> parentFrame = new ThreadLocal<StackFrame>();

	/**
	 * Singleton instance of the {@link ExecEnv} {@link EClass}.
	 */
	protected static final EClass EXEC_ENV = EmftvmPackage.eINSTANCE.getExecEnv();

	private static final Object[] EMPTY = new Object[0];
	private static final int JIT_THRESHOLD = 100; // require > JIT_THRESHOLD runs before JIT-ing

	private boolean ruleSet;
	private Rule rule;
	private final Map<Instruction, EList<Instruction>> predecessors = new HashMap<Instruction, EList<Instruction>>();
	private final Map<Instruction, EList<Instruction>> allPredecessors = new HashMap<Instruction, EList<Instruction>>();
	private final Map<Instruction, EList<Instruction>> nlPredecessors = new HashMap<Instruction, EList<Instruction>>();
	private JITCodeBlock jitCodeBlock;
	private int runcount;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link CodeBlockImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlockImpl() {
		super();
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
		return EmftvmPackage.Literals.CODE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getMaxLocals() {
		if (maxLocals == MAX_LOCALS_EDEFAULT) {
			for (final LocalVariable lv : getLocalVariables()) {
				maxLocals = Math.max(maxLocals, lv.getSlot());
			}
			maxLocals++; // highest index + 1
		}
		return maxLocals;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setMaxLocals(final int newMaxLocals) {
		final int oldMaxLocals = maxLocals;
		maxLocals = newMaxLocals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__MAX_LOCALS, oldMaxLocals, maxLocals));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getMaxStack() {
		if (maxStack == MAX_STACK_EDEFAULT) {
			maxStack = 0;
			for (final Instruction instr : getCode()) {
				maxStack = Math.max(maxStack, instr.getStackLevel());
			}
		}
		return maxStack;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setMaxStack(final int newMaxStack) {
		final int oldMaxStack = maxStack;
		maxStack = newMaxStack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__MAX_STACK, oldMaxStack, maxStack));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Instruction> getCode() {
		if (code == null) {
			code = new EObjectContainmentWithInverseEList<Instruction>(Instruction.class, this, EmftvmPackage.CODE_BLOCK__CODE, EmftvmPackage.INSTRUCTION__OWNING_BLOCK);
		}
		return code;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LineNumber> getLineNumbers() {
		if (lineNumbers == null) {
			lineNumbers = new EObjectContainmentWithInverseEList<LineNumber>(LineNumber.class, this, EmftvmPackage.CODE_BLOCK__LINE_NUMBERS, EmftvmPackage.LINE_NUMBER__OWNING_BLOCK);
		}
		return lineNumbers;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LocalVariable> getLocalVariables() {
		if (localVariables == null) {
			localVariables = new EObjectContainmentWithInverseEList<LocalVariable>(LocalVariable.class, this, EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES, EmftvmPackage.LOCAL_VARIABLE__OWNING_BLOCK);
		}
		return localVariables;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getMatcherFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__MATCHER_FOR) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see CodeBlockImpl#setMatcherFor(Rule)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcherFor(final Rule newMatcherFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMatcherFor, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatcherFor(final Rule newMatcherFor) {
		if (newMatcherFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__MATCHER_FOR && newMatcherFor != null)) {
			if (EcoreUtil.isAncestor(this, newMatcherFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMatcherFor != null)
				msgs = ((InternalEObject)newMatcherFor).eInverseAdd(this, EmftvmPackage.RULE__MATCHER, Rule.class, msgs);
			msgs = basicSetMatcherFor(newMatcherFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, newMatcherFor, newMatcherFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getApplierFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__APPLIER_FOR) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setApplierFor(Rule)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplierFor(final Rule newApplierFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newApplierFor, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplierFor(final Rule newApplierFor) {
		if (newApplierFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__APPLIER_FOR && newApplierFor != null)) {
			if (EcoreUtil.isAncestor(this, newApplierFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newApplierFor != null)
				msgs = ((InternalEObject)newApplierFor).eInverseAdd(this, EmftvmPackage.RULE__APPLIER, Rule.class, msgs);
			msgs = basicSetApplierFor(newApplierFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, newApplierFor, newApplierFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getPostApplyFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setPostApplyFor(Rule)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostApplyFor(final Rule newPostApplyFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPostApplyFor, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostApplyFor(final Rule newPostApplyFor) {
		if (newPostApplyFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR && newPostApplyFor != null)) {
			if (EcoreUtil.isAncestor(this, newPostApplyFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPostApplyFor != null)
				msgs = ((InternalEObject)newPostApplyFor).eInverseAdd(this, EmftvmPackage.RULE__POST_APPLY, Rule.class, msgs);
			msgs = basicSetPostApplyFor(newPostApplyFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, newPostApplyFor, newPostApplyFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getBodyFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BODY_FOR) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setBodyFor(Operation)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyFor(final Operation newBodyFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBodyFor, EmftvmPackage.CODE_BLOCK__BODY_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBodyFor(final Operation newBodyFor) {
		if (newBodyFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BODY_FOR && newBodyFor != null)) {
			if (EcoreUtil.isAncestor(this, newBodyFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBodyFor != null)
				msgs = ((InternalEObject)newBodyFor).eInverseAdd(this, EmftvmPackage.OPERATION__BODY, Operation.class, msgs);
			msgs = basicSetBodyFor(newBodyFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__BODY_FOR, newBodyFor, newBodyFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Field getInitialiserFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__INITIALISER_FOR) return null;
		return (Field)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setInitialiserFor(Field)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialiserFor(final Field newInitialiserFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInitialiserFor, EmftvmPackage.CODE_BLOCK__INITIALISER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialiserFor(final Field newInitialiserFor) {
		if (newInitialiserFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__INITIALISER_FOR && newInitialiserFor != null)) {
			if (EcoreUtil.isAncestor(this, newInitialiserFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInitialiserFor != null)
				msgs = ((InternalEObject)newInitialiserFor).eInverseAdd(this, EmftvmPackage.FIELD__INITIALISER, Field.class, msgs);
			msgs = basicSetInitialiserFor(newInitialiserFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__INITIALISER_FOR, newInitialiserFor, newInitialiserFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CodeBlock> getNested() {
		if (nested == null) {
			nested = new EObjectContainmentWithInverseEList<CodeBlock>(CodeBlock.class, this, EmftvmPackage.CODE_BLOCK__NESTED, EmftvmPackage.CODE_BLOCK__NESTED_FOR);
		}
		return nested;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodeBlock getNestedFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__NESTED_FOR) return null;
		return (CodeBlock)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setNestedFor(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedFor(final CodeBlock newNestedFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestedFor, EmftvmPackage.CODE_BLOCK__NESTED_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNestedFor(final CodeBlock newNestedFor) {
		if (newNestedFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__NESTED_FOR && newNestedFor != null)) {
			if (EcoreUtil.isAncestor(this, newNestedFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNestedFor != null)
				msgs = ((InternalEObject)newNestedFor).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__NESTED, CodeBlock.class, msgs);
			msgs = basicSetNestedFor(newNestedFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__NESTED_FOR, newNestedFor, newNestedFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public StackFrame getParentFrame() {
		return parentFrame.get();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setParentFrame(final StackFrame newParentFrame) {
		final StackFrame oldParentFrame = parentFrame.get();
		parentFrame.set(newParentFrame);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__PARENT_FRAME, oldParentFrame, newParentFrame));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputRuleElement getBindingFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BINDING_FOR) return null;
		return (InputRuleElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setBindingFor(InputRuleElement)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindingFor(final InputRuleElement newBindingFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBindingFor, EmftvmPackage.CODE_BLOCK__BINDING_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBindingFor(final InputRuleElement newBindingFor) {
		if (newBindingFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BINDING_FOR && newBindingFor != null)) {
			if (EcoreUtil.isAncestor(this, newBindingFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBindingFor != null)
				msgs = ((InternalEObject)newBindingFor).eInverseAdd(this, EmftvmPackage.INPUT_RULE_ELEMENT__BINDING, InputRuleElement.class, msgs);
			msgs = basicSetBindingFor(newBindingFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__BINDING_FOR, newBindingFor, newBindingFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}

	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#execute(StackFrame)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object execute(final StackFrame frame) {
		final JITCodeBlock jcb = getJITCodeBlock();
		if (jcb != null) {
			return jcb.execute(frame);
		}
		return internalExecute(frame);
	}

	private Object internalExecute(final StackFrame frame) {
		runcount += 1; // increase invocation counter to trigger JIT

		int pc = 0;
		final EList<Instruction> code = getCode();
		final int codeSize = code.size();
		final ExecEnv env = frame.getEnv();
		final VMMonitor monitor = env.getMonitor();
		final Stack stack = new Stack(getMaxStack());
		CodeBlock cb;
		int argcount;

		if (monitor != null) {
			monitor.enter(frame);
		}

		try {
			LOOP: while (pc < codeSize) {
				final Instruction instr = code.get(pc++);
				if (monitor != null) {
					if (monitor.isTerminated()) {
						throw new VMException(frame, "Execution terminated.");
					} else {
						frame.setPc(pc);
						monitor.step(frame);
					}
				}
				switch (instr.getOpcode()) {
				case PUSH:
					stack.push(((Push) instr).getValue());
					break;
				case PUSHT:
					stack.push(true);
					break;
				case PUSHF:
					stack.push(false);
					break;
				case POP:
					stack.popv();
					break;
				case LOAD:
					stack.push(frame.getLocal(((Load) instr).getCbOffset(), ((Load) instr).getSlot()));
					break;
				case STORE:
					frame.setLocal(stack.pop(), ((Store) instr).getCbOffset(), ((Store) instr).getSlot());
					break;
				case SET:
					frame.setPc(pc);
					set(stack.pop(), stack.pop(), ((Set) instr).getFieldname(), frame);
					break;
				case GET:
					frame.setPc(pc);
					stack.push(get(((Get) instr).getFieldname(), frame, stack.pop()));
					break;
				case GET_TRANS:
					frame.setPc(pc);
					stack.push(getTrans(((GetTrans) instr).getFieldname(), frame, stack.pop()));
					break;
				case SET_STATIC:
					setStatic(stack.pop(), stack.pop(), ((SetStatic) instr).getFieldname(), env);
					break;
				case GET_STATIC:
					frame.setPc(pc);
					stack.push(getStatic(((GetStatic) instr).getFieldname(), frame, stack.pop()));
					break;
				case FINDTYPE:
					stack.push(frame.getEnv().findType(((Findtype) instr).getModelname(), ((Findtype) instr).getTypename()));
					break;
				case FINDTYPE_S:
					stack.push(frame.getEnv().findType((String) stack.pop(), (String) stack.pop()));
					break;
				case NEW:
					stack.push(newInstr(((New) instr).getModelname(), stack.pop(), frame));
					break;
				case NEW_S:
					stack.push(newInstr((String) stack.pop(), stack.pop(), frame));
					break;
				case DELETE:
					frame.setPc(pc);
					delete(frame, (EObject) stack.pop());
					break;
				case DUP:
					stack.dup();
					break;
				case DUP_X1:
					stack.dupX1();
					break;
				case SWAP:
					stack.swap();
					break;
				case SWAP_X1:
					stack.swapX1();
					break;
				case IF:
					if ((Boolean) stack.pop()) {
						pc = ((If) instr).getOffset();
					}
					break;
				case IFN:
					if (!(Boolean) stack.pop()) {
						pc = ((Ifn) instr).getOffset();
					}
					break;
				case GOTO:
					pc = ((Goto) instr).getOffset();
					break;
				case ITERATE:
					Iterator<?> i = ((Collection<?>) stack.pop()).iterator();
					if (i.hasNext()) {
						stack.push(i);
						stack.push(i.next());
					} else {
						pc = ((Iterate) instr).getOffset(); // jump over ENDITERATE
					}
					break;
				case ENDITERATE:
					i = (Iterator<?>) stack.pop();
					if (i.hasNext()) {
						stack.push(i);
						stack.push(i.next());
						pc = ((Enditerate) instr).getOffset(); // jump to first loop instruction
					}
					break;
				case INVOKE:
					frame.setPc(pc);
					stack.push(invoke((Invoke) instr, frame, stack));
					break;
				case INVOKE_STATIC:
					frame.setPc(pc);
					stack.push(invokeStatic(((InvokeStatic) instr).getOpname(), ((InvokeStatic) instr).getArgcount(), frame, stack));
					break;
				case INVOKE_SUPER:
					frame.setPc(pc);
					stack.push(invokeSuper(getOperation(), ((InvokeSuper) instr).getOpname(), ((InvokeSuper) instr).getArgcount(), frame,
							stack));
					break;
				case ALLINST:
					stack.push(EMFTVMUtil.findAllInstances((EClass) stack.pop(), env));
					break;
				case ALLINST_IN:
					stack.push(EMFTVMUtil.findAllInstIn(stack.pop(), (EClass) stack.pop(), env));
					break;
				case ISNULL:
					stack.push(stack.pop() == null);
					break;
				case GETENVTYPE:
					stack.push(EXEC_ENV);
					break;
				case NOT:
					stack.push(!(Boolean) stack.pop());
					break;
				case AND:
					cb = ((And) instr).getCodeBlock();
					frame.setPc(pc);
					stack.push((Boolean) stack.pop() && (Boolean) cb.execute(new StackFrame(frame, cb)));
					break;
				case OR:
					cb = ((Or) instr).getCodeBlock();
					frame.setPc(pc);
					stack.push((Boolean) stack.pop() || (Boolean) cb.execute(new StackFrame(frame, cb)));
					break;
				case XOR:
					stack.push((Boolean) stack.pop() ^ (Boolean) stack.pop());
					break;
				case IMPLIES:
					cb = ((Implies) instr).getCodeBlock();
					frame.setPc(pc);
					stack.push(!(Boolean) stack.pop() || (Boolean) cb.execute(new StackFrame(frame, cb)));
					break;
				case IFTE:
					frame.setPc(pc);
					if ((Boolean) stack.pop()) {
						cb = ((Ifte) instr).getThenCb();
					} else {
						cb = ((Ifte) instr).getElseCb();
					}
					stack.push(cb.execute(new StackFrame(frame, cb)));
					break;
				case RETURN:
					break LOOP;
				case GETCB:
					stack.push(((Getcb) instr).getCodeBlock());
					break;
				case INVOKE_ALL_CBS:
					frame.setPc(pc);
					// Use Java's left-to-right evaluation semantics:
					// stack = [..., arg1, arg2]
					argcount = ((InvokeAllCbs) instr).getArgcount();
					final Object[] args = argcount > 0 ? stack.pop(argcount) : EMPTY;
					for (final CodeBlock ncb : getNested()) {
						if (ncb.getStackLevel() > 0) {
							stack.push(ncb.execute(frame.getSubFrame(ncb, args)));
						} else {
							ncb.execute(frame.getSubFrame(ncb, args));
						}
					}
					break;
				case INVOKE_CB:
					cb = ((InvokeCb) instr).getCodeBlock();
					frame.setPc(pc);
					// Use Java's left-to-right evaluation semantics:
					// stack = [..., arg1, arg2]
					argcount = ((InvokeCb) instr).getArgcount();
					if (cb.getStackLevel() > 0) {
						stack.push(cb.execute(frame.getSubFrame(cb, argcount > 0 ? stack.pop(argcount) : EMPTY)));
					} else {
						cb.execute(frame.getSubFrame(cb, argcount > 0 ? stack.pop(argcount) : EMPTY));
					}
					break;
				case INVOKE_CB_S:
					cb = (CodeBlock) stack.pop();
					frame.setPc(pc);
					// Use Java's left-to-right evaluation semantics:
					// stack = [..., arg1, arg2]
					argcount = ((InvokeCbS) instr).getArgcount();
					// unknown code block => always produce one stack element
					stack.push(cb.execute(frame.getSubFrame(cb, argcount > 0 ? stack.pop(argcount) : EMPTY)));
					break;
				case MATCH:
					frame.setPc(pc);
					// Use Java's left-to-right evaluation semantics:
					// stack = [..., arg1, arg2]
					argcount = ((Match) instr).getArgcount();
					stack.push(argcount > 0 ? matchOne(frame, findRule(frame.getEnv(), ((Match) instr).getRulename()),
							stack.pop(argcount, new EObject[argcount])) : matchOne(frame,
									findRule(frame.getEnv(), ((Match) instr).getRulename())));
					break;
				case MATCH_S:
					frame.setPc(pc);
					// stack = [..., arg1, arg2, rule]
					argcount = ((MatchS) instr).getArgcount();
					stack.push(argcount > 0 ? matchOne(frame, (Rule) stack.pop(), stack.pop(argcount, new EObject[argcount])) : matchOne(
							frame, (Rule) stack.pop()));
					break;
				case ADD:
					add(-1, stack.pop(), stack.pop(), ((Add) instr).getFieldname(), frame);
					break;
				case REMOVE:
					remove(stack.pop(), stack.pop(), ((Remove) instr).getFieldname(), frame);
					break;
				case INSERT:
					add((Integer) stack.pop(), stack.pop(), stack.pop(), ((Insert) instr).getFieldname(), frame);
					break;
				case GET_SUPER:
					frame.setPc(pc);
					stack.push(getSuper(getField(), ((GetSuper) instr).getFieldname(), frame, stack.pop()));
					break;
				case GETENV:
					stack.push(env);
					break;
				default:
					throw new VMException(frame, String.format("Unsupported opcode: %s", instr.getOpcode()));
				} // switch
			} // while
		} catch (final VMException e) {
			throw e;
		} catch (final Exception e) {
			frame.setPc(pc);
			throw new VMException(frame, e);
		}

		if (monitor != null) {
			monitor.leave(frame);
		}

		final CodeBlockJIT jc = env.getJITCompiler();
		if (jc != null && runcount > JIT_THRESHOLD) { // JIT everything that runs more than JIT_THRESHOLD
			synchronized (this) {
				if (getJITCodeBlock() == null) {
					try {
						setJITCodeBlock(jc.jit(this));
					} catch (final Exception e) {
						frame.setPc(pc);
						throw new VMException(frame, e);
					} catch (final VerifyError e) {
						frame.setPc(pc);
						throw new VMException(frame, e);
					}
				}
			}
		}

		return stack.stackEmpty() ? null : stack.pop();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getStackLevel() {
		final EList<Instruction> code = getCode();
		if (code.isEmpty()) {
			return 0;
		}
		return code.get(code.size() - 1).getStackLevel();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Module getModule() {
		final EObject container = eContainer();
		if (container != null) {
			switch (container.eClass().getClassifierID()) {
			case EmftvmPackage.FEATURE:
			case EmftvmPackage.FIELD:
			case EmftvmPackage.OPERATION:
				return ((Feature)container).getModule();
			case EmftvmPackage.RULE:
				return ((Rule)container).getModule();
			case EmftvmPackage.INPUT_RULE_ELEMENT:
				return ((InputRuleElement)container).getInputFor().getModule();
			case EmftvmPackage.CODE_BLOCK:
				return ((CodeBlock)container).getModule();
			default:
				break;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Operation getOperation() {
		final EObject container = eContainer();
		if (container != null) {
			switch (container.eClass().getClassifierID()) {
			case EmftvmPackage.OPERATION:
				return (Operation)container;
			case EmftvmPackage.CODE_BLOCK:
				return ((CodeBlock)container).getOperation();
			default:
				break;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Field getField() {
		final EObject container = eContainer();
		if (container != null) {
			switch (container.eClass().getClassifierID()) {
			case EmftvmPackage.FIELD:
				return (Field)container;
			case EmftvmPackage.CODE_BLOCK:
				return ((CodeBlock)container).getField();
			default:
				break;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Instruction> getPredecessors(final Instruction i) {
		if (!predecessors.containsKey(i)) {
			final EList<Instruction> preds = new BasicEList<Instruction>();
			final EList<Instruction> code = getCode();
			final int index = code.indexOf(i);
			assert index > -1;
			if (index > 0) {
				final Instruction prev = code.get(index - 1);
				if (!(prev instanceof Goto)) {
					preds.add(prev);
				}
				for (final Instruction i2 : code) {
					if (i2 instanceof BranchInstruction && ((BranchInstruction)i2).getTarget() == prev) {
						preds.add(i2);
					}
				}
			}
			predecessors.put(i, ECollections.unmodifiableEList(preds));
		}
		return predecessors.get(i);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Instruction> getAllPredecessors(final Instruction i) {
		if (!allPredecessors.containsKey(i)) {
			final EList<Instruction> predecessors = new BasicEList<Instruction>();
			allPredecessors(i, predecessors);
			allPredecessors.put(i, ECollections.unmodifiableEList(predecessors));
		}
		return allPredecessors.get(i);
	}

	/**
	 * Collects the transitive closure of predecessor instructions for <code>i</code>.
	 * @param i the instruction to collect the predecessors for.
	 * @param currentPreds the predecessor instructions.
	 * @return the predecessor instructions.
	 */
	private EList<Instruction> allPredecessors(final Instruction i, final EList<Instruction> currentPreds) {
		final EList<Instruction> preds = getPredecessors(i);
		for (final Instruction pred : preds) {
			if (!currentPreds.contains(pred)) {
				currentPreds.add(pred);
				allPredecessors(pred, currentPreds);
			}
		}
		return currentPreds;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Instruction> getNonLoopingPredecessors(final Instruction i) {
		if (!nlPredecessors.containsKey(i)) {
			final EList<Instruction> code = getCode();
			final int index = code.indexOf(i);
			final EList<Instruction> preds = new BasicEList<Instruction>();
			for (final Instruction p : getPredecessors(i)) {
				if (code.indexOf(p) < index || !getAllPredecessors(p).contains(i)) {
					preds.add(p);
				}
			}
			nlPredecessors.put(i, ECollections.unmodifiableEList(preds));
		}
		return nlPredecessors.get(i);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__CODE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getCode()).basicAdd(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getLineNumbers()).basicAdd(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocalVariables()).basicAdd(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetMatcherFor((Rule)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetApplierFor((Rule)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPostApplyFor((Rule)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetBodyFor((Operation)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInitialiserFor((Field)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__NESTED:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getNested()).basicAdd(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetNestedFor((CodeBlock)otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetBindingFor((InputRuleElement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__CODE:
			return ((InternalEList<?>)getCode()).basicRemove(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			return ((InternalEList<?>)getLineNumbers()).basicRemove(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			return ((InternalEList<?>)getLocalVariables()).basicRemove(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			return basicSetMatcherFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			return basicSetApplierFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			return basicSetPostApplyFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			return basicSetBodyFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			return basicSetInitialiserFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__NESTED:
			return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			return basicSetNestedFor(null, msgs);
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			return basicSetBindingFor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.RULE__MATCHER, Rule.class, msgs);
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.RULE__APPLIER, Rule.class, msgs);
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.RULE__POST_APPLY, Rule.class, msgs);
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.OPERATION__BODY, Operation.class, msgs);
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.FIELD__INITIALISER, Field.class, msgs);
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.CODE_BLOCK__NESTED, CodeBlock.class, msgs);
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			return eInternalContainer().eInverseRemove(this, EmftvmPackage.INPUT_RULE_ELEMENT__BINDING, InputRuleElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__MAX_LOCALS:
			return getMaxLocals();
		case EmftvmPackage.CODE_BLOCK__MAX_STACK:
			return getMaxStack();
		case EmftvmPackage.CODE_BLOCK__CODE:
			return getCode();
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			return getLineNumbers();
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			return getLocalVariables();
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			return getMatcherFor();
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			return getApplierFor();
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			return getPostApplyFor();
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			return getBodyFor();
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			return getInitialiserFor();
		case EmftvmPackage.CODE_BLOCK__NESTED:
			return getNested();
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			return getNestedFor();
		case EmftvmPackage.CODE_BLOCK__PARENT_FRAME:
			return getParentFrame();
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			return getBindingFor();
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
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__MAX_LOCALS:
			setMaxLocals((Integer)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__MAX_STACK:
			setMaxStack((Integer)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__CODE:
			getCode().clear();
			getCode().addAll((Collection<? extends Instruction>)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			getLineNumbers().clear();
			getLineNumbers().addAll((Collection<? extends LineNumber>)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			getLocalVariables().clear();
			getLocalVariables().addAll((Collection<? extends LocalVariable>)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			setMatcherFor((Rule)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			setApplierFor((Rule)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			setPostApplyFor((Rule)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			setBodyFor((Operation)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			setInitialiserFor((Field)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__NESTED:
			getNested().clear();
			getNested().addAll((Collection<? extends CodeBlock>)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			setNestedFor((CodeBlock)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__PARENT_FRAME:
			setParentFrame((StackFrame)newValue);
			return;
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			setBindingFor((InputRuleElement)newValue);
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
	public void eUnset(final int featureID) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__MAX_LOCALS:
			setMaxLocals(MAX_LOCALS_EDEFAULT);
			return;
		case EmftvmPackage.CODE_BLOCK__MAX_STACK:
			setMaxStack(MAX_STACK_EDEFAULT);
			return;
		case EmftvmPackage.CODE_BLOCK__CODE:
			getCode().clear();
			return;
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			getLineNumbers().clear();
			return;
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			getLocalVariables().clear();
			return;
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			setMatcherFor((Rule)null);
			return;
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			setApplierFor((Rule)null);
			return;
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			setPostApplyFor((Rule)null);
			return;
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			setBodyFor((Operation)null);
			return;
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			setInitialiserFor((Field)null);
			return;
		case EmftvmPackage.CODE_BLOCK__NESTED:
			getNested().clear();
			return;
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			setNestedFor((CodeBlock)null);
			return;
		case EmftvmPackage.CODE_BLOCK__PARENT_FRAME:
			setParentFrame(PARENT_FRAME_EDEFAULT);
			return;
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			setBindingFor((InputRuleElement)null);
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
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case EmftvmPackage.CODE_BLOCK__MAX_LOCALS:
			return getMaxLocals() != MAX_LOCALS_EDEFAULT;
		case EmftvmPackage.CODE_BLOCK__MAX_STACK:
			return getMaxStack() != MAX_STACK_EDEFAULT;
		case EmftvmPackage.CODE_BLOCK__CODE:
			return code != null && !code.isEmpty();
		case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			return lineNumbers != null && !lineNumbers.isEmpty();
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			return localVariables != null && !localVariables.isEmpty();
		case EmftvmPackage.CODE_BLOCK__MATCHER_FOR:
			return getMatcherFor() != null;
		case EmftvmPackage.CODE_BLOCK__APPLIER_FOR:
			return getApplierFor() != null;
		case EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR:
			return getPostApplyFor() != null;
		case EmftvmPackage.CODE_BLOCK__BODY_FOR:
			return getBodyFor() != null;
		case EmftvmPackage.CODE_BLOCK__INITIALISER_FOR:
			return getInitialiserFor() != null;
		case EmftvmPackage.CODE_BLOCK__NESTED:
			return nested != null && !nested.isEmpty();
		case EmftvmPackage.CODE_BLOCK__NESTED_FOR:
			return getNestedFor() != null;
		case EmftvmPackage.CODE_BLOCK__PARENT_FRAME:
			return PARENT_FRAME_EDEFAULT == null ? parentFrame != null : !PARENT_FRAME_EDEFAULT.equals(parentFrame);
		case EmftvmPackage.CODE_BLOCK__BINDING_FOR:
			return getBindingFor() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eNotify(final Notification notification) {
		super.eNotify(notification);
		switch (notification.getFeatureID(null)) {
		case EmftvmPackage.CODE_BLOCK__CODE:
			codeChanged();
			for (final Instruction i : getCode()) {
				i.eNotify(notification);
			}
			break;
		case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			localVariablesChanged();
			break;
		case EmftvmPackage.CODE_BLOCK__NESTED:
			nestedChanged();
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer();
		final EObject container = eContainer();
		if (container != null) {
			result.append(container);
			if (container instanceof CodeBlock) {
				result.append('@');
				result.append(((CodeBlock)container).getNested().indexOf(this));
			} else if (container instanceof Field) {
				// nothing
			} else if (container instanceof Operation) {
				// nothing
			} else if (container instanceof InputRuleElement) {
				result.append('@');
				result.append(((InputRuleElement)container).getInputFor());
			} else if (container instanceof Rule) {
				final Rule r = (Rule)container;
				if (r.getMatcher() == this) {
					result.append("@matcher");
				} else if (r.getApplier() == this) {
					result.append("@applier");
				} else if (r.getPostApply() == this) {
					result.append("@postApply");
				} else {
					result.append("@unknown");
				}
			} else {
				result.append("@unknown");
			}
		} else {
			result.append("@uncontained");
		}
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JITCodeBlock getJITCodeBlock() {
		return jitCodeBlock;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setJITCodeBlock(final JITCodeBlock jcb) {
		this.jitCodeBlock = jcb;
	}

	/**
	 * Returns the {@link Module} (for debugger).
	 * @return the {@link Module}
	 * @see CodeBlockImpl#getModule()
	 */
	public Module getASM() {
		return getModule();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rule getRule() {
		if (!ruleSet) {
			CodeBlock cb = this;
			while (cb != null) {
				if (cb.eContainer() instanceof Rule) {
					rule = (Rule)cb.eContainer();
					break;
				} else {
					cb = cb.getNestedFor();
				}
			}
			ruleSet = true;
		}
		return rule;
	}

	/**
	 * @param env
	 * @param type
	 * @param name
	 * @return The {@link Field} with the given <code>type</code> and <code>name</code>, if any, otherwise <code>null</code>
	 */
	private Field findField(final ExecEnv env, final Object type, final String name) {
		final Rule rule = getRule();
		final Field field;
		if (rule != null) {
			field = rule.findField(type, name);
		} else {
			field = null;
		}
		if (field == null) {
			return env.findField(type, name);
		} else {
			return field;
		}
	}

	/**
	 * @param env
	 * @param type
	 * @param name
	 * @return The static {@link Field} with the given <code>type</code> and <code>name</code>, if any, otherwise <code>null</code>
	 */
	private Field findStaticField(final ExecEnv env, final Object type, final String name) {
		final Rule rule = getRule();
		final Field field;
		if (rule != null) {
			field = rule.findStaticField(type, name);
		} else {
			field = null;
		}
		if (field == null) {
			return env.findStaticField(type, name);
		} else {
			return field;
		}
	}

	/**
	 * Implements the SET instruction.
	 * @param v value
	 * @param o object
	 * @param propname the property name
	 * @param frame the current stack frame
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void set(final Object v, final Object o, final String propname, final StackFrame frame)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		if (o instanceof EObject) {
			final EObject eo = (EObject)o;
			final EClass type = eo.eClass();
			final boolean queueSet = env.getCurrentPhase() == RuleMode.AUTOMATIC_SINGLE && env.getInoutModelOf(eo) != null;
			final Field field = findField(env, type, propname);
			if (field != null) {
				if (field.getRule() == null) {
					if (queueSet) {
						env.queueForSet(field, o, v, frame);
					} else {
						if (env.getInputModelOf(eo) != null) {
							throw new IllegalArgumentException(
									String.format("Cannot set properties of %s, as it is contained in an input model",
											EMFTVMUtil.toPrettyString(eo, env)));
						}
						if (env.getOutputModelOf(eo) != null) {
							throw new IllegalArgumentException(String.format(
									"Setting transient field %s of %s, which cannot be read back as it is contained in an output model",
									propname, EMFTVMUtil.toPrettyString(eo, env)));
						}
						field.setValue(o, v);
					}
				} else {
					// Treat rule fields as local variables
					field.setValue(o, v);
				}
				return;
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				if (queueSet) {
					env.queueForSet(sf, eo, v, frame);
				} else {
					EMFTVMUtil.set(env, eo, sf, v);
				}
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				if (queueSet) {
					env.queueXmiIDForSet(eo, v, frame);
				} else {
					((XMIResource)resource).setID(eo, v.toString());
				}
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = o == null ? Void.TYPE : o.getClass();
		final Field field = findField(env, type, propname);
		if (field != null) {
			field.setValue(o, v);
			return;
		}
		try {
			final java.lang.reflect.Field f = type.getField(propname);
			f.set(o, v);
		} catch (final NoSuchFieldException e) {
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * Adds <code>v</code> to <code>o.propname</code>. Implements the ADD and INSERT instructions.
	 *
	 * @param index
	 *            the insertion index (-1 for end)
	 * @param v
	 *            value
	 * @param o
	 *            object
	 * @param propname
	 *            the property name
	 * @param frame
	 *            the current stack frame
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void add(final int index, final Object v, final Object o, final String propname, final StackFrame frame)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		if (o instanceof EObject) {
			final EObject eo = (EObject)o;
			final EClass type = eo.eClass();
			final boolean queueSet = env.getCurrentPhase() == RuleMode.AUTOMATIC_SINGLE && env.getInoutModelOf(eo) != null;
			final Field field = findField(env, type, propname);
			if (field != null) {
				if (field.getRule() == null) {
					if (queueSet) {
						env.queueForAdd(field, o, v, index, frame);
					} else {
						if (env.getInputModelOf(eo) != null) {
							throw new IllegalArgumentException(String.format(
									"Cannot add to properties of %s, as it is contained in an input model",
									EMFTVMUtil.toPrettyString(eo, env)));
						}
						if (env.getOutputModelOf(eo) != null) {
							throw new IllegalArgumentException(String.format(
									"Adding to transient field %s of %s, which cannot be read back as %1s is contained in an output model",
									propname, EMFTVMUtil.toPrettyString(eo, env)));
						}
						field.addValue(o, v, index, frame);
					}
				} else {
					// Treat rule fields as local variables
					field.addValue(o, v, index, frame);
				}
				return;
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				if (queueSet) {
					env.queueForAdd(sf, eo, v, index, frame);
				} else {
					EMFTVMUtil.add(env, eo, sf, v, index);
				}
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				if (queueSet) {
					env.queueXmiIDForAdd(eo, v, index, frame);
				} else {
					if (((XMIResource) resource).getID(eo) != null) {
						throw new IllegalArgumentException(String.format(
								"Cannot add %s to field %s::%s: maximum multiplicity of 1 reached", v, EMFTVMUtil.toPrettyString(eo, env),
								propname));
					}
					if (index > 0) {
						throw new IndexOutOfBoundsException(String.valueOf(index));
					}
					((XMIResource) resource).setID(eo, v.toString());
				}
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = o == null ? Void.TYPE : o.getClass();
		final Field field = findField(env, type, propname);
		if (field != null) {
			field.addValue(o, v, index, frame);
			return;
		}
		throw new NoSuchFieldException(String.format("Field %s::%s not found", EMFTVMUtil.toPrettyString(type, env), propname));
	}

	/**
	 * Implements the REMOVE instruction.
	 *
	 * @param v
	 *            value
	 * @param o
	 *            object
	 * @param propname
	 *            the property name
	 * @param frame
	 *            the current stack frame
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void remove(final Object v, final Object o, final String propname, final StackFrame frame)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		if (o instanceof EObject) {
			final EObject eo = (EObject)o;
			final EClass type = eo.eClass();
			final boolean queueSet = env.getCurrentPhase() == RuleMode.AUTOMATIC_SINGLE && env.getInoutModelOf(eo) != null;
			final Field field = findField(env, type, propname);
			if (field != null) {
				if (field.getRule() == null) {
					if (queueSet) {
						env.queueForRemove(field, o, v, frame);
					} else {
						if (env.getInputModelOf(eo) != null) {
							throw new IllegalArgumentException(String.format(
									"Cannot remove from properties of %s, as it is contained in an input model",
									EMFTVMUtil.toPrettyString(eo, env)));
						}
						if (env.getOutputModelOf(eo) != null) {
							throw new IllegalArgumentException(
									String.format(
											"Removing from transient field %s of %s, which cannot be read back as %1s is contained in an output model",
											propname, EMFTVMUtil.toPrettyString(eo, env)));
						}
						field.removeValue(o, v, frame);
					}
				} else {
					// Treat rule fields as local variables
					field.removeValue(o, v, frame);
				}
				return;
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				if (queueSet) {
					env.queueForRemove(sf, eo, v, frame);
				} else {
					EMFTVMUtil.remove(env, eo, sf, v);
				}
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				if (queueSet) {
					env.queueXmiIDForRemove(eo, v, frame);
				} else {
					final XMIResource xmiRes = (XMIResource) resource;
					final Object xmiID = xmiRes.getID(eo);
					if (xmiID == null ? v == null : xmiID.equals(v)) {
						xmiRes.setID(eo, null);
					}
				}
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = o == null ? Void.TYPE : o.getClass();
		final Field field = findField(env, type, propname);
		if (field != null) {
			field.removeValue(o, v, frame);
			return;
		}
		throw new NoSuchFieldException(String.format("Field %s::%s not found", EMFTVMUtil.toPrettyString(type, env), propname));
	}

	/**
	 * Implements the GET instruction.
	 *
	 * @param propname
	 * @param env
	 * @param frame
	 * @param o
	 *            the object on which to GET the property
	 * @return the property value
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	private Object get(final String propname, final StackFrame frame, final Object o) throws NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();

		if (o instanceof EObject) {
			final EObject eo = (EObject)o;
			final EClass type = eo.eClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				if (field.getRule() == null && env.getOutputModelOf(eo) != null) {
					throw new IllegalArgumentException(String.format("Cannot read properties of %s, as it is contained in an output model",
							EMFTVMUtil.toPrettyString(eo, env)));
				}
				return field.getValue(o, frame);
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				return EMFTVMUtil.get(env, eo, sf);
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				return ((XMIResource)resource).getID(eo);
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = o == null ? Void.TYPE : o.getClass();
		final Field field = findField(env, type, propname);
		if (field != null) {
			return field.getValue(o, frame);
		}

		if (o instanceof Tuple && ((Tuple) o).asMap().containsKey(propname)) {
			return ((Tuple) o).get(propname);
		}

		try {
			final java.lang.reflect.Field f = type.getField(propname);
			final Object result = f.get(o);
			if (result instanceof List<?>) {
				return new LazyListOnList<Object>((List<Object>)result);
			} else if (result instanceof java.util.Set<?>) {
				return new LazySetOnSet<Object>((java.util.Set<Object>)result);
			} else if (result instanceof Collection<?>) {
				return new LazyBagOnCollection<Object>((Collection<Object>)result);
			} else {
				return result;
			}
		} catch (final NoSuchFieldException e) {
			throw new NoSuchFieldException(String.format("Field %s::%s not found",
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * Implements the GET_TRANS instruction.
	 * @param propname
	 * @param env
	 * @param frame
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private Collection<Object> getTrans(final String propname, final StackFrame frame, final Object o) throws NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();

		if (o instanceof EObject) {
			final EObject eo = (EObject)o;
			final EClass type = eo.eClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				if (field.getRule() == null && env.getOutputModelOf(eo) != null) {
					throw new IllegalArgumentException(String.format("Cannot read properties of %s, as it is contained in an output model",
							EMFTVMUtil.toPrettyString(eo, env)));
				}
				return EMFTVMUtil.getTrans(o, field, frame, new LazyList<Object>());
			} else {
				final EStructuralFeature sf = type.getEStructuralFeature(propname);
				if (sf == null) {
					throw new NoSuchFieldException(String.format("Field %s::%s not found",
							EMFTVMUtil.toPrettyString(type, env), propname));
				}
				return EMFTVMUtil.getTrans(eo, sf, env, new LazyList<Object>());
			}
		} else {
			final Class<?> type = o.getClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				return EMFTVMUtil.getTrans(o, field, frame, new LazyList<Object>());
			} else {
				final java.lang.reflect.Field f = type.getField(propname);
				return EMFTVMUtil.getTrans(o, f, new LazyList<Object>());
			}
		}
	}

	/**
	 * Implements the GET_SUPER instruction.
	 * @param fieldCtx the current {@link Field} context
	 * @param propname
	 * @param env
	 * @param frame
	 * @return the property value
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	private Object getSuper(final Field fieldCtx, final String propname, final StackFrame frame, final Object o)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		if (fieldCtx == null) {
			throw new IllegalArgumentException("GET_SUPER can only be used in fields");
		}
		final EClassifier context = fieldCtx.getEContext();
		if (context == null) {
			throw new IllegalArgumentException(String.format("Field misses context type: %s", fieldCtx));
		}

		final ExecEnv env = frame.getEnv();

		final List<?> superTypes;
		if (context instanceof EClass) {
			superTypes = ((EClass)context).getESuperTypes();
		} else {
			final Class<?> ic = context.getInstanceClass();
			if (ic == null) {
				throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", context));
			}
			superTypes = Collections.singletonList(ic.getSuperclass());
		}

		final java.util.Set<Object> superFs = new LinkedHashSet<Object>();
		if (o instanceof EObject) {
			// o may have EStructuralFeatures
			for (final Object superType : superTypes) {
				Object superF = env.findField(superType, propname);
				if (superF != null) {
					superFs.add(superF);
				} else if (superType instanceof EClass) {
					superF = ((EClass)superType).getEStructuralFeature(propname);
					if (superF != null) {
						superFs.add(superF);
					} else if (((EClass)superType).getInstanceClass() != null) {
						try {
							superF = ((EClass)superType).getInstanceClass().getField(propname);
							assert superF != null;
							superFs.add(superF);
						} catch (final NoSuchFieldException e) {
							// not found - skip
						}
					}
				} else if (superType instanceof Class<?>) {
					try {
						superF = ((Class<?>)superType).getField(propname);
						assert superF != null;
						superFs.add(superF);
					} catch (final NoSuchFieldException e) {
						// not found - skip
					}
				}
			}
		} else {
			// o is a regular Java object - may be null
			for (final Object superType : superTypes) {
				Object superF = env.findField(superType, propname);
				if (superF != null) {
					superFs.add(superF);
				} else if (superType instanceof EClass && ((EClass)superType).getInstanceClass() != null) {
					try {
						superF = ((EClass)superType).getInstanceClass().getField(propname);
						assert superF != null;
						superFs.add(superF);
					} catch (final NoSuchFieldException e) {
						// not found - skip
					}
				} else if (superType instanceof Class<?>) {
					try {
						superF = ((Class<?>)superType).getField(propname);
						assert superF != null;
						superFs.add(superF);
					} catch (final NoSuchFieldException e) {
						// not found - skip
					}
				}
			}
		}

		if (superFs.size() > 1) {
			throw new DuplicateEntryException(String.format(
					"More than one super-field found for context %s: %s",
					context, superFs));
		}
		if (!superFs.isEmpty()) {
			final Object superF = superFs.iterator().next();
			if (superF instanceof Field) {
				final Field field = (Field) superF;
				if (o instanceof EObject) {
					final EObject eo = (EObject) o;
					if (field.getRule() == null && env.getOutputModelOf(eo) != null) {
						throw new IllegalArgumentException(String.format(
								"Cannot read properties of %s, as it is contained in an output model", EMFTVMUtil.toPrettyString(eo, env)));
					}
				}
				return field.getValue(o, frame);
			} else if (superF instanceof EStructuralFeature) {
				return EMFTVMUtil.get(env, (EObject)o, (EStructuralFeature)superF);
			} else {
				final Object result = ((java.lang.reflect.Field)superF).get(o);
				if (result instanceof List<?>) {
					return new LazyListOnList<Object>((List<Object>)result);
				} else if (result instanceof java.util.Set<?>) {
					return new LazySetOnSet<Object>((java.util.Set<Object>)result);
				} else if (result instanceof Collection<?>) {
					return new LazyBagOnCollection<Object>((Collection<Object>)result);
				} else {
					return result;
				}
			}
		}

		throw new NoSuchFieldException(String.format("Super-field of %s::%s not found",
				EMFTVMUtil.toPrettyString(context, env), propname));
	}

	/**
	 * Implements the SET_STATIC instruction.
	 * @param v value
	 * @param o object
	 * @param propname the property name
	 * @param env the execution environment
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void setStatic(final Object v, final Object o, final String propname, final ExecEnv env)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final Object ort = EMFTVMUtil.getRegistryType(o);

		if (ort instanceof EClass) {
			final EClass type = (EClass)ort;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				field.setStaticValue(v);
			} else {
				throw new NoSuchFieldException(String.format("Field %s::%s not found",
						EMFTVMUtil.toPrettyString(type, env), propname));
			}
		} else if (ort instanceof Class<?>) {
			final Class<?> type = (Class<?>)ort;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				field.setValue(ort, v);
			} else {
				final java.lang.reflect.Field f = type.getField(propname);
				if (Modifier.isStatic(f.getModifiers())) {
					f.set(null, v);
				} else {
					throw new NoSuchFieldException(String.format("Field %s::%s not found",
							EMFTVMUtil.toPrettyString(type, env), propname));
				}
			}
		} else {
			throw new IllegalArgumentException(String.format("%s is not a type",
					EMFTVMUtil.toPrettyString(ort, env)));
		}
	}

	/**
	 * Implements the GET_STATIC instruction.
	 * @param propname
	 * @param frame
	 * @return the property value
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private Object getStatic(final String propname, final StackFrame frame, final Object o) throws NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object oType = EMFTVMUtil.getRegistryType(o);

		if (oType instanceof EClass) {
			final EClass type = (EClass)oType;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				return field.getStaticValue(frame);
			} else {
				throw new NoSuchFieldException(String.format("Field %s::%s not found",
						EMFTVMUtil.toPrettyString(type, env), propname));
			}
		} else if (oType instanceof Class<?>) {
			final Class<?> type = (Class<?>)oType;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				return field.getStaticValue(frame);
			} else {
				final java.lang.reflect.Field f = type.getField(propname);
				if (Modifier.isStatic(f.getModifiers())) {
					return f.get(null);
				} else {
					throw new NoSuchFieldException(String.format("Field %s::%s not found",
							EMFTVMUtil.toPrettyString(type, env), propname));
				}
			}
		} else {
			throw new IllegalArgumentException(String.format("%s is not a type", oType));
		}
	}

	/**
	 * Implements the NEW and NEW_S instructions.
	 * @param modelname
	 * @param type
	 * @param fram
	 * @return the new object
	 */
	private static Object newInstr(final String modelname, final Object type, final StackFrame frame) {
		final ExecEnv env = frame.getEnv();
		if (type instanceof EClass) {
			final EClass eType = (EClass)type;
			Model model = env.getOutputModels().get(modelname);
			if (model == null) {
				model = env.getInoutModels().get(modelname);
			}
			if (model == null) {
				throw new IllegalArgumentException(String.format("Inout/output model %s not found", modelname));
			}
			return model.newElement(eType);
		} else {
			try {
				return NativeTypes.newInstance((Class<?>)type);
			} catch (final Exception e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	/**
	 * Implements the DELETE instruction.
	 * @param frame
	 */
	private static void delete(final StackFrame frame, final EObject element) {
		final ExecEnv env = frame.getEnv();
		final Resource res = element.eResource();
		if (res == null) {
			throw new IllegalArgumentException(String.format(
					"Element %s is cannot be deleted; not contained in a model",
					EMFTVMUtil.toPrettyString(element, env)));
		}
		final Model model = env.getInputModelOf(element);
		if (model != null) {
			throw new IllegalArgumentException(String.format(
					"Element %s is cannot be deleted; contained in input model %s",
					EMFTVMUtil.toPrettyString(element, env), env.getModelID(model)));
		}
		env.queueForDelete(element, frame);
	}

	/**
	 * Implements the INVOKE instruction.
	 * @param instr the INVOKE instruction
	 * @param frame the current stack frame
	 * @return the invocation result
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static Object invoke(final Invoke instr, final StackFrame frame, final Stack stack)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final String opname = instr.getOpname();
		final int argcount = instr.getArgcount();
		final Object o;
		final Operation op;
		final Method method;
		switch (argcount) {
		case 0:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			o = stack.pop();
			op = frame.getEnv().findOperation(
					EMFTVMUtil.getArgumentType(o),
					opname);
			method = EMFTVMUtil.findNativeMethod(op, o, opname);
			if (method != null) {
				// Only record new method if it is more general than the existing method
				final Method oldMethod = instr.getNativeMethod();
				if (oldMethod == null || method.getDeclaringClass().isAssignableFrom(oldMethod.getDeclaringClass())) {
					instr.setNativeMethod(method); // record invoked method for JIT compiler
				}
				return EMFTVMUtil.invokeNative(frame, o, method);
			}
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(frame.getSubFrame(body, o));
			}
			throw new UnsupportedOperationException(String.format("%s::%s()",
					EMFTVMUtil.getTypeName(frame.getEnv(), EMFTVMUtil.getArgumentType(o)),
					opname));
		case 1:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			final Object arg = stack.pop();
			o = stack.pop();
			op = frame.getEnv().findOperation(
					EMFTVMUtil.getArgumentType(o),
					opname,
					EMFTVMUtil.getArgumentType(arg));
			method = EMFTVMUtil.findNativeMethod(op, o, opname, arg);
			if (method != null) {
				// Only record new method if it is more general than the existing method
				final Method oldMethod = instr.getNativeMethod();
				if (oldMethod == null || method.getDeclaringClass().isAssignableFrom(oldMethod.getDeclaringClass())) {
					instr.setNativeMethod(method); // record invoked method for JIT compiler
				}
				return EMFTVMUtil.invokeNative(frame, o, method, arg);
			}
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(frame.getSubFrame(body, o, arg));
			}
			throw new UnsupportedOperationException(String.format("%s::%s(%s)",
					EMFTVMUtil.getTypeName(frame.getEnv(), EMFTVMUtil.getArgumentType(o)),
					opname,
					EMFTVMUtil.getTypeName(frame.getEnv(), EMFTVMUtil.getArgumentType(arg))));
		default:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			final Object[] args = stack.pop(argcount);
			//TODO treat context as a regular argument (cf. Java's Method.invoke())
			o = stack.pop();
			op = frame.getEnv().findOperation(
					EMFTVMUtil.getArgumentType(o),
					opname,
					EMFTVMUtil.getArgumentTypes(args));
			method = EMFTVMUtil.findNativeMethod(op, o, opname, args);
			if (method != null) {
				// Only record new method if it is more general than the existing method
				final Method oldMethod = instr.getNativeMethod();
				if (oldMethod == null || method.getDeclaringClass().isAssignableFrom(oldMethod.getDeclaringClass())) {
					instr.setNativeMethod(method); // record invoked method for JIT compiler
				}
				return EMFTVMUtil.invokeNative(frame, o, method, args);
			}
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(frame.getSubFrame(body, o, args));
			}
			throw new UnsupportedOperationException(String.format("%s::%s(%s)",
					EMFTVMUtil.getTypeName(frame.getEnv(), EMFTVMUtil.getArgumentType(o)),
					opname,
					EMFTVMUtil.getTypeNames(frame.getEnv(), EMFTVMUtil.getArgumentTypes(args))));
		}
	}

	/**
	 * Implements the INVOKE_STATIC instruction.
	 * @param opname
	 * @param argcount
	 * @param frame
	 * @return the invocation result
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static Object invokeStatic(final String opname, final int argcount, final StackFrame frame, final Stack stack)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final ExecEnv env = frame.getEnv();
		final Object type;
		final Operation op;
		switch (argcount) {
		case 0:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., type, arg1, arg2]
			type = stack.pop();

			if (type == null) {
				throw new IllegalArgumentException(String.format("Cannot invoke static operation %s on null type", opname));
			}

			if (type == env.eClass()) { // Lazy and called rule invocations are indistinguishable from static operations in ATL
				final Rule rule = env.findRule(opname);
				if (rule != null && rule.getMode() == RuleMode.MANUAL) {
					return matchOne(frame, rule);
				}
			}

			op = env.findStaticOperation(type, opname);
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(new StackFrame(frame, body)); // no need to copy arguments
			}
			if (type instanceof Class<?>) {
				return EMFTVMUtil.invokeNativeStatic(frame, (Class<?>)type, opname);
			}
			throw new UnsupportedOperationException(String.format("static %s::%s()",
					EMFTVMUtil.getTypeName(env, type),
					opname));
		case 1:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., type, arg1, arg2]
			final Object arg = stack.pop();
			type = stack.pop();

			if (type == null) {
				throw new IllegalArgumentException(String.format("Cannot invoke static operation %s on null type", opname));
			}

			if (type == env.eClass()) { // Lazy and called rule invocations are indistinguishable from static operations in ATL
				final Rule rule = env.findRule(opname);
				if (rule != null && rule.getMode() == RuleMode.MANUAL) {
					return matchOne(frame, rule, new Object[] { arg });
				}
			}

			op = env.findStaticOperation(type, opname, EMFTVMUtil.getArgumentType(arg));
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(frame.getSubFrame(body, arg));
			}
			if (type instanceof Class<?>) {
				return EMFTVMUtil.invokeNativeStatic(frame, (Class<?>)type, opname, arg);
			}
			throw new UnsupportedOperationException(String.format("static %s::%s(%s)",
					EMFTVMUtil.getTypeName(env, type),
					opname,
					EMFTVMUtil.getTypeName(env, EMFTVMUtil.getArgumentType(arg))));
		default:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., type, arg1, arg2]
			final Object[] args = stack.pop(argcount);
			type = stack.pop();

			if (type == null) {
				throw new IllegalArgumentException(String.format("Cannot invoke static operation %s on null type", opname));
			}

			if (type == env.eClass()) { // Lazy and called rule invocations are indistinguishable from static operations in ATL
				final Rule rule = env.findRule(opname);
				if (rule != null && rule.getMode() == RuleMode.MANUAL) {
					return matchOne(frame, rule, args);
				}
			}

			//TODO treat context type as a regular argument (cf. Java's Method.invoke())
			op = env.findStaticOperation(type, opname, EMFTVMUtil.getArgumentTypes(args));
			if (op != null) {
				final CodeBlock body = op.getBody();
				return body.execute(frame.getSubFrame(body, args));
			}
			if (type instanceof Class<?>) {
				return EMFTVMUtil.invokeNativeStatic(frame, (Class<?>)type, opname, args);
			}
			throw new UnsupportedOperationException(String.format("static %s::%s(%s)",
					EMFTVMUtil.getTypeName(env, type),
					opname,
					EMFTVMUtil.getTypeNames(env, EMFTVMUtil.getArgumentTypes(args))));
		}
	}

	/**
	 * Implements the INVOKE_SUPER instruction.
	 * @param eContext the current execution context type
	 * @param opname
	 * @param argcount
	 * @param frame
	 * @return the invocation result
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static Object invokeSuper(final Operation op, final String opname, final int argcount, final StackFrame frame, final Stack stack)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (op == null) {
			throw new IllegalArgumentException("INVOKE_SUPER can only be used in operations");
		}
		final EClassifier context = op.getEContext();
		if (context == null) {
			throw new IllegalArgumentException(String.format("Operation misses context type: %s", op));
		}

		final java.util.Set<Operation> ops = new LinkedHashSet<Operation>();
		final Class<?> ic = context.getInstanceClass();
		final List<?> superTypes;
		if (context instanceof EClass) {
			superTypes = ((EClass)context).getESuperTypes();
		} else {
			if (ic == null) {
				throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", context));
			}
			superTypes = Collections.singletonList(ic.getSuperclass());
		}

		final ExecEnv env = frame.getEnv();
		Operation superOp = null;
		final Object o;
		final Method method;

		switch (argcount) {
		case 0:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			o = stack.pop();

			for (final Object superType : superTypes) {
				superOp = env.findOperation(superType, opname);
				if (superOp != null) {
					ops.add(superOp);
				}
			}
			if (ops.size() > 1) {
				throw new DuplicateEntryException(String.format(
						"More than one super-operation found for context %s: %s",
						context, ops));
			}
			if (!ops.isEmpty()) {
				superOp = ops.iterator().next();
			}

			method = EMFTVMUtil.findNativeSuperMethod(superOp, ic, opname);
			if (method != null) {
				return EMFTVMUtil.invokeNative(frame, o, method);
			}
			if (superOp != null) {
				final CodeBlock body = superOp.getBody();
				return body.execute(frame.getSubFrame(body, o));
			}

			throw new UnsupportedOperationException(String.format("super %s::%s()",
					EMFTVMUtil.getTypeName(env, context),
					opname));
		case 1:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			final Object arg = stack.pop();
			o = stack.pop();

			for (final Object superType : superTypes) {
				superOp = env.findOperation(superType, opname, EMFTVMUtil.getArgumentType(arg));
				if (superOp != null) {
					ops.add(superOp);
				}
			}
			if (ops.size() > 1) {
				throw new DuplicateEntryException(String.format(
						"More than one super-operation found for context %s: %s",
						context, ops));
			}
			if (!ops.isEmpty()) {
				superOp = ops.iterator().next();
			}

			method = EMFTVMUtil.findNativeSuperMethod(superOp, ic, opname, arg);
			if (method != null) {
				return EMFTVMUtil.invokeNative(frame, o, method, arg);
			}
			if (superOp != null) {
				final CodeBlock body = superOp.getBody();
				return body.execute(frame.getSubFrame(body, o, arg));
			}

			throw new UnsupportedOperationException(String.format("super %s::%s(%s)",
					EMFTVMUtil.getTypeName(env, context),
					opname,
					EMFTVMUtil.getTypeName(env, EMFTVMUtil.getArgumentType(arg))));
		default:
			// Use Java's left-to-right evaluation semantics:
			// stack = [..., self, arg1, arg2]
			final Object[] args = stack.pop(argcount);
			o = stack.pop();

			for (final Object superType : superTypes) {
				superOp = env.findOperation(superType, opname, EMFTVMUtil.getArgumentTypes(args));
				if (superOp != null) {
					ops.add(superOp);
				}
			}
			if (ops.size() > 1) {
				throw new DuplicateEntryException(String.format(
						"More than one super-operation found for context %s: %s",
						context, ops));
			}
			if (!ops.isEmpty()) {
				superOp = ops.iterator().next();
			}

			method = EMFTVMUtil.findNativeSuperMethod(superOp, ic, opname, args);
			if (method != null) {
				return EMFTVMUtil.invokeNative(frame, o, method, args);
			}
			if (superOp != null) {
				final CodeBlock body = superOp.getBody();
				return body.execute(frame.getSubFrame(body, o, args));
			}

			throw new UnsupportedOperationException(String.format("super %s::%s(%s)",
					EMFTVMUtil.getTypeName(env, context),
					opname,
					EMFTVMUtil.getTypeNames(env, EMFTVMUtil.getArgumentTypes(args))));
		}
	}

	/**
	 * Finds the rule referred to by <pre>instr</pre>.
	 * @param env
	 * @param rulename
	 * @return the rule mentioned by instr
	 * @throws IllegalArgumentException if rule not found
	 */
	private static Rule findRule(final ExecEnv env, final String rulename) {
		final Rule rule = env.findRule(rulename);
		if (rule == null) {
			throw new IllegalArgumentException(String.format("Rule %s not found", rulename));
		}
		return rule;
	}

	/**
	 * Executes <code>rule</code> with <code>args</code>.
	 * @param frame the current stack frame
	 * @param rule the rule
	 * @param args the rule arguments
	 */
	private static Object matchOne(final StackFrame frame, final Rule rule, final Object[] args) {
		EMFTVMUtil.checkRuleArgCount(frame, rule, args.length);
		return rule.matchManual(frame, args);
	}

	/**
	 * Executes <code>rule</code> without arguments.
	 * @param frame the current stack frame
	 * @param rule the rule
	 */
	private static Object matchOne(final StackFrame frame, final Rule rule) {
		EMFTVMUtil.checkRuleArgCount(frame, rule, 0);
		return rule.matchManual(frame, EMPTY);
	}

	/**
	 * Clears values derived from {@link #getCode()}.
	 */
	private void codeChanged() {
		predecessors.clear();
		allPredecessors.clear();
		nlPredecessors.clear();
		eUnset(EmftvmPackage.CODE_BLOCK__MAX_STACK);
		setJITCodeBlock(null);
	}

	/**
	 * Clears values derived from {@link #getLocalVariables()}.
	 */
	private void localVariablesChanged() {
		eUnset(EmftvmPackage.CODE_BLOCK__MAX_LOCALS);
		setJITCodeBlock(null);
	}

	/**
	 * Clears values derived from {@link #getNested()}.
	 */
	private void nestedChanged() {
		setJITCodeBlock(null);
	}

} //CodeBlockImpl
