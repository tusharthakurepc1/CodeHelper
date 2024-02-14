package com.DynamicProgramming;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int e = 2;  // eggs
        int f = 10; // floors


        System.out.println(recursiveSol(e, f));
    }

    public static int recursiveSol(int e, int f){
        if(e == 1)  return f;
        if(f == 0 || f == 1)    return f;


        int mini = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int not_break_egg = recursiveSol(e, f-k);
            int break_egg = recursiveSol(e-1, k-1);

            mini = Math.min(mini, Math.max(break_egg, not_break_egg));
        }


        return mini;
    }
}
