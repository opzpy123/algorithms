package easy;

public class StrStr {
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
	}
	public static int strStr(String haystack, String needle) {
		if(!haystack.contains(needle)) return -1;
		for (int i = 0; i < haystack.length(); i++) {
			if(haystack.startsWith(needle, i)){
				return i;
			}
		}
		haystack.indexOf(needle);
		return 0;
	}
}
