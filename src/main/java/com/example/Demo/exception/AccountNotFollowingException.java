package com.example.Demo.exception;

public class AccountNotFollowingException extends RuntimeException{
    private String message;

    public AccountNotFollowingException() {}

    public AccountNotFollowingException(String msg) {
        super(msg);
        this.message = msg;
    }
}
