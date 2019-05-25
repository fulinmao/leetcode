package com.fulin.Array;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        // 如果 查找的数组为空，则直接返回 -1
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        // 如果查找数组的第一个元素大于target,或者最后一个元素小于target，则直接返回-1
        if(nums[0] >target || nums[length - 1] < target){
            return -1;
        }

        int start = 0;
        int end = length -1;
        int result = -1;

        while(start <= end){
            int middle = start + (end - start) / 2;

            if(nums[middle] == target){
                result = middle;
                break;
            }

            if(nums[middle] > target){
                end = middle - 1;
            }

            if(nums[middle] < target){
                start = middle + 1;
            }

        }

        return result;
    }
}
