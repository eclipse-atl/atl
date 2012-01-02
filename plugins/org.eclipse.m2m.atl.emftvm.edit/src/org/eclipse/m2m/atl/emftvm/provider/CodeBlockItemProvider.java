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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.atl.emftvm.CodeBlock} object.
 * <!-- begin-user-doc -->
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class CodeBlockItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockItemProvider(AdapterFactory adapterFactory) {
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

			addMaxLocalsPropertyDescriptor(object);
			addMaxStackPropertyDescriptor(object);
			addMatcherForPropertyDescriptor(object);
			addApplierForPropertyDescriptor(object);
			addPostApplyForPropertyDescriptor(object);
			addBodyForPropertyDescriptor(object);
			addInitialiserForPropertyDescriptor(object);
			addNestedForPropertyDescriptor(object);
			addParentFramePropertyDescriptor(object);
			addBindingForPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Max Locals feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxLocalsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_maxLocals_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_maxLocals_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__MAX_LOCALS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Stack feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxStackPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_maxStack_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_maxStack_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__MAX_STACK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Matcher For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatcherForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_matcherFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_matcherFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__MATCHER_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Applier For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addApplierForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_applierFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_applierFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__APPLIER_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Post Apply For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostApplyForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_postApplyFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_postApplyFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__POST_APPLY_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Body For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBodyForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_bodyFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_bodyFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__BODY_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initialiser For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialiserForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_initialiserFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_initialiserFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__INITIALISER_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Nested For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNestedForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_nestedFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_nestedFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__NESTED_FOR,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent Frame feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentFramePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_parentFrame_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_parentFrame_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__PARENT_FRAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Binding For feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBindingForPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CodeBlock_bindingFor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CodeBlock_bindingFor_feature", "_UI_CodeBlock_type"),
				 EmftvmPackage.Literals.CODE_BLOCK__BINDING_FOR,
				 false,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(EmftvmPackage.Literals.CODE_BLOCK__CODE);
			childrenFeatures.add(EmftvmPackage.Literals.CODE_BLOCK__LINE_NUMBERS);
			childrenFeatures.add(EmftvmPackage.Literals.CODE_BLOCK__LOCAL_VARIABLES);
			childrenFeatures.add(EmftvmPackage.Literals.CODE_BLOCK__NESTED);
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
	 * This returns CodeBlock.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CodeBlock"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		CodeBlock codeBlock = (CodeBlock)object;
		return getString("_UI_CodeBlock_type") 
			+ " (maxLocals: " + codeBlock.getMaxLocals()
			+ " maxStack: " + codeBlock.getMaxStack() + ")";
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

		switch (notification.getFeatureID(CodeBlock.class)) {
			case EmftvmPackage.CODE_BLOCK__MAX_LOCALS:
			case EmftvmPackage.CODE_BLOCK__MAX_STACK:
			case EmftvmPackage.CODE_BLOCK__PARENT_FRAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EmftvmPackage.CODE_BLOCK__CODE:
			case EmftvmPackage.CODE_BLOCK__LINE_NUMBERS:
			case EmftvmPackage.CODE_BLOCK__LOCAL_VARIABLES:
			case EmftvmPackage.CODE_BLOCK__NESTED:
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
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createPush()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createPusht()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createPushf()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createPop()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createLoad()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createStore()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createSet()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGet()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetTrans()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createSetStatic()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetStatic()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createFindtype()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createFindtypeS()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createNew()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createNewS()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createDelete()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createDup()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createDupX1()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createSwap()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createSwapX1()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createIfn()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGoto()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createIterate()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createEnditerate()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvoke()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvokeSuper()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvokeStatic()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createAllinst()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createAllinstIn()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createIsnull()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetenvtype()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createImplies()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createIfte()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetcb()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvokeAllCbs()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvokeCb()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInvokeCbS()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createMatch()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createMatchS()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createAdd()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createRemove()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createInsert()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetSuper()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__CODE,
				 EmftvmFactory.eINSTANCE.createGetenv()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__LINE_NUMBERS,
				 EmftvmFactory.eINSTANCE.createLineNumber()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__LOCAL_VARIABLES,
				 EmftvmFactory.eINSTANCE.createLocalVariable()));

		newChildDescriptors.add
			(createChildParameter
				(EmftvmPackage.Literals.CODE_BLOCK__NESTED,
				 EmftvmFactory.eINSTANCE.createCodeBlock()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EmftvmEditPlugin.INSTANCE;
	}

}
