package com.sg.PP6WhilesAndDos;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random ran = new Random();
        
        double chance = 0.0;
        int timesTold = 0;
        
        do {
            timesTold++;
            System.out.println("Clean your room! (x"+timesTold+")");
            chance += .05;
            if (ran.nextDouble()<chance){
                System.out.println("Sorry, mother.  Of course I'll clean.");
                System.out.println("That's a necessary part of belonging to a family.");
                break;
            }
            if (timesTold == 15){
                System.out.println("Forget it. I'm smashing your GameCube.");
                break;
            }
        } while (timesTold < 15);
    }
}
