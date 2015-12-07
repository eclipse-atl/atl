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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.util.LazyBag.LongRangeBag;


/**
 * Immutable {@link Set} that supports lazy evaluation.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E> the collection element type
 */
public class LazySet<E> extends LazyCollection<E> implements Set<E> {

	/**
	 * Abstract {@link LazySet} that disables caching of the underlying {@link LazySet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public abstract static class NonCachingSet<E> extends LazySet<E> {

		/**
		 * Creates a {@link NonCachingSet} around <code>dataSource</code>.
		 * @param dataSource the underlying collection
		 */
		public NonCachingSet(final LazySet<E> dataSource) {
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
	 * {@link LazySet} that includes an element into the underlying {@link LazySet},
	 * except if the element already occurs in the underlying {@link LazySet}. 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class IncludingSet<E> extends NonCachingSet<E> {
	
		/**
		 * {@link Iterator} that appends an object to the underlying
		 * collection, except when it already occurs in the underlying collection.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class IncludingSetIterator extends WrappedIterator {
		
			protected final E object;
			protected boolean beforeTail = true;
			protected boolean innerNext; // cache last inner.hasNext() invocation
		
			/**
			 * Creates a new {@link IncludingSetIterator}.
			 * @param object the object to include
			 */
			public IncludingSetIterator(final E object) {
				super();
				this.object = object;
			}
		
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				innerNext = inner.hasNext();
				if (innerNext) {
					return true;
				} else if (beforeTail) {
					if (!containsSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsSet = true;
					}
					assert containsSet;
					return !containsObject;
				}
				return false;
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
					if (!containsSet) {
						containsObject = ((Collection<E>)dataSource).contains(object);
						containsSet = true;
					}
					assert containsSet;
					if (!containsObject) {
						beforeTail = false;
						return object;
					}
				}
				throw new NoSuchElementException();
			}
		}

		protected final E object;
		protected boolean containsObject;
		protected boolean containsSet;

		/**
		 * Creates a new {@link IncludingSet}.
		 * @param object the element to include
		 * @param dataSource the underlying collection
		 */
		public IncludingSet(final E object, final LazySet<E> dataSource) {
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
			return new IncludingSetIterator(object);
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>)dataSource).size();
			if (!containsSet) {
				if (((Collection<E>)dataSource).contains(object)) {
					containsObject = true;
				} else {
					containsObject = false;
				}
				containsSet = true;
			}
			assert containsSet;
			return size + (containsObject ? 0 : 1);
		}
	
	}

	/**
	 * {@link LazySet} that excludes an element from the underlying {@link LazySet}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @param <E> the collection element type
	 */
	public static class ExcludingSet<E> extends NonCachingSet<E> {
	
		/**
		 * {@link ReadOnlyIterator} that excludes a given object.
		 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
		 */
		public class ExcludingSetIterator extends WrappedIterator {
		
			protected E next;
			protected boolean nextSet;
		
			/**
			 * Creates a new {@link ExcludingIterator}.
			 */
			public ExcludingSetIterator() {
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
					containsExcluded = true;
					containsExcludedSet = true;
					if (inner.hasNext()) {
						next = inner.next();
						assert !(object == null ? next == null : object.equals(next));
					}
				}
				final boolean hasNext = nextSet && !(object == null ? next == null : object.equals(next));
				if (!hasNext && !containsExcludedSet) {
					containsExcluded = false;
					containsExcludedSet = true;
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
				if (object == null ? next == null : object.equals(next)) {
					containsExcluded = true;
					containsExcludedSet = true;
					next = inner.next();
				}
				assert !nextSet && next != object;
				return next;
			}
		}

		protected final Object object;
		protected boolean containsExcluded;
		protected boolean containsExcludedSet;
	
		/**
		 * Creates a new {@link ExcludingSet}.
		 * @param object the element to exclude
		 * @param dataSource the underlying collection
		 */
		public ExcludingSet(final Object object, final LazySet<E> dataSource) {
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
			if (containsExcludedSet && !containsExcluded) {
				return ((Collection<E>)dataSource).iterator();
			}
			return new ExcludingSetIterator();
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			final int size = ((Collection<E>)dataSource).size();
			if (!containsExcludedSet) {
				containsExcluded = ((Collection<E>)dataSource).contains(object);
				containsExcludedSet = true;
			}
			return size - (containsExcluded ? 1 : 0);
		}
	
	}

	/**
	 * {@link LazySet} that represents a range running from a first to last {@link Integer}.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class IntegerRangeSet extends LazySet<Integer> {

		protected final int first;
		protected final int last;

		/**
		 * Creates a new {@link IntegerRangeSet}.
		 * 
		 * @param first
		 *            the first object of the range to include
		 * @param last
		 *            the last object of the range to include
		 */
		public IntegerRangeSet(final int first, final int last) {
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
		public boolean contains(Object o) {
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
		public int count(Object object) {
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
	 * {@link LazySet} that represents a range running from a first to last {@link Long}.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class LongRangeSet extends LazySet<Long> {

		protected final long first;
		protected final long last;

		/**
		 * Creates a new {@link LongRangeBag}.
		 * 
		 * @param first
		 *            the first object of the range to include
		 * @param last
		 *            the last object of the range to include
		 */
		public LongRangeSet(final long first, final long last) {
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
		public boolean contains(Object o) {
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
		public int count(Object object) {
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
	 * Creates an empty {@link LazySet}.
	 */
	public LazySet() {
		super();
	}

	/**
	 * Creates a {@link LazySet} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazySet(final Iterable<E> dataSource) {
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
			this.cache = new LinkedHashSet<E>(); // caching iterators require deterministic order
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return Collections.unmodifiableCollection(cache).iterator();
		}
		return new CachingSetIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object o) {
		if (o == this) {
		    return true;
		}
		if (!(o instanceof Set<?>)) {
		    return false;
		}
        try {
			final Collection<?> other = (Collection<?>) o;
			return containsAll(other) && other.containsAll(this);
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hashCode = 0;
		for (E obj : this) {
            if (obj != null) {
                hashCode += obj.hashCode();
            }
		}
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public String asString(final ExecEnv env) {
		return appendElements(new StringBuffer("Set{"), env).append('}').toString();
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

	/* *********************************************************************
	 * Lazy operations                                                     *
	 * *********************************************************************/

	/**
	 * Returns the union of self and <code>s</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param s the collection to union with self
	 * @return The union of self and <code>s</code>.
	 */
	public LazySet<E> union(final LazySet<? extends E> s) {
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
	public LazySet<E> intersection(final LazySet<E> s) {
		return new LazySet<E>(this) {
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
	public LazySet<E> intersection(final LazyBag<E> s) {
		return new LazySet<E>(this) {
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
	public LazySet<E> subtract(final LazySet<E> s) {
		return new LazySet<E>(this) {
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
	 * @param object the object to include
	 * @return The set containing all elements of self plus <code>object</code>
	 */
	public LazySet<E> including(final E object) {
		return new IncludingSet<E>(object, this);
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
	public LazySet<E> including(final E object, final int index) {
		throw new UnsupportedOperationException("Cannot specify index for adding values to unordered collections");
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
	public LazySet<E> includingAll(final Collection<? extends E> coll) {
		return union(LazyCollections.asLazySet(coll));
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
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LazySet<E> includingAll(final Collection<? extends E> coll, final int index) {
		throw new UnsupportedOperationException("Cannot specify index for adding values to unordered collections");
	}

	/**
	 * Returns the set containing all elements of self without <code>object</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 * 
	 * @param object
	 *            the object to exclude
	 * @return The set containing all elements of self without <code>object</code>.
	 */
	public LazySet<E> excluding(final Object object) {
		return new ExcludingSet<E>(object, this);
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
	public LazySet<E> excludingAll(final Collection<?> coll) {
		return new LazySet<E>(this) {
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
	public LazySet<E> symmetricDifference(final LazySet<E> s) {
		return union(s).subtract(intersection(s));
	}

	/**
	 * If the element type is not a collection type this results in the same self.
	 * If the element type is a collection type, the result is the set
	 * containing all the elements of all the elements of self.
	 * <p><i>Lazy operation.</i></p>
	 * @return <b>if</b> self.type.elementType.oclIsKindOf(CollectionType) <b>then</b><br>
	 * &nbsp;&nbsp;self-&gt;iterate(c; acc : Set() = Set{} |<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;acc-&gt;union(c-&gt;asSet() ) )<br>
	 * <b>else</b><br>
	 * &nbsp;&nbsp;self<br>
	 * <b>endif</b>
	 */
	public LazySet<?> flatten() {
		final LazySet<E> inner = this;
		return new LazySet<Object>(new Iterable<Object>() {
			public Iterator<Object> iterator() {
				return new FlattenSetIterator(inner);
			}
		});
	}

	/**
	 * Returns a Set identical to self. This operation exists for convenience reasons.
	 * <p><i>Lazy operation.</i></p>
	 * @return A Set identical to self. This operation exists for convenience reasons.
	 */
	@Override
	public LazySet<E> asSet() {
		return this;
	}

	/**
	 * Returns the Set containing all elements of self plus the Set of <code>first</code> running to <code>last</code>.
	 * <p>
	 * <i>Lazy operation.</i>
	 * </p>
	 * 
	 * @param first
	 *            the first object of the range to include
	 * @param last
	 *            the last object of the range to include
	 * @return The Set containing all elements of self plus the Set of <code>first</code> running to <code>last</code>
	 */
	@SuppressWarnings("unchecked")
	public LazySet<E> includingRange(final E first, final E last) {
		if (first instanceof Integer && last instanceof Integer) {
			return union((LazySet<E>) new IntegerRangeSet((Integer)first, (Integer)last));
		}
		if (first instanceof Long && last instanceof Long) {
			return union((LazySet<E>) new LongRangeSet((Long)first, (Long)last));
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
	 * @return a new lazy set with only the selected elements.
	 */
	public LazySet<E> select(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		condition.setParentFrame(null);
		return new LazySet<E>(this) {
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
	 * @return a new lazy set without the rejected elements.
	 */
	public LazySet<E> reject(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		condition.setParentFrame(null);
		return new LazySet<E>(this) {
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
	 * @return a new lazy bag with the <code>function</code> return values.
	 * @param <T> the element type
	 */
	public <T> LazyBag<T> collect(final CodeBlock function) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = function.getParentFrame();
		function.setParentFrame(null);
		final LazySet<E> inner = this;
		return new LazyBag<T>(new Iterable<T>() {
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
					for (Object o : innerCopy) {
						elementsToKeys.put(o, sortingKeys.next());
					}
					assert !sortingKeys.hasNext();
					Arrays.sort(innerCopy, new Comparator<Object>() {
						public int compare(Object o1, Object o2) {
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

	//TODO provide other iterator operations: collectNested

}
