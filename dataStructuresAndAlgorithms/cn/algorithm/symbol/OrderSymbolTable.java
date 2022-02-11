package symbol;

/**
 * 有序符号表(key-value)
 */
public class OrderSymbolTable<Key extends Comparable<Key>,Value> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //往符号表中有序的插入键值对
    public void put(Key key,Value value){
        //定义两个Node标量，分别记录当前节点和当前节点的上一个结点

        Node curr  = head.next;
        Node pre = head;
        while (curr!=null && key.compareTo(curr.key)>0){
            //变换当前结点和前一个结点即可
            pre=curr;
            curr=curr.next;
        }
        //如果当前结点curr的键和要插入的key一样，则替换
        if(curr!=null&&key.compareTo(curr.key)==0){
            curr.value=value;
            return;
        }
        //如果不一样，则将新结点插入curr之前
        Node newNode = new Node(key, value, curr);
        pre.next=newNode;

        //元素个数加1
        N++;

    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        //找到键为key的结点，把该结点从链表中删除。
        Node n =head;
        while (n.next!=null){
            //判断n结点的下一个结点的key是否为key，如果是则删除该结点
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            //变换n
            n=n.next;
        }
    }

    //从符号表中获取keu对应的值
    public Value get(Key key){
        Node n = head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                return n.next.value;
            }
            n=n.next;
        }
        return null;
    }

}
