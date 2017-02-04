package com.fulin.LinkedList;

import java.util.Arrays;

/**
 * Created by fulin on 16-11-26.
 */
public class MergeKLists {

    public static void main(String[] args){
        int[] lists = {12,3,3,3,3,3};
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int length =  lists.length;
        int mid = length / 2;
        ListNode[] temp1 = new ListNode[mid];
        ListNode[] temp2 = new ListNode[length - mid];

        System.arraycopy(lists,0,temp1,0,mid);
        System.arraycopy(lists,mid,temp2,0,length - mid);
        ListNode list1 = mergeKLists(temp1);
        ListNode list2 = mergeKLists(temp2);
        return mergeTwoListNode(list1,list2);

    }

    private ListNode mergeTwoListNode(ListNode list1 , ListNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }
        ListNode result = new ListNode(-1);
        ListNode resultPoint = result;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                resultPoint.next = list1;
                list1 = list1.next;
            }else{
                resultPoint.next = list2;
                list2 = list2.next;
            }
            resultPoint = resultPoint.next;
        }

        if(list1 == null){
            resultPoint.next = list2;
        }
        if(list2 == null){
            resultPoint.next = list1;
        }
        return result.next;
    }

}
