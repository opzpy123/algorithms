package test;

import common.ListNode;
import question.链表.Merge;

public class MergeTest {
    public static void main(String[] args) {
        Merge merge = new Merge();
        ListNode node = merge.Merge(test1(), test2());
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        return head;
    }

    public static ListNode test2() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        return head;
    }
}
