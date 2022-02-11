package normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
	public static void main(String[] args) {
		FindMaxLength findMaxLength = new FindMaxLength();
//		System.out.println(findMaxLength.findMaxLength(new int[]{0, 1}));
//		System.out.println(findMaxLength.findMaxLength(new int[]{0, 1, 0}));
//		System.out.println(findMaxLength.findMaxLength(new int[]{0,0,1,0,0,1,1,1}));
		System.out.println(findMaxLength.findMaxLength(new int[]{0,0,1,0,0,1,1,0}));
	}
	public int findMaxLength(int[] nums) {
		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int counter = 0;
		map.put(counter, -1);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (num == 1) {
				counter++;
			} else {
				counter--;
			}
			if (map.containsKey(counter)) {
				int prevIndex = map.get(counter);
				maxLength = Math.max(maxLength, i - prevIndex);
			} else {
				map.put(counter, i);
			}
		}
		return maxLength;

	}
}
