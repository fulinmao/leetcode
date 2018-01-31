package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

/**
 * Created by fulin on 18-1-31.
 */
public class ConvertSortedArraytoBST {
    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(nums);
        System.out.println(result.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }

        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        return helper(nums,0,nums.length - 1);
    }

    public static TreeNode helper(int[] nums , int start , int end){

        if(start<0 || end >= nums.length || start > end){
            return  null;
        }

        if(start == end){
            return new TreeNode(nums[start]);
        }

        int index = (start + end) / 2;
        TreeNode tree = new TreeNode(nums[index]);
        tree.left = helper(nums,start,index - 1);
        tree.right = helper(nums,index+1,end);
        return tree;
    }
}
