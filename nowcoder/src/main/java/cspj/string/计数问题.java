package cspj.string;

import java.util.*;

public class 计数问题 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int res = 0;
		int n = sc.nextInt();
		int x = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			char[] chars = String.valueOf(i).toCharArray();
			for (int j = 0; j < chars.length; j++) {
				if((chars[j]+"").equals(x+"")){
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
