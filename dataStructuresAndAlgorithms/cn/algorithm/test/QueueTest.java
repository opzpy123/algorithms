package test;

import linear.Queue;

/**
 * 队列测试
 */
public class QueueTest {
    public static void main(String[] args) {
        //创建一个队列对象
        Queue<String> queue = new Queue<>();
        //测试队列的enqueue方法
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (Object o : queue) {
            System.out.print(o+" ");
        }

        //测试队列的dequeue方法
        System.out.println("\n测试dequeue方法");
        String dequeue = queue.dequeue();
        System.out.println("取出了"+dequeue);
        System.out.println("剩余:"+queue.size()+"个");
        for (Object o : queue) {
            System.out.print(o+" ");
        }
    }
}
