package com.sg.Random;
import java.util.Random;
import java.util.Scanner;
public class DogGenetics {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What's your dog's name?");
        String dogName = sc.nextLine();
        
        System.out.println("I've received confidential information");
        System.out.println(" about the genetic makeup of your superdog:\n");
        
        int a, b, c, d, e;
        
        a = ran.nextInt(100)+1;
        b = ran.nextInt(100-a)+1;
        c = ran.nextInt(100-a-b)+1;
        d = ran.nextInt(100-a-b-c)+1;
        e = 100-a-b-c-d;
        
        System.out.println(a+"% Kryptonian");
        System.out.println(b+"% Martian");
        System.out.println(c+"% Botswanan");
        System.out.println(d+"% Saturnalian");
        System.out.println(e+"% Golden Retriever");
    }
}
