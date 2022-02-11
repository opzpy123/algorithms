package test;

import heap.HeapSort;

import java.util.Arrays;

/**
 * 堆排序测试
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr ={"S","O","R","T","E","X","A","M","P","L","E"};
        //同过heapSort对数组中的元素进行排序
        HeapSort.sort(arr);
        //打印排序后的数组
        System.out.println(Arrays.toString(arr));
    }
}
