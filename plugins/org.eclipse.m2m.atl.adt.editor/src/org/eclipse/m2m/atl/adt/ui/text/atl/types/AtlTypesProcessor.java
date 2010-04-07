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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Type processor.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlTypesProcessor {

	private UnitType unit;

	private AtlModelAnalyser analyser;

	/**
	 * Updates the type processor.
	 * 
	 * @param file
	 *            the file containing the current unit
	 * @param analyser
	 *            the current model analyser (local code analysis)
	 * @param manager
	 *            the current source manager (entire code file repository)
	 */
	public void update(IFile file, AtlModelAnalyser analyser, AtlSourceManager manager) {
		this.analyser = analyser;
		unit = UnitType.create(file, manager);
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
			res = OclAnyType.create(unit.getSourceManager(), element).getOclType();
		} else if (oclIsKindOf(element, "Binding")) { //$NON-NLS-1$
			Feature feature = getBindingFeature(element);
			if (feature != null) {
				res = feature.getType();
			}
		} else if (oclIsKindOf(element, "StringExp")) { //$NON-NLS-1$
			res = StringType.getInstance();
		} else if (oclIsKindOf(element, "IntegerExp")) { //$NON-NLS-1$
			res = IntegerType.getInstance();
		} else if (oclIsKindOf(element, "RealExp")) { //$NON-NLS-1$
			res = RealType.getInstance();
		} else if (oclIsKindOf(element, "BooleanExp")) { //$NON-NLS-1$
			res = BooleanType.getInstance();
		} else if (oclIsKindOf(element, "SequenceExp")) { //$NON-NLS-1$
			// TODO get accurate type
			res = SequenceType.getInstance();
		} else if (oclIsKindOf(element, "BagExp")) { //$NON-NLS-1$
			// TODO get accurate type
			res = BagType.getInstance();
		} else if (oclIsKindOf(element, "SetExp")) { //$NON-NLS-1$
			// TODO get accurate type
			res = SetType.getInstance();
		} else if (oclIsKindOf(element, "OrderedSetExp")) { //$NON-NLS-1$
			// TODO get accurate type
			res = OrderedSetType.getInstance();
		} else if (oclIsKindOf(element, "MapExp")) { //$NON-NLS-1$
			// TODO get accurate type
			res = MapType.getInstance();
		} else if (oclIsKindOf(element, "VariableExp")) { //$NON-NLS-1$
			res = getVariableExpType(element);
		} else if (oclIsKindOf(element, "NavigationOrAttributeCallExp")) { //$NON-NLS-1$
			Feature feature = getFeature(element);
			if (feature != null) {
				res = feature.getType();
			}
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

	/**
	 * Returns a description of the given element.
	 * 
	 * @param locatedElement
	 *            the element
	 * @return the description
	 * @throws BadLocationException
	 */
	public String getInformation(EObject locatedElement) throws BadLocationException {
		if (oclIsKindOf(locatedElement, "OclModelElement")) { //$NON-NLS-1$
			OclAnyType type = OclAnyType.create(unit.getSourceManager(), locatedElement);
			if (type instanceof ModelElementType) {
				return ((ModelElementType)type).getInformation();
			}
		} else if (oclIsKindOf(locatedElement, "Binding")) { //$NON-NLS-1$
			Feature feature = getBindingFeature(locatedElement);
			if (feature != null) {
				return feature.getInformation();
			}
		} else if (oclIsKindOf(locatedElement, "VariableExp")) { //$NON-NLS-1$
			String code = analyser.getText(locatedElement);
			String name = analyzeVariableExp(code)[0];
			return name + " : " + getType(locatedElement); //$NON-NLS-1$
		} else if (oclIsKindOf(locatedElement, "NavigationOrAttributeCallExp")) { //$NON-NLS-1$
			Feature feature = getFeature(locatedElement);
			if (feature != null) {
				String atlDoc = feature.getDocumentation();
				if (atlDoc != null) {
					return atlDoc;
				}
				return feature.getInformation();
			}
		} else if (oclIsKindOf(locatedElement, "OperationCallExp")) { //$NON-NLS-1$
			return getOperationCallExpInformation(locatedElement);
		} else if (oclIsKindOf(locatedElement, "VariableDeclaration")) { //$NON-NLS-1$
			String name = (String)eGet(locatedElement, "varName"); //$NON-NLS-1$
			return name + " : " + getType(locatedElement); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Returns the type of the given element.
	 * 
	 * @param element
	 *            the element to analyze
	 * @return Returns the type of the given element.
	 * @throws BadLocationException
	 */
	public Object getDeclaration(EObject element) throws BadLocationException {
		Object res = null;
		if (oclIsKindOf(element, "VariableExp")) { //$NON-NLS-1$
			res = getVariableExpDeclaration(element);
		} else if (oclIsKindOf(element, "OclModelElement")) { //$NON-NLS-1$
			res = OclAnyType.create(unit.getSourceManager(), element).getOclType().getClassifier();
		} else if (oclIsKindOf(element, "Binding")) { //$NON-NLS-1$
			res = getBindingFeature(element);
		} else if (oclIsKindOf(element, "NavigationOrAttributeCallExp")) { //$NON-NLS-1$
			res = getFeature(element);
		} else if (oclIsKindOf(element, "OperationCallExp")) { //$NON-NLS-1$
			res = getOperationCallExpDeclaration(element);
		} else if (oclIsKindOf(element, "VariableDeclaration")) { //$NON-NLS-1$
			res = element;
		} else if (oclIsKindOf(element, "OclModel")) { //$NON-NLS-1$
			res = getMetamodelDeclaration(element);
		} else if (oclIsKindOf(element, "EnumLiteralExp")) { //$NON-NLS-1$
			// TODO retrieve declaration in metamodel
		}
		return res;
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
		variables.putAll(getRootVariables(element));
		EObject tmp = element;
		while (tmp != null) {
			variables.putAll(getLocalVariableDeclarations(tmp));
			tmp = analyser.getContainer(tmp);
		}
		return variables;
	}

	@SuppressWarnings("unchecked")
	private Object getMetamodelDeclaration(EObject element) {
		EObject res = null;
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		Collection<EObject> inModels = (Collection<EObject>)eGet(unit.getSourceManager().getModel(),
				"inModels"); //$NON-NLS-1$;
		if (inModels != null) {
			for (EObject model : inModels) {
				EObject metamodel = (EObject)eGet(model, "metamodel"); //$NON-NLS-1$
				if (name.equals(eGet(metamodel, "name"))) { //$NON-NLS-1$
					res = metamodel;
				}
			}
		}
		if (res == null) {
			Collection<EObject> outModels = (Collection<EObject>)eGet(unit.getSourceManager().getModel(),
					"outModels"); //$NON-NLS-1$;
			if (outModels != null) {
				for (EObject model : outModels) {
					EObject metamodel = (EObject)eGet(model, "metamodel"); //$NON-NLS-1$
					if (name.equals(eGet(metamodel, "name"))) { //$NON-NLS-1$
						res = metamodel;
					}
				}
			}
		}
		return res;
	}

	private Object getVariableExpDeclaration(EObject element) {
		EObject referredVariable = (EObject)eGet(element, "referredVariable"); //$NON-NLS-1$
		if (referredVariable != null) {
			return referredVariable;
		}
		return null;
	}

	private OclAnyType getVariableExpType(EObject element) throws BadLocationException {
		String code = analyser.getText(element);
		String name = analyzeVariableExp(code)[0];

		Map<String, OclAnyType> rootVariables = getRootVariables(element);
		if (rootVariables.containsKey(name)) {
			return rootVariables.get(name);
		}
		EObject referredVariable = (EObject)eGet(element, "referredVariable"); //$NON-NLS-1$
		if (referredVariable != null) {
			return getType(referredVariable);
		}

		EObject previousIterator = analyser.getPreviousElement(element, "Iterator"); //$NON-NLS-1$
		if (previousIterator != null) {
			String varName = (String)eGet(previousIterator, "varName"); //$NON-NLS-1$
			if (name.equals(varName)) {
				return getType(previousIterator);
			}
		}
		return OclAnyType.getInstance();
	}

	private OclAnyType getVariableDeclarationType(EObject element) {
		EObject atlType = (EObject)eGet(element, "type"); //$NON-NLS-1$
		if (atlType != null) {
			return OclAnyType.create(unit.getSourceManager(), atlType);
		}
		return OclAnyType.getInstance();
	}

	private Feature getBindingFeature(EObject element) throws BadLocationException {
		String navigation = (String)eGet(element, "propertyName"); //$NON-NLS-1$
		if (navigation != null) {
			EObject source = (EObject)eGet(element, "outPatternElement"); //$NON-NLS-1$
			if (source != null) {
				OclAnyType sourceType = getType(source);
				if (!sourceType.equals(OclAnyType.getInstance())) {
					return getFeature(sourceType, unit, navigation);
				}
			}
		}
		return null;
	}

	private Feature getFeature(EObject element) throws BadLocationException {
		String navigation = (String)eGet(element, "name"); //$NON-NLS-1$
		if (navigation != null) {
			EObject source = (EObject)eGet(element, "source"); //$NON-NLS-1$
			if (source != null) {
				OclAnyType sourceType = getType(source);
				if (!sourceType.equals(OclAnyType.getInstance())) {
					return getFeature(sourceType, unit, navigation);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private Object getOperationCallExpDeclaration(EObject element) throws BadLocationException {
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
				if (argumentTypes.isEmpty()) {
					return getOperation(sourceType, unit, operationName);
				} else {
					return getOperation(sourceType, unit, operationName, argumentTypes
							.toArray(new OclAnyType[argumentTypes.size()]));
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private String getOperationCallExpInformation(EObject element) throws BadLocationException {
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
					operation = getOperation(sourceType, unit, operationName);
				} else {
					operation = getOperation(sourceType, unit, operationName, argumentTypes
							.toArray(new OclAnyType[argumentTypes.size()]));
				}
				if (operation != null) {
					String atlDoc = operation.getDocumentation();
					if (atlDoc != null) {
						return atlDoc;
					}
					// TODO add arguments values
					return operation.getInformation(sourceType);
				}
			}
		}
		return null;
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
					operation = getOperation(sourceType, unit, operationName);
				} else {
					operation = getOperation(sourceType, unit, operationName, argumentTypes
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
				atlType = getType(source);
			} else {
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
	 * Compute the "root" element: a module, a rule or an helper.
	 * 
	 * @throws BadLocationException
	 */
	private EObject getRoot(EObject element) throws BadLocationException {
		EObject tmp = element;
		// rule / helper lookup
		while (tmp != null) {
			if (oclIsKindOf(tmp, "Rule") || oclIsKindOf(tmp, "Helper")) { //$NON-NLS-1$ //$NON-NLS-2$
				return tmp;
			}
			tmp = analyser.getContainer(tmp);
		}
		return analyser.getRoot();
	}

	/**
	 * Returns the list of variables available within the current model at the "locatedElement" place.
	 * 
	 * @return the list of variables
	 * @throws BadLocationException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, OclAnyType> getRootVariables(EObject element) throws BadLocationException {
		EObject root = getRoot(element);
		Map<String, OclAnyType> variables = new HashMap<String, OclAnyType>();
		if (unit.getSourceManager().getATLFileType() == AtlSourceManager.ATL_FILE_TYPE_MODULE) {
			variables.put("thisModule", unit); //$NON-NLS-1$
		}
		List<EObject> declarations = new ArrayList<EObject>();
		if (unit != null) {
			if (oclIsKindOf(root, "Rule")) { //$NON-NLS-1$
				Collection<EObject> parameterDeclarations = (Collection<EObject>)eGet(root, "parameters"); //$NON-NLS-1$
				if (parameterDeclarations != null) {
					declarations.addAll(parameterDeclarations);
				}
				EObject inPattern = (EObject)eGet(root, "inPattern"); //$NON-NLS-1$
				if (inPattern == null) {
					inPattern = analyser.getLastLostElementByType("InPattern"); //$NON-NLS-1$
				}
				if (inPattern != null) {
					Collection<EObject> inElements = (Collection<EObject>)eGet(inPattern, "elements"); //$NON-NLS-1$
					if (inElements != null) {
						declarations.addAll(inElements);
					}
				}

				Collection<EObject> variableDeclarations = (Collection<EObject>)eGet(root, "variables"); //$NON-NLS-1$
				if (variableDeclarations != null) {
					declarations.addAll(variableDeclarations);
				}
				EObject outPattern = (EObject)eGet(root, "outPattern"); //$NON-NLS-1$
				if (outPattern == null) {
					outPattern = analyser.getLastLostElementByType("OutPattern"); //$NON-NLS-1$
				}
				if (outPattern != null) {
					Collection<EObject> outElements = (Collection<EObject>)eGet(outPattern, "elements"); //$NON-NLS-1$
					if (outElements != null) {
						declarations.addAll(outElements);
					}
				}

				// Saved model lookup

				String ruleName = (String)eGet(root, "name"); //$NON-NLS-1$
				if (unit instanceof ModuleType) {
					ModuleType module = (ModuleType)unit;
					EObject savedRule = module.getRule(ruleName);
					if (savedRule != null) {
						Collection<EObject> savedParameterDeclarations = (Collection<EObject>)eGet(savedRule,
								"parameters"); //$NON-NLS-1$
						if (savedParameterDeclarations != null) {
							declarations.addAll(savedParameterDeclarations);
						}
						EObject savedInPattern = (EObject)eGet(savedRule, "inPattern"); //$NON-NLS-1$
						if (savedInPattern != null) {
							Collection<EObject> savedInElements = (Collection<EObject>)eGet(savedInPattern,
									"elements"); //$NON-NLS-1$
							if (savedInElements != null) {
								declarations.addAll(savedInElements);
							}
						}
						Collection<EObject> savedVariableDeclarations = (Collection<EObject>)eGet(savedRule,
								"variables"); //$NON-NLS-1$
						if (savedVariableDeclarations != null) {
							declarations.addAll(savedVariableDeclarations);
						}
						EObject savedOutPattern = (EObject)eGet(savedRule, "outPattern"); //$NON-NLS-1$
						if (savedOutPattern != null) {
							Collection<EObject> savedOutElements = (Collection<EObject>)eGet(savedOutPattern,
									"elements"); //$NON-NLS-1$
							if (savedOutElements != null) {
								declarations.addAll(savedOutElements);
							}
						}
					}
				}

			} else if (oclIsKindOf(root, "Helper")) { //$NON-NLS-1$
				EObject definition = (EObject)eGet(root, "definition"); //$NON-NLS-1$
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
							variables.put(
									"self", OclAnyType.create(unit.getSourceManager(), contextDefinition)); //$NON-NLS-1$
						}
					}
				}
			}
		}
		for (EObject eObject : declarations) {
			String variableName = eGet(eObject, "varName").toString(); //$NON-NLS-1$
			EObject variableType = (EObject)eGet(eObject, "type"); //$NON-NLS-1$			
			OclAnyType type = OclAnyType.create(unit.getSourceManager(), variableType);
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
				OclAnyType type = OclAnyType.create(unit.getSourceManager(), variableType);
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
						type = OclAnyType.create(unit.getSourceManager(), variableType);
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
					OclAnyType type = OclAnyType.create(unit.getSourceManager(), variableType);
					variables.put(variableName, type);
				}
			}
		} else {
			// TODO manage other local variables
		}
		return variables;
	}

	public UnitType getUnit() {
		return unit;
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
					check = check && parameters != null && parameters.length > index;
					// TODO check parameters type / supertypes
					// && parameters[index].equals(oclAnyType);
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
