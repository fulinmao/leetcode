package com.fulin.HashTable;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
	
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        Map<RandomListNode , RandomListNode> map = new HashMap<RandomListNode , RandomListNode>(); 
        RandomListNode result = new RandomListNode(head.label);
        map.put(head,result);
        RandomListNode resultPoint = null;;
        RandomListNode headPoint = head.next;
        RandomListNode temp = result;
        
        while(headPoint != null){
            resultPoint = new RandomListNode(headPoint.label);
            temp.next = resultPoint;
            map.put(headPoint,resultPoint);
            temp = temp.next;
            headPoint = headPoint.next;
        }
        
        resultPoint = result;
        headPoint = head;
        
        while(resultPoint != null){
            resultPoint.random = map.get(headPoint.random);
            headPoint = headPoint.next;
            resultPoint = resultPoint.next;
        }
        
        return result;
    }
}
