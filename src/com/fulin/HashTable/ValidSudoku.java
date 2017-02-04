package com.fulin.HashTable;

/**
 * Created by fulin on 17-1-5.
 */
public class ValidSudoku {
    public static void main(String[] args){
        char[][] board = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),
                "4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),
                "7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};

        boolean result =  isValidSudoku(board);
        System.out.println(result);
    }
    public static boolean isValidSudoku(char[][] board) {
        if(board == null){
            return false;
        }
        boolean result = true;
        int row = board.length;
        if(row != 9){
            return false;
        }
        for(int i=0 ; i< row ;i++){
            if(board[i].length !=9){
                return false;
            }
        }
        int[] nums = new int[10];
        // row
        for(int i=0;i<9;i++){
            nums = new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j] < 49 || board[i][j] > 57){
                    continue;
                }
                if(nums[board[i][j] -48] == 0){
                    nums[board[i][j] -48] = 1;
                }else{
                    return false;
                }
            }
        }

        //coloumn
        for(int i=0;i<9;i++){
            nums = new int[10];
            for(int j=0;j<9;j++){
                if(board[j][i] < 49 || board[j][i] > 57){
                    continue;
                }
                if(nums[board[j][i] - 48] == 0){
                    nums[board[j][i] - 48]  = 1;
                }else{
                    return false;
                }
            }
        }
        //square
        for(int i=0;i<9;i++){
            int index = i % 3;
            int column = i / 3;
            nums = new int[10];

            if(board[column * 3 + 0][index * 3 +0] >= 49  && board[column * 3 + 0][index * 3 +0] <=57){
                if( nums[ board[column * 3 + 0][index * 3 +0] -48]  == 0){
                    nums[ board[column * 3 + 0][index * 3 +0] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 0][index * 3 +1] >= 49  && board[column * 3 + 0][index * 3 +1] <=57){
                if( nums[ board[column * 3 + 0][index * 3 +1] -48]  == 0){
                    nums[ board[column * 3 + 0][index * 3 +1] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 0][index * 3 +2] >= 49  && board[column * 3 + 0][index * 3 +2] <=57){
                if( nums[ board[column * 3 + 0][index * 3 +2] -48]  == 0){
                    nums[ board[column * 3 + 0][index * 3 +2] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 1][index * 3 +0] >= 49  && board[column * 3 + 1][index * 3 +0] <=57){
                if( nums[ board[column * 3 + 1][index * 3 +0] -48]  == 0){
                    nums[ board[column * 3 + 1][index * 3 +0] -48] = 1;
                }else{
                    return false;
                }
            }
            if(board[column * 3 + 1][index * 3 +1] >= 49  && board[column * 3 + 1][index * 3 +1] <=57){
                if(nums[ board[column * 3 + 1][index * 3 +1] -48]  == 0){
                    nums[ board[column * 3 + 1][index * 3 +1] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 1][index * 3 +2] >= 49  && board[column * 3 + 1][index * 3 +2] <=57){
                if( nums[ board[column * 3 + 1][index * 3 +2] -48]  == 0){
                    nums[ board[column * 3 + 1][index * 3 +2] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 2][index * 3 +0] >= 49  && board[column * 3 + 2][index * 3 +0] <=57){
                if( nums[ board[column * 3 + 2][index * 3 +0] -48]  == 0){
                    nums[ board[column * 3 + 2][index * 3 +0] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 2][index * 3 +1] >= 49  && board[column * 3 + 2][index * 3 +1] <=57){
                if( nums[ board[column * 3 + 2][index * 3 +1] -48]  == 0){
                    nums[ board[column * 3 + 2][index * 3 +1] -48] = 1;
                }else{
                    return false;
                }
            }

            if(board[column * 3 + 2][index * 3 +2] >= 49  && board[column * 3 + 2][index * 3 +2] <=57){
                if( nums[ board[column * 3 + 2][index * 3 +2] -48]  == 0){
                    nums[ board[column * 3 + 2][index * 3 +2] -48] = 1;
                }else{
                    return false;
                }
            }

        }
        return result;
    }
}
