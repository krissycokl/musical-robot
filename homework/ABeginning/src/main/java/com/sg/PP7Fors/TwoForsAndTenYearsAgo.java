package com.sg.PP7Fors;
import java.util.Scanner;

public class TwoForsAndTenYearsAgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What year do you wanna count back from");
        int year = sc.nextInt();
        
        // Start: 0
        //   End: 10
        
        // Count back 20 years:
        // (int i=0; i<=20; i++)
        for(int i=0; i<=10; i++){
            System.out.println(i+" years ago was "+ (year-i));
        }
        
        System.out.println("I can count backwards in another way as well.");
        
        // Start: Year entered
        // End:   10 years before the year entered
        
        // Count back 20 years:
        // (int i=year; i>= year-20; i--)
        for(int i=year; i>= year-10; i--){
            System.out.println((year-i)+" years ago was "+ i);
        }
        
        // The first loop is clearer to me because it is much less convoluted.
        // by doing the math operation within the for loop instead
        // of within the arguments of the for, it is much clearer.
    }
}
