package test;

import easy.ReverseList;

import java.util.Scanner;

public class SheinTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ListNode head = new ListNode(0,null);
        ListNode pre = new ListNode(0,head);
        for (int i = 0; i < n; i++) {
            head.next=new ListNode(sc.nextInt(),null);
            head=head.next;
        }
        removeN(pre.next.next,m);
        ListNode next = pre.next.next;
        while (next!=null){
            System.out.print(next.val+" ");
            next=next.next;
        }
    }
    private static ListNode removeN(ListNode head,int index){
        if(index<=0)return head;
        if(index==1)return head.next;
        ListNode res =new ListNode(0,head);

        ListNode pre = head;
        ListNode cur = head.next;
        for (int i = 2; i <=index; i++) {
            if(cur==null)break;
            if(i==index)pre.next=cur.next;
            else {
                cur=cur.next;
                pre=pre.next;
            }
        }
        return res.next;
    }

    static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
