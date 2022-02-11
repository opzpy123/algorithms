package normal;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class LongestSubarray {
    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println("answer = " +longestSubarray.longestSubarray(new int[]{8,2,4,7}, 4));
        System.out.println("answer = " +longestSubarray.longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        System.out.println("answer = " +longestSubarray.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;

    }

    public int longestSubarray_超时(int[] nums, int limit) {
        //双指针滑动窗口
        int N = nums.length;
        int res = 0;
        int l = 0, r = 0;
        while (l <= N && r <= N) {
            int min=Integer.MAX_VALUE/2, max=Integer.MIN_VALUE/2;
            for (int i = l; i < r; i++) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
            if (Math.abs(max - min) <= limit) {
                res = Math.max(res,r-l);
            }
            if (r == N) {
                l++;
                r = l;
            }
            r++;
        }
        return res;
    }
}
