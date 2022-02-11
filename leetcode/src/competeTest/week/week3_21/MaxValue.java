package competeTest.week.week3_21;

public class MaxValue {
	public static void main(String[] args) {
		maxValue(4,2,6);
	}
	public static int maxValue(int n, int index, int maxSum) {
		int[] num = new int[n];
		for (int i = n-1; i >=1 ; i++) {
			num[index]=i;
			if(maxSum-i>n-1){
				//满足条件nums[index] 的值被 最大化 且剩余的够分
				System.out.println(num[index]);
			}
		}
		return 0;
	}
}
