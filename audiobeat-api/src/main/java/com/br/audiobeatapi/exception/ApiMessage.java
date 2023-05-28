package com.br.audiobeatapi.exception;

import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class ApiMessage{

    private String errorMessage;
    private Integer statusCode;
    private ZonedDateTime zonedDateTime;
}
