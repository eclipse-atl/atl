package org.atl.eclipse.km3;

import org.eclipse.ui.IStartup;

/**
 * Registers the KM3 metamodel at startup time so that it is available
 * for transformation even when no KM3 action has been invoked before.
 */
public class Startup implements IStartup {

	public void earlyStartup() {
		KM3Projector.getKM3Projector().initEMF();
	}

}
