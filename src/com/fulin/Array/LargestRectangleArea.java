package com.fulin.Array;

import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {4,2};
		int result = largestRectangleArea(heights);
		System.out.println(result);
	}

	public static int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}
		if (heights.length == 1) {
			return heights[0];
		}

		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < heights.length; i++) {
			if (stack.empty() || heights[i] > stack.peek()) {
				stack.push(heights[i]);
			} else {
				int count = 0;
				while ((!stack.empty()) && heights[i] < stack.peek()) {
					count++;
					max = max(max, stack.peek() * count);
					stack.pop();
				}

				while (count > 0) {
					count--;
					stack.push(heights[i]);
				}

				stack.push(heights[i]);
			}
		}

		int count = 1;
		while (!stack.empty()) {
			max = max(max, count * stack.peek());
			stack.pop();
			count++;
		}

		return max;
	}

	/**
	 * return max num
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}

}
