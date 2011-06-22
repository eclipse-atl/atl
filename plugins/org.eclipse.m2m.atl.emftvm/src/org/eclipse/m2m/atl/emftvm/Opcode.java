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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Opcode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getOpcode()
 * @model
 * @generated
 */
public enum Opcode implements Enumerator {
	/**
	 * The '<em><b>PUSH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUSH_VALUE
	 * @generated
	 * @ordered
	 */
	PUSH(0, "PUSH", "PUSH"),

	/**
	 * The '<em><b>PUSHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUSHT_VALUE
	 * @generated
	 * @ordered
	 */
	PUSHT(1, "PUSHT", "PUSHT"),

	/**
	 * The '<em><b>PUSHF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUSHF_VALUE
	 * @generated
	 * @ordered
	 */
	PUSHF(2, "PUSHF", "PUSHF"),

	/**
	 * The '<em><b>POP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POP_VALUE
	 * @generated
	 * @ordered
	 */
	POP(3, "POP", "POP"),

	/**
	 * The '<em><b>LOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOAD_VALUE
	 * @generated
	 * @ordered
	 */
	LOAD(4, "LOAD", "LOAD"),

	/**
	 * The '<em><b>STORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORE_VALUE
	 * @generated
	 * @ordered
	 */
	STORE(5, "STORE", "STORE"),

	/**
	 * The '<em><b>SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_VALUE
	 * @generated
	 * @ordered
	 */
	SET(6, "SET", "SET"),

	/**
	 * The '<em><b>GET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_VALUE
	 * @generated
	 * @ordered
	 */
	GET(7, "GET", "GET"),

	/**
	 * The '<em><b>GET TRANS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_TRANS_VALUE
	 * @generated
	 * @ordered
	 */
	GET_TRANS(8, "GET_TRANS", "GET_TRANS"),

	/**
	 * The '<em><b>SET STATIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_STATIC_VALUE
	 * @generated
	 * @ordered
	 */
	SET_STATIC(9, "SET_STATIC", "SET_STATIC"),

	/**
	 * The '<em><b>GET STATIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_STATIC_VALUE
	 * @generated
	 * @ordered
	 */
	GET_STATIC(10, "GET_STATIC", "GET_STATIC"),

	/**
	 * The '<em><b>FINDTYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINDTYPE_VALUE
	 * @generated
	 * @ordered
	 */
	FINDTYPE(11, "FINDTYPE", "FINDTYPE"),

	/**
	 * The '<em><b>FINDTYPE S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINDTYPE_S_VALUE
	 * @generated
	 * @ordered
	 */
	FINDTYPE_S(12, "FINDTYPE_S", "FINDTYPE_S"),

	/**
	 * The '<em><b>NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @generated
	 * @ordered
	 */
	NEW(13, "NEW", "NEW"),

	/**
	 * The '<em><b>NEW S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_S_VALUE
	 * @generated
	 * @ordered
	 */
	NEW_S(14, "NEW_S", "NEW_S"),

	/**
	 * The '<em><b>DELETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE(15, "DELETE", "DELETE"),

	/**
	 * The '<em><b>DUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUP_VALUE
	 * @generated
	 * @ordered
	 */
	DUP(16, "DUP", "DUP"),

	/**
	 * The '<em><b>DUP X1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUP_X1_VALUE
	 * @generated
	 * @ordered
	 */
	DUP_X1(17, "DUP_X1", "DUP_X1"),

	/**
	 * The '<em><b>SWAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWAP_VALUE
	 * @generated
	 * @ordered
	 */
	SWAP(18, "SWAP", "SWAP"),

	/**
	 * The '<em><b>SWAP X1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWAP_X1_VALUE
	 * @generated
	 * @ordered
	 */
	SWAP_X1(19, "SWAP_X1", "SWAP_X1"), /**
	 * The '<em><b>IF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IF_VALUE
	 * @generated
	 * @ordered
	 */
	IF(20, "IF", "IF"),

	/**
	 * The '<em><b>IFN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IFN_VALUE
	 * @generated
	 * @ordered
	 */
	IFN(21, "IFN", "IFN"), /**
	 * The '<em><b>GOTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOTO_VALUE
	 * @generated
	 * @ordered
	 */
	GOTO(22, "GOTO", "GOTO"),

