package com.sg.scratch;

public class TestWork {
    public static void main(String[] args) {
        String justASpace = " ";
        String justANewLine = "\n";
        String spaceAndNewLine = " \n";
        String nothing = "";
        
        System.out.println("Just a space: \n"+
                "Is empty?: "+justASpace.isEmpty()+
                "Is null? : "+(justASpace==null)+
                "Length?  : "+justASpace.length());
        
        System.out.println("Just a new line: \n"+
                "Is empty?: "+justANewLine.isEmpty()+
                "Is null? : "+(justANewLine==null)+
                "Length?  : "+justANewLine.length());
        
        System.out.println("Space and new line: \n"+
                "Is empty?: "+spaceAndNewLine.isEmpty()+
                "Is null? : "+(spaceAndNewLine==null)+
                "Length?  : "+spaceAndNewLine.length());
        
        System.out.println("Nothing: \n"+
                "Is empty?: "+nothing.isEmpty()+
                "Is null? : "+(nothing==null)+
                "Length?  : "+nothing.length());
    }
}
