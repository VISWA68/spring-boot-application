pipeline {
    agent any

    stages {
        stage('Deploy to EC2') {
            steps {
                sh '''
                ssh ubuntu@18.60.233.196 << 'EOF'
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
