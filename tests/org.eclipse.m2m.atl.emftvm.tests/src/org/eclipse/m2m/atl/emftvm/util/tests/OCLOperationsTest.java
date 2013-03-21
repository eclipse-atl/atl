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

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.OCLOperations;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.Types;

/**
 * Tests {@link OCLOperations}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class OCLOperationsTest extends TestCase {

	/**
	 * Tests Class::refNewInstance(args : Sequence)
	 */
	public void testClassRefNewInstance() {
		final Operation refNewInstance = findOperation("refNewInstance", Types.JAVA_CLASS_TYPE, new String[][] { Types.SEQUENCE_TYPE }, false);
		assertNotNull(refNewInstance);
		final StackFrame frame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), refNewInstance.getBody());
		final long currentTimeMillis = System.currentTimeMillis();
		frame.setLocals(new Object[] { Date.class, new LazyList<Object>().append(currentTimeMillis) });
		final Date date = (Date) refNewInstance.getBody().execute(frame);
		assertEquals(currentTimeMillis, date.getTime());
	}

	/**
	 * Tests String::toDate(format : String)
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
