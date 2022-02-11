package normal;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trie1 {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

	ArrayList<String> tireWords;
	Set<String> tirePrefix;
	/** Initialize your data structure here. */
	public Trie1() {
		tireWords=new ArrayList<>();
		tirePrefix=new HashSet<>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		tireWords.add(word);
		for (int i = 0; i <= word.length(); i++) {
			tirePrefix.add(word.substring(0,i));
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return tireWords.contains(word);
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		return tirePrefix.contains(prefix);
	}
}
