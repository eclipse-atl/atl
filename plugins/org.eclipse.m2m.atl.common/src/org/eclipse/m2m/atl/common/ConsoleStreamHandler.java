/*******************************************************************************
 * Copyright (c) 2007 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Dennis Wagelaar (Vrije Universiteit Brussel) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * Flushes after every log and doesn't close output stream.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ConsoleStreamHandler extends StreamHandler {

    /**
     * Creates a ConsoleStreamHandler for out.
     * @param out the console
     */
    public ConsoleStreamHandler(OutputStream out) {
        super(out, ATLLogFormatter.INSTANCE);
    }
    
    /**
     * {@inheritDoc}
     *
     * @see java.util.logging.StreamHandler#publish(java.util.logging.LogRecord)
     */
    public void publish(LogRecord record) {
    	super.publish(record);
        flush();
    }
    
    /**
     * Don't close output stream.
     */
    public void close() {
        //don't close
    }
}
