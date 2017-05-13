package com.sg.OneOffs;

public class SummativeSums {
    public static void main(String[] args) {
        int[] testAry1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] testAry2 = { 999, -60, -77, 14, 160, 301 };
        int[] testAry3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120,
            130, 140, 150, 160, 170, 180, 190, 200, -99 };
        
        System.out.println("Sum of array 1: "+sumAry(testAry1));
        System.out.println("Sum of array 2: "+sumAry(testAry2));
        System.out.println("Sum or array 3: "+sumAry(testAry3));
    }
    
    public static int sumAry(int[] nums){
        int sum = 0;
        for (int element : nums){
            sum+=element;
        }
        return sum;
    }
}
