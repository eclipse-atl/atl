/**
 * 
 */
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.util.List;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author JOUAULT - Christophe Le Camus (C-S) - Sebastien Gabel (C-S) 
 *
 */
public class Invocation {
	public Invocation(StackFrame frame, ASMUMLModelElement self, String opName, List arguments) {
		this.frame = frame;
		this.self = self;
		this.opName = opName;
		this.arguments = arguments;
	}
	
	public StackFrame frame;
	public ASMUMLModelElement self;
	public String opName;
	public List arguments;
}