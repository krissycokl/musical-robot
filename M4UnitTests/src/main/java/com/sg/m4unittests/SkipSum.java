package com.sg.m4unittests;

public class SkipSum {
    // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    public static int skipSum(int a, int b) {
        if (a+b >=10 && a+b <= 19){
            return 20;
        } else {
            return a+b;
        }
    }

}
