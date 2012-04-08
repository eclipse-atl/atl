/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.tests.fib.Fibonacci;
import org.eclipse.m2m.atl.emftvm.tests.fib.FibonacciNaive;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 */
public class FibonacciNativeTest extends TestCase {
	
	public void testRegularFibonacci() {
		for (int i = 0; i < 3; i++) {
			ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			ResourceSet rs = new ResourceSetImpl();
			ModuleResolver mr = new DefaultModuleResolver(ExecEnvTest.PLUGIN_URI + "/test-data/", rs);
			TimingData td = new TimingData();
			env.loadModule(mr, "Fibonacci");
			td.finishLoading();
			env.run(td);
			td.finish();
			System.out.print("Fibonacci regular: " + td.toString());
		}
	}

	public void testNaiveNativeFibonacci() {
		for (int i = 0; i < 3; i++) {
			ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			ResourceSet rs = new ResourceSetImpl();
			ModuleResolver mr = new DefaultModuleResolver(ExecEnvTest.PLUGIN_URI + "/test-data/", rs);
			TimingData td = new TimingData();
			env.loadModule(mr, "Fibonacci");
			Operation fibOp = env.findOperation(Integer.class, "fib", new Object[0]);
			assertNotNull(fibOp);
			CodeBlock cb = fibOp.getBody();
			CodeBlock nb = new FibonacciNaive();
			nb.getCode().addAll(cb.getCode());
			nb.getLineNumbers().addAll(cb.getLineNumbers());
			fibOp.setBody(nb); // native Fibonacci implementation
			td.finishLoading();
			env.run(td);
			td.finish();
			System.out.print("Fibonacci naive native: " + td.toString());
		}
	}

	public void testNativeFibonacci() {
		for (int i = 0; i < 3; i++) {
			ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			ResourceSet rs = new ResourceSetImpl();
			ModuleResolver mr = new DefaultModuleResolver(ExecEnvTest.PLUGIN_URI + "/test-data/", rs);
			TimingData td = new TimingData();
			env.loadModule(mr, "Fibonacci");
			Operation fibOp = env.findOperation(Integer.class, "fib", new Object[0]);
			assertNotNull(fibOp);
			CodeBlock cb = fibOp.getBody();
			CodeBlock nb = new Fibonacci();
			nb.getCode().addAll(cb.getCode());
			nb.getLineNumbers().addAll(cb.getLineNumbers());
			fibOp.setBody(nb); // native Fibonacci implementation
			td.finishLoading();
			env.run(td);
			td.finish();
			System.out.print("Fibonacci native: " + td.toString());
		}
	}

	public void testJavaFibonacci() {
		for (int i = 0; i < 3; i++) {
			TimingData td = new TimingData();
			Fibonacci f = new Fibonacci();
			td.finishLoading();
			td.finishMatch();
			td.finishApply();
			td.finishPostApply();
			td.finishRecursive();
			System.out.println(f.fib(30));
			td.finish();
			System.out.print("Fibonacci Java: " + td.toString());
		}
	}

}
