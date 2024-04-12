package com.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class WordBreak {
    public static void main(String[] args) {
        String str = "catsandog";
        String key[] = {"cats","dog","sand","and","cat"};

        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0; i< key.length; i++)    map.put(key[i], true);

        int dp_arr[] = new int[str.length()+1];
        Arrays.fill(dp_arr, -1);

        System.out.println(wordBreakBetter(str, 0, map, dp_arr));

    }

    public static int wordBreakBetter(String str, int ind, HashMap<String, Boolean> map, int dp_arr[]){
        if(ind == str.length()){
            return 1;
        }
        if(dp_arr[ind] != -1){
            return dp_arr[ind];
        }

        for(int i=ind;i<=str.length();i++){

            String sub_str = str.substring(ind, i);
            if(map.containsKey(sub_str)){
                int temp_rs = wordBreakBetter(str, i, map,dp_arr);
                if(temp_rs == 1){
                    dp_arr[ind] = 1;
                    return 1;
                }
            }
        }

        return dp_arr[ind] = 0;
    }


//    public static int wordBreakBetter(String str, int ind, HashMap<String, Boolean> map, int dp_arr[][]){
//        if(ind == str.length()){
//            return 1;
//        }
//
//        for(int i=ind;i<=str.length();i++){
//            if(dp_arr[ind][i] != -1){
//                return dp_arr[ind][i];
//            }
//
//            String sub_str = str.substring(ind, i);
//            if(map.containsKey(sub_str)){
//                int temp_rs = dp_arr[ind][i] = wordBreakBetter(str, i, map,dp_arr);
//                if(temp_rs == 1){
//                    return 1;
//                }
//            }
//        }
//
//        return 0;
//    }

    public static boolean wordBreak(String str, int ind, HashMap<String, Boolean> map){
        if(ind == str.length()){
            return true;
        }

        boolean res = false;
        for(int i=ind;i<=str.length();i++){

            String sub_str = str.substring(ind, i);
            if(map.containsKey(sub_str)){
                res = res || wordBreak(str, i, map);
            }

        }

        return res;
    }



}
