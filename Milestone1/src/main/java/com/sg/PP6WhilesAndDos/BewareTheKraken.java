package com.sg.PP6WhilesAndDos;

public class BewareTheKraken {
    public static void main(String[] args) {
        System.out.println("Let's dive.");
        
        int depthDived = 0;
        
        // Only go to the bottom of the ocean.
        while (depthDived < 36200){
            System.out.println("So far, we've gone " + depthDived + " feet.");
            
            if (depthDived >= 20000){
                System.out.println("Is that a Kraken?");
                System.out.println("I'm out.");
                break;
            }
            
            depthDived += 1000;
        }
        
        System.out.println("\nWe swam "+depthDived+" feet.");
    }
}
