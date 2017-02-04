package com.fulin.Array;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1};
		int target = 3;
		int result = search(nums , target);
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int length = nums.length;
		int result = -1;
		if (nums[0] <= nums[length - 1]) {
			// binary search
			result = binarySearch(nums, 0, length - 1, target);
			return result;
		}
		int pivot = 0;
		boolean isLeft = true;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				pivot = i;
				if(nums[i] == target){
					result = i;
					return result;
				}
				if (nums[i] < target && nums[0] > target) {
					isLeft = false;
				}
				break;
			}
		}
		if (isLeft) {
			result = binarySearch(nums, 0, pivot, target);
		} else {
			result = binarySearch(nums, pivot, length - 1, target);
		}

		return result;
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int result = -1;
		int low = start;
		int high = end;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (nums[mid] == target) {
				result = mid;
				break;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			}
			if (nums[mid] < target) {
				low = mid + 1;
			}

			mid = (low + high) / 2;
		}

		return result;
	}
}
