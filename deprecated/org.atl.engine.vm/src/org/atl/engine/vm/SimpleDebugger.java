package org.atl.engine.vm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * A simple ATL VM debugger with step tracing and basic
 * profiling optional capabilities.
 * @author Frédéric Jouault
 */
public class SimpleDebugger implements Debugger {

	public SimpleDebugger(boolean step, List stepops, List deepstepops, List nostepops, List deepnostepops, boolean showStackTrace) {
		this(step, stepops, deepstepops, nostepops, deepnostepops, showStackTrace, false, false);
	}
	
	public SimpleDebugger(boolean step, List stepops, List deepstepops, List nostepops, List deepnostepops, boolean showStackTrace, boolean showSummary, boolean profile) {
		this.step = step;
		this.stepops = stepops;
		this.deepstepops = deepstepops;
		this.nostepops = nostepops;
		this.deepnostepops = deepnostepops;
		this.showStackTrace = showStackTrace;
		this.showSummary = showSummary;
		this.profile = profile;
	}

	public void enter(StackFrame frame) {
		Operation op = frame.getOperation();
		String opName = op.getName();
		
		if(profile) {
			if(op instanceof ASMOperation) {
				OperationCall oc = (OperationCall)operationCalls.get(op);
				if(oc == null) {
					oc = new OperationCall(op);
					operationCalls.put(op, oc);
				}
				oc.incrementCallCount(frame.getArgs());
			}
		}

		if(stepops.contains(opName)) {
			// TODO
		} else if(deepstepops.contains(opName)) {
			stepStack.push(new Boolean(step));
			step = true;
		} else if(nostepops.contains(opName)) {
			// TODO
		} else if(deepnostepops.contains(opName)) {
			stepStack.push(new Boolean(step));
			step = false;
		}

		if(getShowEnter()) {
			if(frame instanceof ASMStackFrame) {
				System.out.println("********************* Entering " + op + " with " + ((ASMStackFrame)frame).getLocalVariables());
			} else {
				System.out.println("********************* Entering " + op + " with " + frame.getArgs());
			}
		}
	}

	public void leave(StackFrame frame) {
		Operation op = frame.getOperation();
		String opName = op.getName();

		if(getShowLeave()) {
			Object ret = null;

			if(frame instanceof ASMStackFrame) {
				if(!((ASMStackFrame)frame).empty())
					ret = ((ASMStackFrame)frame).peek();
			} else {
				ret = ((NativeStackFrame)frame).getRet();
			}
			System.out.println("********************* Leaving " + op + " with " + ret);
		}

		if(stepops.contains(opName)) {
			// TODO
		} else if(deepstepops.contains(opName)) {
			step = ((Boolean)stepStack.pop()).booleanValue();
		} else if(nostepops.contains(opName)) {
			// TODO
		} else if(deepnostepops.contains(opName)) {
			step = ((Boolean)stepStack.pop()).booleanValue();
		}
	}

	private String conv(int i) {
		if(i < 10)
			return "000" + i;
		else if(i < 100)
			return "00" + i;
		else if(i < 1000)
			return "0" + i;
		else
			return "" + i;
	}

	private void printStack(ASMStackFrame frame) {
		if(!true) {
			System.out.println(frame.getLocalStack());
		} else {
			System.out.print("[");
			for(Iterator i = frame.getLocalStack().iterator() ; i.hasNext() ; ) {
				Object o = i.next();
				if(o == null) {
					System.out.print("null");
				} else {
					String s = o.toString();
					if(s.length() > 30) s = s.substring(0, 10) + "..." + s.substring(s.length() - 10);
					System.out.print(s);
				}
				if(i.hasNext())
					System.out.print(", ");
			}
			System.out.println("]");
		}

	}

	public void step(ASMStackFrame frame) {
		instr++;
		if(step) {
			printStack(frame);
			System.out.println(conv(frame.getLocation()) + ": " + ((ASMOperation)frame.getOperation()).getInstructions().get(frame.getLocation()));
		}
	}

