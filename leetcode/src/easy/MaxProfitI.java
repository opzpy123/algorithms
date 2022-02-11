package easy;

public class MaxProfitI {
	public static void main(String[] args) {
		MaxProfitI maxProfitI = new MaxProfitI();
		System.out.println(maxProfitI.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}

	public int maxProfit(int[] prices) {
		int[] dp = new int[prices.length];
		dp[0] = 0;
		int MinPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			MinPrice = Math.min(MinPrice, prices[i]);
			dp[i] = Math.max(dp[i-1],prices[i]-MinPrice);
		}
		return dp[prices.length-1];
	}
}
