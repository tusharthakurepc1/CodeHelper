package com.DynamicProgramming.String_DP;

public class ShortestCommonSupersequence_1092 {
    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";

//        Ans: cabac   s1 and s2 are subsequence of this resultant string
        String res[] = new String[]{s1+s2};
        recursiveSolution(s1, 0, s2, 0, "", res);
        System.out.println(res[0]);
    }


//    This approach is not working for some test cases Ex: a = bbbaaaba, b = bbababbb and expected output is: bbbaaababbb
    public static void recursiveSolution(String s1, int ind1, String s2, int ind2, String super_str, String res[]){
        if(ind1 == s1.length()){
            super_str = super_str + s2.substring(ind2);
            if(super_str.contains(s1) && super_str.contains(s2)){
                if(res[0].length() >= super_str.length()){
                    res[0] = super_str;
                }
            }
            return;
        }
        if(ind2 == s2.length()){
            super_str = super_str + s1.substring(ind1);
            if(super_str.contains(s1) && super_str.contains(s2)){
                if(res[0].length() >= super_str.length()){
                    res[0] = super_str;
                }
            }
            return;
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)){
        //  it both character is same.
            recursiveSolution(s1, ind1 + 1, s2, ind2 + 1, super_str + s1.charAt(ind1), res);
        }
        else{
            recursiveSolution(s1, ind1 + 1, s2, ind2, super_str + s1.charAt(ind1), res);
            recursiveSolution(s1, ind1, s2, ind2 + 1, super_str + s2.charAt(ind2), res);
        }


    }

}
