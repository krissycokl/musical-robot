package com.sg.D7RefactorIntoObjects;

public class InterestCalcAccount {
    private final double BALBEGINNING;
    private final double I;
    private final int COMPOUNDINGS;
    
    private double balCurrent;
    private InterestCalcYear[] years;
    
    public InterestCalcAccount(double balBegin, double i, int compoundings, int numYears){
        this.BALBEGINNING = balBegin;
        this.balCurrent = balBegin;
        this.I = i;
        this.COMPOUNDINGS = compoundings;
        this.years = new InterestCalcYear[numYears];
    }
    
    public double getBalance(){
        return balCurrent;
    }
    
    public void setBalance(double balNew){
        this.balCurrent = balNew;
    }
    
    public void addYear(int year){
        years[year-1] = new InterestCalcYear(getBalance(),I,COMPOUNDINGS,year);
        setBalance(years[year-1].getBalance());
        years[year-1].printYear();
    }
}
