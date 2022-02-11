package normal;

import java.util.Arrays;

public class PartitionDisjoint {
	public static void main(String[] args) {
		Object a =2;
		PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
		System.out.println(partitionDisjoint.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
		System.out.println(partitionDisjoint.partitionDisjoint(new int[]{1,1,1,0,6,12}));
	}
	public int partitionDisjoint(int[] nums) {
		//前后缀最值 O(n)
		int[] suffix = Arrays.copyOf(nums,nums.length);
		int[] prefix = Arrays.copyOf(nums,nums.length);
		int n = suffix.length;
		for (int i = n-2; i >=0 ; i--) {
			suffix[i]=Math.min(suffix[i],suffix[i+1]);
		}
		for (int i = 1; i < n; i++) {
			prefix[i]=Math.max(prefix[i],prefix[i-1]);
			if (prefix[i-1] <= suffix[i]) return i;
		}
		return -1;
	}
}
