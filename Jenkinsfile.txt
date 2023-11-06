pipeline {
    agent any

    stages {
        stage('Display Message') {
            steps {
                echo 'Hello, Jenkins!'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}