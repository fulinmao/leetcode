package com.fulin.Array;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * Created by fulin on 17-9-24.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0){
            return result;
        }

        int low = 0;
        int high = nums.length;
        int middle = (low + high) / 2;
        int start = -1;
        int end = -1;

        // 因为nums是有序数组，如果第一个元素大于target.或者最有一个元素小于target ,则直接返回
        if(nums[0] > target || nums[nums.length - 1] < target){
            return result;
        }
        if(nums[0] == target && nums[nums.length - 1] == target){
            result[0] = 0;
            result[1] = nums.length - 1;
        }
        while(low <= high){
            if(nums[middle] < target){
                low = middle + 1;
            }else if(nums[middle] > target){
                high = middle - 1;
            }else if(nums[middle] == target){
                start = middle;
                while(start > 0 && nums[start] == target){
                    start --;
                }
                end = middle;
                while(end < nums.length - 1 && nums[end] == target){
                    end ++;
                }
                if(nums[start] != target){

                    start = start == nums.length - 1 ? nums.length - 1 : start + 1;
                }

                if(nums[end] != target){
                    end = end == 0 ? 0: end - 1;
                }

                result[0] =  start;
                result[1] = end;
                return result;
            }

            middle = (low + high) /2;
        }
        return result;
    }

}
