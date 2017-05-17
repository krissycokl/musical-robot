package com.sg.PP6WhilesAndDos;
import java.util.*;
public class RollerCoaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's go on a rollie coastie.");
        System.out.println("Say when you want off.");
        
        String keep = "y";
        int rides = 0;
        while(keep.equals("y")){
            System.out.println("°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸");
            System.out.println("Keep going? (y/n)");
            keep = sc.nextLine();
            rides++;
            // No need to "int rides++;", as the variable is already declared out of the loop.
        }
        
        System.out.println("I think I'm gonna be sick...");
        System.out.println("That was "+rides+" rides.");
    }
}
