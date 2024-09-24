package com.mistake.day11.demo2;

abstract class Decorator implements ILogger {
    protected ILogger logger;

    public Decorator(ILogger logger) {
        this.logger = logger;
    }
}
