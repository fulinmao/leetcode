package com.fulin.DP;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example
 *  [
 *      [0,0,0],
 *      [0,1,0],
 *      [0,0,0]
 *   ]

 ×   The total number of unique paths is 2.
 * Created by fulin on 17-7-27.
 */
public class UniquePathsWithObstacles {

    public  static void main(String[] args){
        int[][] path = new int[5][4];
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                System.out.print(path[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1){
            return 0;
        }


        int[][] path = new int[m][n];

        for(int i=0;i<n;i++){
            if( obstacleGrid[0][i] == 0){
                path [0][i] = 1;
            }else{
                break;
            }
        }

        for(int i = 0 ;i < m;i++){
            if( obstacleGrid[i][0] == 0){
                path [i][0] = 1;
            }else{
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                } else{
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
