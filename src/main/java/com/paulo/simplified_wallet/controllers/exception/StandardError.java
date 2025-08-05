package com.paulo.simplified_wallet.controllers.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record StandardError(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path) {
}
