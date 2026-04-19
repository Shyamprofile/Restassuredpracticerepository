pipeline {
    agent any
 tools {
     maven "maven"
    }
    stages {
        stage('Access GIT') {
            steps {
               git 'https://github.com/Shyamprofile/Restassuredpracticerepository.git'
            }
        }
        stage('Build GIT') {
            steps {
              bat 'mvn -Dtest=CreateUser test'
            }
        }
        
    }
}
