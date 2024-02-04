package hard;

public class TrappingRain {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //https://juejin.cn/post/7323271675331084315
    //我们可以通过预处理数组得到leftMax[]和rightMax[]两个数组，
    // leftMax[i]代表数组0到i位置的最大值，leftMax[i] = max(leftMax[i-1], arr[i])；
    // rightMax[i]代表数组i位置到n-1位置的最大值，rightMax[i] = max(rightMax[i+1], arr[i])。
    //
    //这样我们就得到了如下的算法流程。
    //
    //首先遍历数组，从左向右得到数组leftMax[]，再从右向左得到rightMax[]。
    // 然后再遍历一遍数组，对于数组的每一个位置i，通过leftMax[i]，rightMax[i]和arr[i]得到结果，
    // 将结果汇总得到的值就是最终答案。
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int rst = 0;
        for (int i = 0; i < n; i++) {
            rst += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return rst;
    }

}
