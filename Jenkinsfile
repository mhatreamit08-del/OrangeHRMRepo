pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
    }

    parameters {
        string(name: 'SUITE_FILE', defaultValue: 'testng.xml', description: 'TestNG suite file to run')
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source from GitHub..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Compiling project with Maven..."
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Executing TestNG suite: ${params.SUITE_FILE}"
                bat "mvn test -Dsurefire.suiteXmlFiles=${params.SUITE_FILE}"
            }
        }

        stage('Publish Test Report') {
            steps {
                echo "Publishing TestNG HTML report..."
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'emailable-report.html',
                    reportName: 'TestNG Report'
                ])
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo "Archiving surefire reports and logs..."
                archiveArtifacts artifacts: 'target/surefire-reports/**, test-output/**', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }
        success {
            echo "Build #${env.BUILD_NUMBER} succeeded."
        }
        failure {
            echo "Build #${env.BUILD_NUMBER} failed. Check the TestNG report for details."
        }
    }
}