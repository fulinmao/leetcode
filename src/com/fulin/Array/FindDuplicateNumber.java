package com.fulin.Array;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findDuplicate(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length;

		int mid = (low + high) / 2;
		while (low <= high) {
			int count = 0;
			for (int i = 0; i < nums.length ; i++) {
				if (nums[i] <= mid) {
					count++;
				}
			}

			if (count <= mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

			mid = (low + high) / 2;

		}
		return low;

	}
	
	
	public int findDuplicate2(int[] nums){
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = 0;
		int fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		int find = 0;
		while(find !=slow){
			find = nums[find];
			slow = nums[slow];
		}
		
		return find;
		
	}
}
