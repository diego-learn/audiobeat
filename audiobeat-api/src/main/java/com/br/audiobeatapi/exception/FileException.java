package com.br.audiobeatapi.exception;

import lombok.Data;

@Data
public class FileException extends RuntimeException{

    private final String message;

    public FileException(String message) {
        super(message);
        this.message = message;
    }
}
