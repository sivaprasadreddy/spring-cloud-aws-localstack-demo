package com.jetbrains.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfig {
    @Autowired
    ApplicationProperties properties;

    @Bean
    @ServiceConnection
    LocalStackContainer localstackContainer() throws IOException, InterruptedException {
        LocalStackContainer localStack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:4.3.0"));
        localStack.start();
        localStack.execInContainer("awslocal", "s3", "mb", "s3://" + properties.bucketName());
        localStack.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", properties.queueName());
        return localStack;
    }
}
