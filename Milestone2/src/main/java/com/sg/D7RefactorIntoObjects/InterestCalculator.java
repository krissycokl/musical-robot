package com.sg.D7RefactorIntoObjects;

import java.math.BigDecimal;

public class InterestCalculator {
    public static void main(String[] args) {
        
        BigDecimal balBegin;
        BigDecimal i;
        int compoundings;
        int numYears;    
        
        balBegin = new BigDecimal(InterestCalcUI.getBeginningBalance());
        i = new BigDecimal(InterestCalcUI.getInterestRate());
        compoundings = InterestCalcUI.getCompoundings();
        if (compoundings == 0){
            System.out.println("Invalid input.");
            System.exit(0);
        }
        numYears = InterestCalcUI.getYears();
        
        InterestCalcAccount account = new InterestCalcAccount(
                balBegin,
                i,
                compoundings,
                numYears
        );
        
        for (int iter=1;iter<= numYears;iter++){
            account.addYear(iter);
        }   
    }
}