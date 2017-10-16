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
package org.eclipse.m2m.atl.common.OCL.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

import org.eclipse.m2m.atl.common.OCL.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage
 * @generated
 */
public class OCLSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLSwitch() {
		if (modelPackage == null) {
			modelPackage = OCLPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OCLPackage.OCL_EXPRESSION: {
				OclExpression oclExpression = (OclExpression)theEObject;
				T result = caseOclExpression(oclExpression);
				if (result == null) result = caseLocatedElement(oclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null) result = caseOclExpression(variableExp);
				if (result == null) result = caseLocatedElement(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.SUPER_EXP: {
				SuperExp superExp = (SuperExp)theEObject;
				T result = caseSuperExp(superExp);
				if (result == null) result = caseOclExpression(superExp);
				if (result == null) result = caseLocatedElement(superExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.PRIMITIVE_EXP: {
				PrimitiveExp primitiveExp = (PrimitiveExp)theEObject;
				T result = casePrimitiveExp(primitiveExp);
				if (result == null) result = caseOclExpression(primitiveExp);
				if (result == null) result = caseLocatedElement(primitiveExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.STRING_EXP: {
				StringExp stringExp = (StringExp)theEObject;
				T result = caseStringExp(stringExp);
				if (result == null) result = casePrimitiveExp(stringExp);
				if (result == null) result = caseOclExpression(stringExp);
				if (result == null) result = caseLocatedElement(stringExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.BOOLEAN_EXP: {
				BooleanExp booleanExp = (BooleanExp)theEObject;
				T result = caseBooleanExp(booleanExp);
				if (result == null) result = casePrimitiveExp(booleanExp);
				if (result == null) result = caseOclExpression(booleanExp);
				if (result == null) result = caseLocatedElement(booleanExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.NUMERIC_EXP: {
				NumericExp numericExp = (NumericExp)theEObject;
				T result = caseNumericExp(numericExp);
				if (result == null) result = casePrimitiveExp(numericExp);
				if (result == null) result = caseOclExpression(numericExp);
				if (result == null) result = caseLocatedElement(numericExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.REAL_EXP: {
				RealExp realExp = (RealExp)theEObject;
				T result = caseRealExp(realExp);
				if (result == null) result = caseNumericExp(realExp);
				if (result == null) result = casePrimitiveExp(realExp);
				if (result == null) result = caseOclExpression(realExp);
				if (result == null) result = caseLocatedElement(realExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.INTEGER_EXP: {
				IntegerExp integerExp = (IntegerExp)theEObject;
				T result = caseIntegerExp(integerExp);
				if (result == null) result = caseNumericExp(integerExp);
				if (result == null) result = casePrimitiveExp(integerExp);
				if (result == null) result = caseOclExpression(integerExp);
				if (result == null) result = caseLocatedElement(integerExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.COLLECTION_EXP: {
				CollectionExp collectionExp = (CollectionExp)theEObject;
				T result = caseCollectionExp(collectionExp);
				if (result == null) result = caseOclExpression(collectionExp);
				if (result == null) result = caseLocatedElement(collectionExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.BAG_EXP: {
				BagExp bagExp = (BagExp)theEObject;
				T result = caseBagExp(bagExp);
				if (result == null) result = caseCollectionExp(bagExp);
				if (result == null) result = caseOclExpression(bagExp);
				if (result == null) result = caseLocatedElement(bagExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ORDERED_SET_EXP: {
				OrderedSetExp orderedSetExp = (OrderedSetExp)theEObject;
				T result = caseOrderedSetExp(orderedSetExp);
				if (result == null) result = caseCollectionExp(orderedSetExp);
				if (result == null) result = caseOclExpression(orderedSetExp);
				if (result == null) result = caseLocatedElement(orderedSetExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.SEQUENCE_EXP: {
				SequenceExp sequenceExp = (SequenceExp)theEObject;
				T result = caseSequenceExp(sequenceExp);
				if (result == null) result = caseCollectionExp(sequenceExp);
				if (result == null) result = caseOclExpression(sequenceExp);
				if (result == null) result = caseLocatedElement(sequenceExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.SET_EXP: {
				SetExp setExp = (SetExp)theEObject;
				T result = caseSetExp(setExp);
				if (result == null) result = caseCollectionExp(setExp);
				if (result == null) result = caseOclExpression(setExp);
				if (result == null) result = caseLocatedElement(setExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.TUPLE_EXP: {
				TupleExp tupleExp = (TupleExp)theEObject;
				T result = caseTupleExp(tupleExp);
				if (result == null) result = caseOclExpression(tupleExp);
				if (result == null) result = caseLocatedElement(tupleExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.TUPLE_PART: {
				TuplePart tuplePart = (TuplePart)theEObject;
				T result = caseTuplePart(tuplePart);
				if (result == null) result = caseVariableDeclaration(tuplePart);
				if (result == null) result = caseLocatedElement(tuplePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.MAP_EXP: {
				MapExp mapExp = (MapExp)theEObject;
				T result = caseMapExp(mapExp);
				if (result == null) result = caseOclExpression(mapExp);
				if (result == null) result = caseLocatedElement(mapExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.MAP_ELEMENT: {
				MapElement mapElement = (MapElement)theEObject;
				T result = caseMapElement(mapElement);
				if (result == null) result = caseLocatedElement(mapElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ENUM_LITERAL_EXP: {
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp)theEObject;
				T result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null) result = caseOclExpression(enumLiteralExp);
				if (result == null) result = caseLocatedElement(enumLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_UNDEFINED_EXP: {
				OclUndefinedExp oclUndefinedExp = (OclUndefinedExp)theEObject;
				T result = caseOclUndefinedExp(oclUndefinedExp);
				if (result == null) result = caseOclExpression(oclUndefinedExp);
				if (result == null) result = caseLocatedElement(oclUndefinedExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.PROPERTY_CALL_EXP: {
				PropertyCallExp propertyCallExp = (PropertyCallExp)theEObject;
				T result = casePropertyCallExp(propertyCallExp);
				if (result == null) result = caseOclExpression(propertyCallExp);
				if (result == null) result = caseLocatedElement(propertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP: {
				NavigationOrAttributeCallExp navigationOrAttributeCallExp = (NavigationOrAttributeCallExp)theEObject;
				T result = caseNavigationOrAttributeCallExp(navigationOrAttributeCallExp);
				if (result == null) result = casePropertyCallExp(navigationOrAttributeCallExp);
				if (result == null) result = caseOclExpression(navigationOrAttributeCallExp);
				if (result == null) result = caseLocatedElement(navigationOrAttributeCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null) result = casePropertyCallExp(operationCallExp);
				if (result == null) result = caseOclExpression(operationCallExp);
				if (result == null) result = caseLocatedElement(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OPERATOR_CALL_EXP: {
				OperatorCallExp operatorCallExp = (OperatorCallExp)theEObject;
				T result = caseOperatorCallExp(operatorCallExp);
				if (result == null) result = caseOperationCallExp(operatorCallExp);
				if (result == null) result = casePropertyCallExp(operatorCallExp);
				if (result == null) result = caseOclExpression(operatorCallExp);
				if (result == null) result = caseLocatedElement(operatorCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.COLLECTION_OPERATION_CALL_EXP: {
				CollectionOperationCallExp collectionOperationCallExp = (CollectionOperationCallExp)theEObject;
				T result = caseCollectionOperationCallExp(collectionOperationCallExp);
				if (result == null) result = caseOperationCallExp(collectionOperationCallExp);
				if (result == null) result = casePropertyCallExp(collectionOperationCallExp);
				if (result == null) result = caseOclExpression(collectionOperationCallExp);
				if (result == null) result = caseLocatedElement(collectionOperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.LOOP_EXP: {
				LoopExp loopExp = (LoopExp)theEObject;
				T result = caseLoopExp(loopExp);
				if (result == null) result = casePropertyCallExp(loopExp);
				if (result == null) result = caseOclExpression(loopExp);
				if (result == null) result = caseLocatedElement(loopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ITERATE_EXP: {
				IterateExp iterateExp = (IterateExp)theEObject;
				T result = caseIterateExp(iterateExp);
				if (result == null) result = caseLoopExp(iterateExp);
				if (result == null) result = casePropertyCallExp(iterateExp);
				if (result == null) result = caseOclExpression(iterateExp);
				if (result == null) result = caseLocatedElement(iterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ITERATOR_EXP: {
				IteratorExp iteratorExp = (IteratorExp)theEObject;
				T result = caseIteratorExp(iteratorExp);
				if (result == null) result = caseLoopExp(iteratorExp);
				if (result == null) result = casePropertyCallExp(iteratorExp);
				if (result == null) result = caseOclExpression(iteratorExp);
				if (result == null) result = caseLocatedElement(iteratorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.LET_EXP: {
				LetExp letExp = (LetExp)theEObject;
				T result = caseLetExp(letExp);
				if (result == null) result = caseOclExpression(letExp);
				if (result == null) result = caseLocatedElement(letExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.IF_EXP: {
				IfExp ifExp = (IfExp)theEObject;
				T result = caseIfExp(ifExp);
				if (result == null) result = caseOclExpression(ifExp);
				if (result == null) result = caseLocatedElement(ifExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseLocatedElement(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ITERATOR: {
				Iterator iterator = (Iterator)theEObject;
				T result = caseIterator(iterator);
				if (result == null) result = caseVariableDeclaration(iterator);
				if (result == null) result = caseLocatedElement(iterator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseVariableDeclaration(parameter);
				if (result == null) result = caseLocatedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseOclType(collectionType);
				if (result == null) result = caseOclExpression(collectionType);
				if (result == null) result = caseLocatedElement(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_TYPE: {
				OclType oclType = (OclType)theEObject;
				T result = caseOclType(oclType);
				if (result == null) result = caseOclExpression(oclType);
				if (result == null) result = caseLocatedElement(oclType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.PRIMITIVE: {
				Primitive primitive = (Primitive)theEObject;
				T result = casePrimitive(primitive);
				if (result == null) result = caseOclType(primitive);
				if (result == null) result = caseOclExpression(primitive);
				if (result == null) result = caseLocatedElement(primitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = casePrimitive(stringType);
				if (result == null) result = caseOclType(stringType);
				if (result == null) result = caseOclExpression(stringType);
				if (result == null) result = caseLocatedElement(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = casePrimitive(booleanType);
				if (result == null) result = caseOclType(booleanType);
				if (result == null) result = caseOclExpression(booleanType);
				if (result == null) result = caseLocatedElement(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.NUMERIC_TYPE: {
				NumericType numericType = (NumericType)theEObject;
				T result = caseNumericType(numericType);
				if (result == null) result = casePrimitive(numericType);
				if (result == null) result = caseOclType(numericType);
				if (result == null) result = caseOclExpression(numericType);
				if (result == null) result = caseLocatedElement(numericType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = caseNumericType(integerType);
				if (result == null) result = casePrimitive(integerType);
				if (result == null) result = caseOclType(integerType);
				if (result == null) result = caseOclExpression(integerType);
				if (result == null) result = caseLocatedElement(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.REAL_TYPE: {
				RealType realType = (RealType)theEObject;
				T result = caseRealType(realType);
				if (result == null) result = caseNumericType(realType);
				if (result == null) result = casePrimitive(realType);
				if (result == null) result = caseOclType(realType);
				if (result == null) result = caseOclExpression(realType);
				if (result == null) result = caseLocatedElement(realType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.BAG_TYPE: {
				BagType bagType = (BagType)theEObject;
				T result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseOclType(bagType);
				if (result == null) result = caseOclExpression(bagType);
				if (result == null) result = caseLocatedElement(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				T result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseOclType(orderedSetType);
				if (result == null) result = caseOclExpression(orderedSetType);
				if (result == null) result = caseLocatedElement(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseOclType(sequenceType);
				if (result == null) result = caseOclExpression(sequenceType);
				if (result == null) result = caseLocatedElement(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				T result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseOclType(setType);
				if (result == null) result = caseOclExpression(setType);
				if (result == null) result = caseLocatedElement(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_ANY_TYPE: {
				OclAnyType oclAnyType = (OclAnyType)theEObject;
				T result = caseOclAnyType(oclAnyType);
				if (result == null) result = caseOclType(oclAnyType);
				if (result == null) result = caseOclExpression(oclAnyType);
				if (result == null) result = caseLocatedElement(oclAnyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.TUPLE_TYPE: {
				TupleType tupleType = (TupleType)theEObject;
				T result = caseTupleType(tupleType);
				if (result == null) result = caseOclType(tupleType);
				if (result == null) result = caseOclExpression(tupleType);
				if (result == null) result = caseLocatedElement(tupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE: {
				TupleTypeAttribute tupleTypeAttribute = (TupleTypeAttribute)theEObject;
				T result = caseTupleTypeAttribute(tupleTypeAttribute);
				if (result == null) result = caseLocatedElement(tupleTypeAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_MODEL_ELEMENT: {
				OclModelElement oclModelElement = (OclModelElement)theEObject;
				T result = caseOclModelElement(oclModelElement);
				if (result == null) result = caseOclType(oclModelElement);
				if (result == null) result = caseOclExpression(oclModelElement);
				if (result == null) result = caseLocatedElement(oclModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.MAP_TYPE: {
				MapType mapType = (MapType)theEObject;
				T result = caseMapType(mapType);
				if (result == null) result = caseOclType(mapType);
				if (result == null) result = caseOclExpression(mapType);
				if (result == null) result = caseLocatedElement(mapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_FEATURE_DEFINITION: {
				OclFeatureDefinition oclFeatureDefinition = (OclFeatureDefinition)theEObject;
				T result = caseOclFeatureDefinition(oclFeatureDefinition);
				if (result == null) result = caseLocatedElement(oclFeatureDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_CONTEXT_DEFINITION: {
				OclContextDefinition oclContextDefinition = (OclContextDefinition)theEObject;
				T result = caseOclContextDefinition(oclContextDefinition);
				if (result == null) result = caseLocatedElement(oclContextDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_FEATURE: {
				OclFeature oclFeature = (OclFeature)theEObject;
				T result = caseOclFeature(oclFeature);
				if (result == null) result = caseLocatedElement(oclFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseOclFeature(attribute);
				if (result == null) result = caseLocatedElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseOclFeature(operation);
				if (result == null) result = caseLocatedElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLPackage.OCL_MODEL: {
				OclModel oclModel = (OclModel)theEObject;
				T result = caseOclModel(oclModel);
				if (result == null) result = caseLocatedElement(oclModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperExp(SuperExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveExp(PrimitiveExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringExp(StringExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExp(BooleanExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericExp(NumericExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealExp(RealExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerExp(IntegerExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionExp(CollectionExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagExp(BagExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetExp(OrderedSetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceExp(SequenceExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetExp(SetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleExp(TupleExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTuplePart(TuplePart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapExp(MapExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapElement(MapElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralExp(EnumLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Undefined Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Undefined Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclUndefinedExp(OclUndefinedExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Or Attribute Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Or Attribute Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationOrAttributeCallExp(NavigationOrAttributeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorCallExp(OperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionOperationCallExp(CollectionOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateExp(IterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorExp(IteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExp(IfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterator(Iterator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclType(OclType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitive(Primitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericType(NumericType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealType(RealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclAnyType(OclAnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleTypeAttribute(TupleTypeAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclModelElement(OclModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapType(MapType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Feature Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Feature Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclFeatureDefinition(OclFeatureDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Context Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Context Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclContextDefinition(OclContextDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclFeature(OclFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclModel(OclModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocatedElement(LocatedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //OCLSwitch