	/**
	 * The '<em><b>ITERATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITERATE_VALUE
	 * @generated
	 * @ordered
	 */
	ITERATE(23, "ITERATE", "ITERATE"),

	/**
	 * The '<em><b>ENDITERATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENDITERATE_VALUE
	 * @generated
	 * @ordered
	 */
	ENDITERATE(24, "ENDITERATE", "ENDITERATE"),

	/**
	 * The '<em><b>INVOKE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE(25, "INVOKE", "INVOKE"),

	/**
	 * The '<em><b>INVOKE SUPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_SUPER_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_SUPER(26, "INVOKE_SUPER", "INVOKE_SUPER"),

	/**
	 * The '<em><b>INVOKE STATIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_STATIC_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_STATIC(27, "INVOKE_STATIC", "INVOKE_STATIC"),

	/**
	 * The '<em><b>ALLINST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALLINST_VALUE
	 * @generated
	 * @ordered
	 */
	ALLINST(28, "ALLINST", "ALLINST"),

	/**
	 * The '<em><b>ALLINST IN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALLINST_IN_VALUE
	 * @generated
	 * @ordered
	 */
	ALLINST_IN(29, "ALLINST_IN", "ALLINST_IN"),

	/**
	 * The '<em><b>ISNULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ISNULL_VALUE
	 * @generated
	 * @ordered
	 */
	ISNULL(30, "ISNULL", "ISNULL"), /**
	 * The '<em><b>GETENVTYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GETENVTYPE_VALUE
	 * @generated
	 * @ordered
	 */
	GETENVTYPE(31, "GETENVTYPE", "GETENVTYPE"), /**
	 * The '<em><b>NOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_VALUE
	 * @generated
	 * @ordered
	 */
	NOT(32, "NOT", "NOT"), /**
	 * The '<em><b>AND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_VALUE
	 * @generated
	 * @ordered
	 */
	AND(33, "AND", "AND"), /**
	 * The '<em><b>OR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_VALUE
	 * @generated
	 * @ordered
	 */
	OR(34, "OR", "OR"), /**
	 * The '<em><b>XOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XOR_VALUE
	 * @generated
	 * @ordered
	 */
	XOR(35, "XOR", "XOR"), /**
	 * The '<em><b>IMPLIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLIES_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLIES(36, "IMPLIES", "IMPLIES"), /**
	 * The '<em><b>IFTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IFTE_VALUE
	 * @generated
	 * @ordered
	 */
	IFTE(37, "IFTE", "IFTE"), /**
	 * The '<em><b>RETURN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN(38, "RETURN", "RETURN"), /**
	 * The '<em><b>GETCB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GETCB_VALUE
	 * @generated
	 * @ordered
	 */
	GETCB(39, "GETCB", "GETCB"), /**
	 * The '<em><b>INVOKE ALL CBS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_ALL_CBS_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_ALL_CBS(40, "INVOKE_ALL_CBS", "INVOKE_ALL_CBS"), /**
	 * The '<em><b>INVOKE CB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_CB_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_CB(41, "INVOKE_CB", "INVOKE_CB"), /**
	 * The '<em><b>INVOKE CB S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVOKE_CB_S_VALUE
	 * @generated
	 * @ordered
	 */
	INVOKE_CB_S(42, "INVOKE_CB_S", "INVOKE_CB_S"), /**
	 * The '<em><b>MATCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH(43, "MATCH", "MATCH"), /**
	 * The '<em><b>MATCH S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_S_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_S(44, "MATCH_S", "MATCH_S"), /**
	 * The '<em><b>ADD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(45, "ADD", "ADD"), /**
	 * The '<em><b>REMOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE(46, "REMOVE", "REMOVE"), /**
	 * The '<em><b>INSERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSERT_VALUE
	 * @generated
	 * @ordered
	 */
	INSERT(47, "INSERT", "INSERT");

