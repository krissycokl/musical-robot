package com.sg.PP4IfElse;
import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        
        System.out.println("Please input the month of your birth: ");
        input = Integer.parseInt(sc.nextLine());
        
        if (input ==1) {
            System.out.println("January's birthstone is Garnet");
        }
        else if (input==2) {
            System.out.println("February's birthstone is Amethyst");
        }
        else if (input==3) {
            System.out.println("March's birthstone is Aquamarine");
        }
        else if (input ==4) {
            System.out.println("April's birthstone is Diamond");
        }
        else if (input ==5){
            System.out.println("May's birthstone is Emerald");
        }
        else if (input ==6) {
            System.out.println("June's birthstone is Pearl");
        }
        else if (input ==7) {
            System.out.println("July's birthstone is Ruby");
        }
        else if (input ==8) {
            System.out.println("August's birthstone is Peridot");
        }
        else if (input ==9) {
            System.out.println("September's birthstone is Saphhire");
        }
        else if (input ==10) {
            System.out.println("October's birthstone is Opal");
        }
        else if (input ==11) {
            System.out.println("November's birthstone is Topaz");
        }
        else if (input ==12) {
            System.out.println("December's birthstone is Turquoise");
        }
        else {
            System.out.println("But " + input + " doesn't match a month.");
        }
    }
}
