package com.mycompany.socnetworkspring.exception;

public class FriendshipNotFoundException extends RuntimeException{
    public FriendshipNotFoundException(String message) {
        super(message);
    }
}
