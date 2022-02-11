package question.链表;

import common.ListNode;

import java.util.HashSet;

/**
 *
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (pHead1!=null){
            listNodes.add(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            if(listNodes.contains(pHead2))return pHead2;
            pHead2=pHead2.next;
        }
        return null;
    }
}
