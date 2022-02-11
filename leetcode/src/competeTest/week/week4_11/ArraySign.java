package competeTest.week.week4_11;

public class ArraySign {
	public static void main(String[] args) {
		ArraySign arraySign = new ArraySign();
		System.out.println(arraySign.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
		System.out.println(arraySign.arraySign(new int[]{1,5,0,2,-3}));
		System.out.println(arraySign.arraySign(new int[]{-1,1,-1,1,-1}));
	}

	public int arraySign(int[] nums) {
		int flag=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) return 0;
			if(nums[i]<0)flag++;
		}
		return flag%2==0?1:-1;
	}
}
