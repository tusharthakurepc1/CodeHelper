package com.StringDataStructure;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"abab","aba","aba", "aba"};


        System.out.println(helper(arr));

//        System.out.println((int)'0');
    }

    public static String helper(String arr[]){
        if(arr.length == 1){
            return arr[0];
        }

        StringBuilder res = new StringBuilder("");
        int min_len = arr[0].length();

        for(int i=0;i<min_len;i++){
            boolean needInsert = true;

            for(int j=1;j<arr.length;j++){
                if(arr[j].length() == 0){
                    return "";
                }
                if(arr[j].charAt(i) != arr[j-1].charAt(i)){
                    needInsert = false;
                }
                min_len = Math.min(min_len, arr[j].length());
            }


            if(needInsert){
                res.append(arr[0].charAt(i));
            }
            else{
                return res.toString();
            }
        }


        return res.toString();
    }
}
