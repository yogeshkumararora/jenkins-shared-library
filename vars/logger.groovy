def loggingLevel

def setLoggingLevel(String level) {
    this.loggingLevel = level
}

def info(String message) {
    println("[" + this.getCurrentTimestamp() +"] INFO:" + message)
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MM-yyyy HH:mm:ss.SSS")
}