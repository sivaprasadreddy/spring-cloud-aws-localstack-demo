package com.jetbrains.demo;

import java.util.UUID;

public record Message(UUID id, String content) {}
