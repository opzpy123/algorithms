package normal;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Stack<Integer> stack = new Stack<>();
		List<String> operators = Stream.of("+", "-", "*", "/").collect(Collectors.toList());
		for (String token : tokens) {
			if(!operators.contains(token)){
				stack.push(Integer.parseInt(token));
				continue;
			}
			Integer elem1 = stack.pop();
			Integer elem2 = stack.pop();
			if(token.equals("+"))stack.push(elem2+elem1);
			if(token.equals("-"))stack.push(elem2-elem1);
			if(token.equals("*"))stack.push(elem2*elem1);
			if(token.equals("/"))stack.push(elem2/elem1);
		}
		return stack.pop();
	}
}
