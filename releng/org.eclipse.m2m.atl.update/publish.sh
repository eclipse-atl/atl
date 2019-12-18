#!/bin/bash -xv
#*******************************************************************************
# Copyright (c) 2019 Willink Transformations and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#     Dennis Wagelaar
#*******************************************************************************
# Local ATL publish script for use by the promoter job. It prepares and invokes remote scripts.
#

if [[ ${PUBLISH__PROMOTE} == "true" ]]
then

	rm -f downloads.sh publish.zip updates.sh
	curl -s -k ${PUBLISH__DOWNLOADS_SH} > downloads.sh
	curl -s -k ${PUBLISH__UPDATES_SH} > updates.sh
	curl -s -k ${PUBLISH__URL} > publish.zip
	ssh genie.atl@projects-storage.eclipse.org rm -f downloads.sh publish.zip updates.sh
	scp downloads.sh genie.atl@projects-storage.eclipse.org:downloads.sh
	scp publish.zip genie.atl@projects-storage.eclipse.org:publish.zip
	scp updates.sh genie.atl@projects-storage.eclipse.org:updates.sh
	ssh genie.atl@projects-storage.eclipse.org chmod +x downloads.sh updates.sh
	ssh genie.atl@projects-storage.eclipse.org bash -ex downloads.sh -v "'${PUBLISH__VERSION}'" -t "'${PUBLISH__BUILD_T}'" -q "'${PUBLISH__QUALIFIER}'" -a "'${PUBLISH__ALIAS}'"
	ssh genie.atl@projects-storage.eclipse.org bash -ex updates.sh -v "'${PUBLISH__VERSION}'" -t "'${PUBLISH__BUILD_T}'" -q "'${PUBLISH__QUALIFIER}'"

fi
