package com.sg.OneOffs;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double r, p, p0;
        int n;
        
        System.out.println("What's your interest rate?");
        r = Double.parseDouble(sc.nextLine());
        if (r>1) {r = r/100;}
        
        System.out.println("What's your current balance?");
        p = Double.parseDouble(sc.nextLine());
        
        System.out.println("How many years are you investing?");
        n = Integer.parseInt(sc.nextLine());
        
        for (int i=1; i<=n; i++){
            System.out.println("\nYear: "+i);
            System.out.println("    Balance at start of year: $"+Math.round(p));
            p0 = p;
            p = p*Math.pow(1+r/4,4);
            System.out.println("    Interest accrued this year: $"+Math.round((p-p0)));
            System.out.println("    Balance at end of year: $"+ Math.round(p));
        }
    }
}
