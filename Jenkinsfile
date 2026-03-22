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
        stage('Docker Build & Push') {
            steps {
                // Build Docker image from Dockerfile
               sh '''
               aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 050366487181.dkr.ecr.us-east-2.amazonaws.com
               docker build -t springboot-architecture-lab:latest .
               docker tag springboot-architecture-lab:latest 050366487181.dkr.ecr.us-east-2.amazonaws.com/springboot-architecture-lab:latest
               docker push 050366487181.dkr.ecr.us-east-2.amazonaws.com/springboot-architecture-lab:latest
                               '''
            }
        }
        stage('Deploy') {
            steps {
                // Run container on EC2
               sh '''
               docker stop springboot-app || true
               docker rm springboot-app || true
               docker pull 050366487181.dkr.ecr.us-east-2.amazonaws.com/springboot-architecture-lab:latest
               docker run -d -p 8080:8080 --name springboot-app 050366487181.dkr.ecr.us-east-2.amazonaws.com/springboot-architecture-lab:latest
               '''
            }
        }
    }
}