	/**
	 * The '<em><b>PUSH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PUSH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUSH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PUSH_VALUE = 0;

	/**
	 * The '<em><b>PUSHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PUSHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUSHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PUSHT_VALUE = 1;

	/**
	 * The '<em><b>PUSHF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PUSHF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUSHF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PUSHF_VALUE = 2;

	/**
	 * The '<em><b>POP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POP_VALUE = 3;

	/**
	 * The '<em><b>LOAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOAD_VALUE = 4;

	/**
	 * The '<em><b>STORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORE_VALUE = 5;

	/**
	 * The '<em><b>SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_VALUE = 6;

	/**
	 * The '<em><b>GET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_VALUE = 7;

	/**
	 * The '<em><b>GET TRANS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET TRANS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET_TRANS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_TRANS_VALUE = 8;

	/**
	 * The '<em><b>SET STATIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SET STATIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_STATIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_STATIC_VALUE = 9;

	/**
	 * The '<em><b>GET STATIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET STATIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET_STATIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_STATIC_VALUE = 10;

	/**
	 * The '<em><b>FINDTYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINDTYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINDTYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINDTYPE_VALUE = 11;

	/**
	 * The '<em><b>FINDTYPE S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINDTYPE S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINDTYPE_S
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINDTYPE_S_VALUE = 12;

	/**
	 * The '<em><b>NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE = 13;

	/**
	 * The '<em><b>NEW S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEW S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW_S
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEW_S_VALUE = 14;

	/**
	 * The '<em><b>DELETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_VALUE = 15;

	/**
	 * The '<em><b>DUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DUP_VALUE = 16;

	/**
	 * The '<em><b>DUP X1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DUP X1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUP_X1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DUP_X1_VALUE = 17;

	/**
	 * The '<em><b>SWAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SWAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SWAP_VALUE = 18;

	/**
	 * The '<em><b>SWAP X1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SWAP X1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWAP_X1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SWAP_X1_VALUE = 19;

	/**
	 * The '<em><b>IF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IF_VALUE = 20;

	/**
	 * The '<em><b>IFN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IFN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IFN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IFN_VALUE = 21;

	/**
	 * The '<em><b>GOTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GOTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GOTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GOTO_VALUE = 22;

	/**
	 * The '<em><b>ITERATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITERATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITERATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITERATE_VALUE = 23;

	/**
	 * The '<em><b>ENDITERATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENDITERATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENDITERATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENDITERATE_VALUE = 24;

	/**
	 * The '<em><b>INVOKE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_VALUE = 25;

	/**
	 * The '<em><b>INVOKE SUPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE SUPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE_SUPER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_SUPER_VALUE = 26;

	/**
	 * The '<em><b>INVOKE STATIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE STATIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE_STATIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_STATIC_VALUE = 27;

	/**
	 * The '<em><b>ALLINST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALLINST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALLINST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALLINST_VALUE = 28;

	/**
	 * The '<em><b>ALLINST IN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALLINST IN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALLINST_IN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALLINST_IN_VALUE = 29;

	/**
	 * The '<em><b>ISNULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ISNULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ISNULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ISNULL_VALUE = 30;

	/**
	 * The '<em><b>GETENVTYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GETENVTYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GETENVTYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GETENVTYPE_VALUE = 31;

	/**
	 * The '<em><b>NOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_VALUE = 32;

	/**
	 * The '<em><b>AND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_VALUE = 33;

	/**
	 * The '<em><b>OR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_VALUE = 34;

	/**
	 * The '<em><b>XOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XOR_VALUE = 35;

	/**
	 * The '<em><b>IMPLIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPLIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPLIES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPLIES_VALUE = 36;

	/**
	 * The '<em><b>IFTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IFTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IFTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IFTE_VALUE = 37;

	/**
	 * The '<em><b>RETURN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VALUE = 38;

	/**
	 * The '<em><b>GETCB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GETCB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GETCB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GETCB_VALUE = 39;

	/**
	 * The '<em><b>INVOKE ALL CBS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE ALL CBS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE_ALL_CBS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_ALL_CBS_VALUE = 40;

	/**
	 * The '<em><b>INVOKE CB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE CB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE_CB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_CB_VALUE = 41;

	/**
	 * The '<em><b>INVOKE CB S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVOKE CB S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVOKE_CB_S
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVOKE_CB_S_VALUE = 42;

	/**
	 * The '<em><b>MATCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_VALUE = 43;

	/**
	 * The '<em><b>MATCH S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATCH_S
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_S_VALUE = 44;

	/**
	 * The '<em><b>ADD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 45;

	/**
	 * The '<em><b>REMOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REMOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_VALUE = 46;

	/**
	 * The '<em><b>INSERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSERT_VALUE = 47;

	/**
	 * An array of all the '<em><b>Opcode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Opcode[] VALUES_ARRAY =
		new Opcode[] {
			PUSH,
			PUSHT,
			PUSHF,
			POP,
			LOAD,
			STORE,
			SET,
			GET,
			GET_TRANS,
			SET_STATIC,
			GET_STATIC,
			FINDTYPE,
			FINDTYPE_S,
			NEW,
			NEW_S,
			DELETE,
			DUP,
			DUP_X1,
			SWAP,
			SWAP_X1,
			IF,
			IFN,
			GOTO,
			ITERATE,
			ENDITERATE,
			INVOKE,
			INVOKE_SUPER,
			INVOKE_STATIC,
			ALLINST,
			ALLINST_IN,
			ISNULL,
			GETENVTYPE,
			NOT,
			AND,
			OR,
			XOR,
			IMPLIES,
			IFTE,
			RETURN,
			GETCB,
			INVOKE_ALL_CBS,
			INVOKE_CB,
			INVOKE_CB_S,
			MATCH,
			MATCH_S,
			ADD,
			REMOVE,
			INSERT,
		};

	/**
	 * A public read-only list of all the '<em><b>Opcode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Opcode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Opcode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Opcode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Opcode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Opcode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Opcode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Opcode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Opcode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Opcode get(int value) {
		switch (value) {
			case PUSH_VALUE: return PUSH;
			case PUSHT_VALUE: return PUSHT;
			case PUSHF_VALUE: return PUSHF;
			case POP_VALUE: return POP;
			case LOAD_VALUE: return LOAD;
			case STORE_VALUE: return STORE;
			case SET_VALUE: return SET;
			case GET_VALUE: return GET;
			case GET_TRANS_VALUE: return GET_TRANS;
			case SET_STATIC_VALUE: return SET_STATIC;
			case GET_STATIC_VALUE: return GET_STATIC;
			case FINDTYPE_VALUE: return FINDTYPE;
			case FINDTYPE_S_VALUE: return FINDTYPE_S;
			case NEW_VALUE: return NEW;
			case NEW_S_VALUE: return NEW_S;
			case DELETE_VALUE: return DELETE;
			case DUP_VALUE: return DUP;
			case DUP_X1_VALUE: return DUP_X1;
			case SWAP_VALUE: return SWAP;
			case SWAP_X1_VALUE: return SWAP_X1;
			case IF_VALUE: return IF;
			case IFN_VALUE: return IFN;
			case GOTO_VALUE: return GOTO;
			case ITERATE_VALUE: return ITERATE;
			case ENDITERATE_VALUE: return ENDITERATE;
			case INVOKE_VALUE: return INVOKE;
			case INVOKE_SUPER_VALUE: return INVOKE_SUPER;
			case INVOKE_STATIC_VALUE: return INVOKE_STATIC;
			case ALLINST_VALUE: return ALLINST;
			case ALLINST_IN_VALUE: return ALLINST_IN;
			case ISNULL_VALUE: return ISNULL;
			case GETENVTYPE_VALUE: return GETENVTYPE;
			case NOT_VALUE: return NOT;
			case AND_VALUE: return AND;
			case OR_VALUE: return OR;
			case XOR_VALUE: return XOR;
			case IMPLIES_VALUE: return IMPLIES;
			case IFTE_VALUE: return IFTE;
			case RETURN_VALUE: return RETURN;
			case GETCB_VALUE: return GETCB;
			case INVOKE_ALL_CBS_VALUE: return INVOKE_ALL_CBS;
			case INVOKE_CB_VALUE: return INVOKE_CB;
			case INVOKE_CB_S_VALUE: return INVOKE_CB_S;
			case MATCH_VALUE: return MATCH;
			case MATCH_S_VALUE: return MATCH_S;
			case ADD_VALUE: return ADD;
			case REMOVE_VALUE: return REMOVE;
			case INSERT_VALUE: return INSERT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Opcode(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Opcode
