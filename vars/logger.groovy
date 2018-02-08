def getLoggingLevel(String level) {

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

def trace(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) <= 1) {
        println("[" + this.getCurrentTimestamp() + "] TRACE: " + message)
    }
}

def debug(String message) {
    if (getLoggingLevel(env.LOGGING_LEVEL) <= 2) {
        println("[" + this.getCurrentTimestamp() + "] DEBUG: " + message)
    }
}

def info(String message) {
    println("INFO has called : " + getLoggingLevel(env.LOGGING_LEVEL))
    if(getLoggingLevel(env.LOGGING_LEVEL) <= 3) {
        println("[" + this.getCurrentTimestamp() + "] INFO: " + message)
    }
}

def warn(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) <= 4) {
        println("[" + this.getCurrentTimestamp() + "] WARN: " + message)
    }
}

def error(String message) {
    if (getLoggingLevel(env.LOGGING_LEVEL) <= 5) {
        println("[" + this.getCurrentTimestamp() + "] ERROR: " + message)
    }
}

def fatal(String message) {
    if(getLoggingLevel(env.LOGGING_LEVEL) <= 6) {
        println("[" + this.getCurrentTimestamp() + "] FATAL: " + message)
    }
}

def getCurrentTimestamp() {
    def currentDate = new Date()
    return currentDate.format("dd-MMM-yyyy HH:mm:ss.SSS")
}