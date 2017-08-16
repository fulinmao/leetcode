package com.fulin.DP;

/**
 * 115. Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3
 *
 * Created by fulin on 17-8-16.
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        // 如果t 字符串为空字符串，则返回1
        if(t == null || t.length()  == 0){
            return 1;
        }

        //如果t 字符串不为空，s字符串为空，则返回0
        if(s == null || s.length() == 0){
            return 0;
        }

        //如果s字符串的长度小于t的字符串的长度，则返回0
        if(s.length() < t.length()){
            return 0;
        }
        //如果两个字符串完全相同，则返回1
        if(t.equals(s)){
            return 1;
        }
        int m = s.length();
        int n = t.length();

        int[][] nums = new int[m +  1][n + 1];

        nums[0][0] = 1;

        for(int i = 1;i<= m ; i++){
            nums[i][0] = 1;
        }

        for(int i=1 ;i<=n ;i++){
            nums[0][i] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j] ;
                }else{
                    nums[i][j] = nums[i - 1][j];
                }
            }
        }


        return nums[m][n];
    }
}
