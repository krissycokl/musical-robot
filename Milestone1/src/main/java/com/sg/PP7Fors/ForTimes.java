package com.sg.PP7Fors;
import java.util.Scanner;
public class ForTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operand;
        
        System.out.println("Let's do multiplication for this number: ");
        operand = Integer.parseInt(sc.nextLine());
        
        for (int i=1; i<16; i++){
            System.out.println(i+" * "+operand+" is: "+(i*operand));
        }
    }
}
