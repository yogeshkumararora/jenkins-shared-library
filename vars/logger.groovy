/*def Integer TRACE = 1
def Integer DEBUG = 2
Integer INFO = 3
Integer WARN = 4
Integer ERROR = 5
Integer FATAL = 6*/

def getLoggingLevel(String level) {

    switch(level) {
        case 'TRACE':
            result = TRACE
            break
        case 'DEBUG':
            result = 2
            break
        case 'INFO':
            result = INFO
            break
        case 'WARN':
            result = WARN
            break
        case 'ERROR':
            result = ERROR
            break
        case 'FATAL':
            result = FATAL
            break
        default:
            result = INFO // INFO
            break
    }
}

def setLoggingLevel(String level = "INFO") {
    this.loggingLevel = level
}

def trace(String message) {
    if(loggingLevel >=TRACE) {
        println("[" + this.getCurrentTimestamp() + "] TRACE: " + message)
    }
}

def debug(String message) {
    if (loggingLevel >= DEBUG) {
        println("[" + this.getCurrentTimestamp() + "] DEBUG: " + message)
    }
}

def info(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) >= INFO) {
        println("[" + this.getCurrentTimestamp() + "] INFO: " + message)
    }
}

def warn(String message) {
    if(loggingLevel >= WARN) {
        println("[" + this.getCurrentTimestamp() + "] WARN: " + message)
    }
}

def error(String message) {
    if (loggingLevel >= ERROR) {
        println("[" + this.getCurrentTimestamp() + "] ERROR: " + message)
    }
}

def fatal(String message) {
    if(loggingLevel >= FATAL) {
        println("[" + this.getCurrentTimestamp() + "] FATAL: " + message)
    }
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MMM-yyyy HH:mm:ss.SSS")
}