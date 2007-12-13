/*******************************************************************************
 * Copyright (c) 2007 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Wagelaar (Vrije Universiteit Brussel) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.logging;

import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import org.eclipse.m2m.atl.logging.ATLLogFormatter;

/**
 * Flushes after every log and doesn't close output stream.
 */
public class ConsoleStreamHandler extends StreamHandler {

    /**
     * Creates a ConsoleStreamHandler for out.
     * @param out
     */
    public ConsoleStreamHandler(OutputStream out) {
        super(out, ATLLogFormatter.INSTANCE);
    }
    
    /**
     * @see StreamHandler#publish(java.util.logging.LogRecord)
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
