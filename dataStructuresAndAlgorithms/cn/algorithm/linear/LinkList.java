package linear;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 单链表
 * @param <T>
 */
public class LinkList<T> implements Iterable {
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

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkList() {
        //初始化头节点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;

    }

    //清空链表
    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    //获取链表的长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置i处的元素
    public T get(int i) {
        //通过循环，从头节点开始往后找，依次找i次，就可以找到对应的元素
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素t
    public void insert(T t) {
        //通过循环，找到最后的节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        //创建新节点，吧元素放到新节点，并把最后指针指向新节点
        n.next = new Node(t, null);
        //长度加1
        N++;
    }

    //向指定位置i处，添加元素t
    public void insert(T t, int i) {
        //找到i位置钱一个位置的结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新节点，并且新节点需要只想原来i位置的结点
        Node newNode = new Node(t, curr);
        //原来i位置的前一个结点指向新结点即可
        pre.next = newNode;
        //元素个数+1
        N++;
    }

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i) {
        //找到i位置钱一个位置的结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //要找到i位置的结点
        Node curr = pre.next;
        //前一个结点指向下一个结点
        pre.next=pre.next.next;
        //元素个数-1
        N--;
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        //从头节点开始，依次找到每一个结点，取出item，和t比较
        Node n = head;
        int count = 0;
        while (n.next != null) {
            n = n.next;
            if (n.item.equals(t)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
       return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        public LIterator() {
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

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                ", N=" + N +
                '}';
    }

    //用来反转整个链表
    public void reverse(){

        //判断当前链表是否为空链表，如果是则结束运行，如果否 调用重载的reverse方法完成反转
        if(isEmpty()){
            return;
        }
        reverse(head.next);

    }

    //反转指定节点curr 并把反转后的结点返回
    public Node reverse(Node curr){
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归的反转当前结点的下一个结点
        //返回值就是链表反转后 当前节点的上一个结点
        Node pre = reverse(curr.next);
        //让返回的结点的下一个结点变为当前结点curr;
        pre.next=curr;
        //把当前节点的下一个结点 变为null
        curr.next=null;
        return curr;
    }




}
