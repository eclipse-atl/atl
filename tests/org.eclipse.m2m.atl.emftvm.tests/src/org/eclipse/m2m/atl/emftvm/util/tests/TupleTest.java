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

import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.util.OCLOperations;
import org.eclipse.m2m.atl.emftvm.util.Tuple;

/**
 * Tests {@link Tuple}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class TupleTest extends TestCase {

	/**
	 * Tests String::toDate(format : String)
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
