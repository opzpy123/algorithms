package normal;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//		if(k==10000) return false;
//		for (int i = 0; i < nums.length ; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (Math.abs((long)nums[i] - (long) nums[j]) <= t && Math.abs(i - j) <= k) {
//					return true;
//				}
//			}
//		}
//		return false;
		int n = nums.length;
		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < n; i++) {
			Long ceiling = set.ceiling((long) nums[i] - (long) t);
			if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
				return true;
			}
			set.add((long) nums[i]);
			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;

	}
}
