pipeline {
    agent any

    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: 'mootaz', credentialsId: 'token', url: 'https://github.com/fatmalina1231/DevOps_Project.git'
                sh 'chmod +x mvnw'
                sh 'sudo docker build -t my-spring-app .'
                sh 'sudo docker run --network springboot-mysql-net --name springboot-mysql-container -p 9090:9090 my-spring-app'
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
