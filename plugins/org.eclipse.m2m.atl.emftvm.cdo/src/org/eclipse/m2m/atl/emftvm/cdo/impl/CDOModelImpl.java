/*******************************************************************************
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.cdo.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.ModelImpl;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyList.NonCachingList;

/**
 * CDO implementation of {@link Model}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CDOModelImpl extends ModelImpl {

	/**
	 * {@link LazyList} that returns only instances within a given {@link Resource}.
	 *
	 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
	 */
	public static class InResourceList extends NonCachingList<EObject> {

		/**
		 * {@link Iterator} for {@link InResourceList}.
		 *
		 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
		 */
		public class InResourceIterator extends WrappedIterator {

			protected EObject next = null;
			protected boolean nextSet = false;

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				while (inner.hasNext() && (next == null || next.eResource() != resource)) {
					next = inner.next();
				}
				return nextSet && next != null && next.eResource() == resource;
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
				while (next.eResource() != resource) {
					next = inner.next();
				}
				assert !nextSet && next.eResource() == resource;
				return next;
			}
		}

		protected final Resource resource;

		/**
		 * Creates a new {@link InResourceList} around <code>dataSource</code>.
		 *
		 * @param dataSource the underlying data source
		 * @param resource   the resource of which to return the instances
		 */
		public InResourceList(final Iterable<EObject> dataSource, final Resource resource) {
			super(dataSource);
			this.resource = resource;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<EObject> iterator() {
			if (dataSource == null) { // cache complete
				return cache.iterator();
			}
			return new InResourceIterator();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setResource(final Resource newResource) {
		if (newResource != null && !(newResource instanceof CDOResource)) {
			throw new IllegalArgumentException("Resource should be a CDOResource, but was: " + newResource);
		}
		super.setResource(newResource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LazyList<EObject> allInstancesOf(final EClass type) {
		if (!allInstancesMap.containsKey(type)) {
			allInstancesMap.put(type,
					new InResourceList(new CDOInstanceOfIterable((CDOResource) getResource(), type), getResource()));
		}
		return allInstancesMap.get(type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject newElement(final EClass type) {
		final EObject instance = type.getEPackage().getEFactoryInstance().create(type);
		getResource().getContents().add(instance);
		assert instance.eResource() == getResource();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteElement(final EObject element) {
		assert getResource() == element.eResource();
		final EList<EObject> resContents = getResource().getContents();
		if (!resContents.remove(element)) {
			throw new IllegalArgumentException(
					String.format("Element %s not contained as a root element in this model", element));
		}
		for (final EObject child : new ArrayList<EObject>(element.eContents())) {
			assert child.eResource() == null;
			// adding children to a container removes them from their previous container
			resContents.add(child);
		}
	}
}
