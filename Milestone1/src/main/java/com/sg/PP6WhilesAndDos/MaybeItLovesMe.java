package com.sg.PP6WhilesAndDos;

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        
        Random ran = new Random();
        
        int petals = ran.nextInt(77) + 13;
        int counter = 0;
        
        System.out.println("Pick the petals...");
        
        while (counter < petals){
            counter++;
            if(counter%2==0){
                System.out.println("It loves me NOT.");
                if(counter==petals){
                    System.out.println("Figures.");
                }
            }
            else{
                System.out.println("It loves me.");
                if(counter==petals){
                    System.out.println("Huh, that's cool.");
                }
            }
        }
    }
}
