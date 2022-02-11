package test;

/**
 * 快慢指针实现查找中间值
 */
public class FastSlowTest {
    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<>("aa",null);
        Node<String> second = new Node<>("bb",null);
        Node<String> third = new Node<>("cc",null);
        Node<String> fourth = new Node<>("dd",null);
        Node<String> fifth = new Node<>("ee",null);
        Node<String> six = new Node<>("ff",null);
        Node<String> seven = new Node<>("gg",null);

        //完成结点之间的指向
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=six;
        six.next=seven;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值:"+mid);
    }

    //查找链表中间值
    public static String getMid(Node<String> first){
        Node<String> fastPoint=first;
        Node<String> slowPoint=first;
        while(true){
            if(fastPoint.next==null){
                return slowPoint.item;
            }
            fastPoint=fastPoint.next.next;
            slowPoint=slowPoint.next;
        }
    }

    //节点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
}
