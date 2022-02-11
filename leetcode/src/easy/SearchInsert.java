package easy;

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		if(nums.length==0){
			return 1;
		}
		if(nums.length==1){
			if(target>nums[0]){
				return 1;
			}else {
				return 0;
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if(nums[0]==target){
				return 0;
			}
			if(nums[i]==target||(nums[i-1]<target&&target<nums[i])){
				return i;
			}
			if(target>nums[nums.length-1]){
				return nums.length;
			}
		}
		return 0;
	}
}
