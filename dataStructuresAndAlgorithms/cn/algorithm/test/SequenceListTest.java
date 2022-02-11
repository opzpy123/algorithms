package test;

import linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> sequenceList = new SequenceList<String>(10);

        //测试插入
        sequenceList.insert("opzpy");
        sequenceList.insert("kobe");
        sequenceList.insert("irving");
        sequenceList.insert("curry",1);

        for(Object s:sequenceList){
            System.out.print(s+"  ");
        }
        System.out.println("---------------------------");

        //测试获取
        System.out.println("0位"+sequenceList.get(0));
        System.out.println("1位"+sequenceList.get(1));
        System.out.println("2位"+sequenceList.get(2));
        System.out.println("3位"+sequenceList.get(3));
        //测试删除
        System.out.println("删除以前"+sequenceList);
        String remove = sequenceList.remove(1);
        System.out.println("被删除的元素"+remove);
        System.out.println(sequenceList);
        //测试清空
        sequenceList.clear();
        System.out.println(sequenceList);
    }
}
