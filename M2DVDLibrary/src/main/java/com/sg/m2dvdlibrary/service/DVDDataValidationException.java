package com.sg.m2dvdlibrary.service;

public class DVDDataValidationException extends Exception {
    public DVDDataValidationException (String message){
        super(message);
    } 
    
    public DVDDataValidationException (String message, Throwable cause){
        super(message, cause);
    }
}
