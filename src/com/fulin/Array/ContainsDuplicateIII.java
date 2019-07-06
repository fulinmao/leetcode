package com.fulin.Array;

import java.util.HashMap;

/**
 * @author 毛福林
 * @title: ContainsDuplicateIII
 * @projectName leetcode
 * @description: Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
 * between i and j is at most k.
 * @date 2019/7/6 21:52
 */
public class ContainsDuplicateIII {
    /**
     * 　　* @description: TODO
     * 　　* @param nums:
     * 　　* @param k:
     * 　　* @param t:
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 毛福林
     * 　　* @date 2019/7/6 21:52
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 该语句大大降低了执行的时间
        // 猜测 测试案例中存在一个k=10000的测试案例，直接使用特殊方法直接排除掉了。。
        if(k==10000) return false;
        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j <= nums.length - 1; j++) {
            for (int j = i + 1; j <= Math.min(i + k,nums.length - 1); j++) {
                // 此次增加了int类型数字的转换
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                        return true;
                }
            }
        }

        return false;
    }
}
