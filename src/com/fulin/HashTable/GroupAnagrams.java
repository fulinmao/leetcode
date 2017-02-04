package com.fulin.HashTable;

import java.util.*;

/**
 * Created by fulin on 17-1-7.
 */
public class GroupAnagrams {
    public static void main(String[] args){
        String[] strs = {"and","dan"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> map = new HashMap<String ,List<String>> ();
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return result;
        }
        for(int i=0;i<strs.length;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String orderTemp = new String(temp);
            List<String> tempList = new ArrayList<String>();
            if(map.containsKey(orderTemp)){
                tempList = map.get(orderTemp);
                tempList.add(strs[i]);
            }else{
                tempList.add(strs[i]);
            }
            map.put(orderTemp,tempList);
        }
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }


}
