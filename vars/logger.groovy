/*def Integer TRACE = 1
def Integer DEBUG = 2
Integer INFO = 3
Integer WARN = 4
Integer ERROR = 5
Integer FATAL = 6*/

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
            result = INFO // INFO
            break
    }
}

/*def setLoggingLevel(String level = "INFO") {
    this.loggingLevel = level
}*/

def trace(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) >= 1) {
        println("[" + this.getCurrentTimestamp() + "] TRACE: " + message)
    }
}

def debug(String message) {
    if (getLoggingLevel(env.LOGGING_LEVEL) >= 2) {
        println("[" + this.getCurrentTimestamp() + "] DEBUG: " + message)
    }
}

def info(String message) {
    println("INFO has called : " + getLoggingLevel(env.LOGGING_LEVEL))
    if(getLoggingLevel(env.LOGGING_LEVEL) >= 3) {
        println("[" + this.getCurrentTimestamp() + "] INFO: " + message)
    }
}

def warn(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) >= 4) {
        println("[" + this.getCurrentTimestamp() + "] WARN: " + message)
    }
}

def error(String message) {
    if (getLoggingLevel(env.LOGGING_LEVEL) >= 5) {
        println("[" + this.getCurrentTimestamp() + "] ERROR: " + message)
    }
}

def fatal(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) >= 6) {
        println("[" + this.getCurrentTimestamp() + "] FATAL: " + message)
    }
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MMM-yyyy HH:mm:ss.SSS")
}