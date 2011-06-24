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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.Get;
import org.eclipse.m2m.atl.emftvm.Get_static;
import org.eclipse.m2m.atl.emftvm.Get_trans;
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
import org.eclipse.m2m.atl.emftvm.Invoke_all_cbs;
import org.eclipse.m2m.atl.emftvm.Invoke_cb;
import org.eclipse.m2m.atl.emftvm.Invoke_cb_s;
import org.eclipse.m2m.atl.emftvm.Invoke_static;
import org.eclipse.m2m.atl.emftvm.Invoke_super;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.Load;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.Match_s;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Or;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Remove;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.Set_static;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.util.DuplicateEntryException;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;
import org.eclipse.m2m.atl.emftvm.util.LazyBagOnCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyListOnCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyListOnList;
import org.eclipse.m2m.atl.emftvm.util.LazySetOnSet;
import org.eclipse.m2m.atl.emftvm.util.Matcher;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
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
 * </p>
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
	 * The cached value of the '{@link #getMaxLocals() <em>Max Locals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLocals()
	 * @generated NOT
	 * @ordered
	 */
	protected int maxLocals = MAX_LOCALS_EDEFAULT;

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
	 * @generated
	 * @ordered
	 */
	protected StackFrame parentFrame = PARENT_FRAME_EDEFAULT;

	/**
	 * Converts {@link Enumerator}s to {@link EnumLiteral}s.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class EnumConversionList extends LazyList<Object> {

		/**
		 * {@link Iterator} for {@link EnumConversionList}.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class EnumConversionIterator extends CachingIterator {

			/**
			 * Creates a new {@link EnumConversionIterator}.
			 */
			public EnumConversionIterator() {
				super(dataSource.iterator());
			}

			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.CachingIterator#next()
			 */
			@Override
			public Object next() {
				final Object next = convert(inner.next());
				if (++i > cache.size()) {
					assert dataSource != null; // cache not complete
					cache.add(next);
				} else {
					assert cache.contains(next);
				}
				return next;
			}
		}

		/**
		 * Creates a new {@link EnumConversionList} around <code>dataSource</code>.
		 * @param dataSource
		 */
		public EnumConversionList(List<Object> dataSource) {
			super(dataSource);
		}

		/**
		 * @param object
		 * @return the converted object
		 */
		protected final Object convert(final Object object) {
			if (object instanceof Enumerator) {
				return new EnumLiteral(object.toString());
			}
			return object;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<Object> iterator() {
			if (dataSource == null) {
				return cache.iterator();
			}
			return new EnumConversionIterator(); // extends CachingIterator
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			if (dataSource == null) {
				return cache.size();
			}
			return ((Collection<Object>) dataSource).size();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#get(int)
		 */
		@Override
		public Object get(final int index) {
			if (index < cache.size()) {
				return ((List<Object>) cache).get(index);
			}
			return convert(((List<Object>) dataSource).get(index));
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#last()
		 */
		@Override
		public Object last() {
			final int size = size();
			if (size < 1) {
				throw new NoSuchElementException();
			}
			if (dataSource == null) {
				return ((List<Object>) cache).get(size-1);
			}
			return convert(((List<Object>) dataSource).get(size-1));
		}

		/**
		 * Forces cache completion.
		 */
		public void cache() {
			if (dataSource != null) {
				cache.clear();
				for (Object o : dataSource) {
					cache.add(convert(o));
				}
				assert cache.size() == ((List<?>) dataSource).size();
				dataSource = null;
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#createCache()
		 */
		@Override
		protected void createCache() {
			if (dataSource == null) {
				this.cache = Collections.emptyList(); // dataSource == null; cache complete
				this.occurrences = Collections.emptyMap();
			} else {
				this.cache = new ArrayList<Object>(((List<Object>) dataSource).size());
			}
			assert this.cache instanceof List<?>;
		}
	}

	/**
	 * Cache used to store native Java methods.
	 * 
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static final WeakHashMap<Class<?>, Map<String, Method>> methodCache = 
		new WeakHashMap<Class<?>, Map<String, Method>>();

	private boolean ruleSet = false;
	private Rule rule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.CODE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMaxLocals() {
		if (maxLocals == MAX_LOCALS_EDEFAULT) {
			for (LocalVariable lv : getLocalVariables()) {
				maxLocals = Math.max(maxLocals, lv.getSlot());
			}
			maxLocals++; // highest index + 1
		}
		return maxLocals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMaxLocals(int newMaxLocals) {
		int oldMaxLocals = maxLocals;
		maxLocals = newMaxLocals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__MAX_LOCALS, oldMaxLocals, maxLocals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMaxStack() {
		if (maxStack == MAX_STACK_EDEFAULT) {
			maxStack = 0;
			for (Instruction instr : getCode()) {
				maxStack = Math.max(maxStack, instr.getStackLevel());
			}
		}
		return maxStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMaxStack(int newMaxStack) {
		int oldMaxStack = maxStack;
		maxStack = newMaxStack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__MAX_STACK, oldMaxStack, maxStack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getCode() {
		if (code == null) {
			code = new EObjectContainmentWithInverseEList<Instruction>(Instruction.class, this, EmftvmPackage.CODE_BLOCK__CODE, EmftvmPackage.INSTRUCTION__OWNING_BLOCK);
		}
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LineNumber> getLineNumbers() {
		if (lineNumbers == null) {
			lineNumbers = new EObjectContainmentWithInverseEList<LineNumber>(LineNumber.class, this, EmftvmPackage.CODE_BLOCK__LINE_NUMBERS, EmftvmPackage.LINE_NUMBER__OWNING_BLOCK);
		}
		return lineNumbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LocalVariable> getLocalVariables() {
		if (localVariables == null) {
			localVariables = new EObjectContainmentWithInverseEList<LocalVariable>(LocalVariable.class, this, EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES, EmftvmPackage.LOCAL_VARIABLE__OWNING_BLOCK);
		}
		return localVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getMatcherFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__MATCHER_FOR) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcherFor(Rule newMatcherFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMatcherFor, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcherFor(Rule newMatcherFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getApplierFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__APPLIER_FOR) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplierFor(Rule newApplierFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newApplierFor, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplierFor(Rule newApplierFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getPostApplyFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostApplyFor(Rule newPostApplyFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPostApplyFor, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostApplyFor(Rule newPostApplyFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBodyFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BODY_FOR) return null;
		return (Operation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyFor(Operation newBodyFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBodyFor, EmftvmPackage.CODE_BLOCK__BODY_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyFor(Operation newBodyFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field getInitialiserFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__INITIALISER_FOR) return null;
		return (Field)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialiserFor(Field newInitialiserFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInitialiserFor, EmftvmPackage.CODE_BLOCK__INITIALISER_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialiserFor(Field newInitialiserFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeBlock> getNested() {
		if (nested == null) {
			nested = new EObjectContainmentWithInverseEList<CodeBlock>(CodeBlock.class, this, EmftvmPackage.CODE_BLOCK__NESTED, EmftvmPackage.CODE_BLOCK__NESTED_FOR);
		}
		return nested;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getNestedFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__NESTED_FOR) return null;
		return (CodeBlock)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedFor(CodeBlock newNestedFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestedFor, EmftvmPackage.CODE_BLOCK__NESTED_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedFor(CodeBlock newNestedFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrame getParentFrame() {
		return parentFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentFrame(StackFrame newParentFrame) {
		StackFrame oldParentFrame = parentFrame;
		parentFrame = newParentFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK__PARENT_FRAME, oldParentFrame, parentFrame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputRuleElement getBindingFor() {
		if (eContainerFeatureID() != EmftvmPackage.CODE_BLOCK__BINDING_FOR) return null;
		return (InputRuleElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindingFor(InputRuleElement newBindingFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBindingFor, EmftvmPackage.CODE_BLOCK__BINDING_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingFor(InputRuleElement newBindingFor) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object execute(StackFrame frame) {
		int pc = 0;
		final EList<Instruction> code = getCode();
		final int codeSize = code.size();

		try {
			LOOP:
			while (pc < codeSize) {
				Instruction instr = code.get(pc++);
				switch (instr.getOpcode()) {
				case PUSH:
					frame.push(((Push) instr).getValue());
					break;
				case PUSHT:
					frame.push(true);
					break;
				case PUSHF:
					frame.push(false);
					break;
				case POP:
					frame.popv();
					break;
				case LOAD: {
					final Load load = (Load) instr;
					frame.load(load.getCbOffset(), load.getSlot());
					break; }
				case STORE: {
					final Store store = (Store) instr;
					frame.store(store.getCbOffset(), store.getSlot());
					break; }
				case SET:
					set(((Set) instr).getFieldname(), frame);
					break;
				case GET:
					frame.setPc(pc);
					frame.push(get(((Get) instr).getFieldname(), frame));
					break;
				case GET_TRANS:
					frame.setPc(pc);
					frame.push(getTrans(((Get_trans) instr).getFieldname(), frame));
					break;
				case SET_STATIC:
					setStatic(((Set_static) instr).getFieldname(), frame);
					break;
				case GET_STATIC:
					frame.setPc(pc);
					frame.push(getStatic(((Get_static) instr).getFieldname(), frame));
					break;
				case FINDTYPE: {
					final Findtype f = (Findtype) instr;
					frame.push(EMFTVMUtil.findType(frame.getEnv(), f.getModelname(), f.getTypename()));
					break; }
				case FINDTYPE_S: {
					final Object modelName = frame.pop();
					final Object typeName = frame.pop();
					frame.push(EMFTVMUtil.findType(
									frame.getEnv(), 
									(String) modelName, 
									(String) typeName));
					break; }
				case NEW: {
					final New newInstr = (New) instr;
					final Object type = frame.pop();
					frame.push(new_(newInstr.getModelname(), 
									type, 
									frame));
					break; }
				case NEW_S: {
					final Object modelName = frame.pop();
					final Object type = frame.pop();
					frame.push(new_((String) modelName, 
									type,
									frame));
					break; }
				case DELETE:
					delete(frame);
					break;
				case DUP:
					frame.dup();
					break;
				case DUP_X1:
					frame.dup_x1();
					break;
				case SWAP:
					frame.swap();
					break;
				case SWAP_X1:
					frame.swap_x1();
					break;
				case IF:
					if ((Boolean) frame.pop()) {
						pc = ((If) instr).getOffset();
					}
					break;
				case IFN:
					if (! (Boolean) frame.pop()) {
						pc = ((Ifn) instr).getOffset();
					}
					break;
				case GOTO:
					pc = ((Goto) instr).getOffset();
					break;
				case ITERATE: {
					final Collection<?> c = (Collection<?>) frame.pop();
					final Iterator<?> i = c.iterator();
					if (i.hasNext()) {
						frame.push(i);
						frame.push(i.next());
					} else {
						pc = ((Iterate) instr).getOffset() + 1; // jump over ENDITERATE
					}
					break; }
				case ENDITERATE: {
					final Iterator<?> i = (Iterator<?>) frame.pop();
					if (i.hasNext()) {
						frame.push(i);
						frame.push(i.next());
						pc = ((Enditerate) instr).getOffset() + 1; // jump to first loop instruction
					}
					break; }
				case INVOKE: {
					final Invoke invoke = (Invoke) instr;
					frame.setPc(pc);
					frame.push(invoke(invoke.getOpname(), invoke.getArgcount(), frame));
					break; }
				case INVOKE_STATIC: {
					final Invoke_static invokeStatic = (Invoke_static) instr;
					frame.setPc(pc);
					frame.push(invokeStatic(invokeStatic.getOpname(), invokeStatic.getArgcount(), frame));
					break; }
				case INVOKE_SUPER: {
					final Invoke_super invokeSuper = (Invoke_super) instr;
					frame.setPc(pc);
					frame.push(invokeSuper(getBodyFor(), invokeSuper.getOpname(), invokeSuper.getArgcount(), frame));
					break; }
				case ALLINST: {
					final Object type = frame.pop();
					frame.push(EMFTVMUtil.findAllInstances(frame.getEnv(),
									(EClass) type));
					break; }
				case ALLINST_IN: {
					final Object type = frame.pop();
					final Object modelname = frame.pop();
					frame.push(EMFTVMUtil.findAllInstIn(frame.getEnv(), 
									(EClass) type, 
									modelname));
					break; }
				case ISNULL:
					frame.push(frame.pop() == null);
					break;
				case GETENVTYPE:
					frame.push(EmftvmPackage.eINSTANCE.getExecEnv());
					break;
				case NOT:
					frame.push(! (Boolean) frame.pop());
					break;
				case AND: {
					final CodeBlock cb = ((And) instr).getCodeBlock();
					frame.setPc(pc);
					frame.push((Boolean) frame.pop() && 
								(Boolean) cb.execute(frame.getSubFrame(cb, null)));
					break; }
				case OR: {
					final CodeBlock cb = ((Or) instr).getCodeBlock();
					frame.setPc(pc);
					frame.push((Boolean) frame.pop() ||
								(Boolean) cb.execute(frame.getSubFrame(cb, null)));
					break; }
				case XOR:
					frame.push((Boolean) frame.pop() ^ (Boolean) frame.pop());
					break;
				case IMPLIES: {
					final CodeBlock cb = ((Implies) instr).getCodeBlock();
					frame.setPc(pc);
					frame.push(!(Boolean) frame.pop() ||
								(Boolean) cb.execute(frame.getSubFrame(cb, null)));
					break; }
				case IFTE: {
					final Ifte ifte = (Ifte) instr;
					final CodeBlock thenCb = ifte.getThenCb(); // CodeBlocks are never wrapped in LazyValues
					final CodeBlock elseCb = ifte.getElseCb();
					frame.setPc(pc);
					if ((Boolean) frame.pop()) {
						frame.push(thenCb.execute(frame.getSubFrame(thenCb, null)));
					} else {
						frame.push(elseCb.execute(frame.getSubFrame(elseCb, null)));
					}
					break; }
				case RETURN:
					break LOOP;
				case GETCB:
					frame.push(((Getcb) instr).getCodeBlock());
					break;
				case INVOKE_ALL_CBS: {
					final Invoke_all_cbs invoke_all_cbs = (Invoke_all_cbs) instr;
					final Object[] args = getArguments(invoke_all_cbs.getArgcount(), frame);
					frame.setPc(pc);
					for (CodeBlock cb : getNested()) {
						frame.push(cb.execute(frame.getSubFrame(cb, args)));
					}
					break; }
				case INVOKE_CB: {
					final Invoke_cb invoke_cb = (Invoke_cb) instr;
					final CodeBlock cb = invoke_cb.getCodeBlock();
					frame.setPc(pc);
					frame.push(cb.execute(frame.getSubFrame(cb, getArguments(invoke_cb.getArgcount(), frame))));
					break; }
				case INVOKE_CB_S: {
					final Invoke_cb_s invoke_cb_s = (Invoke_cb_s) instr;
					final CodeBlock cb = (CodeBlock) frame.pop();
					frame.setPc(pc);
					frame.push(cb.execute(frame.getSubFrame(cb, getArguments(invoke_cb_s.getArgcount(), frame))));
					break; }
				case MATCH: {
					final Match match = (Match) instr;
					final Rule rule = findRule(frame.getEnv(), match);
					frame.setPc(pc);
					frame.push(matchOne(frame, rule, match.getArgcount()));
					break; }
				case MATCH_S: {
					final Match_s match_s = (Match_s) instr;
					final Rule rule = (Rule) frame.pop();
					frame.setPc(pc);
					frame.push(matchOne(frame, rule, match_s.getArgcount()));
					break; }
				case ADD:
					add(frame.pop(), frame.pop(), ((Add) instr).getFieldname(), 
							frame.getEnv(), -1);
					break;
				case REMOVE:
					remove(((Remove) instr).getFieldname(), frame);
					break;
				case INSERT:
					add(frame.pop(), frame.pop(), ((Insert) instr).getFieldname(), 
							frame.getEnv(), (Integer) frame.pop());
					break;
				default:
					throw new VMException(frame, String.format("Unsupported opcode: %s", instr.getOpcode()));
				} // switch
			} // while
		} catch (VMException e) {
			throw e;
		} catch (Exception e) {
			frame.setPc(pc);
			throw new VMException(frame, e);
		}

		if (frame.stackEmpty()) {
			return null;
		} else {
			return frame.pop();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Calculates the amount of elements on the stack after executing this code block.
	 * @return the amount of elements on the stack after executing this code block
	 * <!-- end-user-doc -->
	 */
	public int getStackLevel() {
		final EList<Instruction> code = getCode();
		if (code.isEmpty()) {
			return 0;
		}
		return code.get(code.size()-1).getStackLevel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Module getModule() {
		final EObject container = eContainer();
		switch (container.eClass().getClassifierID()) {
		case EmftvmPackage.FEATURE:
		case EmftvmPackage.FIELD:
		case EmftvmPackage.OPERATION:
			return ((Feature) container).getModule();
		case EmftvmPackage.RULE:
			return ((Rule) container).getModule();
		case EmftvmPackage.INPUT_RULE_ELEMENT:
			return ((InputRuleElement) container).getInputFor().getModule();
		case EmftvmPackage.CODE_BLOCK:
			return ((CodeBlock) container).getModule();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
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
	 * @return the {@link Rule} that contains this codeblock, or <code>null</code>
	 * if not contained by a {@link Rule}.
	 */
	private Rule getRule() {
		if (!ruleSet) {
			CodeBlock cb = this;
			while (cb != null) {
				if (cb.eContainer() instanceof Rule) {
					rule = (Rule) cb.eContainer();
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
	private Field findField(final ExecEnv env, Object type, String name) {
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
	private Field findStaticField(final ExecEnv env, Object type, String name) {
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
	 * @param propname
	 * @param env
	 * @param frame
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private void set(final String propname, final StackFrame frame) 
	throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object o = frame.pop();
		final Object v = frame.pop();

		if (o instanceof EObject) {
			final EObject eo = (EObject) o;
			final EClass type = eo.eClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				field.setValue(o, v);
				return;
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				set(env, eo, sf, v);
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				((XMIResource) resource).setID(eo, v.toString());
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = (o==null ? Void.TYPE : o.getClass());
		final Field field = findField(env, type, propname);
		if (field != null) {
			field.setValue(o, v);
			return;
		}
		try {
			final java.lang.reflect.Field f = type.getField(propname);
			f.set(o, v);
		} catch (NoSuchFieldException e) {
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	private static void set(final ExecEnv env, final EObject eo, final EStructuralFeature sf, 
			final Object value) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format(
					"Field %s::%s is not changeable", 
					EMFTVMUtil.toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format(
					"Cannot set properties of %s, as it is contained in an input model",
					EMFTVMUtil.toPrettyString(eo, env)));
		}
		if (sf.isMany()) {
			if (!(value instanceof Collection<?>)) {
				throw new IllegalArgumentException(String.format(
						"Cannot assign %s to multi-valued field %s::%s",
						value, sf.getEContainingClass().getName(), sf.getName()));
			}
			setMany(env, eo, sf, (Collection<?>) value);
		} else {
			setSingle(env, eo, sf, value, -1);
		}
		assert eo.eResource() != null;
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &lt;= 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index the insertion index (-1 for end)
	 */
	private static void setSingle(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Object value, final int index) {
		assert !sf.isMany();
		if (index > 0) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		final EClassifier sfType = sf.getEType();
		final boolean allowInterModelReferences = isAllowInterModelReferences(env, eo);
		if (sfType instanceof EEnum) {
			final EEnum eEnum = (EEnum) sfType;
			if (value instanceof EnumLiteral) {
				eo.eSet(sf, ((EnumLiteral) value).getEnumerator(eEnum));
			} else {
				eo.eSet(sf, value);
			}
		} else if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			final boolean isContainment = ref.isContainment();
			final boolean isContainer = ref.isContainer();
			if (checkValue(env, eo, ref, value, allowInterModelReferences)) {
				if (isContainment) { // Restore eResource for old value before clearing
					final EObject oldValue = (EObject) eo.eGet(sf);
					if (oldValue != null) {
						eo.eResource().getContents().add(oldValue);
					}
				} else if (isContainer) { // Restore eResource for eo before clearing
					final EObject oldValue = (EObject) eo.eGet(sf);
					if (oldValue != null) {
						oldValue.eResource().getContents().add(eo);
					}
				}
				eo.eSet(sf, value);
				if (isContainment && value instanceof EObject) {
					// Remove value from its resource if it is contained
					((EObject) value).eResource().getContents().remove(value);
					assert ((EObject) value).eContainer() == eo;
					assert ((EObject) value).eResource() == eo.eResource();
				} else if (isContainer && value instanceof EObject) {
					// Remove eo from its resource if it is contained
					eo.eResource().getContents().remove(eo);
					assert eo.eContainer() == value;
					assert ((EObject) value).eResource() == eo.eResource();
				}
			}
		} else {
			eo.eSet(sf, value);
		}
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &gt; 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index the insertion index (-1 for end)
	 */
	@SuppressWarnings("unchecked")
	private static void setMany(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Collection<?> value) {
		assert sf.isMany();
		final EList<Object> values = (EList<Object>) eo.eGet(sf);
		if (!values.isEmpty()) {
			if (sf instanceof EReference && ((EReference) sf).isContainment()) {
				// Restore eResource for each value before clearing
				final EList<EObject> resContents = eo.eResource().getContents();
				resContents.addAll((EList<? extends EObject>) values);
				// Adding values to the resource should have cleared values already - apparently only happens for generated metamodels
				//assert values.isEmpty();
			}
			values.clear();
		}
		addMany(env, eo, sf, value, -1);
	}

	/**
	 * Adds <code>v</code> to <code>values</code>.
	 * Performs enumerator conversion.
	 * @param eEnum The enumeration type
	 * @param values
	 * @param v
	 * @param index the insertion index (-1 for end)
	 */
	private static void addEnumValue(final EEnum eEnum, 
			final EList<Object> values, Object v, final int index) {
		if (v instanceof EnumLiteral) {
			v = ((EnumLiteral) v).getEnumerator(eEnum);
		}
		if (index > -1) {
			values.add(index, v);
		} else {
			values.add(v);
		}
	}

	/**
	 * Removes <code>v</code> from <code>values</code>.
	 * Performs enumerator conversion.
	 * @param eEnum The enumeration type
	 * @param values
	 * @param v
	 */
	private static void removeEnumValue(final EEnum eEnum, 
			final EList<Object> values, final Object v) {
		if (v instanceof EnumLiteral) {
			values.remove(((EnumLiteral) v).getEnumerator(eEnum));
		} else {
			values.remove(v);
		}
	}

	/**
	 * Adds <code>v</code> to <code>values</code>.
	 * Performs constraint checking on <code>v</code>.
	 * @param env
	 * @param ref The reference type
	 * @param eo The object with <code>ref</code> set to <code>values</code>
	 * @param values
	 * @param v
	 * @param index the insertion index (-1 for end)
	 * @param allowInterModelReferences
	 */
	private static void addRefValue(final ExecEnv env, final EReference ref, final EObject eo,
			final EList<Object> values, final Object v, final int index,
			final boolean allowInterModelReferences) {
		if (checkValue(env, eo, ref, v, allowInterModelReferences)) {
			if (index > -1) {
				values.add(index, v);
			} else {
				values.add(v);
			}
			// Adding v to values should have updated (i.e. cleared) its resource if it is contained - apparently only happens for generated metamodels
			//assert !isContainment || (((EObject) v).eContainer() == eo && ((EObject) v).eResource() == eo.eResource());
			if (ref.isContainment() && v instanceof EObject) {
				((EObject) v).eResource().getContents().remove(v);
				assert ((EObject) v).eContainer() == eo;
				assert ((EObject) v).eResource() == eo.eResource();
			}
		}
	}

	/**
	 * Removes <code>v</code> from <code>values</code>.
	 * Performs constraint checking on <code>v</code>.
	 * @param ref The reference type
	 * @param eo The object with <code>ref</code> set to <code>values</code>
	 * @param values
	 * @param v
	 */
	private static void removeRefValue(final EReference ref, final EObject eo,
			final EList<Object> values, final Object v) {
		if (values.remove(v) && ref.isContainment() && v instanceof EObject) {
			eo.eResource().getContents().add((EObject) v);
			assert ((EObject) v).eContainer() == null;
			assert ((EObject) v).eResource() == eo.eResource();
		}
	}

	/**
	 * Adds <code>v</code> to <code>o.propname</code>.
	 * Implements the ADD and INSERT instructions.
	 * @param o
	 * @param v
	 * @param propname
	 * @param env
	 * @param index the insertion index (-1 for end)
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private void add(final Object o, final Object v, final String propname, 
			final ExecEnv env, final int index) 
	throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		//TODO enable add on fields
		if (o instanceof EObject) {
			final EObject eo = (EObject) o;
			final EClass type = eo.eClass();
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				add(env, eo, sf, v, index);
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				if (((XMIResource) resource).getID(eo) != null) {
					throw new IllegalArgumentException(String.format(
							"Cannot add %s to field %s::%s: maximum multiplicity of 1 reached", 
							v, EMFTVMUtil.toPrettyString(eo, env), propname));
				}
				if (index > 0) {
					throw new IndexOutOfBoundsException(String.valueOf(index));
				}
				((XMIResource) resource).setID(eo, v.toString());
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * Adds the <code>value</code> of <code>eo.sf</code>.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index the insertion index (-1 for end)
	 */
	private static void add(final ExecEnv env, final EObject eo, final EStructuralFeature sf, 
			final Object value, final int index) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format(
					"Field %s::%s is not changeable", 
					EMFTVMUtil.toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format(
					"Cannot add properties to %s, as it is contained in an input model",
					EMFTVMUtil.toPrettyString(eo, env)));
		}
		if (sf.isMany()) {
			if (value instanceof Collection<?>) {
				addMany(env, eo, sf, (Collection<?>) value, index);
			} else {
				addMany(env, eo, sf, value, index);
			}
		} else {
			if (eo.eIsSet(sf)) {
				throw new IllegalArgumentException(String.format("Cannot add more than one value to %s::%s", 
						EMFTVMUtil.toPrettyString(eo.eClass(), env), sf.getName()));
			}
			setSingle(env, eo, sf, value, index);
		}
		assert eo.eResource() != null;
	}

	/**
	 * Adds <code>value</code> to <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &gt; 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index the insertion index (-1 for end)
	 */
	@SuppressWarnings("unchecked")
	private static void addMany(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Object value, final int index) {
		assert sf.isMany();
		final EClassifier sfType = sf.getEType();
		final EList<Object> values = (EList<Object>) eo.eGet(sf); // All EMF collections are ELists
		if (sfType instanceof EEnum) {
			addEnumValue((EEnum) sfType, values, value, index);
		} else if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			addRefValue(env, ref, eo, values, value, index, 
					isAllowInterModelReferences(env, eo));
		} else if (index > -1) {
			values.add(index, value);
		} else {
			values.add(value);
		}
	}

	/**
	 * Adds all <code>value</code> elements to <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &gt; 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index the insertion index (-1 for end)
	 */
	@SuppressWarnings("unchecked")
	private static void addMany(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Collection<?> value, final int index) {
		assert sf.isMany();
		final EClassifier sfType = sf.getEType();
		final EList<Object> values = (EList<Object>) eo.eGet(sf);
		if (sfType instanceof EEnum) {
			final EEnum eEnum = (EEnum) sfType;
			if (index > -1) {
				int currentIndex = index;
				for (Object v : value) {
					addEnumValue(eEnum, values, v, currentIndex++);
				}
			} else {
				for (Object v : value) {
					addEnumValue(eEnum, values, v, -1);
				}
			}
		} else if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			final boolean allowInterModelReferences = isAllowInterModelReferences(env, eo);
			if (index > -1) {
				int currentIndex = index;
				for (Object v : value) {
					addRefValue(env, ref, eo, values, v, currentIndex++, allowInterModelReferences);
				}
			} else {
				for (Object v : value) {
					addRefValue(env, ref, eo, values, v, -1, allowInterModelReferences);
				}
			}
		} else if (index > -1) {
			values.addAll(index, value);
		} else {
			values.addAll(value);
		}
	}

	/**
	 * Implements the REMOVE instruction.
	 * @param propname
	 * @param env
	 * @param frame
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private void remove(final String propname, final StackFrame frame) 
	throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object o = frame.pop();
		final Object v = frame.pop();

		//TODO enable remove on fields
		if (o instanceof EObject) {
			final EObject eo = (EObject) o;
			final EClass type = eo.eClass();
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				remove(env, eo, sf, v);
				return;
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				final XMIResource xmiRes = (XMIResource) resource;
				final Object xmiID = xmiRes.getID(eo);
				if (xmiID==null ? v==null : xmiID.equals(v)) {
					xmiRes.setID(eo, null);
				}
				return;
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * Removes the <code>value</code> from <code>eo.sf</code>.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	private static void remove(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Object value) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format(
					"Field %s::%s is not changeable", 
					EMFTVMUtil.toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format(
					"Cannot remove properties of %s, as it is contained in an input model",
					EMFTVMUtil.toPrettyString(eo, env)));
		}
		final EClassifier sfType = sf.getEType();
		if (sf.isMany()) {
			if (value instanceof Collection<?>) {
				removeMany(env, eo, sf, (Collection<?>) value);
			} else {
				removeMany(env, eo, sf, value);
			}
		} else {
			final Object oldValue = eo.eGet(sf);
			if (sfType instanceof EEnum && value instanceof EnumLiteral) {
				final EEnum eEnum = (EEnum) sfType;
				if (oldValue != null && oldValue.equals(((EnumLiteral) value).getEnumerator(eEnum))) {
					setSingle(env, eo, sf, sf.getDefaultValue(), -1);
				}
			} else {
				if (oldValue==null ? value==null : oldValue.equals(value)) {
					setSingle(env, eo, sf, sf.getDefaultValue(), -1);
				}
			}
		}
		assert eo.eResource() != null;
	}

	/**
	 * Removes the <code>value</code> from <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &gt; 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	private static void removeMany(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Object value) {
		assert sf.isMany();
		final EClassifier sfType = sf.getEType();
		final EList<Object> values = (EList<Object>) eo.eGet(sf);
		if (sfType instanceof EEnum) {
			final EEnum eEnum = (EEnum) sfType;
			removeEnumValue(eEnum, values, value);
		} else if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			removeRefValue(ref, eo, values, value);
		} else {
			values.remove(value);
		}
	}

	/**
	 * Removes all elements of <code>value</code> from <code>eo.sf</code>.
	 * Assumes <code>sf</code> has a multiplicity &gt; 1.
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	private static void removeMany(final ExecEnv env, final EObject eo, 
			final EStructuralFeature sf, final Collection<?> value) {
		assert sf.isMany();
		final EClassifier sfType = sf.getEType();
		final EList<Object> values = (EList<Object>) eo.eGet(sf);
		if (sfType instanceof EEnum) {
			final EEnum eEnum = (EEnum) sfType;
			for (Object v : value) {
				removeEnumValue(eEnum, values, v);
			}
		} else if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			for (Object v : value) {
				removeRefValue(ref, eo, values, v);
			}
		} else {
			values.removeAll(value);
		}
	}

	/**
	 * @param env
	 * @param eo
	 * @return <code>true</code> iff the model of eo allows inter-model references
	 */
	private static boolean isAllowInterModelReferences(final ExecEnv env, final EObject eo) {
		final Model eoModel = env.getModelOf(eo);
		if (eoModel != null) {
			return eoModel.isAllowInterModelReferences();
		} else {
			return true;
		}
	}

	/**
	 * @param env
	 * @param eo
	 * @param ref
	 * @param value
	 * @param allowInterModelReferences
	 * @return <code>true</code> iff the value may be assigned
	 */
	private static boolean checkValue(final ExecEnv env, final EObject eo, final EReference ref, 
			final Object value, final boolean allowInterModelReferences) {
		if (value instanceof EObject) {
			assert eo.eResource() != null;
			final EObject ev = (EObject) value;
			if (eo.eResource() == ev.eResource() || ev.eResource() == null) {
				return true;
			}
			assert ev.eResource() != null;
			if (!allowInterModelReferences) {
				ATLLogger.warning(String.format(
						"Cannot set %s::%s to %s for %s: inter-model references are not allowed for this model",
						EMFTVMUtil.toPrettyString(ref.getEContainingClass(), env), 
						ref.getName(), 
						EMFTVMUtil.toPrettyString(value, env), 
						EMFTVMUtil.toPrettyString(eo, env)));
				return false;
			}
			if (ref.isContainer() || ref.isContainment()) {
				ATLLogger.warning(String.format(
						"Cannot set %s::%s to %s for %s: containment references cannot span across models",
						EMFTVMUtil.toPrettyString(ref.getEContainingClass(), env), 
						ref.getName(), 
						EMFTVMUtil.toPrettyString(value, env), 
						EMFTVMUtil.toPrettyString(eo, env)));
				return false;
			}
			final EReference opposite = ref.getEOpposite();
			if (opposite != null) {
				final Model evModel = env.getInputModelOf(ev);
				if (evModel != null) {
					ATLLogger.warning(String.format(
							"Cannot set %s::%s to %s for %s: inter-model reference with opposite causes changes in input model %s",
							EMFTVMUtil.toPrettyString(ref.getEContainingClass(), env), 
							ref.getName(), 
							EMFTVMUtil.toPrettyString(value, env), 
							EMFTVMUtil.toPrettyString(eo, env),
							env.getModelID(evModel)));
					return false;
				}
				if (!opposite.isMany()) {
					// Single-valued opposites cause changes in their respective opposite,
					// i.e. ref, which can belong to eo or another input model element.
					final Model oppositeModel = env.getInputModelOf((EObject) ev.eGet(opposite));
					if (oppositeModel != null) {
						ATLLogger.warning(String.format(
								"Cannot set %s::%s to %s for %s: inter-model reference with single-valued opposite causes changes in input model %s",
								EMFTVMUtil.toPrettyString(ref.getEContainingClass(), env), 
								ref.getName(), 
								EMFTVMUtil.toPrettyString(value, env), 
								EMFTVMUtil.toPrettyString(eo, env),
								env.getModelID(oppositeModel)));
						return false;
					}
				}
			}
		}
		return true; // any type errors can be delegated to EMF
	}

	/**
	 * Implements the GET instruction.
	 * @param propname
	 * @param env
	 * @param frame
	 * @return the property value
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings("unchecked")
	private Object get(final String propname, final StackFrame frame) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		Object o = frame.pop();

		if (o instanceof EObject) {
			final EObject eo = (EObject) o;
			final EClass type = eo.eClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				return field.getValue(o, frame);
			}
			final EStructuralFeature sf = type.getEStructuralFeature(propname);
			if (sf != null) {
				return get(env, eo, sf);
			}
			final Resource resource = eo.eResource();
			if (EMFTVMUtil.XMI_ID_FEATURE.equals(propname) && resource instanceof XMIResource) { //$NON-NLS-1$
				return ((XMIResource) resource).getID(eo);
			}
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}

		// o is a regular Java object
		final Class<?> type = (o==null ? Void.TYPE : o.getClass());
		final Field field = findField(env, type, propname);
		if (field != null) {
			return field.getValue(o, frame);
		}
		try {
			final java.lang.reflect.Field f = type.getField(propname);
			final Object result = f.get(o);
			if (result instanceof List<?>) {
				return new LazyListOnList<Object>((List<Object>) result);
			} else if (result instanceof java.util.Set<?>) {
				return new LazySetOnSet<Object>((java.util.Set<Object>) result);
			} else if (result instanceof Collection<?>) {
				return new LazyBagOnCollection<Object>((Collection<Object>) result);
			} else {
				return result;
			}
		} catch (NoSuchFieldException e) {
			throw new NoSuchFieldException(String.format("Field %s::%s not found", 
					EMFTVMUtil.toPrettyString(type, env), propname));
		}
	}

	/**
	 * @param env
	 * @param eo
	 * @param sf
	 * @return the value of eo.sf.
	 */
	@SuppressWarnings("unchecked")
	private static Object get(final ExecEnv env, final EObject eo, final EStructuralFeature sf) {
		if (env.getOutputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format(
					"Cannot read properties of %s, as it is contained in an output model",
					EMFTVMUtil.toPrettyString(eo, env)));
		}
		final Object value = eo.eGet(sf);
		if (value instanceof Enumerator) {
			return new EnumLiteral(value.toString());
		} else if (value instanceof EList<?>) {
			final EnumConversionList converted = new EnumConversionList((EList<Object>) value);
			if (env.getInoutModelOf(eo) != null) {
				//Copy list for inout models
				converted.cache();
			}
			return converted;
		}
		assert !(value instanceof Collection<?>); // All EMF collections should be ELists
		return value;
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
	private Collection<Object> getTrans(final String propname, final StackFrame frame) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object o = frame.pop();

		if (o instanceof EObject) {
			final EObject eo = (EObject) o;
			final EClass type = eo.eClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				return getTrans(o, field, frame, new LazyList<Object>());
			} else {
				final EStructuralFeature sf = type.getEStructuralFeature(propname);
				if (sf == null) {
					throw new NoSuchFieldException(String.format("Field %s::%s not found", 
							EMFTVMUtil.toPrettyString(type, env), propname));
				}
				return getTrans(eo, sf, env, new LazyList<Object>());
			}
		} else {
			final Class<?> type = o.getClass();
			final Field field = findField(env, type, propname);
			if (field != null) {
				return getTrans(o, field, frame, new LazyList<Object>());
			} else {
				final java.lang.reflect.Field f = type.getField(propname);
				return getTrans(o, f, new LazyList<Object>());
			}
		}
	}

	/**
	 * Retrieves the transitive closure of field on object and stores the value in result.
	 * @param object
	 * @param field
	 * @param frame
	 * @param result
	 * @return the updated result
	 */
	@SuppressWarnings("unchecked")
	private static LazyList<Object> getTrans(final Object object, final Field field, 
			final StackFrame frame, LazyList<Object> result) {
		final Object value = field.getValue(object, frame);
		if (value instanceof List<?>) {
			final List<Object> cvalue = (List<Object>) value;
			result = result.union(new LazyListOnList<Object>(cvalue));
			for (Object v : cvalue) {
				result = getTrans(v, field, frame, result);
			}
		} else if (value instanceof Collection<?>) {
			final Collection<Object> cvalue = (Collection<Object>) value;
			result = result.union(new LazyListOnCollection<Object>(cvalue));
			for (Object v : cvalue) {
				result = getTrans(v, field, frame, result);
			}
		} else if (value != null) {
			result = result.append(value);
			result = getTrans(value, field, frame, result);
		}
		return result;
	}

	/**
	 * Retrieves the transitive closure of sf on object and stores the value in result.
	 * @param object
	 * @param sf
	 * @param env
	 * @param result
	 * @return the updated result
	 */
	@SuppressWarnings("unchecked")
	private static LazyList<Object> getTrans(final EObject object, 
			final EStructuralFeature sf, final ExecEnv env, 
			LazyList<Object> result) {
		if (!sf.getEContainingClass().isSuperTypeOf(object.eClass())) {
			return result; // feature does not apply to object
		}
		final Object value = get(env, object, sf);
		if (value instanceof LazyList<?>) {
			final LazyList<Object> cvalue = (LazyList<Object>) value;
			result = result.union(cvalue);
			for (Object v : cvalue) {
				if (v instanceof EObject) {
					result = getTrans((EObject) v, sf, env, result);
				}
			}
		} else if (value != null) {
			assert !(value instanceof Collection<?>); // All collections should be LazyLists
			if (value instanceof Enumerator) {
				result = result.append(new EnumLiteral(value.toString()));
			} else {
				result = result.append(value);
				if (value instanceof EObject) {
					result = getTrans((EObject) value, sf, env, result);
				}
			}
		}
		return result;
	}

	/**
	 * Retrieves the transitive closure of field on object and stores the value in result.
	 * @param object
	 * @param field
	 * @param result
	 * @return the updated result
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings("unchecked")
	private static LazyList<Object> getTrans(final Object object, 
			final java.lang.reflect.Field field, 
			LazyList<Object> result) throws IllegalArgumentException, IllegalAccessException {
		if (!field.getDeclaringClass().isAssignableFrom(object.getClass())) {
			return result; // field does not apply to object
		}
		final Object value = field.get(object);
		if (value instanceof LazyList<?>) {
			final LazyList<Object> cvalue = (LazyList<Object>) value;
			result = result.union(cvalue);
			for (Object v : cvalue) {
				result = getTrans(v, field, result);
			}
		} else if (value instanceof List<?>) {
			final List<Object> cvalue = (List<Object>) value;
			result = result.union(new LazyListOnList<Object>(cvalue));
			for (Object v : cvalue) {
				result = getTrans(v, field, result);
			}
		} else if (value instanceof Collection<?>) {
			final Collection<Object> cvalue = (Collection<Object>) value;
			result = result.union(new LazyListOnCollection<Object>(cvalue));
			for (Object v : cvalue) {
				result = getTrans(v, field, result);
			}
		} else if (value != null) {
			result = result.append(value);
			result = getTrans(value, field, result);
		}
		return result;
	}

	/**
	 * Implements the SET_STATIC instruction.
	 * @param propname
	 * @param frame
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private void setStatic(final String propname, final StackFrame frame) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object o = EMFTVMUtil.getRegistryType(frame.pop());
		final Object v = frame.pop();

		if (o instanceof EClass) {
			final EClass type = (EClass) o;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				field.setStaticValue(v);
			} else {
				throw new NoSuchFieldException(String.format("Field %s::%s not found", 
						EMFTVMUtil.toPrettyString(type, env), propname));
			}
		} else if (o instanceof Class<?>) {
			final Class<?> type = (Class<?>) o;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				field.setValue(o, v);	
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
					EMFTVMUtil.toPrettyString(o, env)));
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
	private Object getStatic(final String propname, final StackFrame frame) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final ExecEnv env = frame.getEnv();
		final Object o = EMFTVMUtil.getRegistryType(frame.pop());

		if (o instanceof EClass) {
			final EClass type = (EClass) o;
			final Field field = findStaticField(env, type, propname);
			if (field != null) {
				return field.getStaticValue(frame);
			} else {
				throw new NoSuchFieldException(String.format("Field %s::%s not found", 
						EMFTVMUtil.toPrettyString(type, env), propname));
			}
		} else if (o instanceof Class<?>) {
			final Class<?> type = (Class<?>) o;
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
			throw new IllegalArgumentException(String.format("%s is not a type", o));
		}
	}

	/**
	 * Implements the NEW and NEW_S instructions.
	 * @param modelname
	 * @param type
	 * @param fram
	 * @return the new object
	 */
	private static Object new_(final String modelname, final Object type, final StackFrame frame) {
		final ExecEnv env = frame.getEnv();
		if (type instanceof EClass) {
			final EClass eType = (EClass) type;
			Model model = env.getOutputModels().get(modelname);
			if (model == null) {
				model = env.getInoutModels().get(modelname);
			}
			if (model == null) {
				throw new IllegalArgumentException(String.format("Inout/output model %s not found", modelname));
			}
			return model.newElement(eType);
		} else {
			final Class<?> jType = (Class<?>) type;
			try {
				return jType.newInstance();
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	/**
	 * Implements the DELETE instruction.
	 * @param frame
	 */
	private static void delete(final StackFrame frame) {
		final ExecEnv env = frame.getEnv();
		final EObject element = (EObject) frame.pop();

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
		env.getDeletionQueue().add(element);
	}

	/**
	 * Implements the INVOKE instruction.
	 * @param opname
	 * @param argcount
	 * @param frame
	 * @return the invocation result
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static Object invoke(final String opname, final int argcount, 
			final StackFrame frame) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final ExecEnv env = frame.getEnv();
		final Object o = frame.pop();

		// Null parameters are fine in our multi-methods, as null is just a special singleton object 
//		if (o == null) {
//			throw new IllegalArgumentException(String.format("Cannot invoke operation %s on null object", opname));
//		}

		final Object type = getArgumentType(o);
		final Object[] args = getArguments(argcount, frame);
		final EList<Object> argTypes = getArgumentTypes(args);
		final Operation op = env.findOperation(type, opname, argTypes);
		if (op != null) {
			final CodeBlock body = op.getBody();
			return body.execute(frame.getSubFrame(body, o, args));
		}
		final Class<?>[] argClasses = getArgumentClasses(args);
		final Method method = findNativeMethod(o.getClass(), opname, argClasses, false);
		if (method != null) {
			final StackFrame subFrame = frame.getSubFrame(method, args);
			try {
				return method.invoke(o, args);
			} catch (InvocationTargetException e) {
				final Throwable target = e.getTargetException();
				if (target instanceof VMException) {
					throw (VMException) target;
				} else {
					throw new VMException(subFrame, target);
				}
			} catch (VMException e) {
				throw e;
			} catch (Exception e) {
				throw new VMException(subFrame, e);
			}
		}
		throw new UnsupportedOperationException(String.format("%s::%s(%s)", 
				EMFTVMUtil.getTypeName(env, type), opname, EMFTVMUtil.getTypeNames(env, argTypes)));
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
	private static Object invokeStatic(final String opname, final int argcount, 
			final StackFrame frame) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final ExecEnv env = frame.getEnv();
		final Object type = frame.pop();

		if (type == null) {
			throw new IllegalArgumentException(String.format("Cannot invoke static operation %s on null type", opname));
		}

		if (type == env.eClass()) { // Lazy and called rule invocations are indistinguishable from static operations in ATL
			final Rule rule = env.findRule(opname);
			if (rule != null) {
				return matchOne(frame, rule, argcount);
			}
		}

		final Object[] args = getArguments(argcount, frame);
		final EList<Object> argTypes = getArgumentTypes(args);
		final Operation op = env.findStaticOperation(type, opname, argTypes);
		if (op != null) {
			final CodeBlock body = op.getBody();
			return body.execute(frame.getSubFrame(body, args));
		}
		if (type instanceof Class<?>) {
			final Class<?>[] argClasses = getArgumentClasses(args);
			final Method method = findNativeMethod((Class<?>) type, opname, argClasses, true);
			if (method != null) {
				final StackFrame subFrame = frame.getSubFrame(method, args);
				try {
					return method.invoke(args);
				} catch (InvocationTargetException e) {
					final Throwable target = e.getTargetException();
					if (target instanceof VMException) {
						throw (VMException) target;
					} else {
						throw new VMException(subFrame, target);
					}
				} catch (VMException e) {
					throw e;
				} catch (Exception e) {
					throw new VMException(subFrame, e);
				}
			}
		}
		throw new UnsupportedOperationException(String.format("static %s::%s(%s)", 
				EMFTVMUtil.getTypeName(env, type), opname, EMFTVMUtil.getTypeNames(env, argTypes)));
	}

	/**
	 * Implements the INVOKE_SUPER instruction.
	 * @param context the current execution context type
	 * @param opname
	 * @param argcount
	 * @param frame
	 * @return the invocation result
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static Object invokeSuper(final Operation op, final String opname, final int argcount, 
			final StackFrame frame) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (op == null) {
			throw new IllegalArgumentException("INVOKE_SUPER can only be used in operations");
		}
		final EClassifier context = op.getEContext();
		if (context == null) {
			throw new IllegalArgumentException(String.format("Operation misses context type: %s", op));
		}

		final ExecEnv env = frame.getEnv();
		final Object o = frame.pop();

		// Null parameters are fine in our multi-methods, as null is just a special singleton object 
//		if (o == null) {
//			throw new IllegalArgumentException(String.format("Cannot invoke super operation %s on null object", opname));
//		}

		final java.util.Set<Operation> ops = new LinkedHashSet<Operation>();
		final List<?> superTypes;
		if (context instanceof EClass) {
			superTypes = ((EClass) context).getESuperTypes();
		} else {
			final Class<?> ic = context.getInstanceClass();
			if (ic == null) {
				throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", context));
			}
			superTypes = Collections.singletonList(ic.getSuperclass());
		}

		final Object[] args = getArguments(argcount, frame);
		final EList<Object> argTypes = getArgumentTypes(args);
		Operation superOp = null;
		for (Object superType : superTypes) {
			superOp = env.findOperation(superType, opname, argTypes);
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

		if (superOp != null) {
			final CodeBlock body = superOp.getBody();
			return body.execute(frame.getSubFrame(body, o, args));
		}

		final Class<?> ic = context.getInstanceClass();
		if (ic != null) {
			final Class<?>[] argClasses = getArgumentClasses(args);
			final Method method = findNativeMethod(ic.getSuperclass(), opname, argClasses, false);
			if (method != null) {
				final StackFrame subFrame = frame.getSubFrame(method, args);
				try {
					return method.invoke(o, args);
				} catch (InvocationTargetException e) {
					final Throwable target = e.getTargetException();
					if (target instanceof VMException) {
						throw (VMException) target;
					} else {
						throw new VMException(subFrame, target);
					}
				} catch (VMException e) {
					throw e;
				} catch (Exception e) {
					throw new VMException(subFrame, e);
				}
			}
		}

		throw new UnsupportedOperationException(String.format("super %s::%s(%s)", 
				EMFTVMUtil.getTypeName(env, context), opname, EMFTVMUtil.getTypeNames(env, argTypes)));
	}

	/**
	 * Looks for a native Java method.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param name
	 *            The method name
	 * @param argumentTypes
	 *            The types of all arguments
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @return the method if found, null otherwise
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	//TODO implement multi-methods in ExecEnv
	private static Method findNativeMethod(final Class<?> context, final String opname, 
			final Class<?>[] argTypes, final boolean isStatic) {
		if (context == Void.TYPE) {
			return null; // Java methods cannot be invoked on null, or defined on Void
		}

		final String sig = getMethodSignature(opname, argTypes, isStatic);
		Method ret = findCachedMethod(context, sig);
		if (ret != null) {
			return ret;
		}

		final Method[] methods = context.getDeclaredMethods();
		for (int i = 0; i < (methods.length) && (ret == null); i++) {
			Method method = methods[i];
			if ((Modifier.isStatic(method.getModifiers()) == isStatic) && method.getName().equals(opname)) {
				Class<?>[] pts = method.getParameterTypes();
				if (pts.length == argTypes.length) {
					boolean ok = true;
					for (int j = 0; (j < pts.length) && ok; j++) {
						if (argTypes[j] == EnumLiteral.class && Enumerator.class.isAssignableFrom(pts[j])) {
							continue;
						}
						if (!pts[j].isAssignableFrom(argTypes[j])) {
							if (pts[j]==boolean.class) ok = argTypes[j]==Boolean.class;
							else if (pts[j]==int.class) ok = argTypes[j]==Integer.class;
							else if (pts[j]==char.class) ok = argTypes[j]==Character.class;
							else if (pts[j]==long.class) ok = argTypes[j]==Long.class;
							else if (pts[j]==float.class) ok = argTypes[j]==Float.class;
							else if (pts[j]==double.class) ok = argTypes[j]==Double.class;
							else ok = argTypes[j]==Void.TYPE; // any type
						}
					}
					if (ok) {
						ret = method;
					}
				}
			}
		}

		if ((ret == null) && (context.getSuperclass() != null)) {
			ret = findNativeMethod(context.getSuperclass(), opname, argTypes, isStatic);
		}

		cacheMethod(context, sig, ret);

		return ret;
	}

	/**
	 * Find a method in the cache.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param signature
	 *            The method signature
	 * @return the method
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static Method findCachedMethod(Class<?> caller, String signature) {
		Method ret = null;
		Map<String, Method> sigMap = methodCache.get(caller);
		if (sigMap != null) {
			ret = sigMap.get(signature);
		}
		return ret;
	}

	/**
	 * Stores a method in a cache.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param signature
	 *            The method signature
	 * @param method
	 *            The method to store
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static void cacheMethod(Class<?> caller, String signature, Method method) {
		synchronized (methodCache) {
			Map<String, Method> sigMap = methodCache.get(caller);
			if (sigMap == null) {
				sigMap = new HashMap<String, Method>();
				methodCache.put(caller, sigMap);
			}
			sigMap.put(signature, method);
		}
	}

	/**
	 * Generates a String signature to store methods.
	 * 
	 * @param name
	 * @param argumentTypes
	 * @param isStatic
	 * @return The method signature
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static String getMethodSignature(final String name, final Class<?>[] argumentTypes, 
			final boolean isStatic) {
		final StringBuffer sig = new StringBuffer();
		if (isStatic) {
			sig.append("static ");
		}
		sig.append(name);
		sig.append('(');
		for (int i = 0; i < argumentTypes.length; i++) {
			if (i > 0) {
				sig.append(',');
			}
			sig.append(argumentTypes[i].getName());
		}
		sig.append(')');
		return sig.toString();
	}

	/**
	 * Gets argcount objects off the stack and returns them.
	 * @param argcount
	 * @param frame
	 * @return the arguments
	 */
	private static Object[] getArguments(final int argcount, final StackFrame frame) {
		final Object[] args = new Object[argcount];
		for (int i = 0; i < argcount; i++) {
			// Do not unwrap lazy values
			args[i] = frame.pop();
		}
		return args;
	}

	/**
	 * @param args
	 * @return the types of args
	 */
	private static EList<Object> getArgumentTypes(final Object[] args) {
		final EList<Object> argTypes = new BasicEList<Object>(args.length);
		for (Object arg : args) {
			argTypes.add(getArgumentType(arg));
		}
		return argTypes;
	}

	/**
	 * @param args
	 * @return the types of args
	 */
	private static Object getArgumentType(final Object arg) {
		if (arg instanceof EObject) {
			return ((EObject) arg).eClass();
		} else if (arg != null) {
			return arg.getClass();
		}
		// null is an instance of Void for the purpose of our multi-method semantics
		return Void.TYPE;
	}

	/**
	 * @param args
	 * @return the classes of args
	 */
	private static Class<?>[] getArgumentClasses(final Object[] args) {
		final Class<?>[] argTypes = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			argTypes[i] = args[i] == null ? Void.TYPE : args[i].getClass();
		}
		return argTypes;
	}

	/**
	 * @param env
	 * @param instr
	 * @return the rule mentioned by instr
	 * @throws IllegalArgumentException if rule not found
	 */
	private static Rule findRule(final ExecEnv env, final Match instr) {
		final String rulename = instr.getRulename();
		final Rule rule = env.findRule(rulename);
		if (rule == null) {
			throw new IllegalArgumentException(String.format("Rule %s not found", rulename));
		}
		return rule;
	}

	/**
	 * Executes rule with parameters derived from <code>rule</code>.
	 * @param frame
	 * @param rule
	 * @param argcount
	 */
	private static Object matchOne(final StackFrame frame, final Rule rule, final int argcount) {
		if (argcount != rule.getInputElements().size()) {
			throw new VMException(frame, String.format(
					"Rule %s has different amount of input elements than expected: %d instead of %d",
					rule.getName(), rule.getInputElements().size(), argcount));
		}
		final EObject[] elements = new EObject[argcount];
		for (int i = 0; i < argcount; i++) {
			elements[i] = (EObject) frame.pop();
		}
		return Matcher.matchOne(frame, rule, elements);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		final EObject container = eContainer();
		if (container != null) {
			result.append(container);
			if (container instanceof CodeBlock) {
				result.append('@');
				result.append(((CodeBlock) container).getNested().indexOf(this));
			} else if (container instanceof Field) {
				// nothing
			} else if (container instanceof Operation) {
				// nothing
			} else if (container instanceof InputRuleElement) {
				result.append('@');
				result.append(((InputRuleElement) container).getInputFor());
			} else if (container instanceof Rule) {
				final Rule r = (Rule) container;
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

} //CodeBlockImpl
