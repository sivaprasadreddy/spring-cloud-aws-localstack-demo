package com.jetbrains.demo;

import org.springframework.boot.SpringApplication;

public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.from(Application::main)
                .with(TestcontainersConfig.class)
                .run(args);
    }
}
