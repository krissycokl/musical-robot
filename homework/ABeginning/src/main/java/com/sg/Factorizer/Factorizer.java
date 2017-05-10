package com.sg.Factorizer;
import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;
        int sum = 0;
        int count = 0;
        System.out.println("Please enter a positive integer:");
        
        n = Integer.parseInt(sc.nextLine());
        
        if (n<0) {
            System.out.println("This is not a positive integer.");
        } else {
            System.out.println("\nYour number is "+n);
            System.out.println("\nFactors:");
            if (n==1) {
                sum++;
                count++;
                System.out.print("1");
            }
            else{
                for (i=1;i<n;i++){
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
}
