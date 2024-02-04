package normal;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }

    LinkedList<Integer> queue=new LinkedList<>();;
    int size;

    public MyCircularQueue(int k) {
        size=k;
    }

    public boolean enQueue(int value) {
        if(queue.size()==size){
            return false;
        }else {
            queue.addFirst(value);
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if(queue.isEmpty()){
            return false;
        }else {
            queue.removeFirst();
            size--;
            return true;
        }
    }

    public int Front() {
        return queue.getFirst();
    }

    public int Rear() {
        return queue.getLast();
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return queue.size()==size;
    }
}
