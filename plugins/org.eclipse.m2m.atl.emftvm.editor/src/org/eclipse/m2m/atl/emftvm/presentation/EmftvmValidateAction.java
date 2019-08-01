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
package org.eclipse.m2m.atl.emftvm.presentation;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

/**
 * Applies EMF Validation service batch constraints in addition to regular EMF constraints.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EmftvmValidateAction extends ValidateAction {

	/**
	 * EMF Validation service batch validator object.
	 */
	protected final IValidator<EObject> validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Diagnostic validate(IProgressMonitor progressMonitor) {
		final Diagnostic superdiag = super.validate(progressMonitor);
		final BasicDiagnostic diagnostics;
		if (superdiag instanceof BasicDiagnostic) {
			diagnostics = (BasicDiagnostic)superdiag;
		} else {
			diagnostics = new BasicDiagnostic();
			diagnostics.add(superdiag);
		}

		for (EObject eObject : selectedObjects) {
			final IStatus st = validator.validate(eObject);
			if (!st.isOK()) {
				if (st.getChildren().length > 0) {
					for (IStatus cst : st.getChildren()) {
						if (cst instanceof ConstraintStatus) {
							diagnostics.add(new BasicDiagnostic(cst.getSeverity(), cst.getPlugin(), cst.getCode(), cst.getMessage(), new Object[]{ ((ConstraintStatus)cst).getTarget() }));
						}
					}
				} else {
					if (st instanceof ConstraintStatus) {
						diagnostics.add(new BasicDiagnostic(st.getSeverity(), st.getPlugin(), st.getCode(), st.getMessage(), new Object[]{ ((ConstraintStatus)st).getTarget() }));
					}
				}
			}
		}

		return diagnostics;
	}

}
