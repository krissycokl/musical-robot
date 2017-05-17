package com.sg.D7RefactorIntoObjects;

public class RPSUser {
    private int hand;
    private int wins;
    private final String NAME;
    
    RPSUser(String name){
        wins = 0;
        this.NAME = name;
    }
    
    public void addWin(){
        wins++;
    }
    
    public int getWins(){
        return wins;
    }
    
    public void setHand(int hand){
        this.hand = hand;
    }
    
    public int getHand(){
        return this.hand;
    }
    
    public String getName(){
        return this.NAME;
    }
}
