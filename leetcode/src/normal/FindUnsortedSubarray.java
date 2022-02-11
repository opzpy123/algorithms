package normal;

import java.util.ArrayList;
import java.util.Arrays;

public class FindUnsortedSubarray {
	public static void main(String[] args) {
		FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
		System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
		System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1,2,3,4}));
		System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1}));
	}
	public int findUnsortedSubarray(int[] nums) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		if(Arrays.equals(copy, nums))return 0;
		int l =0,r=copy.length-1;
		while (l<=r){
			if(nums[l]==copy[l])l++;
			if(nums[r]==copy[r])r--;
			if(nums[l]!=copy[l]&&nums[r]!=copy[r]){
				break;
			}
		}
		return r-l+1;
	}
}
