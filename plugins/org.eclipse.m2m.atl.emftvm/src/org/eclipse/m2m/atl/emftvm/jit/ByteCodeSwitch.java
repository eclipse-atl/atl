/*******************************************************************************
 * Copyright (c) 2011-2014 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.jit;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.Allinst;
import org.eclipse.m2m.atl.emftvm.AllinstIn;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.Delete;
import org.eclipse.m2m.atl.emftvm.Dup;
import org.eclipse.m2m.atl.emftvm.DupX1;
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
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.NewS;
import org.eclipse.m2m.atl.emftvm.Not;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Or;
import org.eclipse.m2m.atl.emftvm.Pop;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Pushf;
import org.eclipse.m2m.atl.emftvm.Pusht;
import org.eclipse.m2m.atl.emftvm.Remove;
import org.eclipse.m2m.atl.emftvm.Return;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.Swap;
import org.eclipse.m2m.atl.emftvm.SwapX1;
import org.eclipse.m2m.atl.emftvm.Xor;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch;
import org.eclipse.m2m.atl.emftvm.util.EnumConversionList;
import org.eclipse.m2m.atl.emftvm.util.EnumConversionListOnList;
import org.eclipse.m2m.atl.emftvm.util.EnumConversionSetOnSet;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyListOnList;
import org.eclipse.m2m.atl.emftvm.util.NativeTypes;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * Adds code to the given {@link MethodVisitor}, and returns it.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ByteCodeSwitch extends EmftvmSwitch<MethodVisitor> implements Opcodes {

	/**
	 * The map of primitive types to their boxed class counterpart type.
	 */
	public static final Map<Class<?>, Class<?>> BOXED_CLASSES = new HashMap<Class<?>, Class<?>>();

	static {
		BOXED_CLASSES.put(Void.TYPE, Void.class);
		BOXED_CLASSES.put(Boolean.TYPE, Boolean.class);
		BOXED_CLASSES.put(Character.TYPE, Character.class);
		BOXED_CLASSES.put(Byte.TYPE, Byte.class);
		BOXED_CLASSES.put(Short.TYPE, Short.class);
		BOXED_CLASSES.put(Integer.TYPE, Integer.class);
		BOXED_CLASSES.put(Long.TYPE, Long.class);
		BOXED_CLASSES.put(Float.TYPE, Float.class);
		BOXED_CLASSES.put(Double.TYPE, Double.class);
	}

	/**
	 * Returns the boxed version of <code>type</code>, or <code>type</code> if no boxing required.
	 * @param type the type to box
	 * @return the boxed version of <code>type</code>, or <code>type</code> if no boxing required
	 */
	public static Class<?> boxed(final Class<?> type) {
		if (BOXED_CLASSES.containsKey(type)) {
			return BOXED_CLASSES.get(type);
		}
		return type;
	}

	/**
	 * The {@link MethodVisitor} to add code to.
	 */
	protected final MethodVisitor mv;
	/**
	 * The {@link LabelSwitch} to look up generated labels.
	 */
	protected final LabelSwitch ls;
	/**
	 * The JIT compiler to generate instructions for.
	 */
	protected final CodeBlockJIT jit;
	/**
	 * Whether or not the current execution environment has a monitor attached.
	 */
	protected final boolean hasMonitor;
	/**
	 * Set of instructions to skip while generating bytecode.
	 */
	protected final java.util.Set<Instruction> skipInstructions = new HashSet<Instruction>();

	/**
	 * Creates a new {@link ByteCodeSwitch}.
	 * @param jit the JIT compiler to generate instructions for
	 * @param mv the {@link MethodVisitor} to add code to
	 * @param ls the {@link LabelSwitch} to look up generated labels
	 */
	public ByteCodeSwitch(final CodeBlockJIT jit, final MethodVisitor mv, final LabelSwitch ls) {
		super();
		this.jit = jit;
		this.mv = mv;
		this.ls = ls;
		this.hasMonitor = jit.getEnv().getMonitor() != null;
	}

	@Override
	public MethodVisitor caseInstruction(final Instruction object) {
		if (ls.hasWithTarget(object)) {
			label(ls.getFromTarget(object));
		}
		return mv;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor casePush(final Push object) {
		// Box primitive types
		if (object.getIntValue() != null) {
			generatePushInt(object.getIntValue());
			invokeStat(Integer.class, "valueOf", Integer.class, Type.INT_TYPE);
		} else if (object.getByteValue() != null) {
			generatePushInt(object.getByteValue());
			invokeStat(Byte.class, "valueOf", Byte.class, Type.BYTE_TYPE);
		} else if (object.getCharValue() != null) {
			generatePushInt(object.getCharValue());
			invokeStat(Character.class, "valueOf", Character.class, Type.CHAR_TYPE);
		} else if (object.getShortValue() != null) {
			generatePushInt(object.getShortValue());
			invokeStat(Short.class, "valueOf", Short.class, Type.SHORT_TYPE);
		} else if (object.getLongValue() != null) {
			mv.visitLdcInsn(object.getLongValue());
			invokeStat(Long.class, "valueOf", Long.class, Type.LONG_TYPE);
		} else if (object.getDoubleValue() != null) {
			mv.visitLdcInsn(object.getDoubleValue());
			invokeStat(Double.class, "valueOf", Double.class, Type.DOUBLE_TYPE);
		} else if (object.getFloatValue() != null) {
			mv.visitLdcInsn(object.getFloatValue());
			invokeStat(Float.class, "valueOf", Float.class, Type.FLOAT_TYPE);
		} else if (object.getEnumValue() != null) {
			new_(EnumLiteral.class); // [..., enum]
			dup(); // [..., enum, enum]
			ldc(object.getEnumValue()); // [..., enum, enum, name]
			invokeCons(EnumLiteral.class, String.class); // enum.<init>(name): [..., enum]
		} else if (object.getValue() != null) {
			ldc(object.getValue());
		} else {
			aconst_null(); // push null
		}
		return super.casePush(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor casePusht(final Pusht object) {
		iconst_1(); // true
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(true) 
		return super.casePusht(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor casePushf(final Pushf object) {
		iconst_0(); // false
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(false) 
		return super.casePushf(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor casePop(final Pop object) {
		pop();
		return super.casePop(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseLoad(final Load object) {
		aload(1); // [..., frame]
		if (object.getCbOffset() > 0) {
			generatePushInt(object.getCbOffset()); // [..., frame, cbOffset]
			generatePushInt(object.getSlot()); // [..., frame, cbOffset, slot]
			invokeVirt(StackFrame.class, "getLocal", Object.class, // frame.getLocal(cbOffset, slot) 
					Type.INT_TYPE, Type.INT_TYPE);
		} else {
			generatePushInt(object.getSlot()); // [..., frame, slot]
			invokeVirt(StackFrame.class, "getLocal", Object.class, // frame.getLocal(slot) 
					Type.INT_TYPE);
		}
		return super.caseLoad(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseStore(final Store object) {
		// [..., value]
		aload(1); // [..., value, frame]
		swap(); // [..., frame, value]
		if (object.getCbOffset() > 0) {
			generatePushInt(object.getCbOffset()); // [..., frame, value, cbOffset]
			generatePushInt(object.getSlot()); // [..., frame, value, cbOffset, slot]
			invokeVirt(StackFrame.class, "setLocal", Type.VOID_TYPE,  // frame.setLocal(value, cbOffset, slot)
					Object.class, Type.INT_TYPE, Type.INT_TYPE);
		} else {
			generatePushInt(object.getSlot()); // [..., frame, value, slot]
			invokeVirt(StackFrame.class, "setLocal", Type.VOID_TYPE,  // frame.setLocal(value, slot)
					Object.class, Type.INT_TYPE);
		}
		return super.caseStore(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseSet(final Set object) {
		// [..., o, v]
		aload(0); // this: [..., o, v, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, v, cb]
		aload(1); // frame: [..., o, v, cb, frame]
		ldc(object.getFieldname()); // [..., o, v, cb, frame, propname]
		invokeStat(JITCodeBlock.class, "set", Type.VOID_TYPE,  // set(o, v, cb, frame, propname)
				Object.class, Object.class, CodeBlock.class, StackFrame.class, String.class);
		return super.caseSet(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGet(final Get object) {
		generateSetPc(object);
		// [..., o]
		final Rule rule = object.getOwningBlock().getRule();
		final boolean hasRuleField = rule != null && rule.hasField(object.getFieldname());
		final boolean hasField = jit.getEnv().hasField(object.getFieldname());
		if (hasRuleField) {
			aload(0); // this: [..., o, this]
			getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, cb]
			aload(1); // frame: [..., o, cb, frame]
			ldc(object.getFieldname()); // [..., o, cb, frame, propname]
			invokeStat(JITCodeBlock.class, "get", Object.class,  // get(o, cb, frame, propname)
					Object.class, CodeBlock.class, StackFrame.class, String.class);
		} else if (hasField) {
			aload(1); // frame: [..., o, frame]
			ldc(object.getFieldname()); // [..., o, frame, propname]
			invokeStat(JITCodeBlock.class, "get", Object.class,  // get(o, frame, propname)
					Object.class, StackFrame.class, String.class);
		} else {
			aload(2); // env: [..., o, env]
			ldc(object.getFieldname()); // [..., o, env, propname]
			invokeStat(JITCodeBlock.class, "get", Object.class,  // get(o, env, propname)
					Object.class, ExecEnv.class, String.class);
		}
		return super.caseGet(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetTrans(final GetTrans object) {
		generateSetPc(object);
		// [..., o]
		aload(0); // this: [..., o, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, cb]
		aload(1); // frame: [..., o, cb, frame]
		ldc(object.getFieldname()); // [..., o, cb, frame, propname]
		invokeStat(JITCodeBlock.class, "getTrans", Object.class,  // getTrans(o, cb, frame, propname)
				Object.class, CodeBlock.class, StackFrame.class, String.class);
		return super.caseGetTrans(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseSetStatic(final SetStatic object) {
		// [..., o, v]
		aload(0); // this: [..., o, v, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, v, cb]
		aload(2); // env: [..., o, v, cb, env]
		ldc(object.getFieldname()); // [..., o, v, cb, env, propname]
		invokeStat(JITCodeBlock.class, "setStatic", Type.VOID_TYPE,  // setStatic(o, v, cb, env, propname)
				Object.class, Object.class, CodeBlock.class, ExecEnv.class, String.class);
		return super.caseSetStatic(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetStatic(final GetStatic object) {
		generateSetPc(object);
		// [..., o]
		aload(0); // this: [..., o, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, cb]
		aload(1); // frame: [..., o, cb, frame]
		ldc(object.getFieldname()); // [..., o, cb, frame, propname]
		invokeStat(JITCodeBlock.class, "getStatic", Object.class,  // getStatic(o, cb, frame, propname)
				Object.class, CodeBlock.class, StackFrame.class, String.class);
		return super.caseGetStatic(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseFindtype(final Findtype object) {
		// Native types can be found faster
		if (EMFTVMUtil.NATIVE.equals(object.getModelname())) {
			try {
				final Class<?> type = NativeTypes.findType(object.getTypename());
				final Instruction nextInstr = nextInstruction(object);
				if (nextInstr instanceof New) {
					new_(type);
					dup();
					invokeSpec(type, "<init>", Void.TYPE);
					skipInstructions.add(nextInstr);
				} else {
					ldc(Type.getType(type)); // [..., type]
				}
				return super.caseFindtype(object);
			} catch (ClassNotFoundException e) {
				// fall back - will generate same exception anyway
			}
		}
		aload(2); // env: [..., env]
		ldc(object.getModelname()) ; // [..., env, modelname]
		ldc(object.getTypename()) ; // [..., env, modelname, typename]
		invokeIface(ExecEnv.class, "findType", Object.class,  // env.findType(modelname, typename): [..., type]
				String.class, String.class);
		return super.caseFindtype(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseFindtypeS(final FindtypeS object) {
		// [..., modelname, typename]
		aload(2); // env: [..., modelname, typename, env]
		invokeStat(JITCodeBlock.class, "findTypeS", Object.class,  // findTypeS(modelname, typename, env): [..., type]
				String.class, String.class, ExecEnv.class);
		return super.caseFindtypeS(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseNew(final New object) {
		if (!skipInstructions.contains(object)) {
			// [..., type]
			final String modelName = object.getModelname();
			if (modelName == null) {
				aconst_null(); // [..., type, null]
			} else {
				ldc(object.getModelname()) ; // [..., type, modelname]
			}
			aload(2); // env: [..., type, modelname, env]
			invokeStat(JITCodeBlock.class, "newInstance", Object.class,  // newInstance(type, modelname, env): [..., object]
					Object.class, String.class, ExecEnv.class);
		}
		return super.caseNew(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseNewS(final NewS object) {
		// [..., type, modelname]
		checkcast(String.class); // [..., type, modelname]
		aload(2); // env: [..., type, modelname, env]
		invokeStat(JITCodeBlock.class, "newInstance", Object.class,  // newInstance(type, modelname, env): [..., object]
				Object.class, String.class, ExecEnv.class);
		return super.caseNewS(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseDelete(final Delete object) {
		// [..., object]
		checkcast(EObject.class); // [..., element]
		aload(1); // frame: [..., element, frame]
		invokeStat(JITCodeBlock.class, "delete", Type.VOID_TYPE,  // delete(element, frame): [...]
				EObject.class, StackFrame.class);
		return super.caseDelete(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseDup(final Dup object) {
		dup();
		return super.caseDup(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseDupX1(final DupX1 object) {
		dup_x1();
		return super.caseDupX1(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseSwap(final Swap object) {
		swap();
		return super.caseSwap(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseSwapX1(final SwapX1 object) {
		// [..., a, b, c]
		dup_x2(); // [..., c, a, b, c]
		pop(); // [..., c, a, b]
		swap(); // [..., c, b, a]
		return super.caseSwapX1(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseIf(final If object) {
		assert ls.hasWithSource(object);
		// Unbox the Boolean object
		checkcast(Boolean.class);
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // Boolean.booleanValue()
		ifne(ls.getFromSource(object)); // jump if bool != 0
		return super.caseIf(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseIfn(final Ifn object) {
		assert ls.hasWithSource(object);
		// Unbox the Boolean object
		checkcast(Boolean.class);
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // Boolean.booleanValue()
		ifeq(ls.getFromSource(object)); // jump if bool == 0
		return super.caseIfn(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGoto(final Goto object) {
		assert ls.hasWithSource(object);
		goto_(ls.getFromSource(object));
		return super.caseGoto(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseIterate(final Iterate object) {
		assert ls.hasWithSource(object);
		// Labels
		final Label hasNext = new Label();
		// Instructions
		checkcast(Collection.class); // [..., collection]
		invokeIface(Collection.class, "iterator", Iterator.class); // collection.iterator(): [..., iterator] 
		dup(); // [..., iterator, iterator]
		invokeIface(Iterator.class, "hasNext", Type.BOOLEAN_TYPE); // iterator.hasNext(): [..., iterator, boolean] 
		ifne(hasNext); // jump if hasNext bool != 0: [..., iterator]
		// has no next
		pop(); // [...]
		goto_(ls.getFromSource(object)); // jump over ENDITERATE
		// has next
		label(hasNext);
		dup(); // [..., iterator, iterator]
		invokeIface(Iterator.class, "next", Object.class); // iterator.next(): [..., iterator, object] 
		return super.caseIterate(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseEnditerate(final Enditerate object) {
		assert ls.hasWithSource(object);
		// Labels
		final Label hasNoNext = new Label();
		// Instructions
		dup(); // [..., iterator, iterator]
		invokeIface(Iterator.class, "hasNext", Type.BOOLEAN_TYPE); // iterator.hasNext(): [..., iterator, boolean] 
		ifeq(hasNoNext); // jump if hasNext bool == 0: [..., iterator]
		// has next
		dup(); // [..., iterator, iterator]
		invokeIface(Iterator.class, "next", Object.class); // iterator.next(): [..., iterator, object] 
		goto_(ls.getFromSource(object)); // jump over ITERATE
		// has no next
		label(hasNoNext); // [..., iterator]
		pop(); // [...]
		return super.caseEnditerate(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvoke(final Invoke object) {
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0:  generateInvoke0(object); break;
		case 1:  generateInvoke1(object); break;
		default: generateInvokeN(object, argcount);	break;	
		}
		return super.caseInvoke(object);
	}

	/**
	 * Generates bytecode for an INVOKE without arguments.
	 * @param object the INVOKE instruction
	 */
	private void generateInvoke0(final Invoke object) {
		// [..., self]
		final boolean hasOp = jit.getEnv().hasOperation(object.getOpname(), object.getArgcount());
		// Labels
		final Label selfStart = new Label();
		final Label selfEnd = new Label();
		// Local variable indexes
		final int selfIdx = 4;
		final int methodIdx = 5;
		final int bodyIdx = 6;
		final int subframeIdx = hasOp ? 6 : 5;
		final int vmExceptionIdx = subframeIdx + 1;
		final int exceptionIdx = vmExceptionIdx;
		// Bytecode
		label(selfStart);
		astore(selfIdx); // self: [...]
		if (hasOp) { // Generate Operation invocation code
			// Labels
			final Label ifOpNull = new Label();
			final Label bodyStart = new Label();
			// Bytecode
			aload(2); // env: [..., env]
			aload(selfIdx); // self: [..., env, self]
			invokeStat(EMFTVMUtil.class, "getArgumentType", Object.class, Object.class); // EMFTVMUtil.getArgumentType(self): [..., env, context]
			ldc(object.getOpname()); // [..., env, context, opname]
			invokeIface(ExecEnv.class, "findOperation", Operation.class,  // env.findOperation(context, opname): [..., op]
					Object.class, String.class);
			dup(); // [..., op, op]
			aload(selfIdx); // self: [..., op, op, self]
			ldc(object.getOpname()); // opname: [..., op, op, self, opname]
			invokeStat(EMFTVMUtil.class, "findNativeMethod", Method.class,  // EMFTVMUtil.findNativeMethod(op, self, opname): [..., op, method]
					Operation.class, Object.class, String.class);
			astore(methodIdx); // method: [..., op]
			aload(methodIdx); // method; [..., op, method]
			ifnonnull(ifOpNull); // jump if method != null: [..., op]
			dup(); // [..., op, op]
			ifnull(ifOpNull); // jump if op == null: [..., op]
			invokeIface(Operation.class, "getBody", CodeBlock.class); // op.getBody(): [..., body]
			label(bodyStart);
			astore(bodyIdx); // body: [...]
			aload(bodyIdx); // body: [..., body]
			aload(1); // frame: [..., body, frame]
			aload(bodyIdx); // body: [..., body, frame, body]
			aload(selfIdx); // self: [..., body, frame, body, self]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class,  // frame.getSubFrame(body, self): [..., body, newframe]
					CodeBlock.class, Object.class);
			invokeIface(CodeBlock.class, "execute", Object.class, StackFrame.class); // body.execute(newframe): [..., result]
			goto_(selfEnd); // jump to end
			label(ifOpNull); // [..., op]
			pop(); // [...]
			// Local variables
			localVariable("body", CodeBlock.class, bodyStart, ifOpNull, bodyIdx);
		}
		// Generate native method invocation code here
		final Method method = EMFTVMUtil.findRootMethod(object.getNativeMethod());
		if (method != null) { // native method recorded - try first
			// Labels
			final Label subframeStart = new Label();
			final Label tryStart = new Label();
			final Label tryEnd = new Label();
			final Label vmExceptionHandler = new Label();
			final Label exceptionHandler = new Label();
			final Label subframeNonNull = new Label();
			// Try-catch blocks
			tryCatchBlock(tryStart, vmExceptionHandler, vmExceptionHandler, VMException.class);
			tryCatchBlock(tryStart, vmExceptionHandler, exceptionHandler, Exception.class);
			// Bytecode
			label(subframeStart);
			aconst_null(); // [..., null]
			astore(subframeIdx); // subframe: [...]
			// Check context type (no need to unbox)
			final Class<?> dc = method.getDeclaringClass();
			if (!dc.equals(Object.class)) {
				aload(selfIdx); // self: [..., self]
				instanceof_(dc); // [..., boolean]
				ifeq(tryEnd); // jump if context type does not match: [...]
			}
			// start try-block with native Java INVOKE instruction
			label(tryStart); // [...]
			final int opcode;
			if (dc.isInterface()) {
				opcode = INVOKEINTERFACE;
			} else {
				opcode = INVOKEVIRTUAL;
			}
			aload(selfIdx); // self: [..., self]
			if (!dc.equals(Object.class)) {
				checkcast(dc); // [..., self]
				// Prepare self code block with subframe
				if (CodeBlock.class.isAssignableFrom(dc)) {
					generateSubFrame(method.toString()); // [..., self, subframe]
					astore(subframeIdx); // subframe: [..., self]
					dup(); // [..., self, self]
					aload(subframeIdx); // subframe: [..., self, self, subframe]
					invokeIface(CodeBlock.class, "setParentFrame", Type.VOID_TYPE,  // self.setParentFrame(subframe): [..., self]
							StackFrame.class);
				}
			}
			mv.visitMethodInsn(opcode, // self.<method>(): [..., ?]
					Type.getInternalName(dc), 
					method.getName(), 
					Type.getMethodDescriptor(method),
					dc.isInterface());
			// Check if method returned anything
			final Class<?> rt = method.getReturnType();
			// Box primitive return values
			generateBoxing(rt, dc); // [..., result]
			goto_(selfEnd); // jump over catch block: [..., result]
			// catch (VMException e)
			label(vmExceptionHandler); // [..., e]
			astore(vmExceptionIdx); // e: [...]
			aload(vmExceptionIdx); // e: [..., e]
			athrow(); // throw e
			// catch (Exception e)
			label(exceptionHandler); // [..., e]
			astore(exceptionIdx); // e
			new_(VMException.class); // new VMException(): [..., vme]
			dup(); // [..., vme, vme]
			aload(subframeIdx); // subframe: [..., vme, vme, subframe]
			dup(); // [..., vme, vme, subframe, subframe]
			ifnonnull(subframeNonNull); // jump if subframe != null: [..., vme, vme, subframe]
			pop(); // [..., vme, vme]
			generateSubFrame(method.toString()); // [..., vme, vme, subframe]
			label(subframeNonNull); // [..., vme, vme, subframe]
			aload(exceptionIdx); // e: [..., vme, vme, subframe, e]
			invokeCons(VMException.class, StackFrame.class, Throwable.class); // new VMException(subframe, e): [vme, ...]
			athrow(); // throw vme
			// end of try-catch
			label(tryEnd); // [...]
			if (!dc.equals(Object.class)) {
				// Fall back to reflective invocation
				ldc("JIT miss for " + method.toString()); // [..., msg]
				invokeStat(ATLLogger.class, "info", Type.VOID_TYPE, String.class); // ATLLogger.info(msg): [...]
				aload(1); // frame: [..., frame]
				aload(selfIdx); // self: [..., frame, self]
				ldc(object.getOpname()); // opname: [..., frame, self, opname]
				if (hasOp) {
					aload(methodIdx); // method; [..., frame, self, opname, method]
					invokeStat(JITCodeBlock.class, "invokeNative", Object.class, // JITCodeBlock.invokeNative(frame, self, opname, method): [..., result]
							StackFrame.class, Object.class, String.class, Method.class);
				} else {
					invokeStat(EMFTVMUtil.class, "invokeNative", Object.class, // EMFTVMUtil.invokeNative(frame, self, opname): [..., result]
							StackFrame.class, Object.class, String.class);
				}
			}
			// end of instructions
			label(selfEnd); // [..., result]
			// Local variables
			localVariable("self", Object.class, selfStart, selfEnd, selfIdx);
			if (hasOp) {
				localVariable("method", Method.class, selfStart, selfEnd, methodIdx);
			}
			localVariable("subframe", StackFrame.class, subframeStart, selfEnd, subframeIdx);
			localVariable("e", VMException.class, vmExceptionHandler, exceptionHandler, vmExceptionIdx);
			localVariable("e", Exception.class, exceptionHandler, selfEnd, exceptionIdx);
		} else {
			aload(1); // frame: [..., frame]
			aload(selfIdx); // self: [..., frame, self]
			ldc(object.getOpname()); // opname: [..., frame, self, opname]
			if (hasOp) {
				aload(methodIdx); // method; [..., frame, self, opname, method]
				invokeStat(JITCodeBlock.class, "invokeNative", Object.class, // JITCodeBlock.invokeNative(frame, self, opname, method): [..., result]
						StackFrame.class, Object.class, String.class, Method.class);
			} else {
				invokeStat(EMFTVMUtil.class, "invokeNative", Object.class, // EMFTVMUtil.invokeNative(frame, self, opname): [..., result]
						StackFrame.class, Object.class, String.class);
			}
			label(selfEnd); // [..., result]
			// Local variables
			localVariable("self", Object.class, selfStart, selfEnd, selfIdx);
			if (hasOp) {
				localVariable("method", Method.class, selfStart, selfEnd, methodIdx);
			}
		}
	}

	/**
	 * Generates bytecode for an INVOKE with one argument.
	 * @param object the INVOKE instruction
	 */
	private void generateInvoke1(final Invoke object) {
		// [..., self, arg]
		final boolean hasOp = jit.getEnv().hasOperation(object.getOpname(), object.getArgcount());
		// Labels
		final Label selfStart = new Label();
		final Label selfEnd = new Label();
		// Local variable indexes
		final int selfIdx = 4;
		final int argIdx = 5;
		final int methodIdx = 6;
		final int bodyIdx = 7;
		final int subframeIdx = hasOp ? 7 : 6;
		final int vmExceptionIdx = subframeIdx + 1;
		final int exceptionIdx = vmExceptionIdx;
		// Bytecode
		label(selfStart);
		astore(argIdx); // arg: [..., self]
		astore(selfIdx); // self: [...]
		if (hasOp) { // Generate Operation invocation code
			// Labels
			final Label ifOpNull = new Label();
			final Label bodyStart = new Label();
			// Bytecode
			aload(2); // env: [..., env]
			aload(selfIdx); // self: [..., env, self]
			invokeStat(EMFTVMUtil.class, "getArgumentType", Object.class, Object.class); // EMFTVMUtil.getArgumentType(self): [..., env, context]
			ldc(object.getOpname()); // [..., env, context, opname]
			aload(argIdx); // arg: [..., env, context, opname, arg]
			invokeStat(EMFTVMUtil.class, "getArgumentType", Object.class, Object.class); // EMFTVMUtil.getArgumentType(arg): [..., env, context, opname, argtype]
			invokeIface(ExecEnv.class, "findOperation", Operation.class,  // env.findOperation(context, opname, argtype): [..., op]
					Object.class, String.class, Object.class);
			dup(); // [..., op, op]
			aload(selfIdx); // self: [..., op, op, self]
			ldc(object.getOpname()); // opname: [..., op, op, self, opname]
			aload(argIdx); // arg: [..., op, op, self, opname, arg]
			invokeStat(EMFTVMUtil.class, "findNativeMethod", Method.class,  // EMFTVMUtil.findNativeMethod(op, self, opname, arg): [..., op, method]
					Operation.class, Object.class, String.class, Object.class);
			astore(methodIdx); // method: [..., op]
			aload(methodIdx); // method; [..., op, method]
			ifnonnull(ifOpNull); // jump if method != null: [..., op]
			dup(); // [..., op, op]
			ifnull(ifOpNull); // jump if op == null: [..., op]
			invokeIface(Operation.class, "getBody", CodeBlock.class); // op.getBody(): [..., body]
			label(bodyStart);
			astore(bodyIdx); // body: [...]
			aload(bodyIdx); // body: [..., body]
			aload(1); // frame: [..., body, frame]
			aload(bodyIdx); // body: [..., body, frame, body]
			aload(selfIdx); // self: [..., body, frame, body, self]
			aload(argIdx); // arg: [..., body, frame, body, self, arg]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class,  // frame.getSubFrame(body, self, arg): [..., body, newframe]
					CodeBlock.class, Object.class, Object.class);
			invokeIface(CodeBlock.class, "execute", Object.class, StackFrame.class); // body.execute(newframe): [..., result]
			goto_(selfEnd); // jump to end
			label(ifOpNull); // [..., op]
			pop(); // [...]
			// Local variables
			localVariable("body", CodeBlock.class, bodyStart, ifOpNull, bodyIdx);
		}
		// Generate native method invocation code here
		final Method method = EMFTVMUtil.findRootMethod(object.getNativeMethod());
		if (method != null) { // native method recorded - try first
			// Labels
			final Label subframeStart = new Label();
			final Label tryStart = new Label();
			final Label tryEnd = new Label();
			final Label vmExceptionHandler = new Label();
			final Label exceptionHandler = new Label();
			final Label subframeNonNull = new Label();
			// Try-catch blocks
			tryCatchBlock(tryStart, vmExceptionHandler, vmExceptionHandler, VMException.class);
			tryCatchBlock(tryStart, vmExceptionHandler, exceptionHandler, Exception.class);
			// Bytecode
			label(subframeStart);
			aconst_null(); // [..., null]
			astore(subframeIdx); // subframe: [...]
			// Check context type (no need to unbox)
			final Class<?> dc = method.getDeclaringClass();
			if (!dc.equals(Object.class)) {
				aload(selfIdx); // self: [..., self]
				instanceof_(dc); // [..., boolean]
				ifeq(tryEnd); // jump if context type does not match: [...]
			}
			final Class<?> pc = method.getParameterTypes()[0];
			if (!pc.equals(Object.class)) {
				aload(argIdx); // arg: [..., arg]
				instanceof_(boxed(pc)); // [..., boolean]
				ifeq(tryEnd); // jump if arg type does not match: [...]
			}
			// start try-block with native Java INVOKE instruction
			label(tryStart); // [...]
			final int opcode;
			if (dc.isInterface()) {
				opcode = INVOKEINTERFACE;
			} else {
				opcode = INVOKEVIRTUAL;
			}
			// Prepare subframe
			if (CodeBlock.class.isAssignableFrom(dc) || CodeBlock.class.isAssignableFrom(pc)) {
				generateSubFrame(method.toString()); // [..., subframe]
				astore(subframeIdx); // subframe: [...]
			}
			aload(selfIdx); // self: [..., self]
			if (!dc.equals(Object.class)) {
				checkcast(dc); // [..., self]
				// Prepare self code block with subframe
				if (CodeBlock.class.isAssignableFrom(dc)) {
					dup(); // [..., self, self]
					aload(subframeIdx); // subframe: [..., self, self, subframe]
					invokeIface(CodeBlock.class, "setParentFrame", Type.VOID_TYPE, StackFrame.class); // self.setParentFrame(subframe): [..., self]
				}
			}
			aload(argIdx); // arg: [..., self, arg]
			// Method parameter unboxing
			if (!pc.equals(Object.class)) {
				generateUnboxing(pc); // [..., self, arg]
				// Prepare self code block with subframe
				if (CodeBlock.class.isAssignableFrom(pc)) {
					dup(); // [..., self, arg, arg]
					aload(subframeIdx); // subframe: [..., self, arg, arg, subframe]
					invokeIface(CodeBlock.class, "setParentFrame", Type.VOID_TYPE, StackFrame.class); // arg.setParentFrame(subframe): [..., self, arg]
				}
			}
			mv.visitMethodInsn(opcode, // self.<method>(arg): [..., ?]
					Type.getInternalName(dc), 
					method.getName(), 
					Type.getMethodDescriptor(method),
					dc.isInterface());
			// Check if method returned anything
			final Class<?> rt = method.getReturnType();
			// Box primitive return values
			generateBoxing(rt, dc); // [..., result]
			goto_(selfEnd); // jump over catch block: [..., result]
			// catch (VMException e)
			label(vmExceptionHandler); // [..., e]
			astore(vmExceptionIdx); // e: [...]
			aload(vmExceptionIdx); // e: [..., e]
			athrow(); // throw e
			// catch (Exception e)
			label(exceptionHandler); // [..., e]
			astore(exceptionIdx); // e
			new_(VMException.class); // new VMException(): [..., vme]
			dup(); // [..., vme, vme]
			aload(subframeIdx); // subframe: [..., vme, vme, subframe]
			dup(); // [..., vme, vme, subframe, subframe]
			ifnonnull(subframeNonNull); // jump if subframe != null: [..., vme, vme, subframe]
			pop(); // [..., vme, vme]
			generateSubFrame(method.toString()); // [..., vme, vme, subframe]
			label(subframeNonNull); // [..., vme, vme, subframe]
			aload(exceptionIdx); // e: [..., vme, vme, subframe, e]
			invokeCons(VMException.class, StackFrame.class, Throwable.class); // vme.<init>(subframe, e): [..., vme]
			athrow(); // throw vme
			// end of try-catch
			label(tryEnd); // [...]
			if (!dc.equals(Object.class) || !pc.equals(Object.class)) {
				// Fall back to reflective invocation
				ldc("JIT miss for " + method.toString()); // [..., msg]
				invokeStat(ATLLogger.class, "info", Type.VOID_TYPE, String.class); // ATLLogger.info(msg): [...]
				aload(1); // frame: [..., frame]
				aload(selfIdx); // self: [..., frame, self]
				ldc(object.getOpname()); // opname: [..., frame, self, opname]
				aload(argIdx); // arg: [..., frame, self, opname, arg]
				if (hasOp) {
					aload(methodIdx); // method; [..., frame, self, opname, method]
					invokeStat(JITCodeBlock.class, "invokeNative", Object.class, // JITCodeBlock.invokeNative(frame, self, opname, arg, method): [..., result]
							StackFrame.class, Object.class, String.class, Object.class, Method.class);
				} else {
					invokeStat(EMFTVMUtil.class, "invokeNative", Object.class,  // EMFTVMUtil.invokeNative(frame, self, opname, arg): [..., result]
							StackFrame.class, Object.class, String.class, Object.class);
				}
			}
			// end of instructions
			label(selfEnd); // [..., result]
			// Local variables
			localVariable("self", Object.class, selfStart, selfEnd, selfIdx);
			localVariable("arg", Object.class, selfStart, selfEnd, argIdx);
			if (hasOp) {
				localVariable("method", Method.class, selfStart, selfEnd, methodIdx);
			}
			localVariable("subframe", StackFrame.class, subframeStart, selfEnd, subframeIdx);
			localVariable("e", VMException.class, vmExceptionHandler, exceptionHandler, vmExceptionIdx);
			localVariable("e", Exception.class, exceptionHandler, selfEnd, exceptionIdx);
		} else {
			aload(1); // frame: [..., frame]
			aload(selfIdx); // self: [..., frame, self]
			ldc(object.getOpname()); // opname: [..., frame, self, opname]
			aload(argIdx); // arg: [..., frame, self, opname, arg]
			if (hasOp) {
				aload(methodIdx); // method; [..., frame, self, opname, arg, method]
				invokeStat(JITCodeBlock.class, "invokeNative", Object.class, // JITCodeBlock.invokeNative(frame, self, opname, arg, method): [..., result]
						StackFrame.class, Object.class, String.class, Object.class, Method.class);
			} else {
				invokeStat(EMFTVMUtil.class, "invokeNative", Object.class,  // EMFTVMUtil.invokeNative(frame, self, opname, arg): [..., result]
						StackFrame.class, Object.class, String.class, Object.class);
			}
			label(selfEnd); // [..., result]
			// Local variables
			localVariable("self", Object.class, selfStart, selfEnd, selfIdx);
			localVariable("arg", Object.class, selfStart, selfEnd, argIdx);
			if (hasOp) {
				localVariable("method", Method.class, selfStart, selfEnd, methodIdx);
			}
		}
	}

	/**
	 * Generates bytecode for an INVOKE with <code>argcount</code> arguments.
	 * @param object the INVOKE instruction
	 * @param argcount the number of arguments
	 */
	private void generateInvokeN(final Invoke object, final int argcount) {
		// [..., self, args]
		final boolean hasOp = jit.getEnv().hasOperation(object.getOpname(), object.getArgcount());
		// Labels
		final Label selfStart = new Label();
		final Label selfEnd = new Label();
		// Local variable indexes
		final int selfIdx = 4;
		final int argsIdx = 5;
		final int methodIdx = 6;
		final int bodyIdx = 7;
		// Bytecode
		generatePushInt(argcount); // [..., self, args, argcount]
		anewarray(Object.class); // new Object[argcount]: [..., self, args, array]
		for (int i = 0; i < argcount; i++) {
			dup_x1(); // copy array ref below value: [..., self, args, array, arg, array]
			swap(); // swap arg over array ref: [..., self, args, array, array, arg]
			generatePushInt(argcount - 1 - i); // index: [..., self, args, array, array, arg, index]
			swap(); // swap index over arg: [..., self, args, array, array, index, arg]
			aastore(); // store: [..., self, args, array]
		} // no more args: [..., self, array]
		label(selfStart);
		astore(argsIdx); // args: [..., self]
		astore(selfIdx); // self: [...]
		if (hasOp) { // Generate Operation invocation code
			// Labels
			final Label ifOpNull = new Label();
			final Label bodyStart = new Label();
			// Bytecode
			aload(2); // env: [..., env]
			aload(selfIdx); // self: [..., env, self]
			invokeStat(EMFTVMUtil.class, "getArgumentType", Object.class, Object.class); // EMFTVMUtil.getArgumentType(self): [..., env, context]
			ldc(object.getOpname()); // [..., env, context, opname]
			aload(argsIdx); // args: [..., env, context, opname, args]
			invokeStat(EMFTVMUtil.class, "getArgumentTypes", Object[].class, Object[].class); // EMFTVMUtil.getArgumentTypes(args): [..., env, context, opname, argtypes]
			invokeIface(ExecEnv.class, "findOperation", Operation.class, Object.class, String.class, Object[].class); // env.findOperation(context, opname, argtypes): [..., op]
			dup(); // [..., op, op]
			aload(selfIdx); // self: [..., op, op, self]
			ldc(object.getOpname()); // opname: [..., op, op, self, opname]
			aload(argsIdx); // args: [..., op, op, self, opname, args]
			invokeStat(EMFTVMUtil.class, "findNativeMethod", Method.class,  // EMFTVMUtil.findNativeMethod(op, self, opname, args): [..., op, method]
					Operation.class, Object.class, String.class, Object[].class);
			astore(methodIdx); // method: [..., op]
			aload(methodIdx); // method; [..., op, method]
			ifnonnull(ifOpNull); // jump if method != null: [..., op]
			dup(); // [..., op, op]
			ifnull(ifOpNull); // jump if op == null: [..., op]
			invokeIface(Operation.class, "getBody", CodeBlock.class); // op.getBody(): [..., body]
			label(bodyStart);
			astore(bodyIdx); // body: [...]
			aload(bodyIdx); // body: [..., body]
			aload(1); // frame: [..., body, frame]
			aload(bodyIdx); // body: [..., body, frame, body]
			aload(selfIdx); // self: [..., body, frame, body, self]
			aload(argsIdx); // args: [..., body, frame, body, self, args]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class,  // frame.getSubFrame(body, self, args): [..., body, newframe]
					CodeBlock.class, Object.class, Object[].class);
			invokeIface(CodeBlock.class, "execute", Object.class, StackFrame.class); // body.execute(newframe): [..., result]
			goto_(selfEnd); // jump to end
			label(ifOpNull); // [..., op]
			pop(); // [...]
			// Local variables
			localVariable("body", CodeBlock.class, bodyStart, ifOpNull, bodyIdx);
		}
		// Generate native method invocation code here
		aload(1); // frame: [..., frame]
		aload(selfIdx); // self: [..., frame, self]
		ldc(object.getOpname()); // opname: [..., frame, self, opname]
		aload(argsIdx); // args: [..., frame, self, opname, args]
		if (hasOp) {
			aload(methodIdx); // method; [..., frame, self, opname, args, method]
			invokeStat(JITCodeBlock.class, "invokeNative", Object.class, // JITCodeBlock.invokeNative(frame, self, opname, args, method): [..., result]
					StackFrame.class, Object.class, String.class, Object[].class, Method.class);
		} else {
			invokeStat(EMFTVMUtil.class, "invokeNative", Object.class,  // EMFTVMUtil.invokeNative(frame, self, opname, args): [..., result]
					StackFrame.class, Object.class, String.class, Object[].class);
		}
		label(selfEnd); // [..., result]
		// Local variables
		localVariable("self", Object.class, selfStart, selfEnd, selfIdx);
		localVariable("args", Object[].class, selfStart, selfEnd, argsIdx);
		if (hasOp) {
			localVariable("method", Method.class, selfStart, selfEnd, methodIdx);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvokeSuper(final InvokeSuper object) {
		// Pre-calc context type and perform checks
		final Operation op = object.getOwningBlock().getOperation();
		if (op == null) {
			throw new IllegalArgumentException("INVOKE_SUPER can only be used in operations");
		}
		final EClassifier context = op.getEContext();
		if (context == null) {
			throw new IllegalArgumentException(String.format("Operation misses context type: %s", op));
		}
		if (!(context instanceof EClass) && context.getInstanceClass() == null) {
			throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", context));
		}

		// Generate bytecode
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [..., self]
			aload(0); // [..., self, this]
			if (!(context instanceof EClass)) {
				getField(JITCodeBlock.class, "context", Class.class); // [..., self, context]
				aload(1); // frame: [..., self, context, frame]
				ldc(object.getOpname()); // [..., self, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, context, frame, opname)
						Object.class, Class.class, StackFrame.class, String.class);
			} else {
				getField(JITCodeBlock.class, "eContext", EClass.class); // [..., self, context]
				aload(1); // frame: [..., self, context, frame]
				ldc(object.getOpname()); // [..., self, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, context, frame, opname)
						Object.class, EClass.class, StackFrame.class, String.class);
			}
			break;
		case 1: // [..., self, arg]
			aload(0); // [..., self, arg, this]
			if (!(context instanceof EClass)) {
				getField(JITCodeBlock.class, "context", Class.class); // [..., self, context]
				aload(1); // frame: [..., self, arg, context, frame]
				ldc(object.getOpname()); // [..., self, arg, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, arg, context, frame, opname)
						Object.class, Object.class, Class.class, StackFrame.class, String.class);
			} else {
				getField(JITCodeBlock.class, "eContext", EClass.class); // [..., self, context]
				aload(1); // frame: [..., self, arg, context, frame]
				ldc(object.getOpname()); // [..., self, arg, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, arg, context, frame, opname)
						Object.class, Object.class, EClass.class, StackFrame.class, String.class);
			}
			break;
		default: // [..., self, args]
			generatePushInt(argcount); // [..., self, args, argcount]
			anewarray(Object.class); // new Object[argcount]: [..., self, args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., self, args, array, arg, array]
				swap(); // swap arg over array ref: [..., self, args, array, array, arg]
				generatePushInt(argcount - 1 - i); // index: [..., self, args, array, array, arg, index]
				swap(); // swap index over arg: [..., self, args, array, array, index, arg]
				aastore(); // store: [..., self, args, array]
			} // no more args: [..., self, array]
			aload(0); // [..., self, array, this]
			if (!(context instanceof EClass)) {
				getField(JITCodeBlock.class, "context", Class.class); // [..., self, array, context]
				aload(1); // frame: [..., self, array, context, frame]
				ldc(object.getOpname()); // [..., self, array, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, array, context, frame, opname)
						Object.class, Object[].class, Class.class, StackFrame.class, String.class);
			} else {
				getField(JITCodeBlock.class, "eContext", EClass.class); // [..., self, array, context]
				aload(1); // frame: [..., self, array, context, frame]
				ldc(object.getOpname()); // [..., self, array, context, frame, opname]
				invokeStat(JITCodeBlock.class, "invokeSuper", Object.class, // invokeSuper(self, array, context, frame, opname)
						Object.class, Object[].class, EClass.class, StackFrame.class, String.class);
			}
			break;	
		}
		return super.caseInvokeSuper(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvokeStatic(final InvokeStatic object) {
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [..., type]
			aload(1); // frame: [..., type, frame]
			ldc(object.getOpname()); // [..., type, frame, opname]
			invokeStat(JITCodeBlock.class, "invokeStatic", Object.class, // invokeStatic(type, frame, opname)
					Object.class, StackFrame.class, String.class);
			break;
		case 1: // [..., type, arg]
			aload(1); // frame: [..., type, arg, frame]
			ldc(object.getOpname()); // [..., type, arg, frame, opname]
			invokeStat(JITCodeBlock.class, "invokeStatic", Object.class, // invokeStatic(type, arg, frame, opname)
					Object.class, Object.class, StackFrame.class, String.class);
			break;
		default: // [..., type, args]
			generatePushInt(argcount); // [..., type, args, argcount]
			anewarray(Object.class); // new Object[argcount]: [..., type, args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., type, args, array, arg, array]
				swap(); // swap arg over array ref: [..., type, args, array, array, arg]
				generatePushInt(argcount - 1 - i); // index: [..., type, args, array, array, arg, index]
				swap(); // swap index over arg: [..., type, args, array, array, index, arg]
				aastore(); // store: [..., type, args, array]
			} // no more args: [..., type, array]
			aload(1); // frame: [..., type, array, frame]
			ldc(object.getOpname()); // [..., type, array, frame, opname]
			invokeStat(JITCodeBlock.class, "invokeStatic", Object.class, // invokeStatic(type, array, frame, opname)
					Object.class, Object[].class, StackFrame.class, String.class);
			break;	
		}
		return super.caseInvokeStatic(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseAllinst(final Allinst object) {
		// [..., type]
		checkcast(EClass.class); // [..., type]
		aload(2); // env: [..., type, env]
		invokeStat(EMFTVMUtil.class, "findAllInstances", LazyList.class, // EMFTVMUtil.findAllInstances(type, env)
				EClass.class, ExecEnv.class);
		return super.caseAllinst(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseAllinstIn(final AllinstIn object) {
		// [..., type, modelName]
		swap(); // [..., modelName, type]
		checkcast(EClass.class); // [..., modelName, type]
		aload(2); // env: [..., modelName, type, env]
		invokeStat( // EMFTVMUtil.findAllInstances(modelName, type, env) 
				EMFTVMUtil.class, "findAllInstIn", LazyList.class,
				Object.class, EClass.class, ExecEnv.class);
		return super.caseAllinstIn(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseMatch(final Match object) {
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [...]
			aload(1); // frame: [..., frame]
			ldc(object.getRulename()); // [..., frame, rulename]
			invokeStat(JITCodeBlock.class, "matchOne", Object.class, // matchOne(frame, rulename)
					StackFrame.class, String.class);
			break;
		default: // [..., args]
			generatePushInt(argcount); // [..., args, argcount]
			anewarray(EObject.class); // new EObject[argcount]: [..., args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., args, array, arg, array]
				swap(); // swap arg over array ref: [..., args, array, array, arg]
				checkcast(EObject.class); // [..., args, array, array, earg]
				generatePushInt(argcount - 1 - i); // index: [..., args, array, array, earg, index]
				swap(); // swap index over arg: [..., args, array, array, index, earg]
				aastore(); // store: [..., args, array]
			} // no more args: [..., array]
			aload(1); // frame: [..., array, frame]
			ldc(object.getRulename()); // [..., array, frame, rulename]
			invokeStat(JITCodeBlock.class, "matchOne", Object.class, // matchOne(array, frame, rulename)
					Object[].class, StackFrame.class, String.class);
			break;	
		}
		return super.caseMatch(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseMatchS(final MatchS object) {
		generateSetPc(object);
		checkcast(Rule.class); // [..., rule]
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [..., rule]
			aload(1); // frame: [..., rule, frame]
			invokeStat(JITCodeBlock.class, "matchOne", Object.class, // matchOne(rule, frame)
					Rule.class, StackFrame.class);
			break;
		default: // [..., args, rule]
			generatePushInt(argcount); // [..., args, rule, argcount]
			anewarray(EObject.class); // new EObject[argcount]: [..., args, rule, array]
			swap(); // swap array ref over rule: [..., args, array, rule]
			for (int i = 0; i < argcount; i++) {
				dup_x2(); // copy rule below first arg: [..., args, rule, arg, array, rule]
				pop(); // pop rule: [..., args, rule, arg, array]
				dup_x2(); // copy array ref below rule: [..., args, array, rule, arg, array]
				swap(); // swap arg over array ref: [..., args, array, rule, array, arg]
				checkcast(EObject.class); // [..., args, array, rule, array, earg]
				generatePushInt(argcount - 1 - i); // index: [..., args, array, rule, array, earg, index]
				swap(); // swap index over arg: [..., args, array, rule, array, index, earg]
				aastore(); // store: [..., args, array, rule]
			} // no more args: [..., array, rule]
			aload(1); // frame: [..., array, rule, frame]
			invokeStat(JITCodeBlock.class, "matchOne", Object.class, // matchOne(array, rule, frame)
					Object[].class, Rule.class, StackFrame.class);
			break;	
		}
		return super.caseMatchS(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseAdd(final Add object) {
		// [..., o, v]
		generatePushInt(-1); // [..., o, v, -1]
		ldc(object.getFieldname()); // [..., o, v, -1, fieldName]
		aload(0); // this: [..., o, v, -1, fieldName, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, v, -1, fieldName, cb]
		aload(1); // frame: [..., o, v, -1, fieldName, cb, frame]
		invokeStat(JITCodeBlock.class, "add", Type.VOID_TYPE, // add(o, v, -1, fieldName, cb, frame)
				Object.class, Object.class, Type.INT_TYPE, String.class, CodeBlock.class, StackFrame.class);
		return super.caseAdd(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseRemove(final Remove object) {
		// [..., o, v]
		ldc(object.getFieldname()); // [..., o, v, fieldName]
		aload(0); // this: [..., o, v, fieldName, this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, v, fieldName, cb]
		aload(1); // frame: [..., o, v, fieldName, cb, frame]
		invokeStat(JITCodeBlock.class, "remove", Type.VOID_TYPE, // remove(o, v, fieldName, cb, frame)
				Object.class, Object.class, String.class, CodeBlock.class, StackFrame.class);
		return super.caseRemove(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInsert(final Insert object) {
		// [..., o, v, index]
		// Unbox the Integer object
		checkcast(Integer.class); // [..., o, v, index]
		invokeVirt(Integer.class, "intValue", Type.INT_TYPE); // Integer.intValue(): // [..., o, v, index]
		ldc(object.getFieldname()); // [..., o, v, index, fieldName]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., o, v, index, fieldName, cb]
		aload(1); // frame: [..., o, v, index, fieldName, cb, frame]
		invokeStat(JITCodeBlock.class, "add", Type.VOID_TYPE, // add(o, v, index, fieldName, cb, frame)
				Object.class, Object.class, Type.INT_TYPE, String.class, CodeBlock.class, StackFrame.class);
		return super.caseInsert(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetSuper(final GetSuper object) {
		// Pre-calc context type and perform checks
		final Field fieldCtx = object.getOwningBlock().getField();
		if (fieldCtx == null) {
			throw new IllegalArgumentException("GET_SUPER can only be used in fields");
		}
		final EClassifier context = fieldCtx.getEContext();
		if (context == null) {
			throw new IllegalArgumentException(String.format("Field misses context type: %s", fieldCtx));
		}
		if (!(context instanceof EClass) && context.getInstanceClass() == null) {
			throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", context));
		}

		// Generate bytecode
		generateSetPc(object);
		// [..., o]
		aload(0); // this: [..., o, this]
		if (!(context instanceof EClass)) {
			getField(JITCodeBlock.class, "context", Class.class); // [..., o, context]
			ldc(object.getFieldname()); // [..., o, context, propname]
			aload(1); // frame: [..., o, context, propname, frame]
			invokeStat(JITCodeBlock.class, "getSuper", Object.class, // getSuper(o, context, propname, frame)
					Object.class, Class.class, String.class, StackFrame.class);
		} else {
			getField(JITCodeBlock.class, "eContext", EClass.class); // [..., o, context]
			ldc(object.getFieldname()); // [..., o, context, propname]
			aload(1); // frame: [..., o, context, propname, frame]
			invokeStat(JITCodeBlock.class, "getSuper", Object.class, // getSuper(o, context, propname, frame)
					Object.class, EClass.class, String.class, StackFrame.class);
		}
		return super.caseGetSuper(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetenv(final Getenv object) {
		aload(2); // env: [..., env]
		return super.caseGetenv(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseReturn(final Return object) {
		aload(1); // frame
		areturn();
		return super.caseReturn(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetcb(final Getcb object) {
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "cb", CodeBlock.class); // [..., cb]
		invokeIface(CodeBlock.class, "getNested", EList.class); // cb.getNested(): [..., elist]
		generatePushInt(object.getCbIndex()); // [..., elist, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // elist.get(index): [..., nestedCb]
		return super.caseGetcb(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvokeAllCbs(final InvokeAllCbs object) {
		final EList<CodeBlock> nested = object.getOwningBlock().getNested();
		// Define labels
		final Label argStart = new Label();
		final Label loopStart = new Label();
		final Label loopEnd = new Label();
		// Generate bytecode
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			// unrolled loop start
			label(loopStart);
			for (int i = 0; i < nested.size(); i++) {
				dup(); // [..., nested, nested]
				generatePushInt(i); // [..., nested, nested, index]
				invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., nested, object]
				checkcast(CodeBlock.class); // [..., nested, ncb]
				astore(4); // ncb: [..., nested]
				aload(4); // ncb: [..., nested, ncb]
				new_(StackFrame.class); // [..., nested, ncb, newframe]
				dup(); // [..., nested, ncb, newframe, newframe]
				aload(1); // frame: [..., nested, ncb, newframe, newframe, frame]
				aload(4); // ncb: [..., nested, ncb, newframe, newframe, frame, ncb]
				invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., nested, ncb, newframe]
				invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., nested, newframe]
				if (nested.get(i).getStackLevel() > 0) { // returns value
					invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., nested, result]
					swap(); // swap result under nested: [..., result, nested]
				} else {
					pop(); // remove newframe: [..., nested]
				}
				// [..., results, nested]
			}
			// unrolled loop end
			label(loopEnd);
			pop(); // remove nested: [..., results]
			break;
		case 1: // [..., arg]
			label(argStart);
			astore(5); // arg: [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			// unrolled loop start
			label(loopStart);
			for (int i = 0; i < nested.size(); i++) {
				dup(); // [..., nested, nested]
				generatePushInt(i); // [..., nested, nested, index]
				invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., nested, object]
				checkcast(CodeBlock.class); // [..., nested, ncb]
				astore(4); // ncb: [..., nested]
				aload(4); // ncb: [..., nested, ncb]
				aload(1); // frame: [..., nested, ncb, frame]
				aload(4); // ncb: [..., nested, ncb, frame, ncb]
				aload(5); // arg: [..., nested, ncb, frame, ncb, arg]
				invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, arg): [..., nested, ncb, newframe]
						CodeBlock.class, Object.class);
				invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., nested, newframe]
				if (nested.get(i).getStackLevel() > 0) { // returns value
					invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., nested, result]
					swap(); // swap result under nested: [..., result, nested]
				} else {
					pop(); // remove newframe: [..., nested]
				}
				// [..., results, nested]
			}
			// unrolled loop end
			label(loopEnd);
			pop(); // remove nested: [..., results]
			// Create local variable table entry
			localVariable("arg", Object.class, argStart, loopEnd, 5);
			break;
		default: // [..., args]
			generatePushInt(argcount); // [..., args, argcount]
			anewarray(Object.class); // new Object[argcount]: [..., args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., args, array, arg, array]
				swap(); // swap arg over array ref: [..., args, array, array, arg]
				generatePushInt(argcount - 1 - i); // index: [..., args, array, array, arg, index]
				swap(); // swap index over arg: [..., args, array, array, index, arg]
				aastore(); // store: [..., args, array]
			} // no more args: [..., array]
			label(argStart);
			astore(5); // args: [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			// unrolled loop start
			label(loopStart);
			for (int i = 0; i < nested.size(); i++) {
				dup(); // [..., nested, nested]
				generatePushInt(i); // [..., nested, nested, index]
				invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., nested, object]
				checkcast(CodeBlock.class); // [..., nested, ncb]
				astore(4); // ncb: [..., nested]
				aload(4); // ncb: [..., nested, ncb]
				aload(1); // frame: [..., nested, ncb, frame]
				aload(4); // ncb: [..., nested, ncb, frame, ncb]
				aload(5); // args: [..., nested, ncb, frame, ncb, args]
				invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, args): [..., nested, ncb, newframe]
						CodeBlock.class,Object[].class);
				invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., nested, newframe]
				if (nested.get(i).getStackLevel() > 0) { // returns value
					invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., nested, result]
					swap(); // swap result under nested: [..., result, nested]
				} else {
					pop(); // remove newframe: [..., nested]
				}
				// [..., results, nested]
			}
			// unrolled loop end
			label(loopEnd); // [..., results, nested]
			pop(); // remove nested: [..., results]
			// Create local variable table entry
			localVariable("args", Object[].class, argStart, loopEnd, 5);
			break;	
		}
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, loopStart, loopEnd, 4);
		return super.caseInvokeAllCbs(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvokeCb(final InvokeCb object) {
		// Define labels
		final Label argStart = new Label();
		final Label ncbStart = new Label();
		final Label ncbEnd = new Label();
		// Generate bytecode
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			generatePushInt(object.getCbIndex()); // [..., nested, index]
			invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
			checkcast(CodeBlock.class); // [..., ncb]
			label(ncbStart);
			astore(4); // ncb: [...]
			aload(4); // ncb: [..., ncb]
			new_(StackFrame.class); // [..., ncb, newframe]
			dup(); // [..., ncb, newframe, newframe]
			aload(1); // frame: [..., ncb, newframe, newframe, frame]
			aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
			invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			if (object.getCodeBlock().getStackLevel() > 0) { // returns value
				invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			} else {
				pop(); // remove newframe: [...]
			}
			label(ncbEnd);
			break;
		case 1: // [..., arg]
			label(argStart);
			astore(5); // arg: [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			generatePushInt(object.getCbIndex()); // [..., nested, index]
			invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
			checkcast(CodeBlock.class); // [..., ncb]
			label(ncbStart);
			astore(4); // ncb: [...]
			aload(4); // ncb: [..., ncb]
			aload(1); // frame: [..., ncb, frame]
			aload(4); // ncb: [..., ncb, frame, ncb]
			aload(5); // arg: [..., ncb, frame, ncb, arg]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, arg): [..., ncb, newframe]
					CodeBlock.class, Object.class);
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			if (object.getCodeBlock().getStackLevel() > 0) { // returns value
				invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			} else {
				pop(); // remove newframe: [...]
			}
			label(ncbEnd);
			// Create local variable table entry
			localVariable("arg", Object.class, argStart, ncbEnd, 5);
			break;
		default: // [..., args]
			generatePushInt(argcount); // [..., args, argcount]
			anewarray(Object.class); // new Object[argcount]: [..., args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., args, array, arg, array]
				swap(); // swap arg over array ref: [..., args, array, array, arg]
				generatePushInt(argcount - 1 - i); // index: [..., args, array, array, arg, index]
				swap(); // swap index over arg: [..., args, array, array, index, arg]
				aastore(); // store: [..., args, array]
			} // no more args: [..., array]
			label(argStart);
			astore(5); // args: [...]
			aload(0); // this: [..., this]
			getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
			generatePushInt(object.getCbIndex()); // [..., nested, index]
			invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
			checkcast(CodeBlock.class); // [..., ncb]
			label(ncbStart);
			astore(4); // ncb: [...]
			aload(4); // ncb: [..., ncb]
			aload(1); // frame: [..., ncb, frame]
			aload(4); // ncb: [..., ncb, frame, ncb]
			aload(5); // args: [..., ncb, frame, ncb, args]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, args): [..., ncb, newframe]
					CodeBlock.class, Object[].class);
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			if (object.getCodeBlock().getStackLevel() > 0) { // returns value
				invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			} else {
				pop(); // remove newframe: [...]
			}
			label(ncbEnd);
			// Create local variable table entry
			localVariable("args", Object[].class, argStart, ncbEnd, 5);
			break;	
		}
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, ncbStart, ncbEnd, 4);
		return caseInvokeCb(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseInvokeCbS(final InvokeCbS object) {
		// Define labels
		final Label argStart = new Label();
		final Label ncbStart = new Label();
		final Label ncbEnd = new Label();
		final Label stackEmpty = new Label();
		// Generate bytecode
		generateSetPc(object);
		final int argcount = object.getArgcount();
		switch (argcount) {
		case 0: // [..., ncb]
			checkcast(CodeBlock.class); // [..., ncb]
			label(ncbStart);
			astore(4); // ncb: [...]
			aload(4); // ncb: [..., ncb]
			new_(StackFrame.class); // [..., ncb, newframe]
			dup(); // [..., ncb, newframe, newframe]
			aload(1); // frame: [..., ncb, newframe, newframe, frame]
			aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
			invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			dup(); // [..., newframe, newframe]
			invokeVirt(StackFrame.class, "stackEmpty", Type.BOOLEAN_TYPE); // newframe.stackEmpty(): [..., newframe, boolean]
			ifne(stackEmpty); // jump if stackEmpty == true: [..., newframe]
			invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			goto_(ncbEnd); // jump over stackEmpty
			label(stackEmpty);
			pop(); // [...]
			aconst_null(); // [..., null]
			label(ncbEnd);
			break;
		case 1: // [..., arg, ncb]
			checkcast(CodeBlock.class); // [..., arg, ncb]
			label(ncbStart);
			astore(4); // ncb: [..., arg]
			label(argStart);
			astore(5); // arg: [...]
			aload(4); // ncb: [..., ncb]
			aload(1); // frame: [..., ncb, frame]
			aload(4); // ncb: [..., ncb, frame, ncb]
			aload(5); // arg: [..., ncb, frame, ncb, arg]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, arg): [..., ncb, newframe]
					CodeBlock.class, Object.class);
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			dup(); // [..., newframe, newframe]
			invokeVirt(StackFrame.class, "stackEmpty", Type.BOOLEAN_TYPE); // newframe.stackEmpty(): [..., newframe, boolean]
			ifne(stackEmpty); // jump if stackEmpty == true: [..., newframe]
			invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			goto_(ncbEnd); // jump over stackEmpty
			label(stackEmpty);
			pop(); // [...]
			aconst_null(); // [..., null]
			label(ncbEnd);
			// Create local variable table entry
			localVariable("arg", Object.class, argStart, ncbEnd, 5);
			break;
		default: // [..., args, ncb]
			checkcast(CodeBlock.class); // [..., args, ncb]
			label(ncbStart);
			astore(4); // ncb: [..., args]
			generatePushInt(argcount); // [..., args, argcount]
			anewarray(Object.class); // new Object[argcount]: [..., args, array]
			for (int i = 0; i < argcount; i++) {
				dup_x1(); // copy array ref below value: [..., args, array, arg, array]
				swap(); // swap arg over array ref: [..., args, array, array, arg]
				generatePushInt(argcount - 1 - i); // index: [..., args, array, array, arg, index]
				swap(); // swap index over arg: [..., args, array, array, index, arg]
				aastore(); // store: [..., args, array]
			} // no more args: [..., array]
			label(argStart);
			astore(5); // args: [...]
			aload(4); // ncb: [..., ncb]
			aload(1); // frame: [..., ncb, frame]
			aload(4); // ncb: [..., ncb, frame, ncb]
			aload(5); // args: [..., ncb, frame, ncb, args]
			invokeVirt(StackFrame.class, "getSubFrame", StackFrame.class, // frame.getSubFrame(ncb, args): [..., ncb, newframe]
					CodeBlock.class, Object[].class);
			invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
			dup(); // [..., newframe, newframe]
			invokeVirt(StackFrame.class, "stackEmpty", Type.BOOLEAN_TYPE); // newframe.stackEmpty(): [..., newframe, boolean]
			ifne(stackEmpty); // jump if stackEmpty == true: [..., newframe]
			invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., result]
			goto_(ncbEnd); // jump over stackEmpty
			label(stackEmpty);
			pop(); // [...]
			aconst_null(); // [..., null]
			label(ncbEnd);
			// Create local variable table entry
			localVariable("args", Object[].class, argStart, ncbEnd, 5);
			break;	
		}
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, ncbStart, ncbEnd, 4);
		return caseInvokeCbS(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseNot(final Not object) {
		// Labels
		final Label ifFalse = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifeq(ifFalse); // [...]
		iconst_0(); // [..., false]
		goto_(ifEnd);
		label(ifFalse);
		iconst_1(); // [..., true]
		label(ifEnd);
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		return super.caseNot(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseAnd(final And object) {
		// Labels
		final Label ifFalse = new Label();
		final Label ncbStart = new Label();
		final Label ncbEnd = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifeq(ifFalse); // [...]
		generateSetPc(object);
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
		generatePushInt(object.getCbIndex()); // [..., nested, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
		checkcast(CodeBlock.class); // [..., ncb]
		label(ncbStart);
		astore(4); // ncb: [...]
		aload(4); // ncb: [..., ncb]
		new_(StackFrame.class); // [..., ncb, newframe]
		dup(); // [..., ncb, newframe, newframe]
		aload(1); // frame: [..., ncb, newframe, newframe, frame]
		aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
		invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
		invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
		invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., Boolean]
		label(ncbEnd);
		goto_(ifEnd);
		label(ifFalse);
		iconst_0(); // [..., false]
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		label(ifEnd);
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, ncbStart, ncbEnd, 4);
		return caseAnd(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseOr(final Or object) {
		// Labels
		final Label ifTrue = new Label();
		final Label ncbStart = new Label();
		final Label ncbEnd = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifne(ifTrue); // [...]
		generateSetPc(object);
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
		generatePushInt(object.getCbIndex()); // [..., nested, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
		checkcast(CodeBlock.class); // [..., ncb]
		label(ncbStart);
		astore(4); // ncb: [...]
		aload(4); // ncb: [..., ncb]
		new_(StackFrame.class); // [..., ncb, newframe]
		dup(); // [..., ncb, newframe, newframe]
		aload(1); // frame: [..., ncb, newframe, newframe, frame]
		aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
		invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
		invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
		invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., Boolean]
		label(ncbEnd);
		goto_(ifEnd);
		label(ifTrue);
		iconst_1(); // [..., true]
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		label(ifEnd);
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, ncbStart, ncbEnd, 4);
		return super.caseOr(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseXor(final Xor object) {
		// Labels
		final Label ifFirstFalse = new Label();
		final Label ifFalse = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		checkcast(Boolean.class); // [..., Boolean, Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., Boolean, bool]
		ifeq(ifFirstFalse); // [..., Boolean]
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifeq(ifFalse); // [...]
		iconst_0(); // [..., false]
		goto_(ifEnd);
		label(ifFalse);
		iconst_1(); // [..., true]
		label(ifEnd);
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		label(ifFirstFalse);
		return super.caseXor(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseImplies(final Implies object) {
		// Labels
		final Label ifFalse = new Label();
		final Label ncbStart = new Label();
		final Label ncbEnd = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifeq(ifFalse); // [...]
		generateSetPc(object);
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
		generatePushInt(object.getCbIndex()); // [..., nested, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
		checkcast(CodeBlock.class); // [..., ncb]
		label(ncbStart);
		astore(4); // ncb: [...]
		aload(4); // ncb: [..., ncb]
		new_(StackFrame.class); // [..., ncb, newframe]
		dup(); // [..., ncb, newframe, newframe]
		aload(1); // frame: [..., ncb, newframe, newframe, frame]
		aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
		invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
		invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
		invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., Boolean]
		label(ncbEnd);
		goto_(ifEnd);
		label(ifFalse);
		iconst_1(); // [..., true]
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		label(ifEnd);
		// Create local variable table entry
		localVariable("ncb", CodeBlock.class, ncbStart, ncbEnd, 4);
		return super.caseImplies(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseIfte(final Ifte object) {
		// Labels
		final Label thenCbStart = new Label();
		final Label thenCbEnd = new Label();
		final Label ifFalse = new Label();
		final Label elseCbStart = new Label();
		final Label elseCbEnd = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		generateSetPc(object);
		checkcast(Boolean.class); // [..., Boolean]
		invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // [..., bool]
		ifeq(ifFalse); // [...]
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
		generatePushInt(object.getThenCbIndex()); // [..., nested, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
		checkcast(CodeBlock.class); // [..., ncb]
		label(thenCbStart);
		astore(4); // ncb: [...]
		aload(4); // ncb: [..., ncb]
		new_(StackFrame.class); // [..., ncb, newframe]
		dup(); // [..., ncb, newframe, newframe]
		aload(1); // frame: [..., ncb, newframe, newframe, frame]
		aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
		invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
		invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
		invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., Boolean]
		label(thenCbEnd);
		goto_(ifEnd);
		label(ifFalse);
		aload(0); // this: [..., this]
		getField(JITCodeBlock.class, "nested", EList.class); // [..., nested]
		generatePushInt(object.getElseCbIndex()); // [..., nested, index]
		invokeIface(EList.class, "get", Object.class, Type.INT_TYPE); // nested.get(index): [..., object]
		checkcast(CodeBlock.class); // [..., ncb]
		label(elseCbStart);
		astore(4); // ncb: [...]
		aload(4); // ncb: [..., ncb]
		new_(StackFrame.class); // [..., ncb, newframe]
		dup(); // [..., ncb, newframe, newframe]
		aload(1); // frame: [..., ncb, newframe, newframe, frame]
		aload(4); // ncb: [..., ncb, newframe, newframe, frame, ncb]
		invokeCons(StackFrame.class, StackFrame.class, CodeBlock.class); // new StackFrame(parent, ncb): [..., ncb, newframe]
		invokeIface(CodeBlock.class, "execute", StackFrame.class, StackFrame.class); // ncb.execute(newframe): [..., newframe]
		invokeVirt(StackFrame.class, "pop", Object.class); // newframe.pop(): [..., Boolean]
		label(elseCbEnd);
		label(ifEnd);
		// Create local variable table entry
		localVariable("thenCb", CodeBlock.class, thenCbStart, thenCbEnd, 4);
		localVariable("elseCb", CodeBlock.class, elseCbStart, elseCbEnd, 4);
		return super.caseIfte(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseIsnull(final Isnull object) {
		// Labels
		final Label ifNull = new Label();
		final Label ifEnd = new Label();
		// Generate bytecode
		ifnull(ifNull); // [...]
		iconst_0(); // [..., false]
		goto_(ifEnd);
		label(ifNull);
		iconst_1(); // [..., true]
		label(ifEnd);
		invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(bool): [..., Boolean]
		return super.caseIsnull(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MethodVisitor caseGetenvtype(Getenvtype object) {
		getStatic(JITCodeBlock.class, "EXEC_ENV", EClass.class); // [..., ExecEnv]
		return super.caseGetenvtype(object);
	}

	/**
	 * Generates frame.setPc(pc) for <code>object</code>, iff <code>hasMonitor</code> is <code>false</code>.
	 * @param object the next instruction
	 */
	protected void generateSetPc(final Instruction object) {
		if (!hasMonitor) {
			aload(1); // frame
			final int pc = object.getOwningBlock().getCode().indexOf(object) + 1;
			generatePushInt(pc); // pc
			invokeVirt(StackFrame.class, "setPc", Type.VOID_TYPE, Type.INT_TYPE); // frame.setPc(pc)
		}
	}

	/**
	 * Generates bytecode that creates a new sub-{@link StackFrame}.
	 * @param opname the operation name (for debugger)
	 */
	protected void generateSubFrame(final String opname) {
		new_(StackFrame.class); // [..., newframe]
		dup(); // [..., newframe, newframe]
		aload(1); // frame: [..., newframe, newframe, frame]
		ldc(opname); // [..., newframe, newframe, frame, opname]
		invokeCons(StackFrame.class, StackFrame.class, String.class); // new StackFrame(frame, opname): [..., newframe]
	}

	/**
	 * Generates boxing code for a value of type <code>cls</code>, if necessary.
	 * @param cls the value class
	 * @param selfCls the class of self
	 */
	protected void generateBoxing(final Class<?> cls, final Class<?> selfCls) {
		// [..., val]
		if (cls == Void.TYPE) {
			mv.visitInsn(ACONST_NULL); // replacement return value: [..., null]
		} else if (cls == Boolean.TYPE) {
			invokeStat(Boolean.class, "valueOf", Boolean.class, Type.BOOLEAN_TYPE); // Boolean.valueOf(val): [..., Boolean]
		} else if (cls == Character.TYPE) {
			invokeStat(Character.class, "valueOf", Character.class, Type.CHAR_TYPE); // Character.valueOf(val): [..., Character]
		} else if (cls == Byte.TYPE) {
			invokeStat(Byte.class, "valueOf", Byte.class, Type.BYTE_TYPE); // Byte.valueOf(val): [..., Byte]
		} else if (cls == Short.TYPE) {
			invokeStat(Short.class, "valueOf", Short.class, Type.SHORT_TYPE); // Short.valueOf(val): [..., Short]
		} else if (cls == Integer.TYPE) {
			invokeStat(Integer.class, "valueOf", Integer.class, Type.INT_TYPE); // Integer.valueOf(val): [..., Integer]
		} else if (cls == Long.TYPE) {
			invokeStat(Long.class, "valueOf", Long.class, Type.LONG_TYPE); // Long.valueOf(val): [..., Long]
		} else if (cls == Float.TYPE) {
			invokeStat(Float.class, "valueOf", Float.class, Type.FLOAT_TYPE); // Float.valueOf(val): [..., Float]
		} else if (cls == Double.TYPE) {
			invokeStat(Double.class, "valueOf", Double.class, Type.DOUBLE_TYPE); // Double.valueOf(val): [..., Double]
		} else if (Enumerator.class.isAssignableFrom(cls)) {
			invokeVirt(Object.class, "toString", String.class); // val.toString(): [..., String] 
			new_(EnumLiteral.class); // new EnumLiteral: [..., String, enum]
			dup_x1(); // [..., enum, String, enum]
			swap(); // [..., enum, enum, Stringl]
			invokeCons(EnumLiteral.class, String.class); // enum.<init>(String): [..., enum]
		} else if (Collection.class.isAssignableFrom(cls)) {
			if (LazyCollection.class.isAssignableFrom(cls)) {
				// no conversion required
			} else if (List.class.isAssignableFrom(cls)) {
				new_(EnumConversionListOnList.class); // new EnumConversionList: [..., val, enumlist]
				dup_x1(); // [..., enumlist, val, enumlist]
				swap(); // [..., enumlist, enumlist, val]
				invokeCons(EnumConversionListOnList.class, List.class); // enumlist.<init>(val): [..., enumlist]
				if (EObject.class.isAssignableFrom(selfCls)) {
					final Label ifModelNull = new Label();
					aload(2); // env: [..., enumlist, env]
					aload(4); // self: [..., enumlist, env, self]
					invokeIface(ExecEnv.class, "getInoutModelOf", Model.class, EObject.class); // env.getInoutModelOf(self): [..., enumlist,
																								// model]
					ifnull(ifModelNull); // jump if model == null: [..., enumlist]
					invokeVirt(EnumConversionList.class, "cache", EnumConversionList.class); // enumlist.cache(): [..., enumlist]
					label(ifModelNull); // [..., enumlist]
				}
			} else if (java.util.Set.class.isAssignableFrom(cls)) {
				new_(EnumConversionSetOnSet.class); // new EnumConversionSetOnSet: [..., val, enumset]
				dup_x1(); // [..., enumset, val, enumset]
				swap(); // [..., enumset, enumset, val]
				invokeCons(EnumConversionSetOnSet.class, java.util.Set.class); // enumset.<init>(val): [..., enumset]
				if (EObject.class.isAssignableFrom(selfCls)) {
					final Label ifModelNull = new Label();
					aload(2); // env: [..., enumset, env]
					aload(4); // self: [..., enumset, env, self]
					invokeIface(ExecEnv.class, "getInoutModelOf", Model.class, EObject.class); // env.getInoutModelOf(self): [..., enumset, model]
					ifnull(ifModelNull); // jump if model == null: [..., enumlist]
					invokeVirt(EnumConversionSetOnSet.class, "cache", EnumConversionSetOnSet.class); // enumlist.cache(): [..., enumset]
					label(ifModelNull); // [..., enumset]
				}
			} else {
				new_(EnumConversionList.class); // new EnumConversionList: [..., val, enumlist]
				dup_x1(); // [..., enumlist, val, enumlist]
				swap(); // [..., enumlist, enumlist, val]
				invokeCons(EnumConversionList.class, Collection.class); // enumlist.<init>(val): [..., enumlist]
				if (EObject.class.isAssignableFrom(selfCls)) {
					final Label ifModelNull = new Label();
					aload(2); // env: [..., enumlist, env]
					aload(4); // self: [..., enumlist, env, self]
					invokeIface(ExecEnv.class, "getInoutModelOf", Model.class, EObject.class); // env.getInoutModelOf(self): [..., enumlist,
																								// model]
					ifnull(ifModelNull); // jump if model == null: [..., enumlist]
					invokeVirt(EnumConversionList.class, "cache", EnumConversionList.class); // enumlist.cache(): [..., enumlist]
					label(ifModelNull); // [..., enumlist]
				}
			}
		} else if (cls.isArray()) {
			final Class<?> cType = cls.getComponentType();
			if (Object.class.isAssignableFrom(cType)) {
				// Array of cType
				final Label ifNull = new Label();
				dup(); // [..., array, array]
				ifnull(ifNull); // jump if array == null: [..., array]
				invokeStat(Arrays.class, "asList", List.class, Object[].class); // Arrays.asList(array): [..., list]
				new_(LazyListOnList.class); // new LazyListOnList: [..., list, lazylist]
				dup_x1(); // [..., lazylist, list, lazylist]
				swap(); // [..., lazylist, lazylist, list]
				invokeCons(LazyListOnList.class, List.class); // lazylist.<init>(list): [..., lazylist]
				label(ifNull);
			} // don't wrap primitive type arrays
		}
		// [..., Object]
	}

	/**
	 * Generates unboxing code for a value of type <code>cls</code>, if necessary.
	 * @param cls the value class
	 */
	protected void generateUnboxing(final Class<?> cls) {
		// [..., Object]
		if (cls == Boolean.TYPE) {
			checkcast(Boolean.class);
			invokeVirt(Boolean.class, "booleanValue", Type.BOOLEAN_TYPE); // Object.booleanValue(): [..., boolean]
		} else if (cls == Character.TYPE) {
			checkcast(Character.class);
			invokeVirt(Character.class, "charValue", Type.CHAR_TYPE); // Object.charValue(): [..., char]
		} else if (cls == Byte.TYPE) {
			checkcast(Byte.class);
			invokeVirt(Byte.class, "byteValue", Type.BYTE_TYPE); // Object.byteValue(): [..., byte]
		} else if (cls == Short.TYPE) {
			checkcast(Short.class);
			invokeVirt(Short.class, "shortValue", Type.SHORT_TYPE); // Object.shortValue(): [..., short]
		} else if (cls == Integer.TYPE) {
			checkcast(Integer.class);
			invokeVirt(Integer.class, "intValue", Type.INT_TYPE); // Object.intValue(): [..., int]
		} else if (cls == Long.TYPE) {
			checkcast(Long.class);
			invokeVirt(Long.class, "longValue", Type.LONG_TYPE); // Object.longValue(): [..., long]
		} else if (cls == Float.TYPE) {
			checkcast(Float.class);
			invokeVirt(Float.class, "floatValue", Type.FLOAT_TYPE); // Object.floatValue(): [..., float]
		} else if (cls == Double.TYPE) {
			checkcast(Double.class);
			invokeVirt(Double.class, "doubleValue", Type.DOUBLE_TYPE); // Object.doubleValue(): [..., double]
		} else if (Enumerator.class.isAssignableFrom(cls)) {
			checkcast(EnumLiteral.class); // [..., enum]
			invokeVirt(EnumLiteral.class, "getName", String.class); // enum.getName(): [..., name]
			invokeStat(cls, "getByName", cls, String.class); // <cls>.getByName(name): [..., <cls>]
		} else {
			checkcast(cls);
		}
		// [..., val]
	}

	/**
	 * Generates an optimised instruction for pushing a constant integer <code>value</code>
	 * onto the stack.
	 * @param value the constant integer value to push
	 */
	protected void generatePushInt(final int value) {
		CodeBlockJIT.generatePushInt(mv, value);
	}

	/**
	 * Inserts a label.
	 * @param label the label to insert
	 */
	protected void label(final Label label) {
		mv.visitLabel(label);
	}

	/**
	 * Generates an ALOAD instruction.
	 * @param var the index of the local variable to load
	 */
	protected void aload(final int var) {
		mv.visitVarInsn(ALOAD, var);
	}

	/**
	 * Generates an ASTORE instruction.
	 * @param var the index of the local variable to store
	 */
	protected void astore(final int var) {
		mv.visitVarInsn(ASTORE, var);
	}

	protected void new_(final Class<?> cls) {
		mv.visitTypeInsn(NEW, Type.getInternalName(cls));
	}

	protected void checkcast(final Class<?> cls) {
		mv.visitTypeInsn(CHECKCAST, Type.getInternalName(cls));
	}

	protected void instanceof_(final Class<?> cls) {
		mv.visitTypeInsn(INSTANCEOF, Type.getInternalName(cls));
	}

	protected void anewarray(final Class<?> cls) {
		mv.visitTypeInsn(ANEWARRAY, Type.getInternalName(cls));
	}

	protected void dup() {
		mv.visitInsn(DUP);
	}

	protected void dup_x1() {
		mv.visitInsn(DUP_X1);
	}

	protected void dup_x2() {
		mv.visitInsn(DUP_X2);
	}

	protected void pop() {
		mv.visitInsn(POP);
	}

	protected void swap() {
		mv.visitInsn(SWAP);
	}

	protected void ldc(final Object object) {
		mv.visitLdcInsn(object);
	}

	protected void aconst_null() {
		mv.visitInsn(ACONST_NULL);
	}

	protected void aastore() {
		mv.visitInsn(AASTORE);
	}

	protected void areturn() {
		mv.visitInsn(ARETURN);
	}

	protected void iconst_1() {
		mv.visitInsn(ICONST_1);
	}

	protected void iconst_0() {
		mv.visitInsn(ICONST_0);
	}

	/**
	 * Generates a method invocation instruction.
	 * @param opcode the method invocation instruction opcode (e.g. INVOKEVIRTUAL)
	 * @param owner the method owner class
	 * @param name the method name
	 * @param retType the method return type {@link Class} or {@link Type}
	 * @param argTypes the method argument type {@link Class}es or {@link Type}s
	 */
	protected void invoke(final int opcode, final Class<?> owner, final String name, 
			final Object retType, final Object... argTypes) {
		final Type[] ats = new Type[argTypes.length];
		for (int i = 0; i < argTypes.length; i++) {
			ats[i] = argTypes[i] instanceof Type ? (Type)argTypes[i] : Type.getType((Class<?>)argTypes[i]);
		}
		mv.visitMethodInsn(opcode, 
				Type.getInternalName(owner), 
				name, 
				Type.getMethodDescriptor(
						retType instanceof Type ? (Type)retType : Type.getType((Class<?>)retType), 
						ats),
				owner.isInterface());
	}

	protected void invokeIface(final Class<?> owner, final String name, 
			final Object retType, final Object... argTypes) {
		invoke(INVOKEINTERFACE, owner, name, retType, argTypes);
	}

	protected void invokeVirt(final Class<?> owner, final String name, 
			final Object retType, final Object... argTypes) {
		invoke(INVOKEVIRTUAL, owner, name, retType, argTypes);
	}

	protected void invokeStat(final Class<?> owner, final String name, 
			final Object retType, final Object... argTypes) {
		invoke(INVOKESTATIC, owner, name, retType, argTypes);
	}

	protected void invokeSpec(final Class<?> owner, final String name, 
			final Object retClass, final Object... argClasses) {
		invoke(INVOKESPECIAL, owner, name, retClass, argClasses);
	}

	protected void invokeCons(final Class<?> owner, final Object... argTypes) {
		invoke(INVOKESPECIAL, owner, "<init>", Type.VOID_TYPE, argTypes);
	}

	/**
	 * Generates a field access instruction.
	 * @param opcode the field access opcode (e.g. GETFIELD)
	 * @param owner the field owner class
	 * @param name the field name
	 * @param type the field {@link Class} or {@link Type}
	 */
	protected void field(final int opcode, final Class<?> owner, final String name, 
			final Object type) {
		mv.visitFieldInsn(opcode, Type.getInternalName(owner), name, 
				type instanceof Type ? 
						((Type)type).getDescriptor() : 
						Type.getDescriptor((Class<?>) type));
	}

	protected void getField(final Class<?> owner, final String name, final Object type) {
		field(GETFIELD, owner, name, type);
	}

	protected void putField(final Class<?> owner, final String name, final Object type) {
		field(PUTFIELD, owner, name, type);
	}

	protected void getStatic(final Class<?> owner, final String name, final Object type) {
		field(GETSTATIC, owner, name, type);
	}

	protected void putStatic(final Class<?> owner, final String name, final Object type) {
		field(PUTSTATIC, owner, name, type);
	}

	protected void ifne(final Label label) {
		mv.visitJumpInsn(IFNE, label);
	}

	protected void ifeq(final Label label) {
		mv.visitJumpInsn(IFEQ, label);
	}

	protected void goto_(final Label label) {
		mv.visitJumpInsn(GOTO, label);
	}

	protected void ifnull(final Label label) {
		mv.visitJumpInsn(IFNULL, label);
	}

	protected void ifnonnull(final Label label) {
		mv.visitJumpInsn(IFNONNULL, label);
	}

	protected void athrow() {
		mv.visitInsn(ATHROW);
	}

	/**
	 * Generates a local variable table entry.
	 * @param name the name of a local variable.
	 * @param type the type of this local variable.
	 * @param start the first instruction corresponding to the scope of this local variable (inclusive).
	 * @param end the last instruction corresponding to the scope of this local variable (exclusive).
	 * @param index the local variable's index.
	 * @throws IllegalArgumentException if one of the labels has not already been visited by this visitor (by the {@link MethodVisitor#visitLabel} method).
	 */
	protected void localVariable(final String name, final Class<?> type, 
			final Label start, final Label end, final int index) {
		mv.visitLocalVariable(name, Type.getDescriptor(type), null, start, end, index);
	}

	/**
	 * Generates a try-catch block.
	 * @param start beginning of the exception handler's scope (inclusive).
	 * @param end end of the exception handler's scope (exclusive).
	 * @param handler beginning of the exception handler's code.
	 * @param type internal name of the type of exceptions handled by the handler, or null to catch any exceptions (for "finally" blocks).
	 * @throws IllegalArgumentException if one of the labels has already been visited by this visitor (by the {@link MethodVisitor#visitLabel} method).
	 */
	protected void tryCatchBlock(final Label start, final Label end, 
			final Label handler, final Class<?> type) {
		mv.visitTryCatchBlock(start, end, handler, Type.getInternalName(type));
	}
	
	/**
	 * Returns the next instruction for the given instruction, or <code>null</code>.
	 * @param instruction the instruction
	 * @return the next instruction for the given instruction, or <code>null</code>
	 */
	protected Instruction nextInstruction(final Instruction instruction) {
		final List<Instruction> code = instruction.getOwningBlock().getCode();
		final int index = code.indexOf(instruction);
		if (index < code.size() - 1) {
			return code.get(index + 1);
		}
		return null;
	}

}