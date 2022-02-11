package normal;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode t = head;
		t.next=new ListNode(2);
		t=t.next;
		t.next=new ListNode(3);
		t=t.next;
		t.next=new ListNode(3);
		t=t.next;
		t.next=new ListNode(4);
		t=t.next;
		t.next=new ListNode(4);
		t=t.next;
		t.next=new ListNode(5);
		t=t.next;
		ListNode listNode = deleteDuplicates(head);
		while (listNode!=null){
			System.out.println(listNode.val+" ");
			listNode=listNode.next;
		}

	}
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0, head);

		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}

//	Definition for singly-linked list.
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
