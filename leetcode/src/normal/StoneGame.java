package normal;

public class StoneGame {
	public static void main(String[] args) {
		stoneGame(new int[]{5,3,4,5});
	}
	public static boolean stoneGame(int[] piles) {
		int[][] dp = new int[piles.length+1][piles.length+1];
		for (int i=1; i<=piles.length; ++i){    // 只有一堆石头时，先手能领先的最大分值就是这堆石头的数量。
			dp[i][i] = piles[i-1];
		}
		for (int len=1; len<=piles.length; ++len){  // 先遍历区间长度
			for (int i=1; i+len<=piles.length; ++i){
				int j = i+len;
				dp[i][j] = Math.max(piles[j-1]-dp[i][j-1], piles[i-1]-dp[i+1][j]);
			}
		}
		return dp[1][piles.length]>=0;
	}
}
