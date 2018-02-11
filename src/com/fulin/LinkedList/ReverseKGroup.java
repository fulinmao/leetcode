package com.fulin.LinkedList;

import com.fulin.Utils.ListNode;

import java.util.Calendar;
import java.util.Stack;

/**
 * Created by fulin on 16-11-27.
 */
public class ReverseKGroup {

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        System.out.println(Calendar.getInstance().getTime().getTime());
        ListNode result = reverseKGroup(list,2);
        System.out.println(Calendar.getInstance().getTime().getTime());

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }

        if(k < 2){
            return head;
        }
        int cnt = 0;
        ListNode current = head;
        while(current != null && cnt != k){
            current = current.next;
            cnt ++ ;
        }

        if(cnt == k){
            current = reverseKGroup(current,k);

            for (int i=0;i<k;i++){
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }

            head = current;
        }

        return head;
    }

    /**
     * Time limited exceeded
     */

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null){
//            return head;
//        }
//        if(k < 2){
//            return head;
//        }
//        ListNode headPoint  = head;
//        ListNode result = new ListNode(-1);
//        ListNode current = result;
//        ListNode temp = new ListNode(-1);
//        ListNode tempPoint = temp;
//        while(headPoint != null){
//            boolean flag = false;
//            for(int i=0;i<k;i++){
//                if(headPoint!= null){
//                    tempPoint.next = headPoint;
//                    headPoint = headPoint.next;
//                    tempPoint = tempPoint.next;
//                }else{
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag){
//                current.next = temp.next;
//            }else{
//                current.next = reverseListNode(temp.next);
//            }
//        }
//
//
//        return result.next;
//    }
//
//
//    private static ListNode reverseListNode(ListNode listNode){
//        if(listNode == null){
//            return null;
//        }
//        ListNode result = new ListNode(-1);
//        ListNode current = result;
//        Stack<ListNode> statck = new Stack<ListNode>();
//        while (listNode != null){
//            statck.push(listNode);
//            listNode = listNode.next;
//        }
//        while(!statck.empty()){
//            current.next = statck.pop();
//            current = current.next;
//        }
//        return result.next;
//    }
}
