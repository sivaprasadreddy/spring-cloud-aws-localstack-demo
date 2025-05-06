package com.jetbrains.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "app")
public record ApplicationProperties(
        @DefaultValue("testbucket")
        String bucketName,
        @DefaultValue("testqueue")
        String queueName) {}
