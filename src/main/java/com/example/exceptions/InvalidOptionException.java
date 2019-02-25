package com.example.exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException() {
        super("Invalid Option!\n");
    }
}
