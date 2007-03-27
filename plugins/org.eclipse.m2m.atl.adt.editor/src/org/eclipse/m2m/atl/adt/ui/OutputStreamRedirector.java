/*
 * Created on 21.feb.2005
 *
 */
package org.eclipse.m2m.atl.adt.ui;

import java.io.PrintStream;

import org.eclipse.ui.console.MessageConsoleStream;

/**
 * @author Jon Oldevik
 */
public class OutputStreamRedirector extends PrintStream {
	
	private MessageConsoleStream consoleStream = null;
	
	public OutputStreamRedirector (MessageConsoleStream cStream) {		
		super (System.out);
		consoleStream = cStream;
	}
	
	public void print (String s) {
		consoleStream.print(s);
	}
	public void print (Object o) {
		consoleStream.print(o.toString());
	}
	public void println (String s) {
		consoleStream.println(s);
	}
	
	public void println (Object o) {
		consoleStream.println(o.toString());
	}

}
