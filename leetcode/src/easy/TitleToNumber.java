package easy;

import java.util.Locale;

public class TitleToNumber {
	public static void main(String[] args) {
		TitleToNumber titleToNumber = new TitleToNumber();
		System.out.println(titleToNumber.titleToNumber("A"));
		System.out.println(titleToNumber.titleToNumber("AB"));
	}
	public int titleToNumber(String columnTitle) {

		int number = 0;
		int multiple = 1;
		int n =columnTitle.length();
		for (int i = n - 1; i >= 0; i--) {
			number += (columnTitle.charAt(i) - 'A' + 1) * multiple;
			multiple *= 26;
		}
		return number;

	}
}
