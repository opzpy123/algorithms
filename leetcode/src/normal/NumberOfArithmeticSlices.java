package normal;

public class NumberOfArithmeticSlices {
	public static void main(String[] args) {
		NumberOfArithmeticSlices n = new NumberOfArithmeticSlices();
		System.out.println(n.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
	}

	public int numberOfArithmeticSlices(int[] nums) {
		//连续序列
		if(nums.length<3)return 0;
		int dp = 0, sum = 0, def1 = nums[1] - nums[0];
		for (int i = 2; i < nums.length; i++) {
			int def2 = nums[i] - nums[i - 1];
			if (def2 == def1) {
				sum += (++dp);
			} else {
				dp = 0;
			}
			def1 = def2;
		}
		return sum;
	}
}
