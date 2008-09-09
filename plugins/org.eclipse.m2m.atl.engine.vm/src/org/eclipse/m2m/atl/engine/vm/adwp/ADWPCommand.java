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

import java.util.List;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPCommand {

	public ADWPCommand(int code, int ack, List args) {
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

	public List getArgs() {
		return args;
	}

	public String toString() {
		String ret = "ADWPCommand ";

		switch(code) {
			case ADWP.CMD_CONTINUE:
				ret += "CONTINUE";
				break;
			case ADWP.CMD_STEP:
				ret += "STEP";
				break;
			case ADWP.CMD_STEP_OVER:
				ret += "STEP_OVER";
				break;
			case ADWP.CMD_FINISH:
				ret += "FINISH";
				break;

			case ADWP.CMD_GET:
				ret += "GET";
				break;
			case ADWP.CMD_SET:
				ret += "SET";
				break;
			case ADWP.CMD_CALL:
				ret += "CALL";
				break;

			case ADWP.CMD_SET_BP:
				ret += "SET_BP";
				break;
			case ADWP.CMD_UNSET_BP:
				ret += "UNSET_BP";
				break;
		}

		ret += " " + args;

		return ret;
	}

	private int code;
	private int ack;
	private List args;
}

