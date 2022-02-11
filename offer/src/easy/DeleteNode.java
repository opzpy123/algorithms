package easy;

public class DeleteNode {
	public ListNode deleteNode(ListNode head, int val) {
		if(head == null) return head;

		ListNode pre = null;
		ListNode cur = head;

		if(cur.val == val) return head.next;
		while(cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
