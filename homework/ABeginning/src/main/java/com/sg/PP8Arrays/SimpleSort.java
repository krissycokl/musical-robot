package com.sg.PP8Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        
        int[] together = new int[24];
        
        // Luckily, each array is already sorted, so we don't have to worry
        // about the order of items within their own array.
        // We can simply look at the first element of each.
        
        int index1 = 0;
        int index2 = 0;
        
        while (index1+index2 < 24){
            if (index1==12){
                together[index1+index2] = secondHalf[index2];
                index2++;
            } else if (index2==12){
                together[index1+index2] = firstHalf[index1];
                index1++;
            } else if (firstHalf[index1] < secondHalf[index2]){
                together[index1+index2] = firstHalf[index1];
                index1++;
            } else {
                together[index1+index2] = secondHalf[index2];
                index2++;
            }
        }
        
        for (int i : together){
            System.out.print(i+" ");
        }
    }
}
