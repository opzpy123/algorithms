package question.链表;

import common.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next=new ListNode(5);
        listNode.next.next=new ListNode(1);
        listNode.next.next.next=new ListNode(9);
        DeleteNode deleteNode = new DeleteNode();
        ListNode listNode1 = deleteNode.deleteNode(listNode, 5);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode nxt = head.next;
        if (nxt == null) return null;
        if(cur.val==val)return nxt;
        while (nxt!=null){
            if(nxt.val==val){
                cur.next=nxt.next;
                return head;
            }
            cur=cur.next;
            nxt=nxt.next;
        }
        return null;
    }
}
