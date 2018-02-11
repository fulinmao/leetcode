package com.fulin.LinkedList;


import com.fulin.Utils.ListNode;

public class AddTwoNumbers {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [2,4,3]
		// [5,6,4]
		
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
//		l1.next.next = new ListNode(6);
		
		
		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);
		addTwoNumbers(l1,l2);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode l1Point = l1;
		ListNode l2Point = l2;
		boolean flag = false;

		int l1Val = l1Point.val;
		int l2Val = l2Point.val;
		int sum = l1Val + l2Val;
		if (sum >= 10) {
			flag = true;
		} else {
			flag = false;
		}

		ListNode result = new ListNode(sum % 10);
		ListNode resultPoint = result;
		l1Point = l1Point.next;
		l2Point = l2Point.next;
		while (l1Point != null && l2Point != null) {
			l1Val = l1Point.val;
			l2Val = l2Point.val;
			sum = l1Val + l2Val;
			if (flag) {
				sum = sum + 1;
			}
			if (sum >= 10) {
				flag = true;
			} else {
				flag = false;
			}
			ListNode temp = new ListNode(sum % 10);
			resultPoint.next = temp;
			l1Point = l1Point.next;
			l2Point = l2Point.next;
			resultPoint = resultPoint.next;
		}

		if (l1Point == null) {
			while (l2Point != null) {
				sum = l2Point.val;
				if (flag) {
					sum = sum + 1;
				}
				if (sum >= 10) {
					flag = true;
				} else {
					flag = false;
				}
				ListNode temp = new ListNode(sum % 10);
				resultPoint.next = temp;
				l2Point = l2Point.next;
				resultPoint = resultPoint.next;
			}

		}

		if (l2Point == null) {
			while (l1Point != null) {
				sum = l1Point.val;
				if (flag) {
					sum = sum + 1;
				}
				if (sum >= 10) {
					flag = true;
				} else {
					flag = false;
				}
				ListNode temp = new ListNode(sum % 10);
				resultPoint.next = temp;
				l1Point = l1Point.next;
				resultPoint = resultPoint.next;
			}
		}
		if(flag){
			if(resultPoint != null){
				resultPoint.next = new ListNode(1);
			}else{
				result.next = new ListNode(1);
			}
		}
		return result;
	}
}
