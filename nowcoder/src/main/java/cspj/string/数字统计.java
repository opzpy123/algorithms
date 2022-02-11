package cspj.string;

import java.util.Scanner;

public class 数字统计 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int res = 0;
		int l = sc.nextInt();
		int r = sc.nextInt();
		for (int i = l; i <= r; i++) {
			char[] chars = String.valueOf(i).toCharArray();
			for (int j = 0; j < chars.length; j++) {
				if((chars[j]+"").equals(2+"")){
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
