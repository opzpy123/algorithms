package competeTest.week.week3_28;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {
	public static void main(String[] args) {
		NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();
		System.out.println(numDifferentIntegers.numDifferentIntegers("a123bc34d8ef34"));
		System.out.println(numDifferentIntegers.numDifferentIntegers("leet1234code234"));
		System.out.println(numDifferentIntegers.numDifferentIntegers("a1b01c001"));
		System.out.println(numDifferentIntegers.numDifferentIntegers("12312411235125"));
		System.out.println(numDifferentIntegers.numDifferentIntegers("123123124112351231241123512411235125"));
	}

	public int numDifferentIntegers(String word) {
		word = word + "#";
		Set<String> set = new HashSet<>();
		char[] chars = word.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (Character.isDigit(chars[i])) {
				for (int j = i; j < chars.length; j++) {
					if (!Character.isDigit(chars[j])) {
						while (chars[i]=='0'){
							i++;
						}
						String substring = word.substring(i, j);
						set.add(substring);
						i = j;
						j = chars.length;
					}
				}
			}
		}
		return set.size();
	}

}
