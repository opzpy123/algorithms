package normal;

public class LastStoneWeightII {
	public int lastStoneWeightII(int[] stones) {
		int sum =0;
		for (int i = 0; i < stones.length; i++) {
			sum+=stones[i];
		}
		int n = stones.length;
		int[] dp  = new int[sum/2+1];
		for (int i = 0; i < n; ++i) {
			for (int j = sum / 2; j >= stones[i]; --j) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return sum-2*dp[sum/2];
	}
}
