pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'javac Hello.java'
            }
        }

        stage('Test') {
            steps {
                bat 'java Hello'
            }
        }

        stage('Package') {
            steps {
                bat 'jar -cf Hello.jar Hello.class'
            }
        }

    }

    post {
        success {
            echo 'CI/CD Pipeline Executed Successfully!'
        }

        failure {
            echo 'Build Failed!'
        }
    }
}