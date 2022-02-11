package compete;

import java.util.*;

public class Shence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Deque<int[]> stack = new LinkedList<>();
        stack.push(arr);
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            System.out.println(Arrays.toString(pop));
            int res = 0;
            for (int i = 0; i < 7; i++) {
                int t=1;
                if(i==1)t=2;
                if(i==2)t=5;
                if(i==3)t=10;
                if(i==4)t=20;
                if(i==5)t=50;
                if(i==6)t=100;
                res += pop[i]*t;
            }
            if (res == target) {
                System.out.println(Arrays.toString(pop));
            }
            for (int i = 0; i < 7; i++) {
                if (pop[i] > 0) pop[i] -= 1;
                int t = 0;
                for (int j = 0; j < 7; j++) {
                    t += pop[j];
                }
                if (t != 0) {
                    stack.push(Arrays.copyOf(pop,7));
                }
            }
        }
    }

    private static void drillDown(int[] arr, int start, List<int[]> arrList, int target, int thisI) {
        if (start == arr[thisI]) {
            System.out.println(Arrays.toString(arr));
//            int res = 0;
//            for (int i : arr) {
//                res += i;
//            }
//            if (res == target) {
//                arrList.add(arr);
//            }
//            return;
        }
        for (int i = start; i < arr[i]; i++) {
            arr[i] -= 1;
            drillDown(arr, start + 1, arrList, target, arr[i]);
            arr[i] += 1;
        }
    }
}
