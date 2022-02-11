package question.链表;

import common.ListNode;
/**
 * 描述
 * 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头。
 *
 * 数据范围： n\leq1000n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 * 以上转换过程如下图所示：
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //三个指针 pre cur nxt
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
    /**
     * 递归实现
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode preNode = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return preNode;
    }
}
