package com.DynamicProgramming;

public class MaximumRepeatingSubString {
    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
//                         0123456789012345678901234567890123
        String word = "aaaba";

        solution(sequence, word);
//        System.out.println(solution2(sequence, word));
    }

    public static void solution(String str, String word){
        int count = 0;

        for(int i=0; i<=str.length() - word.length(); i++){
            String sub_str = str.substring(i, i + word.length());

            if(sub_str.equals(word)){
                count += 1;
                i = i + word.length() - 1;
            }

        }
        System.out.println(count);

    }

    public static int solution2(String str, String word){
        int count = 0;

        for(int i=0; i<str.length(); i++){

            int local_i = i,j=0;
            while(j < word.length() && local_i < str.length()){
                if(str.charAt(local_i) != word.charAt(j)){
                    break;
                }

                local_i ++;
                j ++;
            }

            if(j == word.length()){
                System.out.println("Ans: "+i);
                count++;

            }

        }

        return count;
    }


}
