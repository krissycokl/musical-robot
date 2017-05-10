package com.sg.PP4IfElse;
import java.util.Scanner;

public class PickyEater {
    public static void main(String[] args) {
        int timesFried;
        String covered;
        boolean broccoli;
        boolean nameFunny;
        boolean spinach;
        int patsButter;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many times fried?");
        timesFried = Integer.parseInt(sc.nextLine());
        System.out.println("\nDoes the food have a funny name? true/false");
        nameFunny = Boolean.getBoolean(sc.nextLine());
        System.out.println("\nDoes the food contain broccoli? true/false");
        broccoli = Boolean.getBoolean(sc.nextLine());
        System.out.println("\nDoes the food contain spinach? true/false");
        spinach = Boolean.getBoolean(sc.nextLine());
        System.out.println("\nHow many pats of butter on the food?");
        patsButter = Integer.parseInt(sc.nextLine());
        System.out.println("\nWhat is the food covered in?");
        covered = sc.nextLine().toLowerCase();
        
        if (nameFunny || spinach){
            System.out.println("\nWon't be eaten.");
        } else if (timesFried > 2 && timesFried < 4 && covered.equals("chocolate")) {
            System.out.println("\nLike deep-fried Snickers? OK!");
        } else if (timesFried == 2 && covered.equals("cheese")) {
            System.out.println("\nCheese + fried = yes please.");
        } else if (broccoli && patsButter > 6 && covered.equals("cheese")){
            System.out.println("\nHide that broccoli...okay, eaten.");
        } else if (broccoli){
            System.out.println("\nVeggies belong in the trash.");
        } else {
            System.out.println("\nSafe to say I won't eat that either.");
        }
    }
}
