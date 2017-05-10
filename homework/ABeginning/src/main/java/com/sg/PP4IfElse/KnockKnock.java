package com.sg.PP4IfElse;
import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Knock, knock. Guess who.");
        String nameGuess = sc.nextLine();
        
        
        
        // if(nameGuess == "Tarzan"){
        // Comparing strings via "==" doesn't seem to work
        // perhaps because it's comparing a literal "Tarzan"
        // to the nameGuess reference?
        
        // To handle case matching, convert input to
        // all lowercase.
        if(nameGuess.toLowerCase().equals("tarzan")){
            System.out.println("Watch out for that tree!");
        } else{
            System.out.println("Hardly.  I'm wearing a shirt, aren't I?");
        }
    }
}
