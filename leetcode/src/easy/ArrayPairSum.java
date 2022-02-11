package easy;

import java.util.Arrays;

public class ArrayPairSum {
    public static void main(String[] args) {
        ArrayPairSum arrayPairSum = new ArrayPairSum();
        System.out.println(arrayPairSum.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPairSum.arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            res+=nums[i];  //排序后，偶数都是当前[2]窗口的最小值
        }
        return  res;
    }
}
