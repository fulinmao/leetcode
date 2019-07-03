package com.fulin.HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class JewelsandStones {

    public static int numJewelsInStones(String J, String S) {
        // 如果J(珠宝) 为空，则S中珠宝的数量为0
        // 如果S为空，则珠宝的数量必然为0
        if(J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        for(char t : J.toCharArray()){
            set.add(t);
        }
        int result = 0;
        for(char t : S.toCharArray()){
            if(set.contains(t)){
                result ++;
            }
        }
        return result;
    }
}
