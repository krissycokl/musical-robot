package com.sg.m4unittests;

public class RotateLeft {
    // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    public static int[] rotateLeft(int[] numbers) {
        int len = numbers.length;
        int[] tempAry = new int[len];
        for (int i=1; i<len; i++){
            tempAry[i-1] = numbers[i];
        }
        tempAry[len-1] = numbers[0];
        return tempAry;
    }
}
