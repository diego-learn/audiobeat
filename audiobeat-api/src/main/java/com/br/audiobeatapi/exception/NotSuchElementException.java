package com.br.audiobeatapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotSuchElementException extends RuntimeException {

    private final String message;
}
