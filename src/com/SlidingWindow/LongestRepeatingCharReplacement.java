package com.SlidingWindow;


public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String str = "BAAA";
        int k = 0;

        bruteForce(str, k);
        optimalSolution(str, k);
    }

    //Time complexity: O(n + (n * 26))  O(2n)
    //Space complexity: O(26)
    public static void optimalSolution(String str, int k){
        int hash_map[] = new int[26];
        int max_freq = 0, max_len = 0;
        int left = 0;

        for(int right=0; right<str.length(); right++){
            hash_map[(int)str.charAt(right) - 'A'] += 1;
            max_freq = Math.max(max_freq, hash_map[(int)str.charAt(right) - 'A']);

            int changes = (right-left+1) - max_freq;
            while(changes > k){
                hash_map[(int)str.charAt(left) - 'A'] -= 1;

                max_freq = 0;
                for(int i=0; i<hash_map.length; i++){
                    max_freq = Math.max(max_freq, hash_map[i]);
                }

                left++;
                changes = (right-left+1) - max_freq;
            }

            max_len = Math.max(max_len, right-left+1);

        }

        System.out.println(max_len);
    }

    //Time complexity: O(n^2)
    //Space complexity: O(170)
    public static void bruteForce(String str, int k){
        int max_len = 0;

        for(int left=0; left<str.length(); left++){

            int hash_map[] = new int[170];
            int max_freq = 0;

            for(int right=left; right<str.length(); right++){

                hash_map[str.charAt(right)]++;
                max_freq = Math.max(max_freq, hash_map[str.charAt(right)]);

                int changes = (right-left+1) - max_freq;

                if(changes > k){
                    break;
                }

                max_len = Math.max(max_len, right-left+1);

            }
        }

        System.out.println(max_len);

    }

}
