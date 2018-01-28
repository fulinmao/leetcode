package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

/**
 * Created by fulin on 18-1-27.
 */
public class SymmetricTree {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);

        boolean result = isSymmetric(tree);
        System.out.println(result);
    }

    /**
     * 判断一颗树是否为一个颗镜像树：
     *  （1）左右节点数值相等
     *  （2）左子树的左节点和右子树的右节点值相等  并且 左子树的右节点与右子树的左节点相等
     * @param root
     * @return
     */
    public static  boolean isSymmetric(TreeNode root) {
        boolean result = false;

        if(root == null){
            result  = true;
            return result;
        }

        result = helper(root.left,root.right);
        return result;
    }

    /**
     *  判断一颗树是否为一个颗镜像树：
     *  （1）左右节点数值相等
     *  （2）左子树的左节点和右子树的右节点值相等  并且 左子树的右节点与右子树的左节点相等
     * @param left
     * @param right
     * @return
     */
    private static boolean helper(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return helper(left.left , right.right) && helper(left.right , right.left);
    }
}
