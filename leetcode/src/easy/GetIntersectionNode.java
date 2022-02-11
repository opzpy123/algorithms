package easy;

import java.util.HashSet;

public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        HashSet<ListNode> setB = new HashSet<>();
        ListNode A = headA;
        ListNode B = headB;
        while (A != null || B != null) {
            if (A != null) {
                if (setB.contains(A)) return A;
                setA.add(A);
                A = A.next;
            }
            if (B != null) {
                if (setA.contains(B)) return B;
                setB.add(B);
                B = B.next;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


