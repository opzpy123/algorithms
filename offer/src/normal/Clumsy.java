package normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Clumsy {
	public static void main(String[] args) {
		Clumsy clumsy = new Clumsy();
		System.out.println(clumsy.clumsy(10));
	}
	public int clumsy(int N) {
		Deque<Integer> stack = new LinkedList<>();
		stack.push(N);
		N--;
		int index=0;//记录操作数
		while (N>0){
			if(index==0){
				stack.push(stack.pop()*N);
			}else if(index==1){
				stack.push(stack.pop()/N);
			}else if(index==2){
				stack.push(N);
			}else {
				stack.push(-N);
			}
			index=(index+1)%4;
			N--;
		}
		int res=0;
		while (!stack.isEmpty()){
			res+=stack.pop();
		}
		return res;
	}

}
