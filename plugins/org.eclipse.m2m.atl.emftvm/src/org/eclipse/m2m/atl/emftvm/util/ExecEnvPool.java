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
package org.eclipse.m2m.atl.emftvm.util;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;

/**
 * Pool of reusable {@link ExecEnv}s.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ExecEnvPool {

	private final Map<String, Metamodel> metamodels = new LinkedHashMap<String, Metamodel>();
	private ModuleResolverFactory moduleResolverFactory;
	private final List<String> modules = new ArrayList<String>();
	private boolean frozen;
	private final Collection<SoftReference<ExecEnv>> pool = new LinkedList<SoftReference<ExecEnv>>();
	private final Queue<SoftReference<ExecEnv>> freePool = new LinkedList<SoftReference<ExecEnv>>();

	/**
	 * Registers <code>metamodel</code> under <code>name</code>.
	 * 
	 * @param name
	 *            the name under which to register
	 * @param metamodel
	 *            the metamodel to register
	 * @throws IllegalStateException
	 *             if {@link #getExecEnv()} has already been called on this pool
	 */
	public synchronized void registerMetaModel(String name, Metamodel metamodel) {
		if (isFrozen()) {
			throw new IllegalStateException("Cannot register metamodels after calling getExecEnv()");
		}
		metamodels.put(name, metamodel);
	}

	/**
	 * Loads the module with the given <code>name</code> and its imports closure, and registers its contents for execution.
	 * 
	 * @param name
	 *            the module name
	 * @throws IllegalStateException
	 *             if {@link #getExecEnv()} has already been called on this pool
	 */
	public synchronized void loadModule(String name) {
		if (isFrozen()) {
			throw new IllegalStateException("Cannot load modules after calling getExecEnv()");
		}
		modules.add(name);
	}

	/**
	 * Returns the first available {@link ExecEnv} instance from this pool. Creates a new instance if necessary.
	 * 
	 * @return the first available {@link ExecEnv} instance from this pool
	 */
	public synchronized ExecEnv getExecEnv() {
		final boolean validate = !isFrozen(); // Only validate bytecode for first time load
		setFrozen(true);
		final Queue<SoftReference<ExecEnv>> freePool = getFreePool();
		ExecEnv execEnv = null;
		while (!freePool.isEmpty() && execEnv == null) {
			execEnv = freePool.poll().get();
		}
		if (execEnv == null) {
			execEnv = EmftvmFactory.eINSTANCE.createExecEnv();
			for (Entry<String, Metamodel> metamodel : getMetamodels().entrySet()) {
				execEnv.registerMetaModel(metamodel.getKey(), metamodel.getValue());
			}
			final ModuleResolverFactory moduleResolverFactory = getModuleResolverFactory();
			final List<String> modules = getModules();
			if (!modules.isEmpty()) {
				if (moduleResolverFactory == null) {
					throw new IllegalStateException("No module resolver factory set");
				}
				final ModuleResolver moduleResolver = moduleResolverFactory.createModuleResolver();
				for (String module : getModules()) {
					execEnv.loadModule(moduleResolver, module, validate);
				}
			}
			getPool().add(new SoftReference<ExecEnv>(execEnv));
		}
		return execEnv;
	}

	/**
	 * Returns <code>env</code> to this pool. <code>env</code> must have been created by this pool.
	 * 
	 * @param env
	 *            the {@link ExecEnv} to return to this pool
	 * @throws IllegalArgumentException
	 *             if <code>env</code> was not created by this pool
	 */
	public synchronized void returnExecEnv(ExecEnv env) {
		boolean found = false;
		for (Iterator<SoftReference<ExecEnv>> it = getPool().iterator(); it.hasNext();) {
			ExecEnv envEntry = it.next().get();
			if (envEntry == null) {
				it.remove();
			} else {
				found |= (env == envEntry);
				// Keep running to remove all empty soft references
			}
		}
		if (!found) {
			throw new IllegalArgumentException(String.format("%s was not created by this pool", env));
		}
		boolean freeFound = false;
		for (Iterator<SoftReference<ExecEnv>> it = getFreePool().iterator(); it.hasNext();) {
			ExecEnv envEntry = it.next().get();
			if (envEntry == null) {
				it.remove();
			} else {
				freeFound |= (env == envEntry);
				// Keep running to remove all empty soft references
			}
		}
		if (!freeFound) {
			env.clearModels();
			getFreePool().offer(new SoftReference<ExecEnv>(env));
		}
	}

	/**
	 * Returns whether this {@link ExecEnvPool} has been frozen, i.e. no new metamodels or modules can be loaded.
	 * 
	 * @return whether this {@link ExecEnvPool} has been frozen, i.e. no new metamodels or modules can be loaded
	 */
	public synchronized boolean isFrozen() {
		return frozen;
	}

	/**
	 * @param frozen
	 *            the frozen to set
	 */
	protected void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	/**
	 * @return the metamodels
	 */
	protected Map<String, Metamodel> getMetamodels() {
		return metamodels;
	}

	/**
	 * @return the moduleResolverFactory
	 */
	protected ModuleResolverFactory getModuleResolverFactory() {
		return moduleResolverFactory;
	}

	/**
	 * Sets the {@link ModuleResolverFactory} to use for loading modules.
	 * 
	 * @param moduleResolverFactory
	 *            the moduleResolverFactory to set
	 * @throws IllegalStateException
	 *             if {@link #getExecEnv()} has already been called on this pool
	 */
	public synchronized void setModuleResolverFactory(ModuleResolverFactory moduleResolverFactory) {
		if (isFrozen()) {
			throw new IllegalStateException("Cannot load modules after calling getExecEnv()");
		}
		this.moduleResolverFactory = moduleResolverFactory;
	}

	/**
	 * @return the modules
	 */
	protected List<String> getModules() {
		return modules;
	}

	/**
	 * Returns the pool of all {@link ExecEnv} instances created by this {@link ExecEnvPool}.
	 * 
	 * @return the pool
	 */
	protected Collection<SoftReference<ExecEnv>> getPool() {
		return pool;
	}

	/**
	 * Returns the pool of all free {@link ExecEnv} instances. Subset of {@link #getPool()}.
	 * 
	 * @return the freePool
	 */
	protected Queue<SoftReference<ExecEnv>> getFreePool() {
		return freePool;
	}

}
