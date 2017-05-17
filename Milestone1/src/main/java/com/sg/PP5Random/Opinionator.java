package com.sg.PP5Random;
import java.util.Random;
public class Opinionator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("Not sure what's my fav video game.");
        System.out.println("I'll leave it to Random.");
        
        int x = randomizer.nextInt(5);
        
        System.out.println("Random number generated was: "+x);
        
        switch(x){
            case 0: System.out.println("Baldur's Gate II");
                    break;
            case 1: System.out.println("Pokemon");
                    break;
            case 2: System.out.println("Harvest Moon");
                    break;
            case 3: System.out.println("DDR");
                    break;
            case 4: System.out.println("Fallout: New Vegas");
            // The bug in the original code was the inclusion
            // of the if statement for x == 5.
            // Random.nextInt(5) will never generate a 5.
        }
        
        System.out.println("Oh yeah!  Thanks, Random, I'd forgotten"
                + "that was my favorite.");
    }
}
