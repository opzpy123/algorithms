package easy;

import java.util.Stack;

class CQueue {
	Stack<Integer> inStack;
	Stack<Integer> outStack;

	public CQueue() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	public void appendTail(int value) {
		inStack.push(value);
	}

	public int deleteHead() {
		// 如果第二个栈为空
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		if (outStack.isEmpty()) {
			return -1;
		} else {
			return outStack.pop();
		}
	}
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */