/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core.adwp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * ATL Debug Wire Protocol: declarations for ATL VM debugging protocol. Debugger and debuggee share most
 * protocol code.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ADWP extends Thread {

	/****************************************
	 * Commands from debugger to debuggee.
	 ****************************************/

	/** Continues. */
	public static final int CMD_CONTINUE = 0;

	/** Step. */
	public static final int CMD_STEP = 1;

	/** Step over. */
	public static final int CMD_STEP_OVER = 2;

	/** Finish. */
	public static final int CMD_FINISH = 3;

	/** Get. */
	public static final int CMD_GET = 10;

	/** Set. */
	public static final int CMD_SET = 11;

	/** Call. */
	public static final int CMD_CALL = 12;

	/** Set breakpoint. */
	public static final int CMD_SET_BP = 13;

	/** Unset breakpoint. */
	public static final int CMD_UNSET_BP = 14;

	/** Disassemble. */
	public static final int CMD_DISASSEMBLE = 20;

	/** Query. */
	public static final int CMD_QUERY = 21;

	/****************************************
	 * Messages from debuggee to debugger.
	 ****************************************/

	/** Stopped. */
	public static final int MSG_STOPPED = 100;

	/** Answer. */
	public static final int MSG_ANS = 101;

	/** Disassemble. */
	public static final int MSG_DISAS_CODE = 102;

	/** Terminated. */
	public static final int MSG_TERMINATED = 103;

	/****************************************
	 * Value types.
	 ****************************************/

	/** {@link BooleanValue}. */
	public static final int TYPE_BOOLEAN = 1;

	/** {@link IntegerValue}. */
	public static final int TYPE_INTEGER = 2;

	/** {@link StringValue}. */
	public static final int TYPE_STRING = 3;

	/** Object. */
	public static final int TYPE_OBJECT = 4;

	/** {@link NullValue}. */
	public static final int TYPE_NULL = 5;

	/** {@link RealValue}. */
	public static final int TYPE_REAL = 6;

	protected DataInputStream in;

	protected DataOutputStream out;

	private List<ADWPCommand> cmds = new ArrayList<ADWPCommand>();

	/**
	 * Creates the protocol using the given streams.
	 * 
	 * @param in
	 *            the input stream
	 * @param out
	 *            the output stream
	 */
	public ADWP(InputStream in, OutputStream out) {
		this.in = new DataInputStream(new BufferedInputStream(in));
		this.out = new DataOutputStream(new BufferedOutputStream(out));
		this.start();
	}

	/**
	 * Writes the given value on the output stream.
	 * 
	 * @param value
	 *            the value to write
	 * @throws IOException
	 */
	protected void writeValue(Value value) throws IOException {
		if (value instanceof StringValue) {
			String v = ((StringValue)value).getValue();
			out.writeByte(TYPE_STRING);
			out.writeUTF(v);
		} else if (value instanceof IntegerValue) {
			int v = ((IntegerValue)value).getValue();
			out.writeByte(TYPE_INTEGER);
			out.writeInt(v);
		} else if (value instanceof RealValue) {
			double v = ((RealValue)value).getValue();
			out.writeByte(TYPE_REAL);
			out.writeDouble(v);
		} else if (value instanceof BooleanValue) {
			boolean v = ((BooleanValue)value).getValue();
			out.writeByte(TYPE_BOOLEAN);
			out.writeBoolean(v);
		} else if (value instanceof ObjectReference) {
			int id = ((ObjectReference)value).getId();
			out.writeByte(TYPE_OBJECT);
			out.writeInt(id);
		} else if ((value instanceof NullValue) || (value == null)) {
			out.writeByte(TYPE_NULL);
		}
	}

	/**
	 * Reads a value from the input stream.
	 * 
	 * @return the value.
	 * @throws IOException
	 */
	protected Value readValue() throws IOException {
		Value ret = null;

		int type = in.readByte() & 0xFF;
		switch (type) {
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
			default:
				break;
		}

		return ret;
	}

	/**
	 * Reads an object reference.
	 * 
	 * @param id
	 *            the object id
	 * @return the {@link ObjectReference}
	 */
	protected abstract ObjectReference readObjectReference(int id);

	/**
	 * Sends a message.
	 * 
	 * @param msg
	 *            the message
	 * @param ack
	 *            the ack
	 * @param args
	 *            the value arguments
	 */
	public void sendMessage(int msg, int ack, List<Value> args) {
		try {
			out.writeByte(msg);
			out.writeByte(ack);
			out.writeInt(args.size());
			for (Iterator<Value> i = args.iterator(); i.hasNext();) {
				writeValue(i.next());
			}
			out.flush();
		} catch (IOException ioe) {
			ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}
	}

	/**
	 * Reads a command.
	 * 
	 * @return the command
	 */
	public ADWPCommand readCommand() {
		ADWPCommand ret = null;
		synchronized (cmds) {
			if (cmds.size() == 0) {
				try {
					cmds.wait();
				} catch (InterruptedException ie) {
					ATLLogger.log(Level.SEVERE, ie.getLocalizedMessage(), ie);
				}
			}
		}

		ret = cmds.remove(0);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		setName("ADWPDebuggee receiver"); //$NON-NLS-1$
		try {
			while (true) {
				ADWPCommand cmd = null;
				int type = in.readByte() & 0xFF;
				int ack = in.readByte() & 0xFF;
				int length = in.readInt();
				switch (type) {
					case CMD_CONTINUE:
					case CMD_STEP:
					case CMD_STEP_OVER:
					case CMD_FINISH:
						cmd = new ADWPCommand(type, ack, new ArrayList<Value>());
						break;

					case CMD_SET_BP:
					case CMD_UNSET_BP:
					case CMD_DISASSEMBLE:
						cmd = new ADWPCommand(type, ack, Arrays.asList(new Value[] {readValue()}));
						break;

					case CMD_QUERY:
					case CMD_GET:
						cmd = new ADWPCommand(type, ack, Arrays
								.asList(new Value[] {readValue(), readValue()}));
						break;
					case CMD_SET:
						cmd = new ADWPCommand(type, ack, Arrays.asList(new Value[] {readValue(), readValue(),
								readValue(),}));
						break;
					case CMD_CALL:
						List<Value> args = new ArrayList<Value>();
						args.add(readValue()); // ObjectReference
						args.add(readValue()); // opName

						for (int i = 0; i < length - 2; i++) {
							args.add(readValue());
						}
						cmd = new ADWPCommand(type, ack, args);
						break;
					default:
						break;
				}
				while (cmds.size() != 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
				synchronized (cmds) {
					cmds.add(cmd);
					cmds.notifyAll();
				}
			}
		} catch (IOException ioe) {
			// do nothing
		}
	}
}
