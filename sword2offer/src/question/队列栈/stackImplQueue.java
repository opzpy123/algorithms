package question.队列栈;

import java.util.Stack;

public class stackImplQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //push时往栈1放 pop时 判断栈2是否为空 否则 将栈1全部放入栈2
    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
