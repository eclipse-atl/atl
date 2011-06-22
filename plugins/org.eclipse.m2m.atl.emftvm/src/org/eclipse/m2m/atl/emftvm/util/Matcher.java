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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Model;
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


/**
 * {@link Rule} matching functionality for automatic rules.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class Matcher {

	/**
	 * Matches all automatic rules available via <code>frame</code>
	 * @param timingData
	 * @param frame
	 */
	public static void matchAll(final StackFrame frame, final TimingData timingData) {
		matchAllSingle(frame, timingData);
		matchAllRecursive(frame);
		timingData.finishRecursive();
	}

	/**
	 * Matches <code>rule</code> against <code>values</code>.
	 * Assumes <code>rule</code> is of kind {@link RuleMode#MANUAL}.
	 * @param frame
	 * @param rule
	 * @param values
	 * @return the rule application result, or <code>null</code> if the rule did not match
	 */
	public static Object matchOne(final StackFrame frame, final Rule rule, final EObject[] values) {
		final Map<String, EObject> valuesMap = createValuesMap(rule, values);
		final Matcher matcher = new Matcher(frame, rule);
		if (matcher.matchOne(valuesMap)) {
			final TraceLink trace = matcher.createTrace(valuesMap);
			final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
			final Object applyResult = matcher.applyFor(trace, rule, ruleApplyArgs);
			final Object postResult = matcher.postApplyFor(trace, rule, ruleApplyArgs);
			return (postResult == null) ? applyResult : postResult;
		} else {
			return null;
		}
	}

	/**
	 * @param rules
	 * @param kind
	 * @return all rules from <code>rules</code> of mode <code>kind</code>.
	 */
	private static List<Rule> getRulesOfKind(final List<Rule> rules, final RuleMode kind) {
		final List<Rule> rulesOfKind = new ArrayList<Rule>(rules.size());
		for (Rule rule : rules) {
			if (rule.getMode() == kind) {
				rulesOfKind.add(rule);
			}
		}
		return rulesOfKind;
	}

	/**
	 * Matches all {@link RuleMode#AUTOMATIC_SINGLE} rules.
	 * @param frame
	 * @param timingData
	 */
	private static void matchAllSingle(final StackFrame frame, final TimingData timingData) {
		// Retrieve automatic single rules
		final ExecEnv env = frame.getEnv();
		final List<Rule> rules = getRulesOfKind(env.getRules(), RuleMode.AUTOMATIC_SINGLE);
		// Match automatic single rules
		final Set<Rule> matchedRules = new LinkedHashSet<Rule>();
		boolean match;
		do {
			match = false;
			for (Rule rule : rules) {
				// Only match rules for which all super-rules have already been matched
				if (!matchedRules.contains(rule) && matchedRules.containsAll(rule.getESuperRules())) {
					Matcher matcher = new Matcher(frame, rule);
					if (matcher.match()) {
						match = true;
						matchedRules.add(rule); // only add rules that match
					}
				}
			}
		} while (match);
		// Create traces for automatic single rules
		for (Rule rule : matchedRules) {
			if (!rule.isAbstract()) {
				Matcher matcher = new Matcher(frame, rule);
				matcher.createTraces();
			}
		}
		timingData.finishMatch();
		// Apply rules
		for (Rule rule : matchedRules) {
			if (!rule.isAbstract()) {
				Matcher matcher = new Matcher(frame, rule);
				matcher.apply();
			}
		}
		timingData.finishApply();
		// Run post-apply
		for (Rule rule : matchedRules) {
			if (!rule.isAbstract()) {
				Matcher matcher = new Matcher(frame, rule);
				matcher.postApply();
			}
		}
		env.deleteQueue();
		timingData.finishPostApply();
	}

	/**
	 * Matches all {@link RuleMode#AUTOMATIC_RECURSIVE} rules.
	 * @param frame
	 */
	private static void matchAllRecursive(final StackFrame frame) {
		// Retrieve automatic recursive rules
		final ExecEnv env = frame.getEnv();
		final List<Rule> rules = getRulesOfKind(env.getRules(), RuleMode.AUTOMATIC_RECURSIVE);
		final Set<Rule> matchedRules = new LinkedHashSet<Rule>();
		
		boolean outerMatch;
		do {
			outerMatch = false;
			
			// Match automatic recursive rules
			matchedRules.clear();
			boolean match;
			MATCHER:
			do {
				match = false;
				for (Rule rule : rules) {
					// Only match rules for which all super-rules have already been matched
					if (!matchedRules.contains(rule) && matchedRules.containsAll(rule.getESuperRules())) {
						if (rule.getESubRules().isEmpty()) {
							if (!rule.isAbstract()) {
								Matcher matcher = new Matcher(frame, rule);
								if (matcher.matchOne()) {
									outerMatch = true;
									matchedRules.add(rule);
									// Guaranteed final match
									break MATCHER;
								}
							}
						} else {
							Matcher matcher = new Matcher(frame, rule);
							if (matcher.match()) {
								match = true;
								outerMatch |= !rule.isAbstract();
								matchedRules.add(rule); // only add rules that match
							}
						}
					}
				}
			} while (match);

			// Apply first non-abstract match without non-abstract sub-rule matches
			MATCHED_RULES:
			for (Rule rule : matchedRules) {
				if (rule.isAbstract()) {
					continue;
				}
				for (Rule subRule : rule.getESubRules()) {
					if (matchedRules.contains(subRule) && !subRule.isAbstract()) {
						continue MATCHED_RULES;
					}
				}
				final Matcher matcher = new Matcher(frame, rule);
				final TraceLink trace = matcher.createFirstTrace();
				assert trace != null;
				matcher.getMatches().getRules().clear();
				matcher.getMatches().getDefaultSourceElements().clear();
				final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
				matcher.applyFor(trace, rule, ruleApplyArgs);
				matcher.postApplyFor(trace, rule, ruleApplyArgs);
				env.deleteQueue();
				break;
			}
			
		} while (outerMatch);		
	}

	private final TraceFactory factory = TraceFactory.eINSTANCE;
	private final StackFrame frame;
	private final Rule rule;
	private TraceLinkSet matches;
	private TraceLinkSet traces;

	/**
	 * Creates a new {@link Matcher}.
	 * @param frame
	 * @param rule
	 */
	public Matcher(final StackFrame frame, final Rule rule) {
		super();
		this.frame = frame;
		this.rule = rule;
	}

	/**
	 * Matches {@link #getRule()}.
	 * @return <code>true</code> iff the rule has any matches
	 */
	public boolean match() {
		final ExecEnv env = frame.getEnv();
		final EList<Rule> superRules = rule.getESuperRules();
		if (superRules.isEmpty()) {
			// Create value iterables and initial value array
			final EList<InputRuleElement> allInputs = rule.getInputElements();
			final List<Iterable<EObject>> iterables = new ArrayList<Iterable<EObject>>(allInputs.size());
			for (InputRuleElement re : allInputs) {
				if (re.getBinding() != null) {
					// Skip bound elements until all non-bound values have been set
					iterables.add(null);
				} else {
					iterables.add(createIterableFor(env, re));
				}
			}
			final EObject[] values = new EObject[iterables.size()];
			// Do the matching
			return matchFor(values, 0, iterables);
		} else {
			// Retrieve super-rule matches
			final List<TracedRule> superMatches = new ArrayList<TracedRule>();
			final java.util.Set<String> superRuleElementNames = new HashSet<String>();
			final TraceLinkSet matches = getMatches();
			for (Rule superRule : superRules) {
				TracedRule superMatch = matches.getLinksByRule(superRule.getName(), false);
				assert superMatch != null;
				superMatches.add(superMatch);
				for (RuleElement re : superRule.getInputElements()) {
					superRuleElementNames.add(re.getName());
				}
			}
			// Retrieve additional input elements
			final Map<String, Iterable<EObject>> iterables = new HashMap<String, Iterable<EObject>>();
			final EList<InputRuleElement> allInput = rule.getInputElements();
			for (InputRuleElement re : allInput) {
				String name = re.getName();
				if (!superRuleElementNames.contains(name) && re.getBinding() == null) {
					// Skip bound elements until all non-bound values have been set
					iterables.put(name, createIterableFor(env, re));
				}
			}
			// Do the matching
			final Map<String, EObject> values = new HashMap<String, EObject>(allInput.size());
			return matchFor(values, 0, superMatches, iterables, new HashMap<TracedRule, TraceLink>(superRules.size()));
		}
	}

	/**
	 * Matches {@link #getRule()} for the super-rule matches at <code>index</code>.
	 * @param values
	 * @param index
	 * @param superMatches
	 * @param iterables
	 * @param currentMatches
	 * @return
	 */
	private boolean matchFor(
			final Map<String, EObject> values, final int index,
			final List<TracedRule> superMatches,
			final Map<String, Iterable<EObject>> iterables,
			final Map<TracedRule, TraceLink> currentMatches) {
		boolean result = false;
		final int superSize = superMatches.size();
		if (index < superSize) {
			 // create copy to distinguish pre-existing source elements from the ones added here
			final Map<String, EObject> newValues = new HashMap<String, EObject>(values);
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
					} else if (rule.isDistinctElements() && values.containsValue(seValue)) {
						continue MATCH; // all elements in this rule are distinct
					} else {
						newValues.put(seName, seValue);
					}
				}
				for (RuleElement re : rule.getInputElements()) {
					String reName = re.getName();
					// Not all rule input elements exist in newValues!
					if (newValues.containsKey(reName) 
							&& !re.getEType().isInstance(newValues.get(reName))) {
						// go to next match, as elements must conform to sub-rule type
						continue MATCH;
					}
				}
				currentMatches.put(tr, match);
				result |= matchFor(newValues, index + 1, superMatches, iterables, currentMatches);
			}
		} else if (!iterables.isEmpty()) {
			result = matchFor(values, iterables, new ArrayList<String>(iterables.keySet()), 0);
		} else {
			result = matchFor(values, createValuesArray(rule, values), 0);
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
	 * @param values
	 * @param iterables
	 * @param keys
	 * @param keyIndex
	 */
	private boolean matchFor(
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
				if (rule.isDistinctElements() && values.containsValue(o)) {
					continue; // all elements in this rule are distinct
				}
				values.put(key, o);
				result |= matchFor(values, iterables, keys, keyIndex + 1);
				values.remove(key);
			}
			return result;
		} else {
			return matchFor(values, createValuesArray(rule, values), 0);
		}
	}

	/**
	 * Creates a value array for <code>rule</code> out of <code>values</code>.
	 * @param rule
	 * @param values
	 * @return a value array for <code>rule</code> out of <code>values</code>.
	 */
	private static EObject[] createValuesArray(final Rule rule, final Map<String, EObject> values) {
		final EList<InputRuleElement> allInput = rule.getInputElements();
		final EObject[] valuesArray = new EObject[allInput.size()];
		int i = 0;
		for (InputRuleElement re : allInput) {
			valuesArray[i++] = values.get(re.getName());
			// null values allowed, as long as they are later filled in by bound elements
			assert re.getBinding() != null || valuesArray[i-1] != null;
			assert valuesArray[i-1] == null || re.getEType().isInstance(valuesArray[i-1]);
		}
		return valuesArray;
	}

	/**
	 * Creates a value map for <code>rule</code> out of <code>values</code>.
	 * @param rule
	 * @param values
	 * @return a value map for <code>rule</code> out of <code>values</code>.
	 */
	private static Map<String, EObject> createValuesMap(final Rule rule, final EObject[] values) {
		final EList<InputRuleElement> allInput = rule.getInputElements();
		final Map<String, EObject> valuesMap = new HashMap<String, EObject>(allInput.size());
		assert allInput.size() == values.length;
		int i = 0;
		for (RuleElement re : allInput) {
			valuesMap.put(re.getName(), values[i++]);
			assert values[i-1] != null;
		}
		return valuesMap;
	}

	/**
	 * @param values the currently collected values
	 * @param index the index up to which to check the <code>values</code>
	 * @param value the value to check against <code>values</code>
	 * @return <code>true</code> iff <code>value</code> is ok
	 */
	private boolean checkDistinct(final EObject[] values, final int index, final Object value) {
		if (rule.isDistinctElements()) {
			for (int i = 0; i < index; i++) {
				if (values[i] == value) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Matches {@link #getRule()} for each value of <code>iterables.get(i)</code>, for
	 * <code>i = index .. values.length</code>.
	 * Invokes pre-apply code for each match.
	 * @param values the values array to fill, and pass to the matcher/pre-apply code
	 * @param index the current index of <code>values</code> and <code>iterables</code>
	 * @param iterables the collections over which to iterate
	 */
	private boolean matchFor(final EObject[] values, int index, 
			final List<Iterable<EObject>> iterables) {
		assert values.length == iterables.size();
		while (index < values.length && iterables.get(index) == null) { // bound rule elements
			index++;
		}

		if (index < values.length) {
			boolean result = false;
			
			for (EObject o : iterables.get(index)) {
				if (!checkDistinct(values, index, o)) {
					continue; // all elements in this rule are distinct
				}
				values[index] = o;
				result |= matchFor(values, index + 1, iterables);
				values[index] = null;
			}
			
			return result;
		} else {
			return matchFor(values, 0);
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
	private boolean matchFor(final EObject[] values, final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = rule.getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values));
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>) value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					boolean result = false;
					for (EObject v : (Collection<EObject>) value) {
						if (!ire.getEType().isInstance(v) || !checkDistinct(values, values.length-1, v)) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						result |= matchFor(values, index + 1);
						values[index] = null;
					}
					return result;
				} else {
					if (!ire.getEType().isInstance(value) || !checkDistinct(values, values.length-1, value)) {
						return false; // all elements in this rule are distinct
					}
					values[index] = (EObject) value;
					final boolean result = matchFor(values, index + 1);
					values[index] = null;
					return result;
				}
			}
			return matchFor(values, index + 1);
		}

		// Match values
		return matchFor(values);
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
	private boolean matchFor(final Map<String, EObject> valuesMap, final EObject[] values, 
			final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = rule.getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values));
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>) value).contains(values[index])) {
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
					for (EObject v : (Collection<EObject>) value) {
						if (!ire.getEType().isInstance(v) || 
								(rule.isDistinctElements() && valuesMap.containsValue(v))) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						valuesMap.put(key, v);
						result |= matchFor(valuesMap, values, index + 1);
						valuesMap.remove(key);
						values[index] = null;
					}
					return result;
				} else {
					if (!ire.getEType().isInstance(value) || 
							(rule.isDistinctElements() && valuesMap.containsValue(value))) {
						return false; // all elements in this rule are distinct
					}
					final String key = ire.getName();
					values[index] = (EObject) value;
					valuesMap.put(key, (EObject) value);
					final boolean result = matchFor(valuesMap, values, index + 1);
					valuesMap.remove(key);
					values[index] = null;
					return result;
				}
			}
			return matchFor(valuesMap, values, index + 1);
		}

		// Match values
		return matchFor(valuesMap, values);
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param values
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	private boolean matchFor(final EObject[] values) {
		// Match values
		final CodeBlock cb = rule.getMatcher();
		if (cb == null || (Boolean) cb.execute(frame.getSubFrame(cb, values))) {
			// Add new match
			final String ruleName = rule.getName();
			final TraceLinkSet matches = getMatches();
			final TracedRule tr = matches.getLinksByRule(ruleName, true);
			final TraceLink match = factory.createTraceLink();
			tr.getLinks().add(match);
			final EList<SourceElement> ses = match.getSourceElements();
			int i = 0;
			for (RuleElement re : rule.getInputElements()) {
				SourceElement se = factory.createSourceElement();
				se.setName(re.getName());
				se.setObject(values[i++]);
				ses.add(se);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Matches {@link #getRule()} against <code>values</code>,
	 * and records a match in the "matches" {@link TraceLinkSet} in case of a match.
	 * @param valuesMap the map of all values, including super-rule elements
	 * @param values
	 * @return <code>true</code> iff <code>rule</code> matches against <code>values</code>
	 */
	private boolean matchFor(final Map<String, EObject> valuesMap, final EObject[] values) {
		// Match values
		final CodeBlock cb = rule.getMatcher();
		if (cb == null || (Boolean) cb.execute(frame.getSubFrame(cb, values))) {
			// Add new match
			final String ruleName = rule.getName();
			final TraceLinkSet matches = getMatches();
			final TracedRule tr = matches.getLinksByRule(ruleName, true);
			final TraceLink match = factory.createTraceLink();
			tr.getLinks().add(match);
			final EList<SourceElement> ses = match.getSourceElements();
			// Add all values for the match, not just the ones specified in the rule signature
			for (Entry<String, EObject> v : valuesMap.entrySet()) {
				SourceElement se = factory.createSourceElement();
				se.setName(v.getKey());
				se.setObject(v.getValue());
				ses.add(se);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Matches up to one match for {@link #getRule()}.
	 * @return <code>true</code> iff the rule has any matches
	 */
	public boolean matchOne() {
		final ExecEnv env = frame.getEnv();
		final EList<Rule> superRules = rule.getESuperRules();
		if (superRules.isEmpty()) {
			// Create value iterables and initial value array
			final EList<InputRuleElement> allInputs = rule.getInputElements();
			final List<Iterable<EObject>> iterables = new ArrayList<Iterable<EObject>>(allInputs.size());
			for (InputRuleElement re : allInputs) {
				if (re.getBinding() != null) {
					// Skip bound elements until all non-bound values have been set
					iterables.add(null);
				} else {
					iterables.add(createIterableFor(env, re));
				}
			}
			final EObject[] values = new EObject[iterables.size()];
			// Do the matching
			return matchOneFor(values, 0, iterables);
		} else {
			// Retrieve super-rule matches
			final List<TracedRule> superMatches = new ArrayList<TracedRule>();
			final java.util.Set<String> superRuleElementNames = new HashSet<String>();
			final TraceLinkSet matches = getMatches();
			for (Rule superRule : superRules) {
				TracedRule superMatch = matches.getLinksByRule(superRule.getName(), false);
				assert superMatch != null;
				superMatches.add(superMatch);
				for (RuleElement re : superRule.getInputElements()) {
					superRuleElementNames.add(re.getName());
				}
			}
			// Retrieve additional input elements
			final Map<String, Iterable<EObject>> iterables = new HashMap<String, Iterable<EObject>>();
			final EList<InputRuleElement> allInput = rule.getInputElements();
			for (InputRuleElement re : allInput) {
				String name = re.getName();
				if (!superRuleElementNames.contains(name) && re.getBinding() == null) {
					// Skip bound elements until all non-bound values have been set
					iterables.put(name, createIterableFor(env, re));
				}
			}
			// Do the matching
			final Map<String, EObject> values = new HashMap<String, EObject>(allInput.size());
			return matchOneFor(values, 0, superMatches, iterables, new HashMap<TracedRule, TraceLink>(superRules.size()));
		}
	}

	/**
	 * Matches up to one match for {@link #getRule()} for the super-rule matches at <code>index</code>.
	 * @param values
	 * @param index
	 * @param superMatches
	 * @param iterables
	 * @param currentMatches
	 * @return
	 */
	private boolean matchOneFor(
			final Map<String, EObject> values, final int index,
			final List<TracedRule> superMatches,
			final Map<String, Iterable<EObject>> iterables,
			final Map<TracedRule, TraceLink> currentMatches) {
		final int superSize = superMatches.size();
		if (index < superSize) {
			 // create copy to distinguish pre-existing source elements from the ones added here
			final Map<String, EObject> newValues = new HashMap<String, EObject>(values);
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
					} else if (rule.isDistinctElements() && values.containsValue(seValue)) {
						continue MATCH; // all elements in this rule are distinct
					} else {
						newValues.put(seName, seValue);
					}
				}
				for (RuleElement re : rule.getInputElements()) {
					String reName = re.getName();
					// Not all rule input elements exist in newValues!
					if (newValues.containsKey(reName) 
							&& !re.getEType().isInstance(newValues.get(reName))) {
						// go to next match, as elements must conform to sub-rule type
						continue MATCH;
					}
				}
				currentMatches.put(tr, match);
				if (matchOneFor(newValues, index + 1, superMatches, iterables, currentMatches)) {
					return true;
				}
			}
			return false;
		} else if (!iterables.isEmpty()) {
			return matchOneFor(values, iterables, new ArrayList<String>(iterables.keySet()), 0);
		} else {
			final boolean result;
			result = matchOneFor(values, createValuesArray(rule, values), 0);
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
			final Map<String, EObject> values,
			final Map<String, Iterable<EObject>> iterables,
			final List<String> keys,
			int keyIndex) {
		final int size = iterables.size();
		if (keyIndex < size) {
			final String key = keys.get(keyIndex);
			assert !values.containsKey(key);
			for (EObject o : iterables.get(key)) {
				if (rule.isDistinctElements() && values.containsValue(o)) {
					continue; // all elements in this rule are distinct
				}
				values.put(key, o);
				if (matchOneFor(values, iterables, keys, keyIndex + 1)) {
					values.remove(key);
					return true;
				}
				values.remove(key);
			}
			return false;
		} else {
			return matchOneFor(values, createValuesArray(rule, values), 0);
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
	private boolean matchOneFor(final EObject[] values, int index, 
			final List<Iterable<EObject>> iterables) {
		assert values.length == iterables.size();
		while (index < values.length && iterables.get(index) == null) { // bound rule elements
			index++;
		}

		if (index < values.length) {
			for (EObject o : iterables.get(index)) {
				if (!checkDistinct(values, index, o)) {
					continue;
				}
				values[index] = o;
				if (matchOneFor(values, index + 1, iterables)) {
					values[index] = null;
					return true;
				}
				values[index] = null;
			}
			return false;
		} else {
			return matchOneFor(values, 0);
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
	private boolean matchOneFor(final EObject[] values, final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = rule.getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values));
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>) value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					for (EObject v : (Collection<EObject>) value) {
						if (!ire.getEType().isInstance(v) || !checkDistinct(values, values.length-1, v)) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						if (matchOneFor(values, index + 1)) {
							values[index] = null;
							return true;
						}
						values[index] = null;
					}
					return false;
				} else {
					if (!ire.getEType().isInstance(value) || !checkDistinct(values, values.length-1, value)) {
						return false; // all elements in this rule are distinct
					}
					values[index] = (EObject) value;
					final boolean result = matchOneFor(values, index + 1);
					values[index] = null;
					return result;
				}
			}
			return matchOneFor(values, index + 1);
		}

		// Match values
		return matchFor(values);
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
	private boolean matchOneFor(final Map<String, EObject> valuesMap, final EObject[] values, 
			final int index) {
		// Assign bound input element values
		final EList<InputRuleElement> inputs = rule.getInputElements();
		if (index < inputs.size()) {
			final InputRuleElement ire = inputs.get(index);
			final CodeBlock binding = ire.getBinding();
			if (binding != null) {
				final Object value = binding.execute(frame.getSubFrame(binding, values));
				if (value == null) {
					return false; // no value, no matches
				}

				if (values[index] != null) { // assigned from parent match
					if (value instanceof Collection<?>) {
						if (!((Collection<?>) value).contains(values[index])) {
							return false;
						}
					} else {
						if (!values[index].equals(value)) {
							return false;
						}
					}
				} else if (value instanceof Collection<?>) {
					final String key = ire.getName();
					for (EObject v : (Collection<EObject>) value) {
						if (!ire.getEType().isInstance(v) || 
								(rule.isDistinctElements() && valuesMap.containsValue(v))) {
							continue; // all elements in this rule are distinct
						}
						values[index] = v;
						valuesMap.put(key, v);
						if (matchOneFor(valuesMap, values, index + 1)) {
							values[index] = null;
							return true;
						}
						valuesMap.remove(key);
						values[index] = null;
					}
					return false;
				} else {
					if (!ire.getEType().isInstance(value) || 
							(rule.isDistinctElements() && valuesMap.containsValue(value))) {
						return false; // all elements in this rule are distinct
					}
					final String key = ire.getName();
					values[index] = (EObject) value;
					valuesMap.put(key, (EObject) value);
					final boolean result = matchFor(valuesMap, values, index + 1);
					valuesMap.remove(key);
					values[index] = null;
					return result;
				}
			}
			return matchOneFor(valuesMap, values, index + 1);
		}

		// Match values
		return matchFor(valuesMap, values);
	}

	/**
	 * Matches rule for <code>valuesMap</code>.
	 * @param valuesMap
	 * @return <code>true</code> iff the rule matches
	 */
	public boolean matchOne(final Map<String, EObject> valuesMap) {
		// Check value types
		final ExecEnv env = frame.getEnv();
		final EObject[] values = createValuesArray(rule, valuesMap);
		final EList<InputRuleElement> inputs = rule.getInputElements();

		for (int index = 0; index < inputs.size(); index++) {
			InputRuleElement re = inputs.get(index);
			EObject value = valuesMap.get(re.getName());
			if (value == null) {
				throw new VMException(frame, String.format(
						"Cannot match rule input element %s against null value for %s", 
						re, rule));
			}
			EList<Model> inmodels = re.getEModels();
			if (!re.getEType().isInstance(value) || 
					(!inmodels.isEmpty() && !inmodels.contains(env.getModelOf(value)))) {
				return false;
			}
			if (!checkDistinct(values, index, value)) {
				continue;
			}

			// Check bound values
			final CodeBlock binding = re.getBinding();
			if (binding != null) {
				final Object bvalue = binding.execute(frame.getSubFrame(binding, values));
				if (bvalue == null) {
					return false; // no value, no matches
				}
				if (bvalue instanceof Collection<?>) {
					if (!((Collection<?>) bvalue).contains(value)) {
						return false;
					}
				} else {
					if (!value.equals(bvalue)) {
						return false;
					}
				}
			}
		}

		for (Rule superRule : rule.getESuperRules()) {
			Matcher matcher = new Matcher(frame, superRule);
			if (!matcher.matchOne(valuesMap)) {
				return false;
			}
		}

		final CodeBlock cb = rule.getMatcher();
		return cb == null ? true : (Boolean) cb.execute(frame.getSubFrame(cb, values));
	}

	/**
	 * Creates a new {@link Iterator} of possible match values for <code>re</code>.
	 * @param env the execution environment
	 * @param re the rule element to match
	 * @return a new {@link Iterator}
	 */
	private static Iterable<EObject> createIterableFor(final ExecEnv env, 
			final InputRuleElement re) {
		if (re.getEModels().isEmpty()) {
			return EMFTVMUtil.findAllInstances(env, (EClass) re.getEType());
		} else {
			LazyList<EObject> allInstances = new LazyList<EObject>();
			for (Model m : re.getEModels()) {
				allInstances = allInstances.union(m.allInstancesOf((EClass) re.getEType()));
			}
			return allInstances;
		}
	}

	/**
	 * Creates default trace elements for this rule.
	 * @param isDefault whether to create default traces
	 */
	public void createTraces() {
		// Matches become traces
		final TracedRule tr = getMatches().getLinksByRule(rule.getName(), false);
		if (tr == null) {
			throw new VMException(frame, String.format(
					"Cannot create traces for %s; no matches exist",
					rule));
		}
		// Remove overridden matches
		for (Iterator<TraceLink> links = tr.getLinks().iterator(); links.hasNext();) {
			TraceLink trace = links.next();
			if (trace.isOverridden()) {
				links.remove(); // This match is overridden by a sub-rule
			} else {
				completeTraceFor(trace, rule);
			}
		}
		// Move traced rule from match model to trace model
		final TraceLinkSet traces = getTraces();
		traces.getRules().add(tr);
		// Mark default source elements
		if (rule.isDefault()) {
			for (TraceLink trace : tr.getLinks()) {
				EList<SourceElement> ses = trace.getSourceElements();
				if (ses.size() == 1) {
					ses.get(0).setDefaultFor(traces);
				} else {
					assert ses.size() > 1;
					SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
					sel.getSourceElements().addAll(ses);
					sel.setDefaultFor(traces);
				}
			}
		}
	}

	/**
	 * Creates first trace element for this rule.
	 */
	public TraceLink createFirstTrace() {
		// Matches become traces
		final TracedRule tr = getMatches().getLinksByRule(rule.getName(), false);
		if (tr == null) {
			throw new VMException(frame, String.format(
					"Cannot create a trace for rule %s; no matches exist",
					rule));
		}
		for (Iterator<TraceLink> links = tr.getLinks().iterator(); links.hasNext();) {
			TraceLink trace = links.next();
			if (trace.isOverridden()) {
				links.remove(); // This match is overridden by a sub-rule
				continue;
			}
			completeTraceFor(trace, rule);
			final String ruleName = rule.getName();
			final TraceLinkSet traces = getTraces();
			final TracedRule ntr = traces.getLinksByRule(ruleName, true);
			ntr.getLinks().add(trace);
			if (rule.isDefault()) {
				final EList<SourceElement> ses = trace.getSourceElements();
				if (ses.size() == 1) {
					ses.get(0).setDefaultFor(traces);
				} else {
					assert ses.size() > 1;
					final SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
					sel.getSourceElements().addAll(ses);
					sel.setDefaultFor(traces);
				}
			}
			return trace;
		}
		return null;
	}

	/**
	 * Creates one trace element for this rule, for <code>values</code>.
	 * @param values
	 * @return the created trace link
	 */
	public TraceLink createTrace(final Map<String, EObject> values) {
		final TraceLinkSet traces = getTraces();
		final String ruleName = rule.getName();
		final TracedRule tr = traces.getLinksByRule(ruleName, true);
		// Create trace links for input values
		final TraceLink trace = factory.createTraceLink();
		tr.getLinks().add(trace);
		final EList<SourceElement> ses = trace.getSourceElements();
		for (InputRuleElement ire : rule.getInputElements()) {
			String ireName = ire.getName();
			EObject source = values.get(ireName);
			assert source != null;
			SourceElement se = factory.createSourceElement();
			se.setName(ireName);
			se.setObject(source);
			ses.add(se);
		}
		// Complete trace for all output values
		completeTraceFor(trace, rule);
		// Set as default if applicable
		if (rule.isDefault()) {
			if (ses.size() == 1) {
				ses.get(0).setDefaultFor(traces);
			} else {
				final SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
				sel.getSourceElements().addAll(ses);
				sel.setDefaultFor(traces);
			}
		}
		return trace;
	}

	/**
	 * Completes <code>trace</code> for <code>rule</code>
	 * by creating the output elements.
	 * @param trace
	 * @param rule
	 */
	private void completeTraceFor(final TraceLink trace, final Rule rule) {
		final ExecEnv env = frame.getEnv();
		final TraceLinkSet traces = getTraces();
		final boolean isDefault = rule.isDefault();
		for (OutputRuleElement ore : rule.getOutputElements()) {
			String oreName = ore.getName();
			// If there is *any* target element with the same name, it overrides us
			if (trace.getTargetElement(oreName) != null) {
				continue;
			}
			TargetElement te = TraceFactory.eINSTANCE.createTargetElement();
			te.setName(oreName);
			te.setTargetOf(trace);
			InputRuleElement source = ore.getMapsTo();
			if (source != null) {
				SourceElement mapsTo = trace.getSourceElement(source.getName(), false);
				assert mapsTo != null;
				te.setMapsTo(mapsTo);
				if (isDefault) {
					mapsTo.setDefaultFor(traces);
				}
			}
			EClass type = (EClass) env.findType(ore.getTypeModel(), ore.getType());
			EList<Model> models = ore.getEModels();
			assert models.size() == 1;
			te.setObject(models.get(0).newElement(type));
			assert te.getObject() != null;
			assert te.getObject().eResource() != null;
			assert te.getObject().eResource() == models.get(0).getResource();
		}
		for (Rule superRule : rule.getESuperRules()) {
			completeTraceFor(trace, superRule);
		}
	}

	/**
	 * Applies this rule for the created traces.
	 */
	public void apply() {
		final TraceLinkSet traces = getTraces();
		final TracedRule tr = traces.getLinksByRule(rule.getName(), false);
		if (tr == null) {
			throw new VMException(frame, String.format(
					"Cannot apply rule %s; no traces exist",
					rule));
		}
		final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
		for (TraceLink trace : tr.getLinks()) {
			assert !trace.isOverridden();
			applyFor(trace, rule, ruleApplyArgs);
		}
	}

	/**
	 * Applies <code>rule</code> for the given <code>trace</code>.
	 * @param trace
	 * @param rule
	 * @param ruleApplyArgs the argument arrays for the rule applier code blocks
	 * @return the application result
	 */
	private Object applyFor(final TraceLink trace, final Rule rule, 
			final Map<Rule, Object[]> ruleApplyArgs) {
		for (Rule superRule : rule.getESuperRules()) {
			applyFor(trace, superRule, ruleApplyArgs);
		}
		final CodeBlock cb = rule.getApplier();
		if (cb == null) {
			return null;
		} else {
			final Object[] args;
			if (ruleApplyArgs.containsKey(rule)) {
				args = ruleApplyArgs.get(rule);
			} else {
				args = new Object[1 + 
				                  rule.getInputElements().size() + 
				                  rule.getOutputElements().size()];
			}
			createArgs(rule, trace, args);
			return cb.execute(frame.getSubFrame(cb, args));
		}
	}

	/**
	 * Runs post-applier for this rule for the created traces.
	 */
	public void postApply() {
		final TraceLinkSet traces = getTraces();
		final TracedRule tr = traces.getLinksByRule(rule.getName(), false);
		if (tr == null) {
			throw new VMException(frame, String.format(
					"Cannot post-apply rule %s; no traces exist",
					rule));
		}
		final Map<Rule, Object[]> ruleApplyArgs = new HashMap<Rule, Object[]>();
		for (TraceLink trace : tr.getLinks()) {
			postApplyFor(trace, rule, ruleApplyArgs);
		}
	}

	/**
	 * Runs post-applier for <code>rule</code> for the given <code>trace</code>.
	 * @param trace
	 * @param rule
	 * @param ruleApplyArgs the argument arrays for the rule applier code blocks
	 * @return the application result
	 */
	private Object postApplyFor(final TraceLink trace, final Rule rule, 
			final Map<Rule, Object[]> ruleApplyArgs) {
		for (Rule superRule : rule.getESuperRules()) {
			postApplyFor(trace, superRule, ruleApplyArgs);
		}
		final CodeBlock cb = rule.getPostApply();
		if (cb == null) {
			return null;
		} else {
			final Object[] args;
			if (ruleApplyArgs.containsKey(rule)) {
				args = ruleApplyArgs.get(rule);
			} else {
				args = new Object[1 + 
				                  rule.getInputElements().size() + 
				                  rule.getOutputElements().size()];
			}
			createArgs(rule, trace, args);
			return cb.execute(frame.getSubFrame(cb, args));
		}
	}

	/**
	 * Creates applier invocation arguments for <code>rule</code> from <code>trace</code>.
	 * @param rule
	 * @param trace
	 * @return applier invocation arguments for <code>rule</code>
	 */
	private static void createArgs(final Rule rule, final TraceLink trace, final Object[] args) {
		final EList<InputRuleElement> input = rule.getInputElements();
		final EList<OutputRuleElement> output = rule.getOutputElements();
		assert args.length == 1 + input.size() + output.size();
		args[0] = trace;
		int i = 1;
		for (InputRuleElement ire : input) {
			args[i++] = trace.getSourceElement(ire.getName(), false).getObject();
			assert args[i-1] != null;
		}
		for (OutputRuleElement ore : output) {
			args[i++] = trace.getTargetElement(ore.getName()).getObject();
			assert args[i-1] != null;
		}
		assert i == args.length;
	}

	/**
	 * @return the frame
	 */
	public StackFrame getFrame() {
		return frame;
	}

	/**
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @return the matches
	 */
	public TraceLinkSet getMatches() {
		if (matches == null) {
			final Field matchesField = frame.getEnv().findStaticField(EmftvmPackage.eINSTANCE.getExecEnv(), "matches");
			matches = (TraceLinkSet) matchesField.getStaticValue(frame);
			if (matches == null) {
				throw new VMException(frame, "matches field not initialised");
			}
		}
		return matches;
	}

	/**
	 * @return the traces
	 */
	public TraceLinkSet getTraces() {
		if (traces == null) {
			final Field tracesField = frame.getEnv().findStaticField(EmftvmPackage.eINSTANCE.getExecEnv(), "traces");
			traces = (TraceLinkSet) tracesField.getStaticValue(frame);
			if (traces == null) {
				throw new VMException(frame, "traces field not initialised");
			}
		}
		return traces;
	}

}
