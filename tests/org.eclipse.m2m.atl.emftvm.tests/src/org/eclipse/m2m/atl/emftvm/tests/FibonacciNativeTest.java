/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 */
public class FibonacciNativeTest extends TestCase {
	
	public void testRegularFibonacci() {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(true);
		ResourceSet rs = new ResourceSetImpl();
		ModuleResolver mr = new DefaultModuleResolver(EMFTVMTest.PLUGIN_URI + "/test-data/", rs);
		env.loadModule(mr, "Fibonacci");
		for (int i = 0; i < 3; i++) {
			TimingData td = new TimingData();
			td.finishLoading();
			env.run(td);
			td.finish();
			System.out.print("Fibonacci regular: " + td.toString());
		}
	}

	public void testNativeFibonacci() {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(true);
		ResourceSet rs = new ResourceSetImpl();
		ModuleResolver mr = new DefaultModuleResolver(EMFTVMTest.PLUGIN_URI + "/test-data/", rs);
		env.loadModule(mr, "Fibonacci");
		for (int i = 0; i < 3; i++) {
			TimingData td = new TimingData();
			Operation fibOp = env.findOperation(Integer.class, "fib");
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

	public void testJitFibonacci() {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();
		ModuleResolver mr = new DefaultModuleResolver(EMFTVMTest.PLUGIN_URI + "/test-data/", rs);
		env.loadModule(mr, "Fibonacci");
		for (int i = 0; i < 3; i++) {
			TimingData td = new TimingData();
			td.finishLoading();
			env.run(td);
			td.finish();
			System.out.print("Fibonacci JIT: " + td.toString());
		}
	}

	public void testJavaFibonacci() {
		Fibonacci f = new Fibonacci();
		for (int i = 0; i < 3; i++) {
			TimingData td = new TimingData();
			td.finishLoading();
			td.finishMatch();
			td.finishApply();
			td.finishPostApply();
			td.finishRecursive();
			System.out.println(f.collectFib(1000));
			td.finish();
			System.out.print("Fibonacci Java: " + td.toString());
		}
	}

}
