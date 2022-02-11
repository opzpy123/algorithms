package hard;

import java.util.*;

public class SlidingWindows {
    //动态规划
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        //主逻辑
        int [] left = new int[n];
        int [] right = new int[n];
        //初始化边界条件
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        //{1,3,-1,-3,5,3,6,7},3
        for (int i = 1; i < n; i++) {
            // 当前块从左1往右 左0为边界条件
            if (i % k == 0) left[i] = nums[i];  // 当前值撞k块边界了 就取当前值
            else left[i] = Math.max(left[i - 1], nums[i]);//判断当前块中最大元素是当前元素还是上一个元素

            // 当前块从右n-2往左 右n-1为边界条件(n越界) 判断当前块中最大元素是当前元素还是上一个元素吗
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // 当前值撞k块边界了 就取当前值
            else right[j] = Math.max(right[j + 1], nums[j]);//判断当前块中最大元素是当前元素还是上一个元素
        }

        //遍历获取每一位最大值
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }


    //双端队列
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }





    //暴力法
    public  static  int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;

    }

    public static void main(String[] args) {
        maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
