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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Number</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartChar <em>Start Char</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndChar <em>End Char</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock <em>Owning Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LineNumber#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber()
 * @model
 * @generated
 */
public interface LineNumber extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_StartLine()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>Start Column</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Column</em>' attribute.
	 * @see #setStartColumn(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_StartColumn()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getStartColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartColumn <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Column</em>' attribute.
	 * @see #getStartColumn()
	 * @generated
	 */
	void setStartColumn(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_EndLine()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

	/**
	 * Returns the value of the '<em><b>End Column</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Column</em>' attribute.
	 * @see #setEndColumn(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_EndColumn()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getEndColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndColumn <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Column</em>' attribute.
	 * @see #getEndColumn()
	 * @generated
	 */
	void setEndColumn(int value);

	/**
	 * Returns the value of the '<em><b>Start Char</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Char</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Char</em>' attribute.
	 * @see #setStartChar(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_StartChar()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getStartChar();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartChar <em>Start Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Char</em>' attribute.
	 * @see #getStartChar()
	 * @generated
	 */
	void setStartChar(int value);

	/**
	 * Returns the value of the '<em><b>End Char</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Char</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Char</em>' attribute.
	 * @see #setEndChar(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_EndChar()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getEndChar();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndChar <em>End Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Char</em>' attribute.
	 * @see #getEndChar()
	 * @generated
	 */
	void setEndChar(int value);

	/**
	 * Returns the value of the '<em><b>Owning Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLineNumbers <em>Line Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Block</em>' container reference.
	 * @see #setOwningBlock(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_OwningBlock()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getLineNumbers
	 * @model opposite="lineNumbers" required="true" transient="false"
	 * @generated
	 */
	CodeBlock getOwningBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock <em>Owning Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Block</em>' container reference.
	 * @see #getOwningBlock()
	 * @generated
	 */
	void setOwningBlock(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Instructions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Instruction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The instructions that map to this line number specification.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructions</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLineNumber_Instructions()
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber
	 * @model opposite="lineNumber"
	 * @generated
	 */
	EList<Instruction> getInstructions();

} // LineNumber
