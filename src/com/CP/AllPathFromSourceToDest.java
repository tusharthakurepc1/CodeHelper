package com.CP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllPathFromSourceToDest {
    public static void main(String[] args) {
        int list[][] = {
                {1, 2},
                {3},
                {3},
                {}
        };

        String a = "abc";


        allPathRecursive(list, new boolean[list.length], 0, new ArrayList<>());
    }

    public static void allPathRecursive(int list[][], boolean flags[], int curr, List<Integer> path_){
        if(curr == list.length-1){
            System.out.println(path_);
            return;
        }
        if(flags[curr]){
            return;
        }

        flags[curr] = true;
        path_.add(curr);
        System.out.println(curr);

//        traverse for all the child of the curr node
        for(int child : list[curr]){

            if(!flags[child]){
                allPathRecursive(list, flags, child, path_);
            }

        }
    }

//    All path from 0 to n-1 node
    public static void allPath(int list[][], int n){
        boolean flag[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        flag[0] = true;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            System.out.println(temp);

            for(int child : list[temp]){

                if(!flag[child]){
                    stack.push(child);
                    flag[child] = true;
                }

            }


        }

    }


}
