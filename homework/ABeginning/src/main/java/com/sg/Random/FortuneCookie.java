package com.sg.Random;
import java.util.Random;
public class FortuneCookie {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        int gen = randomizer.nextInt(10);
        
        switch(gen){
            case 0: System.out.println("Those aren't the droids you're looking for");
                    break;
            case 1: System.out.println("Never go against a Sicilian when death is on the line");
                    break;
            case 2: System.out.println("Goonies never say die");
                    break;
            case 3: System.out.println("With great power comes great responsibility");
                    break;
            case 4: System.out.println("Never argue with the data");
                    break;
            case 5: System.out.println("Do, or do not.  There is no try");
                    break;
            case 6: System.out.println("You're a leaf in the wind");
                    break;
            case 7: System.out.println("Do absolutely nothing, and it will be everything"
                    + "that you thought it could be");
                    break;
            case 8: System.out.println("Kneel before Zod");
                    break;
            case 9: System.out.println("Make it so");
        }
    }
}
