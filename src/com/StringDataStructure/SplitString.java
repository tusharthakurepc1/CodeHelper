package com.StringDataStructure;

public class SplitString {
    public static void main(String[] args) {
        String str = "0000";

        helper(str);

        System.out.println(optimalSolution(str));
    }

    public static int optimalSolution(String str){

        long ones = countOnes(str);
        if(ones == 0){
            int n = str.length();
            return (int)(((n-1) * (n-2)) / 2);
        }
        else if(ones % 3 != 0){
            return 0;
        }
        else{
            long ones_in_block = ones / 3;
            long c1 = 0, c2 = 0;
            long temp = 0;

            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '1'){
                    temp++;
                }
                if(temp == ones_in_block){
                    c1++;
                }
                if(temp == ones_in_block*2){
                    c2++;
                }
            }
            return (int)(c1 * c2);
        }
    }

    public static int helper(String str){
        int count = 0;
        for(int i=1;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                String left = str.substring(0, i);
                String mid = str.substring(i, j);
                String right = str.substring(j, str.length());

                int left_c = countOnes(left);
                int mid_c = countOnes(mid);
                int right_c = countOnes(right);

                if(left_c == mid_c && mid_c == right_c){
                    System.out.println(left + " || "+ mid+ " || "+ right);
                    count++;
                }

            }
        }
        return count;
    }

    public static int countOnes(String str){
        int count = 0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }

        return count;
    }
}
