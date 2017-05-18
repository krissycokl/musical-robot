package com.sg.D9StudentQuizScores;

import java.util.ArrayList;

public class Student {
    private final String name;
    private ArrayList<Integer> scores;
    
    public Student(String name){
        this.name = name;
        this.scores = new ArrayList<>();
    }
    
    public void addScore(Integer score){
        scores.add(score);
    }
    
    public ArrayList<Integer> getScores(){
        return scores;
    }
    
    public String getName(){
        return this.name;
    }
}
