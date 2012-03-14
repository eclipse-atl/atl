/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

/**
 * The Operation wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class Operation extends Feature {

	/** Full qualified path to the properties file in which to seek the keys. */
	private static final String BUNDLE_NAME = "org.eclipse.m2m.atl.adt.ui.text.atl.types.description"; //$NON-NLS-1$

	/** Contains the locale specific {@link String}s needed by this plug-in. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Map<String, OclAnyType> parameters;

	/**
	 * Creates a new Operation.
	 * 
	 * @param name
	 *            the operation name
	 * @param contextType
	 *            type the operation context type
	 * @param type
	 *            the operation type
	 * @param parameters
	 *            the operation parameter types map
	 */
	public Operation(String name, OclAnyType contextType, OclAnyType type, Map<String, OclAnyType> parameters) {
		super(null, null, name, contextType, type, false, false, 1, 1);
		this.parameters = parameters;
		setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
	}

	/**
	 * Creates a new Operation without parameters.
	 * 
	 * @param name
	 *            the operation name
	 * @param contextType
	 *            the operation context type
	 * @param type
	 *            the operation type
	 */
	public Operation(String name, OclAnyType contextType, OclAnyType type) {
		super(null, null, name, contextType, type, false, false, 1, 1);
		this.parameters = Collections.emptyMap();
		setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
	}

	/**
	 * Creates a new Operation.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param declaration
	 *            the element declaration
	 * @param name
	 *            the operation name
	 * @param contextType
	 *            type the operation context type
	 * @param type
	 *            the operation type
	 * @param parameters
	 *            the operation parameter types map
	 */
	public Operation(UnitType unit, EObject declaration, String name, OclAnyType contextType,
			OclAnyType type, Map<String, OclAnyType> parameters) {
		super(unit, declaration, name, contextType, type, false, false, 1, 1);
		this.parameters = parameters;
		setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
	}

	/**
	 * Creates a new Operation without parameters.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param declaration
	 *            the element declaration
	 * @param name
	 *            the operation name
	 * @param contextType
	 *            the operation context type
	 * @param type
	 *            the operation type
	 */
	public Operation(UnitType unit, EObject declaration, String name, OclAnyType contextType, OclAnyType type) {
		super(unit, declaration, name, contextType, type, false, false, 1, 1);
		this.parameters = Collections.emptyMap();
		setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
	}

	/**
	 * Creates an Operation from an {@link EOperation}.
	 * 
	 * @param operation
	 *            the {@link EOperation}
	 * @param metamodelName
	 *            the metamodel name
	 */
	public Operation(EOperation operation, String metamodelName) {
		super(null, operation, operation.getName(), ModelElementType.create(operation.getEContainingClass(),
				metamodelName), ModelElementType.create(operation.getEType(), metamodelName), operation
				.isOrdered(), false, operation.getLowerBound(), operation.getUpperBound());
		this.parameters = new LinkedHashMap<String, OclAnyType>();
		for (EParameter eParameter : operation.getEParameters()) {
			this.parameters.put(eParameter.getName().toLowerCase(), ModelElementType.create(eParameter
					.getEType(), metamodelName));
		}
		setImagePath("$nl$/icons/EOperation.gif"); //$NON-NLS-1$
	}

	public Map<String, OclAnyType> getParameters() {
		return parameters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Operation) {
			return toString().equals(((Operation)obj).toString());
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.Feature#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer signature = new StringBuffer();
		signature.append(getName());
		signature.append('(');
		for (Iterator<Entry<String, OclAnyType>> iterator = parameters.entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, OclAnyType> parameter = iterator.next();
			signature.append(parameter.getKey());
			signature.append(" : "); //$NON-NLS-1$
			signature.append(parameter.getValue());
			if (iterator.hasNext()) {
				signature.append(", "); //$NON-NLS-1$
			}
		}
		signature.append(')');
		return signature.toString();
	}

	/**
	 * Returns the operation type. Operations may subclass this method for dynamic type computation.
	 * 
	 * @param context
	 *            the context type
	 * @param parameters
	 *            the operation parameter types
	 * @return the operation type
	 */
	public OclAnyType getType(OclAnyType context, Object... parameters) {
		if (getType() != null) {
			return getType();
		} else {
			// default behavior
			return context;
		}
	}

	/**
	 * Returns the information related to the operation, or null if not found.
	 * 
	 * @param context
	 *            the context type
	 * @param parameters
	 *            the operation parameter types
	 * @return the information or null if not found
	 */
	public String getDocumentation(OclAnyType context, Object... parameters) {
		if (documentation == null) {
			String key = ""; //$NON-NLS-1$
			if (context instanceof CollectionType) {
				key = ((CollectionType)context).getCollectionType() + '.';
			} else if (context instanceof MapType) {
				key = "Map."; //$NON-NLS-1$
			} else if (context instanceof TupleType) {
				key = "Tuple."; //$NON-NLS-1$
			} else if (context != null) {
				key = context.toString() + '.';
			}
			key += name;
			documentation = getMessage(key);
		}
		if (documentation != null && !documentation.trim().equals("")) { //$NON-NLS-1$
			return documentation;
		} else {
			for (OclAnyType supertype : context.getSupertypes()) {
				documentation = getDocumentation(supertype, parameters);
				if (documentation != null) {
					return documentation;
				}
			}
		}
		return null;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	/**
	 * Returns a description of the operation for the given context.
	 * 
	 * @param context
	 *            the current context
	 * @return a description of the operation for the given context
	 */
	public String getInformation(OclAnyType context) {
		StringBuffer information = new StringBuffer();
		information.append(getName());
		information.append('(');
		for (Iterator<Entry<String, OclAnyType>> iterator = getParameters().entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, OclAnyType> parameter = iterator.next();
			information.append(parameter.getKey() + " : " + parameter.getValue()); //$NON-NLS-1$
			if (iterator.hasNext()) {
				information.append(", "); //$NON-NLS-1$
			}
		}
		information.append(')');
		if (getType(context) != null) {
			information.append(" : " + getType(context)); //$NON-NLS-1$
		}
		return information.toString();
	}

	private static String getMessage(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static Operation createFromRule(UnitType unit, EObject rule, OclAnyType context) {
		String ruleName = (String)AtlTypesProcessor.eGet(rule, "name"); //$NON-NLS-1$
		Object condition = AtlTypesProcessor.eGet(rule, "isAbstract"); //$NON-NLS-1$
		boolean isAbstract = false;
		if (condition != null) {
			isAbstract = Boolean.valueOf(condition.toString()).booleanValue();	
		}
		if (!isAbstract && ruleName != null) {
			Map<String, OclAnyType> parameters = new HashMap<String, OclAnyType>();
			EList<EObject> parameterObjects = (EList<EObject>)AtlTypesProcessor.eGet(rule, "parameters"); //$NON-NLS-1$
			if (parameterObjects != null) {
				for (EObject eObject : parameterObjects) {
					String parameterName = (String)AtlTypesProcessor.eGet(eObject, "varName"); //$NON-NLS-1$
					EObject parameterTypeObject = (EObject)AtlTypesProcessor.eGet(eObject, "type"); //$NON-NLS-1$
					OclAnyType parameterType = OclAnyType
							.create(unit.getSourceManager(), parameterTypeObject);
					parameters.put(parameterName, parameterType);
				}
			}
			Operation operation = new Operation(unit, rule, ruleName, context, OclAnyType.getInstance(),
					parameters);
			operation.setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
			String doc = getDocumentation(rule);
			if (doc != null && doc.length() > 0) {
				operation.setDocumentation(doc);
			}
			return operation;
		}
		return null;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model called rule.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param rule
	 *            the rule model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	public static Operation createFromCalledRule(UnitType unit, EObject rule, OclAnyType context) {
		Operation operation = createFromRule(unit, rule, context);
		if (operation != null) {
			operation.setImagePath("$nl$/icons/matchedRule.gif"); //$NON-NLS-1$
		}
		return operation;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model lazy rule.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param rule
	 *            the rule model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	public static Operation createFromLazyRule(UnitType unit, EObject rule, OclAnyType context) {
		Operation operation = createFromRule(unit, rule, context);
		if (operation != null) {
			operation.setImagePath("$nl$/icons/lazyRule.gif"); //$NON-NLS-1$
		}
		return operation;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model helper.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param helper
	 *            the helper model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	@SuppressWarnings("unchecked")
	public static Operation createFromHelper(UnitType unit, EObject helper, OclAnyType context) {
		String helperName = (String)AtlTypesProcessor.eGet(helper, "name"); //$NON-NLS-1$
		if (helperName != null) {
			Map<String, OclAnyType> parameters = new LinkedHashMap<String, OclAnyType>();
			EList<EObject> parameterObjects = (EList<EObject>)AtlTypesProcessor.eGet(helper, "parameters"); //$NON-NLS-1$
			if (parameterObjects != null) {
				for (EObject eObject : parameterObjects) {
					String parameterName = (String)AtlTypesProcessor.eGet(eObject, "varName"); //$NON-NLS-1$
					EObject parameterTypeObject = (EObject)AtlTypesProcessor.eGet(eObject, "type"); //$NON-NLS-1$
					OclAnyType parameterType = OclAnyType
							.create(unit.getSourceManager(), parameterTypeObject);
					parameters.put(parameterName, parameterType);
				}
			}
			EObject helperType = (EObject)AtlTypesProcessor.eGet(helper, "returnType"); //$NON-NLS-1$
			OclAnyType type = OclAnyType.create(unit.getSourceManager(), helperType);
			Operation operation = new Operation(unit, helper, helperName, context, type, parameters);
			operation.setImagePath("$nl$/icons/helper.gif"); //$NON-NLS-1$

			EObject container = helper.eContainer();
			if (container != null) {
				container = container.eContainer();
				if (container != null) {
					String doc = getDocumentation(container);
					if (doc != null && doc.length() > 0) {
						operation.setDocumentation(doc);
					}
				}
			}
			return operation;
		}
		return null;
	}

}
