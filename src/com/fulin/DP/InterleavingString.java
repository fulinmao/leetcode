package com.fulin.DP;

/**
 * 97. Interleaving String
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * Created by fulin on 17-8-14.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        // 如果s3为空字符串，则s1 和 s2 字符串必须为空字符串才返回true
        if(s3 == null || s3.length() == 0){

            return (s2 == null && s1 == null) || (s1.length() == 0 || s2.length() == 0);
        }
        // 如果s3的长度与s1 和 s2的长度之和不相等，返回false;
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        //如果s3的第一个字符和s1，s2的第一个字符均不相等，返回false;
        if(s3.charAt(0) != s1.charAt(0) && s3.charAt(0) != s2.charAt(0)){
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        boolean[][] isInterleave = new boolean[m + 1][n + 1];
        isInterleave[0][0] = true;


        for(int i = 1; i<=n;i++){
            isInterleave[0][i] = isInterleave[0][i-1] && (s2.charAt(i - 1) == s3.charAt( i - 1));
        }

        for(int i=1 ;i<=m;i++){
            isInterleave[i][0] = isInterleave[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i-1));
        }

        // 对新增的一个字符 ，需要判断 新增字符是否与s3位置上的字符相同，并且之前的字符与s3的字符完全一致
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                isInterleave[i][j] = (isInterleave[i][j - 1] && s2.charAt(j-1) == s3.charAt(i + j -1) )
                        || (isInterleave[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }

        return isInterleave[m][n];

    }
}
