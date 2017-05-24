package com.sg.D7RefactorIntoObjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestCalcUI {
    static Scanner sc = new Scanner(System.in);
    
    public static String getBeginningBalance(){
        System.out.println("Beginning balance?");
        return sc.nextLine();
    }
    
    public static String getInterestRate(){
        System.out.println("Interest rate?");
        BigDecimal i = new BigDecimal(sc.nextLine());
        if (i.compareTo(BigDecimal.ONE) == 1)
            {
                return i.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString();
            }
        return i.toString();
    }
    
    public static int getCompoundings(){
        System.out.println("How often is it compounded?");
        System.out.println("a.) Daily     b.) Weekly");
        System.out.println("c.) Monthly   d.) Quarterly");
        System.out.println("e.) Yearly");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("daily")){
            return 365;
        } else if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("weekly")){
            return 52;
        } else if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("monthly")){
            return 12;
        } else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("quarterly")){
            return 4;
        } else if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("yearly")){
            return 1;
        } else {return 0;}
    }
    
    public static int getYears(){
        System.out.println("How many years invested?");
        return Integer.parseInt(sc.nextLine());
    }
}
