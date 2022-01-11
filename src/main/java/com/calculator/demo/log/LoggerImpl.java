package com.calculator.demo.log;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class LoggerImpl implements Logger {

    private TracerImpl tracerImpl;

    private LoggerImpl() {
        this.tracerImpl = new TracerImpl();
    }

    private TracerImpl getTracerImpl() {
        return tracerImpl == null ? tracerImpl = new TracerImpl() : tracerImpl;
    }

    @Override
    public void log(String message) {
        getTracerImpl().trace(message);
    }
}
