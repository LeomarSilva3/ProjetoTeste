
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
                dir('contract'){
                    bat 'mvn test C:\Users\bleom\.jenkins\workspace\TestAPI_Pipeline\src\test\java\healthcheck.HelathCheckTest.java'
                }
            }
        }
    }
}
