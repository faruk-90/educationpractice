package com.example.educationpractice.controller;

import lombok.Data;

@Data
public class CommonResponDto<T> {
    private T data;
    private String message;
   private int statusCode;

    public CommonResponDto(T data) {
        this.data = data;
    }

    public CommonResponDto(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public CommonResponDto(T data, String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }
}
