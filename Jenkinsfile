def defaultPromote = false
if (env.BRANCH_NAME == 'master')
{
  defaultPromote = true
}

def targetPlatformToJavaVersionMap = [
  '2024-06' : '17',
  '2024-09' : '21',
  '2024-12' : '21',
]

def targetPlatforms = targetPlatformToJavaVersionMap.keySet() as List

pipeline {
  agent {
    label 'centos-latest'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '30'))
    disableConcurrentBuilds()
    skipDefaultCheckout false
  }

  tools {
    maven 'apache-maven-latest'
    jdk 'temurin-jdk' + targetPlatformToJavaVersionMap[params.TARGET_PLATFORM] + '-latest'
  }

  environment {
    PUBLISH_LOCATION = 'builds'
    BUILD_TIMESTAMP = sh(returnStdout: true, script: 'date +%Y%m%d%H%M').trim()
    CHECKOUT = 'false'
  }

  parameters {
    choice(
      name: 'BUILD_TYPE',
      choices: ['nightly', 'milestone', 'release'],
      description: '''
        Choose the type of build.
        Note that a release build will not promote the build, but rather will promote the most recent milestone build.
        '''
    )

    choice(
      name: 'TARGET_PLATFORM',
      choices: targetPlatforms,
      description: '''
        Choose the named target platform against which to compile and test.
        This is relevant only for nightly and milestone builds.
        '''
    )

    booleanParam(
      name: 'ECLIPSE_SIGN',
      defaultValue: defaultPromote,
      description: '''
        Choose whether or not the bundles will be signed.
        This is relevant only for nightly and milestone builds.
      '''
    )
 
    booleanParam(
      name: 'PROMOTE',
      defaultValue: defaultPromote,
      description: 'Whether to promote the build to the download server.'
    )

    booleanParam(
      name: 'ARCHIVE',
      defaultValue: false,
      description: 'Whether to archive the workspace.'
    )
  }

  stages {
    stage('Display Parameters') {
      steps {
        script {
          env.BUILD_TYPE = params.BUILD_TYPE
          env.TARGET_PLATFORM = params.TARGET_PLATFORM
          env.JAVA_VERSION = targetPlatformToJavaVersionMap[params.TARGET_PLATFORM]
          env.ECLIPSE_SIGN = params.ECLIPSE_SIGN
          env.PROMOTE = params.PROMOTE && env.ECLIPSE_SIGN
          def description = """
BUILD_TYPE=${env.BUILD_TYPE}
TARGET_PLATFORM=${env.TARGET_PLATFORM}
JAVA_VERSION=${env.JAVA_VERSION}
PROMOTE=${env.PROMOTE}
BUILD_TIMESTAMP=${env.BUILD_TIMESTAMP}
ECLIPSE_SIGN=${env.ECLIPSE_SIGN}
ARCHIVE=${params.ARCHIVE}
""".trim()
          echo description
          currentBuild.description = description.replace("\n", "<br/>")
        }
      }
    }

    stage('Git Checkout') {
      when {
        environment name: 'CHECKOUT', value: 'true'
      }
      steps {
        script {
          def gitVariables = checkout(
            poll: false,
            scm: [
              $class: 'GitSCM',
              branches: [[name: '*' + '/master']],
              doGenerateSubmoduleConfigurations: false,
              submoduleCfg: [],
              userRemoteConfigs: [[url: 'https://github.com/eclipse-atl/atl.git']]
            ]
          )

          echo "$gitVariables"
          env.GIT_COMMIT = gitVariables.GIT_COMMIT
        }
      }
    }

    stage('Build') {
      steps {
        sshagent(['projects-storage.eclipse.org-bot-ssh']) {
          dir('.') {
            sh '''
              if [[ $PROMOTE == false ]]; then
                promotion_argument='-Dpromote=false -Dorg.eclipse.justj.p2.manager.args='
              fi
              mvn  \
                -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml \
                --fail-at-end \
                --no-transfer-progress \
                $promotion_argument \
                -Dmaven.artifact.threads=16 \
                -Dbuild.id=${BUILD_TIMESTAMP} \
                -Dcommit.id=$GIT_COMMIT \
                -DECLIPSE_SIGN=${ECLIPSE_SIGN} \
                -Dtarget-platform=${TARGET_PLATFORM} \
                -DjavaVersion=${JAVA_VERSION} \
                -Dbuild.type=$BUILD_TYPE \
                -Dorg.eclipse.justj.p2.manager.build.url=$JOB_URL \
                -Dorg.eclipse.justj.p2.manager.relative=$PUBLISH_LOCATION \
                clean \
                deploy
              '''
          }
        }
      }
    }

    stage('Archive Results') {
      when {
        expression {
          params.ARCHIVE
        }
      }
      steps {
        archiveArtifacts '**'
      }
    }
  }

  post {
    failure {
      mail to: 'm2m-atl-dev@eclipse.org',
      subject: "[ATL CI] Build Failure ${currentBuild.fullDisplayName}",
      mimeType: 'text/html',
      body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
      archiveArtifacts allowEmptyArchive: true, artifacts: '**'
    }

    fixed {
      mail to: 'm2m-atl-dev@eclipse.org',
      subject: "[ATL CI] Back to normal ${currentBuild.fullDisplayName}",
      mimeType: 'text/html',
      body: "Project: ${env.JOB_NAME}<br/>Build Number: ${env.BUILD_NUMBER}<br/>Build URL: ${env.BUILD_URL}<br/>Console: ${env.BUILD_URL}/console"
    }

    always {
      junit '**/target/surefire-reports/TEST-*.xml'
    }

    cleanup {
      deleteDir()
    }
  }
}
