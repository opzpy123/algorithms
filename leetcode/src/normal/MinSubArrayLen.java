package normal;

import java.util.Arrays;

public class MinSubArrayLen {
	public int minSubArrayLen(int target, int[] nums) {
		int i = 0;
		int sum = 0;
		int len = 0;
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j];
			while (sum >= target) {
				len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
				sum -= nums[i++];
			}
		}
		return len;

	}
}
