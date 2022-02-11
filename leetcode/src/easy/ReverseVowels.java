package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseVowels {
	public static void main(String[] args) {
		ReverseVowels reverseVowels = new ReverseVowels();
		System.out.println(reverseVowels.reverseVowels("hello"));
		System.out.println(reverseVowels.reverseVowels("leetcode"));
	}

	public String reverseVowels(String s) {
		String vowel = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int l = 0, r = chars.length - 1;
		while (l < r) {
			if (!vowel.contains(chars[l] + "")) l++;
			if (!vowel.contains(chars[r] + "")) r--;
			if (vowel.contains(chars[l] + "") && vowel.contains(chars[r] + "")) {
				char temp = chars[l];
				chars[l] = chars[r];
				chars[r] = temp;
				l++;
				r--;
			}
		}
		return new String(chars);
	}
}
