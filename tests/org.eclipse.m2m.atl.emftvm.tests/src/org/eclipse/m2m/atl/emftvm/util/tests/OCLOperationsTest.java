/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.OCLOperations;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.Tuple;
import org.eclipse.m2m.atl.emftvm.util.Types;

/**
 * Tests {@link OCLOperations}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class OCLOperationsTest extends TestCase {

	/**
	 * Tests OclAny::debug().
	 */
	public void testOclAnyDebug() {
		final Operation debug = findOperation("debug", Types.OCL_ANY_TYPE, new String[][] {}, false);
		assertNotNull(debug);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), debug.getBody());
		final Object object = new Object();
		frame.setLocals(new Object[] { object });
		final Object result = debug.getBody().execute(frame);
		assertSame(object, result);
	}

	/**
	 * Tests OclAny::debug(message : String).
	 */
	public void testOclAnyDebug_String() {
		final Operation debug = findOperation("debug", Types.OCL_ANY_TYPE, new String[][] { Types.STRING_TYPE }, false);
		assertNotNull(debug);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), debug.getBody());
		final Object object = new Object();
		frame.setLocals(new Object[] { object, "message" });
		final Object result = debug.getBody().execute(frame);
		assertSame(object, result);
	}

	/**
	 * Tests Class::refNewInstance(args : Sequence).
	 */
	public void testClassRefNewInstance() {
		final Operation refNewInstance = findOperation("refNewInstance", Types.JAVA_CLASS_TYPE, new String[][] { Types.SEQUENCE_TYPE },
				false);
		assertNotNull(refNewInstance);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), refNewInstance.getBody());
		final long currentTimeMillis = System.currentTimeMillis();
		frame.setLocals(new Object[] { Date.class, new LazyList<Object>().append(currentTimeMillis) });
		final Date date = (Date) refNewInstance.getBody().execute(frame);
		assertEquals(currentTimeMillis, date.getTime());
	}

	/**
	 * Tests String::toDate(format : String).
	 */
	public void testStringToDate() {
		final Operation toDate = findOperation("toDate", Types.STRING_TYPE, new String[][] { Types.STRING_TYPE }, false);
		assertNotNull(toDate);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toDate.getBody());
		frame.setLocals(new Object[] { "03/03/2013 13:25", "dd/MM/yyyy HH:mm" });
		final Date date = (Date) toDate.getBody().execute(frame);
		final Calendar cal = Calendar.getInstance();
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
	 * Tests String::toDate(format : String, locale : String).
	 */
	public void testStringToDate_Format_Locale() {
		final Operation toDate = findOperation("toDate", Types.STRING_TYPE, new String[][] { Types.STRING_TYPE, Types.STRING_TYPE }, false);
		assertNotNull(toDate);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toDate.getBody());
		frame.setLocals(new Object[] { "3 maart 2013 13:25", "d MMMMM yyyy HH:mm", "nl_BE" });
		final Date date = (Date) toDate.getBody().execute(frame);
		final Calendar cal = Calendar.getInstance();
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
	 * Tests Date::toString(format : String).
	 * 
	 * @throws ParseException
	 */
	public void testDateToString() throws ParseException {
		final Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/03/2013 13:25");
		final Operation toString = findOperation("toString", Types.JAVA_DATE_TYPE, new String[][] { Types.STRING_TYPE }, false);
		assertNotNull(toString);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toString.getBody());
		frame.setLocals(new Object[] { date, "dd/MM/yyyy HH:mm" });
		final String dateString = (String) toString.getBody().execute(frame);
		assertEquals("03/03/2013 13:25", dateString);
	}

	/**
	 * Tests Date::toString(format : String, locale : String).
	 * 
	 * @throws ParseException
	 */
	public void testDateToString_Format_Locale() throws ParseException {
		final Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("03/03/2013 13:25");
		final Operation toString = findOperation("toString", Types.JAVA_DATE_TYPE, new String[][] { Types.STRING_TYPE, Types.STRING_TYPE },
				false);
		assertNotNull(toString);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toString.getBody());
		frame.setLocals(new Object[] { date, "d MMMMM yyyy HH:mm", "nl_BE" });
		final String dateString = (String) toString.getBody().execute(frame);
		assertEquals("3 maart 2013 13:25", dateString);
	}

	/**
	 * Tests Date::toTuple().
	 */
	public void testDateToTuple() {
		final Calendar cal = Calendar.getInstance();
		final Operation toTuple = findOperation("toTuple", Types.JAVA_DATE_TYPE, new String[][] {}, false);
		assertNotNull(toTuple);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toTuple.getBody());
		frame.setLocals(new Object[] { cal.getTime() });
		final Tuple tuple = (Tuple) toTuple.getBody().execute(frame);
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

	/**
	 * Tests Date::toTuple(timezone : String).
	 */
	public void testDateToTuple_Timezone() {
		final TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		final Calendar cal = Calendar.getInstance(tz);
		final Operation toTuple = findOperation("toTuple", Types.JAVA_DATE_TYPE, new String[][] {Types.STRING_TYPE}, false);
		assertNotNull(toTuple);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), toTuple.getBody());
		frame.setLocals(new Object[] { cal.getTime(), tz.getID() });
		final Tuple tuple = (Tuple) toTuple.getBody().execute(frame);
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

	/**
	 * Finds the {@link Operation} with the given details.
	 * 
	 * @param name
	 *            the operation name
	 * @param context
	 *            the context model and type
	 * @param parameters
	 *            the array of parameter models and types
	 * @param isStatic
	 *            whether the operation is static
	 * @return the {@link Operation} with the given details or <code>null</code> if not found
	 */
	protected Operation findOperation(final String name, final String[] context, final String[][] parameters, final boolean isStatic) {
		final OCLOperations oclOps = OCLOperations.getInstance();
		for (Feature f : oclOps.getOclModule().getFeatures()) {
			if (f instanceof Operation) {
				Operation op = (Operation) f;
				if (op.getName().equals(name) && op.isStatic() == isStatic && op.getContextModel().equals(context[0])
						&& op.getContext().equals(context[1]) && op.getParameters().size() == parameters.length) {
					boolean parMatch = true;
					for (int i = 0; i < op.getParameters().size(); i++) {
						Parameter p = op.getParameters().get(i);
						if (!p.getTypeModel().equals(parameters[i][0]) || !p.getType().equals(parameters[i][1])) {
							parMatch = false;
							break;
						}
					}
					if (parMatch) {
						return op;
					}
				}
			}
		}
		return null;
	}

}
