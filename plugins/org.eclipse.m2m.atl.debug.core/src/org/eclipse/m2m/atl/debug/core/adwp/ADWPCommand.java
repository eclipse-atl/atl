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

import java.util.List;

/**
 * A command part of the ADWP protocol.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPCommand {

	private int code;

	private int ack;

	private List<Value> args;

	/**
	 * Creates a new command.
	 * 
	 * @param code
	 *            the command code
	 * @param ack
	 *            the command ack
	 * @param args
	 *            the {@link Value} arguments of the command
	 */
	public ADWPCommand(int code, int ack, List<Value> args) {
		this.code = code;
		this.ack = ack;
		this.args = args;
	}

	public int getCode() {
		return code;
	}

	public int getAck() {
		return ack;
	}

	public List<Value> getArgs() {
		return args;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = "ADWPCommand "; //$NON-NLS-1$

		switch (code) {
			case ADWP.CMD_CONTINUE:
				ret += "CONTINUE"; //$NON-NLS-1$
				break;
			case ADWP.CMD_STEP:
				ret += "STEP"; //$NON-NLS-1$
				break;
			case ADWP.CMD_STEP_OVER:
				ret += "STEP_OVER"; //$NON-NLS-1$
				break;
			case ADWP.CMD_FINISH:
				ret += "FINISH"; //$NON-NLS-1$
				break;

			case ADWP.CMD_GET:
				ret += "GET"; //$NON-NLS-1$
				break;
			case ADWP.CMD_SET:
				ret += "SET"; //$NON-NLS-1$
				break;
			case ADWP.CMD_CALL:
				ret += "CALL"; //$NON-NLS-1$
				break;

			case ADWP.CMD_SET_BP:
				ret += "SET_BP"; //$NON-NLS-1$
				break;
			case ADWP.CMD_UNSET_BP:
				ret += "UNSET_BP"; //$NON-NLS-1$
				break;
			default:
				break;
		}

		ret += " " + args; //$NON-NLS-1$

		return ret;
	}
}
