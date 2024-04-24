package net.javaguides.springboot.controller;

import org.springframework.http.ResponseEntity;

public class ResponseFactory {

    public static ResponseEntity<?> createSuccessResponse(Object data) {
        return ResponseEntity.ok(data);
    }

    public static ResponseEntity<?> createErrorResponse(String message) {
        return ResponseEntity.internalServerError().body(message);
    }
}
