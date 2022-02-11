package cspj.string;

import java.util.Scanner;

public class 标题统计 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int blankNum=0;
		for (int i =0;i<s.length();i++){
			if(s.charAt(i)==' ') blankNum++;
		}
		System.out.println(s.length()-blankNum);
	}
}
