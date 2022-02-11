package test;

import common.ListNode;

public class ReverseList {
    public static void main(String[] args) {

    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = null;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
