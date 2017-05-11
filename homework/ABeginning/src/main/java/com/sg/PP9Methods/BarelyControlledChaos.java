package com.sg.PP9Methods;
import java.util.Random;

public class BarelyControlledChaos {
    
    public static void main(String[] args) {
        String color = randomColor();
        String animal = randomAnimal();
        String colorAgain = randomColor();
        int weight = randomInt(5,200);
        int distance = randomInt(10,20);
        int number = randomInt(1,5);
        int time = randomInt(2,6);
        
        System.out.println("This one time, at band camp");
        System.out.println("I encountered a "+color+", "
                + weight + "lb miniature " +animal+ " with over "
                +distance + " legs.");
        
        System.out.println("I squeezed inside my "+colorAgain+" tuba "
                + "and waited for "+time+" hours.");
        System.out.println("Later, I lost "+number+" fingers from lack of "
                + "circulation due to the tight fit.");
    }
    
    public static String randomColor(){
        Random ran = new Random();
        int random = ran.nextInt(5);
        switch (random){
            case 0: return "blue";
            case 1: return "red";
            case 2: return "periwinkle";
            case 3: return "pastel pink";
            case 4: return "opaline";
        }
        return "error";
    }
    
    public static String randomAnimal(){
        Random ran = new Random();
        int random = ran.nextInt(5);
        switch (random){
            case 0: return "cougar";
            case 1: return "Marowak";
            case 2: return "dwarf hamster";
            case 3: return "cat";
            case 4: return "tarantula";
        }
        return "error";
    }
    
    public static int randomInt(int min, int max){
        Random ran = new Random();
        int random = ran.nextInt(max+1)+min;
        return random;
    }
}
