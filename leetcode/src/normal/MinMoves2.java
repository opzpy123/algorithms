package normal;

import java.util.Arrays;

public class MinMoves2 {
    public static void main(String[] args) {
        MinMoves2 minMoves2 = new MinMoves2();
        minMoves2.minMoves2(new int[]{1,2,3});
        minMoves2.minMoves2(new int[]{1,2,50,3999});
    }
    public int minMoves2(int[] nums) {
        //排序 求中位数
        int res=0;
        Arrays.sort(nums);
        int expectNum = nums[nums.length / 2];
        for(int i=0;i<nums.length;i++){
            res+=Math.abs(nums[i]-expectNum);
        }
        return res;
    }
}
