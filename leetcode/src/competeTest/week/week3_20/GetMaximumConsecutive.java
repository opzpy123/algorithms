package competeTest.week.week3_20;

import java.util.Arrays;

public class GetMaximumConsecutive {
	public static void main(String[] args) {
		GetMaximumConsecutive getMaximumConsecutive = new GetMaximumConsecutive();
		System.out.println(getMaximumConsecutive.getMaximumConsecutive(new int[]{1, 3}));
		System.out.println(getMaximumConsecutive.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
	}
	public int getMaximumConsecutive(int[] coins) {
		if(coins.length==0) return 1;
		if(coins.length==1) return 2;
		Arrays.sort(coins);
		int sum=0;
		int res=0;
		sum+=coins[0];
		for (int i = 1; i < coins.length; i++) {
			sum+=coins[i];
			for (int j = 0; j < coins.length; j++) {
				if(coins[j]==sum){
					res++;
				}
			}
		}
		return res+2;
	}
}
