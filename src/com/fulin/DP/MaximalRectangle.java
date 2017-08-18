package com.fulin.DP;

import java.util.Stack;

/**
 *
 * 85. Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 * For example, given the following matrix:
 *  1 0 1 0 0
 *  1 0 1 1 1
 *  1 1 1 1 1
 *  1 0 0 1 0
 * Return 6.
 *
 * Created by fulin on 17-8-18.
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i=0;i<n;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }

        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }

        int largeAreaRectangle = 0;
        for(int i=0;i<m;i++){
            int temp = largestRectangleArea(dp[i]);
            if(temp > largeAreaRectangle){
                largeAreaRectangle = temp;
            }
        }

        return largeAreaRectangle;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[i] > stack.peek()) {
                stack.push(heights[i]);
            } else {
                int count = 0;
                while ((!stack.empty()) && heights[i] < stack.peek()) {
                    count++;
                    max = max(max, stack.peek() * count);
                    stack.pop();
                }

                while (count > 0) {
                    count--;
                    stack.push(heights[i]);
                }

                stack.push(heights[i]);
            }
        }

        int count = 1;
        while (!stack.empty()) {
            max = max(max, count * stack.peek());
            stack.pop();
            count++;
        }

        return max;
    }

    private int max(int num1 , int num2){
        return num1 > num2 ? num1 :num2 ;
    }
}
