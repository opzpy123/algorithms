package easy;

import java.util.Arrays;

public class GetMaximumGenerated {
    public static void main(String[] args) {
        GetMaximumGenerated g = new GetMaximumGenerated();
        System.out.println(g.getMaximumGenerated(7));
        System.out.println(g.getMaximumGenerated(2));
        System.out.println(g.getMaximumGenerated(3));
    }

    public int getMaximumGenerated(int n) {
        if(n<2)return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int res = 0;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
