package com.CP;

public class WordSearchBacktracking {
    public static void main(String[] args) {
//        char arr[][] = {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };

        char arr[][] = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
//        boolean flags[][] = new boolean[arr.length][arr[0].length];
        String pattern = "AAB";

//        System.out.println(wordSearch(arr, 1, 1, flags, pattern, 0));

        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(wordSearch(arr, i, j, new boolean[arr.length][arr[0].length], pattern, 0)){
                    System.out.println("Find it");
                    System.exit(1);
                }
            }
        }
//        System.out.println("Not found");

    }

    public static boolean wordSearch(char[][] arr, int r, int c, boolean[][] flags, String pattern, int ind){
        if(ind == pattern.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length){
            return false;
        }

        if(arr[r][c] == pattern.charAt(ind) && !flags[r][c]){
//            Go to the four directions and check
            flags[r][c] = true;

            boolean top = false, right = false, bottom = false, left = false;

//            Search in the top
//            if(r > 0){
                top = wordSearch(arr, r-1, c, flags, pattern, ind+1);
//            }

//            Search in the right
//            if(c < arr[0].length-1){
                right = wordSearch(arr, r, c+1, flags, pattern, ind+1);
//            }

//            Search in the bottom
//            if(r < arr.length-1){
                bottom = wordSearch(arr, r+1, c, flags, pattern, ind+1);
//            }

//            Search in the left
//            if(c > 0){
                left = wordSearch(arr, r, c-1, flags, pattern, ind+1);
//            }

            return top || right || bottom || left;
        }

        return false;
    }
}
