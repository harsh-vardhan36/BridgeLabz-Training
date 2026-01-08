package com.linearandbinarysearch.linearsearch;

public class FirstNegativeSearch {

    public static int findFirstNegative(int[] arr) {

       
        for (int i = 0; i < arr.length; i++) {

            
            if (arr[i] < 0) {
                return i;   
            }
        }

        
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {4, 7, 3, -2, 8, -5};

        int result = findFirstNegative(arr);

        System.out.println(result);
    }
}
