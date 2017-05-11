package com.sg.PP6WhilesAndDos;

public class WaitAWhile {
    public static void main(String[] args) {
        int time = 5;
        int bedTime = 10;
        
        while(time<bedTime){
            System.out.println("It's only "+time+" o'clock");
            System.out.println("No sleep yet");
            time++;
        }
        
        System.out.println("Now it's " + time +" o'clock.");
        System.out.println("Guess I should sleep.");
    }
}
