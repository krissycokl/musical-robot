package com.sg.D8UserIO;

public class SimpleCalcRefactor {
    public static void main(String[] args) {
        ImplementsUserIO UIO = new ImplementsUserIO();
        
        boolean play = true;
        String operator;
        double operand1;
        double operand2;
        
        while(play){
            if(UIO.getString("Do you want to do math? (y/n)").equalsIgnoreCase("y")){
                operator = UIO.getString("+, -, *, or / ?");
                if(!validOperator(operator)){continue;}
                operand1 = UIO.getDouble("What is your first number?");
                operand2 = UIO.getDouble("What is your second number?");
                UIO.printString("Answer is "+parse(operator, operand1, operand2));
            } else {play = false;}
        }
    }
    
    public static double parse(String operator, double operand1, double operand2){
        if(operator.equals("+")){
            return operand1+operand2;
        } else if(operator.equals("-")){
            return operand1-operand2;
        } else if(operator.equals("*")){
            return operand1*operand2;
        } else if(operator.equals("/")){
            return operand1/operand2;
        } else {return 0;}
    }
    
    public static boolean validOperator(String operator){
        if(    !operator.equals("+")
            && !operator.equals("-")
            && !operator.equals("*")
            && !operator.equals("/")){
            return false;
        } else {return true;}
    }
}
