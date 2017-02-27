package com.fulin.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 × Given the following matrix:
 ×   1   2   3
 ×   4   5   6
 ×   7   8   9
 × return [1,2,3,6,9,8,7,4,5]
 * Created by fulin on 17-2-27.
 */
public class SpiralMatrix {

    public static void main(String[] args){
//        int[][] nums = {{1 ,  2  , 3  },{4,5   ,6   },{7,8,9 }};
        int[][] nums = {{2,3}};
        List<Integer> list = spiralOrder(nums);

        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null){
            return  list;
        }

        int row = matrix.length ;
        int column = row <= 0 ? -1 : matrix[0].length;

        if(row <0|| column <0){
            return list;
        }

        int start = 0;
        while((row > start *2) && (column > start*2) ){
            list.addAll(printMatrixByOneCricle(matrix,start));
            start ++;
        }
        return list;
    }

    private  static List<Integer>  printMatrixByOneCricle(int[][] nums, int start) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null){
            return  list;
        }

        int row = nums.length - 1;
        int column = nums[0].length - 1;

        int startX = start;
        int startY = start;

        int endX = column - start;
        int endY = row - start;

        //从左往右打印数组
        for(int i=startX;i<= endX;i++){
            list.add(nums[startY][i]);
        }

        //从上往下打印数组
        if(start < endY){
            for(int i=startY+1;i<= endY;i++){
                list.add(nums[i][endX]);
            }
        }


        // 从右向左打印数组
        if(start < endX && start < endY){
            for(int i=endX -1; i>= startX;i--){
                list.add(nums[endY][i]);
            }
        }

        // 从下往上打印数组
        if(start < endX && start < endY){
            for(int i= endY - 1; i> startY;i--){
                list.add(nums[i][startX]);
            }
        }

        return list;
    }
}
