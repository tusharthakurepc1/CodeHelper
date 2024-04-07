package company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem2_AMCAT_2024 {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;

/*
    Problem statement: you are given lamp array where 1 state on and 0 state off
    Condition 1: is the lamp left side and right side is equals then particular lamp is off otherwise on

    you have to return the lamp state after days given
*/

        solution(arr, days);

    }


    public static void solution(int arr[], int days){

        int prev[] = Arrays.copyOf(arr, arr.length);

        for(int day=0; day<days; day++){
            prev = Arrays.copyOf(arr, arr.length);

            for(int i=0; i<prev.length; i++){

                int left_lamp = 0;
                int right_lamp = 0;

                if(i > 0)   left_lamp = prev[i-1];
                if(i < prev.length-1)   right_lamp = prev[i+1];

                arr[i] = left_lamp ^ right_lamp;        //it both open or close then 0, otherwise 1

            }

        }

        System.out.println("Brute Force: "+Arrays.toString(arr));

    }


}
