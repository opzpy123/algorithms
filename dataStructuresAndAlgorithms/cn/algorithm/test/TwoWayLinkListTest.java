package test;

import linear.LinkList;
import linear.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建单向链表对象
        TwoWayLinkList<String> linkList = new TwoWayLinkList<>();

        //测试插入
        linkList.insert("opzpy");
        linkList.insert("kobe");
        linkList.insert("irving");
        linkList.insert("curry",1);

        for(Object s:linkList){
            System.out.print(s+"  ");
        }
        System.out.println("---------------------------");

        //测试获取
        System.out.println("0位"+linkList.get(0));
        System.out.println("1位"+linkList.get(1));
        System.out.println("2位"+linkList.get(2));
        System.out.println("3位"+linkList.get(3));
        //测试删除
        System.out.print("删除以前  ");
        for(Object s:linkList){
            System.out.print(s+"  ");
        }
        String remove = linkList.remove(1);
        System.out.println("\n被删除的元素"+remove);
        System.out.print("删除之后  ");
        for(Object s:linkList){
            System.out.print(s+"  ");
        }
        //测试清空
        linkList.clear();
        System.out.print("\n清空  ");
        for(Object s:linkList){
            System.out.print(s+"  ");
        }
    }
}
