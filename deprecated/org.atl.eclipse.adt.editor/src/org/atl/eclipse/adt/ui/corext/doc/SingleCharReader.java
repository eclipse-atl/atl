/*
 * Created on 2 juil. 2004
 */
package org.atl.eclipse.adt.ui.corext.doc;

import java.io.IOException;
import java.io.Reader;

/**
 * @author C. MONTI for ATL team
 */
public abstract class SingleCharReader extends Reader {
	
	/**
	 * Gets the content as a String
	 */
	public String getString() throws IOException {
		StringBuffer buf= new StringBuffer();
		int ch;
		while ((ch= read()) != -1) {
			buf.append((char)ch);
		}
		return buf.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.io.Reader#read(char[], int, int)
	 */
	public int read(char[] cbuf, int off, int len) throws IOException {
		int end= off + len;
		for (int i= off; i < end; i++) {
			int ch= read();
			if (ch == -1) {
				if (i == off) {
					return -1;
				} else {
					return i - off;
				}
			}
			cbuf[i]= (char)ch;
		}
		return len;
	}
	
	/* (non-Javadoc)
	 * @see java.io.Reader#ready()
	 */
	public boolean ready() throws IOException {
		return true;
	}
	
}
