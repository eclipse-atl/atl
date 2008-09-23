/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.ocl.core;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * Dummy file class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class DummyFile implements IFile {
	private String location;

	/**
	 * Constructor.
	 * 
	 * @param location the file location 
	 */
	public DummyFile(String location) {
		this.location = location;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#appendContents(java.io.InputStream, boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void appendContents(InputStream source, boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#appendContents(java.io.InputStream, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void appendContents(InputStream source, int updateFlags, IProgressMonitor monitor)
			throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#create(java.io.InputStream, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void create(InputStream source, boolean force, IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#create(java.io.InputStream, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void create(InputStream source, int updateFlags, IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#createLink(org.eclipse.core.runtime.IPath, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void createLink(IPath localLocation, int updateFlags, IProgressMonitor monitor)
			throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#delete(boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void delete(boolean force, boolean keepHistory, IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getCharset()
	 */
	public String getCharset() throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getCharset(boolean)
	 */
	public String getCharset(boolean checkImplicit) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getCharsetFor(java.io.Reader)
	 */
	public String getCharsetFor(Reader reader) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getContentDescription()
	 */
	public IContentDescription getContentDescription() throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getContents()
	 */
	public InputStream getContents() throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getContents(boolean)
	 */
	public InputStream getContents(boolean force) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getEncoding()
	 */
	public int getEncoding() throws CoreException {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getFullPath()
	 */
	public IPath getFullPath() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getHistory(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IFileState[] getHistory(IProgressMonitor monitor) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#getName()
	 */
	public String getName() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#isReadOnly()
	 */
	public boolean isReadOnly() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#move(org.eclipse.core.runtime.IPath, boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void move(IPath destination, boolean force, boolean keepHistory, IProgressMonitor monitor)
			throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setCharset(java.lang.String)
	 */
	public void setCharset(String newCharset) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setCharset(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setCharset(String newCharset, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setContents(java.io.InputStream, boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setContents(InputStream source, boolean force, boolean keepHistory, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setContents(org.eclipse.core.resources.IFileState, boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setContents(IFileState source, boolean force, boolean keepHistory, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setContents(java.io.InputStream, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setContents(InputStream source, int updateFlags, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#setContents(org.eclipse.core.resources.IFileState, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setContents(IFileState source, int updateFlags, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#accept(org.eclipse.core.resources.IResourceProxyVisitor, int)
	 */
	public void accept(IResourceProxyVisitor visitor, int memberFlags) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#accept(org.eclipse.core.resources.IResourceVisitor)
	 */
	public void accept(IResourceVisitor visitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#accept(org.eclipse.core.resources.IResourceVisitor, int, boolean)
	 */
	public void accept(IResourceVisitor visitor, int depth, boolean includePhantoms) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#accept(org.eclipse.core.resources.IResourceVisitor, int, int)
	 */
	public void accept(IResourceVisitor visitor, int depth, int memberFlags) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#clearHistory(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void clearHistory(IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#copy(org.eclipse.core.runtime.IPath, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void copy(IPath destination, boolean force, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#copy(org.eclipse.core.runtime.IPath, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void copy(IPath destination, int updateFlags, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#copy(org.eclipse.core.resources.IProjectDescription, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void copy(IProjectDescription description, boolean force, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#copy(org.eclipse.core.resources.IProjectDescription, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void copy(IProjectDescription description, int updateFlags, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#createMarker(java.lang.String)
	 */
	public IMarker createMarker(String type) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#delete(boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void delete(boolean force, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#delete(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void delete(int updateFlags, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#deleteMarkers(java.lang.String, boolean, int)
	 */
	public void deleteMarkers(String type, boolean includeSubtypes, int depth) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#exists()
	 */
	public boolean exists() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#findMarker(long)
	 */
	public IMarker findMarker(long id) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#findMarkers(java.lang.String, boolean, int)
	 */
	public IMarker[] findMarkers(String type, boolean includeSubtypes, int depth) throws CoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getFileExtension()
	 */
	public String getFileExtension() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getLocalTimeStamp()
	 */
	public long getLocalTimeStamp() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getLocation()
	 */
	public IPath getLocation() {
		return new IPath() {

			public String toString() {
				return location;
			}

			public IPath addFileExtension(String extension) {
				return null;
			}

			public IPath addTrailingSeparator() {
				return null;
			}

			public IPath append(String path) {
				return null;
			}

			public IPath append(IPath path) {
				return null;
			}

			public Object clone() {
				return null;
			}

			public String getDevice() {
				return null;
			}

			public String getFileExtension() {
				return null;
			}

			public boolean hasTrailingSeparator() {
				return false;
			}

			public boolean isAbsolute() {
				return false;
			}

			public boolean isEmpty() {
				return false;
			}

			public boolean isPrefixOf(IPath anotherPath) {
				return false;
			}

			public boolean isRoot() {
				return false;
			}

			public boolean isUNC() {
				return false;
			}

			public boolean isValidPath(String path) {
				return false;
			}

			public boolean isValidSegment(String segment) {
				return false;
			}

			public String lastSegment() {
				return null;
			}

			public IPath makeAbsolute() {
				return null;
			}

			public IPath makeRelative() {
				return null;
			}

			public IPath makeUNC(boolean toUNC) {
				return null;
			}

			public int matchingFirstSegments(IPath anotherPath) {
				return 0;
			}

			public IPath removeFileExtension() {
				return null;
			}

			public IPath removeFirstSegments(int count) {
				return null;
			}

			public IPath removeLastSegments(int count) {
				return null;
			}

			public IPath removeTrailingSeparator() {
				return null;
			}

			public String segment(int index) {
				return null;
			}

			public int segmentCount() {
				return 0;
			}

			public String[] segments() {
				return null;
			}

			public IPath setDevice(String device) {
				return null;
			}

			public File toFile() {
				return null;
			}

			public String toOSString() {
				return null;
			}

			public String toPortableString() {
				return null;
			}

			public IPath uptoSegment(int count) {
				return null;
			}

		};
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getMarker(long)
	 */
	public IMarker getMarker(long id) {
		return null;
	}

	public long getModificationStamp() {
		return 0;
	}

	public IContainer getParent() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getPersistentProperty(org.eclipse.core.runtime.QualifiedName)
	 */
	public String getPersistentProperty(QualifiedName key) throws CoreException {
		return null;
	}

	public IProject getProject() {
		return null;
	}

	public IPath getProjectRelativePath() {
		return null;
	}

	public IPath getRawLocation() {
		return null;
	}

	public ResourceAttributes getResourceAttributes() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getSessionProperty(org.eclipse.core.runtime.QualifiedName)
	 */
	public Object getSessionProperty(QualifiedName key) throws CoreException {
		return null;
	}

	public int getType() {
		return 0;
	}

	public IWorkspace getWorkspace() {
		return null;
	}

	public boolean isAccessible() {
		return false;
	}

	public boolean isDerived() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#isLocal(int)
	 */
	public boolean isLocal(int depth) {
		return false;
	}

	public boolean isLinked() {
		return false;
	}

	public boolean isPhantom() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#isSynchronized(int)
	 */
	public boolean isSynchronized(int depth) {
		return false;
	}

	public boolean isTeamPrivateMember() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#move(org.eclipse.core.runtime.IPath, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void move(IPath destination, boolean force, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#move(org.eclipse.core.runtime.IPath, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void move(IPath destination, int updateFlags, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#move(org.eclipse.core.resources.IProjectDescription, boolean, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void move(IProjectDescription description, boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#move(org.eclipse.core.resources.IProjectDescription, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void move(IProjectDescription description, int updateFlags, IProgressMonitor monitor)
			throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#refreshLocal(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void refreshLocal(int depth, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#revertModificationStamp(long)
	 */
	public void revertModificationStamp(long value) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setDerived(boolean)
	 */
	public void setDerived(boolean isDerived) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setLocal(boolean, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setLocal(boolean flag, int depth, IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setLocalTimeStamp(long)
	 */
	public long setLocalTimeStamp(long value) throws CoreException {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setPersistentProperty(org.eclipse.core.runtime.QualifiedName, java.lang.String)
	 */
	public void setPersistentProperty(QualifiedName key, String value) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean readOnly) {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setResourceAttributes(org.eclipse.core.resources.ResourceAttributes)
	 */
	public void setResourceAttributes(ResourceAttributes attributes) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setSessionProperty(org.eclipse.core.runtime.QualifiedName, java.lang.Object)
	 */
	public void setSessionProperty(QualifiedName key, Object value) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setTeamPrivateMember(boolean)
	 */
	public void setTeamPrivateMember(boolean isTeamPrivate) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#touch(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void touch(IProgressMonitor monitor) throws CoreException {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#contains(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	public boolean contains(ISchedulingRule rule) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#isConflicting(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	public boolean isConflicting(ISchedulingRule rule) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IFile#createLink(java.net.URI, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void createLink(URI linkLocation, int updateFlags, IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#createProxy()
	 */
	public IResourceProxy createProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getLocationURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getRawLocationURI() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#isLinked(int)
	 */
	public boolean isLinked(int options) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#findMaxProblemSeverity(java.lang.String, boolean, int)
	 */
	public int findMaxProblemSeverity(String type, boolean includeSubtypes, int depth) throws CoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	/** eclipse 3.4M4 compatibility * */
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#isHidden()
	 */
	public boolean isHidden() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#setHidden(boolean)
	 */
	public void setHidden(boolean val) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#isDerived(int)
	 */
	public boolean isDerived(int val) {
		return false;
	}

	/** eclipse 3.4M6 compatibility * */
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getPersistentProperties()
	 */
	public Map getPersistentProperties() throws CoreException {
		return Collections.EMPTY_MAP;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IResource#getSessionProperties()
	 */
	public Map getSessionProperties() throws CoreException {
		return Collections.EMPTY_MAP;
	}
}
