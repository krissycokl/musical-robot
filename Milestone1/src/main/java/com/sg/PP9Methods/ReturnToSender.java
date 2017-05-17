package com.sg.PP9Methods;

public class ReturnToSender {
    public static void main(String[] args) {
        // int aMystery = mystery();
        // With "int" aMystery, char 'e' becomes 101
        
        char aMystery = mystery();
        String totallyUnexpected = unexpected();
        double aSurprise = surprise();
        boolean itsClassified = classified();
        int aSecret = secret();
        
        System.out.println("The methods have returned.  Results:\n");
        System.out.println("Mysterious: " + aMystery);
        System.out.println("    Secret: " + aSecret);
        System.out.println("Surprising: " + aSurprise);
        System.out.println("Classified: " + itsClassified);
        System.out.println("Unexpected: " + totallyUnexpected);
    }
    
    public static int secret(){
        return 42;
    }
    
    public static double surprise(){
        return 3.14;
    }
    
    public static char mystery(){
        return 'e';
    }
    
    public static boolean classified(){
        return true;
    }
    
    public static String unexpected(){
        return "A kick in the head";
    }
}
