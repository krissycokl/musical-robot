package com.sg.PP6WhilesAndDos;
import java.util.Scanner;
public class StayPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What number should I count from?");
        int num = Integer.parseInt(sc.nextLine());
        int lineCount = 0;
        
        while(num>=0){
            if(lineCount>=10){
                System.out.println();
                lineCount=0;
            }
            System.out.print(num+" ");
            num--;
            lineCount++;
        }
    }
}
