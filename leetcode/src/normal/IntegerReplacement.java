package normal;

import java.util.ArrayList;

public class IntegerReplacement {
    public static void main(String[] args) {
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(integerReplacement.integerReplacement(7));
    }

    int res = Integer.MAX_VALUE;

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        helper(n, 0);
        return res;
    }


    private void helper(Integer n, Integer count) {
        if (n == 1) {
            res = Math.min(res, count);
            return;
        }
        count++;
        if (n % 2 == 0) {
            helper(n / 2, count);
        } else {
            //n+1 或者 n-1
            helper(n + 1, count);
            helper(n - 1, count);
        }

    }

}
