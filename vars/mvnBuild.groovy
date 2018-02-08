def call(String args) {

    this.logger.info("Executing maven goals from mvnBuild.groovy")

    sh 'mvn ' + args

}