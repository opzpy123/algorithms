package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class AreAlmostEqual {
	public static void main(String[] args) {
		AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
		System.out.println(areAlmostEqual.areAlmostEqual("bank", "kanb"));
		System.out.println(areAlmostEqual.areAlmostEqual("attack", "defend"));
		System.out.println(areAlmostEqual.areAlmostEqual("kelb", "kelb"));
		System.out.println(areAlmostEqual.areAlmostEqual("abcd", "dcba"));
		System.out.println(areAlmostEqual.areAlmostEqual("aa", "bb"));

	}

	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.length() == 1 && s2.length() == 1) return false;
		int count = 0;
		int[] table = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			if (count > 2) return false;
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
				table[s1.charAt(i)-'a']++;
				table[s2.charAt(i)-'a']--;
			}
		}
		for (int i = 0; i < table.length; i++) {
			if(table[i]!=0){
				return false;
			}
		}
		return true;
	}
}
