package linear;

import java.util.Iterator;

/**
 * 栈
 */
public class Stack<T> implements Iterable{
    //记录头节点
    private Node head;
    //记录链表长度
    private int N;

    //节点类
    private class Node {
        //存储数据
        T item;
        //下一个节点
        Node next;

        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }

    //判断当前栈中元素的个数是否为0
    public boolean isEmpty(){
        return N==0;
    }

    //获取栈中元素的个数
    public int size(){
        return N;
    }

    //把t元素压入栈
    public void push(T t){
        //找到指向首节点的第一个节点
        Node oldFirst = head.next;
        //创建新节点
        Node newNode = new Node(t, null);
        //让首节点指向新结点
        head.next=newNode;
        //让新结点指向原来的第一个结点
        newNode.next=oldFirst;
        //元素个数++
        N++;
    }

    //弹出栈顶元素
    public T pop(){
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        if(oldFirst==null){
            return null;
        }
        //让首节点指向原来第一个节点的下一个结点
        head.next=oldFirst.next;
        //元素个数-1；
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        //记录每一次遍历拿到的结点
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
