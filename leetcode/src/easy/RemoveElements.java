package easy;

/**
 * 203溢出链表元素
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next=new ListNode(2);
        listNode=listNode.next;
        listNode.next=new ListNode(3);
        listNode=listNode.next;
        listNode.next=new ListNode(4);
        listNode=listNode.next;
        listNode.next=new ListNode(5);
        listNode=listNode.next;
        listNode.next=new ListNode(6);
        RemoveElements removeElements = new RemoveElements();
        ListNode listNode1 = removeElements.removeElements(head, 2);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;

    }
}


