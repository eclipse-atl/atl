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
package org.eclipse.m2m.atl.emftvm.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Rule;

/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.atl.emftvm.Rule} object.
 * <!-- begin-user-doc -->
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class RuleItemProvider
	extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addModePropertyDescriptor(object);
			addInputElementsPropertyDescriptor(object);
			addOutputElementsPropertyDescriptor(object);
			addESuperRulesPropertyDescriptor(object);
			addESubRulesPropertyDescriptor(object);
			addSuperRulesPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addDefaultPropertyDescriptor(object);
			addDistinctElementsPropertyDescriptor(object);
			addUniquePropertyDescriptor(object);
			addLeafPropertyDescriptor(object);
			addWithLeavesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_mode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_mode_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Input Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_inputElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_inputElements_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__INPUT_ELEMENTS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Output Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_outputElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_outputElements_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__OUTPUT_ELEMENTS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the ESuper Rules feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addESuperRulesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_eSuperRules_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_eSuperRules_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__ESUPER_RULES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the ESub Rules feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addESubRulesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_eSubRules_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_eSubRules_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__ESUB_RULES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Rules feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperRulesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_superRules_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_superRules_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__SUPER_RULES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_abstract_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_default_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_default_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__DEFAULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Distinct Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDistinctElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_distinctElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_distinctElements_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__DISTINCT_ELEMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_unique_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_unique_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__UNIQUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Leaf feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeafPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_leaf_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_leaf_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__LEAF,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the With Leaves feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWithLeavesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rule_withLeaves_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rule_withLeaves_feature", "_UI_Rule_type"),
				 EmftvmPackage.Literals.RULE__WITH_LEAVES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__INPUT_ELEMENTS);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__OUTPUT_ELEMENTS);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__MATCHER);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__APPLIER);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__POST_APPLY);
			childrenFeatures.add(EmftvmPackage.Literals.RULE__FIELDS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Rule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Rule"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Rule)object).toString().replaceAll("rule ", "");
		return label == null || label.length() == 0 ?
			getString("_UI_Rule_type") :
			getString("_UI_Rule_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Rule.class)) {
			case EmftvmPackage.RULE__MODE:
			case EmftvmPackage.RULE__SUPER_RULES:
			case EmftvmPackage.RULE__ABSTRACT:
			case EmftvmPackage.RULE__DEFAULT:
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
			case EmftvmPackage.RULE__UNIQUE:
			case EmftvmPackage.RULE__LEAF:
			case EmftvmPackage.RULE__WITH_LEAVES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
			case EmftvmPackage.RULE__MATCHER:
			case EmftvmPackage.RULE__APPLIER:
			case EmftvmPackage.RULE__POST_APPLY:
			case EmftvmPackage.RULE__FIELDS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__INPUT_ELEMENTS,
				 EmftvmFactory.eINSTANCE.createInputRuleElement()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__OUTPUT_ELEMENTS,
				 EmftvmFactory.eINSTANCE.createOutputRuleElement()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__MATCHER,
				 EmftvmFactory.eINSTANCE.createCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__APPLIER,
				 EmftvmFactory.eINSTANCE.createCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__POST_APPLY,
				 EmftvmFactory.eINSTANCE.createCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.RULE__FIELDS,
				 EmftvmFactory.eINSTANCE.createField()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EmftvmPackage.Literals.RULE__MATCHER ||
			childFeature == EmftvmPackage.Literals.RULE__APPLIER ||
			childFeature == EmftvmPackage.Literals.RULE__POST_APPLY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
