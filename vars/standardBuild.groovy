def call(String gitRepo) {
    pipeline {

        agent any

        tools {
            maven 'M3'
            jdk 'Java8'
        }

        stages {
            stage('checkout') {
                steps {
                    checkOut(gitRepo)
                }
            }

            stage('build') {
                steps {
                    mvnBuild('clean compile')
                }
            }

            stage('Unit Test') {
                steps {
                    mvnBuild('test')
                }
            }

            stage('SonarQube Scan') {
                steps {
                    mvnBuild('sonar:sonar')
                }
            }
        }
    }
}