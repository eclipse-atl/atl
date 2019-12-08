#!/bin/bash -xv
#*******************************************************************************
# Copyright (c) 2017, 2019 Willink Transformations and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#     Dennis Wagelaar
#*******************************************************************************
#
#	Promote ~/publish.zip to the downloads 'page'.
#	Promote ~/javadoc.zip to the downloads 'page'.
#
#    -v PUBLISH__VERSION        Unqualified version e.g. 3.9.0
#    -t PUBLISH__BUILD_T        Build type N/I/S/R, blank suppresses promotion
#    -q PUBLISH__QUALIFIER      Version qualifier e.g. v20171025-1600
#    -a PUBLISH__ALIAS          Non blank to use alias as part of final name
#
dropsFolder="/home/data/httpd/download.eclipse.org/mmt/atl/downloads/drops/"
group="modeling.mmt.atl"
zipPrefix="m2m-atl-Update-"

while getopts v:t:q:a: option
do
case "${option}"
in
v) PUBLISH__VERSION=${OPTARG};;
t) PUBLISH__BUILD_T=${OPTARG};;
q) PUBLISH__QUALIFIER=${OPTARG};;
a) PUBLISH__ALIAS=${OPTARG};;
esac
done

if [ -n "${PUBLISH__BUILD_T}" ]
then

  tQualifier="${PUBLISH__BUILD_T}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  versionFolder="${dropsFolder}${PUBLISH__VERSION}/${tQualifier}"
  if [ ! -d "${versionFolder}" ]
  then
    mkdir -p ${versionFolder}
  fi

  fileStem="${tQualifier}"
  if [ -n "${PUBLISH__ALIAS}" ]
  then
    fileStem=${PUBLISH__ALIAS}
  fi
  zipFile="${zipPrefix}${fileStem}.zip"

  pushd ${versionFolder}
    cp ~/publish.zip ${zipFile}
    md5sum -b ${zipFile} > ${zipFile}.md5
    sha512sum -b ${zipFile} > ${zipFile}.sha1
    # make sure permissions are for the intended group
    chgrp -R ${group} ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
    chmod -R g+w ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
  popd
  
fi
