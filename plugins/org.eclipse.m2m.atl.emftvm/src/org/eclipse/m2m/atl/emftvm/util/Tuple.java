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

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * Reflective, immutable implementation of OCL Tuples.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class Tuple {

	/**
	 * Creates a new {@link Tuple} from <code>map</code>.
	 * 
	 * @param map
	 *            the {@link Map} with tuple data
	 * @return a new {@link Tuple} from <code>map</code>
	 */
	public static Tuple fromMap(final Map<String, Object> map) {
		return new Tuple(map);
	}

	/**
	 * Returns a new {@link Tuple} from <code>cal</code>. Supported fields: timezone, year, month, day_of_month, day_of_week, day_of_week_in_month,
	 * day_of_year, era, hour, hour_of_day, minute, second, millisecond, am_pm, week_of_month, week_of_year.
	 * 
	 * @param cal
	 *            the input {@link Calendar}
	 * @return a new {@link Tuple} from <code>cal</code>
	 */
	public static Tuple fromCalendar(final Calendar cal) {
		final Map<String, Object> values = new HashMap<String, Object>();
		values.put("timezone", cal.getTimeZone().getID());
		values.put("year", cal.get(Calendar.YEAR));
		values.put("month", cal.get(Calendar.MONTH));
		values.put("day_of_month", cal.get(Calendar.DAY_OF_MONTH));
		values.put("day_of_week", cal.get(Calendar.DAY_OF_WEEK));
		values.put("day_of_week_in_month", cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		values.put("day_of_year", cal.get(Calendar.DAY_OF_YEAR));
		values.put("era", cal.get(Calendar.ERA));
		values.put("hour", cal.get(Calendar.HOUR));
		values.put("hour_of_day", cal.get(Calendar.HOUR_OF_DAY));
		values.put("minute", cal.get(Calendar.MINUTE));
		values.put("second", cal.get(Calendar.SECOND));
		values.put("millisecond", cal.get(Calendar.MILLISECOND));
		values.put("am_pm", cal.get(Calendar.AM_PM));
		values.put("week_of_month", cal.get(Calendar.WEEK_OF_MONTH));
		values.put("week_of_year", cal.get(Calendar.WEEK_OF_YEAR));
		return new Tuple(values);
	}

	private final Map<String, Object> values;

	/**
	 * Creates a new empty {@link Tuple}.
	 */
	public Tuple() {
		values = Collections.emptyMap();
	}

	/**
	 * Creates a new {@link Tuple} initialized with the given <code>map</code>.
	 * 
	 * @param map
	 *            the map with tuple key-value pairs
	 */
	public Tuple(Map<String, Object> map) {
		values = Collections.unmodifiableMap(map);
	}

	/**
	 * Returns the value for <code>name</code>.
	 * 
	 * @param name
	 *            the element name
	 * @return the value for <code>name</code>
	 */
	public Object get(Object name) {
		return values.get(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Tuple " + values.toString(); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		return (o instanceof Tuple) ? values.equals(((Tuple) o).values) : false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return values.hashCode();
	}

	/**
	 * Returns this {@link Tuple}'s value map.
	 * 
	 * @return this {@link Tuple}'s value map
	 */
	public Map<String, Object> asMap() {
		return values;
	}

	/**
	 * Returns a {@link Date} instance using the fields of this tuple. Supported fields: timezone, language, country, variant, year, month,
	 * day_of_month, day_of_week, day_of_week_in_month, day_of_year, era, hour, hour_of_day, minute, second, millisecond, am_pm,
	 * week_of_month, week_of_year.
	 * 
	 * @return a {@link Date} instance using the fields of this tuple
	 * @see Calendar
	 */
	public Date toDate() {
		TimeZone tz = null;
		if (values.containsKey("timezone")) {
			tz = TimeZone.getTimeZone((String) values.get("timezone"));
		}

		Locale locale = null;
		if (values.containsKey("language")) {
			if (values.containsKey("country")) {
				if (values.containsKey("variant")) {
					locale = new Locale((String) values.get("language"), (String) values.get("country"), (String) values.get("variant"));
				} else {
					locale = new Locale((String) values.get("language"), (String) values.get("country"));
				}
			} else {
				locale = new Locale((String) values.get("language"));
			}
		}

		final Calendar cal;
		if (locale != null && tz != null) {
			cal = Calendar.getInstance(tz, locale);
		} else if (locale != null) {
			cal = Calendar.getInstance(locale);
		} else if (tz != null) {
			cal = Calendar.getInstance(tz);
		} else {
			cal = Calendar.getInstance();
		}

		cal.setTimeInMillis(0);
		if (values.containsKey("year")) {
			cal.set(Calendar.YEAR, (Integer) values.get("year"));
		}
		if (values.containsKey("month")) {
			cal.set(Calendar.MONTH, (Integer) values.get("month"));
		}
		if (values.containsKey("day_of_month")) {
			cal.set(Calendar.DAY_OF_MONTH, (Integer) values.get("day_of_month"));
		}
		if (values.containsKey("day_of_week")) {
			cal.set(Calendar.DAY_OF_WEEK, (Integer) values.get("day_of_week"));
		}
		if (values.containsKey("day_of_week_in_month")) {
			cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, (Integer) values.get("day_of_week_in_month"));
		}
		if (values.containsKey("day_of_year")) {
			cal.set(Calendar.DAY_OF_YEAR, (Integer) values.get("day_of_year"));
		}
		if (values.containsKey("era")) {
			cal.set(Calendar.ERA, (Integer) values.get("era"));
		}
		if (values.containsKey("hour")) {
			cal.set(Calendar.HOUR, (Integer) values.get("hour"));
		}
		if (values.containsKey("hour_of_day")) {
			cal.set(Calendar.HOUR_OF_DAY, (Integer) values.get("hour_of_day"));
		}
		if (values.containsKey("minute")) {
			cal.set(Calendar.MINUTE, (Integer) values.get("minute"));
		}
		if (values.containsKey("second")) {
			cal.set(Calendar.SECOND, (Integer) values.get("second"));
		}
		if (values.containsKey("millisecond")) {
			cal.set(Calendar.MILLISECOND, (Integer) values.get("millisecond"));
		}
		if (values.containsKey("am_pm")) {
			cal.set(Calendar.AM_PM, (Integer) values.get("am_pm"));
		}
		if (values.containsKey("week_of_month")) {
			cal.set(Calendar.WEEK_OF_MONTH, (Integer) values.get("week_of_month"));
		}
		if (values.containsKey("week_of_year")) {
			cal.set(Calendar.WEEK_OF_YEAR, (Integer) values.get("week_of_year"));
		}

		return cal.getTime();
	}
}
