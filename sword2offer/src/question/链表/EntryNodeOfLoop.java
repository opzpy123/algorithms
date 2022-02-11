package question.链表;

import common.ListNode;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //判断有环 指针1 一次走一步 指针2 一次走两步 如果指针1 与指针2相遇 则有环
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            if(p2.next==null)return null;
            p2=p2.next.next;
            if(p1==p2){
                //相遇
                //在此处 定义指针3 从初始开始 在与指针1相遇时就是入口
                ListNode p3 =pHead;
                while (p1!=p3){
                    p1=p1.next;
                    p3=p3.next;
                }
                return p1;
            }
        }
        return null;
    }
}
