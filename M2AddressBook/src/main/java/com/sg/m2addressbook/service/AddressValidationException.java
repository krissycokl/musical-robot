package com.sg.m2addressbook.service;

public class AddressValidationException extends Exception{
    public AddressValidationException(String message){
        super(message);
    }
    
    public AddressValidationException(String message, Throwable cause){
        super(message, cause);
    }
}
