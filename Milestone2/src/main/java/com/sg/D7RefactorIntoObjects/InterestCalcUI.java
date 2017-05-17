package com.sg.D7RefactorIntoObjects;
import java.util.Scanner;

public class InterestCalcUI {
    static Scanner sc = new Scanner(System.in);
    
    public static double getBeginningBalance(){
        System.out.println("Beginning balance?");
        return Double.parseDouble(sc.nextLine());
    }
    
    public static double getInterestRate(){
        System.out.println("Interest rate?");
        double i = Double.parseDouble(sc.nextLine());
        if (i>1){return i/100;}
        return i;
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
