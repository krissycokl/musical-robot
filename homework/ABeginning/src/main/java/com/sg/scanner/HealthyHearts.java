package com.sg.scanner;
import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int age;
        
        System.out.println("How old are you, ya geezer?");
        age = Integer.parseInt(myScanner.nextLine());
        
        System.out.println("Your shouldn't exert yourself past " + (220-age)
                + " bpm.");
     
        System.out.println("Your target range is " + Math.round(.5*(220-age))
                + "-" + Math.round(.85*(220-age)) + " bpm.");
    }
}