	public void error(StackFrame frame, String msg, Exception e) {
		if(getShowStackTrace()) {
			System.out.println("****** BEGIN Stack Trace");
			if(msg != null)
				System.out.println("\tmessage: " + msg);
			if(e != null) {
				System.out.println("\texception: ");
				e.printStackTrace(System.out);
			}
			frame.getExecEnv().printStackTrace();
			System.out.println("****** END Stack Trace");
		}
	}

	public void terminated() {
		if(showSummary || profile) {
			System.out.println("Number of instructions executed: " + instr);
			if(profile) {
				System.out.println("Operation calls:");
				List opCalls = new ArrayList(operationCalls.values());
				Collections.sort(opCalls, Collections.reverseOrder());
				for(Iterator i = opCalls.iterator() ; i.hasNext() ; ) {
					System.out.println("\t" + i.next());
				}
			}
		}
	}

	private boolean getStep() {
		return step;
	}

	private boolean getShowEnter() {
		return step;
	}

	private boolean getShowLeave() {
		return step;
	}

	private boolean getShowStackTrace() {
		return showStackTrace;
	}

	private Stack stepStack = new Stack();

	/** Show stack trace. */
	private boolean showStackTrace;

	/** Show enter and leave */
	private boolean showEnterLeave;

	/** Currently stepping (inherited except if nostep, see below). */
	private boolean step;

	/** List of operations (names so far) which should be stepped regardless of inherited step status. This new step status is not inherited. */
	private List stepops;

	/** List of operations (names so far) which should be stepped regardless of inherited step status. This new step status is inherited. */
	private List deepstepops;

	/** List of operations (names so far) which should not be stepped regardless of inherited step status. This new step status is not inherited. */
	private List nostepops;

	/** List of operations (names so far) which should not be stepped regardless of inherited step status. This new step status is not inherited. */
	private List deepnostepops;

	/** Show summary on termination. */
	private boolean showSummary;
	
	/** Run a simple profiler. */
	private boolean profile;	
	
	/** Profiling information about operation calls. */
	private Map operationCalls = new HashMap();
	
	private class OperationCall implements Comparable {
		public OperationCall(Operation op) {
			this.op = op;
		}
		
		public void incrementCallCount(List args) {
			callCount++;
			Integer ccba = (Integer)callCountByArgs.get(args);
			int ccbai = 0;
			if(ccba != null) ccbai = ccba.intValue();
			callCountByArgs.put(args, new Integer(++ccbai));
			if(maxCallCountByArgs < ccbai) {
				maxCallCountByArgs = ccbai;
				maxCalledArgs = args;
			}
		}
		
		public int getCallCount() {
			return callCount;
		}
		
		public String toString() {
			StringBuffer ret = new StringBuffer(op.toString());
			
			ret.append(": called ");
			ret.append(toTimes(callCount));
			ret.append(" and at most ");
			
/*			for(Iterator i = callCountByArgs.keySet().iterator() ; i.hasNext() ; ) {
				List args = (List)i.next();
				if(args != null) {
					int ccbai = ((Integer)callCountByArgs.get(args)).intValue();
					if(maxCallCountByArgs < ccbai) {
						maxCallCountByArgs = ccbai;
						maxCalledArgs = args;
					}
				} else {
					// should not happen but does happen...
				}
			}
*/
			ret.append(toTimes(maxCallCountByArgs));
			ret.append(" for the same set of arguments: " + maxCalledArgs + ".");
			
			return ret.toString();
		}
		
		public int hashCode() {
			return op.hashCode();
		}
		
		public boolean equals(Object o) {
			return this == o;
		}
		
		public int compareTo(Object o) {
			return maxCallCountByArgs - ((OperationCall)o).maxCallCountByArgs;
		}
		
		private Operation op;
		private int callCount = 0;
		private Map callCountByArgs = new HashMap();
		private int maxCallCountByArgs = 0;
		private List maxCalledArgs = null;
	}
	
	private String toTimes(int n) {
		String ret = null;
		
		switch(n) {
			case 1:
				ret = "once";
				break;
			case 2:
				ret = "twice";
				break;
			default:
				ret = n + " times";
				break;
		}
		
		return ret;
	}
	
	/** Number of instructions executed. */
	private long instr = 0;
}

