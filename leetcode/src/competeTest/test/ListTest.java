package competeTest.test;


import easy.ReverseList;
import normal.ReverseBetween.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		ListTest listTest = new ListTest();
		listTest.test();
	}

	public  void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next=node2;
		node2.next=node3;
		node3.next=node4;

		ListNode reverse = reverse(node1);

		while (reverse!=null){
			System.out.println(reverse.value);
			reverse=reverse.next;
		}

	}
	public ListNode reverse(ListNode node){
		ListNode pre = null;//上一个
		ListNode cur =  node;//当前
		ListNode next = null;//下一个
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}


	class ListNode{
		public Integer value;
		public ListNode next;
		public ListNode() {
		}

		public ListNode(Integer value) {
			this.value=value;
		}

		public ListNode(Integer value, ListNode next) {
			this.value = value;
			this.next = next;
		}

	}
}
