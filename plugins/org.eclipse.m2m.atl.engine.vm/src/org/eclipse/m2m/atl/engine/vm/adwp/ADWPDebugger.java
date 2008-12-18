/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.adwp;

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
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPDebugger extends ADWP {

	public ADWPDebugger(InputStream in, OutputStream out) {
		super(in, out);
	}

	public void sendCommand(int cmd, List args) {
		realSendCommand(cmd, args);
	}

	private void realSendCommand(int cmd, List args) {
		try {
			out.writeByte(cmd);
			out.writeByte(msgId++);
			out.writeInt(args.size());
			for (Iterator i = args.iterator(); i.hasNext();) {
				writeValue((Value)i.next());
			}
			out.flush();
			if ((cmd == CMD_SET_BP) || (cmd == CMD_UNSET_BP)) {
				ATLLogger.info("sent : " + cmd + " - " + args);
			}
		} catch (IOException ioe) {
			ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}
	}

	public ADWPCommand readMessage() {
		ADWPCommand ret = null;

		ret = getMessageFrom(nonAnswers);

		return ret;
	}

	private ADWPCommand getMessageFrom(List list) {
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

		ret = (ADWPCommand)list.remove(0);

		return ret;
	}

	public synchronized ADWPCommand requestMessage(int cmd, List args) {
		ADWPCommand ret = null;

		realSendCommand(cmd, args);
		ret = getMessageFrom(answers);

		return ret;
	}

	public synchronized Value request(int cmd, List args) {
		Value ret = null;

		ADWPCommand acmd = requestMessage(cmd, args);
		ret = (Value)acmd.getArgs().get(0);

		return ret;
	}

	public void run() {
		setName("ADWPDebugger receiver");
		try {
			while (true) {
				List msgs = null;
				ADWPCommand msg = null;
				int type = in.readByte() & 0xFF;
				int ack = in.readByte() & 0xFF;
				int length = in.readInt();
				switch (type) {
					case MSG_TERMINATED:
						msg = new ADWPCommand(type, ack, Collections.EMPTY_LIST);
						msgs = nonAnswers;
						break;
					case MSG_ANS:
						msg = new ADWPCommand(type, ack, Arrays.asList(new Object[] {readValue()}));
						msgs = answers;
						break;

					case MSG_STOPPED:
						msg = new ADWPCommand(type, ack, Arrays.asList(new Object[] {readValue(),
								readValue(), readValue(), readValue(), readValue()}));
						msgs = nonAnswers;
						break;

					case MSG_DISAS_CODE:
						List args = new ArrayList();
						for (int i = 0; i < length; i++) {
							args.add(readValue());
						}
						msg = new ADWPCommand(type, ack, args);
						msgs = answers;
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
		}
	}

	protected ObjectReference readObjectReference(int id) {
		return RemoteObjectReference.valueOf(this, id);
	}

	private int msgId = 1;

	private List nonAnswers = new ArrayList();

	private List answers = new ArrayList();
}
