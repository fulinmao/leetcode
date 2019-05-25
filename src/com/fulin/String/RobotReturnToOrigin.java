package com.fulin.String;

public class RobotReturnToOrigin {
    public static boolean judgeCircle(String moves) {
        // 如果移动的字符串是空，即在原点没有移动，则直接返回true
        if(moves == null || moves.length() == 0){
            return true;
        }

        // 假设 所有的字母 都是符合要求的 U D L R
        int length = moves.length();
        if(length % 2 == 1){
            // 如果移动的步数不是偶，肯定不会返回
            return false;
        }

        int x = 0;
        int y = 0;
        // 将moves 中所有的字母全部转换成大写字母
        moves = moves.toUpperCase();
        char[] movesCharArray = moves.toCharArray();
        for(char temp : movesCharArray){

            if(temp == 'U'){
                y++;
            }else if( temp == 'D'){
                y--;
            }else if (temp == 'L'){
                x--;
            }else if (temp == 'R'){
                x++;
            }else {
                // 如果存在其他字母，则直接返回false
                return false;
            }

        }
        return (x== 0) && (y==0);

    }
}
