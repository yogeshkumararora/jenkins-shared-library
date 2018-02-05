def call(String args) {

    def logger = new Logger();
    logger.info("mvnBuild")

    echo "mvnBuild via echo"

    sh 'mvn ' + args

}