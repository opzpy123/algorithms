package test;

import linear.SequenceList;

import java.util.ArrayList;
import java.util.LinkedList;

public class SequenceListTest2 {
    public static void main(String[] args) {
        LinkedList ls=new LinkedList();
        SequenceList<String> sequenceList = new SequenceList<>(3);
        sequenceList.insert("张三");
        sequenceList.insert("李四");
        sequenceList.insert("王五");
        sequenceList.insert("赵六");
        System.out.println(sequenceList);
        System.out.println(sequenceList.length());
    }

}
