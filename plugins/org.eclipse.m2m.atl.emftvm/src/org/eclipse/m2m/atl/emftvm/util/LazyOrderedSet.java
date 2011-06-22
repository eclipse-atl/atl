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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.CodeBlock;


/**
 * Immutable {@link Set} and {@link List} that supports lazy evaluation.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
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
	public static abstract class NonCachingOrderedSet<E> extends LazyOrderedSet<E> {

		/**
		 * Creates a {@link NonCachingOrderedSet} around <code>dataSource</code>.
		 * @param dataSource
		 */
		public NonCachingOrderedSet(final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			assert dataSource != null;
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#createCache()
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

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#first()
		 */
		@Override
		public E first() {
			return ((List<E>) dataSource).get(fromIndex);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			return ((List<E>) dataSource).get(toIndex-1);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			return ((List<E>) dataSource).get(index + fromIndex);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>) dataSource).indexOf(o);
			if (index >= fromIndex && index < toIndex) {
				return index - fromIndex;
			}
			return -1;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(final Object o) {
			final int index = ((List<E>) dataSource).indexOf(o);
			return index >= fromIndex && index < toIndex;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return fromIndex < toIndex;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new SubListIterator(fromIndex, toIndex);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			return toIndex - fromIndex;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new SubListListIterator(fromIndex, toIndex);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
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
			protected boolean innerNext = false; // cache last inner.hasNext() invocation
		
			/**
			 * Creates a new {@link AppendOrderedSetIterator}.
			 */
			public AppendOrderedSetIterator() {
				super();
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet == true;
				return (beforeTail && !containsObject ) || (innerNext = inner.hasNext());
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
			@Override
			public E next() {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					return inner.next();
				} else if (beforeTail) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet == true;
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
			protected boolean innerNext = false; // cache last inner.hasNext() invocation
		
			/**
			 * Creates a new {@link AppendOrderedSetListIterator}.
			 * @param object the object to include
			 */
			public AppendOrderedSetListIterator() {
				super();
			}
		
			/**
			 * Creates a new {@link AppendOrderedSetListIterator}.
			 * @param index the iterator starting index.
			 */
			public AppendOrderedSetListIterator(final int index) {
				super(index > 0 ? index-1 : index);
				if (index > 0) {
					next();
				}
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet == true;
				return (beforeTail && !containsObject ) || (innerNext = inner.hasNext());
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
			@Override
			public E next() {
				if (innerNext || inner.hasNext()) {
					innerNext = false;
					return inner.next();
				} else if (beforeTail) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet == true;
					if (!containsObject) {
						beforeTail = false;
						return object;
					}
				}
				throw new NoSuchElementException();
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#nextIndex()
			 */
			@Override
			public int nextIndex() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return inner.nextIndex() + (beforeTail ? 0 : 1);
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#hasPrevious()
			 */
			@Override
			public boolean hasPrevious() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return !beforeTail || inner.hasPrevious();
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previous()
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

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previousIndex()
			 */
			@Override
			public int previousIndex() {
				assert beforeTail || (containsObjectSet && !containsObject); // !beforeTail implies (containsObjectSet && !containsObject)
				return inner.previousIndex() + (beforeTail ? 0 : 1);
			}
			
		}

		protected final E object;
		protected boolean containsObject;
		protected boolean containsObjectSet = false;

		/**
		 * Creates a new {@link AppendOrderedSet}.
		 * @param object the element to append
		 * @param dataSource the underlying collection
		 */
		public AppendOrderedSet(final E object, final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.object = object;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(final Object o) {
			return (object==null ? o==null : object.equals(o)) || 
					((Collection<E>) dataSource).contains(o);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#count(java.lang.Object)
		 */
		@Override
		public int count(final E o) {
			return (object==null ? o==null : object.equals(o)) ? 1 : 
					((LazyCollection<E>) dataSource).count(o);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return false;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new AppendOrderedSetIterator();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>) dataSource).size();
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet == true;
			return size + (containsObject == true ? 0 : 1);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			return ((List<E>) dataSource).get(size()-1);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			final int size = ((Collection<E>) dataSource).size();
			if (index < size) {
				return ((List<E>) dataSource).get(index);
			}
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet == true;
			if (index == size && !containsObject) {
				return object;
			}
			throw new NoSuchElementException();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>) dataSource).indexOf(o);
			if (index >= 0) {
				return index;
			}
			assert index == -1;
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet == true;
			if (!containsObject && (object==null ? o==null : object.equals(o))) {
				return ((Collection<E>) dataSource).size();
			}
			return -1;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new AppendOrderedSetListIterator();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
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
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				beforeHead = !containsObject;
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				return beforeHead || inner.hasNext();
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
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
			protected boolean innerPrev = false; // cache value of inner.hasPrevious()
		
			/**
			 * Creates a new {@link PrependOrderedSetListIterator}.
			 */
			public PrependOrderedSetListIterator() {
				super();
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
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
				super(index > 0 ? index-1 : index);
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				this.beforeHead = !containsObject && index == 0;
				if (index > 0) {
					next();
				}
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				return beforeHead || inner.hasNext();
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
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
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#nextIndex()
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
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#hasPrevious()
			 */
			@Override
			public boolean hasPrevious() {
				assert containsObjectSet;
				assert !beforeHead || !containsObject; // beforeHead implies !containsObject
				assert beforeHead || !inner.hasPrevious(); // not beforeHead implies not inner.hasPrevious()
				return !beforeHead && (!containsObject || (innerPrev = inner.hasPrevious()));
			}
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previous()
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
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previousIndex()
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
	
		public PrependOrderedSet(final E object, final LazyOrderedSet<E> dataSource) {
			super(object, dataSource);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new PrependOrderedSetIterator();
		}
	
		@Override
		public E first() {
			return ((List<E>) dataSource).get(size()-1);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			if (!((LazyOrderedSet<E>) dataSource).isEmpty()) {
				return ((LazyOrderedSet<E>) dataSource).last();
			}
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject) {
				return object;
			}
			throw new NoSuchElementException();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject) {
				if (index == 0) {
					return object;
				} else {
					return ((List<E>) dataSource).get(index-1);
				}
			} else {
				return ((List<E>) dataSource).get(index);
			}
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			if (!containsObjectSet) {
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (containsObject) {
				return ((List<E>) dataSource).indexOf(o);
			}
			if (object==null ? o==null : object.equals(o)) {
				return 0;
			}
			final int index = ((List<E>) dataSource).indexOf(o);
			return (index > -1) ? index+1 : -1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new PrependOrderedSetListIterator();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
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
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				// next() will throw exception when index is out of bounds
				return i < index || inner.hasNext();
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
			@Override
			public E next() {
				if (++i == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
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
			protected boolean innerNext = false; // cache last inner.hasNext() invocation
		
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
				super(index > 0 ? index-1 : index);
				assert index >= 0;
				if (index > 0) {
					this.i = index-2;
					next();
				}
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				// next() will throw exception when index is out of bounds
				return i < index || inner.hasNext();
			}
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
			@Override
			public E next() {
				if (++i == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
				}
				return inner.next();
			}
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#nextIndex()
			 */
			@Override
			public int nextIndex() {
				return i+1;
			}
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#hasPrevious()
			 */
			@Override
			public boolean hasPrevious() {
				// previous() will throw exception when index is out of bounds
				return i >= index || inner.hasPrevious();
			}
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previous()
			 */
			@Override
			public E previous() {
				if (i-- == index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
				}
				return inner.previous();
			}
	
			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previousIndex()
			 */
			@Override
			public int previousIndex() {
				return i;
			}
			
		}
	
		protected final int index;
	
		/**
		 * 
		 * @param object
		 * @param index the insertion index
		 * @param dataSource
		 */
		public InsertAtOrderedSet(final E object, final int index, final LazyOrderedSet<E> dataSource) {
			super(object, dataSource);
			this.index = index;
			if (index < 0) {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new InsertAtOrderedSetIterator();
		}
	
		@Override
		public E first() {
			assert index >= 0;
			if (index == 0) {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				if (!containsObject) {
					return object;
				}
			}
			return ((LazyList<E>) dataSource).first();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			final int size = ((Collection<E>) dataSource).size();
			if (index < size) {
				return ((LazyList<E>) dataSource).last();
			} else if (index == size) {
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				if (!containsObject) {
					return object;
				}
				return ((LazyList<E>) dataSource).last();
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			final int size = ((List<E>) dataSource).size();
			if (index < size) {
				if (index < this.index) {
					return ((List<E>) dataSource).get(index);
				} else if (index == this.index) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
						containsObjectSet = true;
					}
					assert containsObjectSet;
					if (!containsObject) {
						return object;
					}
					return ((List<E>) dataSource).get(index);
				}
				assert this.index >= 0;
				assert index > this.index;
				if (!containsObjectSet) {
					containsObject = ((Collection<E>) dataSource).contains(object);
					containsObjectSet = true;
				}
				assert containsObjectSet;
				return ((List<E>) dataSource).get(containsObject ? index : index-1);
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			final int indexOf = ((List<E>) dataSource).indexOf(o);
			if (indexOf > -1) {
				assert index >= 0;
				if (indexOf > index && (object==null ? o==null : object.equals(o))) {
					if (!containsObjectSet) {
						containsObject = ((Collection<E>) dataSource).contains(object);
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
				containsObject = ((Collection<E>) dataSource).contains(object);
				containsObjectSet = true;
			}
			assert containsObjectSet;
			if (!containsObject && (object==null ? o==null : object.equals(o))) {
				if (index <= ((Collection<E>) dataSource).size()) {
					return index;
				}
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			return -1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new InsertAtOrderedSetListIterator();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
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
			protected E next = null;
			protected boolean nextSet = false;
		
			/**
			 * Creates a new {@link ExcludingIterator}.
			 */
			public ExcludingOrderedSetIterator() {
				super();
			}
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedIterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				if (excludedIndexSet) {
					return i < excludedIndex || inner.hasNext();
				}
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				if (nextSet && (object==null ? next==null : object.equals(next))) {
					excludedIndex = i+1;
					excludedIndexSet = true;
					if (inner.hasNext()) {
						next = inner.next();
						assert !(object==null ? next==null : object.equals(next));
					}
				}
				final boolean hasNext = nextSet && !(object==null ? next==null : object.equals(next));
				if (!hasNext && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasNext;
			}
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedIterator#next()
			 */
			@Override
			public E next() {
				i++;
				if (excludedIndexSet) {
					if (i == excludedIndex) {
						// Skip value
						if (nextSet) {
							nextSet = false;
						} else {
							inner.next();
						}
						assert nextSet == false;
					}
					if (nextSet) {
						nextSet = false;
						return next;
					}
					return inner.next();
				}
				if (!nextSet) {
					next = inner.next();
				} else {
					nextSet = false;
				}
				if (object==null ? next==null : object.equals(next)) {
					excludedIndex = i;
					excludedIndexSet = true;
					next = inner.next();
				}
				assert !nextSet && !(object==null ? next==null : object.equals(next));
				return next;
			}
		}
	
		/**
		 * {@link ListIterator} that excludes a given object.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class ExcludingOrderedSetListIterator extends WrappedListIterator {
		
			protected int i = -1;
			protected E next = null;
			protected boolean nextSet = false;
			protected E prev = null;
			protected boolean prevSet = false;
		
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
				super(index > 0 ? index-1 : index);
				if (index > 0) {
					this.i = index-2;
					next();
				} else {
					this.i = index-1;
				}
			}
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedIterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				if (excludedIndexSet) {
					return i < excludedIndex || inner.hasNext();
				}
				if (!nextSet && inner.hasNext()) {
					next = inner.next(); // support null values for next
					nextSet = true;
				}
				if (nextSet && (object==null ? next==null : object.equals(next))) {
					excludedIndex = i+1;
					excludedIndexSet = true;
					if (inner.hasNext()) {
						next = inner.next();
						assert !(object==null ? next==null : object.equals(next));
					}
				}
				final boolean hasNext = nextSet && !(object==null ? next==null : object.equals(next));
				if (!hasNext && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasNext;
			}
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedIterator#next()
			 */
			@Override
			public E next() {
				i++;
				if (excludedIndexSet) {
					if (i == excludedIndex) {
						// Skip value
						if (nextSet) {
							nextSet = false;
							assert nextSet == false;
						} else {
							inner.next();
						}
					}
					if (nextSet) {
						nextSet = false;
						return next;
					}
					return inner.next();
				}
				if (!nextSet) {
					next = inner.next();
				} else {
					nextSet = false;
				}
				if (object==null ? next==null : object.equals(next)) {
					excludedIndex = i;
					excludedIndexSet = true;
					next = inner.next();
				}
				assert !nextSet && !(object==null ? next==null : object.equals(next));
				return next;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#nextIndex()
			 */
			@Override
			public int nextIndex() {
				return i+1;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#hasPrevious()
			 */
			@Override
			public boolean hasPrevious() {
				if (excludedIndexSet) {
					return i > excludedIndex || inner.hasPrevious();
				}
				if (!prevSet && inner.hasPrevious()) {
					prev = inner.previous(); // support null values for next
					prevSet = true;
				}
				if (prevSet && (object==null ? prev==null : object.equals(prev))) {
					excludedIndex = i;
					excludedIndexSet = true;
					if (inner.hasPrevious()) {
						prev = inner.previous();
						assert !(object==null ? prev==null : object.equals(prev));
					}
				}
				final boolean hasPrev = prevSet && !(object==null ? prev==null : object.equals(prev));
				if (!hasPrev && !excludedIndexSet) {
					excludedIndex = -1;
					excludedIndexSet = true;
				}
				return hasPrev;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previous()
			 */
			@Override
			public E previous() {
				if (excludedIndexSet) {
					if (i == excludedIndex) {
						// Skip value
						if (prevSet) {
							prevSet = false;
							assert prevSet == false;
						} else {
							inner.previous();
						}
					}
					i--;
					if (prevSet) {
						prevSet = false;
						return prev;
					}
					return inner.previous();
				}
				if (!prevSet) {
					prev = inner.previous();
				} else {
					prevSet = false;
				}
				if (object==null ? prev==null : object.equals(prev)) {
					excludedIndex = i;
					excludedIndexSet = true;
					prev = inner.previous();
				}
				assert !prevSet && !(object==null ? prev==null : object.equals(prev));
				i--;
				return prev;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.WrappedListIterator#previousIndex()
			 */
			@Override
			public int previousIndex() {
				return i;
			}
		}

		protected final E object;
		protected int excludedIndex;
		protected boolean excludedIndexSet = false;
	
		public ExcludingOrderedSet(final E object, final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.object = object;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(final Object o) {
			return !(object==null ? o==null : object.equals(o)) && 
					((Collection<E>) dataSource).contains(o);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#count(java.lang.Object)
		 */
		@Override
		public int count(final E o) {
			return (object==null ? o==null : object.equals(o)) ? 0 : 
					((LazyCollection<E>) dataSource).count(o);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return !iterator().hasNext();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((Collection<E>) dataSource).iterator();
			}
			return new ExcludingOrderedSetIterator();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>) dataSource).size();
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>) dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			return size - (excludedIndex > -1 ? 1 : 0);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#first()
		 */
		@Override
		public E first() {
			return iterator().next();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>) dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			final int size = ((Collection<E>) dataSource).size();
			return ((List<E>) dataSource).get(size - (excludedIndex == size-1 ? 2 : 1));
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>) dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			if (index < excludedIndex || excludedIndex < 0) {
				return ((List<E>) dataSource).get(index);
			}
			assert excludedIndex >= 0;
			return ((List<E>) dataSource).get(index+1);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			if (object==null ? o==null : object.equals(o)) {
				return -1;
			}
			if (!excludedIndexSet) {
				excludedIndex = ((List<E>) dataSource).indexOf(object);
				excludedIndexSet = true;
			}
			assert excludedIndexSet;
			final int index = ((List<E>) dataSource).indexOf(o);
			if (index < excludedIndex || excludedIndex < 0) {
				return index;
			}
			assert excludedIndex >= 0;
			return (index > -1) ? index-1 : -1;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((List<E>) dataSource).listIterator();
			}
			return new ExcludingOrderedSetListIterator();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			if (excludedIndexSet && excludedIndex < 0) {
				return ((List<E>) dataSource).listIterator(index);
			}
			return new ExcludingOrderedSetListIterator(index);
		}
	
	}

	public static class ReverseOrderedSet<E> extends NonCachingOrderedSet<E> {

		protected final int last;
	
		public ReverseOrderedSet(final LazyOrderedSet<E> dataSource) {
			super(dataSource);
			this.last = dataSource.size() - 1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#first()
		 */
		@Override
		public E first() {
			return ((List<E>) dataSource).get(last);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#last()
		 */
		@Override
		public E last() {
			return ((List<E>) dataSource).get(0);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#get(int)
		 */
		@Override
		public E get(final int index) {
			return ((List<E>) dataSource).get(last - index);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(final Object o) {
			final int index = ((List<E>) dataSource).indexOf(o);
			if (index > -1) {
				return last - index;
			}
			return -1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#lastIndexOf(java.lang.Object)
		 */
		@Override
		public int lastIndexOf(final Object o) {
			final int index = ((List<E>) dataSource).lastIndexOf(o);
			if (index > -1) {
				return last - index;
			}
			return -1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(final Object o) {
			return ((List<E>) dataSource).contains(o);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return ((List<E>) dataSource).isEmpty();
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new ReverseIterator(last);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			return last+1;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new ReverseListIterator(last);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(final int index) {
			return new ReverseListIterator(last, index);
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
	 * @param dataSource
	 */
	public LazyOrderedSet(final Iterable<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	@Override
	protected void createCache() {
		super.createCache();
		if (this.cache == null) {
			this.cache = new ArrayList<E>();
		}
		assert this.cache instanceof List<?>;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return cache.iterator();
		}
		return new CachingSetIterator();
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#get(int)
	 */
	public E get(int index) {
		if (index < cache.size()) {
			return ((List<E>) cache).get(index);
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

	/*
	 * (non-Javadoc)
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		if (dataSource == null) { // cache complete
			return ((List<E>) cache).indexOf(o);
		}
		int i = 0;
		for (E e : this) {
			if (e == o) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return indexOf(o); // elements occur only once
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<E> listIterator() {
		if (dataSource == null) { // cache complete
			return ((List<E>) cache).listIterator();
		}
		return new IteratorToListIterator();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<E> listIterator(int index) {
		if (dataSource == null) { // cache complete
			return ((List<E>) cache).listIterator(index);
		}
		return new IteratorToListIterator(index);
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <p><i>Lazy implementation of {@link List#subList(int, int)}.</i></p>
	 * {@inheritDoc}
	 */
	public List<E> subList(final int fromIndex, final int toIndex) {
		return new SubOrderedSet<E>(fromIndex, toIndex, this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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
		final Iterator<?> e2 = ((Collection<?>) o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
		    E o1 = e1.next();
		    Object o2 = e2.next();
		    if (!(o1==null ? o2==null : o1.equals(o2)))
			return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// List hashcode (shifted)
		int hashCode = 1;
		for (E obj : this) {
		    hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
		}
		// Set hashcode (to distinguish from plain Lists)
		for (E obj : this) {
            if (obj != null) {
                hashCode += obj.hashCode();
            }
		}
		return hashCode;
	}

	/**
	 * Returns the number of occurrences of <code>object</code> in self.<br>
	 * <code>post: result &lt;= 1</code>
	 * @param o
	 * @return The number of occurrences of <code>object</code> in self.
	 */
	public int count(final E o) {
		return contains(o) ? 1 : 0;
	}

	/**
	 * Returns the <code>i</code>-th element of this list.
	 * List index starts at 1.
	 * @param i
	 * @return The <code>i</code>-th element of this list.
	 */
	public E at(final int i) {
		return get(i-1);
	}

	/**
	 * Returns the index of object <code>obj</code> in the sequence.
	 * List index starts at 1.<br>
	 * pre : <code>self->includes(obj)</code><br>
	 * post : <code>self->at(i) = obj</code>
	 * @param obj
	 * @return The index of object <code>obj</code> in the sequence.
	 * @throws IndexOutOfBoundsException if <code>obj</code> is not contained in this list.
	 */
	public int indexOf2(final Object obj) {
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
	 * @param obj
	 * @return The last index of object <code>obj</code> in the sequence.
	 * @throws IndexOutOfBoundsException if <code>obj</code> is not contained in this list.
	 */
	public int lastIndexOf2(final Object obj) {
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
			return ((List<E>) cache).get(0);
		}
		assert cache.size() == 0;
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
			return ((List<E>) cache).get(size-1);
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
	 * @param s
	 * @return The union of self and <code>s</code>.
	 */
	public LazyOrderedSet<E> union(final LazyOrderedSet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new UnionSetIterator(s);
			}
		};
	}

	/**
	 * Returns the union of self and <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The union of self and <code>s</code>.
	 */
	public LazySet<E> union(final LazySet<E> s) {
		return new LazySet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new UnionSetIterator(s);
			}
		};
	}

	/**
	 * Returns the union of self and <code>bag</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param bag
	 * @return The union of self and <code>bag</code>.
	 */
	public LazyBag<E> union(final LazyBag<E> bag) {
		return new LazyBag.UnionBag<E>(bag, this);
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazyOrderedSet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazySet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The intersection of self and <code>s</code> (i.e, the set of all elements that are in both self and <code>s</code>).
	 */
	public LazyOrderedSet<E> intersection(final LazyBag<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new IntersectionIterator(s);
			}
		};
	}

	/**
	 * Returns the elements of self, which are not in <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The elements of self, which are not in <code>s</code>.
	 */
	public LazyOrderedSet<E> subtract(final LazyOrderedSet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new SubtractionIterator(s);
			}
		};
	}

	/**
	 * Returns the elements of self, which are not in <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s
	 * @return The elements of self, which are not in <code>s</code>.
	 */
	public LazyOrderedSet<E> subtract(final LazySet<E> s) {
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
				}
				return new SubtractionIterator(s);
			}
		};
	}

	/**
	 * Returns the set containing all elements of self plus <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object
	 * @return The set containing all elements of self plus <code>object</code>
	 */
	public LazyOrderedSet<E> including(final E object) {
		return append(object);
	}

	/**
	 * Returns the set containing all elements of self without <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object
	 * @return The set containing all elements of self without <code>object</code>.
	 */
	public LazyOrderedSet<E> excluding(final E object) {
		return new ExcludingOrderedSet<E>(object, this);
	}

	/**
	 * Returns the set containing all the elements that are in self or <code>s</code>, but not in both.
	 * <p><i>Lazy operation.</i></p>
	 * @param s
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
			public Iterator<Object> iterator() {
				return new FlattenSetIterator(inner);
			}
		});
	}

	/**
	 * Returns the set of elements, consisting of all elements of self, followed by <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object
	 * @return The set of elements, consisting of all elements of self, followed by <code>object</code>.
	 */
	public LazyOrderedSet<E> append(final E object) {
		return new AppendOrderedSet<E>(object, this);
	}

	/**
	 * Returns the OrderedSet consisting of <code>object</code>, followed by all elements in self.
	 * <p><i>Lazy operation.</i></p>
	 * @param object
	 * @return The OrderedSet consisting of <code>object</code>, followed by all elements in self.
	 */
	public LazyOrderedSet<E> prepend(final E object) {
		return new PrependOrderedSet<E>(object, this);
	}

	/**
	 * Returns the OrderedSet consisting of self with <code>object</code> inserted at position <code>index</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param index
	 * @param object
	 * @return The OrderedSet consisting of self with <code>object</code> inserted at position <code>index</code>.
	 */
	public LazyOrderedSet<E> insertAt(final int index, final E object) {
		return new InsertAtOrderedSet<E>(object, index-1, this);
	}

	/**
	 * Returns the sub-set of self starting at number <code>lower</code>, up to and including element number <code>upper</code>.
	 * List index starts at 1.
	 * <p><i>Lazy operation.</i></p>
	 * @param lower
	 * @param upper
	 * @return The sub-set of self starting at number <code>lower</code>, up to and including element number <code>upper</code>. 
	 */
	public LazyOrderedSet<E> subSequence(final int lower, final int upper) {
		return new SubOrderedSet<E>(lower-1, upper, this);
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
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
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
		return new LazyOrderedSet<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return cache.iterator();
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
	 */
	public <T> LazyList<T> collect(final CodeBlock function) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = function.getParentFrame();
		final LazyOrderedSet<E> inner = this;
		return new LazyList<T>(new Iterable<T>() {
			public Iterator<T> iterator() {
				return new CollectIterator<T>(inner, function, parentFrame);
			}
		});
	}

	//TODO provide other iterator operations: collectNested, sortedBy

}
