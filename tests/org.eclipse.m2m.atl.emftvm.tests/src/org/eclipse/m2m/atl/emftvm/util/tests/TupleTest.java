/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.util.Tuple;

/**
 * Tests {@link Tuple}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class TupleTest extends TestCase {

	/**
	 * Tests String::toDate(format : String) : Date.
	 */
	public void testToDate() {
		final Map<String, Object> values = new HashMap<String, Object>();
		values.put("timezone", "CET");
		values.put("language", "NL");
		values.put("country", "BE");
		values.put("year", Integer.valueOf(2013));
		values.put("month", Integer.valueOf(Calendar.MARCH));
		values.put("day_of_month", Integer.valueOf(3));
		values.put("hour_of_day", Integer.valueOf(13));
		values.put("minute", Integer.valueOf(25));
		final Tuple tuple = new Tuple(values);
		final Date date = tuple.toDate();
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("CET"), new Locale("NL", "BE"));
		cal.setTime(date);
		assertEquals(2013, cal.get(Calendar.YEAR));
		assertEquals(Calendar.MARCH, cal.get(Calendar.MONTH));
		assertEquals(3, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(13, cal.get(Calendar.HOUR_OF_DAY));
		assertEquals(25, cal.get(Calendar.MINUTE));
		assertEquals(0, cal.get(Calendar.SECOND));
		assertEquals(0, cal.get(Calendar.MILLISECOND));
	}

	/**
	 * Tests Tuple::fromCalendar(cal : Calendar) : Tuple.
	 */
	public void testFromCalendar() {
		final Calendar cal = Calendar.getInstance();
		final Tuple tuple = Tuple.fromCalendar(cal);
		assertEquals(tuple.get("timezone"), cal.getTimeZone().getID());
		assertEquals(tuple.get("year"), cal.get(Calendar.YEAR));
		assertEquals(tuple.get("month"), cal.get(Calendar.MONTH));
		assertEquals(tuple.get("day_of_month"), cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(tuple.get("day_of_week"), cal.get(Calendar.DAY_OF_WEEK));
		assertEquals(tuple.get("day_of_week_in_month"), cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		assertEquals(tuple.get("day_of_year"), cal.get(Calendar.DAY_OF_YEAR));
		assertEquals(tuple.get("era"), cal.get(Calendar.ERA));
		assertEquals(tuple.get("hour"), cal.get(Calendar.HOUR));
		assertEquals(tuple.get("hour_of_day"), cal.get(Calendar.HOUR_OF_DAY));
		assertEquals(tuple.get("minute"), cal.get(Calendar.MINUTE));
		assertEquals(tuple.get("second"), cal.get(Calendar.SECOND));
		assertEquals(tuple.get("millisecond"), cal.get(Calendar.MILLISECOND));
		assertEquals(tuple.get("am_pm"), cal.get(Calendar.AM_PM));
		assertEquals(tuple.get("week_of_month"), cal.get(Calendar.WEEK_OF_MONTH));
		assertEquals(tuple.get("week_of_year"), cal.get(Calendar.WEEK_OF_YEAR));
	}

}
