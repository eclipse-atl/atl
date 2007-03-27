package org.eclipse.m2m.atl.engine.injectors;

import java.io.*;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.*;

/**
 * @author Frédéric Jouault
 */
public interface Injector {

	/* New Injector interface. */

	/**
	 * returns the list of parameters supported by this injector
	 * in the form of a Map with parameter names as keys and type
	 * name as value.
	 * Known type names are:
	 * 		"String"
	 * 		"Model" 
	 */
	public Map getParameterTypes();
	
	/**
	 * Performs the injection.
	 * @param target The target model to populate.
	 * @param source The source InputStream. Alternative source kinds can be passed
	 * 				in params.
	 * @param params A Map of additional parameters. The key is the name.
	 * @return The root element of the populated model if it exists, any element else.
	 * @throws IOException
	 */
	public ASMModelElement inject(ASMModel target, InputStream source, Map params) throws IOException;

	/* Old Injector interface. */
	public String getPrefix();

	public void performImportation(ASMModel format, ASMModel extent, InputStream in, String other) throws IOException;
}
