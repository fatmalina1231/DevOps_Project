pipeline {
    agent any

    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: 'mootaz', credentialsId: 'token', url: 'https://github.com/fatmalina1231/DevOps_Project.git'
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
