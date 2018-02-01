package com.fulin.Tree;

import com.fulin.Utils.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Created by fulin on 18-2-1.
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args){
        TreeNode t = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        t.left = left;
        t.right = right;
        List<List<Integer>> result = levelOrderBottom(t);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        List<Integer> tempList = null;
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
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
            stack.push(tempList);
            // 将queue2中的元素全部移动到queue1中
            while(queue2.size() != 0){
                queue1.offer(queue2.poll());
            }
        }

        while(stack.size() !=0){
            tempList = stack.pop();
            result.add(tempList);
        }
        return result;
    }
}
