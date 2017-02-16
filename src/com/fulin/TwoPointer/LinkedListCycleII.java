package com.fulin.TwoPointer;

import com.fulin.Utils.ListNode;

/**
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Created by fulin on 17-2-16.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }

        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
