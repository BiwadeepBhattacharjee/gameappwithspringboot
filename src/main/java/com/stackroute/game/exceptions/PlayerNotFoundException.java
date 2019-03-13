package com.stackroute.game.exceptions;

public class PlayerNotFoundException extends Exception {
    private String message1;

    public PlayerNotFoundException(String message) {
        super(message);
        this.message1 = message;
    }

    public PlayerNotFoundException() {
    }
}
