/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault (INRIA) - initial API and implementation
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
 * 
 * @author Frédéric Jouault
 *
 */
public class DummyFile implements IFile {
	private String location;
	
	public DummyFile(String location) {
		this.location = location;
	}

	public void appendContents(InputStream source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {
	}

	public void appendContents(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
	}

	public void create(InputStream source, boolean force,
			IProgressMonitor monitor) throws CoreException {
	}

	public void create(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
	}

	public void createLink(IPath localLocation, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
	}

	public void delete(boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {
	}

	public String getCharset() throws CoreException {
		return null;
	}

	public String getCharset(boolean checkImplicit) throws CoreException {
		return null;
	}

	public String getCharsetFor(Reader reader) throws CoreException {
		return null;
	}

	public IContentDescription getContentDescription() throws CoreException {
		return null;
	}

	public InputStream getContents() throws CoreException {
		return null;
	}

	public InputStream getContents(boolean force) throws CoreException {
		return null;
	}

	public int getEncoding() throws CoreException {
		return 0;
	}

	public IPath getFullPath() {
		return null;
	}

	public IFileState[] getHistory(IProgressMonitor monitor) throws CoreException {
		return null;
	}

	public String getName() {
		return null;
	}

	public boolean isReadOnly() {
		return false;
	}

	public void move(IPath destination, boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {
	}

	public void setCharset(String newCharset) throws CoreException {

	}

	public void setCharset(String newCharset, IProgressMonitor monitor)
			throws CoreException {

	}

	public void setContents(InputStream source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {

	}

	public void setContents(IFileState source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {

	}

	public void setContents(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public void setContents(IFileState source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public void accept(IResourceProxyVisitor visitor, int memberFlags)
			throws CoreException {

	}

	public void accept(IResourceVisitor visitor) throws CoreException {

	}

	public void accept(IResourceVisitor visitor, int depth,
			boolean includePhantoms) throws CoreException {

	}

	public void accept(IResourceVisitor visitor, int depth, int memberFlags)
			throws CoreException {

	}

	public void clearHistory(IProgressMonitor monitor) throws CoreException {

	}

	public void copy(IPath destination, boolean force, IProgressMonitor monitor)
			throws CoreException {

	}

	public void copy(IPath destination, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public void copy(IProjectDescription description, boolean force,
			IProgressMonitor monitor) throws CoreException {

	}

	public void copy(IProjectDescription description, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public IMarker createMarker(String type) throws CoreException {
		return null;
	}

	public void delete(boolean force, IProgressMonitor monitor)
			throws CoreException {

	}

	public void delete(int updateFlags, IProgressMonitor monitor)
			throws CoreException {

	}

	public void deleteMarkers(String type, boolean includeSubtypes, int depth)
			throws CoreException {

	}

	public boolean exists() {
		return false;
	}

	public IMarker findMarker(long id) throws CoreException {
		return null;
	}

	public IMarker[] findMarkers(String type, boolean includeSubtypes, int depth)
			throws CoreException {
		return null;
	}

	public String getFileExtension() {
		return null;
	}

	public long getLocalTimeStamp() {
		return 0;
	}

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

	public IMarker getMarker(long id) {
		return null;
	}

	public long getModificationStamp() {
		return 0;
	}

	public IContainer getParent() {
		return null;
	}

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

	public boolean isLocal(int depth) {
		return false;
	}

	public boolean isLinked() {
		return false;
	}

	public boolean isPhantom() {
		return false;
	}

	public boolean isSynchronized(int depth) {
		return false;
	}

	public boolean isTeamPrivateMember() {
		return false;
	}

	public void move(IPath destination, boolean force, IProgressMonitor monitor)
			throws CoreException {

	}

	public void move(IPath destination, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public void move(IProjectDescription description, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {

	}

	public void move(IProjectDescription description, int updateFlags,
			IProgressMonitor monitor) throws CoreException {

	}

	public void refreshLocal(int depth, IProgressMonitor monitor)
			throws CoreException {

	}

	public void revertModificationStamp(long value) throws CoreException {

	}

	public void setDerived(boolean isDerived) throws CoreException {

	}

	public void setLocal(boolean flag, int depth, IProgressMonitor monitor)
			throws CoreException {

	}

	public long setLocalTimeStamp(long value) throws CoreException {
		return 0;
	}

	public void setPersistentProperty(QualifiedName key, String value)
			throws CoreException {

	}

	public void setReadOnly(boolean readOnly) {

	}

	public void setResourceAttributes(ResourceAttributes attributes)
			throws CoreException {

	}

	public void setSessionProperty(QualifiedName key, Object value)
			throws CoreException {

	}

	public void setTeamPrivateMember(boolean isTeamPrivate)
			throws CoreException {

	}

	public void touch(IProgressMonitor monitor) throws CoreException {

	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean contains(ISchedulingRule rule) {
		return false;
	}

	public boolean isConflicting(ISchedulingRule rule) {
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void createLink(URI location, int updateFlags, IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		
	}

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

	public boolean isLinked(int options) {
		// TODO Auto-generated method stub
		return false;
	}

	public int findMaxProblemSeverity(String type, boolean includeSubtypes,
			int depth) throws CoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	/** eclipse 3.4M4 compatibility **/
	public boolean isHidden(){
		return false;
	}
	
	public void setHidden(boolean val){
	}
	
	public boolean isDerived(int val){
		return false;
	}
	
	/** eclipse 3.4M6 compatibility **/
	public Map getPersistentProperties() throws CoreException {
		return Collections.EMPTY_MAP;
	}
	
	public Map getSessionProperties() throws CoreException {
		return Collections.EMPTY_MAP;
	}
	
	
}
