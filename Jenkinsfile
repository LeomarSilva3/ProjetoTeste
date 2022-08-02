
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
              bat 'mvn test -Dtest="HelathCheckTest"'
            }
        }
        stage('Contract'){
            steps{
              bat 'mvn test -Dtest="SingleUserContractTest"'
            }
        }
        stage('Functional'){
            steps{
              bat 'mvn test -Dtest="UserCreateTest,UserListTest,UserSingleTest"'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
