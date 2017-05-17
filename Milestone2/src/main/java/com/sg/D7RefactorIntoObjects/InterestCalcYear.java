package com.sg.D7RefactorIntoObjects;

public class InterestCalcYear {
    private final double BALBEGINNING;
    private final double BALEND;
    private final int YEAR;
    
    public InterestCalcYear(double balBegin, double i, int compoundings, int year){
        this.BALBEGINNING = balBegin;
        this.BALEND       = balBegin*Math.pow((1+i/compoundings),compoundings);
        this.YEAR         = year;
    }
    
    public double getBalance(){
        return BALEND;
    }
    
    public void printYear(){
        System.out.println("\nYour balance at the beginning of year "+YEAR
                +" was $"+Math.round(BALBEGINNING)+".");
        System.out.println("In year "+YEAR+" you earned $"+
                Math.round(BALEND-BALBEGINNING)+" dollars in interest.");
        System.out.println("Your balance at the end of year "+YEAR
                + " was $"+Math.round(BALEND)+".");
    }
}
