package com.sg.OneOffs;

import java.util.Scanner;

public class SimpleCalc {
    public static Scanner sc = new Scanner(System.in);
    
    public static double add(double a, double b){
        return a+b;
    }
    
    public static double subtract(double a, double b){
        return a-b;
    }
    
    public static double multiply(double a, double b){
        return a*b;
    }
    
    public static double divide(double a, double b){
        return a/b;
    }
    
    public static double parse(String operation, double a, double b){
        
        if (operation.equals("+")){
            return add(a,b);
        } else if (operation.equals("-")){
            return subtract(a,b);
        } else if (operation.equals("*")){
            return multiply(a,b);
        } else if (operation.equals("/")){
            return divide(a,b);
        } else {
            return 0;
        }
    }
    
    public static String getOperation(){
        String operation;
        
        while (true){
            System.out.println("What operation do you want to perform?");
            System.out.println("+, -, *, /, or exit");

            operation = sc.nextLine();

            if(    operation.equals("+")
                || operation.equals("-")
                || operation.equals("*")
                || operation.equals("/")
                || operation.equalsIgnoreCase("exit")){
                return operation;
            }
            
            System.out.println("Please exit or enter a valid operation.\n");
        }
    }
    
    public static double getOperand(String order){
        String operandString;
        double operand;
        
        while (true){
            System.out.println("\nPlease provide the "+order+" operand:");
            operandString = sc.nextLine();

            try {
                operand = Double.parseDouble(operandString);
                return operand;
            } catch(NumberFormatException nfe) {
                System.out.println("\nOkay...how about a real number this time?");
            }
        }
    }
}
