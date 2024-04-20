package com.DynamicProgramming;

public class MaxHeightByStackingCuboid {
    public static void main(String[] args) {
        int dimensions[][] = {
            {50,45,20},
            {95,37,53},
            {45,23,12}
        };

        boolean flags[] = new boolean[dimensions.length];
        recursiveSolution(dimensions, dimensions.length-1, flags);

    }

    public static void recursiveSolution(int dimensions[][], int ind, boolean flags[]){



    }

}
