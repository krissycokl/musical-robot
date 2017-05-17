package com.sg.PP4IfElse;

public class SpaceRustlers {
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        // Else if executes if the if block preceding it does not,
        // and if the boolean in the else if statement is true.
        // If executes if the boolean in the if statement is true.
        
        if(aliens>spaceships){
            System.out.println("Vroom.  Let's move");
        } else{
            System.out.println("Need more green men.");
        }
        
        if(cows==spaceships){
            System.out.println("Nice job.  Perfect # of cows.");
        } else if(cows > spaceships) {
            System.out.println("We'll need to...condense some of these cows to fit.");
        } else {
            System.out.println("Too many ships.  This is not efficient.");
        }
        
        // If I remove the 'else' from the above 'else if', then
        // I'd get an error, because there would be two else conditions
        // for a single if.
        
        if (aliens >= cows) {
            System.out.println("Woohoo, we got the food.  Hamburger party.");
        }
        else {
            System.out.println("Yikes, the cows are taking over..!");
        }
    }
}
