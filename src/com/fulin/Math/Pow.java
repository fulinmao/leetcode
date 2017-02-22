package com.fulin.Math;

/**
 * Created by fulin on 17-2-22.
 */
public class Pow {
    public static void main(String[] args){
        double base = 8.88023;
        int exponent = 3;
        double result = myPow(base,exponent);
        System.out.println(result);
    }

    public static double myPow(double base, int exponent) {
        double result = 0;
        // 情况1： base: 0 exponent:
        if(equals(base, 0.0) && exponent <= 0){
            return result;	// 如果 底数为0 ，且 指数小于等于0 返回为0
        }

        if(exponent < 0 && equals(base, 0.0)){
            return result;
        }

        int absExponent = exponent;
        if(exponent < 0){
            absExponent = -exponent;
        }

        result = powerUnsignedIntExponent(base, absExponent);

        if(exponent < 0){	// 情况2：指数为负数，需取倒数
            result = 1.0 / result;
        }

        return result;
    }


    /**
     * double 类型的数字比较 尽可能不要用 等号
     * @param a
     * @param b
     * @return
     */
    private static boolean equals(double a , double b){
        boolean result = false;
        if(a - b < 0.00000000001){
            result = true;
        }
        return result;
    }

    private static double powerUnsignedIntExponent(double base , int exponent){

        if(exponent == 1){
            return base;
        }

        if(exponent == 0){
            return 1.0;
        }

        double result = powerUnsignedIntExponent(base , exponent >>> 1);
        result *= result;
        if((exponent & 1) == 1){
            //奇数
            result *= base;
        }
        return  result;
    }
}
