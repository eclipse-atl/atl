/*
 * Created on 23 juil. 2004
 */
package org.atl.eclipse.adt.ui;

/**
 * Defines status codes relevant to the Atl UI plug-in. When a 
 * Core exception is thrown, it contain a status object describing
 * the cause of the exception. The status objects originating from the
 * Atl UI plug-in use the codes defined in this interface.
 * 
 * @author C. MONTI for ATL Team
 */
public interface IAtlStatusConstants {

	// Atl UI status constants start at 10000 to make sure that we don't
	// collide with resource and Atl model constants.
	
	public static final int INTERNAL_ERROR = 10001;
	
	/**
	 * Status constant indicating that an exception occurred on
	 * storing or loading templates.
	 */
	public static final int TEMPLATE_IO_EXCEPTION = 10002;

	/**
	 * Status constant indicating that an validateEdit call has changed the
	 * content of a file on disk.
	 */
	public static final int VALIDATE_EDIT_CHANGED_CONTENT = 10003;
	
	/**
	 * Status constant indicating that a <tt>ChangeAbortException</tt> has been
	 * caught.
 	 */
	public static final int CHANGE_ABORTED = 10004;

	/**
	 * Status constant indicating that an exception occurred while
	 * parsing template file.
	 */
	public static final int TEMPLATE_PARSE_EXCEPTION = 10005;
	
 }
