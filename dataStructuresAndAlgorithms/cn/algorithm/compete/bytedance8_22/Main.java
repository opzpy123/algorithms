package compete.bytedance8_22;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(smallestK(new int[]{2, 3, 1, 2, 3, 4, 5, 6, 1, 4, 3, 2, 999}, 5)));
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 5)));
    }

    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        for (int e : arr) queue.add(e);
        queue.peek();
        return queue.stream().mapToInt(Integer::intValue).boxed().collect(Collectors.toList()).stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
