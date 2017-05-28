package com.sg.m3vendingmachine.service;

public class MachineAtCapacityException extends Exception {
    public MachineAtCapacityException(String message){
        super(message);
    }
    
    public MachineAtCapacityException(String message, Throwable cause){
        super(message, cause);
    }
}
