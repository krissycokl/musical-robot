package com.sg.PP4IfElse;

public class LlamasWhalesAndDodosOhMy {
    public static void main(String[] args) {
        int llamas = 20;
        int whales = 15;
        int dodos =0;
        
        if (dodos > 0){
            System.out.println("Egads, but dodos are extinct!");
        }
        
        if (dodos < 0) {
            System.out.println("Hold on, how are there fewer than zero?");
        }
        
        if (llamas > whales) {
            System.out.println("Whales may be bigger, but llamas r betr");
        }
        
        if (llamas <= whales) {
            System.out.println("Brains over brawn.  Whales beat llamas.");
        }
        
        System.out.println("We've isolated a strand of dodo DNA. Commencing cloning.");
        
        dodos += 100;
        
        if ((whales+llamas) < dodos) {
            System.out.println("AMAZING.  More dodos than others combined.");
        }
        
        if (llamas > whales && llamas > dodos) {
            System.out.println("more llamas than either dodos or whales");
        }
    }
    
}
