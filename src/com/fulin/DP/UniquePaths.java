package com.fulin.DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * Created by fulin on 17-7-26.
 */
public class UniquePaths {

    /**
     * 使用动态规划的方法计算路径的数量
     * @param m 行数
     * @param n 列数
     * @return 路径数量
     */
    public static int uniquePaths(int m, int n) {
        if(m <=0 || n<= 0){
            return 0;
        }

        int[][] path = new int[m][n];

        for(int i = 0;i<m;i++){
            path[i][0] = 1;
        }

        for(int i =0;i<n;i++){
            path[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j = 1;j<n ;j++){
                path[i][j] = path[i][j - 1] + path[i-1][j];
            }
        }

        return path[m-1][n-1];
    }

    /**
     * 使用一维数据计算路径数量
     * @param m 行数
     * @param n 列数
     * @return 路径数量
     */
    public static int uniquePathsOneArray(int m, int n) {
        if(m <=0 || n<= 0){
            return 0;
        }

        int[] path = new int[n];

        for(int i = 0;i<n;i++){
            path[i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j = 1;j<n ;j++){
                path[j] = path[j - 1] + path[j];
            }
        }
        return path[n-1];
    }
}
