package com.fulin.Math;

/**
 * Created by fulin on 17-1-15.
 */
public class IntegerToRoman {

    /**
     *
     *  1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     *  10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     *  100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     *  1000~3000: {"M", "MM", "MMM"}.
     */

    public static void main(String[] args){
        int num = 3599;
        System.out.println(intToRoman(num));

    }

    public static String intToRoman(int num) {
        String result = null;
        if(num <=0 || num >3999){
            return result;
        }
        String[][] romanArray = {{"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"","M", "MM", "MMM"}};
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while(num > 0){
            int temp = num % 10;
            sb.insert(0,romanArray[index][temp]);
            index ++;
            num = num / 10;
        }
        result = sb.toString();
        return result ;
    }
}
