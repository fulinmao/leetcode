package com.fulin.number;

import java.util.Arrays;
import java.util.List;

/**
 * 判断一个字符串是否是合理的数字表示法
 * ①.判断字符串中的数字是否是在合理的字符范围内('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', 'e', '.')
 * ②.判断字符串中是否含有多个科学计数法 标识 e 使用s.lastIndexOf("e") != s.indexOf("e") 进行判断
 * ③.对字符串以 e 进行分割，分割前后都应该是正常的数字（validNumber），例如 e4 和3e 均不是正确的符号
 *
 * validNumber 校验过程
 * ①.判断第一个位置是否为正号（+） 或者 符号（-）
 * ②.判断是否存在多个小数点(.) 使用str.lastIndexOf(".") != str.indexOf(".")
 * ③.对字符串以 小数点(.) 进行分割，特别注意：使用split方法需要对小数点进行转义，例如：.3 和3.都应该是正确的数字
 * ④. 分割前后都应该是0-9的数字
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
        boolean result = true;
        List validChars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', 'e', '.');

        if (s == null || s.trim().length() <= 0) {
            result = false;
            return result;
        }
        s = s.trim().toLowerCase();
        char[] strNum = s.toCharArray();
        // 检查输入的字符串是否在合法的字符串里
        for (int i = 0; i < strNum.length; i++) {
            int index = validChars.indexOf(strNum[i]);
            if (index < 0) {
                result = false;
                break;
            }
        }
        // 检查数字是否合法
        //判断字符串中是否存在多个e
        if(s.lastIndexOf("e") != s.indexOf("e")){
            result = false;
            return result;
        }
        // 判断输入字符串中是否包含 科学计数法中的 e
        String[] splitNums = s.split("e");
        if (splitNums.length > 2 ||splitNums.length <=0) {
            result = false;
        }
        // 如果使用科学计数法之后，e前后的长度都不能为空，且e 后面的部分不能是小数
        if(splitNums.length ==1 && s.contains("e")){
            result = false;
        }

        if(splitNums.length == 2){
            if(splitNums[0].length() == 0 || splitNums.length ==0 ){
                result = false;
            }

            if(splitNums[1].indexOf(".") >=0){
                result = false;
            }
        }
        // 按照e 进行分割，分割后的2部分应该都是数
        for (int i = 0; i < splitNums.length; i++) {
            if (!validNumber(splitNums[i])) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static boolean validNumber(String str) {
        boolean result = true;
        if (str == null || str.length() <= 0) {
            return result;
        }
        // 判断 + 或者 - 是否是在第一个位置
        int index = str.indexOf("+");
        if (index != -1 && index != 0) {
            result = false;
            return result;
        }
        if (index >= 0) {
            // 如果存在+ ，则将先将+去掉
            str = str.substring(index+1);
        }
        if(str.length() == 0){
            result = false;
            return result;
        }

        index = str.indexOf("-");
        if (index != -1 && index != 0) {
            result = false;
            return result;
        }
        if (index >= 0) {
            str = str.substring(index+1);
        }
        if(str.length() == 0){
            result = false;
            return result;
        }

        //判断 输入中是否存在 多个小数点
        if(str.lastIndexOf(".") != str.indexOf(".")){
            result = false;
        }

        String[] splitNum = str.split("\\.");
        if (splitNum.length > 2 || splitNum.length <=0) {
            result = false;
            return result;
        }

        if(splitNum.length == 2){
            if(splitNum[1].length() == 0){
                result = false;
            }
        }

        for (int i = 0; i < splitNum.length; i++) {
            String numStr = splitNum[i];
            char[] numChar = numStr.toCharArray();
            for (int j = 0; j < numChar.length; j++) {
                if (numChar[j] > '9' || numChar[j] < '0') {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String t = ".1";
        boolean result = isNumber(t);
        System.out.println(result);
        String[] tArr = t.split("\\.");
        for(int i=0;i<tArr.length;i++){
            System.out.println(i);
            System.out.println(tArr[i]);
        }
    }
}
