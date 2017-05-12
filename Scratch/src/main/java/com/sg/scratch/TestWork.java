package com.sg.scratch;

public class TestWork {
    public static void main(String[] args) {
        /*byte myByte = 127;
        System.out.println(myByte);
        myByte++;
        System.out.println(myByte);*/
        
        /*int anA = giveMeAnA();
        System.out.println(anA);*/
        
        
        // boolean:  1 bit
        // byte:     8 bit signed
        // short:   16 bit signed
        // char:    16 bit unsigned
        // int:     32 bit signed
        // long:    64 bit signed
        // float:   64 bit "single precision"
        // double:  64 bit "double precision"
        
        // char[] allChars = new char[65536];
        byte[] allBytes = new byte[256];
        
        for (byte i=-128;i<127;i++){
            allBytes[i+128] = i;
        }
        
        for (byte chara : allBytes){
            System.out.print(chara+" ");
            if((chara-1)%8==0){System.out.println();}
        }
    }
    /*
    public static char giveMeAnA(){
        return 'a';
    }*/
}
