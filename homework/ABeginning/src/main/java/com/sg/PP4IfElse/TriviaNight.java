package com.sg.PP4IfElse;
import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        int counter=0;
        int ans;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many fingers does a human have?");
        System.out.println("1.) one     2.) five");
        System.out.println("3.) eight   4.) ten");
        ans = Integer.parseInt(sc.nextLine());
       
        System.out.println("\nYOUR ANSWER: "+ans+"\n");
        if (ans==4) {counter++;}
        else if (ans==3) {
            System.out.println("Pedant. I don't care if you're not counting thumbs, because I am.\n"); 
        }
                
        System.out.println("I have a mouth, but do not breathe.");
        System.out.println("1.) human   2.) river");
        System.out.println("3.) laptop  4.) sky");
        ans = Integer.parseInt(sc.nextLine());
        
        System.out.println("\nYOUR ANSWER: "+ans+"\n");
        if (ans==2) {counter++;}
                
        System.out.println("What can change the nature of a man?");
        System.out.println("1.) love    2.) fate");
        System.out.println("3.) choice  4.) circumstance");
        ans = Integer.parseInt(sc.nextLine());
        
        System.out.println("\nYOUR ANSWER: "+ans+"\n");
        if (ans==3) {counter++;}
        
        System.out.println("Number correct: " + counter);
        switch (counter){
            case 0: System.out.println("Oh boy.  Were you even trying?");
                    break;
            case 1: System.out.println("Yikes...");
                    break;
            case 2: System.out.println("Two thirds.  Grade 'D'.");
                    break;
            case 3: System.out.println("100%.  The only acceptable option.");
                    break;
            default: System.out.println("What were you even doing?");
                    break;
        }
    }
}
