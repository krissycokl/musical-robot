package com.sg.RefactorIntoObjects;

import java.util.Random;

public class RPSLogic {
    
    Random ran = new Random();
    
    private int rounds;
    private int curRound;
    private int numTies = 0;
    String again;
    
    private RPSUser user1 = new RPSUser("You");
    private RPSUser user2 = new RPSUser("Computer");
    
    public boolean runRPS(){    
        rounds = RPSUI.getRounds();
        if (rounds >= 1 && rounds <= 10) {
            for (curRound = 0; curRound < rounds; curRound++) {
                user1.setHand(RPSUI.getHand());
                user2.setHand(ran.nextInt(3)+1);
                RPSUI.tellHand(user1.getHand(),user1.getName());
                RPSUI.tellHand(user2.getHand(),user2.getName());
                RPSUI.showHands(user1.getHand(),user2.getHand());

                if (user1.getHand() == user2.getHand()) {
                    numTies = RPSUI.tieHandler(user1.getWins(), user2.getWins(), numTies);
                } else {                    
                    if (user1.getHand() == 1 && user2.getHand() == 2) {
                        RPSUI.lossHandler(user1.getWins(), user2.getWins(), numTies);
                        user2.addWin();
                    } else if (user1.getHand() == 1 && user2.getHand() == 3) {
                        RPSUI.winHandler(user1.getWins(), user2.getWins(), numTies);
                        user1.addWin();
                    } else if (user1.getHand() == 2 && user2.getHand() == 1) {
                        RPSUI.winHandler(user1.getWins(), user2.getWins(), numTies);
                        user1.addWin();
                    } else if (user1.getHand() == 2 && user2.getHand() == 3) {
                        RPSUI.lossHandler(user1.getWins(), user2.getWins(), numTies);
                        user2.addWin();
                    } else if (user1.getHand() == 3 && user2.getHand() == 1) {
                        RPSUI.lossHandler(user1.getWins(), user2.getWins(), numTies);
                        user2.addWin();
                    } else if (user1.getHand() == 3 && user2.getHand() == 2) {
                        RPSUI.winHandler(user1.getWins(), user2.getWins(), numTies);
                        user1.addWin();
                    } else {
                        System.out.println("Error!");
                    }
                }

                if (curRound == rounds - 1) {
                    if (user1.getWins() > user2.getWins()) { RPSUI.overall(1); }
                    else if (user1.getWins() < user2.getWins()){ RPSUI.overall(2); }
                    else { RPSUI.overall(3); }
                    return RPSUI.again();
                }
            }

        } else {
            return RPSUI.fail();
        }
    return false;
    }
}
