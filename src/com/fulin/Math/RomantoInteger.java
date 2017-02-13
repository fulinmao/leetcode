package com.fulin.Math;

/**
 * Created by fulin on 17-1-15.
 */
public class RomantoInteger {

    /**
     *
     *  1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     *  10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     *  100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     *  1000~3000: {"M", "MM", "MMM"}.
     */
    public static void main(String[] args){

    }

    public static int romanToInt(String s) {
        int result = 0;
        if(s == null || s.length() == 0){
            return result;
        }
        char[] romanArray = s.toCharArray();
        result = toNumber(romanArray[0]);
        for(int i=1;i<romanArray.length;i++){
            if(toNumber(romanArray[i-1]) < toNumber(romanArray[i])){
                result = result + toNumber(romanArray[i]) - 2 * toNumber(romanArray[i - 1]);
            }else{
                result = result + toNumber(romanArray[i]);
            }
        }
        return result;
    }
    private static int toNumber(char ch) {

        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
