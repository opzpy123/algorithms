package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str = "abcadiasiqacdfgiikkg";
        int max = 0;
        String rs = "";
        List<String> list = new ArrayList<>();
        for (int i = 1; i < str.length()+1; i++) {
            for (int j = 1; j < str.length()+1; j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    rs=rs+str.charAt(j-1);
                }
            }
            list.add(rs);
            rs="";
        }

        for (String s : list) {
            char[] chars = s.toCharArray();
            char[] temp = chars.clone();
            Arrays.sort(chars);
            System.out.println("============");
            System.out.println(chars);
            System.out.println(temp);
        }
    }
}
