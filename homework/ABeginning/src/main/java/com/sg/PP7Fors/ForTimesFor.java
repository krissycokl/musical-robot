package com.sg.PP7Fors;
import java.util.Scanner;
public class ForTimesFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operand;
        int correct = 0;
        int guess;
        int times = 15;
        
        System.out.println("Let's do multiplication for this number: ");
        operand = Integer.parseInt(sc.nextLine());
        
        for (int i=1; i<=times; i++){
            System.out.println(i+" * "+operand+" is: ");
            guess = Integer.parseInt(sc.nextLine());
            if (guess == i*operand){
                System.out.println("Correct! "+i+" * "+operand+" is "+guess);
                correct++;
            } else {
                System.out.println("No. "+i+" * "+operand+" is "+i*operand);
            }
        }
        
        System.out.println("\nYou got "+correct+" correct out of "+times);
        if ((float) correct/times < .5){
            System.out.println("You should study more.");
        } else if((float) correct/times > .9){
            System.out.println("Very good job!");
        }
    }
}
