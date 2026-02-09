pipeline {
    agent any

    stages {
        stage('Deploy to EC2') {
            steps {
                sh '''
                ssh ubuntu@EC2_IP << 'EOF'
                cd springboot-app
                git pull origin main
                docker-compose down
                docker-compose up --build -d
                EOF
                '''
            }
        }
    }
}
