/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.common.ATL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage
 * @generated
 */
public class ATLFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ATLFactory eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ATLFactory init() {
		try {
			ATLFactory theATLFactory = (ATLFactory)EPackage.Registry.INSTANCE.getEFactory(ATLPackage.eNS_URI);
			if (theATLFactory != null) {
				return theATLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ATLFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ATLPackage.UNIT: return createUnit();
			case ATLPackage.LIBRARY: return createLibrary();
			case ATLPackage.QUERY: return createQuery();
			case ATLPackage.MODULE: return createModule();
			case ATLPackage.HELPER: return createHelper();
			case ATLPackage.MATCHED_RULE: return createMatchedRule();
			case ATLPackage.LAZY_MATCHED_RULE: return createLazyMatchedRule();
			case ATLPackage.CALLED_RULE: return createCalledRule();
			case ATLPackage.IN_PATTERN: return createInPattern();
			case ATLPackage.OUT_PATTERN: return createOutPattern();
			case ATLPackage.DROP_PATTERN: return createDropPattern();
			case ATLPackage.SIMPLE_IN_PATTERN_ELEMENT: return createSimpleInPatternElement();
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT: return createSimpleOutPatternElement();
			case ATLPackage.FOR_EACH_OUT_PATTERN_ELEMENT: return createForEachOutPatternElement();
			case ATLPackage.BINDING: return createBinding();
			case ATLPackage.RULE_VARIABLE_DECLARATION: return createRuleVariableDeclaration();
			case ATLPackage.LIBRARY_REF: return createLibraryRef();
			case ATLPackage.ACTION_BLOCK: return createActionBlock();
			case ATLPackage.EXPRESSION_STAT: return createExpressionStat();
			case ATLPackage.BINDING_STAT: return createBindingStat();
			case ATLPackage.IF_STAT: return createIfStat();
			case ATLPackage.FOR_STAT: return createForStat();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		Unit unit = new Unit();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		Library library = new Library();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		Query query = new Query();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		Module module = new Module();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper createHelper() {
		Helper helper = new Helper();
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule createMatchedRule() {
		MatchedRule matchedRule = new MatchedRule();
		return matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyMatchedRule createLazyMatchedRule() {
		LazyMatchedRule lazyMatchedRule = new LazyMatchedRule();
		return lazyMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalledRule createCalledRule() {
		CalledRule calledRule = new CalledRule();
		return calledRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern createInPattern() {
		InPattern inPattern = new InPattern();
		return inPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPattern createOutPattern() {
		OutPattern outPattern = new OutPattern();
		return outPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropPattern createDropPattern() {
		DropPattern dropPattern = new DropPattern();
		return dropPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleInPatternElement createSimpleInPatternElement() {
		SimpleInPatternElement simpleInPatternElement = new SimpleInPatternElement();
		return simpleInPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement createSimpleOutPatternElement() {
		SimpleOutPatternElement simpleOutPatternElement = new SimpleOutPatternElement();
		return simpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachOutPatternElement createForEachOutPatternElement() {
		ForEachOutPatternElement forEachOutPatternElement = new ForEachOutPatternElement();
		return forEachOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding createBinding() {
		Binding binding = new Binding();
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleVariableDeclaration createRuleVariableDeclaration() {
		RuleVariableDeclaration ruleVariableDeclaration = new RuleVariableDeclaration();
		return ruleVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryRef createLibraryRef() {
		LibraryRef libraryRef = new LibraryRef();
		return libraryRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionBlock createActionBlock() {
		ActionBlock actionBlock = new ActionBlock();
		return actionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStat createExpressionStat() {
		ExpressionStat expressionStat = new ExpressionStat();
		return expressionStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingStat createBindingStat() {
		BindingStat bindingStat = new BindingStat();
		return bindingStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStat createIfStat() {
		IfStat ifStat = new IfStat();
		return ifStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStat createForStat() {
		ForStat forStat = new ForStat();
		return forStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLPackage getATLPackage() {
		return (ATLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ATLPackage getPackage() {
		return ATLPackage.eINSTANCE;
	}

} //ATLFactory
