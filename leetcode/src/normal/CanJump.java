package normal;

public class CanJump {

    public static void main(String[] args) {

        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
    }
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int[] dp =  new int[len];

        dp[0] = 1;
        dp[1] = nums[0];
        for (int i = 2; i < len; i++) {
            if (dp[i-1] >= 1) {
                dp[i] = Math.max(dp[i-1] -1, nums[i-1]);
            } else {
                dp[i] = 0;
            }
        }

        return dp[len - 1] >= 1;

    }
}
