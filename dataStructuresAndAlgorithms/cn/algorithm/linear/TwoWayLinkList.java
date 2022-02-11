package linear;

import java.util.Iterator;

/**
 * 双向链表
 *
 * @param <T>
 */
public class TwoWayLinkList<T> implements Iterable{
    //记录头结点
    private Node head;
    //记录尾结点
    private Node last;
    //链表的长度
    private int N;

    //结点类
    private class Node{
        //结点数据
        public T item;
        //上一个结点
        public Node pre;
        //后一个结点
        public Node next;

        public Node(T item,Node pre,Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
    }

    //空参构造
    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head=new Node(null,null,null);
        this.last=null;
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear(){
        this.head=new Node(null,null,null);
        this.last=null;
        this.N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
     return N==0;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最够一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素
    public void insert(T t){
        //如果链表为空 创建新结点 成为尾巴结点
        if(isEmpty()){
            Node newNode = new Node(t, head, null);
            last=newNode;
            head.next=last;
        }else {
            //如果链表不为空
            Node oldNode = last;
            //创建新的结点
            Node newNode = new Node(t, oldNode, null);
            //让当前的尾结点指向新结点
            oldNode.next=newNode;
            //让新结点成为尾结点
            last=newNode;
        }
        //元素个数+1
        N++;
    }
    //向指定位置i处插入元素t
    public void insert(T t,int i){
        if(i>N)return;
        //找到i位置的前一个结点
        Node pre =head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点
        Node newNode = new Node(t, pre, curr);
        //让i位置的前一个结点的下一个结点变为新结点
        pre.next=newNode;
        //让i位置的前一个结点变为新结点
        curr.pre=newNode;
        //元素+1
        N++;
    }
    //获取指定位置i处的元素
    public T get(int i){
        Node n =head.next;
        for(int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }
    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t){
        int count=0;
        while(count<N){
            if(get(count).equals(t)){
                return count;
            }
            count++;
        }
        return -1;
    }
    //删除元素i处的元素，并返回该元素
    public T remove(int i){
        //找到i位置的前一个结点
        Node currPre =head;
        for(int index=0;index<i;index++){
            currPre=currPre.next;
        }
        //找到i位置的结点
        Node curr = currPre.next;
        //找到i位置的下一个结点
        Node currNext = curr.next;
        //让i位置的前一个结点的下一个节点变为i位置的下一个节点
        currPre.next=currNext;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        currNext.pre=currPre;
        //元素个数-1
        N--;
        return curr.item;
    }



    @Override
    public Iterator iterator() {
        return new TIterator();
    }
    private class TIterator implements  Iterator{

        private Node n;
        public TIterator(){
            this.n=head;
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
