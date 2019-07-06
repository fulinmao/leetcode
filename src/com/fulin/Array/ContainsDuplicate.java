package com.fulin.Array;

import java.util.HashMap;

/**
 * Created by fulin on 16-12-9.
 */
public class ContainsDuplicate {

    public static void main(String[] args){
        int[] nums = {3,3};
        boolean result = containsDuplicate(nums);
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        boolean result = false;
        HashMap<Integer , Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                result = true;
                break;
            }
            map.put(num,0);
        }

        return result;
    }

}
