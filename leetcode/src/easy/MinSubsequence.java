package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinSubsequence {
    public static void main(String[] args) {
        MinSubsequence minSubsequence = new MinSubsequence();
        System.out.println(minSubsequence.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(minSubsequence.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(minSubsequence.minSubsequence(new int[]{6}));
    }

    public List<Integer> minSubsequence(int[] nums) {
        //nums 升序排序
        Arrays.parallelSort(nums);
        //计算每一位到之前的大小
        ArrayList<Integer> sumList = new ArrayList<>();

        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(numList);

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            sumList.add(nums[i] + pre);
            pre += nums[i];
        }
        Collections.reverse(sumList);

        int preSum = 0;
        int idx = -1;
        for (int i = 0; i < numList.size(); i++) {
            preSum += numList.get(i);
            if (preSum >= sumList.get(i)) {
                idx = i;
                break;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (idx == -1) {
            return null;
        } else {
            for (int i = 0; i <= idx; i++) {
                res.add(numList.get(i));
            }
            return res;
        }
    }
}
