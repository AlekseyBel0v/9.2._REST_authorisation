package com.belov.restauthorisation.exception;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
