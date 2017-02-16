package com.fulin.TwoPointer;

import com.fulin.Utils.ListNode;

/**
 * Created by fulin on 17-2-16.
 */
public class PalindromeLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);

        ListNode head1 = new ListNode(1);
//        head1.next = new ListNode(0);
//        head1.next.next = new ListNode(1);
        head.next.next.next = head1;
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        boolean result = true;;
        ListNode fast = head;
        ListNode slow = head;

        if(fast ==null || fast.next == null){
            return result;
        }

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            //偶数个节点
            slow = reverseListNode(slow);
        }else{
            //奇数个节点
            slow.next = reverseListNode(slow.next);
            slow = slow.next;
        }

        while(slow != null){
            if(head.val != slow.val){
                result = false;
                break;
            }
            slow = slow.next;
            head = head.next;
        }

        return result;
    }

    private static ListNode reverseListNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head.next;
        ListNode first = head;
        first.next = null;
        while(current != null){
            ListNode temp = current.next;
            current.next = first;
            first = current;
            current = temp;
        }

        head = first;
        return head;
    }
}
