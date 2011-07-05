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
package org.eclipse.m2m.atl.emftvm.impl.resource;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ConstantTag;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.NamedElement;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleElement;
import org.eclipse.m2m.atl.emftvm.TypedElement;
import org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;

/**
 * Constant pool implementation for binary EMFTVM file format.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ConstantPool {

	/**
	 * Creates constant pool entries for EMFTVM elements. 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class CreateConstantsSwitch extends EmftvmSwitch<Object> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseNamedElement(NamedElement object) {
			add(object.getName());
			return super.caseNamedElement(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseTypedElement(TypedElement object) {
			add(object.getTypeModel());
			add(object.getType());
			return super.caseTypedElement(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseFeature(Feature object) {
			add(object.getContextModel());
			add(object.getContext());
			return super.caseFeature(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseCodeBlock(CodeBlock object) {
			for (LocalVariable lv : object.getLocalVariables()) {
				doSwitch(lv);
			}
			for (Instruction instr : object.getCode()) {
				doSwitch(instr);
			}
			for (CodeBlock nestedcode : object.getNested()) {
				doSwitch(nestedcode);
			}
			return super.caseCodeBlock(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseModule(Module object) {
			for (Rule r : object.getRules()) {
				doSwitch(r);
			}
			for (Feature f : object.getFeatures()) {
				doSwitch(f);
			}
			for (String imp : object.getImports()) {
				add(imp);
			}
			for (ModelDeclaration m : object.getInputModels()) {
				doSwitch(m);
			}
			for (ModelDeclaration m : object.getInoutModels()) {
				doSwitch(m);
			}
			for (ModelDeclaration m : object.getOutputModels()) {
				doSwitch(m);
			}
			add(object.getSourceName());
			return super.caseModule(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseOperation(Operation object) {
			for (Parameter par : object.getParameters()) {
				doSwitch(par);
			}
			if (object.getBody() != null) doSwitch(object.getBody());
			return super.caseOperation(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseRule(Rule object) {
			for (String sr : object.getSuperRules()) {
				add(sr);
			}
			for (RuleElement re : object.getInputElements()) {
				doSwitch(re);
			}
			for (RuleElement re : object.getOutputElements()) {
				doSwitch(re);
			}
			for (Field f : object.getFields()) {
				doSwitch(f);
			}
			if (object.getMatcher() != null) doSwitch(object.getMatcher());
			if (object.getApplier() != null) doSwitch(object.getApplier());
			if (object.getPostApply() != null) doSwitch(object.getPostApply());
			return super.caseRule(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseRuleElement(RuleElement object) {
			for (String model : object.getModels()) {
				add(model);
			}
			return super.caseRuleElement(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseInputRuleElement(InputRuleElement object) {
			if (object.getBinding() != null) {
				doSwitch(object.getBinding());
			}
			return super.caseInputRuleElement(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseFieldInstruction(FieldInstruction object) {
			add(object.getFieldname());
			return super.caseFieldInstruction(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseFindtype(Findtype object) {
			add(object.getModelname());
			add(object.getTypename());
			return super.caseFindtype(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseInvokeOperationInstruction(InvokeOperationInstruction object) {
			add(object.getOpname());
			return super.caseInvokeOperationInstruction(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseNew(New object) {
			add(object.getModelname());
			return super.caseNew(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object casePush(Push object) {
			add(object.getValue());
			return super.casePush(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseMatch(Match object) {
			add(object.getRulename());
			return super.caseMatch(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseModelDeclaration(ModelDeclaration object) {
			add(object.getModelName());
			add(object.getMetaModelName());
			return super.caseModelDeclaration(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseField(Field object) {
			if (object.getInitialiser() != null) doSwitch(object.getInitialiser());
			return super.caseField(object);
		}

	}

	protected CreateConstantsSwitch createConstants = new CreateConstantsSwitch();
	private ArrayList<Object> constants;

	/**
	 * Creates a new {@link ConstantPool}.
	 */
	public ConstantPool() {
		super();
		constants = new ArrayList<Object>();
	}

	/**
	 * Creates a new {@link ConstantPool}.
	 * @param size the initial pool size
	 */
	public ConstantPool(int size) {
		super();
		constants = new ArrayList<Object>(size);
	}

	/**
	 * Returns the constant at index <pre>i</pre>.
	 * @param i the constant index
	 * @return the constant, or <code>null</code>
	 */
	public Object get(int i) {
		return constants.get(i);
	}

	/**
	 * Returns the index of <pre>value</pre> in the constant pool.
	 * @param value the value to look up
	 * @return the index of value in the constant pool
	 * @throws IllegalArgumentException if value not found
	 */
	public int indexOf(Object value) throws IllegalArgumentException {
		final int index = constants.indexOf(value);
		if (index == -1) {
			throw new IllegalArgumentException("Element not found");
		}
		return index;
	}

	/**
	 * Returns the size of the constant pool.
	 * @return The size of the constant pool
	 */
	public int size() {
		return constants.size();
	}

	/**
	 * Adds <pre>value</pre> to the constant pool, if necessary.
	 * @param value the value to add
	 */
	public void add(Object value) {
		if (!constants.contains(value)) {
			constants.add(value);
		}
	}

	/**
	 * Reads constant table from <pre>in</pre>.
	 * @param in the input stream
	 * @throws IOException
	 */
	public void read(final DataInputStream in) throws IOException {
		final int cpcount = in.readInt();
		constants.clear();
		constants.ensureCapacity(cpcount);
		for (int i = 0; i < cpcount; i++) {
			readConstant(in);
		}
	}

	/**
	 * Reads a constant from <pre>in</pre>.
	 * @param in the input stream
	 * @throws IOException
	 */
	private void readConstant(final DataInputStream in) throws IOException {
		final int tag = in.readInt();
		final Object value;
		switch (tag) {
		case ConstantTag.STRING_VALUE:
			value = in.readUTF();
			break;
		case ConstantTag.INTEGER_VALUE:
			value = in.readInt();
			break;
		case ConstantTag.DOUBLE_VALUE:
			value = in.readDouble();
			break;
		case ConstantTag.BYTE_VALUE:
			value = in.readByte();
			break;
		case ConstantTag.CHARACTER_VALUE:
			value = in.readChar();
			break;
		case ConstantTag.FLOAT_VALUE:
			value = in.readFloat();
			break;
		case ConstantTag.SHORT_VALUE:
			value = in.readShort();
			break;
		case ConstantTag.LONG_VALUE:
			value = in.readLong();
			break;
		case ConstantTag.ENUM_LITERAL_VALUE:
			value = new EnumLiteral(in.readUTF());
			break;
		case ConstantTag.NULL_VALUE:
			value = null;
			break;
		default:
			throw new UnsupportedEncodingException(String.format("Unsupported constant type: %d", tag));
		}
		constants.add(value);
	}

	/**
	 * Creates a constant table for the given module.
	 * @param module the module
	 */
	public void createConstants(final Module module) {
		createConstants.doSwitch(module);
	}

	/**
	 * Writes constant pool to <pre>out</pre>.
	 * @param out the output stream
	 * @throws IOException 
	 */
	public void write(final DataOutputStream out) throws IOException {
		out.writeInt(constants.size());
		for (Object constant : constants) {
			writeConstant(out, constant);
		}
	}

	private static void writeConstant(final DataOutputStream out, final Object constant) throws IOException {
		if (constant == null) {
			out.writeInt(ConstantTag.NULL_VALUE);
			return;
		}
		final ConstantTag tag = ConstantTag.get(constant.getClass().getSimpleName());
		if (tag == null) {
			throw new UnsupportedEncodingException(String.format("Unsupported constant type: %s", constant.getClass().getName()));
		}
		out.writeInt(tag.getValue());
		switch (tag) {
		case STRING:
			out.writeUTF((String)constant);
			break;
		case INTEGER:
			out.writeInt((Integer)constant);
			break;
		case DOUBLE:
			out.writeDouble((Double)constant);
			break;
		case BYTE:
			out.writeByte((Byte)constant);
			break;
		case CHARACTER:
			out.writeChar((Character)constant);
			break;
		case FLOAT:
			out.writeFloat((Float)constant);
			break;
		case SHORT:
			out.writeShort((Short)constant);
			break;
		case LONG:
			out.writeLong((Long)constant);
			break;
		case ENUM_LITERAL:
			if (constant instanceof EnumLiteral) {
				out.writeUTF(((EnumLiteral)constant).getName());
			} else {
				out.writeUTF(constant.toString()); // workaround to support other enum literal classes
			}
			break;
		default:
			throw new UnsupportedEncodingException(String.format("Unsupported constant type: %s", constant.getClass().getName()));
		}
	}

}
