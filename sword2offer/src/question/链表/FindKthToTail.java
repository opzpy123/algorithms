package question.链表;

import common.ListNode;

import java.util.LinkedList;

public class FindKthToTail {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode listNode1 = findKthToTail.FindKthToTail1(listNode, 2);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    int level;
    ListNode res;

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead != null) {
            FindKthToTail(pHead.next, k);
            if (++level == k) {
                res = pHead;
            }
        }
        return res;
    }

    public ListNode FindKthToTail1(ListNode pHead, int k) {
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (pHead != null) {
            listNodes.add(pHead);
            pHead = pHead.next;
        }
        if(listNodes.size()-k<0||listNodes.size()-k>=listNodes.size())return null;
        return listNodes.get(listNodes.size()-k);
    }
}
