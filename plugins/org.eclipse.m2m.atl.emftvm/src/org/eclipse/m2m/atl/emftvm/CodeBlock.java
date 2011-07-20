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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Block</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals <em>Max Locals</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack <em>Max Stack</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLineNumbers <em>Line Numbers</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLocalVariables <em>Local Variables</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor <em>Matcher For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor <em>Applier For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor <em>Post Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor <em>Body For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor <em>Initialiser For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNested <em>Nested</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor <em>Nested For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getParentFrame <em>Parent Frame</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor <em>Binding For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock()
 * @model
 * @generated
 */
public interface CodeBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Locals</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The amount of local variables slots required.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Locals</em>' attribute.
	 * @see #setMaxLocals(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_MaxLocals()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getMaxLocals();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals <em>Max Locals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Locals</em>' attribute.
	 * @see #getMaxLocals()
	 * @generated
	 */
	void setMaxLocals(int value);

	/**
	 * Returns the value of the '<em><b>Max Stack</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The amount of stack slots required.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Stack</em>' attribute.
	 * @see #setMaxStack(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_MaxStack()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getMaxStack();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack <em>Max Stack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Stack</em>' attribute.
	 * @see #getMaxStack()
	 * @generated
	 */
	void setMaxStack(int value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Instruction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_Code()
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock
	 * @model opposite="owningBlock" containment="true"
	 * @generated
	 */
	EList<Instruction> getCode();

	/**
	 * Returns the value of the '<em><b>Line Numbers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.LineNumber}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Numbers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Numbers</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_LineNumbers()
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock
	 * @model opposite="owningBlock" containment="true"
	 * @generated
	 */
	EList<LineNumber> getLineNumbers();

	/**
	 * Returns the value of the '<em><b>Local Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.LocalVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Variables</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_LocalVariables()
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock
	 * @model opposite="owningBlock" containment="true"
	 * @generated
	 */
	EList<LocalVariable> getLocalVariables();

	/**
	 * Returns the value of the '<em><b>Matcher For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher For</em>' container reference.
	 * @see #setMatcherFor(Rule)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_MatcherFor()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getMatcher
	 * @model opposite="matcher" transient="false"
	 * @generated
	 */
	Rule getMatcherFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor <em>Matcher For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher For</em>' container reference.
	 * @see #getMatcherFor()
	 * @generated
	 */
	void setMatcherFor(Rule value);

	/**
	 * Returns the value of the '<em><b>Applier For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getApplier <em>Applier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applier For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applier For</em>' container reference.
	 * @see #setApplierFor(Rule)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_ApplierFor()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getApplier
	 * @model opposite="applier" transient="false"
	 * @generated
	 */
	Rule getApplierFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor <em>Applier For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applier For</em>' container reference.
	 * @see #getApplierFor()
	 * @generated
	 */
	void setApplierFor(Rule value);

	/**
	 * Returns the value of the '<em><b>Post Apply For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getPostApply <em>Post Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Apply For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Apply For</em>' container reference.
	 * @see #setPostApplyFor(Rule)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_PostApplyFor()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getPostApply
	 * @model opposite="postApply" transient="false"
	 * @generated
	 */
	Rule getPostApplyFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor <em>Post Apply For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Apply For</em>' container reference.
	 * @see #getPostApplyFor()
	 * @generated
	 */
	void setPostApplyFor(Rule value);

	/**
	 * Returns the value of the '<em><b>Body For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Operation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body For</em>' container reference.
	 * @see #setBodyFor(Operation)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_BodyFor()
	 * @see org.eclipse.m2m.atl.emftvm.Operation#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	Operation getBodyFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor <em>Body For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body For</em>' container reference.
	 * @see #getBodyFor()
	 * @generated
	 */
	void setBodyFor(Operation value);

	/**
	 * Returns the value of the '<em><b>Initialiser For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Field#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialiser For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialiser For</em>' container reference.
	 * @see #setInitialiserFor(Field)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_InitialiserFor()
	 * @see org.eclipse.m2m.atl.emftvm.Field#getInitialiser
	 * @model opposite="initialiser" transient="false"
	 * @generated
	 */
	Field getInitialiserFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor <em>Initialiser For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialiser For</em>' container reference.
	 * @see #getInitialiserFor()
	 * @generated
	 */
	void setInitialiserFor(Field value);

	/**
	 * Returns the value of the '<em><b>Nested</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.CodeBlock}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor <em>Nested For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_Nested()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor
	 * @model opposite="nestedFor" containment="true"
	 * @generated
	 */
	EList<CodeBlock> getNested();

	/**
	 * Returns the value of the '<em><b>Nested For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNested <em>Nested</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested For</em>' container reference.
	 * @see #setNestedFor(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_NestedFor()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNested
	 * @model opposite="nested" transient="false"
	 * @generated
	 */
	CodeBlock getNestedFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor <em>Nested For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested For</em>' container reference.
	 * @see #getNestedFor()
	 * @generated
	 */
	void setNestedFor(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Parent Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Frame</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Frame</em>' attribute.
	 * @see #setParentFrame(StackFrame)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_ParentFrame()
	 * @model dataType="org.eclipse.m2m.atl.emftvm.StackFrame" transient="true"
	 * @generated
	 */
	StackFrame getParentFrame();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getParentFrame <em>Parent Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Frame</em>' attribute.
	 * @see #getParentFrame()
	 * @generated
	 */
	void setParentFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Binding For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding For</em>' container reference.
	 * @see #setBindingFor(InputRuleElement)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlock_BindingFor()
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding
	 * @model opposite="binding" transient="false"
	 * @generated
	 */
	InputRuleElement getBindingFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor <em>Binding For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding For</em>' container reference.
	 * @see #getBindingFor()
	 * @generated
	 */
	void setBindingFor(InputRuleElement value);

	/**
	 * <!-- begin-user-doc -->
	 * Executes the instructions in this {@link CodeBlock}, using the parameters stored in <code>frame</code>.
	 * @param frame the {@link StackFrame} to use during execution.
	 * @return the resulting execution value, or <code>null</code> if none.
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	Object execute(StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Calculates the amount of elements on the stack after executing this {@link CodeBlock}.
	 * @return the amount of elements on the stack after executing this {@link CodeBlock}.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getStackLevel();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link Module} that (indirectly) contains this {@link CodeBlock}.
	 * @return the {@link Module} that (indirectly) contains this {@link CodeBlock}.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Module getModule();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link Operation} that (indirectly) contains this {@link CodeBlock}, if any.
	 * @return the {@link Operation} that (indirectly) contains this {@link CodeBlock}, or <code>null</code>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Operation getOperation();

} // CodeBlock
