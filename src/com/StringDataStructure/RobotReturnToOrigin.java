package com.StringDataStructure;

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        String moves = "UD";

        System.out.println(helper(moves));
    }

    public static boolean helper(String moves){
        int row = 0, col = 0;

        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'U'){
                row-=1;
            }
            else if(moves.charAt(i) == 'L'){
                col-=1;
            }
            else if(moves.charAt(i) == 'D'){
                row++;
            }
            else if(moves.charAt(i) == 'R'){
                col++;
            }
        }

        if(row == 0 && col == 0)
            return true;
        else
            return false;
    }
}
