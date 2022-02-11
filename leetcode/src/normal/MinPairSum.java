package normal;

import java.util.Arrays;

public class MinPairSum {
	public static void main(String[] args) {
		MinPairSum minPairSum = new MinPairSum();
		System.out.println(minPairSum.minPairSum(new int[]{3, 5, 2, 3}));
		System.out.println(minPairSum.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
	}

	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		int res = 0;
		while (l < r)
			res = Math.max(res, nums[l++] + nums[r--]);
		return res;

	}
}
