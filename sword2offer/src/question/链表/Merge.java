package question.链表;

import common.ListNode;

/**
 * 描述
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，
 */
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                cur = cur.next;
            } else if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            }
        }
        return preHead.next;
    }
}
