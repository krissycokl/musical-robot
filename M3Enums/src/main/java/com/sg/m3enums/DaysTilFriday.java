package com.sg.m3enums;

public class DaysTilFriday {

    public static enum DaysOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DaysOfWeek day = DaysOfWeek.valueOf(io.getString("What day of the week is it?").toUpperCase());
        io.print("Days until Friday:");
        switch (day) {
            case MONDAY:
                System.out.println("4");
                break;
            case TUESDAY:
                System.out.println("3");
                break;
            case WEDNESDAY:
                System.out.println("2");
                break;
            case THURSDAY:
                System.out.println("1");
                break;
            case FRIDAY:
                System.out.println("none, or 7");
                break;
            case SATURDAY:
                System.out.println("6");
                break;
            case SUNDAY:
                System.out.println("5");
        }
    }

}
