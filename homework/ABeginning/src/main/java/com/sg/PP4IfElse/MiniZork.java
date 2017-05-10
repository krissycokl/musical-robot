package com.sg.PP4IfElse;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MiniZork {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you live. Possibly a wise choice.");
                }
                
            } else if (action.equals("stick your hand in")) {
                System.out.println("You feel around, and your finger brushes against something metallic.");
                System.out.println("Withdraw your hand, or grasp the object?");
                action = userInput.nextLine();
                
                if (action.equals("withdraw hand")){
                    System.out.println("You jerk your hand back rapidly.");
                    System.out.println("Your fragile human skin catches on a loose bit of metal.");
                    System.out.println("You die.");
                    
                } else if (action.equals("grasp the object")){
                    System.out.println("You wrap your fingers around the metallic object.");
                    System.out.println("It's a gold coin! You're rich!");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MiniZork.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("CONGRATULATIONS");
                    System.out.println("YOU MANAGED TO KILL THAT BOSS, YOU SEE");
                    System.out.println("THE GRINNING COLOSSUS");
                    System.out.println("YOU'RE THE HERO WE ALL WISH WE COULD BE");
                    System.out.println("YOU MADE IT THROUGH THE TUNNEL");
                    System.out.println("THEN YOU GRABBED THAT FIRE ON THE WALL");
                    System.out.println("YOU JUMPED UP ABOVE HIM");
                    System.out.println("THEN YOU BURNED THE ROPE AND SAVED US ALL");
                }
            }
                
        } else if (action.equals("go to the house")) {
            System.out.println("Despite the sun outside the foyer windows, the hallway is dark as pitch.");
            System.out.println("As you turn to close the door behind you, it slams shut.");
            System.out.println("The deadbolt catches.");
            System.out.println("Attempt to open the door, or move on?");
            action = userInput.nextLine();
            if (action.equals("open door")){
                System.out.println("The handle is oddly hot.");
                System.out.println("It jiggles, but does not turn.");
                System.out.println("You hear breathing from the other side of the door.");
                System.out.println("Better move on.");
            }
        }
        else if (action.equals("move on")) {
            System.out.println("The hallway stretches onward, longer than you thought possible.");
            System.out.println("");
        }
    }
}