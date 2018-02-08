def call(String args) {

    this.logger.info("Executing maven goals from mvnBuild.groovy")

    sh 'env > env.txt'
    for (String i : readFile('env.txt').split("\r?\n")) {
        println i
    }

    sh 'mvn ' + args

}