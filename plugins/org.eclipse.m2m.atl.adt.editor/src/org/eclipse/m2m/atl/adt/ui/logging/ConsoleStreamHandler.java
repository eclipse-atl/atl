package org.eclipse.m2m.atl.adt.ui.logging;

import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import org.eclipse.m2m.atl.logging.ATLLogFormatter;

/**
 * Flushes after every log and doesn't close output stream.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
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
