package com.sg.PP8Arrays;

public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple",
            "Granny Smith Apple", "Cherry Tomato",
            "Gooseberry", "Beefsteak Tomato",
            "Braeburn Apple", "Blueberry",
            "Strawberry", "Navel Orange",
            "Pink Pearl Apple",  "Raspberry",
            "Blood Orange", "Sungold Tomato",
            "Fuji Apple", "Blackberry",
            "Banana", "Pineapple",
            "Florida Orange", "Kiku Apple",
            "Mango", "Satsuma Orange",
            "Watermelon", "Snozzberry"};
        
        int index=0;
        int apples=0;
        int oranges=0;
        
        // Originally I thought needed to loop twice:
        // once just to determine how many
        // fruits will end up in our salad,
        // and a second time to add them.
        
        // However, since the question states there
        // are no more than 12 fruits in the salad:
        String[] fruitSalad = new String[12];
        
        // Loop through a second time to add them to our salad.
        for(String item : fruit){
            if(item.toLowerCase().contains("berry")){
                fruitSalad[index] = item;
                index++;
            } else if(item.toLowerCase().contains("apple") && apples<3){
                fruitSalad[index] = item;
                index++;
                apples++;
            } else if (item.toLowerCase().contains("orange") && oranges<2) {
                fruitSalad[index] = item;
                index++;
                oranges++;
            }
        }
        
        // Print salad.
        System.out.println("My salad contains "+ fruitSalad.length +" items:");
        for(int i=0; i<index; i++){
            if ((i+1)%3==0){System.out.print("\n");}
            if (i==fruitSalad.length-1){
                System.out.println("and "+ fruitSalad[i]);
            } else {System.out.print(fruitSalad[i]+", ");}
        }
    }
}
