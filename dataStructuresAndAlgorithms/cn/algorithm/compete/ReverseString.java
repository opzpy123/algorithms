package compete;

import java.util.Arrays;

public class ReverseString {
	public static void main(String[] args) {
		String s =" asda";
		StringBuilder sb = new StringBuilder();
		sb.append("黄焖鸡 真 好吃");
		sb.reverse();
		System.out.println(sb);
		reverse("how are you");
	}
	private static void reverse(String s){
		String[] split = s.split(" ");
		int l=0,r=split.length-1;
		while (l<r){
			String t = split[l];
			split[l] = split[r];
			split[r] = t;
			l++;
			r--;
		}
		StringBuilder a = new StringBuilder();
		for (String s1 : split) {
			a.append(s1+" ");
		}
		System.out.println(a);
	}
}
