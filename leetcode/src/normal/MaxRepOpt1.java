package normal;

public class MaxRepOpt1 {
	public static void main(String[] args) {
		System.out.println(maxRepOpt1("asdasdaasfxzcxzxzzzzzzzzzzzzzzzzzzzzzsd"));
	}
	public static int maxRepOpt1(String text) {
		int[] table = new int[26];
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			table[chars[i]-'a']++;
		}
		int res=0;
		for (int i = 0; i < 26; i++) {
			res=Math.max(res,table[i]);
		}
		return res;
	}
}
