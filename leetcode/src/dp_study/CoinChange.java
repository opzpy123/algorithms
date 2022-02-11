package dp_study;

import java.util.HashMap;
import java.util.jar.JarEntry;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 35));
        System.out.println(coinChange.coinChange1(new int[]{1, 2, 5}, 35));
        System.out.println(coinChange.coinChange2(new int[]{1, 2, 5}, 35));
    }

    /**
     * 结果多叉树 循环递归
     *
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 使用备忘录保存
     */
    private HashMap<Integer, Integer> map = new HashMap<>();

    private int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (map.containsKey(amount)) return map.get(amount);
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange1(coins, amount - coin);
            if (!map.containsKey(amount - coin)) map.put(amount - coin, subProblem);
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];
        //求最小值 初始化为最大值
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
