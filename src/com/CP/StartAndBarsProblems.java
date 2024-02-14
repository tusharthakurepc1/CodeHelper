package com.CP;

import com.BasicLibTCT;

public class StartAndBarsProblems {
    public static void main(String[] args) {

        System.out.println(optimalSolutionHavingCombinations(3, 2));
    }

/*
 *  Combinatorial Problem(Stars and Bars)
 * Problem Statement: You are having the N number of Starts and you have to fill those start with
 * M numbers of buckets or bars, There is a possibility of having zero stars in the single bucket.
 *
 * The Brute Force solution is to count all the combinations using Recurrence or Power-set(BitManipulation)
 * The Optimal Solution
 *         Ex N = 5 and M = 4
 *  Total Ways are      SS | S | S | S          having n = 8, m = 3 in all the combinations
 *                      S | SS | S | S          n = N + (M-1), m = M-1
 *                      S | S | SS | S
 *                      S | S | S | SS
 *
 *      This can be calculated via combination nCr , where no or M would be the M-1 are you see above
 * and there is total no of N are N + M-1
 */

    public static long optimalSolutionHavingCombinations(int n, int r){
        return BasicLibTCT.combinations(n + (r - 1), r-1);
    }

}
