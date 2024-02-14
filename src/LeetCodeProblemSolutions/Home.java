package LeetCodeProblemSolutions;

import com.GraphDataStructure.GraphDataStore;
import com.TreeDataStructure.*;

import java.util.*;

class TreeNodeCustom{
    public TreeNode root;
    public int coordinate;
    public int level;

    public TreeNodeCustom(TreeNode _root, int _coordinate){
        this.root = _root;
        this.coordinate = _coordinate;
    }
    public TreeNodeCustom(TreeNode _root, int _coordinate, int _level){
        this.root = _root;
        this.coordinate = _coordinate;
        this.level = _level;
    }
}

public class Home {
    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int dp_arr[][] = new int[arr.length][arr[0].length];
        for(int temp[]: dp_arr){
            Arrays.fill(temp, -1);
        }

        System.out.println(helper(arr, arr.length-1, 0, dp_arr));

        tabulationSolution(arr, dp_arr);
    }

    public static int helper(int arr[][], int row, int col, int dp_arr[][]){
        if(row == 0){
            return arr[row][col];
        }
        if(dp_arr[row][col] != -1){
            return dp_arr[row][col];
        }

        int diagnol_left = Integer.MAX_VALUE, diagnol_right = Integer.MAX_VALUE;

        int top = arr[row][col] + helper(arr, row-1, col, dp_arr);
        if(col > 0){
            diagnol_left = arr[row][col] + helper(arr, row-1, col-1, dp_arr);
        }
        if(col < arr[row].length-1){
            diagnol_right = arr[row][col] + helper(arr, row-1, col+1, dp_arr);
        }

        return dp_arr[row][col] = Math.min(top, Math.min(diagnol_left, diagnol_right));
    }

    public static void tabulationSolution(int arr[][], int dp_arr[][]){
        int r_len = arr.length;
        int c_len = arr[0].length;

        for(int j=0;j<c_len;j++){
            dp_arr[0][j] = arr[0][j];
        }

        for(int row = 1;row < arr.length;row++){
            for(int col = 0;col < arr[row].length;col++){

                int diagnol_left = Integer.MAX_VALUE, diagnol_right = Integer.MAX_VALUE;

                int top = arr[row][col] + dp_arr[row-1][col];
                if(col > 0){
                    diagnol_left = arr[row][col] + dp_arr[row-1][col-1];
                }
                if(col < arr[row].length-1){
                    diagnol_right = arr[row][col] + dp_arr[row-1][col+1];
                }

                dp_arr[row][col] = Math.min(top, Math.min(diagnol_left, diagnol_right));
            }
        }


        for(int temp[]: dp_arr){
            System.out.println(Arrays.toString(temp));
        }

    }

}
