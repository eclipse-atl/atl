/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.m2m.atl.debug.core.adwp.ADWP;
import org.eclipse.m2m.atl.debug.core.adwp.ADWPCommand;
import org.eclipse.m2m.atl.debug.core.adwp.ADWPDebugger;
import org.eclipse.m2m.atl.debug.core.adwp.BooleanValue;
import org.eclipse.m2m.atl.debug.core.adwp.IntegerValue;
import org.eclipse.m2m.atl.debug.core.adwp.ObjectReference;
import org.eclipse.m2m.atl.debug.core.adwp.StringValue;
import org.eclipse.m2m.atl.debug.core.adwp.Value;

/**
 * A debug target is a debuggable execution context. It's the root of the element hierarchy. The
 * AtlDebugTarget contains only one thread : the main thread. The thread contains the current stackframe
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlDebugTarget extends AtlDebugElement implements IDebugTarget {

	/**
	 * Constant state possible for the debugger.
	 */
	/** Terminated. */
	public static final int STATE_TERMINATED = 0;

	/** Running. */
	public static final int STATE_RUNNING = 1;

	/** Suspended. */
	public static final int STATE_SUSPENDED = 2;

	/** Disconnected. */
	public static final int STATE_DISCONNECTED = 3;

	/**
	 * Constant action possible for the debugger.
	 */
	static final int TERMINATE = 0;

	static final int SUSPEND = 1;

	static final int STEP_RETURN = 2;

	static final int STEP_OVER = 3;

	static final int STEP_INTO = 4;

	static final int SUSPEND_STEP = 5;

	static final int RESUME = 6;

	static final int CREATE = 7;

	/**
	 * The current state of the debugger.
	 */
	private int state;

	private ADWPDebugger debugger;

	private ILaunch launch;

	private boolean disassemblyMode;

	private String prevLocation;

	/**
	 * Name of the process.
	 */
	private String processName = AtlDebugModelConstants.DEBUGTARGETNAME;

	private String port = AtlDebugModelConstants.NULL;

	private String host = AtlDebugModelConstants.NULL;

	private Socket socket;

	private String messageFromDebuggee = ""; //$NON-NLS-1$

	/**
	 * The array of threads of the debug target In ATL, there is only one thread --> the main thread.
	 */
	private AtlThread[] threads;

	/**
	 * The current AtlStackFrame which contains the current current stackframe For the moment, only the
	 * current stackframe can be accessed.
	 */
	// private AtlStackFrame cf;
	private AtlNbCharFile structFile;

	private Pattern moduleName = Pattern.compile("^.*/(.*)\\.a(tl|sm)$"); //$NON-NLS-1$

	private boolean stopInMain;

	/**
	 * Creates an new Debug target for the given launch.
	 * 
	 * @param launch
	 *            the launch to debug
	 */
	public AtlDebugTarget(ILaunch launch) {
		super(null);
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		// DebugPlugin.getDefault().addDebugEventListener(this);

		try {
			disassemblyMode = Boolean.valueOf(
					(String)(launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.OPTIONS,
							Collections.<String, String> emptyMap())).get("disassemblyMode")) //$NON-NLS-1$
					.booleanValue();
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}
		state = STATE_DISCONNECTED;
		this.launch = launch;
	}

	public void setStopInMain(boolean stopInMain) {
		this.stopInMain = stopInMain;
	}

	/**
	 * Starts debug.
	 */
	public void start() {
		try {
			// Connection
			do {
				try {
					try {
						port = launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.PORT,
								new Integer(ATLLaunchConstants.DEFAULT_PORT).toString());
						host = launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.HOST,
								AtlDebugModelConstants.HOST);
						if (port.equals("")) { //$NON-NLS-1$
							port = new Integer(ATLLaunchConstants.DEFAULT_PORT).toString();
						}
						if (host.equals("")) { //$NON-NLS-1$
							host = AtlDebugModelConstants.HOST;
						}
						socket = new Socket(host, Integer.parseInt(port));
					} catch (CoreException e1) {
						ATLLogger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
					}
				} catch (ConnectException ce) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ATLLogger.severe(Messages.getString("AtlDebugTarget.CONNECTIONPROBLEMS")); //$NON-NLS-1$
					}
				}
			} while (socket == null);

			debugger = new ADWPDebugger(socket.getInputStream(), socket.getOutputStream());
			ATLLogger.fine(Messages.getString("AtlDebugTarget.CONNECTED")); //$NON-NLS-1$
			state = STATE_SUSPENDED;

			threads = new AtlThread[1];
			threads[0] = new AtlThread(AtlDebugModelConstants.THREADNAME, this);

			IBreakpoint[] bpArray = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
					getModelIdentifier());
			for (int i = 0; i < bpArray.length; i++) {
				breakpointAdded(bpArray[i]);
			}
		} catch (UnknownHostException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		Thread th = new Thread() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				ADWPCommand msg;
				prevLocation = null;

				generateDebugEvent(AtlDebugTarget.CREATE, AtlDebugTarget.this);

				while (true) {
					msg = debugger.readMessage();
					if (msg.getCode() == ADWP.MSG_TERMINATED) {
						break;
					}

					messageFromDebuggee = ((StringValue)msg.getArgs().get(0)).getValue();

					ObjectReference currentFrame = (ObjectReference)msg.getArgs().get(1);
					String sourceLocation = ((StringValue)msg.getArgs().get(4)).getValue();
					if (sourceLocation.equals("<null>") && !disassemblyMode) { //$NON-NLS-1$
						debugger.sendCommand(ADWP.CMD_STEP, Arrays.asList(new Value[] {}));
					} else if (sourceLocation.equals(prevLocation) && !disassemblyMode) {
						debugger.sendCommand(ADWP.CMD_STEP, Arrays.asList(new Value[] {}));
					} else {
						ObjectReference stack = (ObjectReference)currentFrame.call(
								"getStack", Collections.<Value> emptyList()); //$NON-NLS-1$
						int n = ((IntegerValue)stack.call("size", Collections.<Value> emptyList())).getValue(); //$NON-NLS-1$
						AtlStackFrame[] frames = new AtlStackFrame[n];
						for (int i = 1; i <= n; i++) {
							ObjectReference stackFrame = (ObjectReference)stack.call(
									"at", Arrays.asList(new Value[] {IntegerValue.valueOf(i)})); //$NON-NLS-1$
							try {
								String fileName = getPathFrom(stackFrame);
								IWorkspace wks = ResourcesPlugin.getWorkspace();
								IWorkspaceRoot wksroot = wks.getRoot();

								IFile file = wksroot.getFile(new Path(fileName));
								file.refreshLocal(IResource.DEPTH_ZERO, null);

								structFile = new AtlNbCharFile(file.getContents());

								frames[n - i] = new AtlStackFrame(threads[0], stackFrame, structFile, file);
							} catch (CoreException e1) {
								ATLLogger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
							}
						}
						threads[0].setStackFrames(frames);

						setState(AtlDebugTarget.STATE_SUSPENDED);
						generateDebugEvent(AtlDebugTarget.SUSPEND_STEP, AtlDebugTarget.this);

						prevLocation = sourceLocation;
					}
				}
				// TERMINATE
				setState(AtlDebugTarget.STATE_SUSPENDED);
				try {
					terminate();
				} catch (DebugException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		};
		th.start();
		if (!stopInMain) {
			setState(AtlDebugTarget.STATE_RUNNING);
			generateDebugEvent(RESUME, this);
			debugger.sendCommand(ADWP.CMD_CONTINUE, Arrays.asList(new Value[] {}));
		}
	}

	/**
	 * Returns the path from the launch configuration that matches the name of the ASMOperation's container.
	 * 
	 * @param stackFrame
	 *            A StackFrame reference containing an ASMOperation
	 * @return The path from the launch configuration that matches the name of the ASMOperation's container
	 * @throws CoreException
	 *             if the launch configuration could not be read
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private String getPathFrom(final ObjectReference stackFrame) throws CoreException {
		String path = null;

		final ObjectReference operation = (ObjectReference)stackFrame.call(
				"getOperation", Collections.<Value> emptyList()); //$NON-NLS-1$
		Assert.isNotNull(operation);
		final ObjectReference asm = (ObjectReference)operation.call("getASM", Collections.<Value> emptyList()); //$NON-NLS-1$
		Assert.isNotNull(asm);
		final Value version = asm.call("getVersion", Collections.<Value> emptyList()); //$NON-NLS-1$
		Assert.isTrue(version instanceof StringValue);
		
		if ("ETVM".equals(((StringValue)version).getValue())) { // This thing sits in a located EMF Resource
			final ObjectReference res = (ObjectReference)asm.call("eResource", Collections.<Value> emptyList()); //$NON-NLS-1$
			Assert.isNotNull(res);
			final ObjectReference uri = (ObjectReference)res.call("getURI", Collections.<Value> emptyList()); //$NON-NLS-1$
			Assert.isNotNull(uri);
			final boolean isPR = ((BooleanValue)uri.call("isPlatformResource", Collections.<Value> emptyList())).getValue(); //$NON-NLS-1$
			if (isPR) {
				String pStr = ((StringValue)uri.call("toPlatformString", Collections.<Value> singletonList(BooleanValue.valueOf(true)))).getValue(); //$NON-NLS-1$
				final String sName = ((StringValue)asm.call("getSourceName", Collections.<Value> emptyList())).getValue(); //$NON-NLS-1$
				if (sName != null) {
					pStr = pStr.substring(0, pStr.lastIndexOf('/') + 1) + sName;
				}
				return pStr;
			}
		}
		
		final String asmName = ((StringValue)asm.call("getName", Collections.<Value> emptyList())).getValue(); //$NON-NLS-1$
		Assert.isNotNull(asmName);

		final ILaunchConfiguration configuration = launch.getLaunchConfiguration();
		final List<String> superimpose = configuration.getAttribute(ATLLaunchConstants.SUPERIMPOSE, Collections
				.<String> emptyList());
		for (final Iterator<String> i = superimpose.iterator(); i.hasNext();) {
			path = i.next();
			if (asmName.equals(getAsmNameFrom(path))) {
				return path.substring(0, path.length() - 3) + "atl"; //$NON-NLS-1$
			}
		}
		final Map<String, String> libraries = configuration.getAttribute(ATLLaunchConstants.LIBS,
				new HashMap<String, String>());
		for (final Iterator<String> i = libraries.keySet().iterator(); i.hasNext();) {
			String lib = i.next();
			path = libraries.get(lib);
			if (asmName.equals(lib) || asmName.equals(getAsmNameFrom(path))) {
				return path.substring(0, path.length() - 3) + "atl"; //$NON-NLS-1$
			}
		}
		path = configuration
				.getAttribute(ATLLaunchConstants.ATL_FILE_NAME, ATLLaunchConstants.NULL_PARAMETER);

		return path;
	}

	/**
	 * Gets the ASM name by path.
	 * 
	 * @param path
	 *            A filename path that contains the name of a .asm or .atl file
	 * @return The basename of the .asm or .atl file, if found, null otherwise
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private String getAsmNameFrom(String path) {
		String asmName = null;
		Matcher m = moduleName.matcher(path);
		if (m.find()) {
			asmName = m.group(1);
		}
		return asmName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		AtlBreakpoint ab = (AtlBreakpoint)breakpoint;
		String location = ""; //$NON-NLS-1$
		Boolean enabled = Boolean.FALSE;
		try {
			location = (String)ab.getMarker().getAttribute(IMarker.LOCATION);
			enabled = (Boolean)ab.getMarker().getAttribute(IBreakpoint.ENABLED);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

			return;
		}

		if (enabled.booleanValue()) {
			List<Value> parameter = new ArrayList<Value>();
			parameter.add(StringValue.valueOf(location));
			debugger.sendCommand(ADWP.CMD_SET_BP, parameter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint,
	 *      org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if(!(breakpoint instanceof AtlBreakpoint)) {
			return;
		}
		AtlBreakpoint ab = (AtlBreakpoint)breakpoint;
		String location = ""; //$NON-NLS-1$
		Boolean enabled = Boolean.FALSE;
		try {
			location = (String)ab.getMarker().getAttribute(IMarker.LOCATION);
			enabled = (Boolean)ab.getMarker().getAttribute(IBreakpoint.ENABLED);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

			return;
		}

		List<Value> parameter = new ArrayList<Value>();
		parameter.add(StringValue.valueOf(location));

		if (enabled.booleanValue()) {
			debugger.sendCommand(ADWP.CMD_SET_BP, parameter);
		} else {
			debugger.sendCommand(ADWP.CMD_UNSET_BP, parameter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint,
	 *      org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {

		AtlBreakpoint ab = (AtlBreakpoint)breakpoint;
		String location = ""; //$NON-NLS-1$
		try {
			location = (String)ab.getMarker().getAttribute(IMarker.LOCATION);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);

			return;
		}

		List<Value> parameter = new ArrayList<Value>();
		parameter.add(StringValue.valueOf(location));

		debugger.sendCommand(ADWP.CMD_UNSET_BP, parameter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		return !isDisconnected();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return state != STATE_DISCONNECTED && state != STATE_RUNNING && state != STATE_TERMINATED;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return !isTerminated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
		setState(AtlDebugTarget.STATE_DISCONNECTED);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.AtlDebugElement#getDebugTarget()
	 */
	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.AtlDebugElement#getLaunch()
	 */
	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	/**
	 * {@inheritDoc} Not use in ATL debugger.
	 * 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	public String getName() throws DebugException {
		return processName;
	}

	/**
	 * {@inheritDoc} Not use in ATL debugger.
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	public IProcess getProcess() {
		return null;
	}

	/**
	 * {@inheritDoc} In our context, this method returns an array with only the main thread.
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	public IThread[] getThreads() throws DebugException {
		return threads;
	}

	/**
	 * {@inheritDoc} In ATL, there is always one and only one thread : the main thread.
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		return getThreads() != null && getThreads().length > 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		return state == STATE_DISCONNECTED;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return state == STATE_SUSPENDED;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return state == STATE_TERMINATED;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		if (!isSuspended()) {
			return;
		}

		prevLocation = null;
		setState(AtlDebugTarget.STATE_RUNNING);
		generateDebugEvent(RESUME, this);
		debugger.sendCommand(ADWP.CMD_CONTINUE, Arrays.asList(new Value[] {}));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint instanceof AtlBreakpoint;
	}

	/**
	 * {@inheritDoc} Not use in our context.
	 * 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		if (isSuspended()) {
			return;
		}

		setState(AtlDebugTarget.STATE_SUSPENDED);
		generateDebugEvent(SUSPEND, this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		if (!isSuspended()) {
			return;
		}

		setState(AtlDebugTarget.STATE_TERMINATED);
		debugger.sendCommand(ADWP.CMD_FINISH, Arrays.asList(new Value[] {}));
		generateDebugEvent(TERMINATE, this);

		// TODO check for "regression"
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
	}

	/**
	 * Returns the debugger.
	 * 
	 * @return the debugger
	 */
	public ADWPDebugger getDebugger() {
		return debugger;
	}

	/**
	 * Returns the state.
	 * 
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * The state corresponding to the state of the debugger (running, disconnected ...) This method allows to
	 * update state.
	 * 
	 * @param state
	 *            The state to set.
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * This method generate a debug event corresponding to the command in parameter This allows for example to
	 * prevent DebugUI that there is an action execute. In this case, DebugUI update the display.
	 * 
	 * @param command
	 * @param contextObject
	 */
	void generateDebugEvent(final int command, final IDebugElement contextObject) {
		final DebugEvent event;
		try {
			switch (command) {
				case CREATE:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.CREATE);
					break;
				case STEP_INTO:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.RESUME,
							DebugEvent.STEP_INTO);
					break;
				case STEP_OVER:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.RESUME,
							DebugEvent.STEP_OVER);
					break;
				case STEP_RETURN:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.RESUME,
							DebugEvent.STEP_RETURN);
					break;
				case RESUME:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.RESUME);
					break;
				case SUSPEND:
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.SUSPEND,
							DebugEvent.CLIENT_REQUEST);
					break;
				case TERMINATE:
					event = new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE);
					break;
				case SUSPEND_STEP: // The VM signals it has stopped
					event = new DebugEvent(getDebugTarget().getThreads()[0], DebugEvent.SUSPEND,
							DebugEvent.BREAKPOINT);
					break;
				default:
					return;
			}
			final DebugEvent[] debugEvents = new DebugEvent[] {event};
			DebugPlugin.getDefault().fireDebugEventSet(debugEvents);
		} catch (DebugException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * This method allows to receive DebugEvent sent.
	 * 
	 * @param events
	 *            the handled event
	 * @see org.eclipse.debug.core.IDebugEventSetListener#handleDebugEvents(org.eclipse.debug.core.DebugEvent[])
	 */
	public void handleDebugEvents(final DebugEvent[] events) {
		for (int i = 0; i < events.length; i++) {
			if (events[i].getDetail() == DebugEvent.SUSPEND) {
				setState(AtlDebugTarget.STATE_SUSPENDED);
			}
		}
	}

	public boolean isDisassemblyMode() {
		return disassemblyMode;
	}

	/**
	 * Sets the disassembly mode.
	 * 
	 * @param disassemblyMode
	 *            the disassemblyMode to set
	 */
	public void setDisassemblyMode(boolean disassemblyMode) {
		this.disassemblyMode = disassemblyMode;
	}

	/**
	 * Sets the previous location.
	 * 
	 * @param prevLocation
	 *            the prevLocation to set
	 */
	public void setPrevLocation(String prevLocation) {
		this.prevLocation = prevLocation;
	}

	/**
	 * Returns the host.
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Returns the port.
	 * 
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Returns the messageFromDebuggee.
	 * 
	 * @return the messageFromDebuggee
	 */
	public String getMessageFromDebuggee() {
		return messageFromDebuggee;
	}

}
