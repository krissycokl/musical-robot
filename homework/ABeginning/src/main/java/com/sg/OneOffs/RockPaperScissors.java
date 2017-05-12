package com.sg.OneOffs;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        int rounds;
        int curRound;
        int ansUser;
        int ansComp;
        String again;

        int numWins = 0;
        int numLosses = 0;
        int numTies = 0;

        System.out.println("How many rounds do you want to play?");
        rounds = Integer.parseInt(sc.nextLine());

        // Check if the user entered valid # of rounds
        if (rounds >= 1 && rounds <= 10) {

            // While user hasn't played all rounds
            for (curRound = 0; curRound < rounds; curRound++) {
                System.out.println("\nPlease choose between");
                System.out.println("1.) Rock");
                System.out.println("2.) Paper, or");
                System.out.println("3.) Scissors");

                ansUser = Integer.parseInt(sc.nextLine());
                System.out.println("You picked " + printHand(ansUser) + ".");
                ansComp = ran.nextInt(3) + 1;

                if (ansUser == ansComp) {
                    System.out.println("Computer also picked " + printHand(ansComp) + ".");
                    numTies++;
                    System.out.println("\nIt's a tie!");
                    System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                            + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                            + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
                } else {
                    System.out.println("Computer picked " + printHand(ansComp) + ".");
                    if (ansUser == 1 && ansComp == 2) {
                        // User: rock, Comp: paper
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 1 && ansComp == 3) {
                        // User: rock, Comp: scissors
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 2 && ansComp == 1) {
                        // User: paper, Comp: rock
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 2 && ansComp == 3) {
                        // User: paper, Comp: scissors
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 3 && ansComp == 1) {
                        // User: scissors, Comp: rock
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 3 && ansComp == 2) {
                        // User: scissors, Comp: paper
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else {
                        // Unexpected
                        System.out.println("Error!");
                    }
                }

                if (curRound == rounds - 1) {
                    System.out.println("\nG A M E   O V E R");
                    System.out.println("Play again? (y/n)");

                    again = sc.nextLine().toLowerCase();

                    if (again.equals("y")) {
                        curRound = -1;
                        numWins = 0;
                        numTies = 0;
                        numLosses = 0;

                        System.out.println("\nHow many rounds do you want to play?");
                        rounds = Integer.parseInt(sc.nextLine());

                        if (rounds < 1 || rounds > 10) {
                            System.out.println("Error: number of rounds should "
                                    + "be between 1 and 10.");
                        }

                    } else {
                        System.out.println("\nThanks for playing!");
                        if (numWins < numLosses) {
                            System.out.println("Sucker...");
                        }
                    }
                }
            }

        } else {
            System.out.println("Error: number of rounds should be between"
                    + " 1 and 10.");
        }
    }

    public static int winHandler(int numWins, int numLosses, int numTies) {
        System.out.println("\nYou win!");
        numWins++;
        System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
        return numWins;
    }

    public static int lossHandler(int numWins, int numLosses, int numTies) {
        System.out.println("\nYou lose!");
        numLosses++;
        System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
        return numLosses;
    }

    public static String printHand(int hand) {
        switch (hand) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
        }
        return "an invalid value";
    }

    public static String pluralHandler(int number) {
        if (number == 1) {
            return "";
        } else {
            return "s";
        }
    }
}