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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlContextType;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Type processor.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlTypesProcessor {

	private AtlSourceManager manager;

	private AtlModelAnalyser analyser;

	/**
	 * Updates the type processor.
	 * 
	 * @param analyser
	 *            the current model analyser (local code analysis)
	 * @param manager
	 *            the current source manager (entire code file repository)
	 */
	public void update(AtlModelAnalyser analyser, AtlSourceManager manager) {
		this.analyser = analyser;
		this.manager = manager;
	}

	/**
	 * Returns the current context id.
	 * 
	 * @return the current context id
	 */
	public String getContextId() {
		String atlContextId = AtlContextType.ATL_CONTEXT_ID;
		if (analyser != null) {
			atlContextId = analyser.getContext();
		}
		return atlContextId;
	}

	/**
	 * Returns the type of the given element.
	 * 
	 * @param element
	 *            the element to analyze
	 * @return Returns the type of the given element.
	 * @throws BadLocationException
	 */
	public OclAnyType getType(EObject element) throws BadLocationException {
		OclAnyType res = OclAnyType.getInstance();
		if (oclIsKindOf(element, "OclModelElement")) { //$NON-NLS-1$
			res = OclAnyType.create(manager, element).getOclType();
		} else if (oclIsKindOf(element, "StringExp")) { //$NON-NLS-1$
			res = StringType.getInstance();
		} else if (oclIsKindOf(element, "IntegerExp")) { //$NON-NLS-1$
			res = IntegerType.getInstance();
		} else if (oclIsKindOf(element, "RealExp")) { //$NON-NLS-1$
			res = RealType.getInstance();
		} else if (oclIsKindOf(element, "BooleanExp")) { //$NON-NLS-1$
			res = BooleanType.getInstance();
		} else if (oclIsKindOf(element, "SequenceExp")) { //$NON-NLS-1$
			// TODO get precise type
			res = SequenceType.getInstance();
		} else if (oclIsKindOf(element, "BagExp")) { //$NON-NLS-1$
			// TODO get precise type
			res = BagType.getInstance();
		} else if (oclIsKindOf(element, "SetExp")) { //$NON-NLS-1$
			// TODO get precise type
			res = SetType.getInstance();
		} else if (oclIsKindOf(element, "OrderedSetExp")) { //$NON-NLS-1$
			// TODO get precise type
			res = OrderedSetType.getInstance();
		} else if (oclIsKindOf(element, "VariableExp")) { //$NON-NLS-1$
			res = getVariableExpType(element);
		} else if (oclIsKindOf(element, "NavigationOrAttributeCallExp")) { //$NON-NLS-1$
			res = getNavigationOrAttributeCallExpType(element);
		} else if (oclIsKindOf(element, "OperatorCallExp")) { //$NON-NLS-1$
			res = getOperatorCallExpType(element);
		} else if (oclIsKindOf(element, "OperationCallExp")) { //$NON-NLS-1$
			res = getOperationCallExpType(element);
		} else if (oclIsKindOf(element, "IteratorExp")) { //$NON-NLS-1$
			res = getIteratorExpType(element);
		} else if (oclIsKindOf(element, "Iterator")) { //$NON-NLS-1$
			res = getIteratorType(element);
		} else if (oclIsKindOf(element, "VariableDeclaration")) { //$NON-NLS-1$
			res = getVariableDeclarationType(element);
		}
		return res;
	}

	private OclAnyType getVariableExpType(EObject element) throws BadLocationException {
		String code = analyser.getText(element);
		String[] exp = analyzeVariableExp(code);

		if (getRootVariables().containsKey(exp[0])) {
			return getRootVariables().get(exp[0]);
		}
		EObject variableDeclaration = analyser.getVariableDeclaration(exp[0]);
		if (variableDeclaration != null) {
			return getType(variableDeclaration);
		}

		EObject referredVariable = (EObject)eGet(element, "referredVariable"); //$NON-NLS-1$
		if (referredVariable != null) {
			return getType(referredVariable);
		}
		return OclAnyType.getInstance();
	}

	private OclAnyType getVariableDeclarationType(EObject element) {
		EObject atlType = (EObject)eGet(element, "type"); //$NON-NLS-1$
		if (atlType != null) {
			return OclAnyType.create(manager, atlType);
		}
		return OclAnyType.getInstance();
	}

	private OclAnyType getNavigationOrAttributeCallExpType(EObject element) throws BadLocationException {
		String navigation = (String)eGet(element, "name"); //$NON-NLS-1$
		if (navigation != null) {
			EObject source = (EObject)eGet(element, "source"); //$NON-NLS-1$
			if (source != null) {
				OclAnyType sourceType = getType(source);
				if (!sourceType.equals(OclAnyType.getInstance())) {
					Feature feature = getFeature(sourceType, getUnit(), navigation);
					if (feature != null) {
						return feature.getType();
					} else {
						return OclAnyType.getInstance();
					}
				}
			}
		}
		return OclAnyType.getInstance();
	}

	@SuppressWarnings("unchecked")
	private OclAnyType getOperationCallExpType(EObject element) throws BadLocationException {
		String operationName = (String)eGet(element, "operationName"); //$NON-NLS-1$
		EObject source = (EObject)eGet(element, "source"); //$NON-NLS-1$
		if (source != null) {
			OclAnyType sourceType = getType(source);
			if (sourceType != null) {
				List<OclAnyType> argumentTypes = new ArrayList<OclAnyType>();
				Collection<EObject> arguments = (Collection<EObject>)eGet(element, "arguments"); //$NON-NLS-1$
				if (arguments != null) {
					for (EObject eObject : arguments) {
						argumentTypes.add(getType(eObject));
					}
				}
				Operation operation = null;
				if (argumentTypes.isEmpty()) {
					operation = getOperation(sourceType, getUnit(), operationName);
				} else {
					operation = getOperation(sourceType, getUnit(), operationName, argumentTypes
							.toArray(new OclAnyType[argumentTypes.size()]));
				}
				if (operation != null) {
					// TODO add arguments values
					return operation.getType(sourceType);
				} else {
					return OclAnyType.getInstance();
				}
			}
		}
		return OclAnyType.getInstance();
	}

	@SuppressWarnings("unchecked")
	private OclAnyType getOperatorCallExpType(EObject element) throws BadLocationException {
		OclAnyType res = OclAnyType.getInstance();
		String operatorName = (String)eGet(element, "operationName"); //$NON-NLS-1$
		if (operatorName.equals("=") || operatorName.equals("<>") || operatorName.equals(">") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				|| operatorName.equals("<") || operatorName.equals("=>") || operatorName.equals("=<") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				|| operatorName.equals("and") || operatorName.equals("or") || operatorName.equals("xor") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				|| operatorName.equals("not")) { //$NON-NLS-1$
			return BooleanType.getInstance();
		} else if (operatorName.equals("+") || operatorName.equals("-") || operatorName.equals("*")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Collection<EObject> arguments = (Collection<EObject>)eGet(element, "arguments"); //$NON-NLS-1$
			if (arguments != null) {
				for (EObject eObject : arguments) {
					OclAnyType argumentType = getType(eObject);
					if (!argumentType.equals(OclAnyType.getInstance()) && !res.equals(RealType.getInstance())
							&& !res.equals(StringType.getInstance())) {
						res = argumentType;
					}
				}
			}
		} else if (operatorName.equals("/")) { //$NON-NLS-1$
			return RealType.getInstance();
		}
		return res;
	}

	private OclAnyType getIteratorExpType(EObject element) throws BadLocationException {
		String iteratorName = (String)eGet(element, "name"); //$NON-NLS-1$
		EObject source = (EObject)eGet(element, "source"); //$NON-NLS-1$
		if (source != null) {
			if (iteratorName.equals("select")) { //$NON-NLS-1$
				return getType(source);
			} else if (iteratorName.equals("collect")) { //$NON-NLS-1$
				EObject body = (EObject)eGet(element, "body"); //$NON-NLS-1$
				return new SequenceType(getType(body));
			} else if (iteratorName.equals("reject")) { //$NON-NLS-1$
				return getType(source);
			} else if (iteratorName.equals("exists")) { //$NON-NLS-1$
				return BooleanType.getInstance();
			} else if (iteratorName.equals("forAll")) { //$NON-NLS-1$
				return BooleanType.getInstance();
			} else if (iteratorName.equals("isUnique")) { //$NON-NLS-1$
				return BooleanType.getInstance();
			} else if (iteratorName.equals("one")) { //$NON-NLS-1$
				return BooleanType.getInstance();
			} else if (iteratorName.equals("any")) { //$NON-NLS-1$
				OclAnyType sourceType = getType(source);
				if (sourceType instanceof CollectionType) {
					return ((CollectionType)sourceType).getParameterType();
				}
			} else if (iteratorName.equals("sortedBy")) { //$NON-NLS-1$
				return getType(source);
			} else if (iteratorName.equals("iterate")) { //$NON-NLS-1$
				// TODO get variable type
			}
		}
		return OclAnyType.getInstance();
	}

	private OclAnyType getIteratorType(EObject element) throws BadLocationException {
		// Iterator
		EObject loopExpr = (EObject)eGet(element, "loopExpr"); //$NON-NLS-1$
		if (loopExpr != null) {
			EObject source = (EObject)eGet(element, "source"); //$NON-NLS-1$
			OclAnyType atlType = null;
			if (source != null) {
				atlType = getType(loopExpr);
			} else {
				// TODO ambiguous ! should improve the parser
				EObject previous = analyser.getPreviousElement(element);
				if (previous != null) {
					atlType = getType(previous);
				}
			}
			if (atlType instanceof CollectionType) {
				return ((CollectionType)atlType).getParameterType();
			}
			// TODO other source iterator types
		}
		return OclAnyType.getInstance();
	}

	/**
	 * Returns the variables available at the given element level.
	 * 
	 * @param element
	 *            the located element
	 * @return the variables map
	 * @throws BadLocationException
	 */
	public Map<String, OclAnyType> getVariables(EObject element) throws BadLocationException {
		Map<String, OclAnyType> variables = new HashMap<String, OclAnyType>();
		variables.putAll(getRootVariables());
		EObject tmp = element;
		while (tmp != null) {
			variables.putAll(getLocalVariableDeclarations(tmp));
			tmp = analyser.getContainer(tmp);
		}
		return variables;
	}

	/**
	 * Returns the list of variables available within the current model at the "locatedElement" place.
	 * 
	 * @return the list of variables
	 * @throws BadLocationException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, OclAnyType> getRootVariables() throws BadLocationException {
		Map<String, OclAnyType> variables = new HashMap<String, OclAnyType>();
		if (manager.getATLFileType() == AtlSourceManager.ATL_FILE_TYPE_MODULE) {
			variables.put("thisModule", getUnit()); //$NON-NLS-1$
		}
		List<EObject> declarations = new ArrayList<EObject>();
		if (getUnit() != null) {
			if (oclIsKindOf(analyser.getRoot(), "Rule")) { //$NON-NLS-1$
				// TODO fix parameters
				//declarations.addAll(analyser.getLostElementsByType("Parameter")); //$NON-NLS-1$
				EObject inPattern = (EObject)eGet(analyser.getRoot(), "inPattern"); //$NON-NLS-1$
				if (inPattern == null) {
					inPattern = analyser.getLastLostElementByType("InPattern"); //$NON-NLS-1$
				}
				if (inPattern != null) {
					Collection<EObject> inElements = (Collection<EObject>)eGet(inPattern, "elements"); //$NON-NLS-1$
					if (inElements != null) {
						declarations.addAll(inElements);
					}
				}
				// TODO fix using
				declarations.addAll(analyser.getLostElementsByType("RuleVariableDeclaration")); //$NON-NLS-1$
				EObject outPattern = (EObject)eGet(analyser.getRoot(), "outPattern"); //$NON-NLS-1$
				if (outPattern == null) {
					outPattern = analyser.getLastLostElementByType("OutPattern"); //$NON-NLS-1$
				}
				if (outPattern != null) {
					Collection<EObject> outElements = (Collection<EObject>)eGet(outPattern, "elements"); //$NON-NLS-1$
					if (outElements != null) {
						declarations.addAll(outElements);
					}
				}
			} else if (oclIsKindOf(analyser.getRoot(), "Helper")) { //$NON-NLS-1$
				EObject definition = (EObject)eGet(analyser.getRoot(), "definition"); //$NON-NLS-1$
				if (definition != null) {
					EObject feature = (EObject)eGet(definition, "feature"); //$NON-NLS-1$
					if (feature != null) {
						Collection<EObject> parametersDeclarations = (Collection<EObject>)eGet(feature,
								"parameters"); //$NON-NLS-1$
						if (parametersDeclarations != null) {
							declarations.addAll(parametersDeclarations);
						}
					}
					EObject context = (EObject)eGet(definition, "context_"); //$NON-NLS-1$
					if (context != null) {
						EObject contextDefinition = (EObject)eGet(context, "context_"); //$NON-NLS-1$
						if (contextDefinition != null) {
							variables.put("self", OclAnyType.create(manager, contextDefinition)); //$NON-NLS-1$
						}
					}
				}
			}
		}
		for (EObject eObject : declarations) {
			String variableName = eGet(eObject, "varName").toString(); //$NON-NLS-1$
			EObject variableType = (EObject)eGet(eObject, "type"); //$NON-NLS-1$			
			OclAnyType type = OclAnyType.create(manager, variableType);
			variables.put(variableName, type);
		}
		return variables;
	}

	@SuppressWarnings("unchecked")
	private Map<String, OclAnyType> getLocalVariableDeclarations(EObject element) throws BadLocationException {
		Map<String, OclAnyType> variables = new HashMap<String, OclAnyType>();
		if (oclIsKindOf(element, "LetExp")) { //$NON-NLS-1$
			EObject declaration = (EObject)eGet(element, "variable"); //$NON-NLS-1$
			if (declaration != null) {
				String variableName = eGet(declaration, "varName").toString(); //$NON-NLS-1$
				EObject variableType = (EObject)eGet(declaration, "type"); //$NON-NLS-1$
				OclAnyType type = OclAnyType.create(manager, variableType);
				variables.put(variableName, type);
			}
		} else if (oclIsKindOf(element, "IteratorExp")) { //$NON-NLS-1$
			Collection<EObject> iterators = (Collection<EObject>)eGet(element, "iterators"); //$NON-NLS-1$
			if (iterators != null) {
				for (EObject declaration : iterators) {
					String variableName = eGet(declaration, "varName").toString(); //$NON-NLS-1$
					EObject variableType = (EObject)eGet(declaration, "type"); //$NON-NLS-1$
					OclAnyType type = null;
					if (variableType != null) {
						type = OclAnyType.create(manager, variableType);
					} else {
						type = getType(declaration);
					}
					variables.put(variableName, type);
				}
			}
		} else if (oclIsKindOf(element, "InPattern")) { //$NON-NLS-1$
			Collection<EObject> inElements = (Collection<EObject>)eGet(element, "elements"); //$NON-NLS-1$
			if (inElements != null) {
				for (EObject eObject : inElements) {
					String variableName = eGet(eObject, "varName").toString(); //$NON-NLS-1$
					EObject variableType = (EObject)eGet(eObject, "type"); //$NON-NLS-1$			
					OclAnyType type = OclAnyType.create(manager, variableType);
					variables.put(variableName, type);
				}
			}
		} else {
			// TODO manage other local variables
		}
		return variables;
	}

	private static String[] analyzeVariableExp(String code) {
		String currentPrefix = code;
		currentPrefix = currentPrefix.replaceFirst("<-", ""); //$NON-NLS-1$ //$NON-NLS-2$
		String varName = ""; //$NON-NLS-1$
		String lastPrefix = ""; //$NON-NLS-1$
		if (currentPrefix.indexOf(".") > 0) { //$NON-NLS-1$
			String[] splittedPrefix = currentPrefix.split("\\."); //$NON-NLS-1$
			if (splittedPrefix.length > 0) {
				if (currentPrefix.endsWith(".")) { //$NON-NLS-1$
					varName = splittedPrefix[splittedPrefix.length - 1];
					lastPrefix = ""; //$NON-NLS-1$
				} else {
					varName = splittedPrefix[splittedPrefix.length - 2];
					lastPrefix = splittedPrefix[splittedPrefix.length - 1];
				}
			}
		} else {
			lastPrefix = currentPrefix;
			varName = currentPrefix;
		}
		return new String[] {varName, lastPrefix};
	}

	/**
	 * Equivalent of ASMOclAny oclIsKindOf method for EObjects.
	 * 
	 * @param element
	 *            the tested element
	 * @param testedElementName
	 *            the type name
	 * @return <code>True</code> element has testedElementName in its superTypes, <code>False</code> else.
	 */
	public static boolean oclIsKindOf(EObject element, String testedElementName) {
		if (element != null) {
			if (element.eClass().getName().equals(testedElementName)) {
				return true;
			} else {
				EList<EClass> types = element.eClass().getEAllSuperTypes();
				for (Iterator<EClass> iterator = types.iterator(); iterator.hasNext();) {
					EClass object = iterator.next();
					if (object.getName().equals(testedElementName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns the value of a feature on an EObject.
	 * 
	 * @param self
	 *            the EObject
	 * @param featureName
	 *            the feature name
	 * @return the feature value
	 */
	public static Object eGet(EObject self, String featureName) {
		EStructuralFeature feature = self.eClass().getEStructuralFeature(featureName);
		if (feature != null) {
			return self.eGet(feature);
		}
		return null;
	}

	/**
	 * Returns the current atl unit type.
	 * 
	 * @return the current atl unit type
	 */
	public UnitType getUnit() {
		if (manager != null) {
			switch (manager.getATLFileType()) {
				case AtlSourceManager.ATL_FILE_TYPE_MODULE:
					return new ModuleType(manager);
				case AtlSourceManager.ATL_FILE_TYPE_LIBRARY:
					return new LibraryType(manager);
				case AtlSourceManager.ATL_FILE_TYPE_QUERY:
					return new QueryType(manager);
				default:
					break;
			}
		}
		return new ModuleType(null);
	}

	/**
	 * Returns the feature associated to the given context, with the given name.
	 * 
	 * @param context
	 *            the context type
	 * @param module
	 *            the current module
	 * @param featureName
	 *            the feature name
	 * @return the feature
	 */
	public static Feature getFeature(OclAnyType context, UnitType module, String featureName) {
		Collection<Feature> allFeatures = new ArrayList<Feature>();
		allFeatures.addAll(context.getFeatures());
		if (module != null) {
			allFeatures.addAll(module.getAttributes(context));
		}
		for (Feature feature : allFeatures) {
			if (feature.getName().equals(featureName)) {
				return feature;
			}
		}
		return null;
	}

	/**
	 * Returns the operation associated to the given context, with the given name.
	 * 
	 * @param context
	 *            the context type
	 * @param module
	 *            the current module
	 * @param operationName
	 *            the operation name
	 * @param parameters
	 *            the operation parameters
	 * @return the feature
	 */
	public static Operation getOperation(OclAnyType context, UnitType module, String operationName,
			OclAnyType... parameters) {
		Operation res = null;
		Collection<Operation> allOperations = new ArrayList<Operation>();
		allOperations.addAll(context.getOperations());
		if (module != null) {
			allOperations.addAll(module.getHelpers(context));
		}
		for (Operation operation : allOperations) {
			if (operation.getName().equals(operationName)) {
				boolean check = true;
				int index = 0;
				for (OclAnyType oclAnyType : operation.getParameters().values()) {
					check = check && parameters != null && parameters.length > index
							&& parameters[index].equals(oclAnyType);
					index++;
				}
				if (check) {
					res = operation;
				}
			}
		}
		return res;
	}
}
