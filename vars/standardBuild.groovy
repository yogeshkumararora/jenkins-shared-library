def call(String gitRepo) {
    pipeline {

        agent any

        tools {
            maven 'M3'
            jdk 'Java8'
        }

        stages {
            stage('Checkout') {
                steps {
                    checkOut(gitRepo)
                }
            }

            stage('Build') {
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
                    withSonarQubeEnv('SonarQube') {
                        mvnBuild('sonar:sonar')
                    }
                }
            }

            stage("SonarQube Quality Gate Check") {
                steps {
                    timeout(time: 1, unit: 'HOURS') {
                        script{
                            def qg = waitForQualityGate()
                            if (qg.status != 'OK') {
                                error "Pipeline aborted due to quality gate failure: ${qg.status}"
                            }
                        }
                    }
                }
            }
        }
    }
}