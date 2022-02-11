package compete;

import java.util.Arrays;

public class MinSailCost {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                {0, 1, 1},
                {1, 2, 0},
                {0, 1, 2}};
        int[][] arr2 = new int[][]{
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 2, 1, 1},
                {0, 2, 0, 0, 1}};
        MinSailCost minSailCost = new MinSailCost();
        System.out.println(minSailCost.minSailCost(arr1));
        System.out.println(minSailCost.minSailCost(arr2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算最小航行费用
     *
     * @param input int整型二维数组 二维网格
     * @return int整型
     */
    public int minSailCost(int[][] input) {
        // write code here
        //二维dp 从左上角到右下角

        int[][] dp = new int[input.length][input[0].length];
        dp[0][0] = 0;
        for (int i = 1; i < input.length; i++) {
            dp[i][0] = dp[i - 1][0] + getValue(input, i, 0);
        }
        for (int i = 1; i < input[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + getValue(input, 0, i);
        }
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                int value = getValue(input, i, j);
                if (value == -1) {
                    dp[i][j] = -1;
                } else {
                    if (dp[i - 1][j] == -1 && dp[i][j - 1] != -1) {
                        dp[i][j] = dp[i][j - 1] + value;
                    } else if (dp[i][j - 1] == -1 && dp[i - 1][j] != -1) {
                        dp[i][j] = dp[i - 1][j] + value;
                    } else if (dp[i][j - 1] != -1 && dp[i - 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + value;
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }
        return dp[input.length - 1][input[0].length - 1];
    }

    private int getValue(int[][] inputint, int col, int row) {
        if (inputint[col][row] == 0) {
            return 2;
        } else if (inputint[col][row] == 1) {
            return 1;
        } else {
            return -1;
        }
    }
}
