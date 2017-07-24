package com.fulin.String;

/**
 * '.' matches any single character
 * '*' matches zero or more or the preceding element
 *
 *
 * @author mfl4482
 *
 */
public class RegularExpressionMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));

    }

    public static boolean isMatch(String s , String p){
        //如果p的长度为0 在s的长度为0是返回匹配，其他情况返回不匹配
        if(p.length() == 0){
            return s.length() == 0;
        }

        //由于p的长度每次都是减少2次，如果p原始的长度为奇数，那么最后一次p的长度为1，需要对这种情况进行考虑
        if(p.length() == 1){
            return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '*');
        }

        if(p.charAt(1) != '*'){
            if(s.length() == 0){
                return false;
            }else{
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && (isMatch(s.substring(1), p.substring(1)));
            }
        }else{
            // next char is '*'
            while(s.length() >0 &&( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') ){
                if(isMatch(s, p.substring(2))){// 该 “*” 表示为0次
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
}