package com.sg.PP6WhilesAndDos;
import java.util.Scanner;
public class DoOrDoNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Should I do it? y/n");
        boolean doIt;
        
        if (sc.next().equals("y")){
            doIt = true;
        } else {
            doIt = false;
        }
        
        boolean didIt = false;
        
        //do{
        //    didIt = true;
        //    break;
        //} while (doIt);
        
        while (doIt){
            didIt = true;
            break;
        }
        
        if (doIt && didIt){
            System.out.println("Did it!");
        } else if (!doIt && didIt){
            System.out.println("You said not to, but I did");
        } else {
            System.out.println("Didn't do it.");
        }
        
        // As originally written, if I tell it
        // to do it, it does it.
        // If I tell it not to do it, it still does it.
        
        // When written as while, instead of do-while,
        // it does not dot it when told not to.
    }
}
