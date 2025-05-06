package com.jetbrains.demo;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    private final SqsTemplate sqsTemplate;

    public MessagePublisher(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void publish(String queueName, Message message) {
        sqsTemplate.send(to -> to.queue(queueName).payload(message));
    }
}
