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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * The ADWP debugger.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPDebugger extends ADWP {

	private int msgId = 1;

	private List<ADWPCommand> nonAnswers = new ArrayList<ADWPCommand>();

	private List<ADWPCommand> answers = new ArrayList<ADWPCommand>();

	/**
	 * Creates a debugger using the given streams.
	 * 
	 * @param in
	 *            the input stream
	 * @param out
	 *            the output stream
	 */
	public ADWPDebugger(InputStream in, OutputStream out) {
		super(in, out);
	}

	/**
	 * Sends a command with the given arguments.
	 * 
	 * @param cmd
	 *            the command
	 * @param args
	 *            the arguments
	 */
	public void sendCommand(int cmd, List<Value> args) {
		realSendCommand(cmd, args);
	}

	private void realSendCommand(int cmd, List<Value> args) {
		try {
			out.writeByte(cmd);
			out.writeByte(msgId++);
			out.writeInt(args.size());
			for (Iterator<Value> i = args.iterator(); i.hasNext();) {
				writeValue(i.next());
			}
			out.flush();
//			if ((cmd == CMD_SET_BP) || (cmd == CMD_UNSET_BP)) {
//				ATLLogger.info("sent : " + cmd + " - " + args); //$NON-NLS-1$ //$NON-NLS-2$
//			}
		} catch (IOException ioe) {
			ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}
	}

	/**
	 * Reads a message.
	 * 
	 * @return the message
	 */
	public ADWPCommand readMessage() {
		ADWPCommand ret = null;
		ret = getMessageFrom(nonAnswers);
		return ret;
	}

	private ADWPCommand getMessageFrom(List<ADWPCommand> list) {
		ADWPCommand ret = null;

		synchronized (list) {
			if (list.size() == 0) {
				try {
					do {
						list.wait();
					} while (list.size() == 0);
				} catch (InterruptedException ie) {
					ATLLogger.log(Level.SEVERE, ie.getLocalizedMessage(), ie);
				}
			}
		}

		ret = list.remove(0);

		return ret;
	}

	/**
	 * Sends a message request to the debuggee.
	 * 
	 * @param cmd
	 *            the command
	 * @param args
	 *            the arguments
	 * @return the return Value
	 */
	public synchronized ADWPCommand requestMessage(int cmd, List<Value> args) {
		ADWPCommand ret = null;

		realSendCommand(cmd, args);
		ret = getMessageFrom(answers);

		return ret;
	}

	/**
	 * Sends a request to the debuggee.
	 * 
	 * @param cmd
	 *            the command
	 * @param args
	 *            the arguments
	 * @return the return Value
	 */
	public synchronized Value request(int cmd, List<Value> args) {
		Value ret = null;
		ADWPCommand acmd = requestMessage(cmd, args);
		ret = acmd.getArgs().get(0);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ADWP#run()
	 */
	@Override
	public void run() {
		setName("ADWPDebugger receiver"); //$NON-NLS-1$
		try {
			while (true) {
				List<ADWPCommand> msgs = null;
				ADWPCommand msg = null;
				int type = in.readByte() & 0xFF;
				int ack = in.readByte() & 0xFF;
				int length = in.readInt();
				switch (type) {
					case MSG_TERMINATED:
						msg = new ADWPCommand(type, ack, Collections.<Value> emptyList());
						msgs = nonAnswers;
						break;
					case MSG_ANS:
						msg = new ADWPCommand(type, ack, Arrays.asList(new Value[] {readValue()}));
						msgs = answers;
						break;

					case MSG_STOPPED:
						msg = new ADWPCommand(type, ack, Arrays.asList(new Value[] {readValue(), readValue(),
								readValue(), readValue(), readValue(),}));
						msgs = nonAnswers;
						break;

					case MSG_DISAS_CODE:
						List<Value> args = new ArrayList<Value>();
						for (int i = 0; i < length; i++) {
							args.add(readValue());
						}
						msg = new ADWPCommand(type, ack, args);
						msgs = answers;
						break;
					default:
						break;
				}
				synchronized (msgs) {
					if (msgs != null) {
						msgs.add(msg);
						msgs.notifyAll();
					}
				}
			}
		} catch (IOException ioe) {
			// do nothing
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ADWP#readObjectReference(int)
	 */
	@Override
	protected ObjectReference readObjectReference(int id) {
		return RemoteObjectReference.valueOf(this, id);
	}

}
