package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleNumber {
	public static void main(String[] args) {
		TriangleNumber triangleNumber = new TriangleNumber();
		System.out.println(triangleNumber.triangleNumber(new int[]{2, 2, 3, 4}));
		System.out.println(triangleNumber.triangleNumber(new int[]{1, 2, 3, 4, 5, 6}));
	}
	public int triangleNumber(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			int k = i;
			for (int j = i + 1; j < n; ++j) {
				while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
					++k;
				}
				ans += Math.max(k - j, 0);
			}
		}
		return ans;
	}



}
