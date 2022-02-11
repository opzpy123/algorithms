package easy;

public class CheckPossibility {
    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        System.out.println(checkPossibility.checkPossibility(new int[]{4, 2, 3}));//true
//        System.out.println(checkPossibility.checkPossibility(new int[]{4, 2, 1}));//false
//        System.out.println(checkPossibility.checkPossibility(new int[]{7,3,6324,6,21}));//false
//        System.out.println(checkPossibility.checkPossibility(new int[]{5,4,3,2,1}));//false
        System.out.println(checkPossibility.checkPossibility(new int[]{3,4,2,3}));//false
    }

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int flag=0;
        for(int i=0;i<len-1&&flag<2;i++){
            if(nums[i]>nums[i+1]){
                flag++;
            }
        }
        return flag<=1;
    }
}
