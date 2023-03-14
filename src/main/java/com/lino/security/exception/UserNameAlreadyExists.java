package com.lino.security.exception;

public class UserNameAlreadyExists extends Exception{
    public UserNameAlreadyExists() {
        super();
    }

    public UserNameAlreadyExists(String message) {
        super(message);
    }
}
