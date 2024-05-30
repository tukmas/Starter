package com.example.Starter.exception;

public class LoggingStartupException extends RuntimeException {
    public LoggingStartupException(String message) {
        super(message);
    }
}