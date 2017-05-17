package com.sg.OneOffs;

public class SimpleCalcApp {
    public static void main(String[] args) {
        String operation;
        double operand1;
        double operand2;
        
        while (true){
            operation = SimpleCalc.getOperation();

            if (operation.equalsIgnoreCase("exit")){
                System.exit(0);
            }

            operand1 = SimpleCalc.getOperand("first");
            operand2 = SimpleCalc.getOperand("second");

            System.out.println("\nAnswer is:");
            System.out.println(SimpleCalc.parse(operation, operand1, operand2)+"\n");
        }
    }
}
