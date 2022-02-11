package easy;

import java.util.Arrays;

public class Search {
	public static void main(String[] args) {
		Search search = new Search();
		System.out.println(search.search(new int[]{5, 7, 7, 8, 8,8,10}, 8));
	}
	public int search(int[] nums, int target) {
		int res=0;
		for (int i = 0; i < nums.length; i++) {
			if (target==nums[i]){
				res++;
			}
		}
		return res;
	}
}
