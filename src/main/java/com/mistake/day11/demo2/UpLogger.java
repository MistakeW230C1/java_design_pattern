package com.mistake.day11.demo2;

/**
 * @author mistake
 */
public class UpLogger extends Decorator {

    public UpLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String msg) {
        msg = msg.toUpperCase();
        logger.log(msg);
    }
}
