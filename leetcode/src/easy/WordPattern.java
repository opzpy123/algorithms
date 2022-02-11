package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {
	public static void main(String[] args) {
		WordPattern wordPattern = new WordPattern();
		System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern.wordPattern("abc", "b c a"));
	}

	/**
	 * java+hashMap 这道题说的是对应关系，那首先想到的集合就是Map，
	 * 将key（a）-value（dog）存在一起，每当遇到一个字母就去查看对应的单词。
	 * 失败有两种情况：
	 * 1.key存在，经过查找字母对应的单词和这个单词不匹配；
	 * 2.key不存在，但是这个单词已经被存了；
	 *
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) return false;
		String[] string = str.split(" ");
		if (pattern.length() != string.length) return false;
		HashMap<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {

			char tmp = pattern.charAt(i);

			if (map.containsKey(tmp)) {
				//key存在
				if(!map.get(tmp).equals(string[i])){
					return false;
				}
			}else {
				//key不存在
				if(map.containsValue(string[i])){
					return false;
				}else {
					map.put(pattern.charAt(i),string[i]);
				}
			}
		}
		return true;
	}
}
