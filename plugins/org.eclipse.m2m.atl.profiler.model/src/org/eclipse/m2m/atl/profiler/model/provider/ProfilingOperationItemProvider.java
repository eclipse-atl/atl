/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.m2m.atl.profiler.model.provider;



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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.atl.profiler.model.ModelFactory;
import org.eclipse.m2m.atl.profiler.model.ModelPackage;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfilingOperationItemProvider
	extends ProfilingInstructionItemProvider
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
	public ProfilingOperationItemProvider(AdapterFactory adapterFactory) {
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

			addEndTimePropertyDescriptor(object);
			addTotalExecutedInstructionsPropertyDescriptor(object);
			addEndMemoryUsagePropertyDescriptor(object);
			addMaxMemoryUsagePropertyDescriptor(object);
			addMatchingOperationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the End Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProfilingOperation_endTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProfilingOperation_endTime_feature", "_UI_ProfilingOperation_type"),
				 ModelPackage.Literals.PROFILING_OPERATION__END_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Executed Instructions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalExecutedInstructionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProfilingOperation_totalExecutedInstructions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProfilingOperation_totalExecutedInstructions_feature", "_UI_ProfilingOperation_type"),
				 ModelPackage.Literals.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End Memory Usage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndMemoryUsagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProfilingOperation_endMemoryUsage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProfilingOperation_endMemoryUsage_feature", "_UI_ProfilingOperation_type"),
				 ModelPackage.Literals.PROFILING_OPERATION__END_MEMORY_USAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Memory Usage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxMemoryUsagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProfilingOperation_maxMemoryUsage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProfilingOperation_maxMemoryUsage_feature", "_UI_ProfilingOperation_type"),
				 ModelPackage.Literals.PROFILING_OPERATION__MAX_MEMORY_USAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Matching Operation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchingOperationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProfilingOperation_matchingOperation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProfilingOperation_matchingOperation_feature", "_UI_ProfilingOperation_type"),
				 ModelPackage.Literals.PROFILING_OPERATION__MATCHING_OPERATION,
				 true,
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
			childrenFeatures.add(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS);
			childrenFeatures.add(ModelPackage.Literals.PROFILING_OPERATION__CONTEXT);
			childrenFeatures.add(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_ERRORS);
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
	 * This returns ProfilingOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProfilingOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ProfilingOperation profilingOperation = (ProfilingOperation)object;
		return getString("_UI_ProfilingOperation_type") + " " + profilingOperation.getLaunchedTime();
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

		switch (notification.getFeatureID(ProfilingOperation.class)) {
			case ModelPackage.PROFILING_OPERATION__END_TIME:
			case ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS:
			case ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE:
			case ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE:
			case ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
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
				(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS,
				 ModelFactory.eINSTANCE.createProfilingInstruction()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS,
				 ModelFactory.eINSTANCE.createProfilingOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS,
				 ModelFactory.eINSTANCE.createProfilingModel()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PROFILING_OPERATION__CONTEXT,
				 ModelFactory.eINSTANCE.createContext()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PROFILING_OPERATION__EXECUTION_ERRORS,
				 ModelFactory.eINSTANCE.createExecutionError()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ATLProfilerEditPlugin.INSTANCE;
	}

}
