/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.adapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.emfvm.VMException;

/**
 * The {@link EMFModelAdapter} adaptation for UML2.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class UML2ModelAdapter extends EMFModelAdapter implements IModelAdapter {

	/** Ordered methods to delay. */
	private List<Invocation> delayedInvocations = new ArrayList<Invocation>();

	/**
	 * Creates a new UMLModelAdapter.
	 */
	public UML2ModelAdapter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.EMFModelAdapter#finalizeModel(org.eclipse.m2m.atl.core.IModel)
	 */
	@Override
	public void finalizeModel(IModel model) {
		super.finalizeModel(model);
		try {
			applyDelayedInvocations();
		} catch (InvocationTargetException e) {
			throw new VMException(null, e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new VMException(null, e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.EMFModelAdapter#invoke(java.lang.reflect.Method,
	 *      java.lang.Object, java.lang.Object[])
	 */
	@Override
	public Object invoke(Method method, Object self, Object[] arguments) {
		if (method.getName().equals("applyProfile") //$NON-NLS-1$ 
				|| method.getName().equals("applyStereotype") //$NON-NLS-1$
				|| method.getName().equals("setValue") //$NON-NLS-1$
				|| method.getName().equals("applyAllRequiredStereotypes") //$NON-NLS-1$
				|| method.getName().equals("applyAllStereotypes") //$NON-NLS-1$
				|| method.getName().equals("unapplyAllStereotype") //$NON-NLS-1$
				|| method.getName().equals("unapplyAllNonApplicableStereotypes")) { //$NON-NLS-1$
			addDelayedInvocation(new Invocation(method, self, method.getName().toString(), arguments));
			return null;
		}
		return super.invoke(method, self, arguments);
	}

	/**
	 * Stores a method invocation.
	 */
	private final class Invocation {

		private final Method method;

		private final Object self;

		private final String opName;

		private final Object[] arguments;

		private Invocation(Method method, Object self, String opName, Object[] arguments) {
			this.method = method;
			this.self = self;
			this.opName = opName;
			this.arguments = arguments;
		}
	}

	private void addDelayedInvocation(Invocation invocation) {
		// Guarantee the applied profiles operations are the first applied
		if (invocation.opName.equals("applyProfile")) { //$NON-NLS-1$
			delayedInvocations.add(0, invocation);
		} else {
			if (invocation.opName.equals("applyStereotype") //$NON-NLS-1$
					|| invocation.opName.equals("applyAllStereotypes") //$NON-NLS-1$
					|| invocation.opName.equals("applyAllRequiredStereotypes")) { //$NON-NLS-1$
				// Guarantee the applied stereotypes operations are applied before setValue and after
				// applyProfile
				int lastApplyProfile = getLastStereotypeMethod("applyProfile"); //$NON-NLS-1$
				if (lastApplyProfile < delayedInvocations.size() - 1) {
					delayedInvocations.add(lastApplyProfile + 1, invocation);
				} else {
					delayedInvocations.add(invocation);
				}
			} else {
				// SetValue operation follow this way
				delayedInvocations.add(invocation);
			}
		}
	}

	private int getLastStereotypeMethod(String opName) {
		int rang = 0;
		for (int i = 0; i < delayedInvocations.size(); i++) {
			Invocation invoc = delayedInvocations.get(rang);
			if (invoc.opName.equals(opName)) {
				rang = i;
			}
		}
		return rang;
	}

	private void applyDelayedInvocations() throws InvocationTargetException, IllegalAccessException {
		for (Iterator<Invocation> i = delayedInvocations.iterator(); i.hasNext();) {
			Invocation invocation = i.next();
			invocation.method.invoke(invocation.self, invocation.arguments);
		}
		delayedInvocations.clear();
	}

}
