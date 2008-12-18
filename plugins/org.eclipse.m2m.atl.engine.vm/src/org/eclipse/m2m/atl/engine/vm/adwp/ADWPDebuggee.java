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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPDebuggee extends ADWP {

	public ADWPDebuggee(InputStream in, OutputStream out) {
		super(in, out);
	}

	public void sendMessage(int msg, int ack, List args) {
		try {
			out.writeByte(msg);
			out.writeByte(ack);
			out.writeInt(args.size());
			for (Iterator i = args.iterator(); i.hasNext();) {
				writeValue((Value)i.next());
			}
			out.flush();
		} catch (IOException ioe) {
			ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}
	}

	public ADWPCommand readCommand() {
		ADWPCommand ret = null;

		synchronized(cmds) {
			if (cmds.size() == 0) {
				try {
					cmds.wait();
				} catch (InterruptedException ie) {
					ATLLogger.log(Level.SEVERE, ie.getLocalizedMessage(), ie);
				}
			}
		}

		ret = (ADWPCommand)cmds.remove(0);

		return ret;
	}

	public void run() {
		setName("ADWPDebuggee receiver");
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
						cmd = new ADWPCommand(type, ack, new ArrayList());
						break;

					case CMD_SET_BP:
					case CMD_UNSET_BP:
					case CMD_DISASSEMBLE:
						cmd = new ADWPCommand(type, ack, Arrays.asList(new Object[] {readValue()}));
						break;

					case CMD_QUERY:
					case CMD_GET:
						cmd = new ADWPCommand(type, ack, Arrays
								.asList(new Object[] {readValue(), readValue()}));
						break;
					case CMD_SET:
						cmd = new ADWPCommand(type, ack, Arrays.asList(new Object[] {readValue(),
								readValue(), readValue()}));
						break;
					case CMD_CALL:
						List args = new ArrayList();
						args.add(readValue()); // ObjectReference
						args.add(readValue()); // opName

						for (int i = 0; i < length - 2; i++) {
							args.add(readValue());
						}
						cmd = new ADWPCommand(type, ack, args);
						break;

				}
				while (cmds.size() != 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
				synchronized(cmds) {
					cmds.add(cmd);
					cmds.notifyAll();
				}
			}
		} catch (IOException ioe) {
		}
	}

	protected ObjectReference readObjectReference(int id) {
		return LocalObjectReference.valueOf(id);
	}

	private List cmds = new ArrayList();
}
