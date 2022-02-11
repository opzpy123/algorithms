package normal;

import java.util.Arrays;
import java.util.Stack;

public class EvalRPN {
	public static void main(String[] args) {
		String[] strings1 = {"2","1","+","3","*"};
		String[] strings2 = {"4","13","5","/","+"};
		String[] strings3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		EvalRPN evalRPN = new EvalRPN();
		System.out.println(evalRPN.evalRPN(strings1));
		System.out.println(evalRPN.evalRPN(strings2));
		System.out.println(evalRPN.evalRPN(strings3));
	}
	public int evalRPN(String[] tokens) {
		Stack<Integer> operaStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].equals("+")){
				int x = operaStack.pop();
				int y = operaStack.pop();
				operaStack.push(y+x);
			}else if(tokens[i].equals("-")){
				int x = operaStack.pop();
				int y = operaStack.pop();
				operaStack.push(y-x);
			} else if(tokens[i].equals("*")){
				int x = operaStack.pop();
				int y = operaStack.pop();
				operaStack.push(y*x);
			} else if(tokens[i].equals("/")){
				int x = operaStack.pop();
				int y = operaStack.pop();
				operaStack.push(y/x);
			}else {
				//当前的是数字
				operaStack.push(Integer.parseInt(tokens[i]));
			}
		}
		return operaStack.pop();
	}
}
