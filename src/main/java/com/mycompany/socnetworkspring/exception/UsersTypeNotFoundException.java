package com.mycompany.socnetworkspring.exception;

public class UsersTypeNotFoundException extends RuntimeException{
    private String message;
    public UsersTypeNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
