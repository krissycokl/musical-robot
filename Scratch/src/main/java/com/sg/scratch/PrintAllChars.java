package com.sg.scratch;

public class PrintAllChars {
    public static void main(String[] args) {
        int i = 0;
        
        for (i=0;i<128;i++){
            char printChar = (char) i;
            System.out.print(printChar);
            if ((i+1)%8==0){System.out.println();}
        }
    }
}
