package com.stackroute.game.exceptions;

public class PlayerAlreadyExistsException extends Exception {
    private String message;


    public PlayerAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public PlayerAlreadyExistsException() {
    }

}
