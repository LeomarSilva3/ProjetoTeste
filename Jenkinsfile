
pipeline {
    agent any
    
        } stage('Build') {
            steps {
             sh 'mvn test'
            }
        }
    post {
        always {
            junit( allowEmptyResults: true, testResults: '*/test-reports/.xml' )
        }
    }
}
