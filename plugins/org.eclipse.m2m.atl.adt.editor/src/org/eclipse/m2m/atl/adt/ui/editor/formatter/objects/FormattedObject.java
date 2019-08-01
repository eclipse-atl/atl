/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor.formatter.objects;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;

/**
 * A formatted object.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class FormattedObject {

	public static final int TYPE_UNKNOWN = -1;

	public static final int TYPE_MODULE = 0;

	public static final int TYPE_OCL_MODEL = 1;

	public static final int TYPE_HELPER = 2;

	public static final int TYPE_MATCHED_RULE = 3;

	public static final int TYPE_OPERATOR_CALL_EXP = 4;

	public static final int TYPE_PARAMETER = 5;

	public static final int TYPE_BINDING = 6;

	public static final int TYPE_IN_PATTERN = 7;

	public static final int TYPE_OUT_PATTERN = 8;

	public static final int TYPE_COLLECTION_TYPE = 9;

	public static final int TYPE_OPERATION = 10;

	public static final int TYPE_ATTRIBUTE = 11;

	public static final int TYPE_TUPLE_EXP = 12;

	public static final int TYPE_COLLECTION_EXP = 13;

	public static final int TYPE_COLLECTION_OPERATION_CALL_EXP = 14;

	public static final int TYPE_NAVIGATION_OR_ATTRIBUTE_CALL_EXP = 15;

	public static final int TYPE_STRING_EXP = 16;

	public static final int TYPE_LIBRARY = 17;

	public static final int TYPE_QUERY = 18;

	public static final int TYPE_LAZY_MATCHED_RULE = 19;

	public static final int TYPE_ABSTRACT_MATCHED_RULE = 20;

	public static final int TYPE_ITERATOR_EXP = 21;

	public static final int TYPE_ITERATE_EXP = 22;

	public static final int TYPE_CALLED_RULE = 23;

	public static final int TYPE_RULE_VARIABLE_DECLARATION = 24;

	public static final int TYPE_OPERATION_CALL_EXP = 25;

	public static final int TYPE_IF_EXP = 26;

	public static final int TYPE_FOR_EXP = 27;

	public static final int TYPE_ACTION_BLOCK = 28;

	public static final int TYPE_OCL_MODEL_ELEMENT = 29;

	public static final int TYPE_SIMPLE_IN_PATTERN = 30;

	public static final int TYPE_LONE_OBJECT = 31;

	public static final int TYPE_LET_EXP = 32;

	public static final int TYPE_SIMPLE_OUT_PATTERN_ELEMENT = 33;

	public static final int TYPE_FOR_EACH_OUT_PATTERN_ELEMENT = 34;

	public static final int TYPE_OCL_UNDEFINED = 35;

	public static final int LINE_TYPE_NORMAL = 0;

	public static final int LINE_TYPE_HELPER_COMMENT = 1;

	public static final int LINE_TYPE_COMMENT = 2;

	public static final int LINE_TYPE_STRING = 3;

	public static final String REPLACEMENT = "OBJECT"; //$NON-NLS-1$

	public static final String RPLCMT_RGX = "(?:\\(\\s*)?" + REPLACEMENT + "\\{\\d+\\}(?:\\s*\\))?"; //$NON-NLS-1$ //$NON-NLS-2$

	public static final String RPLCMT_RGX_GRPNM = "(?:\\(\\s*)?" + REPLACEMENT + "\\{(\\d+)\\}(?:\\s*\\))?"; //$NON-NLS-1$ //$NON-NLS-2$

	private static int count = 0;

	protected String text;

	protected EObject eObject;

	protected int indentationLevel;

	protected int type;

	protected int number;

	protected List<FormattedObject> children;

	public FormattedObject(EObject eObject, String text) throws BadLocationException {
		this.eObject = eObject;
		this.text = text;
		indentationLevel = 0;
		type = typeOf(eObject);
		number = count++;
		children = new ArrayList<FormattedObject>();
	}

	public FormattedObject(EObject eObject, String text, int indentationLevel) throws BadLocationException {
		this(eObject, text);
		this.indentationLevel = indentationLevel;
	}

	public FormattedObject getChild(int i) throws BadLocationException {
		EObject child = eObject.eContents().get(i);
		return new FormattedObject(child, ""); //$NON-NLS-1$
	}

	public void addChildren(FormattedObject... fo) {
		for (FormattedObject child : fo) {
			children.add(child);
		}
	}

	/**
	 * Gives the type of the given EObject.
	 * 
	 * @param obj
	 *            the object we want to know the type.
	 * @return an integer value of the type of the element.
	 * @throws BadLocationException
	 */
	public static int typeOf(EObject obj) throws BadLocationException {
		if (oclIsTypeOf(obj, "Module")) //$NON-NLS-1$
			return TYPE_MODULE;
		else if (oclIsTypeOf(obj, "OclModel")) //$NON-NLS-1$
			return TYPE_OCL_MODEL;
		else if (oclIsTypeOf(obj, "Helper")) //$NON-NLS-1$
			return TYPE_HELPER;
		else if (oclIsTypeOf(obj, "MatchedRule")) //$NON-NLS-1$
			return TYPE_MATCHED_RULE;
		else if (oclIsTypeOf(obj, "LazyMatchedRule")) //$NON-NLS-1$
			return TYPE_LAZY_MATCHED_RULE;
		else if (oclIsTypeOf(obj, "AbstractMatchedRule")) //$NON-NLS-1$
			return TYPE_ABSTRACT_MATCHED_RULE;
		else if (oclIsTypeOf(obj, "CalledRule")) //$NON-NLS-1$
			return TYPE_CALLED_RULE;
		else if (oclIsTypeOf(obj, "OperatorCallExp")) //$NON-NLS-1$
			return TYPE_OPERATOR_CALL_EXP;
		else if (oclIsTypeOf(obj, "Parameter") || //$NON-NLS-1$
				oclIsTypeOf(obj, "TupleTypeAttribute")) //$NON-NLS-1$
			return TYPE_PARAMETER;
		else if (oclIsTypeOf(obj, "Binding")) //$NON-NLS-1$
			return TYPE_BINDING;
		else if (oclIsTypeOf(obj, "InPattern")) //$NON-NLS-1$
			return TYPE_IN_PATTERN;
		else if (oclIsTypeOf(obj, "OutPattern")) //$NON-NLS-1$
			return TYPE_OUT_PATTERN;
		else if (oclIsTypeOf(obj, "SequenceType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "TupleType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "SetType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "BagType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "OrderedSetType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "MapType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "CollectionType")) //$NON-NLS-1$
			return TYPE_COLLECTION_TYPE;
		else if (oclIsTypeOf(obj, "Operation")) //$NON-NLS-1$
			return TYPE_OPERATION;
		else if (oclIsTypeOf(obj, "Attribute")) //$NON-NLS-1$
			return TYPE_ATTRIBUTE;
		else if (oclIsTypeOf(obj, "TupleExp")) //$NON-NLS-1$
			return TYPE_TUPLE_EXP;
		else if (oclIsTypeOf(obj, "SequenceExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "TupleExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "SetExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "BagExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "OrderedSetExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "MapExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "CollectionExp")) //$NON-NLS-1$
			return TYPE_COLLECTION_EXP;
		else if (oclIsTypeOf(obj, "CollectionOperationCallExp")) //$NON-NLS-1$
			return TYPE_COLLECTION_OPERATION_CALL_EXP;
		else if (oclIsTypeOf(obj, "OperationCallExp")) //$NON-NLS-1$
			return TYPE_OPERATION_CALL_EXP;
		else if (oclIsTypeOf(obj, "NavigationOrAttributeCallExp")) //$NON-NLS-1$
			return TYPE_NAVIGATION_OR_ATTRIBUTE_CALL_EXP;
		else if (oclIsTypeOf(obj, "StringExp")) //$NON-NLS-1$
			return TYPE_STRING_EXP;
		else if (oclIsTypeOf(obj, "Library")) //$NON-NLS-1$
			return TYPE_LIBRARY;
		else if (oclIsTypeOf(obj, "Query")) //$NON-NLS-1$
			return TYPE_QUERY;
		else if (oclIsTypeOf(obj, "IteratorExp")) //$NON-NLS-1$
			return TYPE_ITERATOR_EXP;
		else if (oclIsTypeOf(obj, "IterateExp")) //$NON-NLS-1$
			return TYPE_ITERATE_EXP;
		else if (oclIsTypeOf(obj, "RuleVariableDeclaration")) //$NON-NLS-1$
			return TYPE_RULE_VARIABLE_DECLARATION;
		else if (oclIsTypeOf(obj, "IfExp")) //$NON-NLS-1$
			return TYPE_IF_EXP;
		else if (oclIsTypeOf(obj, "ForStat")) //$NON-NLS-1$
			return TYPE_FOR_EXP;
		else if (oclIsTypeOf(obj, "ActionBlock")) //$NON-NLS-1$
			return TYPE_ACTION_BLOCK;
		else if (oclIsTypeOf(obj, "OclModelElement")) //$NON-NLS-1$
			return TYPE_OCL_MODEL_ELEMENT;
		else if (oclIsTypeOf(obj, "SimpleInPatternElement")) //$NON-NLS-1$
			return TYPE_SIMPLE_IN_PATTERN;
		else if (oclIsTypeOf(obj, "BooleanExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "VariableExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "IntegerExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "RealExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "SetExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "BagExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "MapExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "OrderedSetExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "CollectionExp") || //$NON-NLS-1$
				oclIsTypeOf(obj, "StringType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "IntegerType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "RealType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "BooleanType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "OclAnyType") || //$NON-NLS-1$
				oclIsTypeOf(obj, "Iterator")) //$NON-NLS-1$
			return TYPE_LONE_OBJECT; // None formatted objects, but wrapped anyway
		else if (oclIsTypeOf(obj, "LetExp")) //$NON-NLS-1$
			return TYPE_LET_EXP;
		else if (oclIsTypeOf(obj, "SimpleOutPatternElement")) //$NON-NLS-1$
			return TYPE_SIMPLE_OUT_PATTERN_ELEMENT;
		else if (oclIsTypeOf(obj, "ForEachOutPatternElement")) //$NON-NLS-1$
			return TYPE_FOR_EACH_OUT_PATTERN_ELEMENT;
		else if (oclIsTypeOf(obj, "OclUndefinedExp")) //$NON-NLS-1$
			return TYPE_OCL_UNDEFINED;
		return TYPE_UNKNOWN;
	}

	private static boolean oclIsTypeOf(EObject obj, String type) {
		return obj.eClass().getName().equals(type);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public EObject getEObject() {
		return eObject;
	}

	public void setEObject(EObject eObject) {
		this.eObject = eObject;
	}

	public int getIndentationLevel() {
		return indentationLevel;
	}

	public void setIndentationLevel(int indentationLevel) {
		this.indentationLevel = indentationLevel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<FormattedObject> getChildren() {
		return children;
	}

	public int getNumber() {
		return number;
	}

	public String getReplacement() {
		return REPLACEMENT + "{" + number + "}"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static void resetCounter() {
		count = 0;
	}

	public String toString() {
		return text;
	}

}
