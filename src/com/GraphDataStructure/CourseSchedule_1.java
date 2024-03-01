package com.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule_1 {
    public static void main(String[] args) {
        int prerequisites[][] = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int numCourse = 4;

/*
*   In this given problem you are given prerequisites are given which states task 1 is take only when you finished task 0
*   and if it is possible then return true otherwise false
*
*   Ex: prerequisites are   [1, 0]  [0, 1]
*       in this problem task 1 is dependent on task 0 and task 0 is dependent on task 1 so there is no possible sequence
*   So Expected Answer: false
*/

        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<numCourse;i++)    adj_list.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            adj_list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        System.out.println(adj_list);


        System.out.println(isCourseSchedule(adj_list, numCourse));
        System.out.println(Arrays.toString(isCourseSchedule2(adj_list, numCourse)));
    }

    public static boolean isCourseSchedule(List<List<Integer>> adj_list, int numCourse){
        boolean visited[] = new boolean[numCourse];
        boolean path[] = new boolean[numCourse];
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourse;i++){
            if(!visited[i]){

//                Call for the disconnected component
                boolean temp = dfs(adj_list, i, visited, path, res);
                if(temp){
                    System.out.println("Cycle Present");
                    return false;
                }
            }
        }

        System.out.println("No Cycle");
        return true;
    }

    public static int[] isCourseSchedule2(List<List<Integer>> adj_list, int numCourse){
        boolean visited[] = new boolean[numCourse];
        boolean path[] = new boolean[numCourse];
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourse;i++){
            if(!visited[i]){

//                Call for the disconnected component
                boolean temp = dfs(adj_list, i, visited, path, res);
                if(temp){
                    System.out.println("Cycle Present");
                    return new int[]{};
                }
            }
        }

        System.out.println("No Cycle");
        int res_t[] = new int[res.size()];

        for(int i=0;i<numCourse;i++){
            res_t[i] = res.get(i);
        }
        return res_t;
    }

    public static boolean dfs(List<List<Integer>> adj_list, int curr, boolean visited[], boolean path[], List<Integer> res){

        visited[curr] = true;
        path[curr] = true;

        // Go for all the neighbours
        for(int el: adj_list.get(curr)){

            if(visited[el] && path[el]){
                return true;
            }
            if(!visited[el]){
                if(dfs(adj_list, el, visited, path, res)){
                    return true;
                }
            }

        }

        res.add(curr);
        path[curr] = false;
        return false;
    }



}
