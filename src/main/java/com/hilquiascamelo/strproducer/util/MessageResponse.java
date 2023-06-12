package com.hilquiascamelo.strproducer.util;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageResponse {
    private final String message;
    private final String data;
    private final String status;

    public MessageResponse(String message, HttpStatus status) {
        this.message = message;
        this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.status = status.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
