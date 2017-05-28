package com.sg.m3vendingmachine.service;

public class FullOfMoneyException extends Exception {
    public FullOfMoneyException(String message){
        super(message);
    }
    
    public FullOfMoneyException(String message, Throwable cause){
        super(message, cause);
    }
}
