package com.sg.OneOffs;
import java.util.Scanner;
import java.util.Random;

public class LuckySevens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        
        int n = 0;
        int nmax = 0;
        int d;
        int dmax;
        int r;
        
        System.out.println("How many dollars are you starting with?");
        d = Integer.parseInt(sc.nextLine());
        dmax = d;
        
        while (d>0){
            r = ran.nextInt(6) + ran.nextInt(6) + 2;
            n++;
            
            if (r==7){
                d += 4;
                if (d>dmax){
                    dmax = d;
                    nmax = n;
                }
            } else{
                d--;
            }
        }
        
        System.out.println("You rolled "+n+" times before going bust.");
        System.out.println("Shoulda stopped at "+ nmax + " rolls, when you had $"+dmax+".");
    }
}
