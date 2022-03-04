package normal;

import java.util.*;

public class SubArrayRanges {
    public static void main(String[] args) {
        SubArrayRanges subArrayRanges = new SubArrayRanges();
        System.out.println(subArrayRanges.subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges.subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(subArrayRanges.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    public long subArrayRanges(int[] nums) {
        //获取nums所有连续子序列
        HashSet<int[]> subArr = getSubArr(nums);
        //最大元素 index和最小元素index
        int res = 0;
        for (int[] integers : subArr) {
            res += getMaxDef(integers);
        }
        return res;
    }

    private HashSet<int[]> getSubArr(int[] arr) {
        HashSet<int[]> res = new HashSet<>();
        int l = 0, r = 0;
        while (l < arr.length) {
            if (r == arr.length) r = ++l;
            else {
                r++;
                res.add(Arrays.copyOfRange(arr, l, r));
            }
        }
        return res;
    }

    private int getMaxDef(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i : arr) {
            maxVal = Math.max(maxVal, i);
            minVal = Math.min(minVal, i);
        }
        return Math.abs(maxVal - minVal);
    }
}
