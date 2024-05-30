package com.example.Starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "endpoint.logging")
public record EndpointLoggingProperties(boolean active) {}
