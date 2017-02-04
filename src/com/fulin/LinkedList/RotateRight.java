package com.fulin.LinkedList;

/**
 * Created by fulin on 16-11-28.
 */
public class RotateRight {

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        ListNode result = rotateRight(list,3);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return head;
        }
        if(k <= 0){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        int length = 0;
        while(fast != null && count != k){
            fast = fast.next;
            count ++;
            length ++;
        }

        if(count != k){
            k = k % length;
            if(k == 0){
                return head;
            }
            fast = head;
            count = 0;
            while(fast != null && count != k){
                fast = fast.next;
                count ++;
            }
        }

        if(fast == null && count == k){
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode temp = head;
        fast.next = temp;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
