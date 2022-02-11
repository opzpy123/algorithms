package normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 链表环的入口
 */
public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //哈希表
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        HashSet<ListNode> listNodes = new HashSet<>();
        while (pos!=null){
            if(listNodes.contains(pos)){
                return pos;
            }else {
                listNodes.add(pos);
            }
            pos=pos.next;
        }
        return null;
    }
    //快慢指针
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
