package easy;

public class MaxProfitII {
	public static void main(String[] args) {
		MaxProfitII maxProfitII = new MaxProfitII();
		System.out.println(maxProfitII.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
	public int maxProfit(int[] prices) {
		int[] dp = new int[prices.length];
		dp[0]=0;
		for (int i = 1; i < prices.length; i++) {
			dp[i]=Math.max(dp[i-1]+prices[i]-prices[i-1],dp[i-1]);
		}
		return dp[prices.length-1];
	}
}
