package com.fulin.Array;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1000 , -2};
		firstMissingPositive(nums);
	}

	public static int firstMissingPositive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 1;
		}
		int position = 0;
		int length = nums.length;
		while (position < length) {

			if (nums[position] > 0 && (nums[position] != position + 1) && nums[position] <= length
					&& nums[position] != nums[nums[position] - 1]) {
				swap(nums, position, nums[position] - 1);
			} else {
				position++;
			}

		}
		int result = 0;
		int i = 0;
		for (i = 0; i < length; i++) {
			if (nums[i] <= 0 || nums[i] != (i + 1)) {
				result = i + 1;
				break;
			}
		}
		if ((i == length) && (result == 0)) {
			result = length + 1;
		}
		return result;

	}

	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
