/*******************************************************************************
 * Copyright (c) 2024 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.jit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.Allinst;
import org.eclipse.m2m.atl.emftvm.AllinstIn;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.Delete;
import org.eclipse.m2m.atl.emftvm.Dup;
import org.eclipse.m2m.atl.emftvm.DupX1;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.FindtypeS;
import org.eclipse.m2m.atl.emftvm.Get;
import org.eclipse.m2m.atl.emftvm.GetStatic;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.GetTrans;
import org.eclipse.m2m.atl.emftvm.Getcb;
import org.eclipse.m2m.atl.emftvm.Getenv;
import org.eclipse.m2m.atl.emftvm.Getenvtype;
import org.eclipse.m2m.atl.emftvm.Goto;
import org.eclipse.m2m.atl.emftvm.If;
import org.eclipse.m2m.atl.emftvm.Ifn;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Implies;
import org.eclipse.m2m.atl.emftvm.Insert;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Invoke;
import org.eclipse.m2m.atl.emftvm.InvokeAllCbs;
import org.eclipse.m2m.atl.emftvm.InvokeCb;
import org.eclipse.m2m.atl.emftvm.InvokeCbS;
import org.eclipse.m2m.atl.emftvm.InvokeStatic;
import org.eclipse.m2m.atl.emftvm.InvokeSuper;
import org.eclipse.m2m.atl.emftvm.Isnull;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.Load;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.MatchS;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.NewS;
import org.eclipse.m2m.atl.emftvm.Not;
import org.eclipse.m2m.atl.emftvm.Opcode;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Or;
import org.eclipse.m2m.atl.emftvm.Pop;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Pushf;
import org.eclipse.m2m.atl.emftvm.Pusht;
import org.eclipse.m2m.atl.emftvm.Remove;
import org.eclipse.m2m.atl.emftvm.Return;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.Swap;
import org.eclipse.m2m.atl.emftvm.SwapX1;
import org.eclipse.m2m.atl.emftvm.Xor;
import org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch;
import org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT;
import org.eclipse.m2m.atl.emftvm.jit.LabelSwitch;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 *
 */
public class ByteCodeSwitchTest extends TestCase {

	protected ByteCodeSwitch fixture;

	protected CodeBlockJIT codeBlockJITMock;
	protected MethodVisitor methodVisitorMock;
	protected LabelSwitch labelSwitchMock;
	protected ExecEnv execEnvMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		codeBlockJITMock = mock(CodeBlockJIT.class);
		methodVisitorMock = mock(MethodVisitor.class);
		labelSwitchMock = mock(LabelSwitch.class);
		execEnvMock = mock(ExecEnv.class);

		when(codeBlockJITMock.getEnv()).thenReturn(execEnvMock);
		when(execEnvMock.getMonitor()).thenReturn(null);

