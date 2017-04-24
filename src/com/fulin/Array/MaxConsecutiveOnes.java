package com.fulin.Array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.The maximum number of consecutive 1s is 3.
 *
 * Created by fulin on 17-4-24.
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                if(result < max){
                    result = max;
                }
                max = 0 ;
                continue;
            }

            if(nums[i] == 1){
                max = max + 1;
            }

        }

        if(result < max){
            result = max;
            max = 0;
        }


        return result;
    }

}
