package dp_study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 最长公共子序列
 */
public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubsequence("123123ozp112233123opzpy123123123123", "11ssx23opzzz"));
    }

    /**
     * 最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //最长公共子序列的值
        System.out.println(printLCS(text1, text2, m, n, dp));
        //最长公共子序列的长度
        System.out.println("=====dp[][]====");
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("===============");
        return dp[m][n];
    }

    //由dp[][]导向的结果
    private String printLCS(String str1, String str2, int i, int j, int[][] dp) {
        LinkedList<Character> result = new LinkedList<>();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // i - 1 j - 1
                result.addFirst(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return String.valueOf(result);
    }
}
