/*******************************************************************************
 * Copyright (c) 2018, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Resource;
import org.apache.tools.ant.types.resources.FileResource;
import org.apache.tools.ant.util.StringUtils;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;

/**
 * Compiles an ATL module to EMFTVM bytecode.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CompileTask extends EMFTVMTask {

	private static final String DOT_ATL = ".atl";
	private static final String DOT_EMFTVM = ".emftvm";
	private static final double DIVISOR = 1.0E9;
	private static final Pattern DOT_ATL_PAT = Pattern.compile("\\.atl$");

	private String module;
	private String modulePath;
	private String charset;
	private String outputPath;
	private final List<FileSet> moduleSets = new ArrayList<FileSet>();
	private AtlToEmftvmCompiler compiler;

	/**
	 * Sets the module name.
	 *
	 * @param module the module to set
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
	 * Sets the module path. If not set,
	 * {@link org.apache.tools.ant.Project#getBaseDir()} is used.
	 *
	 * @param modulePath the modulePath to set
	 */
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	/**
	 * Returns the module path. If not set,
	 * {@link org.apache.tools.ant.Project#getBaseDir()} is used.
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
	 * Sets the character set to be used for parsing.
	 *
	 * @param charset the character set to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * Returns the directory path to write the output file to. If not set,
	 * {@link #getModulePath()} is used.
	 *
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * Sets the directory path to write the output file to. If not set,
	 * {@link #getModulePath()} is used.
	 *
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	/**
	 * Returns the module {@link FileSet}.
	 *
	 * @return the moduleSets
	 */
	public List<FileSet> getModuleSets() {
		return moduleSets;
	}

	/**
	 * Adds module set to the compile task.
	 *
	 * @param moduleSet the module set to add
	 */
	public void addConfiguredModuleSet(FileSet moduleSet) {
		getModuleSets().add(moduleSet);
	}

	/**
	 * Returns the {@link AtlToEmftvmCompiler}.
	 *
	 * @return the compiler
	 */
	protected AtlToEmftvmCompiler getCompiler() {
		if (compiler == null) {
			compiler = new AtlToEmftvmCompiler();
		}
		return compiler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final String module = getModule();
		if (StringUtils.trimToNull(module) != null) {
			final File modulePath = trimToBaseDir(getModulePath());
			final Resource resource = new FileResource(modulePath, module + DOT_ATL);
			compileResource(modulePath, resource);
		}

		for (final FileSet moduleSet : getModuleSets()) {
			final File dir = moduleSet.getDir();
			final File modulePath = dir == null ? getProject().getBaseDir() : dir;
			for (final Resource resource : moduleSet) {
				compileResource(modulePath, resource);
			}
		}
	}

	private void compileResource(final File basedir, final Resource resource) throws Exception {
		final long startTimeNanos = System.nanoTime();

		final String modulePath = basedir + File.separator;
		final String module = resource.getName();
		final String inputFilePath = modulePath + module;
		final InputStream inputStream = resource.getInputStream();
		try {
			final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			final String charset = getCharset();
			final Reader reader = charset == null ? new InputStreamReader(bufferedInputStream)
					: new InputStreamReader(bufferedInputStream, charset);
			final String outputPath = getOutputPath();
			final String outputFilePath = (outputPath != null ? outputPath : modulePath)
					+ DOT_ATL_PAT.matcher(module).replaceAll(DOT_EMFTVM);

			final CompileTimeError[] errors = getCompiler().compile(reader, outputFilePath);

			if (errors != null && errors.length > 0) {
				final StringBuilder errorString = new StringBuilder();
				for (final CompileTimeError error : errors) {
					errorString.append("\n\t").append(error.getSeverity()).append(" : ").append(error.getDescription())
					.append(" [").append(error.getLocation()).append("]");
				}
				throw new ATLCoreException("Compile error" + errorString);
			}

			ATLLogger.info(String.format("Compiled %s to %s in %f seconds", inputFilePath, outputFilePath,
					(System.nanoTime() - startTimeNanos) / DIVISOR));
		} finally {
			inputStream.close();
		}
	}

	/**
	 * Trims <code>null</code> strings to the project's BaseDir.
	 *
	 * @param str the string to trim
	 * @return <code>str</code>, or
	 *         {@link org.apache.tools.ant.Project#getBaseDir()} if
	 *         <code>null</code>
	 */
	private File trimToBaseDir(final String str) {
		return str != null ? new File(str) : getProject().getBaseDir();
	}

}
