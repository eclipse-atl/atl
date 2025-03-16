/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * Copyright (c) 2012, 2013, 2018, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ResourceIterable;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl#isAllowInterModelReferences <em>Allow Inter Model References</em>}</li>
 * </ul>
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

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				synchronized (cache) {
					if (i < cache.size()) {
						return true;
					} else if (dataSource == null) {
						return false;
					}
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

			/**
			 * {@inheritDoc}
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
				updateCache(next);
				return next;
			}
		}

		protected final EClass type;

		/**
		 * Creates a new {@link InstanceOfList} around <code>dataSource</code>.
		 * @param dataSource
		 * @param type the type of which to return the instances
		 */
		public InstanceOfList(final Iterable<EObject> dataSource, final EClass type) {
			super(dataSource);
			this.type = type;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<EObject> iterator() {
			if (dataSource == null) { // cache complete
				return cache.iterator();
			}
			return new InstanceOfIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean remove(final Object o) {
			// try to remove from cache - if not contained, nothing needs to be done
			return cache.remove(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean add(final EObject o) {
			// add to cache only if complete - if not contained, it will show up on the next iteration
			synchronized (cache) {
				if (dataSource == null) { // cache complete
					return cache.add(o);
				}
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createCache() {
			super.createCache();
			assert cache instanceof List<?>;
			cache = Collections.synchronizedList((List<EObject>)cache);
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
	protected final Map<EClass, LazyList<EObject>> allInstancesMap = new HashMap<EClass, LazyList<EObject>>();

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link ModelImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowInterModelReferences() {
		return allowInterModelReferences;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public EObject newElement(final EClass type) {
		final EObject instance = type.getEPackage().getEFactoryInstance().create(type);
		getResource().getContents().add(instance);
		assert instance.eResource() == getResource();
		addElement(instance, type);
		return instance;
	}

	/**
	 * Adds <code>element</code> to the "allInstances" list for the given type and all its supertypes.
	 *
	 * @param element
	 *            the element to add
	 * @param type
	 *            the current type
	 */
	private void addElement(final EObject element, final EClass type) {
		if (allInstancesMap.containsKey(type)) {
			allInstancesMap.get(type).add(element);
		}
		for (final EClass superType : type.getESuperTypes()) {
			addElement(element, superType);
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public void deleteElement(final EObject element) {
		assert getResource() == element.eResource();
		final EList<EObject> resContents = getResource().getContents();
		if (!resContents.remove(element)) {
			throw new IllegalArgumentException(String.format("Element %s not contained as a root element in this model", element));
		}
		for (final EObject child : new ArrayList<EObject>(element.eContents())) {
			assert child.eResource() == null;
			// adding children to a container removes them from their previous container
			resContents.add(child);
		}
		deleteElement(element, element.eClass());
	}

	/**
	 * Deletes <code>element</code> from the "allInstances" list for the given type and all its supertypes.
	 *
	 * @param element
	 *            the element to delete
	 * @param type
	 *            the current type
	 */
	private void deleteElement(final EObject element, final EClass type) {
		if (allInstancesMap.containsKey(type)) {
			allInstancesMap.get(type).remove(element);
		}
		for (final EClass superType : type.getESuperTypes()) {
			deleteElement(element, superType);
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
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
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resource: ");
		result.append(resource.getURI() == null ? resource : resource.getURI());
		result.append(')');
		return result.toString();
	}

} //ModelImpl
