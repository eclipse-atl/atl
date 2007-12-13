/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ATL Debug Wire Protocol: declarations for ATL VM debugging protocol.
 * Debugger and debuggee share most protocol code.
 * @author Frédéric Jouault
 */
public abstract class ADWP extends Thread {

	// Commands from debugger to debuggee
	public static final int CMD_CONTINUE	= 0;
	public static final int CMD_STEP		= 1;
	public static final int CMD_STEP_OVER	= 2;
	public static final int CMD_FINISH		= 3;

	public static final int CMD_GET			= 10;
	public static final int CMD_SET			= 11;
	public static final int CMD_CALL		= 12;
	public static final int CMD_SET_BP		= 13;
	public static final int CMD_UNSET_BP	= 14;

	public static final int CMD_DISASSEMBLE	= 20;
	public static final int CMD_QUERY		= 21;

	// Messages from debuggee to debugger
	public static final int MSG_STOPPED		= 100;
	public static final int MSG_ANS			= 101;
	public static final int MSG_DISAS_CODE	= 102;
	public static final int MSG_TERMINATED	= 103;

	// Value types
	public static final int TYPE_BOOLEAN	= 1;
	public static final int TYPE_INTEGER	= 2;
	public static final int TYPE_STRING	= 3;
	public static final int TYPE_OBJECT	= 4;
	public static final int TYPE_NULL	= 5;
	public static final int TYPE_REAL	= 6;

	public ADWP(InputStream in, OutputStream out) {
		this.in = new DataInputStream(new BufferedInputStream(in));
		this.out = new DataOutputStream(new BufferedOutputStream(out));
		this.start();
	}

	protected void writeValue(Value value) throws IOException {
		if(value instanceof StringValue) {
			String v = ((StringValue)value).getValue();
			out.writeByte(TYPE_STRING);
			out.writeUTF(v);
		} else if(value instanceof IntegerValue) {
			int v = ((IntegerValue)value).getValue();
			out.writeByte(TYPE_INTEGER);
			out.writeInt(v);
		} else if(value instanceof RealValue) {
			double v = ((RealValue)value).getValue();
			out.writeByte(TYPE_REAL);
			out.writeDouble(v);
		} else if(value instanceof BooleanValue) {
			boolean v = ((BooleanValue)value).getValue();
			out.writeByte(TYPE_BOOLEAN);
			out.writeBoolean(v);
		} else if(value instanceof ObjectReference) {
			int id = ((ObjectReference)value).getId();
			out.writeByte(TYPE_OBJECT);
			out.writeInt(id);
		} else if((value instanceof NullValue) || (value == null)) {
			out.writeByte(TYPE_NULL);
		}
	}

	protected Value readValue() throws IOException {
		Value ret = null;

		int type = (in.readByte() & 0xFF);
		switch(type) {
			case TYPE_STRING:
				ret = StringValue.valueOf(in.readUTF());
				break;
			case TYPE_INTEGER:
				ret = IntegerValue.valueOf(in.readInt());
				break;
			case TYPE_REAL:
				ret = RealValue.valueOf(in.readDouble());
				break;
			case TYPE_BOOLEAN:
				ret = BooleanValue.valueOf(in.readBoolean());
				break;
			case TYPE_OBJECT:
				ret = readObjectReference(in.readInt());
				break;
			case TYPE_NULL:
				ret = new NullValue();
				break;
		}

		return ret;
	}

	protected abstract ObjectReference readObjectReference(int id);

	protected DataInputStream in;
	protected DataOutputStream out;
}

