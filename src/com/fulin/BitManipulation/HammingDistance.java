package com.fulin.BitManipulation;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int result = 0;
        //^：如果相对应位值相同，则结果为0，否则为1
        int count = x ^ y;
        // 然后计算count 中1的个数
        result = count1BitsCount(count);
        return result;
    }

    public static int count1BitsCount(int count){
        int result = 0;
        while(count!=0){
            count = count & (count -1);
            result ++;
        }
        return result;
    }
}
