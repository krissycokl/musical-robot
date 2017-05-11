package com.sg.PP5Random;
import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args) {
        Random roller = new Random();
        Scanner sc = new Scanner(System.in);
        
        int roll;
        Boolean again = true;
        int sides;
        
        System.out.println("Let's roll some dice.");
        
        while(again == true){
            System.out.println("How many sides is your die?");
            sides = Integer.parseInt(sc.nextLine());
            roll = roller.nextInt(sides)+1;
            System.out.println("Your roll was "+roll);
            if(roll == 1){System.out.println("Out, crit miss.");}
            if(roll == sides){System.out.println("Not bad, crit hit!");}
            System.out.println("Press enter to roll another die, or type 'end' to stop.");
            if(sc.nextLine().toLowerCase().equals("end")){
                again = false;
            };
        }
    }
}