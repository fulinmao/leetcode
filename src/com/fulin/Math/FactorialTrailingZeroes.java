package com.fulin.Math;

/**
 * Created by fulin on 18-2-11.
 */
public class FactorialTrailingZeroes {

    // 1. 需要注意的是后缀0是由2，5相乘得来，因此只需看有多少个2，5即可
    // 2.质因子中2的个数总是大于等于5的个数。因此只要计数5的个数就可以了。
    // 3.需要注意的是25中有25，20，15，10，5，但是25又可以分为5*5
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5){
            count += n / 5;
            n /= 5;
        }

        return count ;
    }
}
