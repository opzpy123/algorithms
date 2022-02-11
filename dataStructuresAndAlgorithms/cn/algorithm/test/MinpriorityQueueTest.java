package test;

import priority.MinPriorityQueue;

/**
 * 最小优先队列
 */
public class MinpriorityQueueTest {
    public static void main(String[] args) {
        //创建最小优先队列
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        //存储数据
        queue.insert("g");
        queue.insert("f");
        queue.insert("e");
        queue.insert("d");
        queue.insert("c");
        queue.insert("b");
        queue.insert("a");
        //循环获取最小优先队列中的元素
        while (!queue.isEmpty()){
            String s = queue.delMin();
            System.out.print(s+" ");
        }
    }
}
