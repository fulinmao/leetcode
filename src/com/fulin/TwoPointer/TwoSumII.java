package com.fulin.TwoPointer;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they
 * add up to a specific target number.The function twoSum should return indices of the two numbers
 * such that they add up to the target, where index1 must be less than index2.
 *
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * Created by fulin on 17-2-13.
 */
public class TwoSumII {

    public static void main(String[] args){
        int[] nums = {5,25,75};
        int target = 100;
        int[] result = twoSum(nums,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 1){
            return null;
        }
        int[] result = new int[2];
        int index1 = 0;
        int index2 = numbers.length - 1;
        while(index1 < index2){
            if(target == numbers[index1] + numbers[index2]){
                if(index1 != index2){
                    result[0] = index1 + 1;
                    result[1] = index2 + 1;
                    break;
                }
            }

            if(numbers[index1] + numbers[index2] > target){
                index2 --;
            }else if(numbers[index1] + numbers[index2] < target){
                index1++;
            }
        }
        return result;
    }
}
