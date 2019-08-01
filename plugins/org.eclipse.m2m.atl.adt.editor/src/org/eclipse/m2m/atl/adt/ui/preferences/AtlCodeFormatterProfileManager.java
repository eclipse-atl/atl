/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatterPreferences;

/**
 * The ATL formatter profiles manager.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCodeFormatterProfileManager extends ProfileManager {

	public final static String DEFAULT_PROFILE_STRING = AtlUIPlugin.getPluginId() + ".default_profile"; //$NON-NLS-1$

	private final static BuiltInProfile DEFAULT_PROFILE = new BuiltInProfile(DEFAULT_PROFILE_STRING,
			"ATL default profile [built-in]", AtlCodeFormatterPreferences.getDefaultOptions(), 1); //$NON-NLS-1$

	public AtlCodeFormatterProfileManager(List<Profile> profiles, IScopeContext context,
			PreferencesAccess preferencesAccess, KeySet[] keySets, String profileKey) {
		super(profiles, context, preferencesAccess, keySets, profileKey);
	}

	public static AtlCodeFormatterProfileManager getCurrentProfileManager(IScopeContext currentContext,
			PreferencesAccess access, ProfileStore store) {
		ArrayList<Profile> profiles = new ArrayList<ProfileManager.Profile>();
		profiles.add(DEFAULT_PROFILE);
		try {
			List<Profile> readProfiles = store.readProfiles(access.getInstanceScope());
			if (readProfiles != null)
				profiles.addAll(readProfiles);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return new AtlCodeFormatterProfileManager(profiles, currentContext, access, new KeySet[] {},
				AtlCodeFormatterPropertyPage.CURRENT_PROFILE_KEY);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager#getDefaultProfile()
	 */
	@Override
	public Profile getDefaultProfile() {
		return DEFAULT_PROFILE;
	}

}
