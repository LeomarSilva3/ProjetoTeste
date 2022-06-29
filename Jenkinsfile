
pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
    }
}
