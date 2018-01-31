@Library ('utils@origin/master') _
pipeline {

  agent any

    stages {
        stage('build') {
            steps {
                mvnBuild('sonarlint-demo')
            }
        }
    }
}