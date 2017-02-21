package com.fulin.TwoPointer;

import com.fulin.Utils.ListNode;


/**
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * Created by fulin on 17-2-21.
 */
public class PartitionList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);

        ListNode result = partition(head , 0);
    }


    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode lessNode = new ListNode(-1);
        ListNode greatNode = new ListNode(-1);

        ListNode index1 = lessNode;
        ListNode index2 = greatNode;

        ListNode current = head;
        while(current != null){
            if(current.val < x){
                index1.next = current;
                index1 = index1.next;
                // index1.next = null;
            }else{
                index2.next = current;
                index2 = index2.next;
                // index2.next = null;
            }

            current = current.next;
        }
        index2.next = null;
        index1.next = greatNode.next;
        return lessNode.next;
    }
}
