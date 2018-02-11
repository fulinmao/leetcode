package com.fulin.Math;

import java.util.HashMap;
/**
 * Created by fulin on 18-2-11.
 */
public class HappyNumber {

    public static  void main(String[] args){
        int num = 20;
        boolean result = isHappy(2);
        System.out.println(result);
    }

    public static boolean isHappy(int n) {
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        boolean result = true;

        Integer temp = helper(n);
        if(temp == 1){
            return result;
        }
        while(temp != 1){
            if(map.containsKey(temp)){
                result = false;
                break;
            }
            map.put(temp , 1);
            temp = helper(temp);
        }
        return result;
    }

    public static Integer helper(int n){
        int result = 0;
        int temp = 0;
        while(n >= 10){
            temp = n % 10;
            result += temp * temp;
            n = n / 10;
        }

        result += n * n;
        return result;
    }
}
