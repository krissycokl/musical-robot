package com.sg.m3vendingmachine.service;

public class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(String message){
        super(message);
    }
    
    public ItemOutOfStockException(String message, Throwable cause){
        super(message, cause);
    }
}
