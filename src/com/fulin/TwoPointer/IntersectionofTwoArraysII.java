package com.fulin.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Created by fulin on 17-2-14.
 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args){

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ){
            return null;
        }
        int[] result = null;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                list.add(nums1[index1]);
                index1 ++;
                index2 ++;
            }else if(nums1[index1] > nums2[index2]){
                index2 ++;
            }else{
                index1 ++;
            }
        }

        result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
