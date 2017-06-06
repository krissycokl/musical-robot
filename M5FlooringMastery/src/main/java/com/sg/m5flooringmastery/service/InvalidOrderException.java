package com.sg.m5flooringmastery.service;

public class InvalidOrderException extends Exception {
    public InvalidOrderException(String msg){
        super(msg);
    }
    
    public InvalidOrderException(String msg, Throwable ex){
        super(msg, ex);
    }
}
