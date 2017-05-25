package com.sg.D7RefactorIntoObjects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalcYear {
    private final BigDecimal BALBEGINNING;
    private final BigDecimal BALEND;
    private final BigDecimal INTEREST;
    private final int YEAR;
    
    public InterestCalcYear(BigDecimal balBegin, BigDecimal i, int compoundings, int year){
        
        BigDecimal base = BigDecimal.ONE.add(i.divide(new BigDecimal(compoundings),10,RoundingMode.HALF_UP));
        BigDecimal expo = base.pow(compoundings);
        
        this.BALBEGINNING = balBegin;
        this.BALEND       = BALBEGINNING.multiply(expo).setScale(2,RoundingMode.HALF_UP);
        this.INTEREST     = BALEND.subtract(BALBEGINNING);
        this.YEAR         = year;
        
    }
    
    public BigDecimal getBalance(){
        return BALEND;
    }
    
    public void printYear(){
        System.out.println("\nYour balance at the beginning of year "+YEAR
                +" was $"+BALBEGINNING.toPlainString());
        System.out.println("In year "+YEAR+" you earned $"+
                INTEREST.toPlainString()+" dollars in interest.");
        System.out.println("Your balance at the end of year "+YEAR
                + " was $"+BALEND.toPlainString()+".");
    }
}
