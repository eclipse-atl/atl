#!/bin/bash -xv
#*******************************************************************************
# Copyright (c) 2018, 2019 Willink Transformations and others.
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
#    Promote the PUBLISH__URL to an updates repository.
#
#    -u PUBLISH__URL            The zip to be published e.g. https://ci.eclipse.org/ocl/job/ocl-master/38/artifact/releng/org.eclipse.ocl.releng.build-site/target/org.eclipse.ocl-6.5.0.v20171021-1702.zip
#    -v PUBLISH__VERSION        Unqualified version e.g. 6.5.0
#    -t PUBLISH__BUILD_T        Build type N/I/S/R, blank suppresses promotion
#    -q PUBLISH__QUALIFIER      Version qualifier e.g. v20171020-1234
#
updatesFolder="updates/"
group="modeling.mmt.atl"
localZip="atl.zip"
projectRepoName="ATL"
manageComposite="ant -f ${WORKSPACE}/promotion/manage-composite.xml"
externalUpdatesFolder="https://download.eclipse.org/mmt/atl/updates/"

while getopts u:v:t:q: option
do
case "${option}"
in
u) PUBLISH__URL=${OPTARG};;
v) PUBLISH__VERSION=${OPTARG};;
t) PUBLISH__BUILD_T=${OPTARG};;
q) PUBLISH__QUALIFIER=${OPTARG};;
esac
done

if [ -n "${PUBLISH__BUILD_T}" ]
then

  tQualifier="${PUBLISH__BUILD_T}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  if [ "${PUBLISH__BUILD_T}" = "N" ]
  then
    buildFolder="${updatesFolder}nightly"
    buildRepoName="Nightly"
    latestRelativeReference="../${PUBLISH__VERSION}"
  elif [ "${PUBLISH__BUILD_T}" = "I" ]
  then
    buildFolder="${updatesFolder}interim"
    buildRepoName="Interim"
    latestRelativeReference="../${PUBLISH__VERSION}"
  elif [ "${PUBLISH__BUILD_T}" = "S" ]
  then
    buildFolder="${updatesFolder}milestones"
    buildRepoName="Milestones"
    latestRelativeReference="../${PUBLISH__VERSION}/${tQualifier}"
  elif [ "${PUBLISH__BUILD_T}" = "R" ]
  then
    buildFolder="${updatesFolder}releases"
    buildRepoName="Releases"
    latestRelativeReference="../${PUBLISH__VERSION}"
  else
    buildFolder="${updatesFolder}other"
    latestRelativeReference="../${PUBLISH__VERSION}"
    buildRepoName="Other"
  fi

  if [ ! -d "${buildFolder}" ]
  then
    mkdir -p ${buildFolder}
  fi

  pushd ${buildFolder}
    if [ ! -d "${PUBLISH__VERSION}" ]
    then
      mkdir ${PUBLISH__VERSION}
      versionCompositeName="${projectRepoName} ${buildRepoName} Repository"
      ${manageComposite} add -Dchild.repository=${PUBLISH__VERSION} -Dcomposite.name="${versionCompositeName}"
    fi

    if [ "${PUBLISH__BUILD_T}" = "N" ]
    then
      curl -s -k ${PUBLISH__URL} > ${localZip}
      unzip -ou ${localZip} -d new${PUBLISH__VERSION}
      chgrp -R ${group} new${PUBLISH__VERSION}
      chmod -R g+w new${PUBLISH__VERSION}
      mv ${PUBLISH__VERSION} old${PUBLISH__VERSION}
      mv new${PUBLISH__VERSION} ${PUBLISH__VERSION}
      rm -rf old${PUBLISH__VERSION} ${localZip}
    elif [ "${PUBLISH__BUILD_T}" = "I" ]
    then
      curl -s -k ${PUBLISH__URL} > ${localZip}
      unzip -ou ${localZip} -d new${PUBLISH__VERSION}
      chgrp -R ${group} new${PUBLISH__VERSION}
      chmod -R g+w new${PUBLISH__VERSION}
      mv ${PUBLISH__VERSION} old${PUBLISH__VERSION}
      mv new${PUBLISH__VERSION} ${PUBLISH__VERSION}
      rm -rf old${PUBLISH__VERSION} ${localZip}
    elif [ "${PUBLISH__BUILD_T}" = "S" ]
    then
      pushd ${buildFolder}/${PUBLISH__VERSION}

        versionFolder="${buildFolder}/${tQualifier}"
        if [ ! -d "${tQualifier}" ]
        then
          mkdir ${tQualifier}
        fi

        curl -s -k ${PUBLISH__URL} > ${localZip}
        unzip ${localZip} -d ${tQualifier}
        rm ${localZip}

        chgrp -R ${group} ${tQualifier}
        chmod -R g+w ${tQualifier}
        ${manageComposite} add -Dchild.repository=${tQualifier} -Dcomposite.name="${projectRepoName} ${PUBLISH__VERSION} ${buildRepoName} Repository"
      popd
    elif [ "${PUBLISH__BUILD_T}" = "R" ]
    then
      curl -s -k ${PUBLISH__URL} > ${localZip}
      unzip -ou ${localZip} -d new${PUBLISH__VERSION}
      chgrp -R ${group} new${PUBLISH__VERSION}
      chmod -R g+w new${PUBLISH__VERSION}
      mv ${PUBLISH__VERSION} old${PUBLISH__VERSION}
      mv new${PUBLISH__VERSION} ${PUBLISH__VERSION}
      rm -rf old${PUBLISH__VERSION} ${localZip}

    fi

    mkdir ${buildFolder}/newlatest
    pushd ${buildFolder}/newlatest
      ${manageComposite} add -Dchild.repository=${latestRelativeReference} -Dcomposite.name="${projectRepoName} Latest ${PUBLISH__VERSION} ${buildRepoName} Repository"
    popd
    if [ -d "latest" ]
    then
      mv latest oldlatest
    fi
    mv newlatest latest
    rm -rf oldlatest
   
  popd

fi

