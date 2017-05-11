package com.sg.PP8Arrays;

public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        int numOrange = 0;
        int numApple = 0;
        int ctrOrange = 0;
        int ctrApple = 0;
        
        for (String item : fruit){
            if (item.equals("Orange")){
                numOrange++;
            } else{
                numApple++;
            }
        }
        
        String[] oranges = new String[numOrange];
        String[] apples = new String[numApple];
        
        for (String item : fruit){
            if (item.equals("Orange")){
                oranges[ctrOrange] = item;
                ctrOrange++;
            } else{
                apples[ctrApple] = item;
                ctrApple++;
            }
        }
        
        System.out.println("Overall, there were "+(ctrOrange+ctrApple)+" fruit.");
        System.out.println("You had "+oranges.length+" oranges and "+apples.length+" apples.");
    }
}
