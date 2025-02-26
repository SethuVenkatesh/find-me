package com.sethu.backend.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class IdGenerator {
    public String generateContainerId() {
        return "CONT_"+String.valueOf(Instant.now().toEpochMilli());
    }

    public String generateSubContainerId() {
        return "SUBCONT_"+String.valueOf(Instant.now().toEpochMilli());
    }
}
