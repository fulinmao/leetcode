package com.fulin.String;

import java.util.Arrays;

/**
 * Created by fulin on 17-1-18.
 */
public class LongestPalindrome {

    public static void main(String[] args){


        String s = "cabad";
        char[] t = s.toCharArray();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return null;
        }
        String result = "";
        char[] sArray = s.toCharArray();
        char[] resultArray = null;
        for(int i=0;i< sArray.length;i++){

            //
            for(int j = 0; (i - j >=0)&& i+j<sArray.length;j++){
                if(sArray[i - j] != sArray[i+j]){
                    break;
                }
                int temp = j * 2 + 1;
                if(result.length() < temp){
                    int start = i-j >0 ?(i-j) :0;
                    resultArray = Arrays.copyOfRange(sArray,start,i+j+1);
                    result = new String(resultArray);
                    if(temp == 1){
                        result = sArray[i] + "";
                    }
                }

            }


            for(int j=0;(i-j)>=0 && i+j+1 < sArray.length ;j++){
                if(sArray[i-j] != sArray[i+j+1]){
                    break;
                }
                int temp = j * 2 + 2;
                if(result.length() < temp){
                    int start = i-j >0 ?(i-j) :0;
                    resultArray = Arrays.copyOfRange(sArray,start,i+j+2);
                    result = new String(resultArray);
                    if(temp == 1){
                        result = sArray[i] + "";
                    }
                }

            }
        }

        return result;
    }
}
