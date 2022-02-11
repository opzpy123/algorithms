package normal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class DeleteAndEarn {
	public static void main(String[] args) {
		deleteAndEarn(new int[]{3,4,2});
	}
	public static int deleteAndEarn(int[] nums) {
		int[] arr = new int[10001];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]+=nums[i];
		}
		int[] dp = new int[10001];
		dp[0]=0;
		dp[1]=arr[1];
		for (int i = 2; i < arr.length; i++) {
			dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
		}
		return dp[dp.length-1];
	}
}
