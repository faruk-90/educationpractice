package com.example.educationpractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralExceptionHandler {
    Logger LOG = LoggerFactory.getLogger(CentralExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponDto> onException(Exception ex) {
        LOG.error("An error occurred: ", ex);
        CommonResponDto<Object> commonResponDto = new CommonResponDto<>(null,"An unexpected error occurred. Please try again later.", 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commonResponDto);
    }
}
