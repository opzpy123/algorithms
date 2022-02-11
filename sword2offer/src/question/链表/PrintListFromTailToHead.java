package question.链表;

import common.ListNode;

import java.util.ArrayList;

/**
 * 描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 *
 * 如输入{1,2,3}的链表如下图:
 *
 * 返回一个数组为[3,2,1]
 *
 * 0 <= 链表长度 <= 10000
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }



}
