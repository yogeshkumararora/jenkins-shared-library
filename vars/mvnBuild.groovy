def call(String args) {

    this.logger.info("Executing maven goals from mvnBuild.groovy")

    sh 'env > env.txt'
    for (String i : readFile('env.txt').split("\r?\n")) {
        println i
    }

    if("DEBUG".equals(env.LOGGING_LEVEL)) {
        println("The logger level is set to DEBUG")
    }

    this.logger.trace("trace: This should not be printed")
    this.logger.warn("warn: This should be printed")

    sh 'mvn ' + args

}