package com.fulin.Array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Created by fulin on 17-8-11.
 */
public class ThreeSumClosest {

    public  static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        Arrays.sort(nums);
        int m = nums.length;

        int min = nums[0] + nums[1] + nums[2];
        int max = nums[m-1] + nums[m-2] + nums[m-3];

        if(target >= max){
            return max;
        }
        if(target <= min){
            return min;
        }
        int result = Math.abs(target - min) > Math.abs(target - max) ? max : min;
        int diff = Math.min(Math.abs(target - min) , Math.abs(max - target));
        for(int i=0;i < nums.length ; i++){
            int left = i + 1 ;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(target - sum);
                if(newDiff == 0){
                    return target;
                }
                if(diff > newDiff){
                    diff = newDiff;
                    result = sum;
                }

                if(sum > target){
                    right --;
                }else{
                    left ++;
                }
            }
        }

        return result;
    }
}
