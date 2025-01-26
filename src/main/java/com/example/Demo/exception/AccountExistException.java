package com.example.Demo.exception;

public class AccountExistException extends RuntimeException{

    private String message;

    public AccountExistException() {}

    public AccountExistException(String msg) {
        super(msg);
        this.message = msg;
    }
}
