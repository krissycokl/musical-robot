package com.sg.PP4IfElse;
import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        int picked = 37;
        int userPick;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Pick a #: ");
     
        userPick = Integer.parseInt(sc.nextLine());
        
        if (userPick == picked) {
            System.out.println("You got it.");
        }
        else if (userPick < picked) {
            System.out.println("Too low.  It was "+picked);
        }
        else if (userPick > picked) {
            System.out.println("Too high.  It was "+picked);
        }
        else{
            System.out.println("Did you even guess a number?");
        }
    }
}
