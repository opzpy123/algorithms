package normal;

public class MaxScoreSightseeingPair {
	public static void main(String[] args) {
		MaxScoreSightseeingPair maxScoreSightseeingPair = new MaxScoreSightseeingPair();
		System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
		System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{1,2}));
		System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{1,3}));
	}

	public int maxScoreSightseeingPair(int[] values) {
		int len = values.length;
		int[] v = new int[len - 1];
		v[len - 2] = values[len - 1] - len + 1;
		for (int i = len - 3; i >= 0; i--) {
			v[i] = Math.max(values[i + 1] - i - 1, v[i + 1]);
		}
		int[] dp = new int[len - 1];
		int ans = 0;
		for (int i = 0; i < len - 1; i++) {
			dp[i] = values[i] + i + v[i];
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
}
