package org.eclipse.m2m.atl.adt.ui.outline;

public class Event 
{
	protected Object actedUpon;
	
	public Event(Object receiver) 
	{
		actedUpon = receiver;
	}
	
	public Object receiver() 
	{
		return actedUpon;
	}
}
