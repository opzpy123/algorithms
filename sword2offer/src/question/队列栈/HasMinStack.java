package question.队列栈;

import java.util.Arrays;

public class HasMinStack {
    public static void main(String[] args) {
        HasMinStack hasMinStack = new HasMinStack();
        hasMinStack.push(-1);
        hasMinStack.push(2);
        System.out.println(hasMinStack.min());
        System.out.println(hasMinStack.top());
        hasMinStack.pop();
        hasMinStack.push(1);
        System.out.println(hasMinStack.top());
        System.out.println(hasMinStack.min());
    }


    private int cap = 10;
    private Integer[] array = new Integer[cap];
    private int cur = 0;

    public void push(int node) {
        if (cur == cap - 1) {
            array = Arrays.copyOf(array, cap *= 2);
        }
        array[cur++] = node;
    }

    public void pop() {
        array[cur--]=null;
    }

    public int top() {
        return array[cur-1];
    }

    public int min() {
        Integer[] integers = Arrays.copyOf(array,cur);
        Arrays.sort(integers);
        return integers[0];
    }


}
