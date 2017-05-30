package com.sg.m4unittests;

public class AlarmClock {
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    public static String alarmClock(int day, boolean vacation) {
        if (vacation){
            return "10:00";
        } else if (day > 0 && day < 7){
            return "7:00";
        } else {
            return "10:00";
        }
    }

}
