package test;

import linear.LinkList;
import linear.SequenceList;

public class LinkListTest {
    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> linkList = new LinkList<>();

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
        System.out.println("删除以前"+linkList);
        String remove = linkList.remove(1);
        System.out.println("被删除的元素"+remove);
        System.out.println(linkList);
        //测试清空
        linkList.clear();
        System.out.println(linkList);
    }
}
