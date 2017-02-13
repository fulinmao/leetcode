package com.fulin.TwoPointer;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 "  A man, a plan, a canal: Panama" is a palindrome.
 "  race a car" is not a palindrome.
 *
 * Created by fulin on 17-2-13.
 */
public class ValidPalindrome {

    public static void main(String[] args){
        String s = "......a.....";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        if(s == null ){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        if(!isContainAlphanumericCharacters(s)){
            return true;
        }
        boolean result = true;
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            while(!isAlphanumericCharacters(s.charAt(start))){
                start ++;
            }

            while(!isAlphanumericCharacters(s.charAt(end))){
                end --;
            }

            if(toLow(s.charAt(start))  == toLow(s.charAt(end))){
                start ++;
                end --;
            }else{
                result = false;
                break;
            }
        }

        return result;

    }

    private static char toLow(char c){
        if(c >= 97 && c <= 122){
            c = (char) (c - 32);
        }
        return c;
    }

    private static boolean isAlphanumericCharacters(char c){
        boolean result = false;
        if((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)){
            result = true;
        }
        return result;
    }

    private static boolean isContainAlphanumericCharacters(String str){
        boolean result = false;
        for(int i=0;i<str.length();i++){
            if(isAlphanumericCharacters(str.charAt(i))){
                result = true;
                break;
            }
        }
        return result;
    }
}
