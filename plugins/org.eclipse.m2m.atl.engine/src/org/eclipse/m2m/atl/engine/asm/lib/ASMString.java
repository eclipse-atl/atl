package org.eclipse.m2m.atl.engine.asm.lib;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.Messages;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.m2m.atl.engine.emfvm.lib.Tuple;

public class ASMString implements LibExtension {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension#apply(org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv,
	 *      java.util.Map)
	 */
	public void apply(ExecEnv execEnv, Map options) {
		execEnv.registerOperation(String.class, createEvalSOTS());
		execEnv.registerOperation(String.class, createEvalSOTSBrackets());
		execEnv.registerOperation(String.class, new Operation(2, "writeTo") { //$NON-NLS-1$	
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						return Boolean.valueOf(writeToWithCharset(frame, (String)localVars[0],
								(String)localVars[1], null));
					}
				});
		execEnv.registerOperation(String.class, new Operation(3, "writeToWithCharset") { //$NON-NLS-1$	
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						return Boolean.valueOf(writeToWithCharset(frame, (String)localVars[0],
								(String)localVars[1], (String)localVars[2]));
					}
				});
	}

	public static Operation createEvalSOTS() {
		return new Operation(2, "evalSOTS") { //$NON-NLS-1$
			public Object exec(AbstractStackFrame frame) {
				Object[] localVars = frame.getLocalVars();
				String self = (String)localVars[0];
				Tuple args = (Tuple)localVars[1];
				Object ret = null;
				try {
					ret = new SOTSExpression2(self).exec((StackFrame)frame, args);
				} catch (Exception e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				return ret;
			}
		};
	}

	public static Operation createEvalSOTSBrackets() {
		return new Operation(2, "evalSOTSBrackets") { //$NON-NLS-1$
			public Object exec(AbstractStackFrame frame) {
				Object[] localVars = frame.getLocalVars();
				String self = (String)localVars[0];
				Tuple args = (Tuple)localVars[1];

				StringBuffer ret = new StringBuffer();
				Reader in = new StringReader(self);
				int c;

				try {
					boolean done = false;
					do {
						c = in.read();
						switch (c) {
							case -1:
								done = true;
								break;
							case '{':
								StringBuffer exp = new StringBuffer();
								while ((c = in.read()) != '}') {
									exp.append((char)c);
								}
								Object result = new SOTSExpression2(exp.toString()).exec((StackFrame)frame,
										args);
								if (result instanceof Collection) {
									result = ((Collection)result).iterator().next();
								}
								ret.append(result.toString());
								break;
							default:
								ret.append((char)c);
								break;
						}
					} while (!done);
				} catch (Exception e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				return ret.toString();
			}
		};
	}

	/**
	 * Writes self to fileName with given character set.
	 * 
	 * @param frame
	 *            VM stack frame
	 * @param self
	 *            the string to write
	 * @param fileName
	 *            the file to write to
	 * @param charset
	 *            the character set to use, or use default when null
	 * @return true on success
	 * @throws VMException
	 *             if an {@link IOException} occurs
	 */
	private static boolean writeToWithCharset(AbstractStackFrame frame, String self, String fileName,
			String charset) throws VMException {
		boolean ret = false;
		try {
			File file = getFile(fileName);
			if (file.getParentFile() != null) {
				file.getParentFile().mkdirs();
			}
			PrintStream out = null;
			if (charset == null) {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true);
			} else {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, charset);
			}
			out.print(self);
			out.close();
			ret = true;
		} catch (IOException ioe) {
			throw new VMException(frame, ioe.getLocalizedMessage(), ioe);
		}
		return ret;
	}

	/**
	 * Returns the file in the workspace, or the file in the filesystem if the workspace is not available.
	 * 
	 * @param path
	 *            the absolute or relative path to a file.
	 * @return the file in the workspace, or the file in the filesystem if the workspace is not available.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 */
	private static File getFile(String path) {
		String newPath = path;
		if (Platform.isRunning()) {
			IPath location = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)).getLocation();
			if (location != null) {
				newPath = location.toString();
			} else {
				ATLLogger
						.info(Messages.getString("ASMString_WORKSPACE_FILE_NOT_FOUND", new Object[] {path,})); //$NON-NLS-1$
			}
		} else {
			ATLLogger.info(Messages.getString("ASMString_WORKSPACE_NOT_FOUND")); //$NON-NLS-1$
		}
		return new File(newPath);
	}
}
