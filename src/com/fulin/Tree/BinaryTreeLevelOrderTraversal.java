package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Created by fulin on 18-2-1.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        List<Integer> tempList = null;
        if(root != null){
            queue1.offer(root);
        }
        while(queue1.size() != 0){
            tempList = new ArrayList<Integer>();
            while(queue1.size() !=0){
                TreeNode t = queue1.poll();
                tempList.add(t.val);
                if(t.left != null){
                    queue2.offer(t.left);
                }
                if(t.right != null){
                    queue2.offer(t.right);
                }
            }
            result.add(tempList);
            // 将queue2中的元素全部移动到queue1中
            while(queue2.size() != 0){
                queue1.offer(queue2.poll());
            }
        }

        return result;
    }
}
