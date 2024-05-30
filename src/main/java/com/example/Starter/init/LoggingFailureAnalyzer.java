package com.example.Starter.init;

import com.example.Starter.exception.LoggingStartupException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class LoggingFailureAnalyzer extends AbstractFailureAnalyzer<LoggingStartupException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, LoggingStartupException cause) {
        return new FailureAnalysis(cause.getMessage(),
                "Укажите верные значения для свойства в файле конфигурации. Допустимые значения: true или false.",
                cause);
    }
}