		setFixture(new ByteCodeSwitch(codeBlockJITMock, methodVisitorMock, labelSwitchMock));
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#boxed(java.lang.Class)}.
	 */
	@Test
	public void testBoxed() {
		assertEquals(Void.class, ByteCodeSwitch.boxed(Void.TYPE));
		assertEquals(Boolean.class, ByteCodeSwitch.boxed(Boolean.TYPE));
		assertEquals(Character.class, ByteCodeSwitch.boxed(Character.TYPE));
		assertEquals(Byte.class, ByteCodeSwitch.boxed(Byte.TYPE));
		assertEquals(Short.class, ByteCodeSwitch.boxed(Short.TYPE));
		assertEquals(Integer.class, ByteCodeSwitch.boxed(Integer.TYPE));
		assertEquals(Long.class, ByteCodeSwitch.boxed(Long.TYPE));
		assertEquals(Float.class, ByteCodeSwitch.boxed(Float.TYPE));
		assertEquals(Double.class, ByteCodeSwitch.boxed(Double.TYPE));
		assertEquals(String.class, ByteCodeSwitch.boxed(String.class));
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInstruction(org.eclipse.m2m.atl.emftvm.Instruction)}.
	 */
	@Test
	public void testCaseInstructionInstruction() {
		final Instruction instruction = EmftvmFactory.eINSTANCE.createInstruction(Opcode.ADD);
		final Label labelMock = mock(Label.class);

		when(labelSwitchMock.hasWithTarget(instruction)).thenReturn(true);
		when(labelSwitchMock.getFromTarget(instruction)).thenReturn(labelMock);

		final MethodVisitor result = getFixture().caseInstruction(instruction);

		verify(methodVisitorMock).visitLabel(labelMock);
		assertEquals(methodVisitorMock, result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInstruction(org.eclipse.m2m.atl.emftvm.Instruction)}.
	 */
	@Test
	public void testCaseInstructionInstruction_noLabel() {
		final Instruction instruction = EmftvmFactory.eINSTANCE.createInstruction(Opcode.ADD);

		when(labelSwitchMock.hasWithTarget(instruction)).thenReturn(false);

		final MethodVisitor result = getFixture().caseInstruction(instruction);

		verify(methodVisitorMock, never()).visitLabel((Label) any());
		assertEquals(methodVisitorMock, result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#casePush(org.eclipse.m2m.atl.emftvm.Push)}.
	 */
	@Test
	public void testCasePushPush() {
		final Push instruction = EmftvmFactory.eINSTANCE.createPush();

		final MethodVisitor result = getFixture().casePush(instruction);

		verify(methodVisitorMock).visitInsn(Opcodes.ACONST_NULL);
		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#casePusht(org.eclipse.m2m.atl.emftvm.Pusht)}.
	 */
	@Test
	public void testCasePushtPusht() {
		final Pusht instruction = EmftvmFactory.eINSTANCE.createPusht();

		final MethodVisitor result = getFixture().casePusht(instruction);

		verify(methodVisitorMock).visitInsn(Opcodes.ICONST_1);
		verify(methodVisitorMock).visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Boolean.class), "valueOf",
				Type.getMethodDescriptor(Type.getType(Boolean.class), Type.BOOLEAN_TYPE), false);
		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#casePushf(org.eclipse.m2m.atl.emftvm.Pushf)}.
	 */
	@Test
	public void testCasePushfPushf() {
		final Pushf instruction = EmftvmFactory.eINSTANCE.createPushf();

		final MethodVisitor result = getFixture().casePushf(instruction);

		verify(methodVisitorMock).visitInsn(Opcodes.ICONST_0);
		verify(methodVisitorMock).visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Boolean.class), "valueOf",
				Type.getMethodDescriptor(Type.getType(Boolean.class), Type.BOOLEAN_TYPE), false);
		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#casePop(org.eclipse.m2m.atl.emftvm.Pop)}.
	 */
	@Test
	public void testCasePopPop() {
		final Pop instruction = EmftvmFactory.eINSTANCE.createPop();

		final MethodVisitor result = getFixture().casePop(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseLoad(org.eclipse.m2m.atl.emftvm.Load)}.
	 */
	@Test
	public void testCaseLoadLoad() {
		final Load instruction = EmftvmFactory.eINSTANCE.createLoad();

		final MethodVisitor result = getFixture().caseLoad(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseStore(org.eclipse.m2m.atl.emftvm.Store)}.
	 */
	@Test
	public void testCaseStoreStore() {
		final Store instruction = EmftvmFactory.eINSTANCE.createStore();

		final MethodVisitor result = getFixture().caseStore(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseSet(org.eclipse.m2m.atl.emftvm.Set)}.
	 */
	@Test
	public void testCaseSetSet() {
		final Set instruction = EmftvmFactory.eINSTANCE.createSet();

		final MethodVisitor result = getFixture().caseSet(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGet(org.eclipse.m2m.atl.emftvm.Get)}.
	 */
	@Test
	public void testCaseGetGet() {
		final Get instruction = EmftvmFactory.eINSTANCE.createGet();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseGet(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetTrans(org.eclipse.m2m.atl.emftvm.GetTrans)}.
	 */
	@Test
	public void testCaseGetTransGetTrans() {
		final GetTrans instruction = EmftvmFactory.eINSTANCE.createGetTrans();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseGetTrans(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseSetStatic(org.eclipse.m2m.atl.emftvm.SetStatic)}.
	 */
	@Test
	public void testCaseSetStaticSetStatic() {
		final SetStatic instruction = EmftvmFactory.eINSTANCE.createSetStatic();

		final MethodVisitor result = getFixture().caseSetStatic(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetStatic(org.eclipse.m2m.atl.emftvm.GetStatic)}.
	 */
	@Test
	public void testCaseGetStaticGetStatic() {
		final GetStatic instruction = EmftvmFactory.eINSTANCE.createGetStatic();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseGetStatic(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseFindtype(org.eclipse.m2m.atl.emftvm.Findtype)}.
	 */
	@Test
	public void testCaseFindtypeFindtype() {
		final Findtype instruction = EmftvmFactory.eINSTANCE.createFindtype();

		final MethodVisitor result = getFixture().caseFindtype(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseFindtypeS(org.eclipse.m2m.atl.emftvm.FindtypeS)}.
	 */
	@Test
	public void testCaseFindtypeSFindtypeS() {
		final FindtypeS instruction = EmftvmFactory.eINSTANCE.createFindtypeS();

		final MethodVisitor result = getFixture().caseFindtypeS(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseNew(org.eclipse.m2m.atl.emftvm.New)}.
	 */
	@Test
	public void testCaseNewNew() {
		final New instruction = EmftvmFactory.eINSTANCE.createNew();

		final MethodVisitor result = getFixture().caseNew(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseNewS(org.eclipse.m2m.atl.emftvm.NewS)}.
	 */
	@Test
	public void testCaseNewSNewS() {
		final NewS instruction = EmftvmFactory.eINSTANCE.createNewS();

		final MethodVisitor result = getFixture().caseNewS(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseDelete(org.eclipse.m2m.atl.emftvm.Delete)}.
	 */
	@Test
	public void testCaseDeleteDelete() {
		final Delete instruction = EmftvmFactory.eINSTANCE.createDelete();

		final MethodVisitor result = getFixture().caseDelete(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseDup(org.eclipse.m2m.atl.emftvm.Dup)}.
	 */
	@Test
	public void testCaseDupDup() {
		final Dup instruction = EmftvmFactory.eINSTANCE.createDup();

		final MethodVisitor result = getFixture().caseDup(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseDupX1(org.eclipse.m2m.atl.emftvm.DupX1)}.
	 */
	@Test
	public void testCaseDupX1DupX1() {
		final DupX1 instruction = EmftvmFactory.eINSTANCE.createDupX1();

		final MethodVisitor result = getFixture().caseDupX1(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseSwap(org.eclipse.m2m.atl.emftvm.Swap)}.
	 */
	@Test
	public void testCaseSwapSwap() {
		final Swap instruction = EmftvmFactory.eINSTANCE.createSwap();

		final MethodVisitor result = getFixture().caseSwap(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseSwapX1(org.eclipse.m2m.atl.emftvm.SwapX1)}.
	 */
	@Test
	public void testCaseSwapX1SwapX1() {
		final SwapX1 instruction = EmftvmFactory.eINSTANCE.createSwapX1();

		final MethodVisitor result = getFixture().caseSwapX1(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseIf(org.eclipse.m2m.atl.emftvm.If)}.
	 */
	@Test
	public void testCaseIfIf() {
		final If instruction = EmftvmFactory.eINSTANCE.createIf();

		when(labelSwitchMock.hasWithSource(instruction)).thenReturn(true);

		final MethodVisitor result = getFixture().caseIf(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseIfn(org.eclipse.m2m.atl.emftvm.Ifn)}.
	 */
	@Test
	public void testCaseIfnIfn() {
		final Ifn instruction = EmftvmFactory.eINSTANCE.createIfn();

		when(labelSwitchMock.hasWithSource(instruction)).thenReturn(true);

		final MethodVisitor result = getFixture().caseIfn(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGoto(org.eclipse.m2m.atl.emftvm.Goto)}.
	 */
	@Test
	public void testCaseGotoGoto() {
		final Goto instruction = EmftvmFactory.eINSTANCE.createGoto();

		when(labelSwitchMock.hasWithSource(instruction)).thenReturn(true);

		final MethodVisitor result = getFixture().caseGoto(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseIterate(org.eclipse.m2m.atl.emftvm.Iterate)}.
	 */
	@Test
	public void testCaseIterateIterate() {
		final Iterate instruction = EmftvmFactory.eINSTANCE.createIterate();

		when(labelSwitchMock.hasWithSource(instruction)).thenReturn(true);

		final MethodVisitor result = getFixture().caseIterate(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseEnditerate(org.eclipse.m2m.atl.emftvm.Enditerate)}.
	 */
	@Test
	public void testCaseEnditerateEnditerate() {
		final Enditerate instruction = EmftvmFactory.eINSTANCE.createEnditerate();

		when(labelSwitchMock.hasWithSource(instruction)).thenReturn(true);

		final MethodVisitor result = getFixture().caseEnditerate(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvoke(org.eclipse.m2m.atl.emftvm.Invoke)}.
	 */
	@Test
	public void testCaseInvokeInvoke() {
		final Invoke instruction = EmftvmFactory.eINSTANCE.createInvoke();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseInvoke(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvokeSuper(org.eclipse.m2m.atl.emftvm.InvokeSuper)}.
	 */
	@Test
	public void testCaseInvokeSuperInvokeSuper() {
		final InvokeSuper instruction = EmftvmFactory.eINSTANCE.createInvokeSuper();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Operation operation = EmftvmFactory.eINSTANCE.createOperation();
		instruction.setOwningBlock(owningBlock);
		owningBlock.setBodyFor(operation);
		operation.setEContext(EmftvmPackage.eINSTANCE.getExecEnv());

		final MethodVisitor result = getFixture().caseInvokeSuper(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvokeStatic(org.eclipse.m2m.atl.emftvm.InvokeStatic)}.
	 */
	@Test
	public void testCaseInvokeStaticInvokeStatic() {
		final InvokeStatic instruction = EmftvmFactory.eINSTANCE.createInvokeStatic();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseInvokeStatic(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseAllinst(org.eclipse.m2m.atl.emftvm.Allinst)}.
	 */
	@Test
	public void testCaseAllinstAllinst() {
		final Allinst instruction = EmftvmFactory.eINSTANCE.createAllinst();

		final MethodVisitor result = getFixture().caseAllinst(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseAllinstIn(org.eclipse.m2m.atl.emftvm.AllinstIn)}.
	 */
	@Test
	public void testCaseAllinstInAllinstIn() {
		final AllinstIn instruction = EmftvmFactory.eINSTANCE.createAllinstIn();

		final MethodVisitor result = getFixture().caseAllinstIn(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseMatch(org.eclipse.m2m.atl.emftvm.Match)}.
	 */
	@Test
	public void testCaseMatchMatch() {
		final Match instruction = EmftvmFactory.eINSTANCE.createMatch();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseMatch(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseMatchS(org.eclipse.m2m.atl.emftvm.MatchS)}.
	 */
	@Test
	public void testCaseMatchSMatchS() {
		final MatchS instruction = EmftvmFactory.eINSTANCE.createMatchS();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseMatchS(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseAdd(org.eclipse.m2m.atl.emftvm.Add)}.
	 */
	@Test
	public void testCaseAddAdd() {
		final Add instruction = EmftvmFactory.eINSTANCE.createAdd();

		final MethodVisitor result = getFixture().caseAdd(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseRemove(org.eclipse.m2m.atl.emftvm.Remove)}.
	 */
	@Test
	public void testCaseRemoveRemove() {
		final Remove instruction = EmftvmFactory.eINSTANCE.createRemove();

		final MethodVisitor result = getFixture().caseRemove(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInsert(org.eclipse.m2m.atl.emftvm.Insert)}.
	 */
	@Test
	public void testCaseInsertInsert() {
		final Insert instruction = EmftvmFactory.eINSTANCE.createInsert();

		final MethodVisitor result = getFixture().caseInsert(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetSuper(org.eclipse.m2m.atl.emftvm.GetSuper)}.
	 */
	@Test
	public void testCaseGetSuperGetSuper() {
		final GetSuper instruction = EmftvmFactory.eINSTANCE.createGetSuper();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Field field = EmftvmFactory.eINSTANCE.createField();
		instruction.setOwningBlock(owningBlock);
		owningBlock.setInitialiserFor(field);
		field.setEContext(EmftvmPackage.eINSTANCE.getExecEnv());

		final MethodVisitor result = getFixture().caseGetSuper(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetenv(org.eclipse.m2m.atl.emftvm.Getenv)}.
	 */
	@Test
	public void testCaseGetenvGetenv() {
		final Getenv instruction = EmftvmFactory.eINSTANCE.createGetenv();

		final MethodVisitor result = getFixture().caseGetenv(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseReturn(org.eclipse.m2m.atl.emftvm.Return)}.
	 */
	@Test
	public void testCaseReturnReturn() {
		final Return instruction = EmftvmFactory.eINSTANCE.createReturn();

		final MethodVisitor result = getFixture().caseReturn(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetcb(org.eclipse.m2m.atl.emftvm.Getcb)}.
	 */
	@Test
	public void testCaseGetcbGetcb() {
		final Getcb instruction = EmftvmFactory.eINSTANCE.createGetcb();

		final MethodVisitor result = getFixture().caseGetcb(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvokeAllCbs(org.eclipse.m2m.atl.emftvm.InvokeAllCbs)}.
	 */
	@Test
	public void testCaseInvokeAllCbsInvokeAllCbs() {
		final InvokeAllCbs instruction = EmftvmFactory.eINSTANCE.createInvokeAllCbs();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseInvokeAllCbs(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvokeCb(org.eclipse.m2m.atl.emftvm.InvokeCb)}.
	 */
	@Test
	public void testCaseInvokeCbInvokeCb() {
		final InvokeCb instruction = EmftvmFactory.eINSTANCE.createInvokeCb();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final CodeBlock codeBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		owningBlock.getNested().add(codeBlock);
		instruction.setOwningBlock(owningBlock);
		instruction.setCodeBlock(codeBlock);

		final MethodVisitor result = getFixture().caseInvokeCb(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseInvokeCbS(org.eclipse.m2m.atl.emftvm.InvokeCbS)}.
	 */
	@Test
	public void testCaseInvokeCbSInvokeCbS() {
		final InvokeCbS instruction = EmftvmFactory.eINSTANCE.createInvokeCbS();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseInvokeCbS(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseNot(org.eclipse.m2m.atl.emftvm.Not)}.
	 */
	@Test
	public void testCaseNotNot() {
		final Not instruction = EmftvmFactory.eINSTANCE.createNot();

		final MethodVisitor result = getFixture().caseNot(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseAnd(org.eclipse.m2m.atl.emftvm.And)}.
	 */
	@Test
	public void testCaseAndAnd() {
		final And instruction = EmftvmFactory.eINSTANCE.createAnd();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseAnd(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseOr(org.eclipse.m2m.atl.emftvm.Or)}.
	 */
	@Test
	public void testCaseOrOr() {
		final Or instruction = EmftvmFactory.eINSTANCE.createOr();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseOr(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseXor(org.eclipse.m2m.atl.emftvm.Xor)}.
	 */
	@Test
	public void testCaseXorXor() {
		final Xor instruction = EmftvmFactory.eINSTANCE.createXor();

		final MethodVisitor result = getFixture().caseXor(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseImplies(org.eclipse.m2m.atl.emftvm.Implies)}.
	 */
	@Test
	public void testCaseImpliesImplies() {
		final Implies instruction = EmftvmFactory.eINSTANCE.createImplies();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseImplies(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseIfte(org.eclipse.m2m.atl.emftvm.Ifte)}.
	 */
	@Test
	public void testCaseIfteIfte() {
		final Ifte instruction = EmftvmFactory.eINSTANCE.createIfte();
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		instruction.setOwningBlock(owningBlock);

		final MethodVisitor result = getFixture().caseIfte(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseIsnull(org.eclipse.m2m.atl.emftvm.Isnull)}.
	 */
	@Test
	public void testCaseIsnullIsnull() {
		final Isnull instruction = EmftvmFactory.eINSTANCE.createIsnull();

		final MethodVisitor result = getFixture().caseIsnull(instruction);

		assertNull(result);
	}

	/**
	 * Test method for {@link org.eclipse.m2m.atl.emftvm.jit.ByteCodeSwitch#caseGetenvtype(org.eclipse.m2m.atl.emftvm.Getenvtype)}.
	 */
	@Test
	public void testCaseGetenvtypeGetenvtype() {
		final Getenvtype instruction = EmftvmFactory.eINSTANCE.createGetenvtype();

		final MethodVisitor result = getFixture().caseGetenvtype(instruction);

		assertNull(result);
	}

	/**
	 * @return the fixture
	 */
	protected ByteCodeSwitch getFixture() {
		return fixture;
	}

	/**
	 * @param fixture the fixture to set
	 */
	protected void setFixture(final ByteCodeSwitch fixture) {
		this.fixture = fixture;
	}

}
