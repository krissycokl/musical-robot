package com.sg.M3UnitTests;
public class MakePI {
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public static int[] makePi(int n) {
        String pi = Double.toString(Math.PI);
        int[] digits = new int[n];
        digits[0] = 3;
        
        for (int i=1; i<n; i++){
            digits[i] = Integer.parseInt(pi.substring(i+1, i+2));
        }
        
        return digits;
    }
}
