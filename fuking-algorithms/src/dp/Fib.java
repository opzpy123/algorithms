package dp;

import java.util.HashMap;

/**
 * 斐波那契数列
 */
public class Fib {

    public static void main(String[] args) {
        //记录值 备忘录
        HashMap<Integer, Integer> map = new HashMap<>();
        long a = System.currentTimeMillis();
//        System.out.println(fib1(45));
        long b = System.currentTimeMillis();
        System.out.println(fib(45, map));
        long c = System.currentTimeMillis();
        System.out.println("递归耗时" + (b - a));
        System.out.println("备忘录耗时" + (c - b));

        System.out.println(fib2(45));
        System.out.println(fib3(45));
    }

    //备忘录
    public static int fib(int n, HashMap<Integer, Integer> map) {
        if (n == 1 || n == 2) return 1;
        if (map.containsKey(n)) return map.get(n);
        int fibNum = fib(n - 1, map) + fib(n - 2, map);
        map.put(n, fibNum);
        return map.get(n);
    }

    //递归
    public static int fib1(int n) {
        if (n == 1 || n == 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    //dp
    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    //dp状态压缩 只需要前面两个元素 并不需要一整个数组存储
    public static int fib3(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int pre=1,cur=1;
        for (int i = 3; i <= n; i++) {
            int tmp = pre+cur;
            pre=cur;
            cur=tmp;
        }
        return cur;
    }

}
