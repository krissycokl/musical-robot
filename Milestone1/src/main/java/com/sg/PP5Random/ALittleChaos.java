package com.sg.PP5Random;
import java.util.Random;

public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: "+randomizer.nextInt());
        System.out.println("Or a double: "+randomizer.nextDouble());
        System.out.println("Or a boolean: "+randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        // If changed to randomizer.nextInt(50)+50, you're
        // guaranteed a minimum value of 49.
        
        System.out.println("You can store a random result: "+num);
        System.out.println("And use it over and over again: "+num+", "+num);
        
        System.out.println("Or just keep generating new values.");
        System.out.println("Here're some examples: ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101));
    }
}
