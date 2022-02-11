package normal;

import java.util.ArrayList;
import java.util.List;

public class FindSubstringInWraproundString {
	public static void main(String[] args) {
		FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
		System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("avsdfghi"));
		System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("a"));
		System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("cac"));
		System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zab"));
	}


	public int findSubstringInWraproundString(String p) {
		String surroundString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		List<String> subsequences = new ArrayList<>();
		int res=0;
		printAllSub(p.toCharArray(),0,"",subsequences);
		subsequences.remove(0);
		for (String s : subsequences) {
			if (surroundString.contains(s))res++;
		}
		return res;
	}

	private void printAllSub(char[] str, int i, String res,List<String> subsequences) {
		if (i == str.length) {
			if(!subsequences.contains(res))subsequences.add(res);
			return;
		} else {
			printAllSub(str, i + 1, res,subsequences); // 不要下标为i+1的字符
			printAllSub(str, i + 1, res+str[i],subsequences); // 要第i+1个字符
		}
	}

}
