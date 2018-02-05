import com.yogeshkumararora.tooling.jenkins.logging.Logger

def call(String args) {

    def Logger logger = new Logger()
    logger.info("Executing maven goals from mvnBuild.groovy")

    sh 'mvn ' + args

}