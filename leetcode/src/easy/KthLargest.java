package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
    private PriorityQueue<Integer> q;
    private int kth;
    public KthLargest(int k, int[] nums) {
        kth=k;
        q=new PriorityQueue<>();
        for(int num: nums)add(num);
        System.out.println(q.toString());
    }
    public int add(int val) {
        q.add(val);
        if(q.size()>kth)q.poll();
        return q.peek();
    }
}
