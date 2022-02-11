package competeTest.week.week3_21;

public class MaxAscendingSum {
	public static void main(String[] args) {
		MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
		System.out.println(maxAscendingSum.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
		System.out.println(maxAscendingSum.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
		System.out.println(maxAscendingSum.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
		System.out.println(maxAscendingSum.maxAscendingSum(new int[]{9,1,3,4}));
	}
	public int maxAscendingSum(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int max=nums[0];
		int res=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]>nums[i-1]){
				max+=nums[i];
				res=Math.max(res,max);
			}else {
				max=nums[i];
			}
		}
		if(res==nums[0]){
			for (int i = 0; i < nums.length; i++) {
				res=Math.max(nums[i],res);
			}
		}
		return res;
	}

}
