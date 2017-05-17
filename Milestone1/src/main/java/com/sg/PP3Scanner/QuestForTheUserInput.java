package com.sg.PP3Scanner;

import java.util.Scanner;

public class QuestForTheUserInput {
    
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double speedOfSound;
        boolean correct = false;
        int tries = 0;
        
        System.out.print("Comment vous appelez-vous? ");
        yourName = inputReader.nextLine();
        
        System.out.print("Qu'est-ce que vous cherchez? ");
        yourQuest = inputReader.nextLine();
        
        System.out.print("A quelle vitesse propagatent les ondes sonores en air? ");
        speedOfSound = Double.parseDouble(inputReader.nextLine());
        //speedOfSound = inputReader.nextDouble();
        
        System.out.println("\nVous vous appelez " + yourName + ", ");
        System.out.println("vous cherchez " + yourQuest +", ");
        System.out.println("et vous croyez que le son bouge a " + speedOfSound + " m/s.");
        
        while (correct == false){
            if (Math.abs(speedOfSound - 340) < .5 ) {
                correct = true;
                System.out.println("\nBien fait, " + yourName + ", vous avez raison.");
                System.out.println("La vitesse du son est 340 metres par seconde.");
                System.out.println("Je vous assisterai a trouver " + yourQuest + ".");
            }
            else {
                System.out.println("\nDesolee, vous avez tort.");
                if (tries > 2) {
                    System.out.println("La reponse correcte est moins que 341, "
                            + "et plus que 339.");
                }
                System.out.println("Essayez encore une fois: ");
                speedOfSound = Double.parseDouble(inputReader.nextLine());
                tries++;
            }
        }
    }
}
