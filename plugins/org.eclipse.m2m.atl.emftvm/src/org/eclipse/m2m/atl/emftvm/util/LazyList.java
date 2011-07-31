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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.m2m.atl.emftvm.CodeBlock;


/**
 * Immutable {@link List} that supports lazy evaluation.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E> the collection element type
 */
public class LazyList<E> extends LazyCollection<E> implements List<E> {

	/**
	 * Abstract {@link LazyList} that disables caching of the underlying {@link LazyList}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public abstract static class NonCachingList<E> extends LazyList<E> {

		/**
		 * Creates a {@link NonCachingList} around <code>dataSource</code>.
		 * @param dataSource the underlying {@link LazyList}
		 */
		public NonCachingList(final LazyList<E> dataSource) {
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
	 * {@link LazyList} that represents a union of the underlying {@link LazyList}
	 * and the added {@link LazyList}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> The list element type.
	 */
	public static class UnionList<E> extends NonCachingList<E> {

		protected final LazyList<E> s;

		/**
		 * Creates a new {@link UnionList}.
		 * @param s the collection to union with the underlying collection
		 * @param dataSource the underlying collection
		 */
		public UnionList(final LazyList<E> s, final LazyList<E> dataSource) {
			super(dataSource);
			this.s = s;
			assert s != null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E first() {
			return ((LazyList<E>)dataSource).isEmpty() ? s.first() : ((LazyList<E>)dataSource).first();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(int index) {
			final int size = ((List<E>)dataSource).size();
			return index < size ? ((List<E>)dataSource).get(index) : s.get(index - size);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(Object o) {
			final int indexOf = ((List<E>)dataSource).indexOf(o);
			if (indexOf > -1) {
				return indexOf;
			} else {
				return ((List<E>)dataSource).size() + s.indexOf(o);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			return s.isEmpty() ? ((LazyList<E>)dataSource).last() : s.last();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(Object o) {
			final int lastIndexOf = s.lastIndexOf(o);
			if (lastIndexOf > -1) {
				return ((List<E>)dataSource).size() + lastIndexOf;
			} else {
				return ((List<E>)dataSource).lastIndexOf(o);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new UnionListIterator(s);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return new UnionListIterator(s, index);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(Object o) {
			return ((Collection<E>)dataSource).contains(o) ||
					s.contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(E object) {
			return ((LazyCollection<E>)dataSource).count(object) + s.count(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return ((Collection<E>)dataSource).isEmpty() && s.isEmpty();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new UnionIterator(s);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return ((Collection<E>)dataSource).size() + s.size();
		}

	}

	/**
	 * {@link LazyList} that appends an element to the underlying {@link LazyList}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> The list element type.
	 */
	public static class AppendList<E> extends NonCachingList<E> {

		/**
		 * {@link ListIterator} that appends an object to the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class AppendListIterator extends WrappedListIterator {
		
			protected boolean beforeTail = true;
		
			/**
			 * Creates a new {@link AppendListIterator}.
			 */
			public AppendListIterator() {
				super();
			}
		
			/**
			 * Creates a new {@link AppendListIterator}.
			 * @param index the iterator starting index.
			 */
			public AppendListIterator(final int index) {
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
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				return inner.nextIndex() + (beforeTail ? 0 : 1);
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				return !beforeTail || inner.hasPrevious();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
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
				return inner.previousIndex() + (beforeTail ? 0 : 1);
			}
			
		}

		/**
		 * The element to append.
		 */
		protected final E object;

		/**
		 * Creates a new {@link AppendList}.
		 * @param object the element to append
		 * @param dataSource the underlying {@link LazyList}
		 */
		public AppendList(final E object, final LazyList<E> dataSource) {
			super(dataSource);
			this.object = object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			return object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			final int size = ((List<E>)dataSource).size();
			if (index < size) {
				return ((List<E>)dataSource).get(index);
			} else if (index == size) {
				return object;
			} else {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>)dataSource).indexOf(o);
			if (index > -1) {
				return index;
			}
			return (object == null ? o == null : object.equals(o)) ? size() - 1 : -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(final Object o) {
			if (object == null ? o == null : object.equals(o)) {
				return size() - 1;
			}
			return ((List<E>)dataSource).lastIndexOf(o);
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
		public int count(final E o) {
			return (object == null ? o == null : object.equals(o)) ? 1 : 0 + 
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
			return new AppendIterator(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return ((Collection<E>)dataSource).size() + 1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new AppendListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new AppendListIterator(index);
		}
		
	}

	/**
	 * {@link LazyList} that prepends an element to the underlying {@link LazyList}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class PrependList<E> extends AppendList<E> {

		/**
		 * {@link Iterator} that prepends an object to the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class PrependIterator extends WrappedIterator {
		
			protected boolean beforeHead = true;
		
			/**
			 * Creates a new {@link PrependIterator}.
			 */
			public PrependIterator() {
				super();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return beforeHead || inner.hasNext();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (beforeHead) {
					beforeHead = false;
					return object;
				}
				return inner.next();
			}
		}

		/**
		 * {@link ListIterator} that appends an object to the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class PrependListIterator extends WrappedListIterator {
		
			protected boolean beforeHead = true;
		
			/**
			 * Creates a new {@link PrependListIterator}.
			 */
			public PrependListIterator() {
				super();
			}
		
			/**
			 * Creates a new {@link PrependListIterator}.
			 * @param index the iterator starting index.
			 */
			public PrependListIterator(final int index) {
				super(index < 1 ? index : index - 1);
				this.beforeHead = index < 1;
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return beforeHead || inner.hasNext();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
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
				if (beforeHead) {
					return 0;
				}
				return inner.nextIndex() + 1;
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				assert beforeHead || !inner.hasPrevious(); // not beforeHead implies not inner.hasPrevious()
				return !beforeHead;
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				if (inner.hasPrevious()) {
					return inner.previous();
				} else if (!beforeHead) {
					beforeHead = true;
					return object;
				}
				throw new NoSuchElementException();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				if (beforeHead) {
					return -1;
				}
				return inner.previousIndex() + 1;
			}
			
		}

		/**
		 * Creates a new {@link PrependList}.
		 * @param object the object to prepend
		 * @param dataSource the underlying collection
		 */
		public PrependList(final E object, final LazyList<E> dataSource) {
			super(object, dataSource);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E first() {
			return object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E last() {
			if (!((LazyList<E>)dataSource).isEmpty()) {
				return ((LazyList<E>)dataSource).last();
			} else {
				return object;
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			if (index == 0) {
				return object;
			} else {
				return ((List<E>)dataSource).get(index - 1);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(final Object o) {
			if (object == null ? o == null : object.equals(o)) {
				return 0;
			}
			final int index = ((List<E>)dataSource).indexOf(o);
			return index > -1 ? index + 1 : index;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(Object o) {
			final int lastIndex = ((List<E>)dataSource).lastIndexOf(o) + 1;
			if (lastIndex > 0) {
				return lastIndex;
			}
			return (object == null ? o == null : object.equals(o)) ? 0 : -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new PrependIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new PrependListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return new PrependListIterator(index);
		}
		
	}

	/**
	 * {@link LazyList} that inserts an element it a given index in the underlying collection.
	 * List index starts at 0.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E>
	 */
	public static class InsertAtList<E> extends AppendList<E> {

		/**
		 * Inserts an element into the underlying collection at the given index.
		 * List index starts at 0.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class InsertAtIterator extends WrappedIterator {
		
			protected int i = -1;
		
			/**
			 * Creates a new {@link InsertAtIterator}.
			 */
			public InsertAtIterator() {
				super();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return i < index || inner.hasNext();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (++i == index) {
					return object;
				}
				return inner.next();
			}
		}

		/**
		 * Inserts an element into the underlying collection at the given index.
		 * List index starts at 0.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class InsertAtListIterator extends WrappedListIterator {
		
			protected int i = -1;
		
			/**
			 * Creates a new {@link InsertAtListIterator}.
			 */
			public InsertAtListIterator() {
				super();
			}
		
			/**
			 * Creates a new {@link InsertAtListIterator}.
			 * @param index the iterator starting index, starting from 0 instead of 1.
			 */
			public InsertAtListIterator(final int index) {
				super(index < InsertAtList.this.index ? index : index - 1);
				this.i = index - 1;
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return i < index || inner.hasNext();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				if (++i == index) {
					return object;
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
				return i >= index || inner.hasPrevious();
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				if (i-- == index) {
					return object;
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
		 * Creates a new {@link InsertAtList}.
		 * @param index the index at which to insert the element, starting from 0
		 * @param object the element to insert
		 * @param dataSource the underlying collection
		 */
		public InsertAtList(final int index, final E object, final LazyList<E> dataSource) {
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
		public E first() {
			assert index >= 0;
			return index == 0 ? object : ((LazyList<E>)dataSource).first();
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
				return object;
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(final int index) {
			final int size = ((List<E>)dataSource).size();
			if (index < size) {
				if (index < this.index) {
					return ((List<E>)dataSource).get(index);
				} else if (index == this.index) {
					return object;
				}
				assert this.index >= 0;
				assert index > this.index;
				return ((List<E>)dataSource).get(index - 1);
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
					return index;
				}
				return indexOf;
			}
			if (object == null ? o == null : object.equals(o)) {
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
		public int lastIndexOf(final Object o) {
			final int lastIndexOf = ((List<E>)dataSource).lastIndexOf(o);
			if (lastIndexOf > -1) {
				assert index >= 0;
				if (lastIndexOf < index && (object == null ? o == null : object.equals(o))) {
					return index;
				}
				return lastIndexOf;
			}
			if (object == null ? o == null : object.equals(o)) {
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
		public Iterator<E> iterator() {
			return new InsertAtIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new InsertAtListIterator();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new InsertAtListIterator(index);
		}
		
	}

	/**
	 * {@link LazyList} that presents a sub-range of the underlying list.
	 */
	public static class SubList<E> extends NonCachingList<E> {

		protected final int fromIndex;
		protected final int toIndex;

		/**
		 * Creates a new {@link SubList}.
		 * @param fromIndex the starting index, inclusive
		 * @param toIndex the ending index, exclusive
		 * @param dataSource the underlying collection
		 */
		public SubList(final int fromIndex, final int toIndex, final LazyList<E> dataSource) {
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
		public int lastIndexOf(final Object o) {
			final int index = ((List<E>)dataSource).lastIndexOf(o);
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
			return fromIndex < toIndex;
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
	 * {@link LazyList} that reverses the order of the underlying list.
	 */
	public static class ReverseList<E> extends NonCachingList<E> {

		protected final int last;

		/**
		 * Creates a new {@link ReverseList}.
		 * @param dataSource the underlying collection
		 */
		public ReverseList(final LazyList<E> dataSource) {
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
	 * {@link ListIterator} that returns first the elements of the underlying
	 * collection, then the elements of the other collection.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class UnionListIterator extends WrappedListIterator {

		protected final List<E> s;
		protected ListIterator<E> added; // lazily instantiate this iterator
		protected boolean innerNext; // cache last inner.hasNext() invocation
		protected boolean addedPrev; // cache last added.hasPrevious() invocation

		/**
		 * Creates a new {@link UnionListIterator} for the underlying
		 * collection and <code>s</code>.
		 * @param s the collection to union
		 */
		public UnionListIterator(final List<E> s) {
			super();
			this.s = s;
		}

		/**
		 * Creates a new {@link UnionListIterator} for the underlying
		 * collection and <code>s</code>.
		 * @param s the collection to union
		 * @param index the iterator starting index.
		 */
		public UnionListIterator(final List<E> s, final int index) {
			super(index);
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
					added = s.listIterator();
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
					added = s.listIterator();
				}
			}
			return added.next();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int nextIndex() {
			if (added == null) {
				if (innerNext || inner.hasNext()) {
					return inner.nextIndex();
				} else {
					added = s.listIterator();
				}
			}
			return ((Collection<E>)dataSource).size() + added.nextIndex();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasPrevious() {
			if (added != null) {
				addedPrev = added.hasPrevious();
				if (addedPrev) {
					return true;
				} else {
					added = null;
				}
			}
			return inner.hasPrevious();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E previous() {
			if (added != null) {
				if (addedPrev || added.hasPrevious()) {
					addedPrev = false;
					return added.previous();
				} else {
					added = null;
				}
			}
			return inner.previous();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int previousIndex() {
			if (added != null) {
				if (addedPrev || added.hasPrevious()) {
					return ((Collection<E>)dataSource).size() + added.previousIndex();
				} else {
					added = null;
				}
			}
			return inner.previousIndex();
		}
		
	}

	/**
	 * Creates a {@link LazyList} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyList(final Iterable<E> dataSource) {
		super(dataSource);
	}

	/**
	 * Creates an empty {@link LazyList}.
	 */
	public LazyList() {
		super();
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
	 * Unsupported.
	 * @param index the index at which to add
	 * @param element the element to add
	 * @throws UnsupportedOperationException
	 */
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
	public boolean addAll(final int index, final Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public E get(final int index) {
		if (index < cache.size()) {
			return ((List<E>)cache).get(index);
		}
		int i = 0;
		for (E e : this) {
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
	public int indexOf(final Object o) {
		final int index = ((List<E>)cache).indexOf(o);
		if (index > -1 || dataSource == null) { // cache complete
			return index;
		}
		int i = 0;
		if (o == null) {
			for (E e : this) {
				if (e == null) return i;
				i++;
			}
		} else {
			for (E e : this) {
				if (o.equals(e)) return i;
				i++;
			}
		}
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	public int lastIndexOf(final Object o) {
		if (dataSource == null) { // cache complete
			return ((List<E>)cache).lastIndexOf(o);
		}
		int i = 0;
		int lastIndex = -1;
		if (o == null) {
			for (E e : this) {
				if (e == null) lastIndex = i;
				i++;
			}
		} else {
			for (E e : this) {
				if (e.equals(o)) lastIndex = i;
				i++;
			}
		}
		return lastIndex;
	}

	/**
	 * {@inheritDoc}
	 */
	public ListIterator<E> listIterator() {
		if (dataSource == null) { // cache complete
			return Collections.unmodifiableList((List<E>)cache).listIterator();
		}
		return new IteratorToListIterator();
	}

	/**
	 * {@inheritDoc}
	 */
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
	public E set(final int index, final E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><i>Lazy implementation of {@link List#subList(int, int)}.</i></p>
	 * {@inheritDoc}
	 */
	public List<E> subList(final int fromIndex, final int toIndex) {
		return new SubList<E>(fromIndex, toIndex, this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object o) {
		if (o == this) {
		    return true;
		}
		if (!(o instanceof List<?>)) {
		    return false;
		}
		final Iterator<E> e1 = iterator();
		final Iterator<?> e2 = ((Collection<?>)o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
		    E o1 = e1.next();
		    Object o2 = e2.next();
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
		int hashCode = 1;
		for (E obj : this) {
		    hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
		}
		return hashCode;
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
	 * @param obj the object to look for
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
	 * @param obj the object to look for
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
	 * Returns the sequence consisting of all elements in self, followed by all elements in <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s the list to union with this
	 * @return The sequence consisting of all elements in self, followed by all elements in <code>s</code>.
	 */
	public LazyList<E> union(final LazyList<E> s) {
		return new UnionList<E>(s, this);
	}

	/**
	 * If the element type is not a collection type this results in the same self.
	 * If the element type is a collection type, the result is the sequence
	 * containing all the elements of all the elements of self.
	 * The order of the elements is partial.
	 * <p><i>Lazy operation.</i></p>
	 * @return <b>if</b> self.type.elementType.oclIsKindOf(CollectionType) <b>then</b><br>
	 * &nbsp;&nbsp;self-&gt;iterate(c; acc : Sequence() = Sequence{} |<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;acc-&gt;union(c-&gt;asSequence() ) )<br>
	 * <b>else</b><br>
	 * &nbsp;&nbsp;self<br>
	 * <b>endif</b>
	 */
	public LazyList<?> flatten() {
		final LazyList<E> inner = this;
		return new LazyList<Object>(new Iterable<Object>() {
			public Iterator<Object> iterator() {
				return new FlattenIterator(inner);
			}
		});
	}

	/**
	 * Returns the sequence of elements, consisting of all elements of self, followed by <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to append
	 * @return The sequence of elements, consisting of all elements of self, followed by <code>object</code>.
	 */
	public LazyList<E> append(final E object) {
		return new AppendList<E>(object, this);
	}

	/**
	 * Returns the sequence consisting of <code>object</code>, followed by all elements in self.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to prepend
	 * @return The sequence consisting of <code>object</code>, followed by all elements in self.
	 */
	public LazyList<E> prepend(final E object) {
		return new PrependList<E>(object, this);
	}

	/**
	 * Returns the sequence consisting of self with <code>object</code> inserted at position <code>index</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param index the index at which to insert
	 * @param object the object to insert
	 * @return The sequence consisting of self with <code>object</code> inserted at position <code>index</code>.
	 */
	public LazyList<E> insertAt(final int index, final E object) {
		return new InsertAtList<E>(index - 1, object, this);
	}

	/**
	 * Returns the sub-list of this list starting at number <code>lower</code>,
	 * up to and including element number <code>upper</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param lower the sub-list lower bound, inclusive
	 * @param upper the sub-list upper bound, inclusive
	 * @return the sub-list of this list. 
	 */
	public LazyList<E> subSequence(final int lower, final int upper) {
		return new SubList<E>(lower - 1, upper, this);
	}

	/**
	 * Returns the sequence containing all elements of self plus <code>object</code> added as the last element.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to include
	 * @return The sequence containing all elements of self plus <code>object</code> added as the last element.
	 */
	public LazyList<E> including(final E object) {
		return append(object);
	}

	/**
	 * Returns the sequence containing all elements of self apart from all occurrences of <code>object</code>. 
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to exclude
	 * @return The sequence containing all elements of self apart from all occurrences of <code>object</code>.
	 */
	public LazyList<E> excluding(final E object) {
		return new LazyList<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new ExcludingIterator(object); 
			}
		};
	}

	/**
	 * Returns the sequence containing the same elements but with the opposite order.
	 * <p><i>Lazy operation.</i></p>
	 * @return The sequence containing the same elements but with the opposite order.
	 */
	public LazyList<E> reverse() {
		return new ReverseList<E>(this);
	}

	/**
	 * Returns the Sequence identical to the object itself. This operation exists for convenience reasons. 
	 * <p><i>Lazy operation.</i></p>
	 * @return The Sequence identical to the object itself. This operation exists for convenience reasons.
	 */
	@Override
	public LazyList<E> asSequence() {
		return this;
	}

	/* *********************************************************************
	 * Lazy, higher-order operations                                       *
	 * *********************************************************************/

	/**
	 * Selects all elements from this collection for which the
	 * <code>condition</code> evaluates to <code>true</code>.
	 * @param condition the condition function
	 * @return a new lazy list with only the selected elements.
	 */
	public LazyList<E> select(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		return new LazyList<E>(this) {
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
	 * @return a new lazy list without the rejected elements.
	 */
	public LazyList<E> reject(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		return new LazyList<E>(this) {
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
		final LazyList<E> inner = this;
		return new LazyList<T>(new Iterable<T>() {
			public Iterator<T> iterator() {
				return new CollectIterator<T>(inner, function, parentFrame);
			}
		}) {
			@SuppressWarnings("unchecked")
			@Override
			public T get(final int index) {
				if (index < cache.size()) {
					return ((List<T>)cache).get(index);
				}
				return (T)function.execute(parentFrame.getSubFrame(function, new Object[]{inner.get(index)}));
			}
			@SuppressWarnings("unchecked")
			@Override
			public T last() {
				if (dataSource == null) {
					final int size = cache.size();
					if (size < 1) {
						throw new NoSuchElementException();
					}
					return ((List<T>)cache).get(size - 1);
				}
				return (T)function.execute(parentFrame.getSubFrame(function, new Object[]{inner.last()}));
			}
			@Override
			public int size() {
				return inner.size();
			}
		};
	}

	//TODO provide other iterator operations: collectNested, sortedBy

}
