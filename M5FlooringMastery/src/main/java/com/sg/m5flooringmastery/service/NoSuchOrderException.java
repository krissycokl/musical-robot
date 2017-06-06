package com.sg.m5flooringmastery.service;

public class NoSuchOrderException extends Exception {
    public NoSuchOrderException(String msg){
        super(msg);
    }
    
    public NoSuchOrderException(String msg, Throwable ex){
        super(msg, ex);
    }
}
