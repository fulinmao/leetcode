package com.fulin.LinkedList;

public class DeleteDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		deleteDuplicates(head);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
            return head;
        }
        
        ListNode fastPoint = head;
        ListNode currentPoint = head;
        while(currentPoint !=null){
            int val = currentPoint.val;
            while(fastPoint != null && val == fastPoint.val){
                fastPoint = fastPoint.next;
            }
            currentPoint.next = fastPoint;
            if(fastPoint != null){
            	fastPoint = currentPoint.next;
            }
            if(currentPoint != null){
                currentPoint = currentPoint.next;
            }
        }
        
        return head;
    }

}

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
