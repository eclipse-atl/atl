/*******************************************************************************
 * Copyright (c) 2010, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.AtlTypesProcessor;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.UnitType;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;

/**
 * Open declaration utilities.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class OpenDeclarationUtils {

	private OpenDeclarationUtils() {
		// prevents instantiation
	}

	/**
	 * Retrieves the declaration of the element at the given offset if exists.
	 * 
	 * @param editor
	 *            the current editor
	 * @param offset
	 *            the given offset
	 * @param length
	 *            the region length (after offset, unused)
	 * @return the declaration if exists
	 * @throws BadLocationException
	 */
	public static OclAnyType getType(AtlEditor editor, int offset, int length) throws BadLocationException {
		int savedOffset = offset;
		if (editor.isDirty()) {
			int[] savePosition = editor.getComparator().current2savePosition(
					new int[] {offset, offset + length,});
			if (savePosition != null) {
				savedOffset = savePosition[0];
			}
		}
		AtlSourceManager manager = editor.getSourceManager();
		AtlModelAnalyser analyser = editor.getModelAnalyser();
		EObject locatedElement = analyser.getLocatedElement(savedOffset);
		if (locatedElement != null) {
			IFileEditorInput editorInput = (IFileEditorInput)editor.getEditorInput();
			AtlTypesProcessor processor = new AtlTypesProcessor();
			processor.update(editorInput.getFile(), analyser, manager);
			return processor.getType(locatedElement);
		}
		return null;
	}

	/**
	 * Returns a description of the element available at the given offset.
	 * 
	 * @param editor
	 *            the current editor
	 * @param offset
	 *            the given offset
	 * @param length
	 *            the region length (after offset, unused)
	 * @return a description of the element available at the given offset
	 * @throws BadLocationException
	 */
	public static String getInformation(AtlEditor editor, int offset, int length) throws BadLocationException {
		int savedOffset = offset;
		if (editor.isDirty()) {
			int[] savePosition = editor.getComparator().current2savePosition(
					new int[] {offset, offset + length,});
			if (savePosition != null) {
				savedOffset = savePosition[0];
			}
		}
		AtlSourceManager manager = editor.getSourceManager();
		AtlModelAnalyser analyser = editor.getModelAnalyser();
		if(analyser == null)
			return null;
		EObject locatedElement = analyser.getLocatedElement(savedOffset);
		if (locatedElement != null) {
			IFileEditorInput editorInput = (IFileEditorInput)editor.getEditorInput();
			AtlTypesProcessor processor = new AtlTypesProcessor();
			processor.update(editorInput.getFile(), analyser, manager);
			return processor.getInformation(locatedElement);
		}
		return null;
	}

	/**
	 * Retrieves the declaration of the element at the given offset if exists.
	 * 
	 * @param editor
	 *            the current editor
	 * @param offset
	 *            the given offset
	 * @param length
	 *            the region length (after offset, unused)
	 * @return the declaration if exists
	 * @throws BadLocationException
	 */
	public static Object getDeclaration(AtlEditor editor, int offset, int length) throws BadLocationException {
		int savedOffset = offset;
		if (editor.isDirty()) {
			int[] savePosition = editor.getComparator().current2savePosition(
					new int[] {offset, offset + length,});
			if (savePosition != null) {
				savedOffset = savePosition[0];
			}
		}
		AtlSourceManager manager = editor.getSourceManager();
		AtlModelAnalyser analyser = editor.getModelAnalyser();
		EObject locatedElement = analyser.getLocatedElement(savedOffset);
		if (locatedElement != null) {
			IFileEditorInput editorInput = (IFileEditorInput)editor.getEditorInput();
			AtlTypesProcessor processor = new AtlTypesProcessor();
			processor.update(editorInput.getFile(), analyser, manager);
			return processor.getDeclaration(locatedElement);
		}
		return null;
	}

	/**
	 * Opens the declaration of the given object. Support both meta-elements: open the declaration inside of
	 * the metamodel; and ATL model elements.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param target
	 *            the target {@link EObject}
	 * @param editor
	 *            the editor
	 * @throws BadLocationException
	 */
	public static void openDeclaration(UnitType unit, EObject target, AtlEditor editor)
			throws BadLocationException {
		if (target instanceof EClassifier || target instanceof EStructuralFeature
				|| target instanceof EOperation) {
			showEObject(editor.getSite().getPage(), target.eResource().getURI(), target);
		} else {
			IEditorPart targetEditor = null;
			if (unit != null && unit.getFile() != null
					&& !unit.getFile().equals(((IFileEditorInput)editor.getEditorInput()).getFile())) {
				IWorkbenchPage page = editor.getSite().getPage();
				IEditorDescriptor editorDescriptor = page.getWorkbenchWindow().getWorkbench()
						.getEditorRegistry().findEditor("org.eclipse.m2m.atl.adt.editor.AtlEditor"); //$NON-NLS-1$
				if (editorDescriptor != null) {
					try {
						targetEditor = page.openEditor(new FileEditorInput(unit.getFile()), editorDescriptor
								.getId());
					} catch (PartInitException e) {
						// Do nothing
					}
				}
			} else {
				targetEditor = editor;
			}
			if (targetEditor instanceof AtlEditor) {
				AtlEditor atlEditor = (AtlEditor)targetEditor;
				int[] location = atlEditor.getModelAnalyser().getHelper().getElementOffsets(target, 0);
				if (location != null) {
					if (!atlEditor.isDirty()) {
						atlEditor.selectAndReveal(location[0], location[1] - location[0]);
					} else {
						int[] newLocation = atlEditor.getComparator().save2currentPosition(location);
						atlEditor.selectAndReveal(newLocation[0], newLocation[1] - newLocation[0]);
					}
				}
			}
		}
	}

	/**
	 * Opens the referenced definition on the given page. It can be on the active editor, or not. The
	 * highlighted range of the active editor is modified if the file URI of the referenced object is the
	 * active editor itself. Another editor can be opened if the referenced file is another file.
	 * 
	 * @param page
	 *            is the current page
	 * @param fileURI
	 *            is the file to open on the page
	 * @param eObject
	 *            is the EObject to select (Ecore editor)
	 */
	public static void showEObject(IWorkbenchPage page, URI fileURI, EObject eObject) {
		IWorkbench workbench = page.getWorkbenchWindow().getWorkbench();
		if (fileURI != null && eObject != null) {
			URI newFileURI = formatURI(fileURI);
			if (newFileURI != null) {
				Object fileObject = getIFileXorIOFile(newFileURI);
				if (fileObject instanceof IFile) {
					newFileURI = URI.createPlatformResourceURI(((IFile)fileObject).getFullPath().toString(),
							false);
				}
				IEditorDescriptor editorDescriptor;
				String lastSegment = newFileURI.lastSegment();
				if (lastSegment.endsWith(".ecore") || lastSegment.endsWith(".xmi") || lastSegment.endsWith(".uml")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					editorDescriptor = getXMIEditor();
				} else {
					editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(lastSegment);
				}
				if (editorDescriptor != null) {
					try {
						IEditorPart newEditor = page.openEditor(new URIEditorInput(newFileURI),
								editorDescriptor.getId());
						selectAndReveal(newEditor, eObject);
					} catch (PartInitException e) {
						// Do nothing
					}
				}
			}
		}
	}

	private static void selectAndReveal(IEditorPart newEditor, EObject eObject) {
		IEditingDomainProvider editor = (IEditingDomainProvider)newEditor;
		String eObjectFragmentURI = eObject.eResource().getURIFragment(eObject);
		if (editor.getEditingDomain() != null && editor.getEditingDomain().getResourceSet() != null
				&& editor.getEditingDomain().getResourceSet().getResources().size() > 0
				&& eObjectFragmentURI != null) {
			EObject newObject = editor.getEditingDomain().getResourceSet().getResources().get(0).getEObject(
					eObjectFragmentURI);
			if (editor instanceof IViewerProvider) {
				setSelectionToViewer(newObject, ((IViewerProvider)editor).getViewer());
			}
		}

	}

	/**
	 * Changes the file URI to be readable in a plug-in context. If an EMF URI starts with 'http', We would
	 * like to transform this EMF URI to an ecore platform URI.
	 * 
	 * @param fileURI
	 *            is the URI
	 * @return platform URI
	 */
	private static URI formatURI(URI fileURI) {
		if (fileURI.toString().startsWith("http")) { //$NON-NLS-1$
			URI result = null;
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = registry
					.getExtensionPoint("org.eclipse.emf.ecore.generated_package"); //$NON-NLS-1$
			if (extensionPoint != null && extensionPoint.getExtensions().length > 0) {
				IExtension[] extensions = extensionPoint.getExtensions();
				for (int i = 0; result == null && i < extensions.length; i++) {
					IExtension extension = extensions[i];
					IConfigurationElement[] members = extension.getConfigurationElements();
					for (int j = 0; result == null && j < members.length; j++) {
						IConfigurationElement member = members[j];
						String mURI = member.getAttribute("uri"); //$NON-NLS-1$
						String genModelPath = member.getAttribute("genModel"); //$NON-NLS-1$
						String bundleID = member.getNamespaceIdentifier();
						if (mURI != null && mURI.equals(fileURI.toString())
								&& Platform.getBundle(bundleID) != null && genModelPath != null) {
							String ecoreName = new Path(genModelPath).removeFileExtension().addFileExtension(
									"ecore").lastSegment(); //$NON-NLS-1$
							result = findEcore(Platform.getBundle(bundleID), ecoreName);
						}
					}
				}
			}
			extensionPoint = registry.getExtensionPoint("org.eclipse.emf.ecore.uri_mapping"); //$NON-NLS-1$
			if (result == null && extensionPoint != null && extensionPoint.getExtensions().length > 0) {
				IExtension[] extensions = extensionPoint.getExtensions();
				for (int i = 0; result == null && i < extensions.length; i++) {
					IExtension extension = extensions[i];
					IConfigurationElement[] members = extension.getConfigurationElements();
					for (int j = 0; result == null && j < members.length; j++) {
						IConfigurationElement member = members[j];
						String sourceURI = member.getAttribute("source"); //$NON-NLS-1$
						String targetURI = member.getAttribute("target"); //$NON-NLS-1$
						if (sourceURI != null && sourceURI.equals(fileURI.toString()) && targetURI != null) {
							result = URI.createURI(targetURI, false);
						}
					}
				}
			}
			return result;
		}
		return fileURI;
	}

	/**
	 * Finds an ecore file in the given OSGI bundle.
	 * 
	 * @param bundle
	 *            is an OSGI bundle
	 * @param ecoreName
	 *            is the ecore file name to search
	 * @return the URI of the ecore file, or null if it doesn't exist
	 */
	@SuppressWarnings("unchecked")
	private static URI findEcore(Bundle bundle, String ecoreName) {
		Enumeration<URL> entries = bundle.findEntries("/", ecoreName, true); //$NON-NLS-1$
		if (entries != null) {
			while (entries.hasMoreElements()) {
				URL entry = entries.nextElement();
				if (entry != null) {
					IPath path = new Path(bundle.getSymbolicName()).append(entry.getPath());
					return URI.createPlatformPluginURI(path.toString(), false);
				}
			}
		}
		return null;
	}

	/**
	 * Gets the best XMI editor.
	 * 
	 * @return the descriptor of the XMI editor
	 */
	private static IEditorDescriptor getXMIEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().findEditor(
				"org.eclipse.emf.ecore.presentation.EcoreEditorID"); //$NON-NLS-1$
		if (editorDescriptor == null) {
			editorDescriptor = workbench.getEditorRegistry().getDefaultEditor("Ecore.ecore"); //$NON-NLS-1$
			if (editorDescriptor == null) {
				editorDescriptor = workbench.getEditorRegistry().getDefaultEditor("Ecore.xmi"); //$NON-NLS-1$
			}
		}
		return editorDescriptor;
	}

	/**
	 * Select the given EObject in the viewer.
	 * 
	 * @param selectedEObject
	 *            is the object to select
	 * @param viewer
	 *            is the viewer that contains some EMF objects
	 */
	private static void setSelectionToViewer(final EObject selectedEObject, final Viewer viewer) {
		if (selectedEObject != null && viewer != null) {
			Runnable runnable = new Runnable() {
				public void run() {
					viewer.setSelection(new StructuredSelection(selectedEObject), true);
				}
			};
			viewer.getControl().getDisplay().asyncExec(runnable);
		}
	}

	/**
	 * Returns the workspace file (IFile). If it doesn't exist, we try to find the java.io.File.
	 * 
	 * @param fileURI
	 *            is the platform URI or the file URI...
	 * @return the IFile, or the java.io.File, or null if it doesn't exist
	 */
	public static Object getIFileXorIOFile(URI fileURI) {
		IFile workspaceFile = null;
		File absoluteFile = null;
		String platformString = fileURI.toPlatformString(true);
		IPath platformPath;
		if (platformString != null) {
			platformPath = new Path(platformString);
		} else {
			platformPath = null;
		}
		if (platformPath != null && platformPath.segmentCount() > 1) {
			if (ResourcesPlugin.getWorkspace().getRoot().exists(platformPath)) {
				workspaceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(platformPath);
			} else {
				String pluginName = platformPath.segment(0);
				Bundle bundle = Platform.getBundle(pluginName);
				if (bundle != null) {
					absoluteFile = getAbsoluteFile(bundle, platformPath.removeFirstSegments(1).toString());
				}
			}
		}
		String absolutePath = fileURI.toFileString();
		if (absolutePath != null) {
			absoluteFile = new File(absolutePath);
		}
		if (workspaceFile == null && fileURI.isFile() && absoluteFile != null) {
			IFile tmpFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					new Path(absolutePath));
			if (tmpFile != null && tmpFile.exists()) {
				workspaceFile = tmpFile;
			}
		}
		if (absoluteFile != null && !absoluteFile.exists()) {
			absoluteFile = null;
		}
		if (workspaceFile != null) {
			return workspaceFile;
		} else {
			return absoluteFile;
		}
	}

	/**
	 * Gets the absolute file path of the given plug-in entry.
	 * 
	 * @param bundle
	 *            is the plug-in
	 * @param entryPath
	 *            is the entry path in the plug-in
	 * @return the absolute file path
	 */
	private static File getAbsoluteFile(Bundle bundle, String entryPath) {
		URL entry = bundle.getEntry(entryPath);
		File absoluteFile;
		if (entry != null) {
			try {
				entry = FileLocator.toFileURL(entry);
				if (entry != null) {
					absoluteFile = new Path(entry.getPath()).toFile();
				} else {
					absoluteFile = null;
				}
			} catch (IOException e1) {
				absoluteFile = null;
			}
		} else {
			absoluteFile = null;
		}
		return absoluteFile;
	}

	/**
	 * The region of the found word.
	 * 
	 * @param document
	 *            the current document
	 * @param offset
	 *            the given offset
	 * @return the region of the word at the given offset
	 */
	public static IRegion findWord(IDocument document, int offset) {
		int start = -2;
		int end = -1;
		try {
			int pos = offset;
			char c;
			while (pos >= 0) {
				c = document.getChar(pos);
				if (!isAtlIdentifierPart(c)) {
					break;
				}
				--pos;
			}
			start = pos;
			pos = offset;
			int length = document.getLength();

			while (pos < length) {
				c = document.getChar(pos);
				if (!isAtlIdentifierPart(c)) {
					break;
				}
				++pos;
			}
			end = pos;
		} catch (BadLocationException x) {
			// do nothing
		}
		if (start >= -1 && end > -1) {
			if (start == offset && end == offset)
				return new Region(offset, 0);
			else if (start == offset)
				return new Region(start, end - start);
			else
				return new Region(start + 1, end - start - 1);
		}
		return null;
	}

	/**
	 * Checks whether the given char is an ATL identifier part or not.
	 * 
	 * @param ch
	 *            the char
	 * @return <code>true</code> if the given char is an ATL identifier part
	 */
	private static boolean isAtlIdentifierPart(char ch) {
		return !Character.isWhitespace(ch) && ch != '.' && ch != '(' && ch != ')' && ch != '{' && ch != '}'
				&& ch != '.' && ch != ';' && ch != ',' && ch != ':' && ch != '|' && ch != '+' && ch != '-'
				&& ch != '<' && ch != '=' && ch != '>' && ch != '*' && ch != '/' && ch != '!';
	}

}
