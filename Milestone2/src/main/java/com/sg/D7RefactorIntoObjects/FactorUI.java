package com.sg.D7RefactorIntoObjects;

import java.util.Scanner;

public class FactorUI {
    private static Scanner sc = new Scanner(System.in);
    private static int n;
    
    public static int getNum(){
        System.out.println("Please enter a positive integer:"); 
        n = Integer.parseInt(sc.nextLine());
        if (n<0) {
            System.out.println("This is not a positive integer.");
        } else {
            System.out.println("\nYour number is "+n);
        }
        return n;
    }
    
    public static void listFactors(int n){
        if(n<0){return;}
        int sum = 0;    
        int count = 0;
        if (n==1) {
                sum++;
                count++;
                System.out.print("1");
            }
            else{
                for (int i=1;i<n;i++){
                    if (n%i==0) {
                        sum+=i;
                        count++;
                        System.out.print(i+", ");
                    }
                }
            }
        System.out.println("\n\nNumber of factors: "+count+"\n");
        
        if (sum==n) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
        if (count==1){
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
