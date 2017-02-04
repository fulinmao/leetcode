package com.fulin.String;

/**
 * Created by fulin on 17-1-4.
 */
public class MyAtoi {
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0 - Integer.MAX_VALUE);

        String str ="18446744073709551617";
        System.out.println(myAtoi(str));

    }

    public static int myAtoi(String str) {
        if(str == null || str.length() ==0){
            return 0;
        }
        str = str.trim();
        boolean isNegative = false;
        long result = 0;
        int start = 0;
        char[] strArray = str.toCharArray();
        int length = strArray.length;
        if(strArray == null || strArray.length == 0){
            return 0;
        }
        if(strArray[0] == '-'){
            isNegative = true;
            if(strArray.length <2 ){
                return 0;
            }
            start = 1;

        }else{
            isNegative = false;
            start = 0;
            if(strArray[0] == '+'){
                if(strArray.length <2){
                    return 0;
                }
                start = 1;
            }

        }
        for(int i=start;i<length;i++){
            if(strArray[i] < 48 || strArray[i] > 57){
                length = i;
                break;
            }
        }

        while(start < length){
            if(strArray[start] < 48 || strArray[start] > 57){
                for(int i=0;i< length - start ;i++){
                    result /= 10;
                }
                break;
            }
            long base = 1;
            if(length - start - 1 > 10){
                result = Integer.MAX_VALUE;
                break;
            }
            for(int i = 0; i < length - start - 1 ; i++){
                base *= 10;
            }

            long temp = (strArray[start] - 48 ) * base;
            if(isNegative){
                temp = temp * (-1);
            }
            result = result + temp;
            if(result > Integer.MAX_VALUE){
                break;
            }else if(result < Integer.MIN_VALUE){
                break;
            }
            start ++;
        }

        if(isNegative){
            if(result < Integer.MIN_VALUE || result == Integer.MAX_VALUE){
                result = Integer.MIN_VALUE;
            }
        }else{
            if(result > Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            }
        }
        return new Long(result).intValue();
    }
}
