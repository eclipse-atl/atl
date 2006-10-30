/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

/**
 * @author JOUAULT
 * 
 */
public class AtlCompiler {
	private static AtlCompiler defaultCompiler = null;

	public static AtlCompiler getDefault() {
		if (defaultCompiler == null) {
			defaultCompiler = new AtlCompiler();
		}
		return defaultCompiler;
	}

	/**
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param out
	 *            The IFile to which the ATL compiled program will be saved.
	 * @return A List of EObject instance of Problem.
	 */
	public EObject[] compile(InputStream in, IFile out) {
		EObject ret[] = AtlStandaloneCompiler.getDefault().compile(in,
				out.getLocation().toString());

		try {
			out.refreshLocal(0, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return ret;
	}
}
