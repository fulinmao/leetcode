package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Created by fulin on 18-1-30.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return  minDepth(root.right) + 1;
        }

        if(root.right == null){
            return minDepth(root.left) + 1;
        }

        return 1 + Math.min(minDepth(root.left) , minDepth(root.right));
    }
}
