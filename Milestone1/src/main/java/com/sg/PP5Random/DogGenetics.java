package com.sg.PP5Random;
import java.util.Random;
import java.util.Scanner;
public class DogGenetics {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What's your dog's name?");
        String dogName = sc.nextLine();
        
        System.out.println("\nI've received confidential information");
        System.out.println("about the genetic makeup of your superdog:\n");
        
        double a, b, c, d, e, sum;

        // My original randomization was highly biased toward the first
        // breeds, since it became successively unlikely for each
        // breed to approach 100%.
        
        // To weight each breed equally, generate 5 random numbers
        // independently of one another
        a = ran.nextDouble();
        b = ran.nextDouble();
        c = ran.nextDouble();
        d = ran.nextDouble();
        e = ran.nextDouble();
        
        // Then scale them down so the sum is 100:
        sum = a+b+c+d+e;
        a = a/sum*100;
        b = b/sum*100;
        c = c/sum*100;
        d = d/sum*100;
        e = e/sum*100;
        
        System.out.println(Math.round(a)+"% Kryptonian");
        System.out.println(Math.round(b)+"% Martian");
        System.out.println(Math.round(c)+"% Botswanan");
        System.out.println(Math.round(d)+"% Saturnalian");
        System.out.println(Math.round(e)+"% Golden Retriever\n");
        
        if(a+b+c+d < 50){
            System.out.println("Oh.  Turns out "+dogName + " is kind of a mutt.");
        } else{
            System.out.println("You can really tell "+dogName+" has "
                    + "extra-terrestrial origins!");
        }
    }
}