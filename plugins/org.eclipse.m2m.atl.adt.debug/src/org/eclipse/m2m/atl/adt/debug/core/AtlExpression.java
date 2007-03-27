/*
 * Created on 10 mai 2004
 */
package org.eclipse.m2m.atl.adt.debug.core;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IExpression;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.m2m.atl.adt.debug.AtlDebugPlugin;


/**
 * @author allilaire
 */
public class AtlExpression implements IExpression, IDebugEventSetListener {
	
	private AtlDebugTarget atlDT;
	private String snippet;
	private IValue expressionValue;
	
	public AtlExpression(AtlDebugTarget atlDT, String snippet) {
		this.atlDT = atlDT;
		this.snippet = snippet;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IExpression#getExpressionText()
	 */
	public String getExpressionText() {
		return snippet;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IExpression#getValue()
	 */
	public IValue getValue() {
		return expressionValue;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IExpression#dispose()
	 */
	public void dispose() {
		DebugPlugin.getDefault().removeDebugEventListener(this);
	}
	
	/**
	 * Return the unique identifier of the plugin
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return AtlDebugPlugin.getUniqueIdentifier();
	}
	
	/**
	 * Return the launch
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}
	
	/**
	 * Not use in our context
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter)	{
		return null;
	}

	/**
	 * @see org.eclipse.debug.core.IDebugEventSetListener#handleDebugEvents(org.eclipse.debug.core.DebugEvent[])
	 */
	public void handleDebugEvents(DebugEvent[] events) {
	}
	
}
