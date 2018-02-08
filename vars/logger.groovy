def loggingLevel

def setLoggingLevel(String level = "INFO") {
    this.loggingLevel = level
}

def trace(String message) {
    println("[" + this.getCurrentTimestamp() +"] TRACE: " + message)
}

def debug(String message) {
    println("[" + this.getCurrentTimestamp() +"] DEBUG: " + message)
}

def info(String message) {
    println("[" + this.getCurrentTimestamp() +"] INFO: " + message)
}

def warn(String message) {
    println("[" + this.getCurrentTimestamp() +"] WARN: " + message)
}

def error(String message) {
    println("[" + this.getCurrentTimestamp() +"] ERROR: " + message)
}

def fatal(String message) {
    println("[" + this.getCurrentTimestamp() +"] FATAL: " + message)
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MMM-yyyy HH:mm:ss.SSS")
}