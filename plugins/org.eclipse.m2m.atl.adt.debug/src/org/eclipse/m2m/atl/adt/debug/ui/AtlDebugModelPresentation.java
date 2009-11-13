/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.atl.adt.debug.AtlDebugPlugin;
import org.eclipse.m2m.atl.adt.debug.Messages;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.debug.core.AtlBreakpoint;
import org.eclipse.m2m.atl.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.debug.core.AtlStackFrame;
import org.eclipse.m2m.atl.debug.core.AtlThread;
import org.eclipse.m2m.atl.debug.core.AtlVariable;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * A debug model presentation is responsible for providing labels, images, and editors associated with debug
 * elements in a specific debug model. To allow for an extensible configuration, IDebugModelPresentation
 * interface defines a setAttribute method.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlDebugModelPresentation extends LabelProvider implements IDebugModelPresentation {
	/** If you add a constant here, look in the class AtlVariable if the value is not already used. */
	public static final int BREAKPOINT = 5;

	static final URL BASE_URL = AtlDebugPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$

	static final String ICON_PATH = "icons/"; //$NON-NLS-1$

	private Map<Integer, Image> mapImage;

	private Map<String, Object> fAttributes = new HashMap<String, Object>(3);

	/**
	 * If the button DISPLAY VARIABLE TYPE NAMES in debugUI is pressed then the status of the variable
	 * DISPLAY_VARIABLE_TYPE_NAMES is changed. This method returns true if DISPLAY_VARIABLE_TYPE_NAMES is
	 * selected in debugUI
	 */
	private boolean isShowVariableTypeNames() {
		Boolean show = (Boolean)fAttributes.get(DISPLAY_VARIABLE_TYPE_NAMES);
		show = show == null ? Boolean.FALSE : show;
		return show.booleanValue();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String attribute, Object value) {
		if (value == null) {
			return;
		}
		fAttributes.put(attribute, value);
	}

	/**
	 * This method returns an image from the path.
	 * 
	 * @param path
	 * @return
	 */
	private Image createImage(String path) {
		try {
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		} catch (MalformedURLException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return null;
	}

	private void initMapImage() {
		mapImage = new HashMap<Integer, Image>();
		mapImage.put(new Integer(AtlVariable.ATTRIBUTE), null);
		mapImage.put(new Integer(AtlVariable.ELEMENT), null);
		mapImage.put(new Integer(AtlVariable.LOCALVARIABLE), null);
		mapImage.put(new Integer(AtlVariable.REFERENCE), null);
		mapImage.put(new Integer(AtlVariable.SUPERTYPE), null);
		mapImage.put(new Integer(BREAKPOINT), null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object item) {
		if (mapImage == null) {
			initMapImage();
		}

		if (item instanceof AtlVariable) {
			String imageName = null;
			AtlVariable atlVar = (AtlVariable)item;
			switch (atlVar.getDescription()) {
				case AtlVariable.ATTRIBUTE:
					imageName = "attribute.gif"; //$NON-NLS-1$
					break;
				case AtlVariable.ELEMENT:
					imageName = "element.gif"; //$NON-NLS-1$
					break;
				case AtlVariable.LOCALVARIABLE:
					imageName = "localVariable.gif"; //$NON-NLS-1$
					break;
				case AtlVariable.REFERENCE:
					imageName = "reference.gif"; //$NON-NLS-1$
					break;
				case AtlVariable.SUPERTYPE:
					imageName = "supertype.gif"; //$NON-NLS-1$
					break;
				default:
					return null;
			}
			if (mapImage.get(new Integer(atlVar.getDescription())) == null) {
				mapImage.put(new Integer(atlVar.getDescription()), createImage(ICON_PATH + imageName));
			}
			return mapImage.get(new Integer(atlVar.getDescription()));
		} else if (item instanceof AtlBreakpoint) {
			if (mapImage.get(new Integer(BREAKPOINT)) == null) {
				mapImage.put(new Integer(BREAKPOINT), createImage(ICON_PATH + "breakpoint.gif")); //$NON-NLS-1$
			}
			return mapImage.get(new Integer(BREAKPOINT));
		} else if (item instanceof IMarker) {
			if (mapImage.get(new Integer(BREAKPOINT)) == null) {
				mapImage.put(new Integer(BREAKPOINT), createImage(ICON_PATH + "breakpoint.gif")); //$NON-NLS-1$
			}
			return mapImage.get(new Integer(BREAKPOINT));
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object item) {
		if (item instanceof AtlDebugTarget) {
			AtlDebugTarget target = (AtlDebugTarget)item;
			String name = ""; //$NON-NLS-1$
			try {
				name = target.getName();
			} catch (DebugException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			return name
					+ Messages.getString("AtlDebugModelPresentation.CONNECTEDONHOST") + target.getHost() + Messages.getString("AtlDebugModelPresentation.PORT") + target.getPort(); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (item instanceof AtlThread) {
			AtlThread thread = (AtlThread)item;
			try {
				String currentState;
				String message = ""; //$NON-NLS-1$
				switch (((AtlDebugTarget)thread.getDebugTarget()).getState()) {
					case AtlDebugTarget.STATE_DISCONNECTED:
						currentState = Messages.getString("AtlDebugModelPresentation.DISCONNECTED"); //$NON-NLS-1$
						break;
					case AtlDebugTarget.STATE_RUNNING:
						currentState = Messages.getString("AtlDebugModelPresentation.RUNNING"); //$NON-NLS-1$
						break;
					case AtlDebugTarget.STATE_SUSPENDED:
						currentState = Messages.getString("AtlDebugModelPresentation.SUSPENDED"); //$NON-NLS-1$
						message = ((AtlDebugTarget)thread.getDebugTarget()).getMessageFromDebuggee();
						return thread.getName() + " (" + currentState + " (" + message + "))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					case AtlDebugTarget.STATE_TERMINATED:
						currentState = Messages.getString("AtlDebugModelPresentation.TERMINATED"); //$NON-NLS-1$
						break;
					default:
						currentState = Messages.getString("AtlDebugModelPresentation.UNKNOWN"); //$NON-NLS-1$
				}
				return thread.getName() + " (" + currentState + ")"; //$NON-NLS-1$//$NON-NLS-2$
			} catch (DebugException e) {
				return null;
			}
		} else if (item instanceof AtlStackFrame) {
			return null;
		} else if (item instanceof AtlVariable) {
			AtlVariable atlVar = (AtlVariable)item;
			String typeVar = null;
			try {
				if (isShowVariableTypeNames()) {
					typeVar = atlVar.getReferenceTypeName();
				} else {
					typeVar = ""; //$NON-NLS-1$
				}
				String rtn = atlVar.getValue().getReferenceTypeName();
				if (rtn.equals("Boolean") || //$NON-NLS-1$
						rtn.equals("Integer") || //$NON-NLS-1$
						rtn.equals("Real")) { //$NON-NLS-1$
					return typeVar + " " + atlVar.getName() + " = " + atlVar.getValue().getValueString(); //$NON-NLS-1$//$NON-NLS-2$
				} else if (rtn.equals("String")) { //$NON-NLS-1$
					return typeVar
							+ " " + atlVar.getName() + " = '" + atlVar.getValue().getValueString() + "'"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
				} else if (rtn.equals("EnumLiteral")) { //$NON-NLS-1$
					return typeVar + " " + atlVar.getName() + " = #" + atlVar.getValue().getValueString(); //$NON-NLS-1$//$NON-NLS-2$
				} else if (rtn.equals("Map Element")) { //$NON-NLS-1$
					return atlVar.getName();
				} else {
					return typeVar
							+ " " + atlVar.getName() + " = " + atlVar.getReferenceTypeName() + " (id = " + atlVar.getIdVariable() + ")"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
				}
			} catch (DebugException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		} else if (item instanceof AtlBreakpoint) {
			IMarker marker = ((AtlBreakpoint)item).getMarker();
			String location;
			try {
				location = marker.getResource().getName();
				Integer lineNumber = (Integer)marker.getAttribute(IMarker.LINE_NUMBER);
				Integer charStart = (Integer)marker.getAttribute(IMarker.CHAR_START);
				Integer charEnd = (Integer)marker.getAttribute(IMarker.CHAR_END);
				return location + " [line: " + lineNumber + //$NON-NLS-1$
						", charStart: " + charStart + //$NON-NLS-1$
						", charEnd: " + charEnd + //$NON-NLS-1$
						"]"; //$NON-NLS-1$
			} catch (CoreException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue,
	 *      org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		try {
			listener.detailComputed(value, value.getValueString());
		} catch (DebugException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Specific implementation of the {@link IStorageEditorInput} for disassembly.
	 */
	private class DisassemblyEditorInput implements IStorageEditorInput {

		private IStorage contents;

		public DisassemblyEditorInput(IStorage contents) {
			this.contents = contents;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IEditorInput#exists()
		 */
		public boolean exists() {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
		 */
		public ImageDescriptor getImageDescriptor() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IEditorInput#getName()
		 */
		public String getName() {
			return contents.getName();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IEditorInput#getPersistable()
		 */
		public IPersistableElement getPersistable() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IEditorInput#getToolTipText()
		 */
		public String getToolTipText() {
			return contents.getName();
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
		 * @see org.eclipse.ui.IStorageEditorInput#getStorage()
		 */
		public IStorage getStorage() throws CoreException {
			return contents;
		}
	}

	/**
	 * Returns the disassembly editor.
	 * 
	 * @param frame
	 *            the frame context
	 * @return the disassembly editor
	 */
	public IEditorInput getDisassemblyEditorInput(AtlStackFrame frame) {
		IEditorInput ret = null;

		ret = new DisassemblyEditorInput(frame.getDisassembled());

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		if (element instanceof AtlStackFrame) {
			AtlStackFrame frame = (AtlStackFrame)element;
			if (((AtlDebugTarget)frame.getDebugTarget()).isDisassemblyMode()) {
				return getDisassemblyEditorInput(frame);
			}
			return new FileEditorInput(frame.getSourcefile());
		} else if (element instanceof AtlBreakpoint) {
			IMarker marker = ((AtlBreakpoint)element).getMarker();
			IFile ifile = (IFile)marker.getResource();
			return new FileEditorInput(ifile);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput,
	 *      java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		if (input instanceof DisassemblyEditorInput) {
			return "org.eclipse.ui.DefaultTextEditor"; //$NON-NLS-1$
		}
		IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
		IEditorDescriptor descriptor = registry.getDefaultEditor(input.getName());
		if (descriptor != null) {
			return descriptor.getId();
		}
		return "org.eclipse.ui.DefaultTextEditor"; //$NON-NLS-1$
	}

}
