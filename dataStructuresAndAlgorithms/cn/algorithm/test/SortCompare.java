package test;

import sort.Insertion;
import sort.Merge;
import sort.Quick;
import sort.Shell;

import java.io.*;
import java.util.ArrayList;

public class SortCompare {
    public static void main(String[] args) throws IOException {
        //1.创建一个ArrayList集合，保存读取出来的整数
        ArrayList<Integer> list = new ArrayList<>();
        //2.创建缓存读取流BufferReader，读取数据，并存储到ArrayList中
        BufferedReader reader = new BufferedReader(new InputStreamReader(SortCompare.class.getResourceAsStream("../reverse_arr.txt")));
        String line = null;
        while((line=reader.readLine())!=null){
            //line是字符串，把Line转换成Integer，存储到集合中
            int i = Integer.parseInt(line);
            list.add(i);
        }
        reader.close();

        //3.把ArrayList集合转换成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        //4.调用测试代码完成测试
//        testInsertion(a);//14170
        testShell(a);//16
        testMerge(a);//41
        testQuick(a);

    }

    //测试希尔排序
    public static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的时间: "+(end-start)+" ms");
    }
    //测试插入排序
    public static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("插入排序的时间: "+(end-start)+" ms");
    }
    //测试归并排序
    public static void testMerge(Integer[] a){
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("归并排序的时间: "+(end-start)+" ms");
    }

    //测试快速排序
    public static void testQuick(Integer[] a){
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("快速排序的时间: "+(end-start)+" ms");
    }

    void inputTest(){
        File file = new File("C:\\IDEA_WorkSpace\\algorithms\\dataStructuresAndAlgorithms\\algorithm\\01-sort\\reverse_arr.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            for (int i = 100000; i >0 ; i--) {
                fw.write(i+"\r\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
