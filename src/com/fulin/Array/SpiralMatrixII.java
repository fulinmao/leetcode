package com.fulin.Array;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.
 *
 * For example,Given n = 3,
 *
 * [
 * [1,2,3],
 * [8,9,4],
 * [7,6,5]
 * ]
 * Created by fulin on 17-3-4.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        if(n < 0){
            return null;
        }

        int[][] result = new int[n][n];
        int start = 0;
        int startNum = 1;
        while(n > start * 2){
            startNum = genArrayByOneCricle(result, start,startNum,n);
            start ++;
        }

        return result;
    }

    private int genArrayByOneCricle(int[][] result , int start,int startNum,int n){
        if(start <0){
            return 0;
        }
        int startX = start;
        int startY = start;

        int endX = n - start - 1;
        int endY = n - start - 1;

        //从左往右生成数组
        for(int i=startX;i<= endX;i++){
            result[startY][i] = startNum ++;
        }
        //从上往下生成数组
        if(startY < endY){
            for(int i=startY + 1 ; i < endY;i++){
                result[i][endX] = startNum ++;
            }
        }
        //从右往左生成数组
        if(startX < endX && startY < endY){
            for(int i= endX;i>startX;i--){
                result[endY][i] = startNum ++;
            }
        }

        //从下往上打印数组
        if(startX < endX && startY < endY){
            for(int i= endY;i > startY;i--){
                result[i][startY] = startNum++;
            }
        }

        return startNum;
    }
}
