package normal;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Search {
	public static void main(String[] args) {
//		search(new int[]{2,5,6,0,0,1,2},2);
		search(new int[]{2,2,2,3,2,2,2},3);
	}

	public static boolean search(int[] nums, int target) {
		if(nums.length==1&&nums[0]==target) return true;
		int k = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]<nums[i-1]){
				k=i-1;
				break;
			}
		}
		if(target<=nums[k]&&target>=nums[0]){
//			0-k搜索
			for (int i = 0; i <= k; i++) {
				if(target==nums[i]){
					return true;
				}
			}
		}else{
//			(k+1)-(nums.length-1)搜索
			for (int i = k+1; i <nums.length ; i++) {
				if(target==nums[i]){
					return true;
				}
			}
		}
		return false;
	}
}
