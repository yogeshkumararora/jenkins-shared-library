/*def Integer TRACE = 1
def Integer DEBUG = 2
Integer INFO = 3
Integer WARN = 4
Integer ERROR = 5
Integer FATAL = 6*/

loggingLevel

def getLoggingLevel(String level) {

    println("getLogging: " + level)

    switch(level) {
        case 'TRACE':
            result = 1
            break
        case 'DEBUG':
            result = 2
            break
        case 'INFO':
            result = 3
            break
        case 'WARN':
            result = 4
            break
        case 'ERROR':
            result = 5
            break
        case 'FATAL':
            result = 6
            break
        default:
            result = 3 // INFO
            break
    }
    result
}

def setLoggingLevel(String level) {
    this.loggingLevel = getLoggingLevel(level)
}

def trace(String message) {
    if(this.loggingLevel <= 1) {
        println("[" + this.getCurrentTimestamp() + "] TRACE: " + message)
    }
}

def debug(String message) {
    if (this.loggingLevel <= 2) {
        println("[" + this.getCurrentTimestamp() + "] DEBUG: " + message)
    }
}

def info(String message) {
    println("INFO has called : " + getLoggingLevel(env.LOGGING_LEVEL))
    if(this.loggingLevel <= 3) {
        println("[" + this.getCurrentTimestamp() + "] INFO: " + message)
    }
}

def warn(String message) {
    if(this.loggingLevel <= 4) {
        println("[" + this.getCurrentTimestamp() + "] WARN: " + message)
    }
}

def error(String message) {
    if (this.loggingLevel <= 5) {
        println("[" + this.getCurrentTimestamp() + "] ERROR: " + message)
    }
}

def fatal(String message) {
    if(this.loggingLevel <= 6) {
        println("[" + this.getCurrentTimestamp() + "] FATAL: " + message)
    }
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MMM-yyyy HH:mm:ss.SSS")
}