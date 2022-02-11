package easy;

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode cur = head;
		while (cur.next!=null){
			if(cur.val==cur.next.val){
				cur.next=cur.next.next;
			}else {
				cur=cur.next;
			}
		}

		return head;

	}


//	Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
