package com.sg.PP7Fors;

public class SpringForwardFallBack {
    public static void main(String[] args) {
        System.out.println("It's spring");
        
        // Start/stop range: [1,10)
        // To be the same range as the below
        //  (int i = 1; i<11; i++)
        for (int i = 0; i<10; i++){
            System.out.print(i+", ");
        }
        
        System.out.println("\nIt's fall");
        
        // Start/stop range: [10,0)
        for (int i=10;i>0;i--){
            System.out.print(i+", ");
        }
    }
}
