package com.sg.PP7Fors;
import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many fizzes and/or buzzes?");
        int n = Integer.parseInt(sc.nextLine());
        int fbs = 0;
        
        for (int i=0;i<=15*n;i++){
            if (i==0){
                System.out.println(i);
            } else if (i%15 == 0){
                System.out.println("fizz buzz");
                fbs += 2;
            } else if (i%3 == 0){
                System.out.println("fizz");
                fbs++;
            } else if (i%5 == 0){
                System.out.println("buzz");
                fbs++;
            } else {
                System.out.println(i);
            }
            if (fbs>=n){
                break;
            }
        }
        
        System.out.println("All done :)");
    }
}
