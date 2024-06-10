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
    jdk 'temurin-jdk17-latest'
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

    booleanParam(
      name: 'BUILD_SIGN',
      defaultValue: false,
      description: '''
        Choose whether or not the bundles will be signed.
        This is relevant only for nightly and milestone builds.
      '''
    )
 
    booleanParam(
      name: 'BUILD_PROMOTE',
      defaultValue: false,
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
          env.BUILD_SIGN = params.BUILD_SIGN
          env.BUILD_PROMOTE = params.BUILD_PROMOTE && env.BUILD_SIGN
          def description = """
BUILD_TYPE=${env.BUILD_TYPE}
BUILD_PROMOTE=${env.BUILD_PROMOTE}
BUILD_TIMESTAMP=${env.BUILD_TIMESTAMP}
BUILD_SIGN=${env.BUILD_SIGN}
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
              if [[ $BUILD_PROMOTE == false ]]; then
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
                -DBUILD_SIGN=${BUILD_SIGN} \
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
