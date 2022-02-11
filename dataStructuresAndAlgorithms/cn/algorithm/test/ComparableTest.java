package test;

import sort.ComparableStudent;

//2.定义测试类test，在测试类中定义测试方法comparable getMax(Comparable c1,Comparable c2);
public class ComparableTest {

    public static void main(String[] args) {
        //创建两个Student对象，并调用getmax对象
        ComparableStudent s1 = new ComparableStudent();
        s1.setUserName("张三");
        s1.setAge(18);
        ComparableStudent s2 = new ComparableStudent();
        s2.setUserName("李四");
        s2.setAge(20);

        Comparable max = getMax(s1,s2);

        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        //如果result<0则c1比c2小
        if(result<0){
            return c2;
        }else {
            return c1;
        }
    }
}
