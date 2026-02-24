pipeline {
    agent any

    tools {
        maven 'Maven-3'
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

        stage('SonarQube Analysis') {
            steps {
                dir('sbi-bank') {
                    withSonarQubeEnv('SonarQube-Server') {
                        bat 'mvn sonar:sonar'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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
            echo '✅ Build, Code Quality & Packaging successful'
        }
        failure {
            echo '❌ Pipeline failed (Build or Quality Gate)'
        }
    }
}
