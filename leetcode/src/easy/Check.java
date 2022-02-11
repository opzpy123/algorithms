package easy;

import java.util.*;

public class Check {
    public static void main(String[] args) {
        Check check = new Check();
        System.out.println(check.check(new int[]{3, 4, 5, 1, 2, 3, 4, 1, 2, 3}));
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        // 特殊处理, 若输入数组为递增, 即等于源数组, 那么count == 0, 返回true
        return nums[n - 1] <= nums[0] || count == 0;
    }
}
