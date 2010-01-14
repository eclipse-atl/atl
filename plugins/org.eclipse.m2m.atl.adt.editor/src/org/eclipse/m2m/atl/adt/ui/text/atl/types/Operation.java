/*******************************************************************************
 * Copyright (c) 2009 Obeo.
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
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The Operation wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
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
		super(null, name, contextType, type, false, false, 1, 1);
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
		super(null, name, contextType, type, false, false, 1, 1);
		this.parameters = Collections.emptyMap();
		setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
	}

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
	public Operation(EObject declaration, String name, OclAnyType contextType, OclAnyType type,
			Map<String, OclAnyType> parameters) {
		super(declaration, name, contextType, type, false, false, 1, 1);
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
	public Operation(EObject declaration, String name, OclAnyType contextType, OclAnyType type) {
		super(declaration, name, contextType, type, false, false, 1, 1);
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
		super(operation, operation.getName(), ModelElementType.create(operation.getEContainingClass(),
				metamodelName), ModelElementType.create(operation.getEType(), metamodelName), operation
				.isOrdered(), false, operation.getLowerBound(), operation.getUpperBound());
		this.parameters = new HashMap<String, OclAnyType>();
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
		String key = ""; //$NON-NLS-1$
		if (context instanceof CollectionType) {
			key = ((CollectionType)context).getCollectionType() + '.';
		} else if (context != null) {
			key = context.toString() + '.';
		}
		key += name;
		String info = getMessage(key);
		if (info != null && !info.trim().equals("")) { //$NON-NLS-1$
			return info;
		}
		return null;
	}

	/**
	 * Returns a description of the operation for the given context.
	 * 
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
	private static Operation createFromRule(AtlSourceManager manager, EObject rule, OclAnyType context) {
		String ruleName = (String)AtlTypesProcessor.eGet(rule, "name"); //$NON-NLS-1$
		if (ruleName != null) {
			Map<String, OclAnyType> parameters = new HashMap<String, OclAnyType>();
			EList<EObject> parameterObjects = (EList<EObject>)AtlTypesProcessor.eGet(rule, "parameters"); //$NON-NLS-1$
			if (parameterObjects != null) {
				for (EObject eObject : parameterObjects) {
					String parameterName = (String)AtlTypesProcessor.eGet(eObject, "varName"); //$NON-NLS-1$
					EObject parameterTypeObject = (EObject)AtlTypesProcessor.eGet(eObject, "type"); //$NON-NLS-1$
					OclAnyType parameterType = OclAnyType.create(manager, parameterTypeObject);
					parameters.put(parameterName, parameterType);
				}
			}
			Operation operation = new Operation(rule, ruleName, context, OclAnyType.getInstance(), parameters);
			operation.setImagePath("$nl$/icons/operation.gif"); //$NON-NLS-1$
			return operation;
		}
		return null;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model called rule.
	 * 
	 * @param manager
	 *            the source manager, used to map the return type
	 * @param rule
	 *            the rule model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	public static Operation createFromCalledRule(AtlSourceManager manager, EObject rule, OclAnyType context) {
		Operation operation = createFromRule(manager, rule, context);
		if (operation != null) {
			operation.setImagePath("$nl$/icons/matchedRule.gif"); //$NON-NLS-1$
		}
		return operation;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model lazy rule.
	 * 
	 * @param manager
	 *            the source manager, used to map the return type
	 * @param rule
	 *            the rule model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	public static Operation createFromLazyRule(AtlSourceManager manager, EObject rule, OclAnyType context) {
		Operation operation = createFromRule(manager, rule, context);
		if (operation != null) {
			operation.setImagePath("$nl$/icons/lazyRule.gif"); //$NON-NLS-1$
		}
		return operation;
	}

	/**
	 * Utility method to initialize an Operation Feature from an ATL model helper.
	 * 
	 * @param manager
	 *            the source manager, used to map the return type
	 * @param helper
	 *            the helper model element
	 * @param context
	 *            the operation context type
	 * @return the Operation
	 */
	@SuppressWarnings("unchecked")
	public static Operation createFromHelper(AtlSourceManager manager, EObject helper, OclAnyType context) {
		String helperName = (String)AtlTypesProcessor.eGet(helper, "name"); //$NON-NLS-1$
		if (helperName != null) {
			Map<String, OclAnyType> parameters = new HashMap<String, OclAnyType>();
			EList<EObject> parameterObjects = (EList<EObject>)AtlTypesProcessor.eGet(helper, "parameters"); //$NON-NLS-1$
			if (parameterObjects != null) {
				for (EObject eObject : parameterObjects) {
					String parameterName = (String)AtlTypesProcessor.eGet(eObject, "varName"); //$NON-NLS-1$
					EObject parameterTypeObject = (EObject)AtlTypesProcessor.eGet(eObject, "type"); //$NON-NLS-1$
					OclAnyType parameterType = OclAnyType.create(manager, parameterTypeObject);
					parameters.put(parameterName, parameterType);
				}
			}
			EObject helperType = (EObject)AtlTypesProcessor.eGet(helper, "returnType"); //$NON-NLS-1$
			OclAnyType type = OclAnyType.create(manager, helperType);
			Operation operation = new Operation(helper, helperName, context, type, parameters);
			operation.setImagePath("$nl$/icons/helper.gif"); //$NON-NLS-1$
			return operation;
		}
		return null;
	}
}
