package com.sg.M3UnitTests;

public class SameFirstLast {
    // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    public static boolean sameFirstLast(int[] numbers) {
        if (numbers[0] == numbers[numbers.length - 1]){
            return true;
        }
        return false;
    }
}
