package com.example.management.api;

import org.slf4j.MDC;

import java.util.UUID;

public class RequestID {

    private static final String id = "id";

    public static void init() {
        MDC.put(id, UUID.randomUUID().toString());
    }

    public static String get () {
        return MDC.get(id);
    }

    public static void clear() {
        MDC.remove(id);
    }
}