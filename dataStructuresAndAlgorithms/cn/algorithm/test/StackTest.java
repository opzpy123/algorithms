package test;

import linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        //创建一个栈对象
        Stack<String> stack = new Stack<>();
        //测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (Object item : stack) {
            System.out.println(item);
        }
        //测试弹栈
        String pop1 = stack.pop();
        String pop2 = stack.pop();
        String pop3 = stack.pop();
        String pop4 = stack.pop();

        System.out.println("弹出的元素");
        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);
        System.out.println(pop4);
        String pop5 = stack.pop();
    }
}
