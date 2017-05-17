package com.sg.D8UserIO;

public class D8TestUserIO {
    public static void main(String[] args) {
        
        ImplementsUserIO testIO = new ImplementsUserIO();
        
        System.out.println(testIO.getInt("please give int"));
        System.out.println(testIO.getInt("give int b/w 1 & 5",1,5));
        System.out.println(testIO.getString("gimme string"));
        System.out.println(testIO.getDouble("give double"));
        System.out.println(testIO.getDouble("give dbl b/w -5 & 50",-5,50));
    }
}
