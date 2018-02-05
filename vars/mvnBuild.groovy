def call(String args) {

    def logger = new Logger();
    logger.info("mvnBuild")

    sh 'mvn ' + args

}