package com.sg.PP7Fors;

public class DifferentKettleOfFish {
    public static void main(String[] args) {
        int fish = 1;
        /*while(fish<10){
            if(fish==3){
                System.out.println("red fish");
            }else if (fish==4) {
                System.out.println("blue fish");
            } else{
                System.out.println(fish + " fish");
            }
            
            fish++;
        }*/
        
        // written as a for loop:
        for (fish=1;fish<10;fish++){
            if(fish==3){
                System.out.println("red fish");
            }else if (fish==4) {
                System.out.println("blue fish");
            } else{
                System.out.println(fish + " fish");
            }
        }
    }
}
