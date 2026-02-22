pipeline {
    agent any

    tools {
        maven 'Maven-3'   // only if configured in Jenkins → Tools
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                dir('sbi-bank') {
                    bat 'mvn clean test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('sbi-bank') {
                    bat 'mvn package -DskipTests'
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'sbi-bank/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build and packaging successful'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}
