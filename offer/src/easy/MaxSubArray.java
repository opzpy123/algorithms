package easy;

import java.util.Arrays;

public class MaxSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		System.out.println(maxSubArray(new int[]{1}));
		System.out.println(maxSubArray(new int[]{-2,1}));
	}
	public static int maxSubArray(int[] nums) {
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			//0表示不取这个值
			nums[i] += Math.max(nums[i - 1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;

	}
}
