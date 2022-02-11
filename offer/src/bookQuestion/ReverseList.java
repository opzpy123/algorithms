package bookQuestion;

/**
 * 翻转链表
 */
public class ReverseList {
    //节点类
    private static class Node {
        //存储数据
        Integer item;
        //下一个节点
        Node next;

        public Node() {
        }

        public Node(Integer item) {
            this.item = item;
        }

        public Node(Integer item, Node next) {
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

        public Boolean hasNext() {
            return this.next != null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.next = new Node(0, new Node(1, new Node(2, new Node(3, new Node(4, new Node())))));
        Node helper = helper(head);
        while (helper.hasNext()){
            System.out.println(helper.item);
            helper= helper.next;
        }
    }

    public static Node helper(Node head){
        if(head!=null||head.next!=null){
            return head;
        }
        Node temp = helper(head.next);
        head.next.next= head;
        head.next=null;
        return temp;
    }
}
