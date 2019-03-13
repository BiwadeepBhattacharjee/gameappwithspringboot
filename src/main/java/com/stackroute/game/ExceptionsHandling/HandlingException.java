package com.stackroute.game.ExceptionsHandling;


import com.stackroute.game.exceptions.PlayerAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlingException {
    @ExceptionHandler(value = PlayerAlreadyExistsException.class)
    public ResponseEntity<String> playerAlreadyExistsExceptionHandler(PlayerAlreadyExistsException e) {
        return new ResponseEntity<>("Exception occured at Global " + e.getMessage(), HttpStatus.CONFLICT);
    }
}
