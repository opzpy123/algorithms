package easy;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        MinimumDifference minimumDifference = new MinimumDifference();
        System.out.println(minimumDifference.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
