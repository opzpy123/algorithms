package easy;


import java.util.Stack;

public class HasCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
//        while (head!=null){
//            if(head.val==Integer.MAX_VALUE)
//                return true;
//            head.val=Integer.MAX_VALUE;
//            head=head.next;//走过就标记
//        }
//        return false;

        if(head==null||head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;

    }
}
