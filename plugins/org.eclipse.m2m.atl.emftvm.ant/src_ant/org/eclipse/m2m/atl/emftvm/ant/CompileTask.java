/*******************************************************************************
 * Copyright (c) 2018 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;

/**
 * Compiles an ATL module to EMFTVM bytecode.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CompileTask extends EMFTVMTask {

	private String module;
	private String modulePath;
	private String charset;

	/**
	 * Sets the module name.
	 * 
	 * @param module
	 *            the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Returns the module name.
	 * 
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module path.
	 * 
	 * @param modulePath
	 *            the modulePath to set
	 */
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	/**
	 * Returns the module path.
	 * 
	 * @return the modulePath
	 */
	public String getModulePath() {
		return modulePath;
	}

	/**
	 * Returns the character set to be used for parsing.
	 * 
	 * @return the character set to be used for parsing
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * Sets the character set to be used for parsing
	 * 
	 * @param charset
	 *            the character set to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final File atlFile = new File(modulePath + module + ".atl");
		final AtlToEmftvmCompiler compiler = new AtlToEmftvmCompiler();
		final InputStream inputStream = new FileInputStream(atlFile);
		try {
			final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			final String charset = getCharset();
			final Reader reader = charset == null || charset.isEmpty() ? new InputStreamReader(bufferedInputStream)
					: new InputStreamReader(bufferedInputStream, charset);

			final CompileTimeError[] errors = compiler.compile(reader, modulePath + module + ".emftvm");

			if (errors != null && errors.length > 0) {
				final StringBuilder errorString = new StringBuilder();
				for (final CompileTimeError error : errors) {
					errorString.append("\n\t").append(error.getSeverity()).append(" : ").append(error.getDescription())
							.append(" [").append(error.getLocation()).append("]");
				}
				throw new ATLCoreException("Compile error" + errorString);
			}
		} finally {
			inputStream.close();
		}
	}

}
