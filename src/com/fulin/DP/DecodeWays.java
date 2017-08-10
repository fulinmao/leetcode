package com.fulin.DP;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *   'A' -> 1
 *   'B' -> 2
 *   ...
 *   'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 *  Created by fulin on 17-8-10.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        //如果字符串为空，则返回0
        if(s == null || s.length() == 0){
            return 0;
        }
        // 如果字符串以0开始，则返回0
        if(s.length() > 0 && s.charAt(0) == '0'){
            return 0;
        }

        int m = s.length();

        int[] ways = new int[m + 1];

        //对数组的第一个元素赋值为0 第二个元素赋值为1
        ways[0] = 1;
        ways[1] = 1;

        for(int i=2;i<=m;i++){

            char current = s.charAt(i - 1);
            if('0' != current){
                ways[i] = ways[i-1];
            }
            // 如果 当前元素与之前的元素组成的数字长度是10 - 26的话，则方式可以加上前两个字符串的方法
            char pre = s.charAt(i-2);
            if((pre < '2' && pre > '0') ||(pre == '2' && current <= '6' ) ){
                ways[i] += ways[i - 2];
            }


        }

        return ways[m];
    }
}
