package normal;

public class MovesToMakeZigzag {
    public static void main(String[] args) {
        MovesToMakeZigzag movesToMakeZigzag = new MovesToMakeZigzag();
        System.out.println(movesToMakeZigzag.movesToMakeZigzag(new int[]{1, 2, 3}));
        System.out.println(movesToMakeZigzag.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

}
