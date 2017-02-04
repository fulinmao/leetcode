package com.fulin.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,9,2,5,3,4};
		int result = lengthOfLIS(nums);
		System.out.println(result);
	}
	/**
	 * dp 
	 * @param nums
	 * @return
	 */
//	public int lengthOfLIS(int[] nums) {
//
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		int maxLength = 1;
//		int length = nums.length;
//		int[] dp = new int[length];
//		dp[0] = 1;
//		for (int i = 1; i < length; i++) {
//
//			for (int j = 0; j < i; j++) {
//				if (nums[j] < nums[i]) {
//					dp[i] = max(dp[j], dp[i]);
//				}
//			}
//			dp[i] = dp[i] + 1;
//			maxLength = max(maxLength, dp[i]);
//		}
//		return maxLength;
//
//	}
//
//	private int max(int a, int b) {
//		return a > b ? a : b;
//	}
	
	
	public static int lengthOfLIS(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int maxLength = 0;
		int length = nums.length;
		int[] tail = new int[length];
		tail[0] = nums[0];
		for(int i = 1 ; i< length ;i++){
			if(nums[i] > tail[maxLength]){
   				tail[++maxLength ] = nums[i];
			}else if(nums[i] < tail[0]){
				tail[0] = nums[i];
			}else{
				int index = binarySearch(tail , 0 ,maxLength ,nums[i]);
				tail[index] = nums[i];
			}
		}
		return maxLength + 1;
	}
	
	
	private static int binarySearch(int[] nums , int start , int end , int target){
		
		while(start <= end){
			int mid = (start + end) / 2;
			if(nums[mid] == target){
				return mid;
			}
			
			if(nums[mid] > target){
				end = mid - 1;
			}
			
			if(nums[mid] < target){
				start = mid + 1;
			}
		}
		return start;
		
	}
}
