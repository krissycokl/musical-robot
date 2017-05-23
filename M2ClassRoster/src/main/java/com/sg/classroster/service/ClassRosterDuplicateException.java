package com.sg.classroster.service;

public class ClassRosterDuplicateException extends Exception {
    public ClassRosterDuplicateException(String message){
        super(message);
    }
    
    public ClassRosterDuplicateException(String message, Throwable cause){
        super(message, cause);
    }
}
