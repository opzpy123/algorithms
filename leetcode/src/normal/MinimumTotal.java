package normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> all = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        all.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        all.add(list);
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        all.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        all.add(list);
        System.out.println(all);

        MinimumTotal minimumTotal = new MinimumTotal();
        System.out.println(minimumTotal.minimumTotal(all));

    }
}
