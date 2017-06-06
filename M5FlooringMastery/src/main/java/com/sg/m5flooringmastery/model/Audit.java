package com.sg.m5flooringmastery.model;

import java.time.LocalDateTime;

public class Audit {
    
    private final LocalDateTime timestamp;
    private final String newVal;
    private final String oldVal;
    private final int id;
    
    public Audit(int id, String newVal, String oldVal){
        this.id = id;
        this.newVal = newVal;
        this.oldVal = oldVal;
        this.timestamp = LocalDateTime.now();
    }
    
    public Audit(int id, String newVal){
        this(id, newVal, "");
    }
}
