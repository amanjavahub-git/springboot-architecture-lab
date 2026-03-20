pipeline {
    agent any   // Run on any Jenkins agent

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'feature/aws-s3-bucket-ecr', url: 'https://github.com/amanjavahub-git/springboot-architecture-lab.git'
            }
        }
        stage('Build JAR') {
            steps {
                // Build JAR using Maven
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                // Build Docker image from Dockerfile
                sh 'docker build -t springboot-architecture-lab:latest .'
            }
        }
        stage('Deploy') {
            steps {
                // Run container on EC2
                sh 'docker run -d -p 8080:8080 --name springboot-app springboot-architecture-lab:latest'
            }
        }
    }
}