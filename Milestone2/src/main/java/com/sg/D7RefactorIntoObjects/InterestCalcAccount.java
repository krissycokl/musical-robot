package com.sg.D7RefactorIntoObjects;

import java.math.BigDecimal;

public class InterestCalcAccount {
    private final BigDecimal BALBEGINNING;
    private final BigDecimal I;
    private final int COMPOUNDINGS;
    
    private BigDecimal balCurrent;
    private InterestCalcYear[] years;

    InterestCalcAccount(BigDecimal balBegin, BigDecimal i, int compoundings, int numYears) {
        this.BALBEGINNING = balBegin;
        this.balCurrent = balBegin;
        this.I = i;
        this.COMPOUNDINGS = compoundings;
        this.years = new InterestCalcYear[numYears];
    }
    
    public BigDecimal getBalance(){
        return balCurrent;
    }
    
    public void setBalance(BigDecimal balNew){
        this.balCurrent = balNew;
    }
    
    public void addYear(int year){
        years[year-1] = new InterestCalcYear(getBalance(),I,COMPOUNDINGS,year);
        setBalance(years[year-1].getBalance());
        years[year-1].printYear();
    }
}
