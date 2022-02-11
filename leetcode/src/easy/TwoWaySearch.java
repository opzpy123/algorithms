package easy;

public class TwoWaySearch {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
        int[] nums = new int[]{6};
        System.out.println(search(nums, 6));
    }
    public static int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]>target)r=mid-1;
            else if(nums[mid]<target)l=mid+1;
            else return mid;
        }
        return-1;
    }
}
