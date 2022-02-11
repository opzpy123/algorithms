package normal;


public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode temp = a;
        a.next = new ListNode(2);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(4);
        a = a.next;
        a.next = null;
        swapPairs(temp);
    }
}
