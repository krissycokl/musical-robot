package com.sg.PP7Fors;
import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int start, end, inc;
        
        System.out.print("Start at: ");
        start = Integer.parseInt(sc.nextLine());
        System.out.print(" Stop at: ");
        end   = Integer.parseInt(sc.nextLine());
        System.out.print("Count by: ");
        inc   = Integer.parseInt(sc.nextLine());
        
        System.out.println("\n");
        for (int i=start; i<=end; i+= inc){
            System.out.print(i+" ");
            if (((i-start)/inc+1)%3 == 0){
                System.out.print(" - ShooBeDo\n");
            }
        }
    }
}
