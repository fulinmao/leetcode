package com.fulin.Array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 毛福林
 * @title: MaximumSubarrayTest
 * @projectName leetcode
 * @description: TODO
 * @date 2019/7/1516:05
 */
public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = 6;
        int rtn = MaximumSubarray.maxSubArray(nums);
        assert result == rtn;
    }

    @Test
    public void maxSubArray2() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = 6;
        int rtn = MaximumSubarray.maxSubArray2(nums);
        assert result == rtn;
    }

    @Test
    public void maxSubArray1() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = 6;
        int rtn = MaximumSubarray.maxSubArray1(nums);
        assert result == rtn;
    }
}