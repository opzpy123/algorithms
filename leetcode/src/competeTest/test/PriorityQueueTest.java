package competeTest.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<int[]> sortIntArr = new PriorityQueue<>((a, b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int[] ints1 = {1,2};
        int[] ints2 = {2,3};
        int[] ints3 = {-1,0};
        int[] ints4 = {1,5};
        sortIntArr.add(ints1);
        sortIntArr.add(ints2);
        sortIntArr.add(ints3);
        sortIntArr.add(ints4);
        while (!sortIntArr.isEmpty()){
            System.out.println(Arrays.toString(sortIntArr.poll()));
        }
    }
}
