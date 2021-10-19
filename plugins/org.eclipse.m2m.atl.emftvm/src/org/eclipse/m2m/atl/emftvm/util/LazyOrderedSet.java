/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.util.LazyList.LongRangeList;

/**
 * Immutable {@link Set} and {@link List} that supports lazy evaluation.
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazyOrderedSet<E> extends LazyCollection<E> implements Set<E>, List<E> {

	/**
	 * {@link LazyOrderedSet} that disables caching of the underlying {@link LazyOrderedSet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public abstract static class NonCachingOrderedSet<E> extends LazyOrderedSet<E> {

		/**
		 * Creates a {@link NonCachingOrderedSet} around <code>dataSource</code>.
		 * @param dataSource the underlying collection
		 */
		public NonCachingOrderedSet(final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			assert dataSource != null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createCache() {
			//no caching
		}
	}

	/**
	 * {@link LazyOrderedSet} that represents a sub-range of the underlying
	 * {@link LazyOrderedSet}.
	 * Index starts at 0.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class SubOrderedSet<E> extends NonCachingOrderedSet<E> {

		protected final int fromIndex;
		protected final int toIndex;

		/**
		 * Creates a new {@link SubOrderedSet}.
		 * @param fromIndex the starting index, inclusive
		 * @param toIndex the ending index, exclusive
		 * @param dataSource the underlying collection
		 */
		public SubOrderedSet(final int fromIndex, final int toIndex, final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;
			if (0 > fromIndex || fromIndex > toIndex) {
				throw new IndexOutOfBoundsException(String.valueOf(fromIndex) + " - " +
						String.valueOf(toIndex));
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E first() {
			return ((List<E>)dataSource).get(fromIndex);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			return ((List<E>)dataSource).get(toIndex - 1);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			return ((List<E>)dataSource).get(index + fromIndex);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>)dataSource).indexOf(o);
			if (index >= fromIndex && index < toIndex) {
				return index - fromIndex;
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			final int index = ((List<E>)dataSource).indexOf(o);
			return index >= fromIndex && index < toIndex;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return fromIndex >= toIndex;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new SubListIterator(fromIndex, toIndex);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return toIndex - fromIndex;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new SubListListIterator(fromIndex, toIndex);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new SubListListIterator(fromIndex, toIndex, index);
		}

	}

	/**
	 * {@link LazyOrderedSet} that appends an element to the underlying
	 * {@link LazyOrderedSet}, except when it already occurs in the underlying
	 * {@link LazyOrderedSet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class AppendOrderedSet<E> extends NonCachingOrderedSet<E> {

		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class AppendOrderedSetIterator extends WrappedIterator {

			protected boolean beforeTail = true;
			protected boolean innerNext; // cache last inner.hasNext() invocation

			/**
			 * Creates a new {@link AppendOrderedSetIterator}.
			 */
			public AppendOrderedSetIterator() {
				super();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				return (beforeTail && !containsObject) || (innerNext = inner.hasNext());
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					return inner.next();
				} else if (beforeTail) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						beforeTail = false;
						return object;
					}
				}
				throw new NoSuchElementException();
			}
		}

		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class AppendOrderedSetListIterator extends WrappedListIterator {

			protected boolean beforeTail = true;
			protected boolean innerNext; // cache last inner.hasNext() invocation

			/**
			 * Creates a new {@link AppendOrderedSetListIterator}.
			 */
			public AppendOrderedSetListIterator() {
				super();
			}

			/**
			 * Creates a new {@link AppendOrderedSetListIterator}.
			 * @param index the iterator starting index.
			 */
			public AppendOrderedSetListIterator(final int index) {
				super(index > 0 ? index - 1 : index);
				if (index > 0) {
					next();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				return (beforeTail && !containsObject) || (innerNext = inner.hasNext());
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					return inner.next();
				} else if (beforeTail) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						beforeTail = false;
						return object;
					}
				}
				throw new NoSuchElementException();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return inner.nextIndex() + (beforeTail ? 0 : 1);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return !beforeTail || inner.hasPrevious();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				if (!beforeTail) {
					beforeTail = true;
					return object;
				}
				return inner.previous();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return inner.previousIndex() + (beforeTail ? 0 : 1);
			}

		}

		protected final E object;
		protected boolean containsObject;
		protected boolean containsObjectSet;

		/**
		 * Creates a new {@link AppendOrderedSet}.
		 * @param object the element to append
		 * @param dataSource the underlying collection
		 */
		public AppendOrderedSet(final E object, final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.object = object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			return (object == null ? o == null : object.equals(o)) ||
					((Collection<E>)dataSource).contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(final Object o) {
			return (object == null ? o == null : object.equals(o)) ? 1 :
				((LazyCollection<E>)dataSource).count(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new AppendOrderedSetIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>)dataSource).size();
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			return size + (containsObject ? 0 : 1);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			return ((List<E>)dataSource).get(size() - 1);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			final int size = ((Collection<E>)dataSource).size();
			if (index < size) {
				return ((List<E>)dataSource).get(index);
			}
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (index == size && !containsObject) {
				return object;
			}
			throw new NoSuchElementException();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>)dataSource).indexOf(o);
			if (index >= 0) {
				return index;
			}
			assert index == -1;
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject && (object == null ? o == null : object.equals(o))) {
				return ((Collection<E>)dataSource).size();
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new AppendOrderedSetListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new AppendOrderedSetListIterator(index);
		}

	}

	/**
	 * {@link LazyOrderedSet} that prepends an element to the underlying
	 * {@link LazyOrderedSet}, except when it already occurs in the underlying
	 * {@link LazyOrderedSet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class PrependOrderedSet<E> extends AppendOrderedSet<E> {

		/**
		 * {@link Iterator} that prepends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class PrependOrderedSetIterator extends WrappedIterator {

			protected boolean beforeHead;

			/**
			 * Creates a new {@link PrependOrderedSetIterator}.
			 */
			public PrependOrderedSetIterator() {
				super();
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				beforeHead = !containsObject;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				return beforeHead || inner.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				if (beforeHead) {
					beforeHead = false;
					return object;
				}
				return inner.next();
			}
		}

		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class PrependOrderedSetListIterator extends WrappedListIterator {

			protected boolean beforeHead;
			protected boolean innerPrev; // cache value of inner.hasPrevious()

			/**
			 * Creates a new {@link PrependOrderedSetListIterator}.
			 */
			public PrependOrderedSetListIterator() {
				super();
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				this.beforeHead = !containsObject;
			}

			/**
			 * Creates a new {@link PrependOrderedSetListIterator}.
			 * @param index the iterator starting index.
			 */
			public PrependOrderedSetListIterator(final int index) {
				super(index > 0 ? index - 1 : index);
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				this.beforeHead = !containsObject && index == 0;
				if (index > 0) {
					next();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				return beforeHead || inner.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				if (beforeHead) {
					beforeHead = false;
					return object;
				}
				return inner.next();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				if (beforeHead) {
					return 0;
				}
				return inner.nextIndex() + (containsObject ? 0 : 1);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				assert beforeHead || !inner.hasPrevious(); // not beforeHead implies not inner.hasPrevious()
				return !beforeHead && (!containsObject || (innerPrev = inner.hasPrevious()));
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				assert containsObjectSet;
				if (innerPrev || inner.hasPrevious()) {
					innerPrev = false;
					return inner.previous();
				} else if (!beforeHead) {
					if (!containsObject) {
						beforeHead = true;
						return object;
					}
				}
				throw new NoSuchElementException();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				if (beforeHead) {
					return -1;
				}
				return inner.previousIndex() + (containsObject ? 0 : 1);
			}

		}

		/**
		 * Creates a new {@link PrependOrderedSet}.
		 * @param object the object to prepend
		 * @param dataSource the underlying collection
		 */
		public PrependOrderedSet(final E object, final LazyOrderedSet<E> dataSource) {
			super(object, dataSource);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new PrependOrderedSetIterator();
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#first()
		 */
		@Override
		public E first() {
			return ((List<E>)dataSource).get(size() - 1);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			if (!((LazyOrderedSet<E>)dataSource).isEmpty()) {
				return ((LazyOrderedSet<E>)dataSource).last();
			}
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject) {
				return object;
			}
			throw new NoSuchElementException();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject) {
				if (index == 0) {
					return object;
				} else {
					return ((List<E>)dataSource).get(index - 1);
				}
			} else {
				return ((List<E>)dataSource).get(index);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (containsObject) {
				return ((List<E>)dataSource).indexOf(o);
			}
			if (object == null ? o == null : object.equals(o)) {
				return 0;
			}
			final int index = ((List<E>)dataSource).indexOf(o);
			return (index > -1) ? index + 1 : -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new PrependOrderedSetListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new PrependOrderedSetListIterator(index);
		}

	}

	/**
	 * {@link LazyOrderedSet} that inserts an object into the underlying
	 * {@link LazyOrderedSet}, except when it already occurs in the underlying
	 * {@link LazyOrderedSet}.
	 * List index starts at 0.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class InsertAtOrderedSet<E> extends AppendOrderedSet<E> {

		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * List index starts at 0.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class InsertAtOrderedSetIterator extends WrappedIterator {

			protected int i = -1;

			/**
			 * Creates a new {@link InsertAtOrderedSetIterator}.
			 */
			public InsertAtOrderedSetIterator() {
				super();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				// next() will throw exception when index is out of bounds
				return i < index || inner.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (++i == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
				}
				return inner.next();
			}
		}

		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class InsertAtOrderedSetListIterator extends WrappedListIterator {

			protected int i = -1;
			protected boolean innerNext; // cache last inner.hasNext() invocation

			/**
			 * Creates a new {@link InsertAtOrderedSetListIterator}.
			 */
			public InsertAtOrderedSetListIterator() {
				super();
			}

			/**
			 * Creates a new {@link InsertAtOrderedSetListIterator}.
			 * @param index the iterator starting index.
			 */
			public InsertAtOrderedSetListIterator(final int index) {
				super(index > 0 ? index - 1 : index);
				assert index >= 0;
				if (index > 0) {
					this.i = index - 2;
					next();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				// next() will throw exception when index is out of bounds
				return i < index || inner.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (++i == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
				}
				return inner.next();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				return i + 1;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				// previous() will throw exception when index is out of bounds
				return i >= index || inner.hasPrevious();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				if (i-- == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
				}
				return inner.previous();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				return i;
			}

		}

		protected final int index;

		/**
		 * Creates a new {@link InsertAtOrderedSet}.
		 * @param object the object to insert
		 * @param index the insertion index
		 * @param dataSource the underlying collection
		 */
		public InsertAtOrderedSet(final E object, final int index, final LazyOrderedSet<E> dataSource) {
			super(object, dataSource);
			this.index = index;
			if (index < 0) {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new InsertAtOrderedSetIterator();
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#first()
		 */
		@Override
		public E first() {
			assert index >= 0;
			if (index == 0) {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				if (!containsObject) {
					return object;
				}
			}
			return ((LazyList<E>)dataSource).first();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			final int size = ((Collection<E>)dataSource).size();
			if (index < size) {
				return ((LazyList<E>)dataSource).last();
			} else if (index == size) {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				if (!containsObject) {
					return object;
				}
				return ((LazyList<E>)dataSource).last();
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			final int size = ((List<E>)dataSource).size();
			if (index <= size) {
				if (index < this.index) {
					return ((List<E>)dataSource).get(index);
				} else if (index == this.index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
					return ((List<E>)dataSource).get(index);
				}
				assert this.index >= 0;
				assert index > this.index;
				if (!containsObjectSet) {
					containsObject = ((Collection<E>)dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				return ((List<E>)dataSource).get(containsObject ? index : index - 1);
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			final int indexOf = ((List<E>)dataSource).indexOf(o);
			if (indexOf > -1) {
				assert index >= 0;
				if (indexOf > index && (object == null ? o == null : object.equals(o))) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return index;
					}
				}
				return indexOf;
			}
			if (!containsObjectSet) {
				containsObject = ((Collection<E>)dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject && (object == null ? o == null : object.equals(o))) {
				if (index <= ((Collection<E>)dataSource).size()) {
					return index;
				}
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new InsertAtOrderedSetListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new InsertAtOrderedSetListIterator(index);
		}

	}

	/**
	 * {@link LazyOrderedSet} that excludes an element from the underlying
	 * {@link LazyOrderedSet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class ExcludingOrderedSet<E> extends NonCachingOrderedSet<E> {

		/**
		 * {@link Iterator} that excludes a given object.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class ExcludingOrderedSetIterator extends WrappedIterator {

			protected int i = -1;
			protected E next;
			protected boolean nextSet;

			/**
			 * Creates a new {@link ExcludingOrderedSetIterator}.
			 */
			public ExcludingOrderedSetIterator() {
				super();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				if (nextSet && (object == null ? next == null : object.equals(next))) {
					excludedIndex = i + 1;
					excludedIndexSet = true;
					if (inner.hasNext()) {
						next = inner.next();
						assert !(object == null ? next == null : object.equals(next));
					}
				}
				final boolean hasNext = nextSet && !(object == null ? next == null : object.equals(next));
				if (!hasNext && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasNext;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				i++;
				if (!nextSet) {
					next = inner.next();
				} else {
					nextSet = false;
				}
				if (object == null ? next == null : object.equals(next)) {
					excludedIndex = i;
					excludedIndexSet = true;
					next = inner.next();
				}
				assert !nextSet && !(object == null ? next == null : object.equals(next));
				return next;
			}
		}

		/**
		 * {@link ListIterator} that excludes a given object.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class ExcludingOrderedSetListIterator extends WrappedListIterator {

			protected int i = -1;
			protected E next;
			protected boolean nextSet;
			protected E prev;
			protected boolean prevSet;

			/**
			 * Creates a new {@link ExcludingIterator}.
			 */
			public ExcludingOrderedSetListIterator() {
				super();
			}

			/**
			 * Creates a new {@link ExcludingIterator}.
			 * @param index the iterator starting index.
			 */
			public ExcludingOrderedSetListIterator(final int index) {
				super(index > 0 ? index - 1 : index);
				if (index > 0) {
					this.i = index - 2;
					next();
				} else {
					this.i = index - 1;
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				if (nextSet && (object == null ? next == null : object.equals(next))) {
					excludedIndex = i + 1;
					excludedIndexSet = true;
					if (inner.hasNext()) {
						next = inner.next();
						assert !(object == null ? next == null : object.equals(next));
					}
				}
				final boolean hasNext = nextSet && !(object == null ? next == null : object.equals(next));
				if (!hasNext && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasNext;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				i++;
				if (!nextSet) {
					next = inner.next();
				} else {
					nextSet = false;
				}
				if (object == null ? next == null : object.equals(next)) {
					excludedIndex = i;
					excludedIndexSet = true;
					next = inner.next();
				}
				assert !nextSet && !(object == null ? next == null : object.equals(next));
				return next;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				return i + 1;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				if (!prevSet && inner.hasPrevious()) {
					prev = inner.previous(); // support null values for next
					prevSet = true;
				}
				if (prevSet && (object == null ? prev == null : object.equals(prev))) {
					excludedIndex = i;
					excludedIndexSet = true;
					if (inner.hasPrevious()) {
						prev = inner.previous();
						assert !(object == null ? prev == null : object.equals(prev));
					}
				}
				final boolean hasPrev = prevSet && !(object == null ? prev == null : object.equals(prev));
				if (!hasPrev && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasPrev;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				if (!prevSet) {
					prev = inner.previous();
				} else {
					prevSet = false;
				}
				if (object == null ? prev == null : object.equals(prev)) {
					excludedIndex = i;
					excludedIndexSet = true;
					prev = inner.previous();
				}
				assert !prevSet && !(object == null ? prev == null : object.equals(prev));
				i--;
				return prev;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				return i;
			}
		}

		protected final Object object;
		protected int excludedIndex;
		protected boolean excludedIndexSet;

		/**
		 * Creates a new {@link ExcludingOrderedSet}.
		 * @param object the object to exclude
		 * @param dataSource the underlying collection
		 */
		public ExcludingOrderedSet(final Object object, final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.object = object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			return !(object == null ? o == null : object.equals(o)) &&
					((Collection<E>)dataSource).contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(final Object o) {
			return (object == null ? o == null : object.equals(o)) ? 0 :
				((LazyCollection<E>)dataSource).count(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return !iterator().hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((Collection<E>)dataSource).iterator();
			}
			return new ExcludingOrderedSetIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>)dataSource).size();
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>)dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			return size - (excludedIndex > -1 ? 1 : 0);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E first() {
			return iterator().next();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>)dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			final int size = ((Collection<E>)dataSource).size();
			return ((List<E>)dataSource).get(size - (excludedIndex == size - 1 ? 2 : 1));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>)dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			if (index < excludedIndex || excludedIndex < 0) {
				return ((List<E>)dataSource).get(index);
			}
			assert excludedIndex >= 0;
			return ((List<E>)dataSource).get(index + 1);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			if (object == null ? o == null : object.equals(o)) {
				return -1;
			}
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>)dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			final int index = ((List<E>)dataSource).indexOf(o);
			if (index < excludedIndex || excludedIndex < 0) {
				return index;
			}
			assert excludedIndex >= 0;
			return (index > -1) ? index - 1 : -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((List<E>)dataSource).listIterator();
			}
			return new ExcludingOrderedSetListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((List<E>)dataSource).listIterator(index);
			}
			return new ExcludingOrderedSetListIterator(index);
		}

	}

	/**
	 * {@link LazyOrderedSet} in reverse order.
	 */
	public static class ReverseOrderedSet<E> extends NonCachingOrderedSet<E> {

		protected final int last;

		/**
		 * Creates a new {@link ReverseOrderedSet}.
		 * @param dataSource the underlying collection
		 */
		public ReverseOrderedSet(final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.last = dataSource.size() - 1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E first() {
			return ((List<E>)dataSource).get(last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			return ((List<E>)dataSource).get(0);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			return ((List<E>)dataSource).get(last - index);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>)dataSource).indexOf(o);
			if (index > -1) {
				return last - index;
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(final Object o) {
			final int index = ((List<E>)dataSource).lastIndexOf(o);
			if (index > -1) {
				return last - index;
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			return ((List<E>)dataSource).contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return ((List<E>)dataSource).isEmpty();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new ReverseIterator(last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return last + 1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new ReverseListIterator(last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new ReverseListIterator(last, index);
		}

	}

	/**
	 * {@link LazyOrderedSet} that represents a range running from a first to last {@link Integer}.
	 *
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class IntegerRangeOrderedSet extends LazyOrderedSet<Integer> {

		protected final int first;
		protected final int last;

		/**
		 * Creates a new {@link IntegerRangeOrderedSet}.
		 *
		 * @param first
		 *            the first object of the range to include
		 * @param last
		 *            the last object of the range to include
		 */
		public IntegerRangeOrderedSet(final int first, final int last) {
			super();
			if (first > last) {
				throw new IllegalArgumentException(String.format("The first element of a range (%d) cannot be greater than the last (%d)",
						first, last));
			}
			this.first = first;
			this.last = last;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createCache() {
			// no caching
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Integer first() {
			return first;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Integer get(final int index) {
			final int element = first + index;
			if (element > last) {
				throw new IndexOutOfBoundsException(Integer.toString(index));
			}
			return element;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			if (contains(o)) {
				return (Integer) o - first;
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Integer last() {
			return last;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(final Object o) {
			// All elements of a range are unique
			return indexOf(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<Integer> listIterator() {
			return new IntegerRangeListIterator(first, last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<Integer> listIterator(final int index) {
			return new IntegerRangeListIterator(first, last, index);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			if (o instanceof Integer) {
				final Integer obj = (Integer) o;
				return (obj >= first && obj <= last);
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(final Object object) {
			// All elements of a range are unique
			return contains(object) ? 1 : 0;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			// Empty ranges are not allowed
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<Integer> iterator() {
			return new IntegerRangeListIterator(first, last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return last - first + 1;
		}

	}

	/**
	 * {@link LazyOrderedSet} that represents a range running from a first to last {@link Long}.
	 *
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class LongRangeOrderedSet extends LazyOrderedSet<Long> {

		protected final long first;
		protected final long last;

		/**
		 * Creates a new {@link LongRangeList}.
		 *
		 * @param first
		 *            the first object of the range to include
		 * @param last
		 *            the last object of the range to include
		 */
		public LongRangeOrderedSet(final long first, final long last) {
			super();
			if (first > last) {
				throw new IllegalArgumentException(String.format("The first element of a range (%d) cannot be greater than the last (%d)",
						first, last));
			}
			this.first = first;
			this.last = last;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createCache() {
			// no caching
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Long first() {
			return first;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Long get(final int index) {
			final long element = first + index;
			if (element > last) {
				throw new IndexOutOfBoundsException(Integer.toString(index));
			}
			return element;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			if (contains(o)) {
				return (int) ((Long) o - first);
			}
			return -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Long last() {
			return last;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(final Object o) {
			// All elements of a range are unique
			return indexOf(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<Long> listIterator() {
			return new LongRangeListIterator(first, last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<Long> listIterator(final int index) {
			return new LongRangeListIterator(first, last, index);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(final Object o) {
			if (o instanceof Integer) {
				final Integer obj = (Integer) o;
				return (obj >= first && obj <= last);
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(final Object object) {
			// All elements of a range are unique
			return contains(object) ? 1 : 0;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			// Empty ranges are not allowed
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<Long> iterator() {
			return new LongRangeListIterator(first, last);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return (int) (last - first + 1);
		}

	}

	/**
	 * Creates an empty {@link LazyOrderedSet}.
	 */
	public LazyOrderedSet() {
		super();
	}

	/**
	 * Creates a {@link LazyOrderedSet} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyOrderedSet(final Iterable<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createCache() {
		super.createCache();
		if (this.cache == null) {
			this.cache = new ArrayList<E>();
		}
		assert this.cache instanceof List<?>;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return cache.iterator();
		}
		return new CachingSetIterator();
	}

	/**
	 * Unsupported.
	 * @param index the index at which to add
	 * @param element the object to add
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void add(final int index, final E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @param index the index at which to add
	 * @param c the collection to add
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	@Override
	public boolean addAll(final int index, final Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(final int index) {
		if (index < cache.size()) {
			return ((List<E>)cache).get(index);
		}
		int i = 0;
		for (final E e : this) {
			if (i == index) {
				return e;
			}
			i++;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(final Object o) {
		final int index = ((List<E>)cache).indexOf(o);
		if (index > -1 || dataSource == null) { // cache complete
			return index;
		}
		int i = 0;
		for (final E e : this) {
			if (e == o) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(final Object o) {
		return indexOf(o); // elements occur only once
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator() {
		if (dataSource == null) { // cache complete
			return Collections.unmodifiableList((List<E>)cache).listIterator();
		}
		return new IteratorToListIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator(final int index) {
		if (dataSource == null) { // cache complete
			return Collections.unmodifiableList((List<E>)cache).listIterator(index);
		}
		return new IteratorToListIterator(index);
	}

	/**
	 * Unsupported.
	 * @param index the index at which to remove
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	@Override
	public E remove(final int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported.
	 * @param index the index at which to set
	 * @param element the element to set
	 * @return nothing
	 * @throws UnsupportedOperationException
	 */
	@Override
	public E set(final int index, final E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><i>Lazy implementation of {@link List#subList(int, int)}.</i></p>
	 * {@inheritDoc}
	 */
	@Override
	public LazyOrderedSet<E> subList(final int fromIndex, final int toIndex) {
		return new SubOrderedSet<E>(fromIndex, toIndex, this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof List<?> && o instanceof Set<?>)) {
			return false;
		}
		final Iterator<E> e1 = iterator();
		final Iterator<?> e2 = ((Collection<?>)o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
			final E o1 = e1.next();
			final Object o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		// List hashcode (shifted)
		int hashCode = 1;
		for (final E obj : this) {
			hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
		}
		// Set hashcode (to distinguish from plain Lists)
		for (final E obj : this) {
			if (obj != null) {
				hashCode += obj.hashCode();
			}
		}
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String asString(final ExecEnv env) {
		return appendElements(new StringBuffer("OrderedSet{"), env).append('}').toString();
	}

	/**
	 * Returns the number of occurrences of <code>object</code> in self.<br>
	 * <code>post: result &lt;= 1</code>
	 *
	 * @param o
	 *            the object to count
	 * @return The number of occurrences of <code>object</code> in self.
	 */
	@Override
	public int count(final Object o) {
		return contains(o) ? 1 : 0;
	}

	/**
	 * Returns the <code>i</code>-th element of this list.
	 * List index starts at 1.
	 * @param i the element index
	 * @return The <code>i</code>-th element of this list.
	 */
	public E at(final int i) {
		return get(i - 1);
	}

	/**
	 * Returns the index of object <code>obj</code> in the sequence.
	 * List index starts at 1.<br>
	 * pre : <code>self->includes(obj)</code><br>
	 * post : <code>self->at(i) = obj</code>
	 * @param obj the object
	 * @return The index of object <code>obj</code> in the sequence.
	 * @throws IndexOutOfBoundsException if <code>obj</code> is not contained in this list.
	 */
	public int indexOf2(final Object obj) throws IndexOutOfBoundsException {
		final int i = indexOf(obj) + 1;
		if (i == 0) {
			throw new IndexOutOfBoundsException();
		}
		return i;
	}

	/**
	 * Returns the last index of object <code>obj</code> in the sequence.
	 * List index starts at 1.<br>
	 * pre : <code>self->includes(obj)</code><br>
	 * post : <code>self->at(i) = obj</code>
	 * @param obj the object
	 * @return The last index of object <code>obj</code> in the sequence.
	 * @throws IndexOutOfBoundsException if <code>obj</code> is not contained in this list.
	 */
	public int lastIndexOf2(final Object obj) throws IndexOutOfBoundsException {
		final int i = lastIndexOf(obj) + 1;
		if (i == 0) {
			throw new IndexOutOfBoundsException();
		}
		return i;
	}

	/**
	 * Returns the first element in self.
	 * @return The first element in self.
	 */
	public E first() {
		if (cache.size() > 0) {
			return ((List<E>)cache).get(0);
		}
		return iterator().next();
	}

	/**
	 * Returns the last element in self.
	 * @return The last element in self.
	 */
	public E last() {
		if (dataSource == null) {
			final int size = cache.size();
			if (size < 1) {
				throw new NoSuchElementException();
			}
			return ((List<E>)cache).get(size - 1);
		}
		boolean lastSet = false;
		E last = null;
		for (final Iterator<E> it = iterator(); it.hasNext();) {
			last = it.next();
			lastSet = true;
		}
		if (!lastSet) {
			throw new NoSuchElementException();
		}
		return last;
	}

	/* *********************************************************************
	 * Lazy operations                                                     *
	 * *********************************************************************/

	/**
	 * Returns the union of self and <code>s</code>,
	 * where elements of self are returned before elements of s.
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to union with self
	 * @return The union of self and <code>s</code>.
	 */
	public LazyOrderedSet<E> union(final LazyOrderedSet<? extends E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new UnionSetIterator(s);
			}
		};
	}

	/**
	 * Returns the ordered set consisting of all elements in self, with all elements in <code>s</code> inserted at <code>index</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param s
	 *            the ordered set to union with this
	 * @param index
	 *            the insertion index (starting at 1)
	 * @return The ordered set consisting of all elements in self, with all elements in <code>s</code> inserted at <code>index</code>
	 */
	public LazyOrderedSet<E> union(final LazyOrderedSet<? extends E> s, final int index) {
		if (index == 1) {
			return union(s);
		}
		return subSequence(1, index - 1).union(s).union(subSequence(index, size()));
	}

	/**
	 * Returns the union of self and <code>s</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param s
	 *            the collection to union with self
	 * @return The union of self and <code>s</code>.
	 */
	public LazySet<E> union(final LazySet<E> s) {
		return new LazySet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new UnionSetIterator(s);
			}
		};
	}

	/**
	 * Returns the union of self and <code>bag</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param bag the collection to union with self
	 * @return The union of self and <code>bag</code>.
	 */
	public LazyBag<E> union(final LazyBag<E> bag) {
		return new LazyBag.UnionBag<E>(bag, this);
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to intersect with self
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazyOrderedSet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to intersect with self
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazySet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to intersect with self
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazyBag<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the elements of self, which are not in <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to subtract from self
	 * @return The elements of self, which are not in <code>s</code>.
	 */
	public LazyOrderedSet<E> subtract(final LazyOrderedSet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new SubtractionIterator(s);
			}
		};
	}

	/**
	 * Returns the elements of self, which are not in <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to subtract from self
	 * @return The elements of self, which are not in <code>s</code>.
	 */
	public LazyOrderedSet<E> subtract(final LazySet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new SubtractionIterator(s);
			}
		};
	}

	/**
	 * Returns the set containing all elements of self plus <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the element to include
	 * @return The set containing all elements of self plus <code>object</code>
	 */
	@Override
	public LazyOrderedSet<E> including(final E object) {
		return append(object);
	}

	/**
	 * Returns the collection containing all elements of self plus <code>object</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param object
	 *            the object to include
	 * @param index
	 *            the index at which to insert <code>coll</code> (starting at 1)
	 * @return The collection containing all elements of self plus <code>object</code>.
	 */
	@Override
	public LazyOrderedSet<E> including(final E object, final int index) {
		if (index > 0) {
			return insertAt(index, object);
		} else {
			return append(object);
		}
	}

	/**
	 * Returns the collection containing all elements of self plus <code>coll</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param coll
	 *            the collection to include
	 * @return The collection containing all elements of self plus <code>coll</code>.
	 */
	@Override
	public LazyOrderedSet<E> includingAll(final Collection<? extends E> coll) {
		return union(LazyCollections.asLazyOrderedSet(coll));
	}

	/**
	 * Returns the collection containing all elements of self plus <code>coll</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param coll
	 *            the collection to include
	 * @param index
	 *            the index at which to insert <code>coll</code> (starting at 1)
	 * @return The collection containing all elements of self plus <code>coll</code>.
	 */
	@Override
	public LazyOrderedSet<E> includingAll(final Collection<? extends E> coll, final int index) {
		if (index > 0) {
			return union(LazyCollections.asLazyOrderedSet(coll), index);
		} else {
			return union(LazyCollections.asLazyOrderedSet(coll));
		}
	}

	/**
	 * Returns the set containing all elements of self without <code>object</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param object
	 *            the element to exclude
	 * @return The set containing all elements of self without <code>object</code>.
	 */
	@Override
	public LazyOrderedSet<E> excluding(final Object object) {
		return new ExcludingOrderedSet<E>(object, this);
	}

	/**
	 * Returns the collection containing all elements of self minus <code>coll</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param coll
	 *            the collection to exclude
	 * @return The collection containing all elements of self minus <code>coll</code>.
	 */
	@Override
	public LazyOrderedSet<E> excludingAll(final Collection<?> coll) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new SubtractionIterator(coll);
			}
		};
	}

	/**
	 * Returns the set containing all the elements that are in self or <code>s</code>, but not in both.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param s
	 *            the collection to perform the symmetric difference with
	 * @return The set containing all the elements that are in self or <code>s</code>, but not in both.
	 */
	public LazyOrderedSet<E> symmetricDifference(final LazyOrderedSet<E> s) {
		return union(s).subtract(intersection(s));
	}

	/**
	 * If the element type is not a collection type this results in the same self.
	 * If the element type is a collection type, the result is the set
	 * containing all the elements of all the elements of self.
	 * <p><i>Lazy operation.</i></p>
	 * @return <b>if</b> self.type.elementType.oclIsKindOf(CollectionType) <b>then</b><br>
	 * &nbsp;&nbsp;self-&gt;iterate(c; acc : OrderedSet() = OrderedSet{} |<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;acc-&gt;union(c-&gt;asOrderedSet() ) )<br>
	 * <b>else</b><br>
	 * &nbsp;&nbsp;self<br>
	 * <b>endif</b>
	 */
	public LazyOrderedSet<?> flatten() {
		final LazyOrderedSet<E> inner = this;
		return new LazyOrderedSet<Object>(new Iterable<Object>() {
			@Override
			public Iterator<Object> iterator() {
				return new FlattenSetIterator(inner);
			}
		});
	}

	/**
	 * Returns the set of elements, consisting of all elements of self, followed by <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the element to append
	 * @return The set of elements, consisting of all elements of self, followed by <code>object</code>.
	 */
	public LazyOrderedSet<E> append(final E object) {
		return new AppendOrderedSet<E>(object, this);
	}

	/**
	 * Returns the OrderedSet consisting of <code>object</code>, followed by all elements in self.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the element to prepend
	 * @return The OrderedSet consisting of <code>object</code>, followed by all elements in self.
	 */
	public LazyOrderedSet<E> prepend(final E object) {
		return new PrependOrderedSet<E>(object, this);
	}

	/**
	 * Returns the OrderedSet consisting of self with <code>object</code> inserted at position <code>index</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param index the index at which to insert
	 * @param object the element to insert
	 * @return The OrderedSet consisting of self with <code>object</code> inserted at position <code>index</code>.
	 */
	public LazyOrderedSet<E> insertAt(final int index, final E object) {
		return new InsertAtOrderedSet<E>(object, index - 1, this);
	}

	/**
	 * Returns the sub-set of self starting at number <code>lower</code>, up to and including element number <code>upper</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param lower the sub-range lower bound, inclusive
	 * @param upper the sub-range upper bound, inclusive
	 * @return The sub-set of self starting at number <code>lower</code>, up to and including element number <code>upper</code>.
	 */
	public LazyOrderedSet<E> subSequence(final int lower, final int upper) {
		return new SubOrderedSet<E>(lower - 1, upper, this);
	}

	/**
	 * Returns the ordered set of elements with same elements but with the opposite order.
	 * @return The ordered set of elements with same elements but with the opposite order.
	 */
	public LazyOrderedSet<E> reverse() {
		return new ReverseOrderedSet<E>(this);
	}

	/**
	 * Returns an OrderedSet identical to self. This operation exists for convenience reasons.
	 * <p><i>Lazy operation.</i></p>
	 * @return An OrderedSet identical to self. This operation exists for convenience reasons.
	 */
	@Override
	public LazyOrderedSet<E> asOrderedSet() {
		return this;
	}

	/**
	 * Returns the OrderedSet containing all elements of self plus the OrderedSet of <code>first</code> running to <code>last</code> added
	 * as the last elements.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 *
	 * @param first
	 *            the first object of the range to include
	 * @param last
	 *            the last object of the range to include
	 * @return The OrderedSet containing all elements of self plus the OrderedSet of <code>first</code> running to <code>last</code> added
	 *         as the last elements
	 */
	@Override
	@SuppressWarnings("unchecked")
	public LazyOrderedSet<E> includingRange(final E first, final E last) {
		if (first instanceof Integer && last instanceof Integer) {
			return union((LazyOrderedSet<E>) new IntegerRangeOrderedSet((Integer) first, (Integer) last));
		}
		if (first instanceof Long && last instanceof Long) {
			return union((LazyOrderedSet<E>) new LongRangeOrderedSet((Long) first, (Long) last));
		}
		throw new IllegalArgumentException(String.format("includingRange() not supported for arguments of type %s and %s", first.getClass()
				.getName(), last.getClass().getName()));
	}

	/* *********************************************************************
	 * Lazy, higher-order operations                                       *
	 * *********************************************************************/

	/**
	 * Selects all elements from this collection for which the
	 * <code>condition</code> evaluates to <code>true</code>.
	 * @param condition the condition function
	 * @return a new lazy ordered set with only the selected elements.
	 */
	public LazyOrderedSet<E> select(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		condition.setParentFrame(null);
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new SelectIterator(condition, parentFrame);
			}
		};
	}

	/**
	 * Rejects all elements from this collection for which the
	 * <code>condition</code> evaluates to <code>true</code>.
	 * @param condition the condition function
	 * @return a new lazy ordered set without the rejected elements.
	 */
	public LazyOrderedSet<E> reject(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		condition.setParentFrame(null);
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new RejectIterator(condition, parentFrame);
			}
		};
	}

	/**
	 * Collects the return values of <code>function</code> for
	 * each of the elements of this collection.
	 * @param function the return value function
	 * @return a new lazy list with the <code>function</code> return values.
	 * @param <T> the element type
	 */
	public <T> LazyList<T> collect(final CodeBlock function) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = function.getParentFrame();
		function.setParentFrame(null);
		final LazyOrderedSet<E> inner = this;
		return new LazyList<T>(new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new CollectIterator<T>(inner, function, parentFrame);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LazyOrderedSet<E> sortedBy(final CodeBlock body) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = body.getParentFrame();
		body.setParentFrame(null);
		return new LazyOrderedSet<E>(this) {
			@SuppressWarnings("unchecked")
			@Override
			public Iterator<E> iterator() {
				final Collection<E> inner = (Collection<E>) dataSource;
				if (inner != null) {
					final Iterator<Comparable<Object>> sortingKeys = new CollectIterator<Comparable<Object>>(inner, body, parentFrame);
					final Object[] innerCopy = inner.toArray();
					final Map<Object, Comparable<Object>> elementsToKeys = new HashMap<Object, Comparable<Object>>(innerCopy.length);
					for (final Object o : innerCopy) {
						elementsToKeys.put(o, sortingKeys.next());
					}
					assert !sortingKeys.hasNext();
					Arrays.sort(innerCopy, new Comparator<Object>() {
						@Override
						public int compare(final Object o1, final Object o2) {
							return elementsToKeys.get(o1).compareTo(elementsToKeys.get(o2));
						}
					});
					cache = (Collection<E>) Arrays.asList(innerCopy);
					dataSource = null;
				}
				return super.iterator();
			}
			@Override
			public int size() {
				if (dataSource == null) {
					return cache.size();
				}
				return ((Collection<E>) dataSource).size();
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Spliterator<E> spliterator() {
		return List.super.spliterator();
	}

	//TODO provide other iterator operations: collectNested

}
