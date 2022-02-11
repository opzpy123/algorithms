package easy;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] =getBits(i);
        }
        return res;
    }

    private static int getBits(int num) {
        int res = 0;
        while (num > 1) {
            if (num % 2 == 1) {
                res++;
            }
            num/=2;
        }
        return res+1;
    }
}
