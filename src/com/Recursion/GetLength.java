package com.Recursion;

public class GetLength {
    public static void main(String[] args) {
        String str = "hello World";
        int arr[] = {1, 4, 3, 2, 4, 9};


//        System.out.println(getLength(str, str.length()-1));
        System.out.println(getLengthArray(arr, arr.length-1));
    }
    public static int getLength(String str, int ind){
        if(ind == 0){
            return 1;
        }

        return 1 + getLength(str, ind - 1);
    }

    public static int getLengthArray(int arr[], int ind){
        if(ind == 0){
            return 1;
        }

        return 1 + getLengthArray(arr, ind - 1);
    }
}
