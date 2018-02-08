def call(String args) {

    this.logger.info("Executing maven goals from mvnBuild.groovy")

    sh 'env > env.txt'
    for (String i : readFile('env.txt').split("\r?\n")) {
        println i
    }

    if("DEBUG".equals(env.LOGGER_LEVEL)) {
        println("The logger level is set to DEBUG")
    }

    sh 'mvn ' + args

}