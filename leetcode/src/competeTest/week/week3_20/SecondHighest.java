package competeTest.week.week3_20;

import java.util.ArrayList;
import java.util.List;

public class SecondHighest {
	public static void main(String[] args) {
		SecondHighest secondHighest = new SecondHighest();
		System.out.println(secondHighest.secondHighest("dfa12321afd"));
		System.out.println(secondHighest.secondHighest("abc1111"));
	}
	public int secondHighest(String s) {
		char[] chars = s.toCharArray();
		int[] arr = new int[10];
		for (int i = 0; i < chars.length; i++) {
			if(Character.isDigit(chars[i])&&arr[Character.getNumericValue(chars[i])]==0){
				arr[Character.getNumericValue(chars[i])]++;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=0){
				res.add(i);
			}
		}
		return res.size()>=2?res.get(res.size()-2):-1;
	}
}
