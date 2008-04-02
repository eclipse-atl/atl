/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionProcessor;
import org.eclipse.swt.graphics.Color;

public class AtlContentAssistPreference {
	
	/**
	 * Handles the preference fPreferenceeStore changes for the content assistant.
	 * 
	 * @param assistant the given content assistant
	 * @param store the given preference store
	 * @param event the given property change event
	 */
	public static void changeConfiguration(ContentAssistant assistant, IPreferenceStore store, PropertyChangeEvent event) {
		String property = event.getProperty();
		AtlColorManager colorManager = AtlUIPlugin.getDefault().getTextTools().getColorManager();
		
		if(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_ENABLE.equals(property)) {
			assistant.enableAutoActivation(store.getBoolean(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_ENABLE));
		} else if(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY.equals(property)) {
			assistant.setAutoActivationDelay(store.getInt(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY));
		} else if(AtlPreferenceConstants.CODEASSIST_AUTOINSERT.equals(property)) {
			assistant.enableAutoInsert(store.getBoolean(AtlPreferenceConstants.CODEASSIST_AUTOINSERT));
		} else if(AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND.equals(property)) {
			assistant.setProposalSelectorBackground(getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND, colorManager));
		} else if(AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND.equals(property)) {
			assistant.setProposalSelectorForeground(getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND, colorManager));
		} else if(AtlPreferenceConstants.CODEASSIST_PARAMETERS_BACKGROUND.equals(property)) {
			Color c = getColor(store, AtlPreferenceConstants.CODEASSIST_PARAMETERS_BACKGROUND, colorManager);
			assistant.setContextInformationPopupBackground(c);
			assistant.setContextSelectorBackground(c);
		} else if(AtlPreferenceConstants.CODEASSIST_PARAMETERS_FOREGROUND.equals(property)) {
			Color c = getColor(store, AtlPreferenceConstants.CODEASSIST_PARAMETERS_FOREGROUND, colorManager);
			assistant.setContextInformationPopupForeground(c);
			assistant.setContextSelectorForeground(c);
		} else if(AtlPreferenceConstants.CODEASSIST_PREFIX_COMPLETION.equals(property)) {
			assistant.enablePrefixCompletion(store.getBoolean(AtlPreferenceConstants.CODEASSIST_PREFIX_COMPLETION));
		}
		
		changeProcessor(assistant, store, property);
	}
	
	private static void changeProcessor(ContentAssistant assistant, IPreferenceStore store, String key) {
		AtlCompletionProcessor cp= getProcessor(assistant);
		if(cp == null)
			return;
		
		if(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS.equals(key)) {
			String triggers= store.getString(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS);
			if(triggers != null)
				cp.setCompletionProposalAutoActivationCharacters(triggers.toCharArray());
		} else if(AtlPreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS.equals(key)) {
			boolean enabled= store.getBoolean(AtlPreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS);
			cp.restrictProposalsToVisibility(enabled);
		} else if(AtlPreferenceConstants.CODEASSIST_CASE_SENSITIVITY.equals(key)) {
			boolean enabled= store.getBoolean(AtlPreferenceConstants.CODEASSIST_CASE_SENSITIVITY);
			cp.restrictProposalsToMatchingCases(enabled);
		} else if(AtlPreferenceConstants.CODEASSIST_ORDER_PROPOSALS.equals(key)) {
			boolean enable= store.getBoolean(AtlPreferenceConstants.CODEASSIST_ORDER_PROPOSALS);
			cp.orderProposalsAlphabetically(enable);
		}
	}
	
	/**
	 * Configure the given content assistant from the given store.
	 */
	public static void configure(ContentAssistant assistant, IPreferenceStore store) {
		AtlColorManager manager = AtlUIPlugin.getDefault().getTextTools().getColorManager();		
		
		assistant.enableAutoActivation(store.getBoolean(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_ENABLE));		
		assistant.setAutoActivationDelay(store.getInt(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY));
		assistant.enableAutoInsert(store.getBoolean(AtlPreferenceConstants.CODEASSIST_AUTOINSERT));
		assistant.setProposalSelectorBackground(getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND, manager));
		assistant.setProposalSelectorForeground(getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND, manager));
		assistant.enablePrefixCompletion(store.getBoolean(AtlPreferenceConstants.CODEASSIST_PREFIX_COMPLETION));
		assistant.setProposalPopupOrientation(ContentAssistant.PROPOSAL_OVERLAY);
		
		Color background= getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND, manager);			
		assistant.setContextInformationPopupBackground(background);
		assistant.setContextSelectorBackground(background);
		assistant.setProposalSelectorBackground(background);
		
		Color foreground= getColor(store, AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND, manager);
		assistant.setContextInformationPopupForeground(foreground);
		assistant.setContextSelectorForeground(foreground);
		assistant.setProposalSelectorForeground(foreground);
		
		configureProcessor(assistant, store);
	}
	
	private static void configureProcessor(ContentAssistant assistant, IPreferenceStore store) {
		AtlCompletionProcessor cp = getProcessor(assistant);
		if(cp == null)
			return;
		
		String triggers = store.getString(AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS);
		if(triggers != null)
			cp.setCompletionProposalAutoActivationCharacters(triggers.toCharArray());
		
		cp.restrictProposalsToVisibility(store.getBoolean(AtlPreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS));
		cp.restrictProposalsToMatchingCases(store.getBoolean(AtlPreferenceConstants.CODEASSIST_CASE_SENSITIVITY));
		cp.orderProposalsAlphabetically(store.getBoolean(AtlPreferenceConstants.CODEASSIST_ORDER_PROPOSALS));
	}
	
	private static Color getColor(IPreferenceStore store, String key, AtlColorManager colorManager) {
		return colorManager.getColor(PreferenceConverter.getColor(store, key));
	}
	
	private static AtlCompletionProcessor getProcessor(ContentAssistant assistant) {
		IContentAssistProcessor p = assistant.getContentAssistProcessor(IDocument.DEFAULT_CONTENT_TYPE);
		if(p instanceof AtlCompletionProcessor)
			return  (AtlCompletionProcessor) p;
		return null;
	}
	
}
