package test;

import common.ListNode;
import question.链表.ReverseList;

public class ReverseListTest {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.reverseList(test1());
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }

    public static ListNode test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        return head;
    }
}
