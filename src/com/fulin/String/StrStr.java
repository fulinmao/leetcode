package com.fulin.String;

/**
 * Created by fulin on 17-1-7.
 */
public class StrStr {

    public static void main(String[] args){
        String haystack = "mississippi";
        String needle = "issi";
        System.out.println(strStr(haystack,needle));
    }

    public static  int strStr(String haystack, String needle) {
        int index = -1;

        if(needle == null){
            return index;
        }

        if(haystack == null){
            return index;
        }
        if(haystack.equals(needle)){
            index = 0;
            return index;
        }

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        for(int i=0;i <= haystackArray.length - needleArray.length ;i++){
            int j = 0;
            int start = i;
            for(j=0;j<needleArray.length;j++){
                if(haystackArray[start ++] != needleArray[j]){
                    break;
                }
            }
            if(j == needleArray.length){
                index = i;
                break;
            }

        }
        return index;
    }
}
