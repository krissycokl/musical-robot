package com.sg.m4unittests;

public class Sum {
    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    public static int sum(int[] numbers) {
        int len = numbers.length;
        int sum = 0;
        for (int i=0; i<len; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
