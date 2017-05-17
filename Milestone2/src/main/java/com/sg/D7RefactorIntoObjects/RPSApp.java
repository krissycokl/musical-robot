package com.sg.D7RefactorIntoObjects;

public class RPSApp {

    public static void main(String[] args) {
        boolean play = true;
        while (play){
            RPSLogic newGame = new RPSLogic();
            play = newGame.runRPS();
        }
    }
}