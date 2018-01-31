def call(String gitRepo) {
    pipeline {

        agent any

        stages {
            stage('checkout') {
                steps {
                    checkOut(gitRepo)
                }
            }
        }
    }
}