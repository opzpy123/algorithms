package hard;

import java.util.ArrayList;
import java.util.List;

public class LongestPrefix {
	public static void main(String[] args) {
		System.out.println(longestPrefix("level"));
		System.out.println(longestPrefix("leetcodeleet"));
		System.out.println(longestPrefix("ababab"));
		System.out.println(longestPrefix("a"));
	}
	public static String longestPrefix(String s) {
		int l=0,r=s.length()-1;
		StringBuilder prefix =new StringBuilder();
		StringBuilder suffix =new StringBuilder();
		List<String> stringList = new ArrayList<>();
		while (l<s.length()&&r>0){
			prefix.append(s.charAt(l));
			String tempStr = suffix.toString();
			suffix=new StringBuilder();
			suffix.append(s.charAt(r));
			suffix.append(tempStr);
			if(prefix.toString().equals(suffix.toString())){
				stringList.add(prefix.toString());
			}
			l++;
			r--;
		}
		return stringList.size()==0?"":stringList.get(stringList.size()-1);
	}
	public String longestPrefix1(String s){
		int n = s.length();
		long prefix = 0, suffix = 0;
		long base = 31, mod = 1000000007, mul = 1;
		int happy = 0;
		for (int i = 1; i < n; ++i) {
			prefix = (prefix * base + (s.charAt(i - 1) - 'a')) % mod;
			suffix = (suffix + (s.charAt(n - i) - 'a') * mul) % mod;
			if (prefix == suffix) {
				happy = i;
			}
			mul = mul * base % mod;
		}
		return s.substring(0, happy);
	}
}
