package competeTest.week.week6_1;

public class IsSumEqual {
	public static void main(String[] args) {
		System.out.println(isSumEqual("acb", "cba", "cdb"));
		System.out.println(isSumEqual("d", "b", "aaaaae"));
	}
	public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		char[] firstChars = firstWord.toCharArray();
		char[] secondChars = secondWord.toCharArray();
		char[] targetChars = targetWord.toCharArray();
		String a="",b="",c="";
		for (int i = 0; i < firstChars.length; i++) {
			a+=firstChars[i] - 'a'+"";
		}
		for (int i = 0; i < secondChars.length; i++) {
			b+=secondChars[i] - 'a'+"";
		}
		for (int i = 0; i < targetChars.length; i++) {
			c+=targetChars[i] - 'a'+"";
		}
		int fst = Integer.parseInt(a);
		int srd = Integer.parseInt(b);
		int tar = Integer.parseInt(c);
		return fst+srd==tar;

	}
}
