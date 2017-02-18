package com.fulin.TwoPointer;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 * Created by fulin on 17-2-18.
 */
public class RemoveDupFromSortedArrayII {

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }

        if(nums.length <=2){
            return nums.length;
        }

        int index = 2;

        for(int i=2;i<nums.length;i++){
            if(nums[i] != nums[index-2]){
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
