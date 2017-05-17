package com.sg.PP5Random;
import java.util.Random;
public class CoinFlipper {
    public static void main(String[] args) {
        Random coinFlip = new Random();
        System.out.println("Flipping your coin...");
        Boolean heads = coinFlip.nextBoolean();
        if(heads){System.out.println("You got heads.");}
        else{System.out.println("You got tails.");}
    }
}
