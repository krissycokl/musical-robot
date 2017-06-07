package com.sg.m5flooringmastery.service;

class OrderEditException extends Exception {
    public OrderEditException(String msg){
        super(msg);
    }
    
    public OrderEditException(String msg, Throwable ex){
        super(msg, ex);
    }
}
