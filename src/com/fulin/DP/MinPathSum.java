package com.fulin.DP;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Created by fulin on 17-7-31.
 */
public class MinPathSum {

    public static void main(String[] args){
        int[][] grid = {{3,4,6},{2,6,4},{1,3,1}};
        int result = minPathSum(grid);
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        if(grid == null){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] path = new int[m][n];


        for(int i=0 ; i< m ;i ++){
            System.arraycopy(grid[i],0,path[i],0,n);
        }

        for(int i = 1 ; i<n ; i++){
            path[0][i] = path[0][i] + path[0][i-1];
        }

        for(int i = 1; i < m ; i++){
            path[i][0]  = path[i][0] + path[i-1][0];
        }

        for(int i=1;i<m;i++){
            for (int j = 1;j<n;j++){
                path[i][j] = Math.min(path[i - 1][j],path[i][j-1]) + path[i][j];
            }
        }
        return path[m-1][n-1];
    }
}
