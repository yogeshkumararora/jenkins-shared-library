package com.yogeshkumararora.tooling.jenkins.logging

class Logger implements Serializable{

    def steps

    public Logger(steps) {
        this.steps = steps
    }

    def info(String message) {
        steps.echo("INFO:" + message)
    }
}