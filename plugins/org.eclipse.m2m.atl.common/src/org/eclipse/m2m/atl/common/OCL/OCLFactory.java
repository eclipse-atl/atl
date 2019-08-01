/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.common.OCL;

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
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage
 * @generated
 */
public class OCLFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final OCLFactory eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLFactory init() {
		try {
			OCLFactory theOCLFactory = (OCLFactory)EPackage.Registry.INSTANCE.getEFactory(OCLPackage.eNS_URI);
			if (theOCLFactory != null) {
				return theOCLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLFactory() {
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
			case OCLPackage.VARIABLE_EXP: return createVariableExp();
			case OCLPackage.SUPER_EXP: return createSuperExp();
			case OCLPackage.STRING_EXP: return createStringExp();
			case OCLPackage.BOOLEAN_EXP: return createBooleanExp();
			case OCLPackage.REAL_EXP: return createRealExp();
			case OCLPackage.INTEGER_EXP: return createIntegerExp();
			case OCLPackage.BAG_EXP: return createBagExp();
			case OCLPackage.ORDERED_SET_EXP: return createOrderedSetExp();
			case OCLPackage.SEQUENCE_EXP: return createSequenceExp();
			case OCLPackage.SET_EXP: return createSetExp();
			case OCLPackage.TUPLE_EXP: return createTupleExp();
			case OCLPackage.TUPLE_PART: return createTuplePart();
			case OCLPackage.MAP_EXP: return createMapExp();
			case OCLPackage.MAP_ELEMENT: return createMapElement();
			case OCLPackage.ENUM_LITERAL_EXP: return createEnumLiteralExp();
			case OCLPackage.OCL_UNDEFINED_EXP: return createOclUndefinedExp();
			case OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP: return createNavigationOrAttributeCallExp();
			case OCLPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case OCLPackage.OPERATOR_CALL_EXP: return createOperatorCallExp();
			case OCLPackage.COLLECTION_OPERATION_CALL_EXP: return createCollectionOperationCallExp();
			case OCLPackage.ITERATE_EXP: return createIterateExp();
			case OCLPackage.ITERATOR_EXP: return createIteratorExp();
			case OCLPackage.LET_EXP: return createLetExp();
			case OCLPackage.IF_EXP: return createIfExp();
			case OCLPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case OCLPackage.ITERATOR: return createIterator();
			case OCLPackage.PARAMETER: return createParameter();
			case OCLPackage.COLLECTION_TYPE: return createCollectionType();
			case OCLPackage.OCL_TYPE: return createOclType();
			case OCLPackage.STRING_TYPE: return createStringType();
			case OCLPackage.BOOLEAN_TYPE: return createBooleanType();
			case OCLPackage.INTEGER_TYPE: return createIntegerType();
			case OCLPackage.REAL_TYPE: return createRealType();
			case OCLPackage.BAG_TYPE: return createBagType();
			case OCLPackage.ORDERED_SET_TYPE: return createOrderedSetType();
			case OCLPackage.SEQUENCE_TYPE: return createSequenceType();
			case OCLPackage.SET_TYPE: return createSetType();
			case OCLPackage.OCL_ANY_TYPE: return createOclAnyType();
			case OCLPackage.TUPLE_TYPE: return createTupleType();
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE: return createTupleTypeAttribute();
			case OCLPackage.OCL_MODEL_ELEMENT: return createOclModelElement();
			case OCLPackage.MAP_TYPE: return createMapType();
			case OCLPackage.OCL_FEATURE_DEFINITION: return createOclFeatureDefinition();
			case OCLPackage.OCL_CONTEXT_DEFINITION: return createOclContextDefinition();
			case OCLPackage.ATTRIBUTE: return createAttribute();
			case OCLPackage.OPERATION: return createOperation();
			case OCLPackage.OCL_MODEL: return createOclModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp createVariableExp() {
		VariableExp variableExp = new VariableExp();
		return variableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperExp createSuperExp() {
		SuperExp superExp = new SuperExp();
		return superExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExp createStringExp() {
		StringExp stringExp = new StringExp();
		return stringExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExp createBooleanExp() {
		BooleanExp booleanExp = new BooleanExp();
		return booleanExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealExp createRealExp() {
		RealExp realExp = new RealExp();
		return realExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerExp createIntegerExp() {
		IntegerExp integerExp = new IntegerExp();
		return integerExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagExp createBagExp() {
		BagExp bagExp = new BagExp();
		return bagExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetExp createOrderedSetExp() {
		OrderedSetExp orderedSetExp = new OrderedSetExp();
		return orderedSetExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExp createSequenceExp() {
		SequenceExp sequenceExp = new SequenceExp();
		return sequenceExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetExp createSetExp() {
		SetExp setExp = new SetExp();
		return setExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleExp createTupleExp() {
		TupleExp tupleExp = new TupleExp();
		return tupleExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TuplePart createTuplePart() {
		TuplePart tuplePart = new TuplePart();
		return tuplePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapExp createMapExp() {
		MapExp mapExp = new MapExp();
		return mapExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapElement createMapElement() {
		MapElement mapElement = new MapElement();
		return mapElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralExp createEnumLiteralExp() {
		EnumLiteralExp enumLiteralExp = new EnumLiteralExp();
		return enumLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclUndefinedExp createOclUndefinedExp() {
		OclUndefinedExp oclUndefinedExp = new OclUndefinedExp();
		return oclUndefinedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationOrAttributeCallExp createNavigationOrAttributeCallExp() {
		NavigationOrAttributeCallExp navigationOrAttributeCallExp = new NavigationOrAttributeCallExp();
		return navigationOrAttributeCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp createOperationCallExp() {
		OperationCallExp operationCallExp = new OperationCallExp();
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorCallExp createOperatorCallExp() {
		OperatorCallExp operatorCallExp = new OperatorCallExp();
		return operatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionOperationCallExp createCollectionOperationCallExp() {
		CollectionOperationCallExp collectionOperationCallExp = new CollectionOperationCallExp();
		return collectionOperationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExp createIterateExp() {
		IterateExp iterateExp = new IterateExp();
		return iterateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorExp createIteratorExp() {
		IteratorExp iteratorExp = new IteratorExp();
		return iteratorExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExp createLetExp() {
		LetExp letExp = new LetExp();
		return letExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExp createIfExp() {
		IfExp ifExp = new IfExp();
		return ifExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator createIterator() {
		Iterator iterator = new Iterator();
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		Parameter parameter = new Parameter();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType createCollectionType() {
		CollectionType collectionType = new CollectionType();
		return collectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType createOclType() {
		OclType oclType = new OclType();
		return oclType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringType stringType = new StringType();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanType booleanType = new BooleanType();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerType integerType = new IntegerType();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealType createRealType() {
		RealType realType = new RealType();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagType createBagType() {
		BagType bagType = new BagType();
		return bagType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetType createOrderedSetType() {
		OrderedSetType orderedSetType = new OrderedSetType();
		return orderedSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType createSequenceType() {
		SequenceType sequenceType = new SequenceType();
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetType createSetType() {
		SetType setType = new SetType();
		return setType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclAnyType createOclAnyType() {
		OclAnyType oclAnyType = new OclAnyType();
		return oclAnyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleType createTupleType() {
		TupleType tupleType = new TupleType();
		return tupleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleTypeAttribute createTupleTypeAttribute() {
		TupleTypeAttribute tupleTypeAttribute = new TupleTypeAttribute();
		return tupleTypeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModelElement createOclModelElement() {
		OclModelElement oclModelElement = new OclModelElement();
		return oclModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapType createMapType() {
		MapType mapType = new MapType();
		return mapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition createOclFeatureDefinition() {
		OclFeatureDefinition oclFeatureDefinition = new OclFeatureDefinition();
		return oclFeatureDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclContextDefinition createOclContextDefinition() {
		OclContextDefinition oclContextDefinition = new OclContextDefinition();
		return oclContextDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		Attribute attribute = new Attribute();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		Operation operation = new Operation();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel createOclModel() {
		OclModel oclModel = new OclModel();
		return oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLPackage getOCLPackage() {
		return (OCLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLPackage getPackage() {
		return OCLPackage.eINSTANCE;
	}

} //OCLFactory
