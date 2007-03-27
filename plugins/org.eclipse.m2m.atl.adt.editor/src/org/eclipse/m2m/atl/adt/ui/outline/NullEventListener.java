package org.eclipse.m2m.atl.adt.ui.outline;

public class NullEventListener implements EventListener 
{
	private static NullEventListener instance;
	
	public static NullEventListener getInstance() 
	{
		if (instance == null)
			instance = new NullEventListener();
		return instance;
	}
	
	/*
	 * @see EventListener#add(Event)
	 */
	public void update(Event event) { System.out.println("je suis la!!");}

}
