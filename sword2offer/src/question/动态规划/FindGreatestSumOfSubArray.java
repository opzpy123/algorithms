package question.动态规划;

import java.util.Arrays;

/**
 * 描述
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 数据范围:
 * 1 <= n <= 10^51<=n<=10
 * 5
 * <p>
 * -100 <= a[i] <= 100−100<=a[i]<=100
 * <p>
 * 要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
 * 进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {

        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        System.out.println(findGreatestSumOfSubArray.FindGreatestSumOfSubArray1(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
        System.out.println(findGreatestSumOfSubArray.sumOfSubArr(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }

    private int sumOfSubArr(int[] arr) {
        //连续子数组最大和
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length + 1];
        dp[0] = Math.max(arr[0], 0);
        int max = 0;
        for (int i = 1; i <arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public int FindGreatestSumOfSubArray0(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            int temp = array[i];
            int j = i - 1;
            while (j >= 0) {
                temp += array[j];
                max = Math.max(max, temp);
                j--;
            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int max = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int FindGreatestSumOfSubArray2(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
