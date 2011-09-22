/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.debug;

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

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.common.util.EList;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.debug.core.adwp.ADWPCommand;
import org.eclipse.m2m.atl.debug.core.adwp.IntegerValue;
import org.eclipse.m2m.atl.debug.core.adwp.StringValue;
import org.eclipse.m2m.atl.debug.core.adwp.Value;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.launcher.EmftvmLauncherPlugin;
import org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Implements all debugging facilities specified by {@link org.eclipse.m2m.atl.emftvm.util.VMMonitor}
 * using ATL's {@link org.eclipse.m2m.atl.debug.core.adwp.ADWP} protocol.
 * Adapted from org.eclipse.m2m.atl.engine.emfvm.launch.debug.NetworkDebugger.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class NetworkDebugger extends LaunchAdapter {

	private Socket socket;
	private ADWPDebuggee debuggee;
	private StackFrame lastFrame;
	private boolean step;
	private boolean stepOver;
	private boolean finish;
	private boolean finished;
	private int depth;
	private Map<Integer, Command> commands = new HashMap<Integer, Command>();
	private List<String> breakpoints = new ArrayList<String>();

	/**
	 * Creates a new {@link NetworkDebugger}.
	 * @param launch the launch object to wrap
	 * @param port the network port to listen to
	 * @param suspend whether to start suspended
	 */
	public NetworkDebugger(ILaunch launch, final int port, boolean suspend) {
		super(launch);
		if (suspend) {
			step = true;
		}

		final Thread init = new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket server = new ServerSocket(port);
					socket = server.accept();
					server.close();
					debuggee = new ADWPDebuggee(socket.getInputStream(), socket.getOutputStream());
				} catch (IOException ioe) {
					EmftvmLauncherPlugin.log(ioe);
				}
			}
		};

		if (suspend) {
			init.run();
		} else {
			init.start();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter#enter(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	@Override
	public void enter(StackFrame frame) {
		super.enter(frame);
		if (stepOver || finish) {
			depth++;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter#leave(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	@Override
	public void leave(StackFrame frame) {
		super.leave(frame);
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
	 * @see org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter#step(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	@Override
	public void step(StackFrame frame) {
		super.step(frame);
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
			final String sourceLocation = frame.getSourceLocation();
			if (breakpoints.contains(sourceLocation)) {
				dialog(frame, "for breakpoint"); //$NON-NLS-1$
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter#terminated()
	 */
	@Override
	public void terminated() {
		super.terminated();
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
	 * @see org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter#error(StackFrame, String, Exception)
	 */
	public void error(StackFrame stackFrame, String msg, Exception e) {
		dialog(stackFrame, "ERROR: " + msg); //$NON-NLS-1$
	}

	/**
	 * Returns the last stack frame, if available.
	 * @return the lastFrame, or <code>null</code>
	 */
	public StackFrame getLastFrame() {
		return lastFrame;
	}

	/**
	 * Returns the {@link ExecEnv}, if available.
	 * @return the {@link ExecEnv}, or <code>null</code>
	 */
	public ExecEnv getExecEnv() {
		final StackFrame frame = getLastFrame();
		return frame == null ? null : frame.getEnv();
	}

	/**
	 * Sends a STOPPED message to the debuggee.
	 * @param frame the current stack frame
	 * @param msg the message contents
	 */
	private void dialog(StackFrame frame, String msg) {
		final boolean debug = false;
		final CodeBlock cb = frame.getCodeBlock();
		final String opName = cb == null ? frame.getNativeMethod().toString() : cb.toString();

		StackFrame sourceFrame = frame;
		while (sourceFrame.getCodeBlock() == null) {
			sourceFrame = frame.getParent();
		}
		final int location = sourceFrame.getLocation();
		final String sourceLocation = sourceFrame.getSourceLocation();

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
		public abstract boolean doIt(ADWPCommand cmd, StackFrame frame);

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
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
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
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
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
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
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
		new Command(ADWPDebuggee.CMD_QUERY, "executes a query in the current context") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				//TODO CMD_QUERY does not work yet
				return false;
			}
		};
		// END Data inspection commands

		// BEGIN Execution control commands
		new Command(ADWPDebuggee.CMD_CONTINUE, "resume program execution") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_STEP, "execute a single instruction; stepping into method calls") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				step = true;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_STEP_OVER, "execute a single instruction; stepping over method calls") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				stepOver = true;
				depth = 0;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_FINISH, "run until after the execution of the current operation") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				finish = true;
				depth = 0;
				return true;
			}
		};
		new Command(ADWPDebuggee.CMD_SET_BP, "set a breakpoint") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				List<Value> args = cmd.getArgs();
				String location = ((StringValue)args.get(0)).getValue();
				breakpoints.add(location);
				return false;
			}
		};
		new Command(ADWPDebuggee.CMD_UNSET_BP, "unset a breakpoint") { //$NON-NLS-1$
			@Override
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
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
			public boolean doIt(ADWPCommand cmd, StackFrame frame) {
				final CodeBlock op = ((StackFrame)((LocalObjectReference)cmd.getArgs().get(0))
						.getObject()).getCodeBlock();
				EList<Instruction> instr = op.getCode();
				List<Value> msgArgs = new ArrayList<Value>();

				for (Iterator<Instruction> i = instr.iterator(); i.hasNext();) {
					String inst = i.next().toString();
					msgArgs.add(StringValue.valueOf(inst));
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
