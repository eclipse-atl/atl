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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.emftvm.CodeBlock;


/**
 * Immutable {@link Collection} that supports lazy evaluation.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazyBag<E> extends LazyCollection<E> {

	/**
	 * {@link LazyBag} that implements the "including" operation.
	 */
	public static class IncludingBag<E> extends LazyBag<E> {

		protected final E object;

		/**
		 * Creates a new {@link IncludingBag}.
		 * @param object the object to include
		 * @param dataSource the underlying collection
		 */
		public IncludingBag(final E object, final LazyCollection<E> dataSource) {
			super(dataSource);
			this.object = object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(Object o) {
			return (object == null ? o == null : object.equals(o)) || 
					((Collection<E>)dataSource).contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(E o) {
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

	}

	/**
	 * {@link LazyBag} that implements the "union" operation.
	 */
	public static class UnionBag<E> extends LazyBag<E> {

		protected final LazyCollection<E> other;

		/**
		 * Creates a new {@link UnionBag}.
		 * @param other the collection to union with <pre>dataSource</pre>
		 * @param dataSource the underlying collection
		 */
		public UnionBag(final LazyCollection<E> other, final LazyCollection<E> dataSource) {
			super(dataSource);
			this.other = other;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(Object o) {
			return ((Collection<E>)dataSource).contains(o) || other.contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int count(E object) {
			return ((LazyCollection<E>)dataSource).count(object) + other.count(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return ((Collection<?>)dataSource).isEmpty() && other.isEmpty();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new UnionIterator(other);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return ((Collection<E>)dataSource).size() + other.size();
		}

	}

	/**
	 * {@link ReadOnlyIterator} that returns only elements contained in both underlying collections,
	 * where the element occurs as often as in the collection with the least occurrences of the element.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class BagIntersectionIterator extends CachingIterator {

		final Collection<E> s;
		final Map<E, Integer> sOcc;
		E next;
		boolean nextSet;

		/**
		 * Creates a new {@link BagIntersectionIterator} on this and <code>s</code>.
		 * @param s the collection to intersect with this
		 */
		public BagIntersectionIterator(final LazyCollection<E> s) {
			super(dataSource.iterator());
			this.s = s;
			if (s.occurrences != null) {
				sOcc = new HashMap<E, Integer>(s.occurrences);
			} else {
				sOcc = new HashMap<E, Integer>();
				for (E e : s) {
					if (sOcc.containsKey(e)) {
						sOcc.put(e, sOcc.get(e) + 1);
					} else {
						sOcc.put(e, 1);
					}
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
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
			while (nextSet && (!sOcc.containsKey(next) || sOcc.get(next) == 0) && inner.hasNext()) {
				next = inner.next();
			}
			final boolean hasNext = nextSet && sOcc.containsKey(next) && sOcc.get(next) > 0;
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
			} else {
				nextSet = false;
			}
			while (!sOcc.containsKey(next) || sOcc.get(next) == 0) {
				next = inner.next();
			}
			assert !nextSet && sOcc.containsKey(next) && sOcc.get(next) > 0;
			sOcc.put(next, sOcc.get(next) - 1);
			updateCache(next);
			return next;
		}
		
	}

	/**
	 * Creates an empty {@link LazyBag}.
	 */
	public LazyBag() {
		super();
	}

	/**
	 * Creates a {@link LazyBag} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyBag(Iterable<E> dataSource) {
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
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object o) {
		if (o == this) {
		    return true;
		}
		if (!(o instanceof LazyCollection<?>)) {
		    return false;
		}
        try {
        	final LazyCollection<E> other = (LazyCollection<E>)o;
        	final LazySet<E> keys = asSet().union(other.asSet());
            for (E e : keys) {
            	if (count(e) != other.count(e)) {
            		return false;
            	}
            }
            return true;
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

	/* *********************************************************************
	 * Lazy operations                                                     *
	 * *********************************************************************/

	/**
	 * Returns the union of self and <code>bag</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param bag the collection to union with this
	 * @return The union of self and <code>bag</code>.
	 */
	public LazyBag<E> union(final LazyBag<E> bag) {
		return new UnionBag<E>(bag, this);
	}

	/**
	 * Returns the union of self and <code>set</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param set the collection to union with this
	 * @return The union of self and <code>set</code>.
	 */
	public LazyBag<E> union(final LazySet<E> set) {
		return new UnionBag<E>(set, this);
	}

	/**
	 * Returns the intersection of self and <code>bag</code>
	 * (i.e, the bag of all elements that are in both self and <code>s</code>,
	 * where the element occurs as often as in the bag with the least element occurrences).
	 * <p><i>Lazy operation.</i></p>
	 * @param bag the collection to intersect with this
	 * @return The intersection of self and <code>bag</code>.
	 */
	public LazyBag<E> intersection(final LazyBag<E> bag) {
		return new LazyBag<E>(this) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new BagIntersectionIterator(bag);
			}
		};
	}

	/**
	 * Returns the intersection of self and <code>set</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param set the collection to intersect with this
	 * @return The intersection of self and <code>set</code>.
	 */
	public LazySet<E> intersection(final LazySet<E> set) {
		final LazyBag<E> inner = this;
		return new LazySet<E>(set) {
			@Override
			public Iterator<E> iterator() {
				if (dataSource == null) {
					return Collections.unmodifiableCollection(cache).iterator();
				}
				return new IntersectionIterator(inner);
			}
		};
	}

	/**
	 * Returns the bag containing all elements of self plus <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to include
	 * @return The bag containing all elements of self plus <code>object</code>.
	 */
	public LazyBag<E> including(final E object) {
		return new IncludingBag<E>(object, this);
	}

	/**
	 * Returns the bag containing all elements of self apart from all occurrences of <code>object</code>.
	 * <p><i>Lazy operation.</i></p>
	 * @param object the object to exclude
	 * @return The bag containing all elements of self apart from all occurrences of <code>object</code>.
	 */
	public LazyBag<E> excluding(final E object) {
		return new LazyBag<E>(this) {
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
	 * If the element type is not a collection type this results in the same self.
	 * If the element type is a collection type, the result is the sequence
	 * containing all the elements of all the elements of self.
	 * The order of the elements is partial.
	 * <p><i>Lazy operation.</i></p>
	 * @return <b>if</b> self.type.elementType.oclIsKindOf(CollectionType) <b>then</b><br>
	 * &nbsp;&nbsp;self-&gt;iterate(c; acc : Bag() = Bag{} |<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;acc-&gt;union(c-&gt;asBag() ) )<br>
	 * <b>else</b><br>
	 * &nbsp;&nbsp;self<br>
	 * <b>endif</b>
	 */
	public LazyBag<?> flatten() {
		final LazyBag<E> inner = this;
		return new LazyBag<Object>(new Iterable<Object>() {
			public Iterator<Object> iterator() {
				return new FlattenIterator(inner);
			}
		});
	}

	/**
	 * Returns a Bag identical to self. This operation exists for convenience reasons.
	 * <p><i>Lazy operation.</i></p>
	 * @return A Bag identical to self. This operation exists for convenience reasons.
	 */
	@Override
	public LazyBag<E> asBag() {
		return this;
	}

	/* *********************************************************************
	 * Lazy, higher-order operations                                       *
	 * *********************************************************************/

	/**
	 * Selects all elements from this collection for which the
	 * <code>condition</code> evaluates to <code>true</code>.
	 * @param condition the condition function
	 * @return a new lazy bag with only the selected elements.
	 */
	public LazyBag<E> select(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		return new LazyBag<E>(this) {
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
	 * @return a new lazy bag without the rejected elements.
	 */
	public LazyBag<E> reject(final CodeBlock condition) {
		// Parent frame may change after this method returns!
		final StackFrame parentFrame = condition.getParentFrame();
		return new LazyBag<E>(this) {
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
		final LazyBag<E> inner = this;
		return new LazyBag<T>(new Iterable<T>() {
			public Iterator<T> iterator() {
				return new CollectIterator<T>(inner, function, parentFrame);
			}
		});
	}

	//TODO provide other iterator operations: collectNested, sortedBy

}
