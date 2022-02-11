package easy;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 反转链表
 */
public class ReversePrint {
	public int[] reversePrint(ListNode head) {
		Deque<Integer> deque = new LinkedList<>();
		while (head!=null){
			deque.push(head.val);
			head=head.next;
		}
		int[] res = new int[deque.size()];
		int i=0;
		while (!deque.isEmpty()){
			res[i++]=deque.pop();
		}
		return res;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
