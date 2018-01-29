package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

/**
 * Created by fulin on 18-1-29.
 */
public class BalancedBinaryTree {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(10);
        right.right = new TreeNode(7);

        tree.right = right;

        boolean result = isBalanced(tree);
        System.out.println(result);
    }



    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) >=2){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode tree){
        if(tree == null){
            return 0;
        }
        return 1 + Math.max(height(tree.left) , height(tree.right));
    }
}
