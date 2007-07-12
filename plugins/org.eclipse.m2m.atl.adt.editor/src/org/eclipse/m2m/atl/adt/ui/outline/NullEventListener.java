package org.eclipse.m2m.atl.adt.ui.outline;

import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

public class NullEventListener implements EventListener 
{
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
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
	public void update(Event event) {
		logger.info("je suis la!!");
	}

}
