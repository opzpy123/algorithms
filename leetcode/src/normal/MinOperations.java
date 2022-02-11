package normal;

public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int left=0,right=nums.length-1;
        int opeartoin = 0 ;
        while (left<right){
            if (x-nums[left]==0){
                opeartoin++;
            }
            if (x-nums[right]==0){
                opeartoin++;
            }
            if(x>0) {
                if(nums[left]>nums[right]){
                    x-=nums[left];
                    left++;
                }else {
                    right++;
                }
                opeartoin++;
            }
            if(x<0){
                return -1;
            }
        }
        return opeartoin;
    }
}
