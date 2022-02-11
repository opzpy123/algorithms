package hard;

public class FindMin {
	public int findMin(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res=Math.min(res,nums[i]);
		}
		return res;
	}
}
