package com.fulin.LinkedList;

/**
 * Created by fulin on 16-11-27.
 */
public class SwapPairs {

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        ListNode result = swapPairs(list);

    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        if(head.next == null){
            return head;
        }
        ListNode currentPoint = head;
        ListNode nextPoint = head.next;
        head = nextPoint;
        while(currentPoint != null && nextPoint != null){

            currentPoint.next = nextPoint.next;
            nextPoint.next = currentPoint;

            if(currentPoint != null){
                currentPoint = currentPoint.next;
            }

            if(currentPoint !=null){
                nextPoint = currentPoint.next;
            }

        }
        return head;
    }
}
