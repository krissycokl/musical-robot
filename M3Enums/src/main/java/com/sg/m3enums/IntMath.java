package com.sg.m3enums;
public class IntMath {

    public static enum MathOperator{
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
    
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        double operand1 = io.getDouble("Please enter the first number:");
        double operand2 = io.getDouble("And the second number:");
        
        for (MathOperator operator : MathOperator.values()){
            System.out.println(operator + ": "+calculate(operator, operand1, operand2));
        }
    }
    
    public static double calculate(MathOperator operator, double operand1, double operand2){
        switch(operator){
            case ADD:
                return operand1+operand2;
            case SUBTRACT:
                return operand1-operand2;
            case MULTIPLY:
                return operand1*operand2;
            case DIVIDE:
                return operand1/operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
