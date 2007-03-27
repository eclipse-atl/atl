/*
 * Created on 27 mai 2004
 */
package org.eclipse.m2m.atl.adt.launching.sourcelookup;

import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.m2m.atl.adt.debug.core.AtlStackFrame;

/**
 * @author allilaire
 */
public class AtlSourceLocator implements ISourceLocator {

	/**
	 * Returns a source element that corresponds to the given stack frame, or
	 * null if a source element could not be located. The object returned by
	 * this method will be used by the debug UI plug-in to display source. The
	 * debug UI uses the debug model presentation associated with the given
	 * stack frame's debug model to translate a source object into an {editor
	 * input, editor id} pair in which to display source. For example, a java
	 * source locator could return an object representing a compilation unit or
	 * class file. The java debug model presentation would then be responsible
	 * for providing an editor input and editor id for each compilation unit and
	 * class file such that the debug UI could display source.
	 * 
	 * @see org.eclipse.debug.core.model.ISourceLocator#getSourceElement(IStackFrame)
	 */
	public Object getSourceElement(IStackFrame stackFrame) {
		if (stackFrame instanceof AtlStackFrame) {
			AtlStackFrame asf = (AtlStackFrame)stackFrame;
			return asf;
		}
		return null;
	}
	
}
