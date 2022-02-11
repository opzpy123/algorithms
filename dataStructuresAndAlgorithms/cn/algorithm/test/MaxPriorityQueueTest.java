package test;

import priority.MaxPriorityQueue;

/**
 * 最大优先队列测试
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        //创建队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        //往队列中存储元素
        queue.insert("a");
        queue.insert("b");
        queue.insert("c");
        queue.insert("d");
        queue.insert("e");
        queue.insert("f");
        queue.insert("g");
        //通过循环从队列中获取最大的元素
        while (!queue.isEmpty()){
            String s = queue.delMAx();
            System.out.print(s+" ");
        }
    }
}
