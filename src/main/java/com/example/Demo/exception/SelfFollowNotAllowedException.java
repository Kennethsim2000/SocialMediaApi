package com.example.Demo.exception;

public class SelfFollowNotAllowedException extends RuntimeException{
    private String message;

    public SelfFollowNotAllowedException() {}

    public SelfFollowNotAllowedException(String msg) {
        super(msg);
        this.message = msg;
    }
}
