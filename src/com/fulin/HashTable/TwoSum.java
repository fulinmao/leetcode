package com.fulin.HashTable;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Created by fulin on 17-2-13.
 */
public class TwoSum {

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 1){
            return result;
        }
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i] , i);
        }
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(target - num)){
                if(i != map.get(target - num)){
                    result[0] = i;
                    result[1] = map.get(target - num);
                    break;
                }
            }
        }
        return result;
    }
}
