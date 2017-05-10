package com.sg.PP4IfElse;
import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        
        System.out.println("What's your last name?");
        
        // Convert input to lowercase, since that's
        // part of the string compare (lower case
        // names are "after" uppercase names)
        name = sc.nextLine().toLowerCase();
        
        System.out.print("Team: ");
        if(name.compareTo("baggins")<0){
            System.out.println("'Red Dragons'");
        } else if (name.compareTo("dresden")<0 && name.compareTo("baggins")>0) {
            System.out.println("'Dark Wizards'");
        } else if (name.compareTo("howl")<0 && name.compareTo("dresden")>0) {
            System.out.println("Moving Castles'");
        } else if (name.compareTo("potter")<0 && name.compareTo("howl")>0) {
            System.out.println("Golden Snitches get Golden Stitches");
        } else if (name.compareTo("vimes")<0 && name.compareTo("potter")>0) {
            System.out.println("'Night Guards'");
        } else {
            System.out.println("'Black Holes'");
        }
        
        System.out.println("\nDo your best!");
    }
}
