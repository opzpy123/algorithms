package easy;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        largestSumAfterKNegations.largestSumAfterKNegations(new int[]{3,-1,0,2},3);
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            nums[i]=-nums[i];
            Arrays.sort(nums);
        }
        return Arrays.stream(nums).sum();
    }
}
