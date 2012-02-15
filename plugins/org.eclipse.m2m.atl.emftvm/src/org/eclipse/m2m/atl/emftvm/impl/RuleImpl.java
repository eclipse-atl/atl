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
package org.eclipse.m2m.atl.emftvm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleElement;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;
import org.eclipse.m2m.atl.emftvm.util.FieldContainer;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getInputElements <em>Input Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getOutputElements <em>Output Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getESuperRules <em>ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getESubRules <em>ESub Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getApplier <em>Applier</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getPostApply <em>Post Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getSuperRules <em>Super Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isDistinctElements <em>Distinct Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isWithLeaves <em>With Leaves</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends NamedElementImpl implements Rule {

	/**
	 * Base class for code that depends on the state of {@link Rule#isUnique()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class UniqueState {

		/**
		 * Creates a unique trace mapping entry for the source values in <code>ses</code>,
		 * if applicable.
		 * @param tr the traced rule to add the unique traces to
		 * @param ses the source values that serve as a the unique trace key
		 */
		public abstract void createUniqueMapping(final TracedRule tr, final EList<SourceElement> ses);

		/**
		 * Creates a unique trace mapping entry for the source values in <code>teMapsTo</code>,
		 * if applicable.
		 * @param tr the traced rule to add the unique traces to
		 * @param ses the source values that serve as a the unique trace key
		 * @param seSize the total amount of source elements for this rule
		 * @return <code>true</code> iff unique mappings are set for complete list of all source elements
		 */
		public abstract boolean createUniqueMapping(TracedRule tr, EList<SourceElement> ses, int seSize);

		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * In case of a unique rule, this method will not match if the rule has already
		 * matched against <code>values</code> before.
		 * @param frame the stack frame context
		 * @param values the source values to match against
		 * @return <code>true</code> iff this rule matches against <code>values</code>
		 */
		public abstract boolean matchFor(final StackFrame frame, final EObject[] values);

		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * In case of a unique rule, this method will not match if the rule has already
		 * matched against <code>values</code> before.
		 * @param frame the stack frame context
		 * @param valuesMap the map of all values, including super-rule elements
		 * @param values the source values to match against
		 * @return <code>true</code> iff this rule matches against <code>values</code>
		 */
		public abstract boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
				final EObject[] values);

		/**
		 * 
		 * @param frame
		 * @param values
		 * @return
		 */
		public abstract Object matchManual(final StackFrame frame, final EObject[] values);
	}

	/**
	 * {@link UniqueState} class for rules with {@link Rule#isUnique()} set to <code>false</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class UniqueOffState extends UniqueState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createUniqueMapping(final TracedRule tr,
				final EList<SourceElement> ses) {
			assert !isUnique();
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean createUniqueMapping(final TracedRule tr,
				final EList<SourceElement> ses, final int seSize) {
			assert !isUnique();
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object matchManual(final StackFrame frame, final EObject[] values) {
			assert !isUnique();
			final Map<String, EObject> valuesMap = createValuesMap(values);
			if (matchOne(frame, valuesMap)) {
				return applyTo(frame, createTrace(frame, valuesMap));
			} else {
				return null;
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			assert !isUnique();
			return matcherCbState.matchFor(frame, values);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
				final EObject[] values) {
			assert !isUnique();
			return matcherCbState.matchFor(frame, valuesMap, values);
		}
	}

	/**
	 * {@link UniqueState} class for rules with {@link Rule#isUnique()} set to <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class UniqueOnState extends UniqueState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createUniqueMapping(final TracedRule tr,
				final EList<SourceElement> ses) {
			assert isUnique();
			if (ses.size() == 1) {
				ses.get(0).setUniqueFor(tr);
			} else {
				final SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
				sel.getSourceElements().addAll(ses);
				sel.setUniqueFor(tr);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean createUniqueMapping(final TracedRule tr,
				final EList<SourceElement> ses, final int seSize) {
			assert isUnique();
			createUniqueMapping(tr, ses);
			// Unique mappings set for complete list of all source elements
			return (ses.size() == seSize);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object matchManual(final StackFrame frame, final EObject[] values) {
			assert isUnique();
			final Map<TraceLink, Object> uniqueResults = frame.getEnv().getUniqueResults();
			// Reuse existing application result for unique rules
			TraceLink trace = getUniqueTrace(frame, values);
			if (trace != null) {
				return uniqueResults.get(trace);
			}
			// Otherwise match as normal
			final Map<String, EObject> valuesMap = createValuesMap(values);
			if (matchOne(frame, valuesMap)) {
				trace = createTrace(frame, valuesMap);
				final Object resultValue = applyTo(frame, trace);
				// Store unique result for later retrieval
				uniqueResults.put(trace, resultValue);
				return resultValue;
			} else {
				return null;
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			assert isUnique();
			// Don't match if values have previously matched
			final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(getName(), true);
			if (values.length == 1) {
				if (tr.getUniqueSourceElement(values[0]) != null) {
					return false;
				}
			} else {
				if (tr.getUniqueSourceElements(Arrays.asList(values)) != null) {
					return false;
				}
			}
			// Otherwise match as normal
			return matcherCbState.matchFor(frame, values);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
				final EObject[] values) {
			assert isUnique();
			// Don't match if values have previously matched
			final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(getName(), true);
			if (values.length == 1) {
				if (tr.getUniqueSourceElement(values[0]) != null) {
					return false;
				}
			} else {
				if (tr.getUniqueSourceElements(Arrays.asList(values)) != null) {
					return false;
				}
			}
			// Otherwise match as normal
			return matcherCbState.matchFor(frame, valuesMap, values);
		}

		/**
		 * Returns the unique rule application trace for <code>values</code>, if applicable.
		 * @param frame the stack frame context
		 * @param values the source values for the trace
		 * @return the unique rule application trace, or <code>null</code>
		 */
		private TraceLink getUniqueTrace(final StackFrame frame, final EObject[] values) {
			final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(getName(), true);
			if (values.length == 1) {
				final SourceElement se = tr.getUniqueSourceElement(values[0]);
				if (se != null) {
					return se.getSourceOf();
				}
			} else {
				final SourceElementList sel = tr.getUniqueSourceElements(Arrays.asList(values));
				if (sel != null) {
					return sel.getSourceElements().get(0).getSourceOf();
				}
			}
			return null;
		}
	}

	/**
	 * Base class for code that depends on the state of {@link Rule#isDefault()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class DefaultState {

		/**
		 * Creates a default trace mapping entry for the source values in <code>ses</code>,
		 * if applicable.
		 * @param traces the trace link set to add the default traces to
		 * @param ses the source values that serve as a the default trace key
		 */
		public abstract void createDefaultMapping(final TraceLinkSet traces, final EList<SourceElement> ses);

		/**
		 * Creates a default trace mapping entry for the source values in <code>teMapsTo</code>,
		 * if applicable.
		 * @param traces the trace link set to add the default traces to
		 * @param teMapsTo the source values that serve as a the default trace key
		 * @param seSize the amount of source elements for this rule
		 * @return <code>true</code> iff default mappings are set for complete list of all source elements
		 */
		public abstract boolean createDefaultMapping(TraceLinkSet traces, EList<SourceElement> teMapsTo, int seSize);
	}

	/**
	 * {@link DefaultState} class for rules with {@link Rule#isDefault()} set to <code>false</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class DefaultOffState extends DefaultState {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createDefaultMapping(final TraceLinkSet traces, final EList<SourceElement> ses) {
			// do nothing
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean createDefaultMapping(final TraceLinkSet traces, final EList<SourceElement> teMapsTo, final int seSize) {
			return false;
		}
	}
	
	/**
	 * {@link DefaultState} class for rules with {@link Rule#isDefault()} set to <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class DefaultOnState extends DefaultState {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createDefaultMapping(final TraceLinkSet traces, final EList<SourceElement> ses) {
			assert isDefault();
			if (ses.size() == 1) {
				ses.get(0).setDefaultFor(traces);
			} else {
				final SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
				sel.getSourceElements().addAll(ses);
				sel.setDefaultFor(traces);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean createDefaultMapping(final TraceLinkSet traces, final EList<SourceElement> ses, final int seSize) {
			assert isDefault();
			createDefaultMapping(traces, ses);
			// Default mappings set for complete list of all source elements
			return (ses.size() == seSize);
		}
	}

	/**
	 * Base class for code that depends on whether the rule has any {@link Rule#getESuperRules()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class SuperRulesState {
		
		/**
		 * Matches {@link #getRule()}.
		 * @param frame the stack frame in which to execute the matcher
		 * @return <code>true</code> iff the rule has any matches
		 */
		public abstract boolean match(final StackFrame frame);

		/**
		 * Matches up to one match for {@link #getRule()}.
		 * @return <code>true</code> iff the rule has any matches
		 */
		public abstract boolean matchOne(final StackFrame frame);
	}

	/**
	 * {@link SuperRulesState} class for rules without any {@link Rule#getESuperRules()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class WithoutSuperRulesState extends SuperRulesState {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean match(final StackFrame frame) {
			assert getESuperRules().isEmpty();
			final ExecEnv env = frame.getEnv();
			// Create value iterables and initial value array
			final EList<InputRuleElement> allInputs = getInputElements();
			final List<Iterable<EObject>> iterables = new ArrayList<Iterable<EObject>>(allInputs.size());
			for (InputRuleElement re : allInputs) {
				if (re.getBinding() != null) {
					// Skip bound elements until all non-bound values have been set
					iterables.add(null);
				} else {
					iterables.add(re.createIterable(env));
				}
			}
			final EObject[] values = new EObject[iterables.size()];
			// Do the matching
			return matchFor(frame, values, 0, iterables);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchOne(final StackFrame frame) {
			assert getESuperRules().isEmpty();
			final ExecEnv env = frame.getEnv();
			// Create value iterables and initial value array
			final EList<InputRuleElement> allInputs = getInputElements();
			final List<Iterable<EObject>> iterables = new ArrayList<Iterable<EObject>>(allInputs.size());
			for (InputRuleElement re : allInputs) {
				if (re.getBinding() != null) {
					// Skip bound elements until all non-bound values have been set
					iterables.add(null);
				} else {
					iterables.add(re.createIterable(env));
				}
			}
			final EObject[] values = new EObject[iterables.size()];
			// Do the matching
			return matchOneFor(frame, values, 0, iterables);
		}
	}
	
	/**
	 * {@link SuperRulesState} class for rules with {@link Rule#getESuperRules()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class WithSuperRulesState extends SuperRulesState {
		
		/**
		 * {@inheritDoc}
		 */
		public boolean match(final StackFrame frame) {
			final ExecEnv env = frame.getEnv();
			final EList<Rule> superRules = getESuperRules();
			assert !superRules.isEmpty();
			// Retrieve super-rule matches
			final List<TracedRule> superMatches = new ArrayList<TracedRule>();
			final java.util.Set<String> superRuleElementNames = new HashSet<String>();
			final TraceLinkSet matches = env.getMatches();
			for (Rule superRule : superRules) {
				TracedRule superMatch = matches.getLinksByRule(superRule.getName(), false);
				assert superMatch != null;
				superMatches.add(superMatch);
				for (RuleElement re : superRule.getInputElements()) {
					superRuleElementNames.add(re.getName());
				}
			}
			// Retrieve additional input elements
			final Map<String, Iterable<EObject>> iterables = new LinkedHashMap<String, Iterable<EObject>>();
			final EList<InputRuleElement> allInput = getInputElements();
			for (InputRuleElement re : allInput) {
				String name = re.getName();
				if (!superRuleElementNames.contains(name) && re.getBinding() == null) {
					// Skip bound elements until all non-bound values have been set
					iterables.put(name, re.createIterable(env));
				}
			}
			// Do the matching
			return matchFor(frame, 
					new LinkedHashMap<String, EObject>(allInput.size()), 
					0, 
					superMatches, 
					iterables, 
					new LinkedHashMap<TracedRule, TraceLink>(superRules.size()));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchOne(StackFrame frame) {
			final ExecEnv env = frame.getEnv();
			final EList<Rule> superRules = getESuperRules();
			assert !superRules.isEmpty();
			// Retrieve super-rule matches
			final List<TracedRule> superMatches = new ArrayList<TracedRule>();
			final java.util.Set<String> superRuleElementNames = new HashSet<String>();
			final TraceLinkSet matches = env.getMatches();
			for (Rule superRule : superRules) {
				TracedRule superMatch = matches.getLinksByRule(superRule.getName(), false);
				assert superMatch != null;
				superMatches.add(superMatch);
				for (RuleElement re : superRule.getInputElements()) {
					superRuleElementNames.add(re.getName());
				}
			}
			// Retrieve additional input elements
			final Map<String, Iterable<EObject>> iterables = new LinkedHashMap<String, Iterable<EObject>>();
			final EList<InputRuleElement> allInput = getInputElements();
			for (InputRuleElement re : allInput) {
				String name = re.getName();
				if (!superRuleElementNames.contains(name) && re.getBinding() == null) {
					// Skip bound elements until all non-bound values have been set
					iterables.put(name, re.createIterable(env));
				}
			}
			// Do the matching
			return matchOneFor(frame, 
					new LinkedHashMap<String, EObject>(allInput.size()), 
					0, 
					superMatches, 
					iterables, 
					new HashMap<TracedRule, TraceLink>(superRules.size()));
		}
	}

	/**
	 * Base class for code that depends on the rule's {@link Rule#getMode()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class RuleModeState {
		
		/**
		 * Matches {@link #getRule()} for the automatic single stage, if applicable.
		 * @param frame the stack frame in which to execute the matcher
		 * @return <code>true</code> iff the rule has any matches
		 */
		public boolean matchSingle(final StackFrame frame) {
			return false; // base case
		}

		/**
		 * Matches {@link #getRule()} for the automatic recursive stage, if applicable.
		 * @param frame the stack frame in which to execute the matcher
		 * @return <code>true</code> iff the rule has any matches
		 */
		public boolean[] matchRecursive(final StackFrame frame) {
			return new boolean[]{false, false}; // base case
		}

		/**
		 * Matches {@link #getRule()} manually, if applicable.
		 * @param frame the stack frame in which to execute the matcher
		 * @param values the values to match against
		 * @return the rule application result, or <code>null</code> if the rule did not match
		 * @throws VMException if this is not a {@link RuleMode#MANUAL} rule
		 */
		public Object matchManual(final StackFrame frame, final EObject[] values) {
			// base case
			throw new VMException(frame, String.format(
					"Rule %s is not a manual rule", this));
		}
		
		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * In case of a unique rule, this method will not match if the rule has already
		 * matched against <code>values</code> before.
		 * @param frame the stack frame context
		 * @param values the source values to match against
		 * @return <code>true</code> iff this rule matches against <code>values</code>
		 */
		public abstract boolean matchFor(StackFrame frame, EObject[] values);

		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * In case of a unique rule, this method will not match if the rule has already
		 * matched against <code>values</code> before.
		 * @param frame the stack frame context
		 * @param valuesMap the map of all values, including super-rule elements
		 * @param values the source values to match against
		 * @return <code>true</code> iff this rule matches against <code>values</code>
		 */
		public abstract boolean matchFor(StackFrame frame, Map<String, EObject> valuesMap, 
				EObject[] values);
	}

	/**
	 * {@link RuleModeState} class for rules with mode {@link RuleMode#MANUAL}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class ManualState extends RuleModeState {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object matchManual(final StackFrame frame, final EObject[] values) {
			assert getMode() == RuleMode.MANUAL;
			return uniqueState.matchManual(frame, values);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			assert getMode() == RuleMode.MANUAL;
			throw new VMException(frame, 
					"matchFor(StackFrame, EObject[]) should not be used for manual rules");
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(StackFrame frame,
				Map<String, EObject> valuesMap, EObject[] values) {
			assert getMode() == RuleMode.MANUAL;
			throw new VMException(frame, 
					"matchFor(StackFrame, Map<String, EObject>, EObject[]) should not be used for manual rules");
		}
	}

	/**
	 * {@link RuleModeState} class for rules with mode {@link RuleMode#AUTOMATIC_SINGLE}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class AutomaticSingleState extends RuleModeState {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchSingle(final StackFrame frame) {
			assert getMode() == RuleMode.AUTOMATIC_SINGLE;
			return leafState.matchSingle(frame);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			assert getMode() == RuleMode.AUTOMATIC_SINGLE;
			return matcherCbState.matchFor(frame, values);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
				final EObject[] values) {
			assert getMode() == RuleMode.AUTOMATIC_SINGLE;
			return matcherCbState.matchFor(frame, valuesMap, values);
		}
	}

	/**
	 * {@link RuleModeState} class for rules with mode {@link RuleMode#AUTOMATIC_RECURSIVE}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class AutomaticRecursiveState extends RuleModeState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean[] matchRecursive(StackFrame frame) {
			assert getMode() == RuleMode.AUTOMATIC_RECURSIVE;
			return leafState.matchRecursive(frame);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(StackFrame frame, EObject[] values) {
			assert getMode() == RuleMode.AUTOMATIC_RECURSIVE;
			return uniqueState.matchFor(frame, values);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(StackFrame frame,
				Map<String, EObject> valuesMap, EObject[] values) {
			assert getMode() == RuleMode.AUTOMATIC_RECURSIVE;
			return uniqueState.matchFor(frame, valuesMap, values);
		}
		
	}

	/**
	 * Base class for code that depends on the rule's {@link Rule#isAbstract()} and {@link Rule#getESubRules()}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class LeafState {

		/**
		 * Matches {@link #getRule()} for the automatic single stage, if applicable.
		 * @param frame the stack frame in which to execute the matcher
		 * @return <code>true</code> iff the rule has any matches
		 */
		public boolean matchSingle(final StackFrame frame) {
			return superRulesState.match(frame);
		}

		/**
		 * Matches {@link #getRule()} for the automatic recursive stage, if applicable.
		 * @param frame the stack frame in which to execute the matcher
		 * @return <code>true</code> iff the rule has any matches
		 */
		public abstract boolean[] matchRecursive(StackFrame frame);

		/**
		 * Applies and post-applies this rule for the first recorded match.
		 * @param frame the stack frame in which to execute the applier and post-applier
		 * @return <code>true</code> iff this rule was applied
		 */
		public boolean applyFirst(final StackFrame frame) {
			return false; // skip non-leaf rules
		}
	}

	/**
	 * {@link LeafState} class for rules for which {@link Rule#isLeaf()} is <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsLeafState extends LeafState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean[] matchRecursive(StackFrame frame) {
			assert isLeaf();
			if (superRulesState.matchOne(frame)) {
				return new boolean[]{true, true}; // guaranteed final match
			}
			return new boolean[]{false, false}; // no match
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean applyFirst(final StackFrame frame) {
			assert isLeaf();
			final ExecEnv env = frame.getEnv();
			final TraceLink trace = createFirstTrace(frame);
			assert trace != null;
			final TraceLinkSet matches = env.getMatches();
			matches.getRules().clear();
			matches.getDefaultSourceElements().clear();
			final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
			applyFor(frame, trace, ruleApplyArgs, new HashSet<Rule>());
			postApplyFor(frame, trace, ruleApplyArgs, new HashSet<Rule>());
			env.deleteQueue();
			return true;
		}
	}

	/**
	 * {@link LeafState} class for rules for which {@link Rule#isLeaf()} is <code>false</code>
	 * and {@link Rule#isWithLeaves()} is <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsWithLeavesState extends LeafState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean[] matchRecursive(StackFrame frame) {
			assert !isLeaf() && isWithLeaves();
			if (superRulesState.match(frame)) {
				return new boolean[]{true, false}; // simple match
			}
			return new boolean[]{false, false}; // no match
		}
	}

	/**
	 * {@link LeafState} class for rules for which {@link Rule#isLeaf()} is <code>false</code>
	 * and {@link Rule#isWithLeaves()} is also <code>false</code>.
	 * In other words, the rule is abstract, but has no concrete sub-rules!
	 * Such rules do not have to be matched, as they can never be applied.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsOtherLeafState extends LeafState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchSingle(final StackFrame frame) {
			assert !isLeaf() && !isWithLeaves();
			return false; // skip matching
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean[] matchRecursive(StackFrame frame) {
			assert !isLeaf() && !isWithLeaves();
			return new boolean[]{false, false}; // skip matching
		}
	}

	/**
	 * Base class for code that depends on the rule's {@link Rule#isAbstract()} state.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class AbstractState {
		
		/**
		 * Creates trace elements for the recorded matches for this rule.
		 * @param frame the stack frame context
		 */
		public abstract void createTraces(StackFrame frame);

		/**
		 * Applies this rule for the created traces.
		 * @param frame the stack frame in which to execute the applier
		 */
		public abstract void apply(StackFrame frame);

		/**
		 * Runs post-applier for this rule for the created traces.
		 * @param frame the stack frame in which to execute the post-applier
		 */
		public abstract void postApply(StackFrame frame);
	}

	/**
	 * {@link AbstractState} class for rules for which {@link Rule#isAbstract()} is <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsAbstractState extends AbstractState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createTraces(StackFrame frame) {
			assert isAbstract();
			// do nothing - abstract rules cannot be applied
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void apply(StackFrame frame) {
			assert isAbstract();
			// do nothing - abstract rules cannot be applied
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void postApply(StackFrame frame) {
			assert isAbstract();
			// do nothing - abstract rules cannot be applied
		}
	}

	/**
	 * {@link AbstractState} class for rules for which {@link Rule#isAbstract()} is <code>false</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsNotAbstractState extends AbstractState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createTraces(StackFrame frame) {
			assert !isAbstract();
			final ExecEnv env = frame.getEnv();
			// Matches become traces
			final TracedRule tr = env.getMatches().getLinksByRule(getName(), false);
			if (tr == null) {
				throw new VMException(frame, String.format(
						"Cannot create traces for %s; no matches exist",
						this));
			}
			// Move traced rule from match model to trace model
			final TraceLinkSet traces = env.getTraces();
			traces.getRules().add(tr);
			// Remove overridden matches
			for (Iterator<TraceLink> links = tr.getLinks().iterator(); links.hasNext();) {
				TraceLink trace = links.next();
				if (trace.isOverridden()) {
					links.remove(); // This match is overridden by a sub-rule
				} else {
					boolean defaultMappingSet = completeTraceFor(frame, trace);
					// Mark default/unique source elements if applicable
					if (!defaultMappingSet) {
						EList<SourceElement> ses = trace.getSourceElements();
						defaultState.createDefaultMapping(traces, ses);
						uniqueState.createUniqueMapping(tr, ses);
					}
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void apply(StackFrame frame) {
			assert !isAbstract();
			final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(getName(), false);
			if (tr == null) {
				throw new VMException(frame, String.format(
						"Cannot apply rule %s; no traces exist",
						this));
			}
			for (TraceLink trace : tr.getLinks()) {
				assert !trace.isOverridden();
				applyFor(frame, trace, new HashMap<Rule, Object[]>(), new HashSet<Rule>());
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void postApply(StackFrame frame) {
			assert !isAbstract();
			final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(getName(), false);
			if (tr == null) {
				throw new VMException(frame, String.format(
						"Cannot post-apply rule %s; no traces exist",
						this));
			}
			for (TraceLink trace : tr.getLinks()) {
				postApplyFor(frame, trace, new HashMap<Rule, Object[]>(), new HashSet<Rule>());
			}
		}
	}

	/**
	 * Base class for code that depends on whether the rule has a {@link Rule#getMatcher()} code block.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class MatcherCbState {

		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * @param frame the stack frame in which to run the matcher
		 * @param values the source values to match
		 * @return <code>true</code> iff the rule matches
		 */
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			// base case: no matcher code block => always matches
			final TraceLink match = TraceFactory.eINSTANCE.createTraceLink();
			final EList<SourceElement> ses = match.getSourceElements();
			int i = 0;
			for (RuleElement re : getInputElements()) {
				SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
				se.setName(re.getName());
				se.setObject(values[i++]);
				ses.add(se);
			}
			frame.getEnv().getMatches().getLinksByRule(getName(), true).getLinks().add(match);
			return true;
		}

		/**
		 * Matches this rule against <code>values</code>,
		 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
		 * @param frame the stack frame context
		 * @param valuesMap the map of all values, including super-rule elements
		 * @param values the source values to match against
		 * @return <code>true</code> iff this rule matches against <code>values</code>
		 */
		public boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
				final EObject[] values) {
			final TraceLink match = TraceFactory.eINSTANCE.createTraceLink();
			final EList<SourceElement> ses = match.getSourceElements();
			// Add all values for the match, not just the ones specified in the rule signature
			for (Entry<String, EObject> v : valuesMap.entrySet()) {
				SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
				se.setName(v.getKey());
				se.setObject(v.getValue());
				ses.add(se);
			}
			frame.getEnv().getMatches().getLinksByRule(getName(), true).getLinks().add(match);
			return true;
		}
	}

	/**
	 * {@link MatcherCbState} class for rules that have a {@link Rule#getMatcher()} code block.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class WithMatcherCbState extends MatcherCbState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(final StackFrame frame, final EObject[] values) {
			final CodeBlock cb = getMatcher();
			assert cb != null;
			if ((Boolean)cb.execute(frame.getSubFrame(cb, values)).pop()) {
				return super.matchFor(frame, values);
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchFor(StackFrame frame,
				Map<String, EObject> valuesMap, EObject[] values) {
			final CodeBlock cb = getMatcher();
			assert cb != null;
			if ((Boolean)cb.execute(frame.getSubFrame(cb, values)).pop()) {
				return super.matchFor(frame, valuesMap, values);
			}
			return false;
		}
	}

	/**
	 * {@link MatcherCbState} class for rules that do not have a {@link Rule#getMatcher()} code block.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class WithoutMatcherCbState extends MatcherCbState {

	}

	/**
	 * Base class for code that depends on the rule's {@link Rule#isDistinctElements()} state.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected abstract class DistinctState {

		/**
		 * Checks if <pre>values</pre> are distict, if so required by the rule.
		 * @param values the currently collected values
		 * @param index the index up to which to check the <code>values</code>
		 * @param value the value to check against <code>values</code>
		 * @return <code>true</code> iff <code>value</code> is ok
		 */
		public abstract boolean checkDistinct(EObject[] values, int index, Object value);
	}

	/**
	 * {@link DistinctState} class for rules for which {@link Rule#isDistinctElements()} is set to <code>true</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsDistinctState extends DistinctState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean checkDistinct(EObject[] values, int index, Object value) {
			for (int i = 0; i < index; i++) {
				if (values[i] == value) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * {@link DistinctState} class for rules for which {@link Rule#isDistinctElements()} is set to <code>false</code>.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected class IsNotDistinctState extends DistinctState {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean checkDistinct(EObject[] values, int index, Object value) {
			return true; // test always passes
		}
	}

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final RuleMode MODE_EDEFAULT = RuleMode.MANUAL;
	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected RuleMode mode = MODE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInputElements() <em>Input Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputElements()
	 * @generated
	 * @ordered
	 */
	protected EList<InputRuleElement> inputElements;
	/**
	 * The cached value of the '{@link #getOutputElements() <em>Output Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputRuleElement> outputElements;
	/**
	 * The cached value of the '{@link #getESuperRules() <em>ESuper Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESuperRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> eSuperRules;
	/**
	 * The cached value of the '{@link #getESubRules() <em>ESub Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESubRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> eSubRules;
	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock matcher;
	/**
	 * The cached value of the '{@link #getApplier() <em>Applier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplier()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock applier;
	/**
	 * The cached value of the '{@link #getPostApply() <em>Post Apply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostApply()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock postApply;
	/**
	 * The cached value of the '{@link #getSuperRules() <em>Super Rules</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperRules()
	 * @generated
	 * @ordered
	 */
	protected EList<String> superRules;
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<Field> fields;
	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;
	/**
	 * The default value of the '{@link #isDistinctElements() <em>Distinct Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinctElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISTINCT_ELEMENTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDistinctElements() <em>Distinct Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinctElements()
	 * @generated
	 * @ordered
	 */
	protected boolean distinctElements = DISTINCT_ELEMENTS_EDEFAULT;
	/**
	 * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNIQUE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean unique = UNIQUE_EDEFAULT;
	/**
	 * The default value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEAF_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected boolean leaf = LEAF_EDEFAULT;
	/**
	 * The default value of the '{@link #isWithLeaves() <em>With Leaves</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithLeaves()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_LEAVES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isWithLeaves() <em>With Leaves</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithLeaves()
	 * @generated
	 * @ordered
	 */
	protected boolean withLeaves = WITH_LEAVES_EDEFAULT;
	/**
	 * Field storage and lookup. 
	 */
	protected FieldContainer fieldContainer = new FieldContainer();

	/**
	 * The rule's {@link #isUnique()} state object.
	 */
	protected UniqueState uniqueState;
	/**
	 * The rule's {@link #isDefault()} state object.
	 */
	protected DefaultState defaultState;
	/**
	 * The rule's {@link #getESuperRules()}.isEmpty() state object.
	 */
	protected SuperRulesState superRulesState;
	/**
	 * The rule's {@link #getMode()} state object.
	 */
	protected RuleModeState ruleModeState;
	/**
	 * The rule's {@link #isLeaf()}/{@link #isWithLeaves()} state object.
	 */
	protected LeafState leafState;
	/**
	 * The rule's {@link #isAbstract()} state object.
	 */
	protected AbstractState abstractState;
	/**
	 * The rule's {@link #getMatcher()} state object.
	 */
	protected MatcherCbState matcherCbState;
	/**
	 * The rule's {@link #isDistinctElements()} state object.
	 */
	protected DistinctState distinctState;

	/**
	 * Flag to specify whether {@link #leaf} has been initialised.
	 */
	private boolean leafSet;
	/**
	 * Flag to specify whether {@link #withLeaves} has been initialised.
	 */
	private boolean withLeavesSet;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link RuleImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getModule() {
		if (eContainerFeatureID() != EmftvmPackage.RULE__MODULE) return null;
		return (Module)eContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setModule(Module)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModule, EmftvmPackage.RULE__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		if (newModule != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.RULE__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject)newModule).eInverseAdd(this, EmftvmPackage.MODULE__RULES, Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(RuleMode newMode) {
		RuleMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputRuleElement> getInputElements() {
		if (inputElements == null) {
			inputElements = new EObjectContainmentWithInverseEList<InputRuleElement>(InputRuleElement.class, this, EmftvmPackage.RULE__INPUT_ELEMENTS, EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR);
		}
		return inputElements;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputRuleElement> getOutputElements() {
		if (outputElements == null) {
			outputElements = new EObjectContainmentWithInverseEList<OutputRuleElement>(OutputRuleElement.class, this, EmftvmPackage.RULE__OUTPUT_ELEMENTS, EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR);
		}
		return outputElements;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getESuperRules() {
		if (eSuperRules == null) {
			eSuperRules = new EObjectWithInverseResolvingEList.ManyInverse<Rule>(Rule.class, this, EmftvmPackage.RULE__ESUPER_RULES, EmftvmPackage.RULE__ESUB_RULES);
		}
		return eSuperRules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getESubRules() {
		if (eSubRules == null) {
			eSubRules = new EObjectWithInverseResolvingEList.ManyInverse<Rule>(Rule.class, this, EmftvmPackage.RULE__ESUB_RULES, EmftvmPackage.RULE__ESUPER_RULES);
		}
		return eSubRules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setMatcher(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(CodeBlock newMatcher, NotificationChain msgs) {
		CodeBlock oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcher(CodeBlock newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, CodeBlock.class, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, CodeBlock.class, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getApplier() {
		return applier;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setApplier(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplier(CodeBlock newApplier, NotificationChain msgs) {
		CodeBlock oldApplier = applier;
		applier = newApplier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__APPLIER, oldApplier, newApplier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplier(CodeBlock newApplier) {
		if (newApplier != applier) {
			NotificationChain msgs = null;
			if (applier != null)
				msgs = ((InternalEObject)applier).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, CodeBlock.class, msgs);
			if (newApplier != null)
				msgs = ((InternalEObject)newApplier).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, CodeBlock.class, msgs);
			msgs = basicSetApplier(newApplier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__APPLIER, newApplier, newApplier));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getPostApply() {
		return postApply;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setPostApply(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostApply(CodeBlock newPostApply, NotificationChain msgs) {
		CodeBlock oldPostApply = postApply;
		postApply = newPostApply;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__POST_APPLY, oldPostApply, newPostApply);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostApply(CodeBlock newPostApply) {
		if (newPostApply != postApply) {
			NotificationChain msgs = null;
			if (postApply != null)
				msgs = ((InternalEObject)postApply).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, CodeBlock.class, msgs);
			if (newPostApply != null)
				msgs = ((InternalEObject)newPostApply).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, CodeBlock.class, msgs);
			msgs = basicSetPostApply(newPostApply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__POST_APPLY, newPostApply, newPostApply));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSuperRules() {
		if (superRules == null) {
			superRules = new EDataTypeUniqueEList<String>(String.class, this, EmftvmPackage.RULE__SUPER_RULES);
		}
		return superRules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentWithInverseEList<Field>(Field.class, this, EmftvmPackage.RULE__FIELDS, EmftvmPackage.FIELD__RULE);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinctElements() {
		return distinctElements;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistinctElements(boolean newDistinctElements) {
		boolean oldDistinctElements = distinctElements;
		distinctElements = newDistinctElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__DISTINCT_ELEMENTS, oldDistinctElements, distinctElements));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnique(boolean newUnique) {
		boolean oldUnique = unique;
		unique = newUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__UNIQUE, oldUnique, unique));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLeaf() {
		if (!leafSet) {
			leaf = !isAbstract() && !isWithLeaves();
			leafSet = true;
		}
		return leaf;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isWithLeaves() {
		if (!withLeavesSet) {
			withLeaves = false;
			for (Rule subRule : getESubRules()) {
				if (subRule.isLeaf() || subRule.isWithLeaves()) {
					withLeaves = true;
					break;
				}
			}
			withLeavesSet = true;
		}
		return withLeaves;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Field findField(Object context, String name) {
		return fieldContainer.findField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public Field findStaticField(Object context, String name) {
		return fieldContainer.findStaticField(context, name);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	public void registerField(Field field) {
		fieldContainer.registerField(field);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchSingle(StackFrame frame) {
		return ruleModeState.matchSingle(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean[] matchRecursive(StackFrame frame) {
		return ruleModeState.matchRecursive(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object matchManual(StackFrame frame, EObject[] values) {
		return ruleModeState.matchManual(frame, values);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchOne(StackFrame frame, Map<String, EObject> valuesMap) {
		for (Rule superRule : getESuperRules()) {
			if (!superRule.matchOne(frame, valuesMap)) {
				return false;
			}
		}

		// Check value types
		final ExecEnv env = frame.getEnv();
		final EObject[] values = createValuesArray(valuesMap);
		final EList<InputRuleElement> inputs = getInputElements();

		for (int index = 0; index < inputs.size(); index++) {
			InputRuleElement re = inputs.get(index);
			EObject value = valuesMap.get(re.getName());
			if (value == null) {
				throw new VMException(frame, String.format(
						"Cannot match rule input element %s against null value for %s", 
						re, this));
			}
			EList<Model> inmodels = re.getEModels();
			if (!re.getEType().isInstance(value) || 
					(!inmodels.isEmpty() && !inmodels.contains(env.getModelOf(value)))) {
				return false;
			}
			if (!distinctState.checkDistinct(values, index, value)) {
				continue;
			}

			// Check bound values
			final CodeBlock binding = re.getBinding();
			if (binding != null) {
				final Object bvalue = binding.execute(frame.getSubFrame(binding, values)).pop();
				if (bvalue == null) {
					return false; // no value, no matches
				}
				if (bvalue instanceof Collection<?>) {
					if (!((Collection<?>)bvalue).contains(value)) {
						return false;
					}
				} else {
					if (!value.equals(bvalue)) {
						return false;
					}
				}
			}
		}

		return matcherCbState.matchFor(frame, values);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createTraces(final StackFrame frame) {
		abstractState.createTraces(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean completeTraceFor(final StackFrame frame, final TraceLink trace) {
		boolean defaultMappingSet = false;
		final ExecEnv env = frame.getEnv();
		final int seSize = trace.getSourceElements().size();
		for (OutputRuleElement ore : getOutputElements()) {
			String oreName = ore.getName();
			// If there is *any* target element with the same name, it overrides us
			if (trace.getTargetElement(oreName) != null) {
				continue;
			}
			TargetElement te = TraceFactory.eINSTANCE.createTargetElement();
			te.setName(oreName);
			te.setTargetOf(trace);
			EList<SourceElement> teMapsTo = te.getMapsTo();
			for (InputRuleElement source : ore.getMapsTo()) {
				SourceElement mapsTo = trace.getSourceElement(source.getName(), false);
				assert mapsTo != null;
				teMapsTo.add(mapsTo);
			}
			if (!teMapsTo.isEmpty()) {
				defaultMappingSet |= defaultState.createDefaultMapping(env.getTraces(), teMapsTo, seSize);
				defaultMappingSet |= uniqueState.createUniqueMapping(trace.getRule(), teMapsTo, seSize);
			}
			EClass type;
			try {
				type = (EClass)env.findType(ore.getTypeModel(), ore.getType());
			} catch (ClassNotFoundException e) {
				throw new VMException(frame);
			}
			EList<Model> models = ore.getEModels();
			assert models.size() == 1;
			te.setObject(models.get(0).newElement(type));
			assert te.getObject() != null;
			assert te.getObject().eResource() != null;
			assert te.getObject().eResource() == models.get(0).getResource();
		}
		for (Rule superRule : getESuperRules()) {
			defaultMappingSet |= superRule.completeTraceFor(frame, trace);
		}
		return defaultMappingSet;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void apply(final StackFrame frame) {
		abstractState.apply(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void postApply(final StackFrame frame) {
		abstractState.postApply(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean applyFirst(final StackFrame frame) {
		return leafState.applyFirst(frame);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StackFrame applyFor(final StackFrame frame, final TraceLink trace, 
			final Map<Rule, Object[]> ruleApplyArgs, final Set<Rule> appliedRules) {
		if (appliedRules.contains(this)) {
			return null;
		} else {
			appliedRules.add(this);
		}
		StackFrame result = null;
		for (Rule superRule : getESuperRules()) {
			result = superRule.applyFor(frame, trace, ruleApplyArgs, appliedRules);
		}
		final CodeBlock cb = getApplier();
		if (cb != null) {
			final Object[] args;
			if (ruleApplyArgs.containsKey(this)) {
				args = ruleApplyArgs.get(this);
			} else {
				args = new Object[1 + 
				                  getInputElements().size() + 
				                  getOutputElements().size()];
				createArgs(trace, args);
				ruleApplyArgs.put(this, args);
			}
			result = cb.execute(frame.getSubFrame(cb, args));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StackFrame postApplyFor(final StackFrame frame, final TraceLink trace, 
			final Map<Rule, Object[]> ruleApplyArgs, final Set<Rule> appliedRules) {
		if (appliedRules.contains(this)) {
			return null;
		} else {
			appliedRules.add(this);
		}
		StackFrame result = null;
		for (Rule superRule : getESuperRules()) {
			result = superRule.postApplyFor(frame, trace, ruleApplyArgs, appliedRules);
		}
		final CodeBlock cb = getPostApply();
		if (cb != null) {
			final Object[] args;
			if (ruleApplyArgs.containsKey(this)) {
				args = ruleApplyArgs.get(this);
			} else {
				args = new Object[1 + 
				                  getInputElements().size() + 
				                  getOutputElements().size()];
				createArgs(trace, args);
				ruleApplyArgs.put(this, args);
			}
			result = cb.execute(frame.getSubFrame(cb, args));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void compileState() {
		withLeavesSet = false;
		leafSet = false;
		updateDefaultState();
		updateUniqueState();
		updateSuperRulesState();
		updateRuleModeState();
		updateLeafState();
		updateAbstractState();
		updateMatcherCbState();
		updateDistinctState();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModule((Module)otherEnd, msgs);
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputElements()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputElements()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUPER_RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESuperRules()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUB_RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESubRules()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__MATCHER:
				if (matcher != null)
					msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__MATCHER, null, msgs);
				return basicSetMatcher((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__APPLIER:
				if (applier != null)
					msgs = ((InternalEObject)applier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__APPLIER, null, msgs);
				return basicSetApplier((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__POST_APPLY:
				if (postApply != null)
					msgs = ((InternalEObject)postApply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__POST_APPLY, null, msgs);
				return basicSetPostApply((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__FIELDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				return basicSetModule(null, msgs);
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return ((InternalEList<?>)getInputElements()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return ((InternalEList<?>)getOutputElements()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUPER_RULES:
				return ((InternalEList<?>)getESuperRules()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUB_RULES:
				return ((InternalEList<?>)getESubRules()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__MATCHER:
				return basicSetMatcher(null, msgs);
			case EmftvmPackage.RULE__APPLIER:
				return basicSetApplier(null, msgs);
			case EmftvmPackage.RULE__POST_APPLY:
				return basicSetPostApply(null, msgs);
			case EmftvmPackage.RULE__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmftvmPackage.RULE__MODULE:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__RULES, Module.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				return getModule();
			case EmftvmPackage.RULE__MODE:
				return getMode();
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return getInputElements();
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return getOutputElements();
			case EmftvmPackage.RULE__ESUPER_RULES:
				return getESuperRules();
			case EmftvmPackage.RULE__ESUB_RULES:
				return getESubRules();
			case EmftvmPackage.RULE__MATCHER:
				return getMatcher();
			case EmftvmPackage.RULE__APPLIER:
				return getApplier();
			case EmftvmPackage.RULE__POST_APPLY:
				return getPostApply();
			case EmftvmPackage.RULE__SUPER_RULES:
				return getSuperRules();
			case EmftvmPackage.RULE__ABSTRACT:
				return isAbstract();
			case EmftvmPackage.RULE__FIELDS:
				return getFields();
			case EmftvmPackage.RULE__DEFAULT:
				return isDefault();
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				return isDistinctElements();
			case EmftvmPackage.RULE__UNIQUE:
				return isUnique();
			case EmftvmPackage.RULE__LEAF:
				return isLeaf();
			case EmftvmPackage.RULE__WITH_LEAVES:
				return isWithLeaves();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				setModule((Module)newValue);
				return;
			case EmftvmPackage.RULE__MODE:
				setMode((RuleMode)newValue);
				return;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				getInputElements().clear();
				getInputElements().addAll((Collection<? extends InputRuleElement>)newValue);
				return;
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				getOutputElements().clear();
				getOutputElements().addAll((Collection<? extends OutputRuleElement>)newValue);
				return;
			case EmftvmPackage.RULE__ESUPER_RULES:
				getESuperRules().clear();
				getESuperRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case EmftvmPackage.RULE__ESUB_RULES:
				getESubRules().clear();
				getESubRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case EmftvmPackage.RULE__MATCHER:
				setMatcher((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__APPLIER:
				setApplier((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__POST_APPLY:
				setPostApply((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__SUPER_RULES:
				getSuperRules().clear();
				getSuperRules().addAll((Collection<? extends String>)newValue);
				return;
			case EmftvmPackage.RULE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case EmftvmPackage.RULE__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends Field>)newValue);
				return;
			case EmftvmPackage.RULE__DEFAULT:
				setDefault((Boolean)newValue);
				return;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				setDistinctElements((Boolean)newValue);
				return;
			case EmftvmPackage.RULE__UNIQUE:
				setUnique((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				setModule((Module)null);
				return;
			case EmftvmPackage.RULE__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				getInputElements().clear();
				return;
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				getOutputElements().clear();
				return;
			case EmftvmPackage.RULE__ESUPER_RULES:
				getESuperRules().clear();
				return;
			case EmftvmPackage.RULE__ESUB_RULES:
				getESubRules().clear();
				return;
			case EmftvmPackage.RULE__MATCHER:
				setMatcher((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__APPLIER:
				setApplier((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__POST_APPLY:
				setPostApply((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__SUPER_RULES:
				getSuperRules().clear();
				return;
			case EmftvmPackage.RULE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case EmftvmPackage.RULE__FIELDS:
				getFields().clear();
				return;
			case EmftvmPackage.RULE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				setDistinctElements(DISTINCT_ELEMENTS_EDEFAULT);
				return;
			case EmftvmPackage.RULE__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.RULE__MODULE:
				return getModule() != null;
			case EmftvmPackage.RULE__MODE:
				return mode != MODE_EDEFAULT;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return inputElements != null && !inputElements.isEmpty();
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return outputElements != null && !outputElements.isEmpty();
			case EmftvmPackage.RULE__ESUPER_RULES:
				return eSuperRules != null && !eSuperRules.isEmpty();
			case EmftvmPackage.RULE__ESUB_RULES:
				return eSubRules != null && !eSubRules.isEmpty();
			case EmftvmPackage.RULE__MATCHER:
				return matcher != null;
			case EmftvmPackage.RULE__APPLIER:
				return applier != null;
			case EmftvmPackage.RULE__POST_APPLY:
				return postApply != null;
			case EmftvmPackage.RULE__SUPER_RULES:
				return superRules != null && !superRules.isEmpty();
			case EmftvmPackage.RULE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case EmftvmPackage.RULE__FIELDS:
				return fields != null && !fields.isEmpty();
			case EmftvmPackage.RULE__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				return distinctElements != DISTINCT_ELEMENTS_EDEFAULT;
			case EmftvmPackage.RULE__UNIQUE:
				return unique != UNIQUE_EDEFAULT;
			case EmftvmPackage.RULE__LEAF:
				return leaf != LEAF_EDEFAULT;
			case EmftvmPackage.RULE__WITH_LEAVES:
				return withLeaves != WITH_LEAVES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		if (abstract_) {
			result.append("abstract ");
		}
		result.append("rule ");
		result.append(super.toString());
		return result.toString();
	}

	/**
	 * Updates {@link #defaultState}.
	 */
	protected void updateDefaultState() {
		if (isDefault()) {
			if (!(defaultState instanceof DefaultOnState)) {
				defaultState = new DefaultOnState();
			}
		} else {
			if (!(defaultState instanceof DefaultOffState)) {
				defaultState = new DefaultOffState();
			}
		}
	}

	/**
	 * Updates {@link #uniqueState}.
	 */
	protected void updateUniqueState() {
		if (isUnique()) {
			if (!(uniqueState instanceof UniqueOnState)) {
				uniqueState = new UniqueOnState();
			}
		} else {
			if (!(uniqueState instanceof UniqueOffState)) {
				uniqueState = new UniqueOffState();
			}
		}
	}

	/**
	 * Updates {@link #superRulesState}.
	 */
	protected void updateSuperRulesState() {
		if (getESuperRules().isEmpty()) {
			if (!(superRulesState instanceof WithoutSuperRulesState)) {
				superRulesState = new WithoutSuperRulesState();
			}
		} else {
			if (!(superRulesState instanceof WithSuperRulesState)) {
				superRulesState = new WithSuperRulesState();
			}
		}
	}

	/**
	 * Updates {@link #ruleModeState}.
	 */
	protected void updateRuleModeState() {
		switch (getMode()) {
		case AUTOMATIC_SINGLE:
			if (!(ruleModeState instanceof AutomaticSingleState)) {
				ruleModeState = new AutomaticSingleState();
			}
			break;
		case AUTOMATIC_RECURSIVE:
			if (!(ruleModeState instanceof AutomaticRecursiveState)) {
				ruleModeState = new AutomaticRecursiveState();
			}
			break;
		case MANUAL:
			if (!(ruleModeState instanceof ManualState)) {
				ruleModeState = new ManualState();
			}
			break;
		}
	}

	/**
	 * Updates {@link #leafState}.
	 */
	protected void updateLeafState() {
		if (isLeaf()) {
			if (!(leafState instanceof IsLeafState)) {
				leafState = new IsLeafState();
			}
		} else if (isWithLeaves()) {
			if (!(leafState instanceof IsWithLeavesState)) {
				leafState = new IsWithLeavesState();
			}
		} else {
			if (!(leafState instanceof IsOtherLeafState)) {
				leafState = new IsOtherLeafState();
			}
		}
	}

	/**
	 * Updates {@link #abstractState}.
	 */
	protected void updateAbstractState() {
		if (isAbstract()) {
			if (!(abstractState instanceof IsAbstractState)) {
				abstractState = new IsAbstractState();
			}
		} else {
			if (!(abstractState instanceof IsNotAbstractState)) {
				abstractState = new IsNotAbstractState();
			}
		}
	}

	/**
	 * Updates {@link #matcherCbState}.
	 */
	protected void updateMatcherCbState() {
		if (getMatcher() != null) {
			if (!(matcherCbState instanceof WithMatcherCbState)) {
				matcherCbState = new WithMatcherCbState();
			}
		} else {
			if (!(matcherCbState instanceof WithoutMatcherCbState)) {
				matcherCbState = new WithoutMatcherCbState();
			}
		}
	}

	/**
	 * Updates {@link #distinctState}.
	 */
	protected void updateDistinctState() {
		if (isDistinctElements()) {
			if (!(distinctState instanceof IsDistinctState)) {
				distinctState = new IsDistinctState();
			}
		} else {
			if (!(distinctState instanceof IsNotDistinctState)) {
				distinctState = new IsNotDistinctState();
			}
		}
	}

	/**
	 * Matches {@link #getRule()} for the super-rule matches at <code>index</code>.
	 * @param frame the stack frame context
	 * @param values
	 * @param index
	 * @param superMatches
	 * @param iterables
	 * @param currentMatches
	 * @return <code>true</code> iff the rule matches
	 */
	private boolean matchFor(
			final StackFrame frame, 
			final Map<String, EObject> values, final int index,
			final List<TracedRule> superMatches,
			final Map<String, Iterable<EObject>> iterables,
			final Map<TracedRule, TraceLink> currentMatches) {
		boolean result = false;
		final int superSize = superMatches.size();
		if (index < superSize) {
			 // create copy to distinguish pre-existing source elements from the ones added here
			final Map<String, EObject> newValues = new LinkedHashMap<String, EObject>(values);
			final TracedRule tr = superMatches.get(index);
			MATCH:
			for (TraceLink match : tr.getLinks()) {
				for (SourceElement se : match.getSourceElements()) {
					String seName = se.getName();
					EObject seValue = se.getObject();
					if (values.containsKey(seName)) {
						if (values.get(seName) != seValue) {
							continue MATCH; // go to next match, as elements of the same name must be identical
						}
					} else if (isDistinctElements() && values.containsValue(seValue)) {
						continue MATCH; // all elements in this rule are distinct
					} else {
						newValues.put(seName, seValue);
					}
				}
				for (RuleElement re : getInputElements()) {
					String reName = re.getName();
					// Not all rule input elements exist in newValues!
					if (newValues.containsKey(reName) 
							&& !re.getEType().isInstance(newValues.get(reName))) {
						// go to next match, as elements must conform to sub-rule type
						continue MATCH;
					}
				}
				currentMatches.put(tr, match);
				result |= matchFor(frame, newValues, index + 1, superMatches, iterables, currentMatches);
			}
		} else if (!iterables.isEmpty()) {
			result = matchFor(frame, values, iterables, new ArrayList<String>(iterables.keySet()), 0);
		} else {
			result = matchFor(frame, values, createValuesArray(values), 0);
			if (result) {
				// Schedule selected parent matches for removal
				for (TraceLink link : currentMatches.values()) {
					link.setOverridden(true);
				}
			}
		}
		return result;
	}

	/**
	 * Matches {@link #getRule()} for the iterable with the key at <code>keyIndex</code>.
	 * @param frame the stack frame context
	 * @param values
	 * @param iterables
	 * @param keys
	 * @param keyIndex
	 * @return <code>true</code> iff the rule matches
	 */
	private boolean matchFor(
			final StackFrame frame, 
			final Map<String, EObject> values,
			final Map<String, Iterable<EObject>> iterables,
			final List<String> keys,
			int keyIndex) {
		final int size = iterables.size();
		if (keyIndex < size) {
			boolean result = false;
			final String key = keys.get(keyIndex);
			assert !values.containsKey(key);
			for (EObject o : iterables.get(key)) {
				if (isDistinctElements() && values.containsValue(o)) {
					continue; // all elements in this rule are distinct
				}
				values.put(key, o);
				result |= matchFor(frame, values, iterables, keys, keyIndex + 1);
				values.remove(key);
			}
			return result;
		} else {
			return matchFor(frame, values, createValuesArray(values), 0);
		}
	}

	/**
	 * Matches {@link #getRule()} for each value of <code>iterables.get(i)</code>, for
	 * <code>i = index .. values.length</code>.
	 * Invokes pre-apply code for each match.
	 * @param frame the stack frame context
	 * @param values the values array to fill, and pass to the matcher/pre-apply code
	 * @param index the current index of <code>values</code> and <code>iterables</code>
	 * @param iterables the collections over which to iterate
	 */
	private boolean matchFor(final StackFrame frame, final EObject[] values, final int index, 
			final List<Iterable<EObject>> iterables) {
		assert values.length == iterables.size();
		int newIndex = index;
		while (newIndex < values.length && iterables.get(newIndex) == null) { // bound rule elements
			newIndex++;
		}

		if (newIndex < values.length) {
			boolean result = false;
			
			for (EObject o : iterables.get(newIndex)) {
				if (!distinctState.checkDistinct(values, newIndex, o)) {
					continue; // all elements in this rule are distinct
				}
				values[newIndex] = o;
				result |= matchFor(frame, values, newIndex + 1, iterables);
				values[newIndex] = null;
			}
			
			return result;
		} else {
			return matchFor(frame, values, 0);
		}
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param frame the stack frame context
	 * @param values
	 * @param index the current rule input element index to check (starts at 0)
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	@SuppressWarnings("unchecked")
	private boolean matchFor(final StackFrame frame, final EObject[] values, final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values)).pop();
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>)value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					boolean result = false;
					for (EObject v : (Collection<EObject>)value) {
						if (!ire.getEType().isInstance(v) || !distinctState.checkDistinct(values, values.length - 1, v)) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						result |= matchFor(frame, values, index + 1);
						values[index] = null;
					}
					return result;
				} else {
					if (!ire.getEType().isInstance(value) || !distinctState.checkDistinct(values, values.length - 1, value)) {
						return false; // all elements in this rule are distinct
					}
					values[index] = (EObject)value;
					final boolean result = matchFor(frame, values, index + 1);
					values[index] = null;
					return result;
				}
			}
			return matchFor(frame, values, index + 1);
		}

		// Match values
		return uniqueState.matchFor(frame, values);
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param frame the stack frame context
	 * @param valuesMap the map of all values, including super-rule elements
	 * @param values
	 * @param index the current rule input element index to check (starts at 0)
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	@SuppressWarnings("unchecked")
	private boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
			final EObject[] values,	final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values)).pop();
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>)value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					final String key = ire.getName();
					boolean result = false;
					for (EObject v : (Collection<EObject>)value) {
						if (!ire.getEType().isInstance(v) || 
								(isDistinctElements() && valuesMap.containsValue(v))) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						valuesMap.put(key, v);
						result |= matchFor(frame, valuesMap, values, index + 1);
						valuesMap.remove(key);
						values[index] = null;
					}
					return result;
				} else {
					if (!ire.getEType().isInstance(value) || 
							(isDistinctElements() && valuesMap.containsValue(value))) {
						return false; // all elements in this rule are distinct
					}
					final String key = ire.getName();
					values[index] = (EObject)value;
					valuesMap.put(key, (EObject)value);
					final boolean result = matchFor(frame, valuesMap, values, index + 1);
					valuesMap.remove(key);
					values[index] = null;
					return result;
				}
			}
			return matchFor(frame, valuesMap, values, index + 1);
		}

		// Match values
		return uniqueState.matchFor(frame, valuesMap, values);
	}

	/**
	 * Matches this rule against <code>values</code>,
	 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
	 * @param frame the stack frame context
	 * @param values the source values to match against
	 * @return <code>true</code> iff this rule matches against <code>values</code>
	 */
	//TODO remove
//	private boolean matchFor(final StackFrame frame, final EObject[] values) {
//		if (matcherCbState.matchFor(frame, values)) {
//			final TraceLink match = TraceFactory.eINSTANCE.createTraceLink();
//			final EList<SourceElement> ses = match.getSourceElements();
//			int i = 0;
//			for (RuleElement re : getInputElements()) {
//				SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
//				se.setName(re.getName());
//				se.setObject(values[i++]);
//				ses.add(se);
//			}
//			frame.getEnv().getMatches().getLinksByRule(getName(), true).getLinks().add(match);
//			return true;
//		} else {
//			return false;
//		}
//	}

	/**
	 * Matches this rule against <code>values</code>,
	 * and records a match in {@link ExecEnv#getMatches()} in case of a match.
	 * @param frame the stack frame context
	 * @param valuesMap the map of all values, including super-rule elements
	 * @param values the source values to match against
	 * @return <code>true</code> iff this rule matches against <code>values</code>
	 */
	//TODO remove
//	private boolean matchFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
//			final EObject[] values) {
//		if (matcherCbState.matchFor(frame, values)) {
//			final TraceLink match = TraceFactory.eINSTANCE.createTraceLink();
//			final EList<SourceElement> ses = match.getSourceElements();
//			// Add all values for the match, not just the ones specified in the rule signature
//			for (Entry<String, EObject> v : valuesMap.entrySet()) {
//				SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
//				se.setName(v.getKey());
//				se.setObject(v.getValue());
//				ses.add(se);
//			}
//			frame.getEnv().getMatches().getLinksByRule(getName(), true).getLinks().add(match);
//			return true;
//		} else {
//			return false;
//		}
//	}

	/**
	 * Matches up to one match for {@link #getRule()} for the super-rule matches at <code>index</code>.
	 * @param frame the stack frame context
	 * @param values
	 * @param index
	 * @param superMatches
	 * @param iterables
	 * @param currentMatches
	 * @return <code>true</code> iff the rule matches
	 */
	private boolean matchOneFor(
			final StackFrame frame, 
			final Map<String, EObject> values, final int index,
			final List<TracedRule> superMatches,
			final Map<String, Iterable<EObject>> iterables,
			final Map<TracedRule, TraceLink> currentMatches) {
		final int superSize = superMatches.size();
		if (index < superSize) {
			 // create copy to distinguish pre-existing source elements from the ones added here
			final Map<String, EObject> newValues = new LinkedHashMap<String, EObject>(values);
			final TracedRule tr = superMatches.get(index);
			MATCH:
			for (TraceLink match : tr.getLinks()) {
				for (SourceElement se : match.getSourceElements()) {
					String seName = se.getName();
					EObject seValue = se.getObject();
					if (values.containsKey(seName)) {
						if (values.get(seName) != seValue) {
							continue MATCH; // go to next match, as elements of the same name must be identical
						}
					} else if (isDistinctElements() && values.containsValue(seValue)) {
						continue MATCH; // all elements in this rule are distinct
					} else {
						newValues.put(seName, seValue);
					}
				}
				for (RuleElement re : getInputElements()) {
					String reName = re.getName();
					// Not all rule input elements exist in newValues!
					if (newValues.containsKey(reName) 
							&& !re.getEType().isInstance(newValues.get(reName))) {
						// go to next match, as elements must conform to sub-rule type
						continue MATCH;
					}
				}
				currentMatches.put(tr, match);
				if (matchOneFor(frame, newValues, index + 1, superMatches, iterables, currentMatches)) {
					return true;
				}
			}
			return false;
		} else if (!iterables.isEmpty()) {
			return matchOneFor(frame, values, iterables, new ArrayList<String>(iterables.keySet()), 0);
		} else {
			final boolean result;
			result = matchOneFor(frame, values, createValuesArray(values), 0);
			if (result) {
				// Schedule selected parent matches for removal
				for (TraceLink link : currentMatches.values()) {
					link.setOverridden(true);
				}
			}
			return result;
		}
	}

	/**
	 * Matches up to one match for {@link #getRule()} for the iterable with the key at <code>keyIndex</code>.
	 * @param values
	 * @param iterables
	 * @param keys
	 * @param keyIndex
	 */
	private boolean matchOneFor(
			final StackFrame frame, 
			final Map<String, EObject> values,
			final Map<String, Iterable<EObject>> iterables,
			final List<String> keys,
			int keyIndex) {
		final int size = iterables.size();
		if (keyIndex < size) {
			final String key = keys.get(keyIndex);
			assert !values.containsKey(key);
			for (EObject o : iterables.get(key)) {
				if (isDistinctElements() && values.containsValue(o)) {
					continue; // all elements in this rule are distinct
				}
				values.put(key, o);
				if (matchOneFor(frame, values, iterables, keys, keyIndex + 1)) {
					values.remove(key);
					return true;
				}
				values.remove(key);
			}
			return false;
		} else {
			return matchOneFor(frame, values, createValuesArray(values), 0);
		}
	}

	/**
	 * Matches <code>rule</code> for each value of <code>iterables.get(i)</code>, for
	 * <code>i = index .. values.length</code>.
	 * Invokes pre-apply code for each match.
	 * @param values the values array to fill, and pass to the matcher/pre-apply code
	 * @param index the current index of <code>values</code> and <code>iterables</code>
	 * @param iterables the collections over which to iterate
	 */
	private boolean matchOneFor(final StackFrame frame, final EObject[] values, final int index, 
			final List<Iterable<EObject>> iterables) {
		assert values.length == iterables.size();
		int newIndex = index;
		while (newIndex < values.length && iterables.get(newIndex) == null) { // bound rule elements
			newIndex++;
		}

		if (newIndex < values.length) {
			for (EObject o : iterables.get(newIndex)) {
				if (!distinctState.checkDistinct(values, newIndex, o)) {
					continue;
				}
				values[newIndex] = o;
				if (matchOneFor(frame, values, newIndex + 1, iterables)) {
					values[newIndex] = null;
					return true;
				}
				values[newIndex] = null;
			}
			return false;
		} else {
			return matchOneFor(frame, values, 0);
		}
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param values
	 * @param index the current rule input element index to check (starts at 0)
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	@SuppressWarnings("unchecked")
	private boolean matchOneFor(final StackFrame frame, final EObject[] values, final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values)).pop();
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>)value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					for (EObject v : (Collection<EObject>)value) {
						if (!ire.getEType().isInstance(v) || !distinctState.checkDistinct(values, values.length - 1, v)) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						if (matchOneFor(frame, values, index + 1)) {
							values[index] = null;
							return true;
						}
						values[index] = null;
					}
					return false;
				} else {
					if (!ire.getEType().isInstance(value) || !distinctState.checkDistinct(values, values.length - 1, value)) {
						return false; // all elements in this rule are distinct
					}
					values[index] = (EObject)value;
					final boolean result = matchOneFor(frame, values, index + 1);
					values[index] = null;
					return result;
				}
			}
			return matchOneFor(frame, values, index + 1);
		}

		// Match values
		return uniqueState.matchFor(frame, values);
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param valuesMap the map of all values, including super-rule elements
	 * @param values
	 * @param index the current rule input element index to check (starts at 0)
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	@SuppressWarnings("unchecked")
	private boolean matchOneFor(final StackFrame frame, final Map<String, EObject> valuesMap, 
			final EObject[] values, final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values)).pop();
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>)value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					final String key = ire.getName();
					for (EObject v : (Collection<EObject>)value) {
						if (!ire.getEType().isInstance(v) || 
								(isDistinctElements() && valuesMap.containsValue(v))) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						valuesMap.put(key, v);
						if (matchOneFor(frame, valuesMap, values, index + 1)) {
							values[index] = null;
							return true;
						}
						valuesMap.remove(key);
						values[index] = null;
					}
					return false;
				} else {
					if (!ire.getEType().isInstance(value) || 
							(isDistinctElements() && valuesMap.containsValue(value))) {
						return false; // all elements in this rule are distinct
					}
					final String key = ire.getName();
					values[index] = (EObject)value;
					valuesMap.put(key, (EObject)value);
					final boolean result = matchOneFor(frame, valuesMap, values, index + 1);
					valuesMap.remove(key);
					values[index] = null;
					return result;
				}
			}
			return matchOneFor(frame, valuesMap, values, index + 1);
		}
		
		// Match values
		return uniqueState.matchFor(frame, valuesMap, values);
	}

	/**
	 * Creates a value array for this rule out of <code>values</code>.
	 * @param values
	 * @return a value array out of <code>values</code>.
	 */
	private EObject[] createValuesArray(final Map<String, EObject> values) {
		final EList<InputRuleElement> allInput = getInputElements();
		final EObject[] valuesArray = new EObject[allInput.size()];
		int i = 0;
		for (InputRuleElement re : allInput) {
			valuesArray[i++] = values.get(re.getName());
			// null values allowed, as long as they are later filled in by bound elements
			assert re.getBinding() != null || valuesArray[i - 1] != null;
			assert valuesArray[i - 1] == null || re.getEType().isInstance(valuesArray[i - 1]);
		}
		return valuesArray;
	}

	/**
	 * Creates a value map for <code>rule</code> out of <code>values</code>.
	 * @param values
	 * @return a value map for <code>rule</code> out of <code>values</code>.
	 */
	private Map<String, EObject> createValuesMap(final EObject[] values) {
		final EList<InputRuleElement> allInput = getInputElements();
		final Map<String, EObject> valuesMap = new HashMap<String, EObject>(allInput.size());
		assert allInput.size() == values.length;
		int i = 0;
		for (RuleElement re : allInput) {
			valuesMap.put(re.getName(), values[i++]);
			assert values[i - 1] != null;
		}
		return valuesMap;
	}

	/**
	 * Creates one trace element for this rule, for <code>values</code>.
	 * @param frame the stack frame context
	 * @param values the values to include in the trace link
	 * @return the created trace link
	 */
	private TraceLink createTrace(final StackFrame frame, final Map<String, EObject> values) {
		final TraceLinkSet traces = frame.getEnv().getTraces();
		final String ruleName = getName();
		final TracedRule tr = traces.getLinksByRule(ruleName, true);
		// Create trace links for input values
		final TraceLink trace = TraceFactory.eINSTANCE.createTraceLink();
		tr.getLinks().add(trace);
		final EList<SourceElement> ses = trace.getSourceElements();
		//Add all values for the trace, not just the ones specified in the rule signature
		for (Entry<String, EObject> v : values.entrySet()) {
			SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
			se.setName(v.getKey());
			se.setObject(v.getValue());
			ses.add(se);
		}
		// Complete trace for all output values
		final boolean defaultMappingSet = completeTraceFor(frame, trace);
		// Set as default/unique if applicable
		if (!defaultMappingSet) {
			defaultState.createDefaultMapping(traces, ses);
			uniqueState.createUniqueMapping(tr, ses);
		}
		return trace;
	}

	/**
	 * Creates a trace element for the first recorded match for this rule.
	 * @param frame the stack frame context
	 * @return the created trace element
	 */
	private TraceLink createFirstTrace(final StackFrame frame) {
		final ExecEnv env = frame.getEnv();
		final String ruleName = getName();
		// Matches become traces
		final TracedRule tr = env.getMatches().getLinksByRule(ruleName, false);
		if (tr == null) {
			throw new VMException(frame, String.format(
					"Cannot create a trace for rule %s; no matches exist",
					this));
		}
		for (Iterator<TraceLink> links = tr.getLinks().iterator(); links.hasNext();) {
			TraceLink trace = links.next();
			if (trace.isOverridden()) {
				links.remove(); // This match is overridden by a sub-rule
				continue;
			}
			final boolean defaultMappingSet = completeTraceFor(frame, trace);
			final TraceLinkSet traces = env.getTraces();
			final TracedRule ntr = traces.getLinksByRule(ruleName, true);
			ntr.getLinks().add(trace);
			// Set as default/unique if applicable
			if (!defaultMappingSet) {
				final EList<SourceElement> ses = trace.getSourceElements();
				defaultState.createDefaultMapping(traces, ses);
				uniqueState.createUniqueMapping(tr, ses);
			}
			return trace;
		}
		return null;
	}

	/**
	 * Applies {@link #getRule()} to <code>trace</code>
	 * @param frame the stack frame in which to execute the applier and post-apply
	 * @param trace the source and target values to which to apply the rule
	 * @return the rule application result
	 */
	private Object applyTo(final StackFrame frame, final TraceLink trace) {
		final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
		final StackFrame applyResult = applyFor(frame, trace, ruleApplyArgs, new HashSet<Rule>());
		final StackFrame postResult = postApplyFor(frame, trace, ruleApplyArgs, new HashSet<Rule>());
		final StackFrame result = (postResult == null || postResult.stackEmpty()) ? applyResult : postResult;
		return (result == null || result.stackEmpty()) ? null : result.pop();
	}

	/**
	 * Creates applier invocation arguments for this rule from <code>trace</code>.
	 * @param trace
	 * @return applier invocation arguments for <code>rule</code>
	 */
	private void createArgs(final TraceLink trace, final Object[] args) {
		final EList<InputRuleElement> input = getInputElements();
		final EList<OutputRuleElement> output = getOutputElements();
		assert args.length == 1 + input.size() + output.size();
		args[0] = trace;
		int i = 1;
		for (InputRuleElement ire : input) {
			args[i++] = trace.getSourceElement(ire.getName(), false).getObject();
			assert args[i - 1] != null;
		}
		for (OutputRuleElement ore : output) {
			args[i++] = trace.getTargetElement(ore.getName()).getObject();
			assert args[i - 1] != null;
		}
		assert i == args.length;
	}

} //RuleImpl
