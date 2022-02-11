package normal;

import java.util.Arrays;

public class JudgeSquareSum {
	public static void main(String[] args) {
		JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
		System.out.println(judgeSquareSum.judgeSquareSum(1));
		System.out.println(judgeSquareSum.judgeSquareSum(2));
		System.out.println(judgeSquareSum.judgeSquareSum(3));
		System.out.println(judgeSquareSum.judgeSquareSum(4));
		System.out.println(judgeSquareSum.judgeSquareSum(5));
	}

	public boolean judgeSquareSum(int c) {
		int i = 0;
		int j = (int)Math.sqrt(c);
		while(i<=j){
			if(i*i+j*j < c){
				i++;
			}else if(i*i+j*j > c){
				j--;
			}else{
				return true;
			}
		}
		return false;
	}
}
