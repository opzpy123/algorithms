package normal;

public class MaxProductI {
	public static void main(String[] args) {
		MaxProductI maxProductI = new MaxProductI();
		System.out.println(maxProductI.maxProduct(new int[]{2, 3, -2, 4}));
		System.out.println(maxProductI.maxProduct(new int[]{-2, 0, -1}));
		System.out.println(maxProductI.maxProduct(new int[]{0, 2}));
	}

	public int maxProduct(int[] nums) {
		int n = nums.length;
		if(n == 0){
			return 0;
		} else if(n == 1) {
			return nums[0];
		}
		int p = nums[0];
		int maxP = nums[0];
		int minP = nums[0];
		for(int i = 1; i < n; i++) {
			int t = maxP;
			maxP = Math.max(Math.max(maxP * nums[i], nums[i]), minP *nums[i]);
			minP = Math.min(Math.min(t * nums[i], nums[i]), minP * nums[i]);
			p = Math.max(maxP, p);
		}
		return p;


	}
}
