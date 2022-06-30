
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
              bat 'mvn test -Dtest=healthcheck.HelathCheckTest.java'
            }
        }
        stage('Contract'){
            steps{
              bat 'mvn test -Dtest=contract.SingleUserContractTest.java'
            }
        }
    }
}
