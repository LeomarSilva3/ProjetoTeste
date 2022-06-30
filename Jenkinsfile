
pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Health Checked'){
            steps{
              bat 'mvn test -DTests=healthcheck'
            }
        }
        stage('Contract'){
            steps{
              bat 'mvn test -DTests=contract'
            }
        }
        stage('Functional'){
            steps{
              bat 'mvn test -DTests=Functional'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
