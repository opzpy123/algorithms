package compete;

public class SubSequence {
	public static void main(String[] args) {
		subs("abcd".toCharArray(),0,"");
	}
	public static void subs(char[] str, int i, String res) {
		if (i == str.length) {
			System.out.println(res);
			return;
		}
		subs(str, i + 1, res);
		subs(str, i + 1, res + str[i]);
	}
}
