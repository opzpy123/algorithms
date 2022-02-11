package easy;

public class CountKDifference {
    public static void main(String[] args) {
        CountKDifference countKDifference = new CountKDifference();
        System.out.println(countKDifference.countKDifference(new int[]{1, 2, 2, 1}, 1));
    }
    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(Math.abs(nums[i]-nums[j])==k)res++;
            }
        }
        return res;
    }

}
