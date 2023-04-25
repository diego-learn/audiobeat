package com.br.audiobeatapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class errorResponse {
    private int status;
    private String error;
    private String message;

}
