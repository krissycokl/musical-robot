package com.sg.m5flooringmastery.dao;

public class StateNotFoundException extends Exception {

    public StateNotFoundException(String message) {
        super(message);
    }

    public StateNotFoundException(String message, Throwable ex){
        super(message, ex);
    }
}
