package competeTest.week.week4_17;

import java.util.Arrays;

public class GetMaximumXor {
	public static void main(String[] args) {
//		System.out.println((int) Math.pow(2, 1));
		System.out.println(Arrays.toString(getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
		System.out.println(Arrays.toString(getMaximumXor(new int[]{0,1,1,3}, 2)));
		System.out.println(Arrays.toString(getMaximumXor(new int[]{0,1,2,2,5,7}, 3)));
		System.out.println(Arrays.toString(getMaximumXor(new int[]{0}, 1)));
		System.out.println(5^2);

	}

	public static int[] getMaximumXor1(int[] nums, int maximumBit) {
		//暴力 超时
		int n = nums.length;
		int target = (int)Math.pow(2,maximumBit)-1;
		int index=n-1;
		int[] res = new int[n];
		int xor = nums[0];
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j <= target; j++) {
				int temp=xor ^ j;
				if (temp == target) {
					res[index--]=j;
				}
			}
			xor=xor^nums[i];
		}
		int temp=nums[0];
		for (int i = 1; i <n; i++) {
			temp = nums[i]^temp;
		}
		for (int i = 0; i <=target; i++) {
			int temp2 = temp^i;
			if(temp2==target){
				res[0]=i;
			}
		}
		return res;
	}
	public static int[] getMaximumXor(int[] nums, int maximumBit) {
		int n = nums.length;
		int target = (int)Math.pow(2,maximumBit)-1;

		//使用数组保存前n项的异或结果
		int[] xorArr = new int[n];
		xorArr[0]=nums[0];
		for (int i = 1; i < n; i++) {
			int temp = xorArr[i-1]^nums[i];
			xorArr[i]=temp;
		}

		//根据异或性质 target异或上面xor数组 得到res
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[n-i-1]=target^xorArr[i];
		}
		return res;
	}
}
