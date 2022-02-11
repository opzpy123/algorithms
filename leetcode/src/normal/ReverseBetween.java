package normal;

import easy.RemoveElements.ListNode;

import java.util.Arrays;

public class ReverseBetween {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode head = node1;
		ReverseBetween reverseBetween = new ReverseBetween();
		ListNode listNode = reverseBetween.reverseBetween(head, 2, 4);
		while (listNode!=null){
			System.out.println(listNode.val);
			listNode=listNode.next;
		}
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head==null||left==right) return head;
		//一次遍历获取顺序数组
		ListNode operaHead = head;
		int[] arr = new int[right-left+1];
		int nodeIndex=1;
		int arrIndex=0;
		while (operaHead!=null){
			if(nodeIndex>=left&&nodeIndex<=right){
				arr[arrIndex++]=operaHead.val;
			}
			operaHead=operaHead.next;
			nodeIndex++;
		}
		//链指针回队首
		operaHead=head;
		//获取到数组
		System.out.println(Arrays.toString(arr));
		//对数组进行翻转
		int l=0,r=arr.length-1,t;
		while (l<r){
			t=arr[l];
			arr[l]=arr[r];
			arr[r]=t;
			l++;r--;
		}
		System.out.println(Arrays.toString(arr));
		//数组赋值回链表
		arrIndex=0;
		nodeIndex=1;
		while (operaHead!=null){
			if(nodeIndex>=left&&nodeIndex<=right){
				operaHead.val=arr[arrIndex++];
			}
			operaHead=operaHead.next;
			nodeIndex++;
		}
		operaHead=head;
		return operaHead;
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
