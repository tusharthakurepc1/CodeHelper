package com.DynamicProgramming.String_DP;

public class WildCardMatching {
    public static void main(String[] args) {
        String s1 = "acdcb";
        String s2 = "a*c?b";

        System.out.println(helper(s1, s1.length()-1, s2, s2.length()-1));
    }

    public static boolean helper(String s1, int ind1, String s2, int ind2){
        if(ind1 == -1 && ind2 == -1){
            return true;
        }
        if(ind1 < 0){
            for(int i=0;i<ind2;i++){
                if(s2.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(ind2 < 0){
            return false;
        }

        if(s1.charAt(ind1) == s2.charAt(ind2) || s2.charAt(ind2) == '?'){
            return helper(s1, ind1 - 1, s2, ind2 - 1);
        }
        else if(s2.charAt(ind2) == '*'){
            return helper(s1, ind1 - 1, s2, ind2) || helper(s1, ind1, s2, ind2 + 1);
        }

        return false;
    }


}
