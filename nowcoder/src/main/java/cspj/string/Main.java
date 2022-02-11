package cspj.string;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String text = sc.nextLine();
		s = s.toLowerCase(Locale.ROOT);
		text = text.toLowerCase(Locale.ROOT);
		int res = 0;
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (s.equals(split[i])) res++;
		}
		if (res == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(res + " " + text.indexOf(s));
	}
}
