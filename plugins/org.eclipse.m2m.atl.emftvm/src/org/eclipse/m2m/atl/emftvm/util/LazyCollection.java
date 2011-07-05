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
package org.eclipse.m2m.atl.emftvm.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.CodeBlock;


/**
 * Immutable {@link Collection} that supports lazy evaluation.
 * Based on the OCL 2.2 specification (formal/2010-02-01).
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public abstract class LazyCollection<E> implements Collection<E> {

	/**
	 * {@link Iterator} without {@link #remove()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E>
	 */
	public abstract static class ReadOnlyIterator<E> implements Iterator<E> {

		/**
		 * Unsupported.
		 * @throws UnsupportedOperationException
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * {@link ListIterator} without {@link #remove()}, {@link #add(Object)}, and {@link #set(Object)}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E>
	 */
	public abstract static class ReadOnlyListIterator<E> extends ReadOnlyIterator<E> implements ListIterator<E> {
	
		/**
		 * Unsupported.
		 * @throws UnsupportedOperationException
		 * @param o the object to add
		 */
		public void add(E o) {
			throw new UnsupportedOperationException();
		}
	
		/**
		 * Unsupported.
		 * @throws UnsupportedOperationException
		 * @param o the object to set
		 */
		public void set(E o) {
			throw new UnsupportedOperationException();
		}
	
	}

	/**
	 * Abstract {@link ReadOnlyIterator} that wraps around the underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public abstract class WrappedIterator extends ReadOnlyIterator<E> {

		protected final Iterator<E> inner = dataSource.iterator();

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return inner.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return inner.next();
		}
	}

	/**
	 * Abstract {@link ReadOnlyListIterator} that wraps around the underlying collection.
	 * Assumes the underlying collection is a {@link List}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public abstract class WrappedListIterator extends ReadOnlyListIterator<E> {

		protected final ListIterator<E> inner;

		/**
		 * Creates a new {@link WrappedListIterator}.
		 */
		public WrappedListIterator() {
			super();
			this.inner = ((List<E>)dataSource).listIterator();
		}

		/**
		 * Creates a new {@link WrappedListIterator} starting at <code>index</code>.
		 * @param index the iterator starting index of the underlying iterator.
		 */
		public WrappedListIterator(final int index) {
			super();
			this.inner = ((List<E>)dataSource).listIterator(index);
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return inner.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasPrevious() {
			return inner.hasPrevious();
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return inner.next();
		}

		/**
		 * {@inheritDoc}
		 */
		public int nextIndex() {
			return inner.nextIndex();
		}

		/**
		 * {@inheritDoc}
		 */
		public E previous() {
			return inner.previous();
		}

		/**
		 * {@inheritDoc}
		 */
		public int previousIndex() {
			return inner.previousIndex();
		}
	}

	/**
	 * {@link ReadOnlyIterator} that caches values of the underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class CachingIterator extends ReadOnlyIterator<E> {

		protected final Iterator<E> inner;
		protected int i;

		/**
		 * Creates a new {@link CachingIterator} around <code>inner</code>.
		 * @param inner the underlying collection iterator
		 */
		public CachingIterator(final Iterator<E> inner) {
			super();
			this.inner = inner;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			final boolean hasNext = i < cache.size() || (dataSource != null && inner.hasNext());
			if (!hasNext) {
				dataSource = null; // cache complete
				assert i == cache.size();
			}
			return hasNext;
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			final E next = inner.next();
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
	}

	/**
	 * Converts an {@link Iterator} to a {@link ListIterator}.
	 * Does not support modification of the underlying {@link LazyList}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class IteratorToListIterator extends CachingIterator implements ListIterator<E> {
	
		/**
		 * Creates a new {@link IteratorToListIterator} for this {@link LazyList}.
		 */
		public IteratorToListIterator() {
			super(iterator());
		}
	
		/**
		 * Creates a new {@link IteratorToListIterator} for this {@link LazyList}.
		 * @param index the iterator starting index.
		 */
		public IteratorToListIterator(final int index) {
			super(iterator());
			while (nextIndex() < index) {
				next();
			}
		}
	
		/**
		 * Unsupported.
		 * @throws UnsupportedOperationException
		 * @param o the object to add
		 */
		public void add(E o) {
			throw new UnsupportedOperationException();
		}
	
		/**
		 * Unsupported.
		 * @throws UnsupportedOperationException
		 * @param o the object to set
		 */
		public void set(E o) {
			throw new UnsupportedOperationException();
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasPrevious() {
			return i > 0;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public int nextIndex() {
			return i;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E previous() {
			if (i > 0) {
				return ((List<E>)cache).get(--i);
			}
			throw new NoSuchElementException();
		}
	
		/**
		 * {@inheritDoc}
		 */
		public int previousIndex() {
			return i - 1;
		}
	
	}

	/**
	 * {@link ReadOnlyIterator} that removes duplicate values from the underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class CachingSetIterator extends CachingIterator {
	
		protected final Set<E> returnedValues = new HashSet<E>();
		protected E next;
		protected boolean nextSet;

		/**
		 * Creates a new {@link CachingSetIterator}.
		 */
		public CachingSetIterator() {
			super(dataSource.iterator());
		}

		/**
		 * {@inheritDoc}
		 */
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
			while (nextSet && returnedValues.contains(next) && inner.hasNext()) {
				next = inner.next();
			}
			final boolean hasNext = nextSet && !returnedValues.contains(next);
			if (!hasNext) {
				dataSource = null; // cache complete
				assert i == cache.size();
			}
			return hasNext;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E next() {
			if (!nextSet) {
				next = inner.next();
			} else {
				nextSet = false;
			}
			while (returnedValues.contains(next)) {
				next = inner.next();
			}
			assert !nextSet && !returnedValues.contains(next);
			returnedValues.add(next);
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
		
	}

	/**
	 * {@link Iterator} that appends an object to the underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class AppendIterator extends WrappedIterator {

		protected final E object;
		protected boolean beforeTail = true;

		/**
		 * Creates a new {@link AppendIterator}.
		 * @param object the element to append
		 */
		public AppendIterator(final E object) {
			super();
			this.object = object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			assert beforeTail || !inner.hasNext(); // not beforeTail implies not inner.hasNext()
			return beforeTail;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() {
			if (inner.hasNext()) {
				return inner.next();
			} else if (beforeTail) {
				beforeTail = false;
				return object;
			}
			throw new NoSuchElementException();
		}
	}

	/**
	 * {@link Iterator} that iterates over a subrange of the underlying {@link LazyList}'s contents.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class SubListIterator extends ReadOnlyIterator<E> {

		protected final int toIndex;
		protected int i;
	
		/**
		 * Creates a {@link SubListIterator} for the range <code>fromIndex</code>,
		 * including, to <code>toIndex</code>, excluding.
		 * @param fromIndex the starting index, inclusive
		 * @param toIndex the ending index, exclusive
		 */
		public SubListIterator(final int fromIndex, final int toIndex) {
			super();
			this.i = fromIndex;
			this.toIndex = toIndex;
			assert dataSource instanceof List<?>;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return i <= toIndex;
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return ((List<E>)dataSource).get(i++);
		}
	
	}

	/**
	 * {@link Iterator} that iterates over a subrange of the underlying {@link LazyList}'s contents.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class SubListListIterator extends ReadOnlyListIterator<E> {
	
		protected final int fromIndex;
		protected final int toIndex;
		protected int i;
	
		/**
		 * Creates a {@link SubListListIterator} for the range <code>fromIndex</code>,
		 * including, to <code>toIndex</code>, excluding.
		 * @param fromIndex the starting index. inclusive
		 * @param toIndex the ending index, exclusive
		 */
		public SubListListIterator(final int fromIndex, final int toIndex) {
			super();
			this.i = fromIndex;
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;
			assert dataSource instanceof List<?>;
		}
	
		/**
		 * Creates a {@link SubListListIterator} for the range <code>fromIndex</code>,
		 * including, to <code>toIndex</code>, excluding.
		 * @param fromIndex the starting index, inclusive
		 * @param toIndex the ending index, exclusive
		 * @param index the iterator starting index.
		 */
		public SubListListIterator(final int fromIndex, final int toIndex, final int index) {
			super();
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;
			this.i = index;
			if (fromIndex > index || index >= toIndex) {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			assert dataSource instanceof List<?>;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return i <= toIndex;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return ((List<E>)dataSource).get(i++);
		}
	
		/**
		 * {@inheritDoc}
		 */
		public int nextIndex() {
			return i;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasPrevious() {
			return i > fromIndex;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E previous() {
			return ((List<E>)dataSource).get(--i);
		}
	
		/**
		 * {@inheritDoc}
		 */
		public int previousIndex() {
			return i - 1;
		}
		
	}

	/**
	 * {@link ReadOnlyIterator} that excludes a given object.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class ExcludingIterator extends CachingIterator {
	
		protected final E object;
		protected E next;
		protected boolean nextSet;
	
		/**
		 * Creates a new {@link ExcludingIterator}, which excludes <code>object</code>.
		 * @param object the object to exclude
		 */
		public ExcludingIterator(final E object) {
			super(dataSource.iterator());
			this.object = object;
		}

		/**
		 * {@inheritDoc}
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
			while (nextSet && (object == null ? next == null : object.equals(next)) && inner.hasNext()) { // inner.hasNext() is expensive
				next = inner.next();
			}
			final boolean hasNext = nextSet && !(object == null ? next == null : object.equals(next));
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
		public E next() {
			if (!nextSet) {
				next = inner.next();
			} else {
				nextSet = false;
			}
			while (object == null ? next == null : object.equals(next)) {
				next = inner.next();
			}
			assert !nextSet && !(object == null ? next == null : object.equals(next));
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
	}

	/**
	 * {@link ReadOnlyIterator} that returns only elements contained in both underlying collections.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class IntersectionIterator extends CachingIterator {
	
		protected final Collection<E> s;
		protected E next;
		protected boolean nextSet;
	
		/**
		 * Creates a new {@link IntersectionIterator} on this and <code>s</code>.
		 * @param s the collection to intersect with this
		 */
		public IntersectionIterator(final Collection<E> s) {
			super(dataSource.iterator());
			this.s = s;
		}
	
		/**
		 * {@inheritDoc}
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
			while (nextSet && !s.contains(next) && inner.hasNext()) {
				next = inner.next();
			}
			final boolean hasNext = nextSet && s.contains(next);
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
		public E next() {
			if (!nextSet) {
				next = inner.next(); // support null values for next
			} else {
				nextSet = false;
			}
			while (!s.contains(next)) {
				next = inner.next();
			}
			assert !nextSet && s.contains(next);
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
		
	}

	/**
	 * {@link ReadOnlyIterator} that returns elements contained in this underlying collection,
	 * but not in the other underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class SubtractionIterator extends CachingIterator {
	
		protected final Collection<E> s;
		protected E next;
		protected boolean nextSet;
	
		/**
		 * Creates a new {@link SubtractionIterator} on this and <code>s</code>.
		 * @param s the collection to subtract from this
		 */
		public SubtractionIterator(final Collection<E> s) {
			super(dataSource.iterator());
			this.s = s;
		}
	
		/**
		 * {@inheritDoc}
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
			while (nextSet && s.contains(next) && inner.hasNext()) {
				next = inner.next();
			}
			final boolean hasNext = nextSet && !s.contains(next);
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
		public E next() {
			if (!nextSet) {
				next = inner.next(); // support null values for next
			} else {
				nextSet = false;
			}
			while (s.contains(next)) {
				next = inner.next();
			}
			assert !nextSet && !s.contains(next); 
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
		
	}

	/**
	 * {@link Iterator} that returns first the elements of the underlying
	 * collection, then the elements of the other collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class UnionIterator extends WrappedIterator {

		protected final Iterable<E> s;
		protected Iterator<E> added; // lazily instantiate this iterator
		protected boolean innerNext; // cache last inner.hasNext() invocation

		/**
		 * Creates a new {@link UnionIterator} for the underlying
		 * collection and <code>s</code>.
		 * @param s the collection to union with this
		 */
		public UnionIterator(final Iterable<E> s) {
			super();
			this.s = s;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			if (added == null) {
				innerNext = inner.hasNext();
				if (innerNext) {
					return true;
				} else {
					added = s.iterator();
				}
			}
			return added.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() {
			if (added == null) {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					return inner.next();
				} else {
					added = s.iterator();
				}
			}
			return added.next();
		}
	}

	/**
	 * {@link Iterator} that returns first the elements of the underlying
	 * collection, then the elements of the other collection, with all
	 * duplicates removed.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class UnionSetIterator extends CachingSetIterator {

		protected final Iterable<E> s;
		protected Iterator<E> added; // lazily instantiate this iterator
		protected boolean innerNext; // cache last inner.hasNext() invocation

		/**
		 * Creates a new {@link UnionIterator} for the underlying
		 * collection and <code>s</code>.
		 * @param s the collection to union with this
		 */
		public UnionSetIterator(final Iterable<E> s) {
			super();
			this.s = s;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			if (i < cache.size()) {
				return true;
			} else if (dataSource == null) {
				return false;
			}
			if (added == null) {
				innerNext = inner.hasNext();
				if (innerNext) {
					return true; // inner is already a set
				} else {
					added = s.iterator();
					nextSet = false;
				}
			}
			if (!nextSet && added.hasNext()) {
				next = added.next(); // support null values for next
				nextSet = true;
			}
			while (nextSet && returnedValues.contains(next) && added.hasNext()) {
				next = added.next();
			}
			return nextSet && returnedValues.contains(next);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() {
			if (added == null) {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					next = inner.next(); // inner is already a set
					returnedValues.add(next);
					if (++i > cache.size()) {
						assert dataSource != null; // cache not complete
						cache.add(next);
					}
					return next;
				} else {
					added = s.iterator();
					nextSet = false;
				}
			}
			if (!nextSet) {
				next = added.next(); // support null values for next
			} else {
				nextSet = false;
			}
			while (returnedValues.contains(next)) {
				next = added.next();
			}
			assert !nextSet && !returnedValues.contains(next);
			returnedValues.add(next);
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
	}

	/**
	 * Flattens any nested {@link Iterable}s by iterating over their elements
	 * as well.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class FlattenIterator extends ReadOnlyIterator<Object> {

		protected final Iterator<?> inner;
		protected Iterator<?> current;
		protected Object next;
		protected boolean nextSet;

		/**
		 * Creates a new {@link FlattenIterator} around <code>inner</code>.
		 * @param inner the underlying collection
		 */
		public FlattenIterator(final Iterable<?> inner) {
			super();
			this.inner = inner.iterator();
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			if (!nextSet) {
				if (current != null && current.hasNext()) {
					next = current.next();
					nextSet = true;
				} else {
					while (!nextSet && inner.hasNext()) {
						next = inner.next();
						if (next instanceof Iterable<?>) {
							current = ((Iterable<?>)next).iterator();
							if (current.hasNext()) {
								next = current.next();
								nextSet = true;
							}
						} else {
							nextSet = true;
						}
					}
				}
			}
			return nextSet;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object next() {
			if (!nextSet) {
				if (current != null && current.hasNext()) {
					next = current.next();
				} else {
					while (!nextSet) {
						next = inner.next();
						if (next instanceof Iterable<?>) {
							current = ((Iterable<?>)next).iterator();
							if (current.hasNext()) {
								next = current.next();
								nextSet = true;
							}
						} else {
							nextSet = true;
						}
					}
					nextSet = false;
				}
			} else {
				nextSet = false;
			}
			assert !nextSet;
			return next;
		}
	}

	/**
	 * Flattens any nested {@link Iterable}s by iterating over their elements
	 * as well. Removes any duplicates from the returned elements.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class FlattenSetIterator extends ReadOnlyIterator<Object> {
		
		protected final LazyCollection<?>.CachingSetIterator inner;
		protected Iterator<?> current;
		protected Object next;
		protected boolean nextSet;

		/**
		 * Creates a new {@link FlattenSetIterator} around <code>inner</code>.
		 * @param inner the underlying collection
		 */
		public FlattenSetIterator(final LazySet<?> inner) {
			super();
			this.inner = (LazyCollection<?>.CachingSetIterator)inner.iterator();
		}

		/**
		 * Creates a new {@link FlattenSetIterator} around <code>inner</code>.
		 * @param inner the underlying collection
		 */
		public FlattenSetIterator(final LazyOrderedSet<?> inner) {
			super();
			this.inner = (LazyCollection<?>.CachingSetIterator)inner.iterator();
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			while (!nextSet || inner.returnedValues.contains(next)) {
				if (current != null && current.hasNext()) {
					next = current.next();
					nextSet = true;
				} else if (inner.hasNext()) {
					nextSet = false;
					next = inner.next();
					if (next instanceof Iterator<?>) {
						current = (Iterator<?>)next;
						if (current.hasNext()) {
							next = current.next();
							nextSet = true;
						}
					} else {
						nextSet = true;
					}
				}
			}
			return nextSet && !inner.returnedValues.contains(next);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see java.util.Iterator#next()
		 */
		public Object next() {
			while (!nextSet || inner.returnedValues.contains(next)) {
				if (current != null && current.hasNext()) {
					next = current.next();
					nextSet = true;
				} else {
					nextSet = false;
					next = inner.next();
					if (next instanceof Iterator<?>) {
						current = (Iterator<?>)next;
						if (current.hasNext()) {
							next = current.next();
							nextSet = true;
						}
					} else {
						nextSet = true;
					}
				}
				nextSet = true;
			}
			nextSet = false;
			assert !nextSet && !inner.returnedValues.contains(next);
			return next;
		}
	}

	/**
	 * {@link ReadOnlyIterator} that returns the values of the underlying
	 * collection in reverse order.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 */
	public class ReverseIterator extends ReadOnlyIterator<E> {

		protected int index;

		/**
		 * Creates a new {@link ReverseIterator} for the underlying {@link List}.
		 * @param lastIndex the last index in the underlying list. 
		 */
		public ReverseIterator(final int lastIndex) {
			super();
			this.index = lastIndex;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return index >= 0;
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return ((List<E>)dataSource).get(index--);
		}
		
	}

	/**
	 * {@link ReadOnlyIterator} that returns the values of the underlying
	 * collection in reverse order.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 */
	public class ReverseListIterator extends ReadOnlyListIterator<E> {
	
		protected final int lastIndex;
		protected int index;
	
		/**
		 * Creates a new {@link ReverseIterator} for the underlying {@link List}.
		 * @param lastIndex the last index in the underlying list. 
		 */
		public ReverseListIterator(final int lastIndex) {
			super();
			this.index = lastIndex;
			this.lastIndex = lastIndex;
		}
	
		/**
		 * Creates a new {@link ReverseIterator} for the underlying {@link List}.
		 * @param lastIndex the last index in the underlying list. 
		 * @param index the iterator starting index.
		 */
		public ReverseListIterator(final int lastIndex, final int index) {
			super();
			this.lastIndex = lastIndex;
			this.index = index;
			if (0 > index || index > lastIndex) {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return index >= 0;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E next() {
			return ((List<E>)dataSource).get(index--);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public int nextIndex() {
			return lastIndex - index;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public boolean hasPrevious() {
			return index < lastIndex;
		}
	
		/**
		 * {@inheritDoc}
		 */
		public E previous() {
			return ((List<E>)dataSource).get(++index);
		}
	
		/**
		 * {@inheritDoc}
		 */
		public int previousIndex() {
			return lastIndex - index - 1;
		}
		
	}

	/**
	 * {@link ReadOnlyIterator} that filters elements from the underlying
	 * collection by evaluating a condition function on them.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public abstract class FilterIterator extends CachingIterator {

		protected final CodeBlock condition;
		protected final StackFrame parentFrame;
		protected E next;
		protected boolean nextSet;
		protected boolean nextIncluded;

		/**
		 * Creates a {@link FilterIterator} with <code>condition</code>.
		 * @param condition the condition function
		 * @param parentFrame the parent stack frame context
		 */
		public FilterIterator(final CodeBlock condition, final StackFrame parentFrame) {
			super(dataSource.iterator());
			this.condition = condition;
			this.parentFrame = parentFrame;
		}
		
		/**
		 * Checks whether to include <pre>element</pre>.
		 * @param element the element to filter
		 * @return <code>true</code> iff <code>element</code> should be included in this collection
		 */
		protected abstract boolean include(E element);

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			if (i < cache.size()) {
				return true;
			} else if (dataSource == null) {
				return false;
			}
			if (!nextSet && inner.hasNext()) {
				next = inner.next(); // support null values for next
				nextSet = true;
				nextIncluded = include(next);
			}
			while (nextSet && !nextIncluded && inner.hasNext()) {
				next = inner.next();
				nextIncluded = include(next);
			}
			final boolean hasNext = nextSet && nextIncluded;
			if (!hasNext) {
				dataSource = null; // cache complete
				assert i == cache.size();
			}
			return hasNext;
		}

		/**
		 * {@inheritDoc}
		 */
		public E next() {
			if (!nextSet) {
				next = inner.next(); // support null values for next
				nextIncluded = include(next);
			} else {
				nextSet = false;
			}
			while (!nextIncluded) {
				next = inner.next();
				nextIncluded = include(next);
			}
			assert !nextSet && nextIncluded;
			if (++i > cache.size()) {
				assert dataSource != null; // cache not complete
				cache.add(next);
			} else {
				assert cache.contains(next);
			}
			return next;
		}
	}

	/**
	 * {@link FilterIterator} that selects elements from the underlying
	 * collection by evaluation a condition function on them.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class SelectIterator extends FilterIterator {

		/**
		 * Creates a {@link SelectIterator} with <code>condition</code>.
		 * @param condition the condition function
		 * @param parentFrame the parent stack frame context
		 */
		public SelectIterator(final CodeBlock condition, final StackFrame parentFrame) {
			super(condition, parentFrame);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected final boolean include(E element) {
			return (Boolean)condition.execute(parentFrame.getSubFrame(condition, new Object[]{next}));
		}
	}

	/**
	 * {@link FilterIterator} that rejects elements from the underlying
	 * collection by evaluation a condition function on them.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class RejectIterator extends FilterIterator {

		/**
		 * Creates a {@link RejectIterator} with <code>condition</code>.
		 * @param condition the condition function
		 * @param parentFrame the parent stack frame context
		 */
		public RejectIterator(final CodeBlock condition, final StackFrame parentFrame) {
			super(condition, parentFrame);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected final boolean include(E element) {
			return !(Boolean)condition.execute(parentFrame.getSubFrame(condition, new Object[]{next}));
		}
	}

	/**
	 * {@link ReadOnlyIterator} that collects the results of
	 * evaluating a function on each of the elements from the
	 * underlying collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * 
	 * @param <T> the function return type
	 */
	public static class CollectIterator<T> extends ReadOnlyIterator<T> {

		protected final Iterator<?> inner;
		protected final CodeBlock function;
		protected final StackFrame parentFrame;

		/**
		 * Creates a {@link CollectIterator} with <code>condition</code> on <code>inner</code>.
		 * @param inner the underlying collection
		 * @param function the value function
		 * @param parentFrame the parent stack frame context
		 */
		public CollectIterator(final Iterable<?> inner, final CodeBlock function, final StackFrame parentFrame) {
			super();
			this.inner = inner.iterator();
			this.function = function;
			this.parentFrame = parentFrame;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasNext() {
			return inner.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public T next() {
			return (T)function.execute(parentFrame.getSubFrame(function, new Object[]{inner.next()}));
		}
	}

	/**
	 * List {@link #toString()} evaluation cut-off number.
	 */
	private static final int CUT_OFF = 31;

	/**
	 * The inner data source for this collection.
	 * Is set to <code>null</code> when cache is complete.
	 */
	protected Iterable<E> dataSource;

	/**
	 * Element cache.
	 */
	protected Collection<E> cache;

	/**
	 * Cached element occurrence map.
	 */
	protected Map<E, Integer> occurrences;

	/**
	 * Creates a {@link LazyCollection} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyCollection(final Iterable<E> dataSource) {
		super();
		this.dataSource = dataSource;
		createCache();
	}

	/**
	 * Creates an empty {@link LazyCollection}.
	 */
	public LazyCollection() {
		this(null);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/**
	 * Creates the cache collections.
	 */
	protected void createCache() {
		if (dataSource == null) {
			this.cache = Collections.emptyList(); // dataSource == null; cache complete
			this.occurrences = Collections.emptyMap();
		}
	}

	/**
	 * Unsupported.
	 * @param o the element to add
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	public boolean add(final E o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @param c the collection to add
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	public boolean addAll(final Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @throws UnsupportedOperationException
	 */
	public void clear() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Object o) {
		if (cache.contains(o)) {
			return true;
		} else if (dataSource == null) {
			return false;
		}
		if (o == null) {
			for (E e : this) {
				if (e == null) return true;
			}
		} else {
			for (E e : this) {
				if (o.equals(e)) return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean containsAll(final Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if this collection contains any of the elements in the specified collection.
	 * @param c collection to be checked for containment in this collection.
	 * @return <code>true</code> if this collection contains any of the elements in the specified collection.
	 */
	public boolean containsAny(final Collection<?> c) {
		for (Object o : c) {
			if (contains(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		if (dataSource == null) {
			return cache.isEmpty();
		}
		return cache.isEmpty() && !iterator().hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return cache.iterator();
		}
		return new CachingIterator(dataSource.iterator());
	}

	/**
	 * Unsupported.
	 * @param o the element to remove
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	public boolean remove(final Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @param c the collection to remove
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	public boolean removeAll(final Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @param c the collection to retain
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	public boolean retainAll(final Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		if (dataSource == null) {
			return cache.size();
		}
		int size = 0;
		final Iterator<E> i = iterator();
		while (i.hasNext()) {
			i.next();
			size++;
		}
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] toArray() {
		final int size = size(); // trigger cache completion (we would need the size anyway for array creation)
		if (dataSource == null) {
			return cache.toArray();
		}
		final Object[] array = new Object[size];
		final Iterator<E> it = iterator();
		for (int i = 0; i < array.length; i++) {
			array[i] = it.next();
		}
		return array;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(final T[] a) {
		final int size = size(); // trigger cache completion (we would need the size anyway for array length checking)
		if (dataSource == null) {
			return cache.toArray(a);
		}
		T[] r = a;
	    if (r.length < size) {
	        r = (T[])java.lang.reflect.Array.
	        		newInstance(r.getClass().getComponentType(), size);
	    }
	    final Iterator<E> it = iterator();
		for (int i = 0; i < size; i++) {
	    	r[i] = (T)it.next();
	    }
	    if (r.length > size) {
	    	r[size] = null;
	    }
	    return r;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		try {
			int index = 0;
			final StringBuffer buf = new StringBuffer();
			buf.append('[');
			for (E e : this) {
				if (index > CUT_OFF) {
					buf.append(", ...");
					break;
				}
				if (index++ > 0) {
					buf.append(", ");
				}
				buf.append(EMFTVMUtil.toPrettyString(e, null));
			}
			buf.append(']');
			return buf.toString();
		} catch (Exception e) {
			final StringBuffer stackTrace = new StringBuffer();
			stackTrace.append(e.toString());
			for (StackTraceElement ste : e.getStackTrace()) {
				stackTrace.append("\n\t");
				stackTrace.append(ste);
			}
			return stackTrace.toString();
		}
	}

	/**
	 * Returns <code>true</code> if <code>object</code> is an element of self, <code>false</code> otherwise.
	 * @param object the object to check for
	 * @return <code>true</code> if <code>object</code> is an element of self, <code>false</code> otherwise.
	 */
	public boolean includes(final E object) {
		return contains(object);
	}

	/**
	 * Returns <code>true</code> if <code>object</code> is not an element of self, <code>false</code> otherwise.
	 * @param object the object to check for
	 * @return <code>true</code> if <code>object</code> is not an element of self, <code>false</code> otherwise.
	 */
	public boolean excludes(final E object) {
		return !contains(object);
	}

	/**
	 * Returns the number of times that <code>object</code> occurs in the collection self.
	 * @param object the object to check for
	 * @return The number of times that <code>object</code> occurs in the collection self.
	 */
	public int count(final E object) {
		if (occurrences == null) {
			occurrences = new HashMap<E, Integer>();
			for (E e : this) {
	        	if (occurrences.containsKey(e)) {
	        		occurrences.put(e, occurrences.get(e) + 1);
	        	} else {
	        		occurrences.put(e, 1);
	        	}
			}
		}
		return occurrences.containsKey(object) ? occurrences.get(object) : 0;
	}

	/**
	 * Does self contain all the elements of <code>c2</code> ?
	 * @param c2 the collection to check
	 * @return <code>true</code> iff self contains all elements of <code>c2</code>.
	 */
	public boolean includesAll(final Collection<E> c2) {
		return containsAll(c2);
	}

	/**
	 * Does self contain none of the elements of <code>c2</code> ?
	 * @param c2 the collection to check
	 * @return <code>true</code> iff self contains no elements of <code>c2</code>.
	 */
	public boolean excludesAll(final Collection<E> c2) {
		return !containsAny(c2);
	}

	/**
	 * Is self not the empty collection?
	 * @return <code>false</code> iff self contains no elements.
	 */
	public boolean notEmpty() {
		return !isEmpty();
	}

	/**
	 * The element with the maximum value of all elements in self.
	 * Elements must be of a type supporting the max operation.
	 * The max operation - supported by the elements - must take one parameter 
	 * of type <code>E</code> and be both associative and commutative.
	 * Integer and Real fulfill this condition.
	 * @return The element with the maximum value of all elements in self.
	 */
	@SuppressWarnings("unchecked")
	public E max() {
		Number max = 0;
		boolean maxSet = false;
		for (E e : this) {
			if (e instanceof Integer) {
				max = maxSet ? Math.max(max.intValue(), (Integer)e) : (Integer)e;
				maxSet = true;
			} else if (e instanceof Long) {
				max = maxSet ? Math.max(max.longValue(), (Long)e) : (Long)e;
				maxSet = true;
			} else if (e instanceof Float) {
				max = maxSet ? Math.max(max.floatValue(), (Float)e) : (Float)e;
				maxSet = true;
			} else if (e instanceof Double) {
				max = maxSet ? Math.max(max.doubleValue(), (Double)e) : (Double)e;
				maxSet = true;
			} else {
				throw new IllegalArgumentException(String.format(
						"Cannot calculate max on %s", e));
			}
		}
		if (!maxSet) {
			throw new IllegalArgumentException("Cannot calculate the maximum of an empty collection");
		}
		return (E)max;
	}

	/**
	 * The element with the minimum value of all elements in self.
	 * Elements must be of a type supporting the min operation.
	 * The min operation - supported by the elements - must take one parameter 
	 * of type T and be both associative and commutative. 
	 * Integer and Real fulfill this condition.
	 * @return The element with the minimum value of all elements in self.
	 */
	@SuppressWarnings("unchecked")
	public E min() {
		Number min = 0;
		boolean minSet = false;
		for (E e : this) {
			if (e instanceof Integer) {
				min = minSet ? Math.min(min.intValue(), (Integer)e) : (Integer)e;
				minSet = true;
			} else if (e instanceof Long) {
				min = minSet ? Math.min(min.longValue(), (Long)e) : (Long)e;
				minSet = true;
			} else if (e instanceof Float) {
				min = minSet ? Math.min(min.floatValue(), (Float)e) : (Float)e;
				minSet = true;
			} else if (e instanceof Double) {
				min = minSet ? Math.min(min.doubleValue(), (Double)e) : (Double)e;
				minSet = true;
			} else {
				throw new IllegalArgumentException(String.format(
						"Cannot calculate min on %s", e));
			}
		}
		if (!minSet) {
			throw new IllegalArgumentException("Cannot calculate the minimum of an empty collection");
		}
		return (E)min;
	}

	/**
	 * The addition of all elements in self.
	 * Elements must be of a type supporting the + operation.
	 * The + operation must take one parameter of type <code>E</code> and be both associative: (a+b)+c = a+(b+c),
	 * and commutative: a+b = b+a. Integer and Real fulfill this condition.
	 * @return <code>self-&gt;iterate( elem; acc : E = 0 | acc + elem )</code>
	 */
	@SuppressWarnings("unchecked")
	public E sum() {
		Number sum = 0;
		for (E e : this) {
			if (e instanceof Integer) {
				sum = sum.intValue() + (Integer)e;
			} else if (e instanceof Long) {
				sum = sum.longValue() + (Long)e;
			} else if (e instanceof Float) {
				sum = sum.floatValue() + (Float)e;
			} else if (e instanceof Double) {
				sum = sum.longValue() + (Double)e;
			} else {
				throw new IllegalArgumentException(String.format(
						"Cannot calculate sum on %s", e));
			}
		}
		return (E)sum;
	}

	/* *********************************************************************
	 * Lazy operations                                                     *
	 * *********************************************************************/

	/**
	 * The cartesian product operation of <code>self</code> and <code>c2</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param <T> the element type
	 * @param c2 the other factor in the cartesian product
	 * @return <code>self->iterate (e1; acc: Set(Tuple(first: T, second: T2)) = Set{} |<br>
	 * c2->iterate (e2; acc2: Set(Tuple(first: T, second: T2)) = acc | <br>
	 * acc2->including (Tuple{first = e1, second = e2}) ) )</code>
	 */
	public <T> LazySet<Tuple> product(final Iterable<T> c2) {
		final Iterable<E> c1 = this;
		return new LazySet<Tuple>(new Iterable<Tuple>() {
			public Iterator<Tuple> iterator() {
				return new ReadOnlyIterator<Tuple>() {
					final Iterator<E> c1it = c1.iterator();
					E lastc1;
					boolean lastc1Set;
					Iterator<T> c2it = c2.iterator();
					
					public Tuple next() {
						if (!lastc1Set) {
							lastc1 = c1it.next(); // support null values for lastc1
							lastc1Set = true;
						}
						final T lastc2;
						if (c2it.hasNext()) {
							lastc2 = c2it.next();
						} else {
							lastc1 = c1it.next();
							c2it = c2.iterator();
							lastc2 = c2it.next();
						}
						final Map<String, Object> tupleValues = new HashMap<String, Object>(2);
						tupleValues.put("first", lastc1);
						tupleValues.put("second", lastc2);
						return new Tuple(tupleValues);
					}
					
					public boolean hasNext() {
						if (c2it.hasNext()) {
							return true;
						} else if (c1it.hasNext()) {
							lastc1 = c1it.next();
							c2it = c2.iterator();
							return c2it.hasNext();
						} else {
							return false;
						}
					}
				};
			}
		});
	}

	/**
	 * Returns the Bag containing all the elements from self, including duplicates. 
	 * <p><i>Lazy operation.</i></p>
	 * @return The Bag containing all the elements from self, including duplicates.
	 */
	public LazyBag<E> asBag() {
		return new LazyBag<E>(this);
	}

	/**
	 * Returns a Sequence that contains all the elements from self, in undefined order. 
	 * <p><i>Lazy operation.</i></p>
	 * @return A Sequence that contains all the elements from self, in undefined order.
	 */
	public LazyList<E> asSequence() {
		return new LazyList<E>(this);
	}

	/**
	 * Returns the Set containing all the elements from self, with duplicated removed.
	 * <p><i>Lazy operation.</i></p>
	 * @return The Set containing all the elements from self, with duplicated removed.
	 */
	public LazySet<E> asSet() {
		return new LazySet<E>(this);
	}

	/**
	 * Returns an OrderedSet that contains all the elements from self, in undefined order, with duplicates removed.
	 * <p><i>Lazy operation.</i></p>
	 * @return An OrderedSet that contains all the elements from self, in undefined order, with duplicates removed.
	 */
	public LazyOrderedSet<E> asOrderedSet() {
		return new LazyOrderedSet<E>(this);
	}

	/**
	 * Returns the collection containing all elements of self plus <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to include
	 * @return The collection containing all elements of self plus <code>object</code>.
	 */
	public abstract LazyCollection<E> including(final E object);

	/* *********************************************************************
	 * Higher-order operations                                             *
	 * *********************************************************************/

	/**
	 * Checks if <code>condition</code> holds for
	 * all elements in the underlying collection.
	 * @param condition the condition function
	 * @return <code>true</code> iff <code>condition</code> holds for
	 * all elements in the underlying collection.
	 */
	public boolean forAll(final CodeBlock condition) {
		final StackFrame frame = condition.getParentFrame();
		for (E e : this) {
			if (!(Boolean)condition.execute(frame.getSubFrame(condition, new Object[]{e}))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if <code>condition</code> holds for
	 * all element pairs in the cartesian product of the underlying collection.
	 * @param condition the condition function
	 * @return <code>true</code> iff <code>condition</code> holds for
	 * all element pairs in the cartesian product of the underlying collection.
	 */
	public boolean forAll2(final CodeBlock condition) {
		final StackFrame frame = condition.getParentFrame();
		for (E e : this) {
			for (E e2 : this) {
				if (!(Boolean)condition.execute(frame.getSubFrame(condition, new Object[]{e, e2}))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if <code>condition</code> holds for 
	 * at least one element in the underlying collection.
	 * @param condition the condition function
	 * @return <code>true</code> iff <code>condition</code> holds for 
	 * at least one element in the underlying collection.
	 */
	public boolean exists(final CodeBlock condition) {
		final StackFrame frame = condition.getParentFrame();
		for (E e : this) {
			if ((Boolean)condition.execute(frame.getSubFrame(condition, new Object[]{e}))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if <code>condition</code> holds for 
	 * at least one element pair in the cartesian product of the underlying collection.
	 * @param condition the condition function
	 * @return <code>true</code> iff <code>condition</code> holds for 
	 * at least one element pair in the cartesian product of the underlying collection.
	 */
	public boolean exists2(final CodeBlock condition) {
		final StackFrame frame = condition.getParentFrame();
		for (E e : this) {
			for (E e2 : this) {
				if ((Boolean)condition.execute(frame.getSubFrame(condition, new Object[]{e, e2}))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Builds an accumulated value by calling the
	 * <code>updater</code> function for each element in the underlying collection
	 * and the previous accumulated value.
	 * @param <T> the element type
	 * @param initialValue the initial accumulated value
	 * @param updater the updater function
	 * @return The accumulated value
	 */
	@SuppressWarnings("unchecked")
	public <T> T iterate(final T initialValue, final CodeBlock updater) {
		final StackFrame frame = updater.getParentFrame();
		T acc = initialValue;
		for (E e : this) {
			acc = (T)updater.execute(frame.getSubFrame(updater, new Object[]{e, acc}));
		}
		return acc;
	}
	
	/**
	 * Results in <code>true</code> if <code>body</code> evaluates to a different value for each 
	 * element in the source collection; otherwise, result is <code>false</code>.
	 * @param body the code to execute on each element
	 * @return <code>true</code> if <code>body</code> evaluates to a different value for each 
	 * element in the source collection.
	 */
	public boolean isUnique(final CodeBlock body) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = body.getParentFrame();
		final Set<Object> values = new HashSet<Object>(size());
		for (E e : this) {
			Object value = body.execute(parentFrame.getSubFrame(body, new Object[]{e}));
			if (values.contains(value)) {
				return false;
			}
			values.add(value);
		}
		return true;
	}
	
	/**
	 * Returns any element in the source collection for which <code>body</code> evaluates to <code>true</code>.
	 * If there is more than one element for which <code>body</code> is <code>true</code>, one of them is returned.
	 * There must be at least one element fulfilling <code>body</code>.
	 * @param body the function to evaluate on each element
	 * @return any element in the source collection for which body evaluates to <code>true</code>.
	 * @throws NoSuchElementException if there is no element in the source collection for which <code>body</code> is <code>true</code>.
	 */
	public E any(final CodeBlock body) throws NoSuchElementException {
		final StackFrame parentFrame = body.getParentFrame();
		for (E e : this) {
			if ((Boolean)body.execute(parentFrame.getSubFrame(body, new Object[]{e}))) {
				return e;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Results in <code>true</code> if there is exactly one element in the 
	 * source collection for which <code>body</code> is <code>true</code>.
	 * @param body the function to evaluate on each element
	 * @return <code>true</code> if there is exactly one element in the 
	 * source collection for which <code>body</code> is <code>true</code>.
	 */
	public boolean one(final CodeBlock body) {
		boolean result = false;
		final StackFrame frame = body.getParentFrame();
		for (E e : this) {
			if ((Boolean)body.execute(frame.getSubFrame(body, new Object[]{e}))) {
				if (result) { // only one true value allowed
					return false;
				}
				result = true;
			}
		}
		return result;
	}

}