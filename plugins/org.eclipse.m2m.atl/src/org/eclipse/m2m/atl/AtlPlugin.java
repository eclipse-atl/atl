package org.eclipse.m2m.atl;

import org.eclipse.core.runtime.Plugin;

public class AtlPlugin extends Plugin {
	//The shared instance.
	private static AtlPlugin plugin;

	/**
	 * The constructor.
	 */
	public AtlPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static AtlPlugin getDefault() {
		return plugin;
	}
}
