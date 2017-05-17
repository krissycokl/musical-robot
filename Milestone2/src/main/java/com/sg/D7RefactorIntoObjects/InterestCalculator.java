package com.sg.D7RefactorIntoObjects;

public class InterestCalculator {
    public static void main(String[] args) {
        
        double balBegin;
        double i;
        int compoundings;
        int numYears;    
        
        balBegin = InterestCalcUI.getBeginningBalance();
        i = InterestCalcUI.getInterestRate();
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