package competeTest.week.week4_17;

public class MinOperations {
	public static void main(String[] args) {
		System.out.println(minOperations(new int[]{1, 1, 1}));
		System.out.println(minOperations(new int[]{1,5,2,4,1}));
		System.out.println(minOperations(new int[]{8}));
	}
	public static int minOperations(int[] nums) {
		int res=0;
		int flag= 0;
		for (int i = 1; i < nums.length; i++) {
			flag=Math.max(nums[i-1]+1,++flag);
			if(nums[i]<flag){
				res+=flag-nums[i];
			}
		}
		return res;
	}
}
