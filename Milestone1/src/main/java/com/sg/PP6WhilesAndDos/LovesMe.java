package com.sg.PP6WhilesAndDos;

public class LovesMe {
    public static void main(String[] args) {
        int petals = 34;
        
        System.out.println("Pick the petals...");
        
        while (petals>0){
            if(petals%2==0){System.out.println("It loves me NOT.");}
            else{System.out.println("It loves me.");}
            petals--;
        }
        
        System.out.println("There's the verdict.");
    }
}
