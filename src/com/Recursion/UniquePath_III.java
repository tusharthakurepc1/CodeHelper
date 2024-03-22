package com.Recursion;

public class UniquePath_III {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

/*
*   This problem you have to return the total no of path in which you cover all the non-visited tiles and reach the destination
*   0 : unvisited tile
*   1 : starting point
*   2 : destination point
*  -1 : obstacles
*
*       reach from (0, 0) to (2, 2) there are 2 path
*   Expected ans is: 2
 */

        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    ans = recursiveSolution(grid, i, j);
                    System.out.println(ans);
                    return;
                }
            }
        }

    }

    public static int recursiveSolution(int grid[][], int row, int col){
        if(grid[row][col] == 2){
            if(isValid(grid)){
                return 1;
            }
            return 0;
        }


        //try out all directions possible
        int deltaX[] = {-1, 0, 1, 0};
        int deltaY[] = {0, 1, 0, -1};
        int ans = 0;

        for(int i=0;i<4;i++){

            int new_x = row + deltaX[i];
            int new_y = col + deltaY[i];

            if(new_x >= 0 && new_y >= 0 && new_x < grid.length && new_y < grid[0].length){


                if(grid[new_x][new_y] == 0 || grid[new_x][new_y] == 2){
                    grid[row][col] = 1;
                    ans = ans + recursiveSolution(grid, new_x, new_y);
                    grid[row][col] = 0;
                }

            }


        }

        return ans;
    }

    public static boolean isValid(int grid[][]){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }

}
