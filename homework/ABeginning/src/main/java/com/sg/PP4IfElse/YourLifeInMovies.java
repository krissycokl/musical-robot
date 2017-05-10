package com.sg.PP4IfElse;
import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        
        System.out.println("When were you born?");
        year = Integer.parseInt(sc.nextLine());
        
        if (year<2005){
            System.out.println("'Up' came out 5 yrs ago");
        }
        if (year<1995) {
            System.out.println("First Harry Potter movie came out 15 yrs ago");
        }
        if (year<1985) {
            System.out.println("Space Jam came out 2 decades ago");
        }
        if (year<1975) {
            System.out.println("Jurassic Park came out nearer the moon landing than today");
        }
        if (year<1965) {
            System.out.println("M*A*S*H has been out for 50 years");
        }
        System.out.println("You should feel old.");
    }
}
