package test;

/**
 * 有环链表入口问题
 */
public class CircleListInTest {
    public static void main(String[] args) {
        Node<String> first  = new Node<>("aa",null);
        Node<String> second = new Node<>("bb",null);
        Node<String> third  = new Node<>("cc",null);
        Node<String> fourth = new Node<>("dd",null);
        Node<String> fifth  = new Node<>("ee",null);
        Node<String> six   = new Node<>("ff",null);
        Node<String> seven  = new Node<>("gg",null);

        //完成结点之间的指向
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=six;
        six.next=seven;
        //产生环
        seven.next=third;

        //查找环的入口结点
        Node<String> entrance =getEntrance(first);
        System.out.println("first链表中环的入口元素为:"+entrance.item);
    }

    /**
     * 查找有环链表中环的入口结点
     * @param first
     * @return
     */
    public static Node getEntrance(Node<String> first){
        //当快慢指针相遇的时候，在first定义一个临时指针
        // 慢指针和临时指针依次步进的时候，相遇到的位置就是环入口的位置
        Node<String> fast = first;
        Node<String> slow = first;
        //临时指针，原理涉及到数论的知识
        Node<String> temp = first;
        while (slow!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                while (!temp.equals(slow)){
                    temp=temp.next;
                    slow=slow.next;
                }
                return temp;
            }
        }
        return null;
    }


    //节点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }
}
