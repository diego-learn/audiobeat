package com.br.audiobeatapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidFileTypeException.class)
    @ResponseBody
    public ApiMessage handleInvalidFileException(InvalidFileTypeException e) {
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.toString());
        exception.setStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ApiMessage handleBadRequestException(BadRequestException e){
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(GCPFileUploadException.class)
    @ResponseBody
    public ApiMessage handleFileUploadException(GCPFileUploadException e){
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(FileException.class)
    @ResponseBody
    public ApiMessage handleFileWriteException(FileException e){
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(NotSuchElementException.class)
    @ResponseBody
    public ApiMessage handleBadRequestException(NotSuchElementException e){
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(ElementExistException.class)
    @ResponseBody
    public ApiMessage handleElementExistException(ElementExistException e){
        ApiMessage exception = new ApiMessage();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }
}
