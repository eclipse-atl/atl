/*
 * Created on 30 avr. 2004
 */
package org.atl.eclipse.adt.debug.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.atl.eclipse.adt.debug.AtlDebugPlugin;
import org.atl.eclipse.adt.debug.Messages;
import org.atl.eclipse.adt.debug.core.AtlBreakpoint;
import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.atl.eclipse.adt.debug.core.AtlStackFrame;
import org.atl.eclipse.adt.debug.core.AtlThread;
import org.atl.eclipse.adt.debug.core.AtlVariable;
import org.atl.eclipse.adt.launching.AtlLauncherTools;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


/**
 * @author allilaire
 * A debug model presentation is responsible for providing labels, images,
 * and editors associated with debug elements in a specific debug model.
 *
 * To allow for an extensible configuration, IDebugModelPresentation interface defines
 * a setAttribute method.
 * 
 */

public class AtlDebugModelPresentation extends LabelProvider implements IDebugModelPresentation {

	static final URL BASE_URL = AtlDebugPlugin.getDefault().getBundle().getEntry("/");
	static final String iconPath = "icons/";
	
	private HashMap fAttributes= new HashMap(3);

	/**
	 * If the button DISPLAY VARIABLE TYPE NAMES in debugUI is pressed
	 * then the status of the variable DISPLAY_VARIABLE_TYPE_NAMES is changed
	 * 
	 * This method returns true if DISPLAY_VARIABLE_TYPE_NAMES is selected in debugUI
	 */
	private boolean isShowVariableTypeNames() {
		Boolean show= (Boolean) fAttributes.get(DISPLAY_VARIABLE_TYPE_NAMES);
		show= show == null ? Boolean.FALSE : show;
		return show.booleanValue();
	}
	
	/**
	 * Clients may define new presentation attributes. For example, a client may wish
	 * to define a "hexadecimal" property to display numeric values in hexadecimal. Implementations
	 * should honor the presentation attributes defined by this interface where possible,
	 * but do not need to honor presentation attributes defined by other clients.
	 * To access the debug model presentation for a debug view, clients should use
	 * DebugView#getPresentation(String).
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
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	private Image createImage(String path) {
		try {
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
	
	/**
	 * This method returns the image associate to the type of the parameter
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object item) {
		String icon = null;
		if (item instanceof AtlVariable) {
			AtlVariable atlVar = (AtlVariable)item;
			String typeVar = null;
			try {
				typeVar = atlVar.getReferenceTypeName();
			} catch (DebugException e) {
				e.printStackTrace();
			}			
			switch (atlVar.getDescription()) {
				case AtlVariable.ATTRIBUTE : icon = "attribute.gif"; break;
				case AtlVariable.ELEMENT : icon = "element.gif"; break;
				case AtlVariable.LOCALVARIABLE : icon = "localVariable.gif"; break;
				case AtlVariable.REFERENCE : icon = "reference.gif"; break;
				case AtlVariable.SUPERTYPE : icon = "supertype.gif"; break;
				default : return null;
			}
		} else if (item instanceof AtlBreakpoint) {
			icon = "breakpoint.gif";
		} else if (item instanceof IMarker) {
			icon = "breakpoint.gif";
		}
			
		if (icon != null)
			return createImage(iconPath + icon);
		return null;
	}

	/**
	 * This method returns the text associate to the parameter
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object item) {
		if (item instanceof AtlDebugTarget) {
			AtlDebugTarget target = (AtlDebugTarget) item;
			String name = "";
			try {
				name = target.getName();
			}
			catch (DebugException e) {
				e.printStackTrace();
			}
			return name + Messages.getString("AtlDebugModelPresentation.CONNECTEDONHOST")+ target.getHost() + Messages.getString("AtlDebugModelPresentation.PORT") + target.getPort(); //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if (item instanceof AtlThread) {
			AtlThread thread = (AtlThread) item;
			try {
				String currentState;
				String message = "";
				switch (((AtlDebugTarget)thread.getDebugTarget()).getState()) {
					case AtlDebugTarget.stateDisconnected: 	currentState = Messages.getString("AtlDebugModelPresentation.DISCONNECTED"); 	break; //$NON-NLS-1$
					case AtlDebugTarget.stateRunning: 		currentState = Messages.getString("AtlDebugModelPresentation.RUNNING"); 		break; //$NON-NLS-1$
					case AtlDebugTarget.stateSuspended: 	currentState = Messages.getString("AtlDebugModelPresentation.SUSPENDED"); //$NON-NLS-1$
															message = ((AtlDebugTarget)thread.getDebugTarget()).getMessageFromDebuggee();
															return thread.getName() + " (" + currentState + " (" + message + "))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					case AtlDebugTarget.stateTerminated: 	currentState = Messages.getString("AtlDebugModelPresentation.TERMINATED"); 	break; //$NON-NLS-1$
					default : currentState = Messages.getString("AtlDebugModelPresentation.UNKNOWN"); //$NON-NLS-1$
				}
				return thread.getName() + " (" + currentState + ")";
			}
			catch (DebugException e) {
				return null;
			}
		}
		else if (item instanceof AtlStackFrame)
			return null;
		else if (item instanceof AtlVariable) {
			AtlVariable atlVar = (AtlVariable)item;
			String typeVar = null;
			try {
				if (isShowVariableTypeNames())
					typeVar = atlVar.getReferenceTypeName();
				else
					typeVar = "";
				
				String rtn = atlVar.getValue().getReferenceTypeName();
				if (rtn.equals("boolean") || 
					atlVar.getValue().getReferenceTypeName().equals("int"))
					return typeVar + " " + atlVar.getName() + " = " + atlVar.getValue().getValueString();
				else if (rtn.equals("String"))
					return typeVar + " " + atlVar.getName() + " = '" + atlVar.getValue().getValueString() + "'";
				else if (rtn.equals("EnumLiteral"))
					return typeVar + " " + atlVar.getName() + " = #" + atlVar.getValue().getValueString();
				else if (atlVar.getValue().getReferenceTypeName().equals("Map Element"))
					return atlVar.getName();
				else
					return typeVar + " " + atlVar.getName() + " = " + atlVar.getReferenceTypeName() + " (id = " + atlVar.getIdVariable() + ")";
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
		else if (item instanceof AtlBreakpoint)
		{
			IMarker marker = ((AtlBreakpoint)item).getMarker();
			String location;
			try {
				location = (String)marker.getResource().getName();
				Integer lineNumber = (Integer)marker.getAttribute(IMarker.LINE_NUMBER);
				Integer charStart = (Integer)marker.getAttribute(IMarker.CHAR_START);
				Integer charEnd = (Integer)marker.getAttribute(IMarker.CHAR_END);
				return location + " [line: " + lineNumber + ", charStart: " + charStart + ", charEnd: " + charEnd + "]";
			}
			catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue,
	 *      org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		try {
			listener.detailComputed(value,value.getValueString());
		}
		catch (DebugException e) {
			e.printStackTrace();
		}
	}
	
	private class DisassemblyEditorInput implements IStorageEditorInput {

		private IStorage contents;
		
		public DisassemblyEditorInput(IStorage contents) {
			this.contents = contents;
		}
		
		/**
		 * @see org.eclipse.ui.IEditorInput#exists()
		 */
		public boolean exists() {
			return true;
		}

