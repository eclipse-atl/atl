package org.atl.engine.vm;

import java.io.InputStream;

/**
 * @author Frédéric Jouault
 */
public abstract class ASMReader {

	public abstract ASM read(InputStream in);
}

