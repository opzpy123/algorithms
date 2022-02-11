package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        subarraysWithKDistinct.subarraysWithKDistinct(new int[]{1,2,1,2,3},2);
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] lower = new int[n], upper = new int[n];
        find(lower, nums, k);
        find(upper, nums, k - 1);
//         System.out.println(Arrays.toString(lower));
//         System.out.println(Arrays.toString(upper));
        int ans = 0;
        for (int i = 0; i < n; i++) ans += upper[i] - lower[i];
        return ans;
    }
    void find(int[] arr, int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int ans = 0;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            int right = nums[i];
            if (cnt[right] == 0) sum++;
            cnt[right]++;
            while (sum > k) {
                int left = nums[j++];
                cnt[left]--;
                if (cnt[left] == 0) sum--;
            }
            arr[i] = j;
        }
    }
}
