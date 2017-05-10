package com.sg.scanner;
import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int age;
        
        System.out.println("How old are you, ya geezer?");
        age = Integer.parseInt(myScanner.nextLine());
        
        System.out.println("Your heart shouldn't work above " + (220-age)
                + " bpm.");
     
        //System.out.println("Your target range is " + (.5*(220-age))
        //        + "-" + (.85*(220-age)) + " bpm.");
        
        //System.out.println("Your target range is " + ((220-age)/2)
        //        + "-" + ((220-age)*17/20) + " bpm.");
        
        System.out.println("Your target range is " + 
                ((int) (.5*(220-age))) + "-"
                + ((int) (.85*(220-age))) + " bpm.");
    }
}
