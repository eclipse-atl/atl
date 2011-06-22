/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ResourceIterable;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl#isAllowInterModelReferences <em>Allow Inter Model References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {

	/**
	 * {@link LazyList} that returns only instances of a given type.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class InstanceOfList extends LazyList<EObject> {

		/**
		 * {@link Iterator} for {@link InstanceOfList}.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class InstanceOfIterator extends CachingIterator {

			protected EObject next = null;
			protected boolean nextSet = false;

			/**
			 * Creates a new {@link InstanceOfIterator}.
			 */
			public InstanceOfIterator() {
				super(dataSource.iterator());
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.CachingIterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				if (i < cache.size()) {
					return true;
				} else if (dataSource == null) {
					return false;
				}
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				while (inner.hasNext() && !type.isInstance(next)) {
					next = inner.next();
				}
				final boolean hasNext = nextSet && type.isInstance(next);
				if (!hasNext) {
					dataSource = null; // cache complete
					assert i == cache.size();
				}
				return hasNext;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.CachingIterator#next()
			 */
			@Override
			public EObject next() {
				if (!nextSet) {
					next = inner.next(); // support null values for next
				} else {
					nextSet = false;
				}
				while (!type.isInstance(next)) {
					next = inner.next();
				}
				assert !nextSet && type.isInstance(next);
				if (++i > cache.size()) {
					assert dataSource != null; // cache not complete
					cache.add(next);
				} else {
					assert cache.contains(next);
				}
				return next;
			}
		}

		protected final EClass type;

		/**
		 * Creates a new {@link InstanceOfList} around <code>dataSource</code>.
		 * @param dataSource
		 * @param type the type of which to return the instances
		 */
		public InstanceOfList(Iterable<EObject> dataSource, EClass type) {
			super(dataSource);
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<EObject> iterator() {
			if (dataSource == null) { // cache complete
				return cache.iterator();
			}
			return new InstanceOfIterator();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#remove(java.lang.Object)
		 */
		@Override
		public boolean remove(Object o) {
			if (dataSource == null) { // cache complete
				return cache.remove(o);
			}
			return super.remove(o);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#add(java.lang.Object)
		 */
		@Override
		public boolean add(EObject o) {
			if (dataSource == null) { // cache complete
				return cache.add(o);
			}
			return super.add(o);
		}
	}

	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final Resource RESOURCE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected Resource resource = RESOURCE_EDEFAULT;
	/**
	 * The default value of the '{@link #isAllowInterModelReferences() <em>Allow Inter Model References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowInterModelReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_INTER_MODEL_REFERENCES_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isAllowInterModelReferences() <em>Allow Inter Model References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowInterModelReferences()
	 * @generated
	 * @ordered
	 */
	protected boolean allowInterModelReferences = ALLOW_INTER_MODEL_REFERENCES_EDEFAULT;
	/**
	 * Cache of allInstancesOf().
	 */
	protected Map<EClass, InstanceOfList> allInstancesMap = new HashMap<EClass, InstanceOfList>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(Resource newResource) {
		Resource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowInterModelReferences() {
		return allowInterModelReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowInterModelReferences(boolean newAllowInterModelReferences) {
		boolean oldAllowInterModelReferences = allowInterModelReferences;
		allowInterModelReferences = newAllowInterModelReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL__ALLOW_INTER_MODEL_REFERENCES, oldAllowInterModelReferences, allowInterModelReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param type
	 * @return all instances of type
	 * <!-- end-user-doc -->
	 */
	public LazyList<EObject> allInstancesOf(final EClass type) {
		if (!allInstancesMap.containsKey(type)) {
			allInstancesMap.put(type, new InstanceOfList(
					new ResourceIterable(getResource()), type));
		}
		return allInstancesMap.get(type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param type
	 * @return a new instance of type
	 * <!-- end-user-doc -->
	 */
	public EObject newElement(EClass type) {
		final EObject instance = type.getEPackage().getEFactoryInstance().create(type);
		getResource().getContents().add(instance);
		assert instance.eResource() == getResource();
		if (allInstancesMap.containsKey(type)) {
			try {
				allInstancesMap.get(type).add(instance);
			} catch (UnsupportedOperationException e) {
				allInstancesMap.remove(type);
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Deletes <code>element</code> from this model.
	 * Resets allInstancesOf cache for <code>element</code>'s {@link EClass}.
	 * @param element
	 * <!-- end-user-doc -->
	 */
	public void deleteElement(EObject element) {
		assert getResource() == element.eResource();
		final EList<EObject> resContents = getResource().getContents();
		EcoreUtil.delete(element);
		for (EObject child : new ArrayList<EObject>(element.eContents())) {
			assert child.eResource() == null;
			// adding children to a container removes them from their previous container
			resContents.add(child); 
		}
		final EClass type = element.eClass();
		if (allInstancesMap.containsKey(type)) {
			try {
				allInstancesMap.get(type).remove(element);
			} catch (UnsupportedOperationException e) {
				allInstancesMap.remove(type);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.MODEL__RESOURCE:
				return getResource();
			case EmftvmPackage.MODEL__ALLOW_INTER_MODEL_REFERENCES:
				return isAllowInterModelReferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.MODEL__RESOURCE:
				setResource((Resource)newValue);
				return;
			case EmftvmPackage.MODEL__ALLOW_INTER_MODEL_REFERENCES:
				setAllowInterModelReferences((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.MODEL__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
				return;
			case EmftvmPackage.MODEL__ALLOW_INTER_MODEL_REFERENCES:
				setAllowInterModelReferences(ALLOW_INTER_MODEL_REFERENCES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.MODEL__RESOURCE:
				return RESOURCE_EDEFAULT == null ? resource != null : !RESOURCE_EDEFAULT.equals(resource);
			case EmftvmPackage.MODEL__ALLOW_INTER_MODEL_REFERENCES:
				return allowInterModelReferences != ALLOW_INTER_MODEL_REFERENCES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resource: ");
		result.append(resource.getURI() == null ? resource : resource.getURI());
		result.append(')');
		return result.toString();
	}

} //ModelImpl
