package com.fulin.LinkedList;

import com.fulin.Utils.ListNode;

import java.util.Stack;

/**
 * Created by fulin on 18-2-8.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();

        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != null){
            stack1.push(currentA);
            currentA = currentA.next;
        }

        while(currentB != null){
            stack2.push(currentB);
            currentB = currentB.next;
        }
        ListNode result = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            currentA = stack1.pop();
            currentB = stack2.pop();

            if(currentA.val == currentB.val){
                result = currentA;
            }else{
                break;
            }
        }
        return result;
    }
}
