pipeline {
    agent any

    stages {
        stage('Deploy to EC2') {
            steps {
                sh '''
ssh ubuntu@40.192.37.255 << 'EOF'
cd spring-boot-application
git pull origin main
docker-compose down
docker-compose up --build -d
EOF
'''
            }
        }
    }
}
