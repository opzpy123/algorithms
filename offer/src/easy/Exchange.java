package easy;

public class Exchange {
	public int[] exchange(int[] nums) {
		//双指针
		int n=nums.length;
		int l =0;
		int r =n-1;
		while (l<r){
			//寻找一个偶数
			while (l<r&&nums[l]%2!=0){
				l++;
			}
			//寻找一个奇数
			while (l<r&&nums[r]%2!=1){
				r--;
			}
			if(l<r){
				int t = nums[l];
				nums[l]=nums[r];
				nums[r]=t;
			}
		}
		return nums;
	}
}
