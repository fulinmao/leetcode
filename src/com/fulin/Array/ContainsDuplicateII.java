package com.fulin.Array;

import java.util.HashMap;

/**
 * Created by fulin on 16-12-9.
 */
public class ContainsDuplicateII {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,9};
        boolean result = containsNearbyDuplicate(nums , 3);
        System.out.println(result);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return false;
        }

        boolean result = false;
        int length = nums.length;
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();

        for(int i = 0; i< length ;i++){
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if(i - index <= k){
                    result = true;
                    break;
                }
            }
            map.put(nums[i] , i);
        }

        return result;
    }

}
