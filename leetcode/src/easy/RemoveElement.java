package easy;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[]{2, 2, 2, 2, 2, 2, 1}, 2));
    }

    /**
     * 高明思路
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }

    public int removeElement(int[] nums, int val) {
        //先搞定返回值
        int ret = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                ret--;
            }
        }
        //修改原数组
        int index = 0;
        while (index < nums.length) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == val) {
                    swap(nums, i, i + 1);
                }
            }
            index++;
        }

//        System.out.println(Arrays.toString(nums));
        return ret;
    }

    //swap方法
    public void swap(int[] nums, int index_1, int index_2) {
        int temp = nums[index_1];
        nums[index_1] = nums[index_2];
        nums[index_2] = temp;

    }
}
