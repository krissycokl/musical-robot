package com.sg.PP5Random;
import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        
        Boolean negative = ran.nextBoolean();
        int num = ran.nextInt(100);
        Boolean correct = false;
        int guess;
        
        if(negative){num = -1*num;}
        
        System.out.println("I've picked an int between -100 and 100, exclusive.\n");
        
        while (!correct){
            System.out.println("What's your guess?");
            guess = Integer.parseInt(sc.nextLine());
            if(guess<num){
                System.out.println("Too low. Try again.\n");
            } else if(guess>num){
                System.out.println("Too high. Try again.\n");
            } else {
                System.out.println("You got it! "+num+" is correct.");
                correct = true;
            }
        }
    }
}
