package normal;

import java.util.PriorityQueue;

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        for (int i : arr) {
            pq.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
