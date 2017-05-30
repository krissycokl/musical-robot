package com.sg.m4unittests;

import static com.sg.m4unittests.AlarmClock.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlarmClockTest {

    public AlarmClockTest() {
    }

    @Test
    public void testAlarmClockVacation() {
        assertEquals("10:00",alarmClock(2,true));
    }

    @Test
    public void testAlarmClockWeekday(){
        assertEquals("7:00",alarmClock(4,false));
    }
    
    @Test
    public void testAlarmClockWeekend(){
        assertEquals("10:00",alarmClock(0,false));
    }
}