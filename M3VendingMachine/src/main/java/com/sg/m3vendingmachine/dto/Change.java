package com.sg.m3vendingmachine.dto;

import java.math.BigDecimal;

public class Change {
    private BigDecimal balance;
    
    public static BigDecimal dollar  = new BigDecimal("1.00").setScale(2);
    public static BigDecimal quarter = new BigDecimal("0.25").setScale(2);
    public static BigDecimal dime    = new BigDecimal("0.10").setScale(2);
    public static BigDecimal nickel  = new BigDecimal("0.05").setScale(2);
    public static BigDecimal penny   = new BigDecimal("0.01").setScale(2);
    
    public Change(BigDecimal balance){
        this.balance = balance;
    }
    
    public void changeBalance(BigDecimal increment){
        balance = balance.add(increment);
    }
    
    public BigDecimal getBalance(){
        return balance;
    }
    
    public BigDecimal[] makeChange(BigDecimal cost){
        
        BigDecimal[] changeByType = new BigDecimal[4];
        BigDecimal change = getBalance().subtract(cost);
        
        changeByType[0] = change.divideToIntegralValue(quarter);
        changeByType[1] = change.subtract(changeByType[0].multiply(quarter))
                         .divideToIntegralValue(dime);
        changeByType[2] = change.subtract(changeByType[0].multiply(quarter))
                         .subtract(changeByType[1].multiply(dime))
                         .divideToIntegralValue(nickel);
        changeByType[3] = change.subtract(changeByType[0].multiply(quarter))
                         .subtract(changeByType[1].multiply(dime))
                         .subtract(changeByType[2].multiply(nickel))
                         .multiply(new BigDecimal("100").setScale(0));
        
        balance = new BigDecimal("0").setScale(2);
        
        return changeByType;
    }
}
