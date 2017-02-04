package com.fulin.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IntersectionTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] result = intersection(nums1,nums2);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null ||  nums2 == null){
			return null;
		}
		
		int[] result = {};
		if(nums1.length ==0 && nums2.length == 0){
			return result;
		}
		List<Integer> nums1List = new ArrayList<Integer>();
		List<Integer> nums2List = new ArrayList<Integer>();
		for(int i=0;i<nums1.length;i++){
			nums1List.add(nums1[i]);
		}
		for(int i=0;i<nums2.length;i++){
			nums2List.add(nums2[i]);
		}
		
		nums1List.retainAll(nums2List);
		
		
		// remove the same element
		HashSet<Integer> resultSet = new HashSet<Integer>(nums1List);
		result = new int[resultSet.size()];
		Iterator <Integer> iterator = resultSet.iterator();
		int index = 0 ;
		while(iterator.hasNext()){
			result[index ++] = iterator.next();
		}
		return result;
    }
	
}