		/**
		 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
		 */
		public ImageDescriptor getImageDescriptor() {
			return null;
		}

		/**
		 * @see org.eclipse.ui.IEditorInput#getName()
		 */
		public String getName() {
			return contents.getName();
		}

		/**
		 * @see org.eclipse.ui.IEditorInput#getPersistable()
		 */
		public IPersistableElement getPersistable() {
			return null;
		}

		/**
		 * @see org.eclipse.ui.IEditorInput#getToolTipText()
		 */
		public String getToolTipText() {
			return null;
		}

		/**
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class adapter) {
			return null;
		}

		/**
		 * @see org.eclipse.ui.IStorageEditorInput#getStorage()
		 */
		public IStorage getStorage() throws CoreException {
			return contents;
		}
	}

	private IEditorPart dte;
	
	public IEditorInput getDisassemblyEditorInput(AtlStackFrame frame) {
		IEditorInput ret = null;

		ret = new DisassemblyEditorInput(frame.getDisassembled());

		if(dte == null) {
			try {
				IWorkbenchPage iwp[] = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getPages();
				dte = iwp[0].openEditor(ret, "org.eclipse.ui.DefaultTextEditor");
			}
			catch (PartInitException e) {
				e.printStackTrace();
			}
		} else {
			//dte.
		}
		
		return ret;
	}

	/**
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		IStorageEditorInput i;
		AtlStackFrame frame;
		String projectName;
		String fileName;
		
		if(element instanceof AtlStackFrame ) {
			frame = (AtlStackFrame) element;
			if(((AtlDebugTarget)frame.getDebugTarget()).isDisassemblyMode()) return getDisassemblyEditorInput(frame);
			ILaunchConfiguration configuration = frame.getDebugTarget().getLaunch().getLaunchConfiguration();
			try {
				fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME, AtlLauncherTools.NULLPARAMETER);

				IWorkspace wks = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot wksroot = wks.getRoot();

				i = new FileEditorInput(wksroot.getFile(new Path(fileName)));
				return i;
			}
			catch (CoreException e) {
				e.printStackTrace();
			}
		}
		else if(element instanceof AtlBreakpoint)
		{
			IMarker marker = ((AtlBreakpoint)element).getMarker();
			IFile ifile = (IFile)marker.getResource();
			return new FileEditorInput(ifile);
		}
		return null;
	}

	/**
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput,
	 *      java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		if(input instanceof DisassemblyEditorInput)
			return "org.eclipse.ui.DefaultTextEditor";
		IEditorRegistry registry= PlatformUI.getWorkbench().getEditorRegistry();
		IEditorDescriptor descriptor= registry.getDefaultEditor(input.getName());
		if (descriptor != null)
			return descriptor.getId();
		
		return null;
	}

}