package com.fulin.Array;

/**
 * @author 毛福林
 * @title: MaximumSubarray
 * @projectName leetcode
 * @description: TODO
 * @date 2019/7/1222:25
 */
public class MaximumSubarray {
    /**
     * 使用暴力方法进行求解
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        // 使用暴力求解的方法
         if(nums == null || nums.length == 0){
             return 0;
         }
         int result = nums[0];
         for(int i=0;i<nums.length ;i ++){
             int temp = nums[i];
             if(temp > result){
                 result = temp;
             }
             for(int j=i+1;j<nums.length;j++){
                 temp += nums[j];
                 if(temp > result){
                     result = temp;
                 }
             }

         }
         return result;

    }

    public static int maxSubArray1(int[] nums){
        int result = 0;
        if(nums == null || nums.length <= 0){
            result = -1;
            return result;
        }
        int[] dp = nums;

        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }


        result = dp[0];
        for(int i=0;i<dp.length;i++){
            if(result < dp[i]){
                result = dp[i];
            }
        }
        return result;
    }
    /**
     * 使用动态规划的思路求解最大的连续子序列
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int result = 0;
        if(nums == null || nums.length <= 0){
            result = -1;
            return result;
        }
        result = nums[0];
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ;i ++){
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }

            if(result < sum){
                result = sum;
            }
        }

        return result;
    }
}
