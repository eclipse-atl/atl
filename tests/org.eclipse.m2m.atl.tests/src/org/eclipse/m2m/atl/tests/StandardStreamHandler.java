/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.tests;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * A standard log handler.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class StandardStreamHandler extends StreamHandler {

	/**
	 * {@inheritDoc}
	 *
	 * @see java.util.logging.StreamHandler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public synchronized void publish(LogRecord record) {
		if (record.getLevel().equals(Level.SEVERE)) {
			System.err.println(record.getMessage());
			if (record.getThrown() != null) {
				record.getThrown().printStackTrace();				
			}
		} else {
			System.out.println(record.getMessage());
		}
	}

}
