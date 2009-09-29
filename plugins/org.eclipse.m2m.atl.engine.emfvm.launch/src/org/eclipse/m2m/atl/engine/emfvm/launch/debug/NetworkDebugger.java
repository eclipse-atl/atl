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
package org.eclipse.m2m.atl.engine.emfvm.launch.debug;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.debug.core.adwp.ADWPCommand;
import org.eclipse.m2m.atl.debug.core.adwp.IntegerValue;
import org.eclipse.m2m.atl.debug.core.adwp.StringValue;
import org.eclipse.m2m.atl.debug.core.adwp.Value;
import org.eclipse.m2m.atl.engine.emfvm.ASMOperation;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.launch.ITool;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;

/**
 * The main ATL debugger.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class NetworkDebugger implements ITool {

	private ExecEnv execEnv;

	private AbstractStackFrame lastFrame;

	private Map<Integer, Command> commands = new HashMap<Integer, Command>();

	private boolean step;

	private boolean stepOver;

	private boolean finish;

	private boolean finished;

	private int depth;

	private Socket socket;

	private ADWPDebuggee debuggee;

	private List<String> breakpoints = new ArrayList<String>();

	/**
	 * NetworkDebugger constructor.
	 * 
	 * @param port
	 *            connection port
	 * @param suspend
	 *            setp parameter
	 */
	public NetworkDebugger(final int port, boolean suspend) {
		if (suspend) {
			step = true;
		}

		Thread init = new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket server = new ServerSocket(port);
					socket = server.accept();
					server.close();
					debuggee = new ADWPDebuggee(socket.getInputStream(), socket.getOutputStream());
				} catch (IOException ioe) {
					ATLLogger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
				}
			}
		};

		if (suspend) {
			init.run();
		} else {
			init.start();
		}
	}

	public ExecEnv getExecEnv() {
		return execEnv;
	}

	public AbstractStackFrame getLastFrame() {
		return lastFrame;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#enter(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void enter(AbstractStackFrame frame) {
		if (stepOver || finish) {
			depth++;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#leave(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void leave(AbstractStackFrame frame) {
		if ((depth == 0) && finish) {
			step = true;
			finished = true;
		}
		if ((stepOver || finish) && depth > 0) {
			depth--;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#step(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void step(AbstractStackFrame frame) {
		if (execEnv == null) {
			execEnv = frame.getExecEnv();
		}
		this.lastFrame = frame;
		if (stepOver && (depth == 0)) {
			stepOver = false;
			step = true;
		}
		if (step) {
			if (finished) {
				dialog(frame, "after finishing"); //$NON-NLS-1$
			} else {
				dialog(frame, "for stepping"); //$NON-NLS-1$
			}
		} else {
			int location = frame.getLocation();
			ASMOperation operation = (ASMOperation)frame.getOperation();
			String sourceLocation = operation.resolveLineNumber(location);
			if (breakpoints.contains(sourceLocation)) {
				dialog(frame, "for breakpoint"); //$NON-NLS-1$
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#terminated()
	 */
	public void terminated() {
		try {
			debuggee.sendMessage(ADWPDebuggee.MSG_TERMINATED, 0, Collections.<Value>emptyList());
			socket.close();
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#error(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.String, java.lang.Exception)
	 */
	public void error(AbstractStackFrame stackFrame, String msg, Exception e) {
		dialog(stackFrame, "ERROR: " + msg); //$NON-NLS-1$
		if (e != null) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} else {
			if (msg != null) {
				ATLLogger.severe("Message: " + msg); //$NON-NLS-1$
			}
		}
	}

	private void dialog(AbstractStackFrame stFrame, String msg) {
		final boolean debug = false;
		// while (stFrame instanceof NativeStackFrame) {
		// stFrame = stFrame.getParent();
		// }
		AbstractStackFrame frame = stFrame;
		int location = frame.getLocation();
		ASMOperation operation = (ASMOperation)frame.getOperation();
		String opName = operation.getName();
		String sourceLocation = operation.resolveLineNumber(location);

		debuggee.sendMessage(ADWPDebuggee.MSG_STOPPED, 0, Arrays.asList(new Value[] {
				StringValue.valueOf(msg), LocalObjectReference.valueOf(frame, this),
				StringValue.valueOf(opName), IntegerValue.valueOf(location),
				StringValue.valueOf(sourceLocation),}));

		boolean resume = false;
		do {
			ADWPCommand acmd = debuggee.readCommand();
			if (debug) {
				ATLLogger.info(acmd.toString());
			}

			resume = false;
			step = false;
			stepOver = false;
			finish = false;
			finished = false;

			Command cmd = commands.get(Integer.valueOf(acmd.getCode()));
			if (cmd == null) {
				ATLLogger.warning("unsupported command: " + acmd.getCode()); //$NON-NLS-1$
			} else {
				resume = cmd.doIt(acmd, frame);
			}

		} while (!resume);
	}

	/**
	 * A debugger command.
	 */
	protected abstract class Command {

		private String description;

		/**
		 * Creates a new command.
		 * 
		 * @param cmd
		 *            the command id
		 * @param description
		 *            the command description
		 */
		public Command(int cmd, String description) {
			this.description = description;
			commands.put(Integer.valueOf(cmd), this);
		}

		/**
		 * Performs the command's action and returns <code>true</code> if the program should be resumed.
		 * 
		 * @param cmd
		 *            the command
		 * @param frame
		 *            the frame
		 * @return returns <code>true</code> if the program should be resumed.
		 */
		public abstract boolean doIt(ADWPCommand cmd, AbstractStackFrame frame);

		/**
		 * Returns the command description.
		 * 
		 * @return the command description
		 */
		public String getDescription() {
			return description;
		}
	}

	{

		// BEGIN Data inspection commands
		new Command(ADWPDebuggee.CMD_GET, "get a property from an object") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				List<Value> args = cmd.getArgs();
				LocalObjectReference o = (LocalObjectReference)args.get(0);
				String propName = ((StringValue)args.get(1)).getValue();
				Value ret = o.get(propName);
				debuggee.sendMessage(ADWPDebuggee.MSG_ANS, cmd.getAck(), Arrays.asList(new Value[] {ret}));
				return false;
			}
		};
		new Command(ADWPDebuggee.CMD_SET, "set a property to an object") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				List<Value> args = cmd.getArgs();
				LocalObjectReference o = (LocalObjectReference)args.get(0);
				String propName = ((StringValue)args.get(1)).getValue();
				Value value = args.get(2);
				o.set(propName, value);
				return false;
			}
		};
		new Command(ADWPDebuggee.CMD_CALL, "call an operation on an object") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				List<Value> args = cmd.getArgs();
				LocalObjectReference o = (LocalObjectReference)args.get(0);
				String opName = ((StringValue)args.get(1)).getValue();
				int nbArgs = ((IntegerValue)args.get(2)).getValue();
				List<Value> realArgs = (nbArgs == 0) ? new ArrayList<Value>() : args.subList(3, args.size());
				Value ret = o.call(opName, realArgs);
				debuggee.sendMessage(ADWPDebuggee.MSG_ANS, cmd.getAck(), Arrays.asList(new Value[] {ret}));
				return false;
			}
		};
		// CMD_QUERY does not work yet
		new Command(ADWPDebuggee.CMD_QUERY, "executes a query in the current context") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				// List args = cmd.getArgs();
				// String query = ((StringValue)args.get(1)).getValue();
				//
				// Object asmRet = null;
				// try {
				// ASM asm = new ASMXMLReader().read(new ByteArrayInputStream(query.getBytes()));
				// ASMOperation op = asm.getOperation("test");
				// ASMModule asmModule = new ASMModule(asm);
				// List arguments = new ArrayList();
				// arguments.add(0, asmModule);
				// ASMExecEnv env = new ASMExecEnv(asmModule, debugger);
				// Map models = execEnv.getModels();
				// for (Iterator i = models.keySet().iterator(); i.hasNext();) {
				// String mname = (String)i.next();
				// env.addModel(mname, (ASMModel)models.get(mname));
				// }
				// env.registerOperations(asm);
				// Map pvalues = new HashMap();
				// AbstractStackFrame asmFrame = frame;
				// for (Iterator i = asmFrame.getLocalVariables().keySet().iterator(); i.hasNext();) {
				// String slot = (String)i.next();
				// String pname;
				// if (slot.equals("_stack")) {
				// pname = slot;
				// } else {
				// pname = asmFrame.resolveVariableName(Integer.parseInt(slot));
				// }
				// pvalues.put(pname, asmFrame.getVariable(slot));
				// }
				// for (Iterator i = op.getParameters().iterator(); i.hasNext();) {
				// ASMParameter p = (ASMParameter)i.next();
				// String pname = op.resolveVariableName(Integer.parseInt(p.getName()), 0);
				// ASMOclAny value = (ASMOclAny)pvalues.get(pname);
				// arguments.add(value);
				// }
				// StackFrame qframe = ASMStackFrame.rootFrame(env, op, arguments);
				// asmRet = op.exec(qframe);
				// } catch (Exception e) {
				// ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				// }
				// Value ret = LocalObjectReference.asm2value(asmRet, thisDebugger);
				//
				// debuggee.sendMessage(ADWPDebuggee.MSG_ANS, cmd.getAck(), Arrays.asList(new Value[] {ret}));
				return false;
			}
		};
		// END Data inspection commands

		// BEGIN Execution control commands
		new Command(ADWPDebuggee.CMD_CONTINUE, "resume program execution") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_STEP, "execute a single instruction; stepping into method calls") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				step = true;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_STEP_OVER, "execute a single instruction; stepping over method calls") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				stepOver = true;
				depth = 0;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_FINISH, "run until after the execution of the current operation") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				finish = true;
				depth = 0;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_SET_BP, "set a breakpoint") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				List<Value> args = cmd.getArgs();
				String location = ((StringValue)args.get(0)).getValue();
				breakpoints.add(location);
				return false;
			}
		};
		new Command(ADWPDebuggee.CMD_UNSET_BP, "unset a breakpoint") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				List<Value> args = cmd.getArgs();
				String location = ((StringValue)args.get(0)).getValue();
				breakpoints.remove(location);
				return false;
			}
		};
		// END Execution control commands

		// BEGIN Code commands
		new Command(ADWPDebuggee.CMD_DISASSEMBLE, "disassemble current operation") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, AbstractStackFrame frame) {
				ASMOperation op = (ASMOperation)((StackFrame)((LocalObjectReference)cmd.getArgs().get(0))
						.getObject()).getOperation();
				List<?> instr = op.getInstructions();
				List<Value> msgArgs = new ArrayList<Value>();

				int k = 0;
				for (Iterator<?> i = instr.iterator(); i.hasNext();) {
					String inst = i.next().toString();
					if (inst.startsWith("load ")) { //$NON-NLS-1$
						inst = "load " + op.resolveVariableName(Integer.parseInt(inst.substring(5)), k); //$NON-NLS-1$
					} else if (inst.startsWith("store ")) { //$NON-NLS-1$
						inst = "store " + op.resolveVariableName(Integer.parseInt(inst.substring(6)), k); //$NON-NLS-1$
					}
					msgArgs.add(StringValue.valueOf(inst));
					k++;
				}
				debuggee.sendMessage(ADWPDebuggee.MSG_DISAS_CODE, cmd.getAck(), msgArgs);
				return false;
			}
		};
		/*
		 * new Command("source", "display source location") { public boolean doIt(String[] args, StackFrame
		 * frame) { String id =
		 * ((ASMOperation)frame.getOperation()).resolveLineNumber(((ASMStackFrame)frame).getLocation());
		 * out.println(id + "\r"); return false; } };
		 */
		// END Code commands
	}
}
