package test;

import common.ListNode;
import question.链表.PrintListFromTailToHead;

public class PrintListFromTailToHeadTest {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        PrintListFromTailToHead printListFromTailToHead = new PrintListFromTailToHead();
        System.out.println(printListFromTailToHead.printListFromTailToHead(head));
    }
    public static void test2() {
        ListNode head = new ListNode(67);
        head.next = new ListNode(0);
        head.next.next = new ListNode(24);
        head.next.next.next = new ListNode(58);

        PrintListFromTailToHead printListFromTailToHead = new PrintListFromTailToHead();
        System.out.println(printListFromTailToHead.printListFromTailToHead(head));
    }
}
